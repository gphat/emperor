package emp

import anorm.{Id,NotAssigned}
import emp.event._
import emp.text.Renderer
import emp.util.Search._
import models._
import org.apache.commons.codec.digest.DigestUtils
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.DateTime
import play.api.i18n.Messages
import play.api.libs.json.Json._
import play.api.libs.json._

/**
 * Code for converting Emperor entities into JSON.
 */
object JsonFormats {

  val dateFormatter = DateTimeFormat.forPattern("yyyyMMdd'T'HHmmss'Z'")
  val dateFormatterUTC = DateTimeFormat.forPattern("yyyyMMdd'T'HHmmss'Z'").withZoneUTC()

  private def optionLongtoJsValue(maybeId: Option[Long]) = maybeId.map({ l => JsNumber(l) }).getOrElse(JsNull)

  private def optionI18nStringtoJsValue(maybeId: Option[String])(implicit messages: Messages) = maybeId.map({ s => JsString(Messages(s)) }).getOrElse(JsNull)
  private def optionStringtoJsValue(maybeId: Option[String])(implicit messages: Messages) = maybeId.map({ s => JsString(s) }).getOrElse(JsNull)

  /**
   * JSON conversion for Comment
   */
  implicit object CommentFormat extends Format[Comment] {
    def reads(json: JsValue): JsResult[Comment] = {
      val userId = (json \ "userId").as[Long]
      val user = UserModel.getById(userId)

      JsSuccess(Comment(
        id = Id((json \ "id").as[Long]),
        ctype = (json \ "type").as[String],
        userId = userId,
        username = user.map({ u => u.username }).getOrElse(""),
        realName = user.map({ u => u.realName }).getOrElse(""),
        emailDigest = user.map({ u => DigestUtils.md5Hex(u.username.trim.toLowerCase) }).getOrElse(""),
        ticketId = (json \ "ticketId").as[Long],
        content = (json \ "content").as[String],
        dateCreated = (json \ "dateCreated").asOpt[String].map({ d => dateFormatterUTC.parseDateTime(d) }).getOrElse(new DateTime())
      ))
    }

    def writes(comment: Comment): JsValue = {
      val cdoc: Map[String,JsValue] = Map(
        "id"            -> JsNumber(comment.id.get),
        "type"          -> JsString(comment.ctype),
        "ticketId"      -> JsNumber(comment.ticketId),
        "userId"        -> JsNumber(comment.userId),
        "userName"      -> JsString(comment.username),
        "userRealName"  -> JsString(comment.realName),
        "userEmailDigest" -> JsString(DigestUtils.md5Hex(comment.username.trim.toLowerCase)),
        "content"       -> JsString(
          // Stop double-encoding markdown!
          if(comment.content.contains("<p>")) {
            comment.content
          } else {
            Renderer.render(Some(comment.content))
          }
        ),
        "dateCreated"   -> JsString(dateFormatter.print(comment.dateCreated))
      )
      toJson(cdoc)
    }
  }

  /**
   * JSON conversion for Event
   */
  implicit object EventFormat extends Format[Event] {
    def reads(json: JsValue): JsResult[Event] = {
      val userId = (json \ "userId").as[Long]
      val user = UserModel.getById(userId)

      JsSuccess(Event(
        id = (json \ "id").as[String],
        projectId = (json \ "projectId").as[Long],
        projectName = (json \ "projectName").as[String],
        userId = userId,
        userRealName = user.map({ u => u.realName }).getOrElse(""),
        username = user.map({ u => u.username }).getOrElse(""),
        userEmailDigest = user.map({ u => DigestUtils.md5Hex(u.username.trim.toLowerCase) }).getOrElse(""),
        eKey = (json \ "ekey").as[String],
        eType = (json \ "etype").as[String],
        content = (json \ "content").as[String],
        url = (json \ "url").as[String],
        dateCreated = (json \ "dateCreated").asOpt[String].map({ d => dateFormatterUTC.parseDateTime(d) }).getOrElse(new DateTime())
      ))
    }

    def writes(event: Event): JsValue = {
      val edoc: Map[String,JsValue] = Map(
        "id"            -> JsString(event.id),
        "projectId"     -> JsNumber(event.projectId),
        "projectName"   -> JsString(event.projectName),
        "userId"        -> JsNumber(event.userId),
        "userRealname"  -> JsString(event.userRealName),
        "username"      -> JsString(event.username),
        "userEmailDigest" -> JsString(DigestUtils.md5Hex(event.username.trim.toLowerCase)),
        "ekey"          -> JsString(event.eKey),
        "etype"         -> JsString(event.eType),
        "etypeI18N"     -> JsString(Messages(event.eType)),
        "content"       -> JsString(event.content),
        "url"           -> JsString(event.url),
        "dateCreated"   -> JsString(dateFormatter.print(event.dateCreated))
      )
      toJson(edoc)
    }
  }

