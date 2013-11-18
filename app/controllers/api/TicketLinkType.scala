package controllers.api

import anorm.Id
import emp.JsonFormats._
import controllers._
import models._
import play.api.i18n.Messages
import play.api.libs.json._
import play.api.libs.json.Json
import play.api.mvc._

object TicketLinkType extends Controller with Secured {

  def index(callback: Option[String]) = IsAuthenticated() { implicit request =>

    val linkTypes = TicketLinkTypeModel.getAll

    Ok(Json.toJson(linkTypes))
  }

  def item(typeId: Long, callback: Option[String]) = IsAuthenticated() { implicit request =>

    TicketLinkTypeModel.getById(typeId).map({ ttype =>
      Ok(Json.toJson(ttype))
    }).getOrElse(NotFound(Json.obj("status" -> "KO", "message" -> "api.unknown.entity")))
  }
}