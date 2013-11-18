package emp.plugin

import akka.actor.Actor
import emp.Plugin
import emp.event._
import play.api.Configuration
import play.api.i18n.Messages
import play.api.Logger
import play.api.libs.json.Json
import play.api.libs.ws.WS

class SignupNotifier(configuration: Configuration) extends Actor {

  /**
   * Receive an event.
   */
  def receive = {
    case event: EmperorEvent => sendEmail(event)
  }

  // XXX This definitely needs a refactor
  /**
   * Send an email after catching an event.
   */
  def sendEmail(event: EmperorEvent) = {

    // maybeAPIKey.map({ apiKey =>
    //   event match {
    //     // Handle an invite request
    //     case rie: RequestInviteEvent => {
    //       InvitationModel.getUnacceptedById(rie.invitationId).map({ invitation =>
    //         val resp = WS.url("https://mandrillapp.com/api/1.0/messages/send-template.json").
    //           post(Json.obj(
    //             "key" -> apiKey,
    //             "template_name" -> "invitation",
    //             "template_content" -> Json.arr(
    //               Json.obj(
    //                 "name" -> "main",
    //                 "content" -> invitation.secret
    //               )
    //             ),
    //             "message" -> Json.obj(
    //               "to" -> Json.arr(
    //                 Json.obj("email" -> invitation.email)
    //               )
    //             )
    //           ))
    //         val response = Await.result(resp, Duration(5, "seconds"))
    //         if(response.status == 200) {
    //           Logger.debug("Sent invitation for id " + invitation.id)
    //         } else {
    //           Logger.error("Failed to send Mandrill request:" +  response.body)
    //         }
    //       })
    //     }
    //     case aie: AcceptInviteEvent => {
    //       Logger.debug("Invitation accepted")
    //     }
    //     // Unknown event, just do nothing
    //     case _ => {
    //       Logger.debug("Got an unknown event " + event)
    //     }
    //   }
    // }).getOrElse(Logger.debug("Event ignored due to missing API key in config emperor.mandrill.key"))
  }
}

object SignupNotifier extends Plugin {

  def relevantEvents = List("invite/requested", "invite/accepted")
}