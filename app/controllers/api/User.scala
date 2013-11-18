package controllers.api

import emp.JsonFormats._
import controllers._
import models.{UserModel,UserTokenModel}
import play.api._
import play.api.mvc._
import play.api.libs.json.Json

object User extends Controller with Secured {

  def startsWith(q: Option[String], callback: Option[String]) = IsAuthenticated() { implicit request =>

    q.map({ query =>
      Ok(Json.toJson(UserModel.getStartsWith(query)))
    }).getOrElse(NotFound(Json.obj("status" -> "KO", "message" -> "api.unknown.entity")))
  }

  def deleteToken(token: String, callback: Option[String]) = IsAuthenticated() { implicit request =>

    UserTokenModel.delete(request.user.id.get, token).map({ token =>
      Ok(Json.toJson(token))
    }).getOrElse(NotFound(Json.obj("status" -> "KO", "message" -> "api.unknown.entity")))
  }

  def index(callback: Option[String]) = IsAuthenticated() { implicit request =>
    Ok(Json.toJson(UserModel.getAll))
  }

  def item(userId: Long, callback: Option[String]) = IsAuthenticated() { implicit request =>

    UserModel.getById(userId).map({ user =>

      Ok(Json.toJson(user))
    }).getOrElse(NotFound(Json.obj("status" -> "KO", "message" -> "api.unknown.entity")))
  }

  def tokens(userId: Long, callback: Option[String]) = IsAuthenticated() { implicit request =>
    UserModel.getById(userId).map({ user =>
      val tokens = UserTokenModel.getByUser(userId)
      Ok(Json.toJson(tokens.items.toSeq))
    }).getOrElse(NotFound(Json.obj("status" -> "KO", "message" -> "api.unknown.entity")))
  }
}