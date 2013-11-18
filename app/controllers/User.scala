package controllers

import anorm._
import emp.util.Search._
import org.joda.time.DateTime
import play.api._
import play.api.data._
import play.api.data.Forms._
import play.api.mvc._
import play.api.mvc.Security._
import play.api.db._
import models.{ProjectModel,SearchModel,UserModel,UserTokenModel}
import org.slf4j.{Logger,LoggerFactory}
import emp.util.Search._

object User extends Controller with Secured {

  val editForm = Form(
    mapping(
      "id"       -> ignored(NotAssigned:Pk[Long]),
      "username" -> email,
      "password" -> ignored[String](""),
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

  val passwordForm = Form(
    mapping(
      "password" -> nonEmptyText(minLength = 8, maxLength = 1024),
      "password2"-> nonEmptyText(minLength = 8, maxLength = 1024)
    )(models.NewPassword.apply)(models.NewPassword.unapply)
    verifying("user.password.match", np => { np.password.equals(np.password2) })
  )

  val tokenForm = Form(
    mapping(
      "token"   -> ignored(NotAssigned:Pk[String]),
      "userId"  -> ignored[Long](1),
      "comment" -> optional(text),
      "dateCreated" -> ignored[DateTime](new DateTime())
    )(models.UserToken.apply)(models.UserToken.unapply)
  )

  def edit(userId: Long) = IsAuthenticated() { implicit request =>
    UserModel.getById(userId).map({ user =>
      if(request.user.id.get == userId || request.user.admin) {
        Ok(views.html.user.edit(userId, editForm.fill(user), tokenForm, passwordForm)(request))
      } else {
        NotFound
      }
    }).getOrElse(NotFound)
  }

  def generateToken(userId: Long) = IsAuthenticated() { implicit request =>
    UserModel.getById(userId).map({ user =>
      tokenForm.bindFromRequest.fold(
        errors => {
          Results.Redirect(routes.Core.index()).flashing("error" -> "user.token.failure")
        }, {
          case token: models.UserToken => {
            UserTokenModel.create(userId, token.comment)
            Results.Redirect(routes.User.edit(userId)).flashing("success" -> "user.token.success")
          }
        }
      )
    }).getOrElse(NotFound)
  }

  def item(userId: Long, page: Int = 1, count: Int = 10) = IsAuthenticated() { implicit request =>

    UserModel.getById(userId).map({ user =>

      val efilters = Map("user" -> Seq(userId.toString))

      val eventQuery = SearchQuery(query = "*", filters = efilters, page = page, count = count)

      val events = SearchModel.searchEvent(eventQuery)

      Ok(views.html.user.item(user)(request))
    }).getOrElse(NotFound)
  }

  def update(userId: Long) = IsAuthenticated() { implicit request =>

    UserModel.getById(userId).map({ user =>
      if(request.user.id.get == userId || request.user.admin) {
        editForm.bindFromRequest.fold(
          errors => {
            BadRequest(views.html.user.edit(userId, errors, tokenForm, passwordForm))
          },
          {
            case user: models.User => {
              UserModel.update(userId, user)
              Redirect(routes.User.item(userId)).flashing("success" -> "user.edit.success")
            }
          }
        )
      } else {
        NotFound
      }
    }).getOrElse(NotFound)
  }

  def updatePassword(userId: Long) = IsAuthenticated() { implicit request =>

    UserModel.getById(userId).map({ user =>
      if(request.user.id.get == userId || request.user.admin) {
        passwordForm.bindFromRequest.fold(
          errors => {
            BadRequest(views.html.user.edit(userId, editForm.fill(user), tokenForm, errors))
          }, {
            case np: models.NewPassword => {
              UserModel.updatePassword(userId, np.password)
              Redirect(routes.User.item(userId)).flashing("success" -> "user.password.success")
            }
          }
        )
      } else {
        NotFound
      }
    }).getOrElse(NotFound)
  }
}
