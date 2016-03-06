package controllers

import emp.event._
import emp.util.Stats
import play.api._
import play.api.data._
import play.api.data.Forms._
import play.api.i18n.{I18nSupport,MessagesApi}
import play.api.Logger
import play.api.mvc._
import models._
import org.mindrot.jbcrypt.BCrypt

class Auth(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  val loginForm = Form(
    mapping(
      "username" -> email,
      "password" -> nonEmptyText
    )(LoginUser.apply)(LoginUser.unapply)
    .verifying("auth.failure", params => !params.username.equalsIgnoreCase("anonymous"))
    .verifying("auth.failure", params => {
      val maybeUser = UserModel.getByUsername(params.username)
      maybeUser match {
        case Some(user) => {
          BCrypt.checkpw(params.password, user.password) == true
        }
        case None => false
      }
    })
  )

  val forgotForm = Form(
    mapping(
      "username" -> email
    )(ForgotUser.apply)(ForgotUser.unapply)
  )

  val resetForm = Form(
    mapping(
      "password" -> nonEmptyText(minLength = 8),
      "password2" -> nonEmptyText(minLength = 8)
    )(NewPassword.apply)(NewPassword.unapply)
    verifying("user.password.match", np => { np.password.equals(np.password2) })
  )

  def forgot = Action { implicit request =>

    Ok(views.html.auth.forgot(forgotForm))
  }

  def login(redirectUrl: String = "/") = Action { implicit request =>

    Ok(views.html.auth.login(loginForm, redirectUrl))
  }

  def logout = Action { implicit request =>

    Redirect(routes.Auth.login()).withNewSession.flashing("error" -> "auth.logout.success")
  }

  def reset(token: String) = Action { implicit request =>

    UserModel.getByForgotPassword(token).map({ user =>
      Ok(views.html.auth.reset(resetForm, token))
    }).getOrElse(
      Redirect(routes.Auth.login()).flashing("error" -> "auth.forgot.notfound")
    )
  }


  def doLogin(redirectUrl: String = "/") = Action { implicit request =>

    loginForm.bindFromRequest.fold(
      errors => {
        BadRequest(views.html.auth.login(errors, redirectUrl))
      }, {
        case loginUser => {

          val user = UserModel.getByUsername(loginUser.username).get // We know this exists, so just get it
          EmperorEventBus.publish(
            LogInUserEvent(
              userId = user.id.get
            )
          )
          Stats.addEvent("usersLoggedIn", Map("userId" -> user.id.get.toString))
          Redirect(redirectUrl).withSession("user_id" -> user.id.get.toString).flashing("success" -> "auth.success")
        }
      }
    )
  }

  def doForgot = Action { implicit request =>
    forgotForm.bindFromRequest.fold(
      errors => {
        BadRequest(views.html.auth.forgot(errors))
      }, {
        case forgotUser => {
          UserModel.getByUsername(forgotUser.username).map({ user =>
            val token = UserModel.generateForgotPassword(user.id.get)
            Stats.addEvent("passwordsReset", Map("userId" -> user.id.get.toString))
            Redirect(routes.Auth.login()).flashing("success" -> "auth.forgot.success")
          }).getOrElse(NotFound(views.html.auth.forgot(forgotForm)))
        }
      }
    )
  }

  def doReset(token: String) = Action { implicit request =>
    UserModel.getByForgotPassword(token).map({ user =>
      resetForm.bindFromRequest.fold(
        errors => {
          BadRequest(views.html.auth.reset(errors, token))
        }, {
          case np: models.NewPassword => {
            UserModel.updatePassword(user.id.get, np.password)
            Redirect(routes.Auth.login()).flashing("success" -> "user.password.success")
          }
        }
      )
    }).getOrElse(
      Redirect(routes.Auth.login()).flashing("error" -> "auth.forgot.notfound")
    )
  }
}

case class AuthenticatedRequest(
  val user: models.User, request: Request[AnyContent]
) extends WrappedRequest(request)

/**
 * Provide security features
 */
trait Secured {

  /**
   * Redirect to login if the user in not authenticated.
   */
  private def onUnauthenticated(request: RequestHeader) = Results.Redirect("/auth/login", Map("redirectUrl" -> Seq(request.uri))).flashing("error" -> "auth.mustlogin")

  /**
   * Redirect to index if the user in not authenticated.
   */
  private def onUnauthorized(request: RequestHeader) = Results.Redirect(routes.Core.index()).flashing("error" -> "auth.notauthorized")

  /**
   * Action for verifying authentication and authorization of users and no specific project or ticket.
   */
  def IsAuthenticated(admin: Boolean = false)(f: AuthenticatedRequest => Result) = {
    Action { request =>

      // Try and find a user
      getUserIdFromRequest(request).flatMap({ uid =>
        UserModel.getById(uid)
      }).map({ user =>
        if(admin) {
          if(user.admin == true) {
            f(AuthenticatedRequest(user, request))
          } else {
            Logger.debug("Denied to user " + user.id.get + " due to lack of admin privelege.")
            onUnauthorized(request)
          }
        } else {
          f(AuthenticatedRequest(user, request))
        }
      }).getOrElse({
        Logger.debug("Denied to unknown user")
        onUnauthenticated(request)
      })
    }
  }

  /**
   * Try and find a user via header token
   */
  def getUserIdFromRequest(request: RequestHeader): Option[Long] = {

    if(request.session.get("user_id").isDefined){
      // It's in the session, use that!  This is most common, so it's first
      Some(request.session.get("user_id").get.toLong)
    } else if(request.headers.get("Authorization").isDefined && request.headers.get("Authorization").get.startsWith("Token token=")) {
      val token = request.headers.get("Authorization").get.substring(12).trim()
      // Token is present, use that!  Use map, as we might not get one back
      // if the token is invalid.
      UserTokenModel.getById(token).map({ ut =>
        // Give back the user id for the token
        Some(ut.userId)
      }).getOrElse(None)
    } else if(request.queryString.contains("authtoken") && request.queryString.get("authtoken").isDefined) {
      val token = request.queryString.get("authtoken").get.head
      // Token is present, use that!  Use map, as we might not get one back
      // if the token is invalid.
      UserTokenModel.getById(token).map({ ut =>
        // Give back the user id for the token
        Some(ut.userId)
      }).getOrElse(None)
    } else {
      // anonymous no longer works!
      None
    }
  }
}
