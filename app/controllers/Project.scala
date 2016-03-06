package controllers

import javax.inject.Inject

import anorm._
import emp.JsonFormats._
import emp.util.Search._
import emp.util.Stats
import models._
import org.joda.time.DateTime
import play.api._
import play.api.data._
import play.api.data.Forms._
import play.api.i18n.{I18nSupport,Messages,MessagesApi}
import play.api.mvc._
import play.api.libs.json.Json

class Project @Inject() (val messagesApi: MessagesApi) extends Controller with I18nSupport with Secured {

  val addProjectForm = Form(
    mapping(
      "id"                  -> ignored(NotAssigned:Pk[Long]),
      "workflow_id"         -> ignored(0L),
      "name"                -> nonEmptyText,
      "key"                 -> text(minLength = 3, maxLength = 16).verifying("project.key.invalid", ProjectModel.isValidKey(_)),
      "owner_id"            -> optional(longNumber),
      "default_priority_id" -> optional(longNumber),
      "default_severity_id" -> optional(longNumber),
      "default_type_id"     -> optional(longNumber),
      "default_assignee"    -> optional(number),
      "date_created"        -> ignored(new DateTime())
    )(models.Project.apply)(models.Project.unapply)
  )

  val editProjectForm = Form(
    mapping(
      "id"                  -> ignored(NotAssigned:Pk[Long]),
      "workflow_id"         -> ignored(0L),
      "name"                -> nonEmptyText,
      "key"                 -> ignored[String](""),
      "owner_id"            -> optional(longNumber),
      "default_priority_id" -> optional(longNumber),
      "default_severity_id" -> optional(longNumber),
      "default_type_id"     -> optional(longNumber),
      "default_assignee"    -> optional(number),
      "date_created"        -> ignored(new DateTime())
    )(models.Project.apply)(models.Project.unapply)
  )

  def add = IsAuthenticated(admin = true) { implicit request =>

    addProjectForm.bindFromRequest.fold(
      errors => {
        val users = UserModel.getAll.map { x => (x.id.get.toString -> x.realName) }
        val asses = DefaultAssignee.values.map { x => (x.id.toString -> Messages(x.toString)) }
        val ttypes = TicketTypeModel.getAll.map { x => (x.id.get.toString -> Messages(x.name)) }
        val prios = TicketPriorityModel.getAll.map { x => (x.id.get.toString -> Messages(x.name)) }
        val sevs = TicketSeverityModel.getAll.map { x => (x.id.get.toString -> Messages(x.name)) }

        BadRequest(views.html.project.create(errors, users, asses.toList, ttypes, prios, sevs))
      },
      value => {
        ProjectModel.create(project = value).map({ project =>

          Redirect(routes.Project.item(project.id.get)).flashing("success" -> "project.add.success")
        }).getOrElse(
          Redirect(routes.Project.index()).flashing("error" -> "project.add.failure")
        )
      }
    )
  }

  def create = IsAuthenticated(admin = true) { implicit request =>

    val projs = ProjectModel.list(page = 1, count = 10)
    if(projs.total < 1) {
      val users = UserModel.getAll.map { x => (x.id.get.toString -> x.realName) }
      val asses = DefaultAssignee.values.map { x => (x.id.toString -> Messages(x.toString)) }
      val ttypes = TicketTypeModel.getAll.map { x => (x.id.get.toString -> Messages(x.name)) }
      val prios = TicketPriorityModel.getAll.map { x => (x.id.get.toString -> Messages(x.name)) }
      val sevs = TicketSeverityModel.getAll.map { x => (x.id.get.toString -> Messages(x.name)) }
      Stats.addEvent("createdProjects", Map("userId" -> request.user.id.toString))
      Ok(views.html.project.create(addProjectForm, users, asses.toList, ttypes, prios, sevs))
    } else {
      Redirect(routes.Project.index()).flashing("error" -> "admin.billing.project.limit")
    }
  }

  def index(page: Int = 1, count: Int = 10) = IsAuthenticated() { implicit request =>

    val emailFinder = """(\w+)@([\w\.]+)""".r

    val projs = ProjectModel.list(page = page, count = count)

    Ok(views.html.project.index(projs))
  }

  def edit(projectId: Long) = IsAuthenticated(admin = true) { implicit request =>

    val maybeProject = ProjectModel.getById(projectId)

    val users = UserModel.getAll.map { x => (x.id.get.toString -> x.realName) }
    val asses = DefaultAssignee.values.map { x => (x.id.toString -> Messages(x.toString)) }
    val ttypes = TicketTypeModel.getAll.map { x => (x.id.get.toString -> Messages(x.name)) }
    val prios = TicketPriorityModel.getAll.map { x => (x.id.get.toString -> Messages(x.name)) }
    val sevs = TicketSeverityModel.getAll.map { x => (x.id.get.toString -> Messages(x.name)) }

    maybeProject match {
      case Some(project) => {
        Ok(views.html.project.edit(projectId, editProjectForm.fill(project), users, asses.toList, ttypes, prios, sevs))
      }
      case None => NotFound(views.html.error.missing())
    }
  }

  def item(projectId: Long, page: Int = 1, count: Int = 10) = IsAuthenticated() { implicit request =>

    ProjectModel.getById(projectId).map({ project =>
      val eventQuery = SearchQuery(projects = Seq(projectId), page = page, count = count)

      val events = SearchModel.searchEvent(eventQuery)

      val owner = project.ownerId.map({ userId => UserModel.getById(userId) }).getOrElse(None)

      Ok(views.html.project.item(project, Json.toJson(project), owner))
    }).getOrElse(NotFound(views.html.error.missing()))
  }

  def update(projectId: Long) = IsAuthenticated() { implicit request =>

    editProjectForm.bindFromRequest.fold(
      errors => {
        val users = UserModel.getAll.map { x => (x.id.get.toString -> x.realName) }
        val asses = DefaultAssignee.values.map { x => (x.id.toString -> Messages(x.toString)) }
        val ttypes = TicketTypeModel.getAll.map { x => (x.id.get.toString -> Messages(x.name)) }
        val prios = TicketPriorityModel.getAll.map { x => (x.id.get.toString -> Messages(x.name)) }
        val sevs = TicketSeverityModel.getAll.map { x => (x.id.get.toString -> Messages(x.name)) }

        BadRequest(views.html.project.edit(projectId, errors, users, asses.toList, ttypes, prios, sevs))
      },
      value => {
        ProjectModel.update(projectId, value)
        Redirect(routes.Project.item(projectId)).flashing("success" -> "project.edit.success")
      }
    )
  }
}