  /**
   * JSON conversion for FullLink
   */
  implicit object FullLinkFormat extends Format[FullLink] {

    def reads(json: JsValue): JsResult[FullLink] = JsSuccess(FullLink(
      id          = Id((json \ "id").as[Long]),
      linkGroup   = (json \ "linkGroup").as[Long],
      typeId      = (json \ "typeId").as[Long],
      typeName    = (json \ "typeName").as[String],
      parentId    = (json \ "parentId").as[Long],
      parentTicketId = (json \ "parentTicketId").as[String],
      parentResolutionId = (json \ "parentResolutionId").asOpt[Long],
      parentSummary = (json \ "parentSummary").as[String],
      childId     = (json \ "childId").as[Long],
      childTicketId = (json \ "childTicketId").as[String],
      childResolutionId = (json \ "childResolutionId").asOpt[Long],
      childSummary = (json \ "childSummary").as[String],
      dateCreated = (json \ "dateCreated").asOpt[String].map({ d => dateFormatterUTC.parseDateTime(d) }).getOrElse(new DateTime())
    ))

    def writes(l: FullLink)(implicit messages: Messages): JsValue = {

      val childRes = l.childResolutionId match {
        case Some(reso) => JsNumber(reso)
        case None => JsNull
      }

      val parentRes = l.parentResolutionId match {
        case Some(reso) => JsNumber(reso)
        case None => JsNull
      }

      val ldoc: Map[String,JsValue] = Map(
        "id"              -> JsNumber(l.id.get),
        "linkGroup"       -> JsNumber(l.linkGroup),
        "typeId"          -> JsNumber(l.typeId),
        "typeName"        -> JsString(l.typeName),
        "typeNameI18N"    -> JsString(Messages(l.typeName)),
        "parentId"        -> JsNumber(l.parentId),
        "parentTicketId"  -> JsString(l.parentTicketId),
        "parentResolutionId" -> parentRes,
        "parentSummary"   -> JsString(l.parentSummary),
        "childId"         -> JsNumber(l.childId),
        "childTicketId"   -> JsString(l.childTicketId),
        "childResolutionId" -> childRes,
        "childSummary"    -> JsString(l.childSummary),
        "dateCreated"     -> JsString(dateFormatter.print(l.dateCreated))
      )
      toJson(ldoc)
    }
  }

