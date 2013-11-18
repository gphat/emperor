
package controllers.api

import emp.JsonFormats._
import controllers._
import models._
import play.api.i18n.Messages
import play.api.libs.json._
import play.api.libs.json.Json
import play.api.mvc._

object Project extends Controller with Secured {

  def assignableUsers(id: Long, callback: Option[String]) = IsAuthenticated() { implicit request =>

    Ok(Json.toJson(UserModel.getAssignable()))
  }

  def index(callback: Option[String]) = IsAuthenticated() { implicit request =>
    Ok(Json.toJson(ProjectModel.getAll))
  }

  def item(id: Long, callback: Option[String]) = IsAuthenticated() { implicit request =>

    ProjectModel.getById(id).map({ project =>
      Ok(Json.toJson(project))
    }).getOrElse({
      NotFound(Json.obj("status" -> "KO", "message" -> "api.unknown.entity"))
    })
  }
}