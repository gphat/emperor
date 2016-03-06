package controllers

import controllers._
import emp.util.Search._
import emp.util.Stats
import models.{ProjectModel,SearchModel,WorkflowModel}
import play.api.i18n.{I18nSupport,Messages,MessagesApi}
import play.api.libs.json.Json
import play.api.mvc._

class Board(val messagesApi: MessagesApi) extends Controller with I18nSupport with Secured {

  def index(projectId: Long) = IsAuthenticated() { implicit request =>
    ProjectModel.getById(projectId).map({ project =>
      Stats.addEvent("boardsViewed", Map("projectId" -> projectId.toString))
      Ok(views.html.board.index(project, WorkflowModel.getStatuses(project.workflowId, agile = false))(request))
    }).getOrElse(NotFound)
  }

}
