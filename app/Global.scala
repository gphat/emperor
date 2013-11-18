import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.Actor
import emp.event._
import emp.plugin._
import emp.util.Stats
import models.SearchModel
// import play.airbrake.Airbrake
import play.api._
import play.api.Play.current
import play.api.mvc._
import play.api.mvc.Results._
import play.api.db.DB
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Global extends GlobalSettings {

  override def onError(request: RequestHeader, ex: Throwable) = {
    // Airbrake.notify(request, ex)
    Logger.error(ex.toString)
    Future(InternalServerError(views.html.error.error()))
  }

  override def onHandlerNotFound(request: RequestHeader) = {
    Future(NotFound(views.html.error.missing()))
  }

  override def onStart(app: Application) {
    Logger.info("Application has started")

    val actsystem = ActorSystem("Emperor")

    val emailNotifier = actsystem.actorOf(Props(new EmailNotifier(Play.configuration)))

    EmailNotifier.relevantEvents.foreach { ev =>
      Logger.debug("Subscribed Email Notifier to '" + ev + "'")
      EmperorEventBus.subscribe(emailNotifier, ev)
    }

    val searchIndexer = actsystem.actorOf(Props(new SearchIndexer(Play.configuration)))

    // Search indexer does not like running without ES
    if(!Play.isTest) {
      SearchIndexer.relevantEvents.foreach { ev =>
        Logger.debug("Subscribed Search Indexer to '" + ev + "'")
        EmperorEventBus.subscribe(searchIndexer, ev)
      }
    }

    val forgotPasswordNotifier = actsystem.actorOf(Props(new ForgotPasswordNotifier(Play.configuration)))

    ForgotPasswordNotifier.relevantEvents.foreach { ev =>
      Logger.debug("Subscribed Forgot Password Notifier to '" + ev + "'")
      EmperorEventBus.subscribe(forgotPasswordNotifier, ev)
    }

    // val signupNotifier = actsystem.actorOf(Props(new SignupNotifier(Play.configuration)))
    // SignupNotifier.relevantEvents.foreach { ev =>
    //   Logger.debug("Subscribed Signup Notifier to '" + ev + "'")
    //   EmperorEventBus.subscribe(signupNotifier, ev)
    // }
  }

  override def onStop(app: Application) {
    Logger.info("Application shutdown...")
  }
}