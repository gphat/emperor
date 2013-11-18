package controllers.api

import emp.JsonFormats._
import controllers._
import models._
import play.api.i18n.Messages
import play.api.libs.json._
import play.api.libs.json.Json
import play.api.mvc._

object TicketPriority extends Controller with Secured {

  def index(callback: Option[String]) = IsAuthenticated() { implicit request =>
    Ok(Json.toJson(TicketPriorityModel.getAll))
  }

  def item(prioId: Long, callback: Option[String]) = IsAuthenticated() { implicit request =>

    TicketPriorityModel.getById(prioId).map({ prio =>

      Ok(Json.toJson(prio))
    }).getOrElse(NotFound(Json.obj("status" -> "KO", "message" -> "api.unknown.entity")))
  }
}