  /**
   * JSON conversion for FullTicket
   */
  implicit object FullTicketFormat extends Format[FullTicket] {

    def reads(json: JsValue): JsResult[FullTicket] = {
      val userId = (json \ "userId").as[Long]
      val user = UserModel.getById(userId)
      val assigneeId = (json \ "assigneeId").asOpt[Long]
      val assignee = assigneeId.map({ aid => UserModel.getById(aid) }).getOrElse(None)
      val attentionId = (json \ "attentionId").asOpt[Long]
      val attention = attentionId.map({ aid => UserModel.getById(aid )}).getOrElse(None)

      JsSuccess(FullTicket(
        id        = Id((json \ "id").as[Long]),
        dataId    = (json \ "dataId").as[Long],
        ticketId  = (json \ "ticketId").as[String],
        projectTicketId = (json \ "projectTicketId").as[Long],
        user      = NamedThing(
          id    = userId,
          name  = user.map({ u => u.realName }).getOrElse("")
        ),
        assignee = OptionalNamedThing(
          id    = assigneeId.map({ aid => Some(aid) }).getOrElse(Some(0L)),
          name  = assignee.map({ a => Some(a.realName) }).getOrElse(None)
        ),
        attention = OptionalNamedThing(
          id    = attentionId,
          name  = attention.map({ a => Some(a.realName) }).getOrElse(None)
        ),
        project  = NamedKeyedThing(
          id    = (json \ "projectId").as[Long],
          name  = (json \ "projectName").as[String],
          key   = (json \ "projectKey").as[String]
        ),
        priority  = ColoredPositionedThing(
          id    = (json \ "priorityId").as[Long],
          name  = (json \ "priorityName").as[String],
          color = (json \ "priorityColor").as[String],
          position = (json \ "priorityPosition").as[Int]
        ),
        resolution = OptionalNamedThing(
          id    = (json \ "resolutionId").asOpt[Long],
          name  = (json \ "resolutionName").asOpt[String]
        ),
        severity  = ColoredPositionedThing(
          id    = (json \ "severityId").as[Long],
          name  = (json \ "severityName").as[String],
          color = (json \ "severityColor").as[String],
          position = (json \ "severityPosition").as[Int]
        ),
        workflowStatusId = (json \ "workflowStatusId").as[Long],
        workflowPosition = (json \ "workflowPosition").as[Int],
        status  = NamedThing(
          id    = (json \ "statusId").as[Long],
          name  = (json \ "statusName").as[String]
        ),
        ttype  = ColoredThing(
          id    = (json \ "typeId").as[Long],
          name  = (json \ "typeName").as[String],
          color = (json \ "typeColor").as[String]
        ),
        position = (json \ "position").asOpt[Long],
        summary = (json \ "summary").as[String],
        description = (json \ "description").asOpt[String],
        dateCreated = (json \ "dateCreated").asOpt[String].map({ d => dateFormatterUTC.parseDateTime(d) }).getOrElse(new DateTime()),
        dateChanged = (json \ "dateChanged").asOpt[String].map({ d => dateFormatterUTC.parseDateTime(d) }).getOrElse(new DateTime())
      ))
    }

    def writes(ticket: FullTicket)(implicit messages: Messages): JsValue = {

      val links = TicketModel.getLinks(ticket.id.get).groupBy(_.typeName)

      val tdoc: Map[String,JsValue] = Map(
        "id"              -> JsNumber(ticket.id.get),
        "dataId"         -> JsNumber(ticket.dataId),
        "daysOpen"       -> JsNumber(ticket.daysOpen),
        "daysSinceLastChange" -> JsNumber(ticket.daysSinceLastChange),
        "ticketId"       -> JsString(ticket.ticketId),
        "projectTicketId" -> JsNumber(ticket.projectTicketId),
        "projectId"      -> JsNumber(ticket.project.id),
        "projectKey"     -> JsString(ticket.project.key),
        "projectName"    -> JsString(ticket.project.name),
        "priorityId"     -> JsNumber(ticket.priority.id),
        "priorityName"   -> JsString(ticket.priority.name),
        "priorityNameI18N" -> JsString(Messages(ticket.priority.name)),
        "priorityColor"  -> JsString(ticket.priority.color),
        "priorityPosition" -> JsNumber(ticket.priority.position),
        "resolutionId"   -> optionLongtoJsValue(ticket.resolution.id),
        // A ticket with no resolution gets a default name, hence the differing logic here
        "resolutionName" -> JsString(ticket.resolution.name.getOrElse("TICK_RESO_UNRESOLVED")),
        "resolutionNameI18N" -> JsString(Messages(ticket.resolution.name.getOrElse("TICK_RESO_UNRESOLVED"))),
        "assigneeId"     -> ticket.assignee.id.map({ l => JsNumber(l) }).getOrElse(JsNumber(0L)),
        "assigneeName"   -> optionStringtoJsValue(ticket.assignee.name),
        "attentionId"    -> optionLongtoJsValue(ticket.attention.id),
        "attentionName"  -> optionStringtoJsValue(ticket.attention.name),
        "severityId"     -> JsNumber(ticket.severity.id),
        "severityColor"  -> JsString(ticket.severity.color),
        "severityName"   -> JsString(ticket.severity.name),
        "severityNameI18N" -> JsString(Messages(ticket.severity.name)),
        "severityPosition" -> JsNumber(ticket.severity.position),
        "statusId"       -> JsNumber(ticket.status.id),
        "statusName"     -> JsString(ticket.status.name),
        "statusNameI18N"-> JsString(Messages(ticket.status.name)),
        "typeId"         -> JsNumber(ticket.ttype.id),
        "typeColor"      -> JsString(ticket.ttype.color),
        "typeName"       -> JsString(ticket.ttype.name),
        "typeNameI18N"   -> JsString(Messages(ticket.ttype.name)),
        "userId"         -> JsNumber(ticket.user.id),
        "userName"       -> JsString(ticket.user.name),
        "summary"        -> JsString(ticket.summary),
        "shortSummary"   -> JsString(ticket.abbreviatedSummary()),
        "workflowId"     -> optionLongtoJsValue(WorkflowModel.getForTicket(ticket.id.get).map({ wf => wf.id.get })),
        "workflowStatusId" -> JsNumber(ticket.workflowStatusId),
        "workflowPosition" -> JsNumber(ticket.workflowPosition),
        "description"    -> JsString(Renderer.render(ticket.description)),
        "dateCreated"    -> JsString(dateFormatter.print(ticket.dateCreated)),
        "dateChanged"    -> JsString(dateFormatter.print(ticket.dateChanged)),
        "blocks" -> Json.toJson(links.get("TICK_LINK_BLOCKS").map(ls => ls.map(l =>
          l.childTicketId
        )).getOrElse(Seq())),
        "isBlockedBy" -> Json.toJson(links.get("TICK_LINK_BLOCKED_BY").map(ls => ls.map(l =>
          l.childTicketId
        )).getOrElse(Seq())),
        "contains" -> Json.toJson(links.get("TICK_LINK_CONTAINS").map(ls => ls.map(l =>
          l.childTicketId
        )).getOrElse(Seq())),
        "isContainedIn" -> Json.toJson(links.get("TICK_LINK_CONTAINED_IN").map(ls => ls.map(l =>
          l.childTicketId
        )).getOrElse(Seq())),
        "isRelated" -> Json.toJson(links.get("TICK_LINK_RELATED").map(ls => ls.map(l =>
          l.childTicketId
        )).getOrElse(Seq())),
        "relations" -> Json.toJson(links.keys)
      )
      toJson(tdoc)
    }
  }

