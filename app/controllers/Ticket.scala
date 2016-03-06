package controllers

import javax.inject.Inject

import anorm._
import emp.util.Pagination.Page
import emp.util.Search._
import emp.util.Stats
import emp.JsonFormats._
import org.joda.time.DateTime
import play.api._
import play.api.data._
import play.api.data.Forms._
import play.api.i18n.{I18nSupport,Messages,MessagesApi}
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.json.Json._
import emp.util.Search._
import models._
import models.DefaultAssignee._
import models.TicketModel._
import org.joda.time.DateTime
import scala.math._

class Ticket @Inject() (val messagesApi: MessagesApi) extends Controller with I18nSupport with Secured {

  val linkForm = Form(
    mapping(
      "link_type_id"-> longNumber,
      "ticket" -> play.api.data.Forms.list(nonEmptyText),
      "comment" -> optional(text)
    )(models.MakeLink.apply)(models.MakeLink.unapply)
  )

  val assignForm = Form(
    mapping(
      "user_id" -> optional(longNumber),
      "comment" -> optional(text)
    )(models.Assignment.apply)(models.Assignment.unapply)
  )

  val ticketForm = Form(
    mapping(
      "projectId"  -> longNumber,
      "typeId"     -> longNumber,
      "priorityId" -> longNumber,
      "severityId" -> longNumber,
      "summary"     -> nonEmptyText,
      "description" -> optional(text),
      "assigneeId" -> optional(longNumber),
      "position"    -> optional(longNumber)
    )(models.NewTicket.apply)(models.NewTicket.unapply)
  )

  val ticketDataForm = Form(
    mapping(
      "id"         -> ignored(NotAssigned:Pk[Long]),
      "ticketId"   -> ignored(0L),
      "userId"     -> longNumber,
      "priorityId" -> longNumber,
      "resolutionId" -> optional(longNumber),
      "assigneeId" -> optional(longNumber),
      "attentionId" -> optional(longNumber),
      "severityId" -> longNumber,
      "statusId"   -> ignored(0L),
      "typeId"     -> longNumber,
      "position"    -> optional(longNumber),
      "summary"     -> nonEmptyText,
      "description" -> optional(text),
      "dateCreated" -> ignored[DateTime](new DateTime())
    )(models.TicketData.apply)(models.TicketData.unapply)
  )

  /**
   * Display a form for creating a ticket.
   * If we received a projectId then we will default the form to the appropriate
   * settings for the provided project.
   */
  def create(projectId: Option[Long]) = IsAuthenticated() { implicit request =>

    // Should be i18ned in the view
    val projs = ProjectModel.getAll
    val ttypes = Json.toJson(TicketTypeModel.getAll).toString
    val prios = Json.toJson(TicketPriorityModel.getAll).toString
    val sevs = Json.toJson(TicketSeverityModel.getAll).toString

    // The worst case scenario, just the user id
    val startTicket = models.NewTicket(
      projectId = 0,
      priorityId = 0,
      severityId = 0,
      typeId = 0,
      summary = "",
      description = None
    )

    val maybeProject: Option[models.Project] = if(projectId.isDefined) {
      ProjectModel.getById(projectId.get)
    } else if(projs.length == 1) {
      // If they've only got one project return that to save some trouble
      Some(projs(0))
    } else {
      None
    }

    val assignees = Json.toJson(UserModel.getAssignable()).toString

    val pj: String = maybeProject.map({ p => Json.toJson(p).toString }).getOrElse("{}")

    Ok(views.html.ticket.create(ticketForm, assignees, Json.toJson(projs).toString, ttypes, prios, sevs, pj))
  }

  def edit(ticketId: String) = IsAuthenticated() { implicit request =>

    TicketModel.getByStringId(ticketId).map({ ticket =>
      val data = TicketModel.getDataById(ticket.id.get)
      val projs = ProjectModel.getAll.map { x => (x.id.get.toString -> Messages(x.name)) }
      val ttypes = TicketTypeModel.getAll.map { x => (x.id.get.toString -> Messages(x.name)) }
      val prios = TicketPriorityModel.getAll.map { x => (x.id.get.toString -> Messages(x.name)) }
      val sevs = TicketSeverityModel.getAll.map { x => (x.id.get.toString -> Messages(x.name)) }
      val assignees = UserModel.getAssignable().map { x => (x.id.getOrElse("").toString -> x.realName) }
      val users = UserModel.getAssignable(includeNobody = false).map { x => (x.id.getOrElse("").toString -> x.realName) }
      Ok(views.html.ticket.edit(ticketId, ticketDataForm.fill(data.get), users, assignees, assignees, projs, ttypes, prios, sevs))
    }).getOrElse(NotFound((views.html.error.missing())))
  }

  def item(tab: String = "comments", ticketId: String, page: Int = 1, count: Int= 10, query: String = "*") = IsAuthenticated() { implicit request =>

    TicketModel.getFullByStringId(ticketId).map({ ticket =>

      val assignees = UserModel.getAssignable().map { user => (user.id.getOrElse("").toString -> user.realName) }
      Stats.addEvent("viewedTickets", Map("ticketId" -> ticketId))
      Ok(views.html.ticket.item(
        ticket = ticket,
        ticketJson = Json.toJson(ticket),
        assignees = assignees,
        assignForm = assignForm.fill(Assignment(ticket.assignee.id, None))
      ))
    }).getOrElse(NotFound(views.html.error.missing()))
  }

  def update(ticketId: String) = IsAuthenticated() { implicit request =>

    TicketModel.getByStringId(ticketId).map({ ticket =>

      ticketDataForm.bindFromRequest.fold(
        errors => {
          val projs = ProjectModel.getAll.map { x => (x.id.get.toString -> Messages(x.name)) }
          val ttypes = TicketTypeModel.getAll.map { x => (x.id.get.toString -> Messages(x.name)) }
          val prios = TicketPriorityModel.getAll.map { x => (x.id.get.toString -> Messages(x.name)) }
          val sevs = TicketSeverityModel.getAll.map { x => (x.id.get.toString -> Messages(x.name)) }
          val assignees = UserModel.getAssignable().map { user => (user.id.getOrElse("").toString -> user.realName) }

          BadRequest(views.html.ticket.edit(ticketId, errors, assignees, assignees, assignees, projs, ttypes, prios, sevs))
        },
        value => {
          TicketModel.update(request.user.id.get, ticket.id.get, value)
          Redirect(routes.Ticket.item("comments", ticketId)).flashing("success" -> "ticket.edit.success")
        }
      )
    }).getOrElse(NotFound(views.html.error.missing()))
  }
}
