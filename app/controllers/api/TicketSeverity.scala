package controllers.api

import emp.JsonFormats._
import controllers._
import models._
import play.api.i18n.{I18nSupport,Messages,MessagesApi}
import play.api.libs.json._
import play.api.libs.json.Json
import play.api.mvc._

class TicketSeverity(val messagesApi: MessagesApi) extends Controller with I18nSupport with Secured {

  def index(callback: Option[String]) = IsAuthenticated() { implicit request =>
    Ok(Json.toJson(TicketSeverityModel.getAll))
  }

  def item(sevId: Long, callback: Option[String]) = IsAuthenticated() { implicit request =>

    TicketSeverityModel.getById(sevId).map({ sev =>

      Ok(Json.toJson(sev))
    }).getOrElse(NotFound(Json.obj("status" -> "KO", "message" -> "api.unknown.entity")))
  }
}