  /**
   * JSON conversion for Link
   */
  implicit object LinkFormat extends Format[Link] {

    def reads(json: JsValue): JsResult[Link] = JsSuccess(Link(
      id          = Id((json \ "id").as[Long]),
      linkGroup   = (json \ "linkGroup").as[Long],
      typeId      = (json \ "typeId").as[Long],
      typeName    = (json \ "name").as[String],
      parentId    = (json \ "parentId").as[Long],
      childId     = (json \ "childId").as[Long],
      dateCreated = (json \ "dateCreated").asOpt[String].map({ d => dateFormatterUTC.parseDateTime(d) }).getOrElse(new DateTime())
    ))

    def writes(l: Link)(implicit messages: Messages): JsValue = {

      val ldoc: Map[String,JsValue] = Map(
        "id"             -> JsNumber(l.id.get),
        "linkGroup"      -> JsNumber(l.linkGroup),
        "typeId"         -> JsNumber(l.typeId),
        "name"           -> JsString(l.typeName),
        "nameI18N"       -> JsString(Messages(l.typeName)),
        "parentId"       -> JsNumber(l.parentId),
        "childId"        -> JsNumber(l.childId),
        "dateCreated"    -> JsString(dateFormatter.print(l.dateCreated))
      )
      toJson(ldoc)
    }
  }

