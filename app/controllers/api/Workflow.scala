package controllers.api

import emp.JsonFormats._
import controllers._
import models._
import play.api.i18n.Messages
import play.api.libs.json._
import play.api.libs.json.Json
import play.api.mvc._

object Workflow extends Controller with Secured {

  def index(callback: Option[String]) = IsAuthenticated() { implicit request =>
    Ok(Json.toJson(WorkflowModel.getAll))
  }

  def item(id: Long, callback: Option[String]) = IsAuthenticated() { implicit request =>

    WorkflowModel.getById(id).map({ wf =>
      Ok(Json.toJson(wf))
    }).getOrElse(NotFound(Json.obj("status" -> "KO", "message" -> "api.unknown.entity")))
  }

  def statuses(id: Long, callback: Option[String]) = IsAuthenticated() { implicit request =>

    val wfs = WorkflowModel.getStatuses(id)

    Ok(Json.toJson(wfs))
  }
}