package controllers.api

import javax.inject.Inject

import anorm.{NotAssigned,Pk}
import controllers._
import emp.event._
import emp.util.Search._
import emp.util.Stats
import emp.JsonFormats._
import models._
import org.joda.time.DateTime
import play.api.i18n.{I18nSupport,Messages,MessagesApi}
import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.mvc._
import scala.math.abs

class Ticket @Inject() (val messagesApi: MessagesApi, val eventBus: EmperorEventBus) extends Controller with I18nSupport with Secured {

  val emptyObj = __.json.put(Json.obj())

  val validateAssign: Reads[JsObject] = (
    (__ \ 'userId).json.pickBranch and
    ((__ \ 'comment).json.pickBranch orElse emptyObj)
  ).reduce

  val validateComment: Reads[JsObject] = (
    (__ \ 'content).json.pickBranch
  )

  val validateLink: Reads[JsObject] = (
    (__ \ 'linkTypeId).json.pickBranch and
    (__ \ 'childTicketId).json.pickBranch
  ).reduce

  val validateResolution: Reads[JsObject] = (
    (__ \ 'resolutionId).json.pickBranch and
    ((__ \ 'comment).json.pickBranch orElse emptyObj)
  ).reduce

  val validateUnresolution: Reads[JsObject] = (
    ((__ \ 'comment).json.pickBranch orElse emptyObj)
  )

  val validateStatus: Reads[JsObject] = (
    (__ \ 'statusId).json.pickBranch and
    ((__ \ 'comment).json.pickBranch orElse emptyObj)
  ).reduce

  val validateTicket: Reads[JsObject] = (
    (__ \ 'typeId).json.pickBranch and
    (__ \ 'priorityId).json.pickBranch and
    (__ \ 'severityId).json.pickBranch and
    (__ \ 'summary).json.pickBranch and
    ((__ \ 'description).json.pickBranch orElse emptyObj) and
    ((__ \ 'assigneeId).json.pickBranch orElse emptyObj) and
    ((__ \ 'position).json.pickBranch orElse emptyObj)
  ).reduce

  def assign(ticketId: String, callback: Option[String]) = IsAuthenticated() { implicit request =>

    TicketModel.getFullByStringId(ticketId).map({ ticket =>

      request.body.asJson.map({ json =>
        json.transform(validateAssign).map({ jsObj =>

          val rt = TicketModel.assign(
            ticketId = ticket.id.get, userId = request.user.id.get,
            assigneeId = (jsObj \ "userId").asOpt[Long],
            comment = (jsObj \ "comment").asOpt[String]
          )
          Stats.addEvent("ticketsAssigned", Map("ticketId" -> ticketId))
          Ok(Json.toJson(rt))
        }).recoverTotal({
          e => BadRequest(Json.obj("status" -> "KO", "message" -> JsError.toFlatJson(e)))
        })
      }).getOrElse(
        BadRequest(Json.obj("status" -> "KO", "message" -> "Expecting Json data"))
      )
    }).getOrElse(NotFound(Json.obj("status" -> "KO", "message" -> "api.unknown.entity")))
  }

  def comment(ticketId: String, `type`: Option[String] = Some("comment"), callback: Option[String]) = IsAuthenticated() { implicit request =>

    TicketModel.getFullByStringId(ticketId).map({ ticket =>

      val commFilters = Map(
        "ticket_id" -> Seq(ticket.id.get.toString),
        "type"      -> Seq(`type`.get)
      )

      val q = SearchQuery(
        query = "*",
        page = 1,
        count = 99999, filters = commFilters,
        sortBy = Some("dateCreated"), sortOrder = Some("asc")
      )
      val results = SearchModel.searchComment(q)
      val json = Json.obj(
        "pager" -> Json.obj(
          "items" -> Json.toJson(results.pager.items),
          "page" -> results.pager.page,
          "requestedPage" -> results.pager.requestedPage,
          "range" -> results.pager.range,
          "window" -> results.pager.getWindow(10),
          "count" -> results.pager.count,
          "total" -> results.pager.total,
          "next"  -> results.pager.next,
          "prev"  -> results.pager.prev,
          "offset"-> results.pager.offset
        ),
        "facets" -> results.facets.map(fs => Json.obj(
          "name" -> fs.name,
          "nameI18N" -> Messages(fs.name),
          "items" -> fs.items.map(f => Json.obj(
            "value" -> f.value,
            "valueI18N" -> Messages(f.value),
            "count" -> f.count
          ))
        ))
      )

      Ok(json)
    }).getOrElse(
      NotFound(Json.obj("status" -> "KO", "message" -> "api.unknown.entity"))
    )
  }

  def addComment(ticketId: String, callback: Option[String]) = IsAuthenticated() { implicit request =>

    TicketModel.getFullByStringId(ticketId).map({ ticket =>

      request.body.asJson.map({ json =>
        json.transform(validateComment).map({ jsObj =>

          TicketModel.addComment(
            ticketId = ticket.id.get, ctype = "comment", userId = request.user.id.get,
            content = (jsObj \ "content").as[String]
          ).map({ comm =>
            eventBus.publish(
              CommentTicketEvent(
                ticketId = ticket.id.get,
                commentId = comm.id.get
              )
            )
            Stats.addEvent("ticketsCommented", Map("ticketId" -> ticketId))
            Ok(Json.toJson(comm))
          }).getOrElse(BadRequest(Json.obj("status" -> "KO", "message" -> "api.operation.failed")))
        }).recoverTotal({
          e => BadRequest(Json.obj("status" -> "KO", "message" -> JsError.toFlatJson(e)))
        })
      }).getOrElse({
        BadRequest(Json.obj("status" -> "KO", "message" -> "Expecting Json data"))
      })
    }).getOrElse(NotFound(Json.obj("status" -> "KO", "message" -> "api.unknown.entity")))
  }

  def changeStatus(ticketId: String, callback: Option[String]) = IsAuthenticated() { implicit request =>

    TicketModel.getFullByStringId(ticketId).map({ ticket =>

      val wf = WorkflowModel.getForTicket(ticket.id.get).get;

      request.body.asJson.map({ json =>
        json.transform(validateStatus).map({ jsObj =>
          val statusId = (jsObj \ "statusId").as[Long]
          if(WorkflowModel.verifyStatusInWorkflow(wf.id.get, statusId)) {
            TicketModel.changeStatus(
              ticketId = ticket.id.get, userId = request.user.id.get,
              newStatusId = statusId, comment = (jsObj \ "comment").asOpt[String]
            )
            Stats.addEvent("ticketsStatused", Map("ticketId" -> ticketId))
            Ok(Json.toJson(TicketModel.getFullByStringId(ticketId).get))
          } else {
            BadRequest(Json.obj("status" -> "KO", "message" -> "api.ticket.workflow.bad_status"))
          }
        }).recoverTotal({
          e => BadRequest(Json.obj("status" -> "KO", "message" -> JsError.toFlatJson(e)))
        })
      }).getOrElse({
        BadRequest(Json.obj("status" -> "KO", "message" -> "Expecting JSON data"))
      })
    }).getOrElse(NotFound(Json.obj("status" -> "KO", "message" -> "api.unknown.entity")))
  }

  def create(projectId: Long, callback: Option[String]) = IsAuthenticated() { implicit request =>

    request.body.asJson.map({ json =>
      json.transform(validateTicket).map({ jsObj =>
        TicketModel.create(
          userId = request.user.id.get,
          projectId = projectId,
          typeId = (jsObj \ "typeId").as[Long],
          priorityId = (jsObj \ "priorityId").as[Long],
          severityId = (jsObj \ "severityId").as[Long],
          summary = (jsObj \ "summary").as[String],
          description = (jsObj \ "description").asOpt[String],
          assigneeId = (jsObj \ "assigneeId").asOpt[Long],
          position = (jsObj \ "position").asOpt[Long]
        ).fold(
          error => {
            BadRequest(Json.obj("status" -> "KO", "message" -> Messages(error)))
          },
          ticket => {
            Stats.addEvent("ticketsCreated", Map("projectId" -> projectId.toString))
            Ok(Json.toJson(ticket))
          }
        )
      }).recoverTotal({
        e => BadRequest(Json.obj("status" -> "KO", "message" -> JsError.toFlatJson(e)))
      })
    }).getOrElse({
      BadRequest(Json.obj("status" -> "KO", "message" -> "Expecting Json data"))
    })
  }

  def item(ticketId: String, callback: Option[String]) = IsAuthenticated() { implicit request =>

    TicketModel.getFullByStringId(ticketId).map({
      ticket => Ok(Json.toJson(ticket))
    }).getOrElse(
      NotFound(Json.obj("status" -> "KO", "message" -> "api.unknown.entity"))
    )
  }

  def deleteComment(ticketId: String, id: Long, callback: Option[String]) = IsAuthenticated() { implicit request =>

    TicketModel.getFullByStringId(ticketId).map({ ticket =>
      TicketModel.getCommentById(id).map({ comm =>

        val canDelete = if(comm.userId == request.user.id.get) {
          // You can delete it if it's yours…
          true

        } else if(request.user.admin == true) {
          // Or if you are an admin…
          true
        } else {
          // Otherwise, no
          false
        }
        if(canDelete) {
          TicketModel.deleteComment(id)
          Ok(Json.obj("status" -> "OK"))
        } else {
          Unauthorized(Json.toJson(Map("status" -> "KO", "message" -> "api.permission.denied")))
        }
      }).getOrElse(NotFound(Json.obj("status" -> "KO", "message" -> "api.unknown.entity")))
    }).getOrElse(NotFound(Json.obj("status" -> "KO", "message" -> "api.unknown.entity")))
  }

  def deleteLink(ticketId: String, id: Long, callback: Option[String]) = IsAuthenticated() { implicit request =>

    val (tProj, tId) = TicketModel.parseTicketId(ticketId).get

    TicketModel.getLinkById(id).map({ link =>
      if(link.parentId == tId || link.childId == tId) {
        link
      } else {
        None
      }
    }).map({ link =>
      TicketModel.removeLink(id)
      Stats.addEvent("ticketsLinksDeleted", Map("ticketId" -> ticketId))
      Ok(Json.obj("status" -> "OK"))
    }).getOrElse(NotFound(Json.obj("status" -> "KO", "message" -> "api.unknown.entity")))
  }

  def link(ticketId: String, callback: Option[String]) = IsAuthenticated() { implicit request =>

    request.body.asJson.map({ json =>
      json.transform(validateLink).map({ jsObj =>
        val typeId = (json \ "linkTypeId").as[Long]
        val childId = (jsObj \ "childTicketId").as[String]

        val maybeLink: Either[String,Option[models.Link]] = if(childId == ticketId) {
          Left("Can't link ticket to itself.")
        } else {

          val parent = TicketModel.getByStringId(ticketId)
          val child = TicketModel.getByStringId(childId)

          if(parent.isDefined && child.isDefined) {
            val link = TicketModel.link(
              linkTypeId = typeId, parentId = parent.get.id.get, childId = child.get.id.get
            )
            link.map({ l =>
              eventBus.publish(
                UnlinkTicketEvent(
                  parentId = l.parentId,
                  childId = l.childId
                )
              )
            })
            Right(link)

          } else {
            Left("Unknown ticket id.")
          }
        }

        maybeLink match {
          case Left(message) => BadRequest(Json.obj("status" -> "KO", "message" -> message))
          case Right(link) => link match {
            case Some(l) => {
              eventBus.publish(
                LinkTicketEvent(
                  groupId = l.linkGroup,
                  parentId = l.parentId,
                  childId = l.childId
                )
              )
              Stats.addEvent("ticketsLinksCreated", Map("ticketId" -> ticketId))
              Ok(Json.toJson(l))
            }
            case None => InternalServerError(Json.obj("status" -> "KO", "message" -> "Error occurred creating link."))
          }
        }
      }).recoverTotal({
        e => BadRequest(Json.obj("status" -> "KO", "message" -> JsError.toFlatJson(e)))
      })
    }).getOrElse({
      BadRequest(Json.obj("status" -> "KO", "message" -> "Expecting Json data"))
    })
  }

  def links(ticketId: String, callback: Option[String]) = IsAuthenticated() { implicit request =>

    TicketModel.getByStringId(ticketId).map({ ticket =>

      // XXX Need to put the actual tickets in here, at least the Edit ticket
      Ok(Json.toJson(TicketModel.getLinks(ticket.id.get)))
    }).getOrElse(NotFound(Json.obj("status" -> "KO", "message" -> "api.unknown.entity")))
  }

  def resolve(ticketId: String, callback: Option[String]) = IsAuthenticated() { implicit request =>

    TicketModel.getFullByStringId(ticketId).map({ ticket =>

      val wf = WorkflowModel.getForTicket(ticket.id.get).get;

      request.body.asJson.map({ json =>
        json.transform(validateResolution).map({ jsObj =>
          val resId = (jsObj \ "resolutionId").as[Long]
          TicketModel.resolve(
            ticketId = ticket.id.get, userId = request.user.id.get,
            resolutionId = resId, comment = (jsObj \ "comment").asOpt[String]
          )
          val json = Json.toJson(TicketModel.getFullByStringId(ticketId).get)
          Stats.addEvent("ticketsResolved", Map("ticketId" -> ticketId))
          Ok(json)
        }).recoverTotal({
          e => BadRequest(Json.obj("status" -> "KO", "message" -> JsError.toFlatJson(e)))
        })
      }).getOrElse({
        BadRequest(Json.obj("status" -> "KO", "message" -> "Expecting JSON data"))
      })
    }).getOrElse(NotFound(Json.obj("status" -> "KO", "message" -> "api.unknown.entity")))
  }

  def unresolve(ticketId: String, callback: Option[String]) = IsAuthenticated() { implicit request =>

    TicketModel.getFullByStringId(ticketId).map({ ticket =>

      val wf = WorkflowModel.getForTicket(ticket.id.get).get;

      request.body.asJson.map({ json =>
        json.transform(validateUnresolution).map({ jsObj =>
          TicketModel.unresolve(
            ticketId = ticket.id.get, userId = request.user.id.get,
            comment = (jsObj \ "comment").asOpt[String]
          )
          Stats.addEvent("ticketsUnresolved", Map("ticketId" -> ticketId))
          Ok(Json.toJson(TicketModel.getFullByStringId(ticketId).get))
        }).recoverTotal({
          e => BadRequest(Json.obj("status" -> "KO", "message" -> JsError.toFlatJson(e)))
        })
      }).getOrElse({
        BadRequest(Json.obj("status" -> "KO", "message" -> "Expecting JSON data"))
      })
    }).getOrElse(NotFound(Json.obj("status" -> "KO", "message" -> "api.unknown.entity")))
  }
}
