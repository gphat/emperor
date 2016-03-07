package emp.event

import akka.event.ActorEventBus
import akka.event.LookupClassification
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.Actor
import emp.plugin._
import javax.inject._
import models._
import play.api.Environment
import play.api.Logger
import play.api.Play.current

/**
 * Base class for events.
 */
class EmperorEvent(n: String) {
  val name: String = n
}

// XXX Tests for the emission of these events would be awesome.

/**
 * `project/changed`: Represents a modification of a project.
 */
case class ChangeProjectEvent(
  projectId: Long
) extends EmperorEvent("project/changed")

/**
 * `ticket/changed`: Represents a modification of a ticket.
 */
case class ChangeTicketEvent(
  ticketId: Long,
  newDataId: Long,
  oldDataId: Long
) extends EmperorEvent("ticket/changed")

/**
 * `ticket/commentedon`: Represents a comment added to a ticket.
 */
case class CommentTicketEvent(
  ticketId: Long,
  commentId: Long
) extends EmperorEvent("ticket/commentedon")

case class ForgotPasswordEvent(
  userId: Long
) extends EmperorEvent("user/forgotpassword")

/**
 * `ticket/linked`: Represents a link created between two tickets.
 */
case class LinkTicketEvent(
  groupId: Long,
  parentId: Long,
  childId: Long
) extends EmperorEvent("ticket/linked")

/**
 * `user/loggedin`: Represents a user logging in.
 */
case class LogInUserEvent(
  userId: Long
) extends EmperorEvent("user/loggedin")

/**
 * `project/created`: Represents the creation of a project.
 */
case class NewProjectEvent(
  projectId: Long
) extends EmperorEvent("project/created")

/**
 * `ticket/created`: Represents the creation of a ticket.
 */
case class NewTicketEvent(
  ticketId: Long
) extends EmperorEvent("ticket/created")

/**
 * `user/created`: Represents the creation of a user.
 */
case class NewUserEvent(
  userId: Long
) extends EmperorEvent("user/created")

/**
 * `ticket/unlinked`: Represents the removal of a link between two tickets.
 */
case class UnlinkTicketEvent(
  childId: Long,
  parentId: Long
) extends EmperorEvent("ticket/unlinked")

/**
 * Internal event bus used to notify interested plugins about activity within
 * emperor.
 *
 * ==Events==
 *
 * $ - project/changed
 * $ - project/created
 * $ - ticket/changed
 * $ - ticket/commentedon
 * $ - ticket/created
 * $ - ticket/linked
 * $ - ticket/unlinked
 * $ - user/created
 * $ - user/forgotpassword
 * $ - user/loggedin
 */
@Singleton
class EmperorEventBus @Inject() (val env: Environment) extends ActorEventBus with LookupClassification {
  type Event=EmperorEvent
  type Classifier=String

  Logger.info("Application has started")

  val actsystem = ActorSystem("Emperor")

  val emailNotifier = actsystem.actorOf(Props(new EmailNotifier(current.configuration)))

  EmailNotifier.relevantEvents.foreach { ev =>
    Logger.debug("Subscribed Email Notifier to '" + ev + "'")
    this.subscribe(emailNotifier, ev)
  }

  val searchIndexer = actsystem.actorOf(Props(new SearchIndexer(current.configuration)))

  // Search indexer does not like running without ES
  if(env.mode.toString != "TEST") {
    SearchIndexer.relevantEvents.foreach { ev =>
      Logger.debug("Subscribed Search Indexer to '" + ev + "'")
      this.subscribe(searchIndexer, ev)
    }
  }

  val forgotPasswordNotifier = actsystem.actorOf(Props(new ForgotPasswordNotifier(current.configuration)))

  ForgotPasswordNotifier.relevantEvents.foreach { ev =>
    Logger.debug("Subscribed Forgot Password Notifier to '" + ev + "'")
    this.subscribe(forgotPasswordNotifier, ev)
  }

  // val signupNotifier = actsystem.actorOf(Props(new SignupNotifier(Play.configuration)))
  // SignupNotifier.relevantEvents.foreach { ev =>
  //   Logger.debug("Subscribed Signup Notifier to '" + ev + "'")
  //   EmperorEventBus.subscribe(signupNotifier, ev)
  // }

  protected def mapSize(): Int = 10

  protected def classify(event: Event): Classifier = event.name

  protected def publish(event: Event, subscriber: Subscriber): Unit = subscriber ! event
}
