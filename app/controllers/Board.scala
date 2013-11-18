package controllers

import controllers._
import emp.util.Search._
import emp.util.Stats
import models.{ProjectModel,SearchModel,WorkflowModel}
import play.api.libs.json.Json
import play.api.mvc._

object Board extends Controller with Secured {

  def index(projectId: Long) = IsAuthenticated() { implicit request =>
    ProjectModel.getById(projectId).map({ project =>
      Stats.addEvent("boardsViewed", Map("projectId" -> projectId.toString))
      Ok(views.html.board.index(project, WorkflowModel.getStatuses(project.workflowId, agile = false))(request))
    }).getOrElse(NotFound)
  }

}