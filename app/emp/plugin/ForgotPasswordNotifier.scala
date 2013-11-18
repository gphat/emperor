package emp.plugin

import akka.actor.Actor
import emp.Plugin
import emp.event._
import emp.util.Stats
import models.UserModel
import play.api.Configuration
import play.api.i18n.Messages
import play.api.Logger
import play.api.libs.json.Json
import play.api.libs.ws.WS
import scala.concurrent.Await
import scala.concurrent.duration._

class ForgotPasswordNotifier(configuration: Configuration) extends Actor {

  /**
   * Receive an event.
   */
  def receive = {
    case event: EmperorEvent => sendEmail(event)
  }

  /**
   * Send an email after catching an event.
   */
  def sendEmail(event: EmperorEvent) = {

    // maybeAPIKey.map({ apiKey =>
    //   event match {
    //     // Handle an invite request
    //     case fpe: ForgotPasswordEvent => {
    //       UserModel.getById(fpe.userId).map({ user =>
    //         val resp = WS.url("https://mandrillapp.com/api/1.0/messages/send-template.json").
    //           post(Json.obj(
    //             "key" -> apiKey,
    //             "template_name" -> "forgotpassword",
    //             "template_content" -> Json.arr(),
    //             "message" -> Json.obj(
    //               "to" -> Json.arr(
    //                 Json.obj("email" -> user.username)
    //               ),
    //               "merge" -> true,
    //               "global_merge_vars" -> Json.arr(
    //                 Json.obj(
    //                   "name" -> "TOKEN",
    //                   "content" -> user.forgotPassword.get
    //                 )
    //               )
    //             )
    //           ))
    //         val response = Await.result(resp, Duration(5, "seconds"))
    //         if(response.status == 200) {
    //           Stats.addEvent("emailsSent", Map("message" -> "forgotPassword"))
    //           Logger.debug("Sent forgot password for id " + user.id.get)
    //         } else {
    //           Logger.error("Failed to send Mandrill request:" +  response.body)
    //         }
    //       })
    //     }
    //     // Unknown event, just do nothing
    //     case _ => {
    //       Logger.debug("Got an unknown event " + event)
    //     }
    //   }
    // }).getOrElse(Logger.debug("Event ignored due to missing API key in config emperor.mandrill.key"))
  }
}

object ForgotPasswordNotifier extends Plugin {

  def relevantEvents = List("user/forgotpassword")
}