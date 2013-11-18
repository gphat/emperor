package controllers.admin

import anorm._
import controllers._
import models.UserModel
import org.mindrot.jbcrypt.BCrypt
import org.joda.time.{DateTime,DateTimeZone}
import play.api._
import play.api.data._
import play.api.data.Forms._
import play.api.data.format.Formats._
import play.api.libs.json.Json._
import play.api.mvc._
import play.api.Play.current
import play.api.db._

object User extends Controller with Secured {

  val newForm = Form(
    mapping(
      "id"       -> ignored(NotAssigned:Pk[Long]),
      "username" -> email,
      "password" -> nonEmptyText,
      "realName" -> nonEmptyText,
      "timezone" -> nonEmptyText,
      "location" -> optional(text),
      "title"    -> optional(text),
      "url"      -> optional(text),
      "active"   -> boolean,
      "admin"    -> boolean,
      "forgotPassword" -> ignored[Option[String]](None),
      "date_created" -> ignored[DateTime](new DateTime())
    )(models.User.apply)(models.User.unapply)
  )

  def add = IsAuthenticated(admin = true) { implicit request =>

    newForm.bindFromRequest.fold(
      errors => BadRequest(views.html.admin.user.create(errors)),
      value => {
        val user = UserModel.create(value)
        Redirect(controllers.routes.User.item(user.id.get)).flashing("success" -> "admin.user.add.success")
      }
    )
  }

  def create = IsAuthenticated(admin = true) { implicit request =>

    val users = UserModel.list(
      page = 1, count = 10
    )
    if(users.total < 1) {
      // Create a default user for filling in the form with the
      // timezone, which we will default to Joda's "default" time.
      val defaultUser = models.User(
        id = Id(1.toLong),
        username = "",
        password = "",
        realName = "",
        timezone = Play.configuration.getString("emperor.timezone").getOrElse(DateTimeZone.getDefault().getID),
        location = None,
        title = None,
        url = None,
        dateCreated = new DateTime()
      )

      Ok(views.html.admin.user.create(newForm.fill(defaultUser))(request))
    } else {
      Redirect(controllers.admin.routes.User.index()).flashing("error" -> "admin.billing.user.limit")
    }
  }

  def index(page: Int = 1, count: Int = 10) = IsAuthenticated(admin = true) { implicit request =>

    val users = UserModel.list(
     page = page, count = count
    )

    Ok(views.html.admin.user.index(users)(request))
  }
}