  /**
   * JSON conversion for Project
   */
  implicit object ProjectFormat extends Format[Project] {

    def reads(json: JsValue): JsResult[Project] = JsSuccess(Project(
      id          = Id((json \ "id").as[Long]),
      workflowId  = (json \ "workflowId").as[Long],
      name        = (json \ "name").as[String],
      key         = (json \ "key").as[String],
      ownerId     = (json \ "ownerId").asOpt[Long],
      defaultPriorityId = (json \ "defaultPriorityId").asOpt[Long],
      defaultSeverityId = (json \ "defaultSeverityId").asOpt[Long],
      defaultTypeId = (json \ "defaultTypeId").asOpt[Long],
      defaultAssignee = (json \ "defaultAssignee").asOpt[Int],
      dateCreated = (json \ "dateCreated").asOpt[String].map({ d => dateFormatterUTC.parseDateTime(d) }).getOrElse(new DateTime())
    ))

    def writes(obj: Project): JsValue = {

      val owner = obj.ownerId match {
        case Some(id) => JsNumber(id)
        case None     => JsNull
      }

      val prio = obj.defaultPriorityId match {
        case Some(id) => JsNumber(id)
        case None     => JsNull
      }

      val sev = obj.defaultSeverityId match {
        case Some(id) => JsNumber(id)
        case None     => JsNull
      }

      val ttype = obj.defaultTypeId match {
        case Some(id) => JsNumber(id)
        case None     => JsNull
      }

      val defAssign = obj.defaultAssignee match {
        case Some(id) => JsNumber(id)
        case None     => JsNull
      }

      val doc: Map[String,JsValue] = Map(
        "id"             -> JsNumber(obj.id.get),
        "workflowId"     -> JsNumber(obj.workflowId),
        "name"           -> JsString(obj.name),
        "key"            -> JsString(obj.key),
        "ownerId"        -> owner,
        "defaultPriorityId" -> prio,
        "defaultSeverityId" -> sev,
        "defaultTypeId" -> ttype,
        "defaultAssignee" -> defAssign,
        "dateCreated"    -> JsString(dateFormatter.print(obj.dateCreated))
      )
      toJson(doc)
    }
  }

  /**
   * JSON conversion for TicketPriority
   */
  implicit object TicketPriorityFormat extends Format[TicketPriority] {

    def reads(json: JsValue): JsResult[TicketPriority] = JsSuccess(TicketPriority(
      id          = Id((json \ "id").as[Long]),
      name        = (json \ "name").as[String],
      color       = (json \ "color").as[String],
      position    = (json \ "position").as[Int],
      dateCreated = (json \ "dateCreated").asOpt[String].map({ d => dateFormatterUTC.parseDateTime(d) }).getOrElse(new DateTime())
    ))

    def writes(obj: TicketPriority)(implicit messages: Messages): JsValue = {

      val doc: Map[String,JsValue] = Map(
        "id"            -> JsNumber(obj.id.get),
        "name"          -> JsString(obj.name),
        "nameI18N"      -> JsString(Messages(obj.name)),
        "color"         -> JsString(obj.color),
        "position"      -> JsNumber(obj.position),
        "dateCreated"   -> JsString(dateFormatter.print(obj.dateCreated))
      )
      toJson(doc)
    }
  }

