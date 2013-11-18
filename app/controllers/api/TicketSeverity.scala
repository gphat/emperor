package controllers.api

import emp.JsonFormats._
import controllers._
import models._
import play.api.i18n.Messages
import play.api.libs.json._
import play.api.libs.json.Json
import play.api.mvc._

object TicketSeverity extends Controller with Secured {

  def index(callback: Option[String]) = IsAuthenticated() { implicit request =>
    Ok(Json.toJson(TicketSeverityModel.getAll))
  }

  def item(sevId: Long, callback: Option[String]) = IsAuthenticated() { implicit request =>

    TicketSeverityModel.getById(sevId).map({ sev =>

      Ok(Json.toJson(sev))
    }).getOrElse(NotFound(Json.obj("status" -> "KO", "message" -> "api.unknown.entity")))
  }
}