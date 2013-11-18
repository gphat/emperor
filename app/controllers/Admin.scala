package controllers

import controllers.Auth._
import play.api._
import play.api.mvc._
import models.SearchModel

object Admin extends Controller with Secured {

  def reindex = IsAuthenticated(admin = true) { implicit request =>

    SearchModel.reIndex
    // This was causing the reindex to be called twice and I have NO idea why.
    // Redirect(routes.Admin.index).flashing("success" -> "admin.reindex.success")
    Ok("ok")
  }

  def index = IsAuthenticated(admin = true) { implicit request =>

    Ok(views.html.admin.index(request))
  }
}