  /**
   * JSON conversion for TicketSeverity
   */
  implicit object TicketSeverityFormat extends Format[TicketSeverity] {

    def reads(json: JsValue): JsResult[TicketSeverity] = JsSuccess(TicketSeverity(
      id          = Id((json \ "id").as[Long]),
      name        = (json \ "name").as[String],
      color       = (json \ "color").as[String],
      position    = (json \ "position").as[Int],
      dateCreated = (json \ "dateCreated").asOpt[String].map({ d => dateFormatterUTC.parseDateTime(d) }).getOrElse(new DateTime())
    ))

    def writes(obj: TicketSeverity)(implicit messages: Messages): JsValue = {

      val doc: Map[String,JsValue] = Map(
        "id"            -> JsNumber(obj.id.get),
        "name"          -> JsString(obj.name),
        "nameI18N"      -> JsString(Messages(obj.name)),
        "color"         -> JsString(obj.color),
        "position"      -> JsNumber(obj.position),
        "dateCreated"   -> JsString(dateFormatter.print(obj.dateCreated))
      )
      toJson(doc)
    }
  }

  /**
   * JSON conversion for TicketLinkType
   */
  implicit object TicketLinkTypeFormat extends Format[TicketLinkType] {

    def reads(json: JsValue): JsResult[TicketLinkType] = JsSuccess(TicketLinkType(
      id          = Id((json \ "id").as[Long]),
      name        = (json \ "name").as[String],
      inverse     = (json \ "inverse").asOpt[Long],
      dateCreated = (json \ "dateCreated").asOpt[String].map({ d => dateFormatterUTC.parseDateTime(d) }).getOrElse(new DateTime())
    ))

    def writes(obj: TicketLinkType)(implicit messages: Messages): JsValue = {

      val doc: Map[String,JsValue] = Map(
        "id"            -> JsNumber(obj.id.get),
        "name"          -> JsString(obj.name),
        "nameI18N"      -> JsString(Messages(obj.name)),
        "inverse"       -> optionLongtoJsValue(obj.inverse),
        "dateCreated"   -> JsString(dateFormatter.print(obj.dateCreated))
      )
      toJson(doc)
    }
  }

  /**
   * JSON conversion for TicketResolution
   */
  implicit object TicketResolutionFormat extends Format[TicketResolution] {

    def reads(json: JsValue): JsResult[TicketResolution] = JsSuccess(TicketResolution(
      id          = Id((json \ "id").as[Long]),
      name        = (json \ "name").as[String],
      dateCreated = (json \ "dateCreated").asOpt[String].map({ d => dateFormatterUTC.parseDateTime(d) }).getOrElse(new DateTime())
    ))

    def writes(obj: TicketResolution)(implicit messages: Messages): JsValue = {

      val doc: Map[String,JsValue] = Map(
        "id"            -> JsNumber(obj.id.get),
        "name"          -> JsString(obj.name),
        "nameI18N"      -> JsString(Messages(obj.name)),
        "dateCreated"   -> JsString(dateFormatter.print(obj.dateCreated))
      )
      toJson(doc)
    }
  }

  /**
   * JSON conversion for TicketType
   */
  implicit object TicketTypeFormat extends Format[TicketType] {

    def reads(json: JsValue): JsResult[TicketType] = JsSuccess(TicketType(
      id          = Id((json \ "id").as[Long]),
      name        = (json \ "name").as[String],
      color       = (json \ "color").as[String],
      dateCreated = (json \ "dateCreated").asOpt[String].map({ d => dateFormatterUTC.parseDateTime(d) }).getOrElse(new DateTime())
    ))

    def writes(obj: TicketType)(implicit messages: Messages): JsValue = {

      val doc: Map[String,JsValue] = Map(
        "id"            -> JsNumber(obj.id.get),
        "name"          -> JsString(obj.name),
        "nameI18N"      -> JsString(Messages(obj.name)),
        "color"         -> JsString(obj.color),
        "dateCreated"   -> JsString(dateFormatter.print(obj.dateCreated))
      )
      toJson(doc)
    }
  }

  /**
   * JSON conversion for User
   */
  implicit object UserFormat extends Format[User] {

    def reads(json: JsValue): JsResult[User] = JsSuccess(User(
      id          = Id((json \ "id").as[Long]),
      username    = (json \ "username").as[String],
      password    = (json \ "password").as[String],
      realName    = (json \ "realName").as[String],
      timezone    = (json \ "timezone").as[String],
      location    = (json \ "location").asOpt[String],
      title       = (json \ "title").asOpt[String],
      url         = (json \ "url").asOpt[String],
      dateCreated = (json \ "dateCreated").asOpt[String].map({ d => dateFormatterUTC.parseDateTime(d) }).getOrElse(new DateTime())
    ))

    def writes(obj: User)(implicit messages: Messages): JsValue = {

      val doc: Map[String,JsValue] = Map(
        "id"              -> obj.id.map(i => JsNumber(i)).getOrElse(JsNull),
        "username"        -> JsString(obj.username),
        "realName"        -> JsString(obj.realName),
        "emailDigest"     -> JsString(DigestUtils.md5Hex(obj.username.trim.toLowerCase)),
        "timezone"        -> JsString(obj.timezone),
        "location"        -> optionStringtoJsValue(obj.location),
        "title"           -> optionStringtoJsValue(obj.title),
        "url"             -> optionStringtoJsValue(obj.url),
        "dateCreated"     -> JsString(dateFormatter.print(obj.dateCreated))
      )
      toJson(doc)
    }
  }

  /**
   * JSON conversion for UserToken
   */
  implicit object UserTokenFormat extends Format[UserToken] {

    def reads(json: JsValue): JsResult[UserToken] = JsSuccess(UserToken(
      token   = Id((json \ "name").as[String]),
      userId  = (json \ "userId").as[Long],
      comment = (json \ "comment").asOpt[String],
      dateCreated = (json \ "dateCreated").asOpt[String].map({ d => dateFormatterUTC.parseDateTime(d) }).getOrElse(new DateTime())
    ))

    def writes(obj: UserToken)(implicit messages: Messages): JsValue = {
      val doc: Map[String,JsValue] = Map(
        "token"         -> JsString(obj.token.get),
        "userId"        -> JsNumber(obj.userId),
        "comment"       -> optionStringtoJsValue(obj.comment),
        "dateCreated"   -> JsString(dateFormatter.print(obj.dateCreated))
      )
      toJson(doc)
    }
  }

  /**
   * JSON conversion for Workflow
   */
  implicit object WorkflowFormat extends Format[Workflow] {

    def reads(json: JsValue): JsResult[Workflow] = JsSuccess(Workflow(
      id          = Id((json \ "id").as[Long]),
      name        = (json \ "name").as[String],
      description = (json \ "description").asOpt[String],
      dateCreated = (json \ "dateCreated").asOpt[String].map({ d => dateFormatterUTC.parseDateTime(d) }).getOrElse(new DateTime())
    ))

    def writes(w: Workflow)(implicit messages: Messages): JsValue = {

      val wsdoc: Map[String,JsValue] = Map(
        "id"              -> JsNumber(w.id.get),
        "name"            -> JsString(w.name),
        "nameI18N"       -> JsString(Messages(w.name)),
        "description"     -> optionStringtoJsValue(w.description),
        "dateCreated"  -> JsString(dateFormatter.print(w.dateCreated))
      )
      toJson(wsdoc)
    }
  }


  /**
   * JSON conversion for WorkflowStatus
   */
  implicit object WorkflowStatusFormat extends Format[WorkflowStatus] {

    def reads(json: JsValue): JsResult[WorkflowStatus] = JsSuccess(WorkflowStatus(
      id          = Id((json \ "id").as[Long]),
      workflowId  = (json \ "workflowId").as[Long],
      statusId    = (json \ "statusId").as[Long],
      name        = (json \ "name").as[String],
      position    = (json \ "position").as[Int]
    ))

    def writes(ws: WorkflowStatus)(implicit messages: Messages): JsValue = {

      val wsdoc: Map[String,JsValue] = Map(
        "id"              -> JsNumber(ws.id.get),
        "workflowId"      -> JsNumber(ws.workflowId),
        "statusId"        -> JsNumber(ws.statusId),
        "name"            -> JsString(ws.name),
        "nameI18N"        -> JsString(Messages(ws.name)),
        "position"        -> JsNumber(ws.position)
      )
      toJson(wsdoc)
    }
  }
}
