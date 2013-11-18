package emp.plugin

import akka.actor.Actor
import emp.Plugin
import emp.event._
import models.{SearchModel,TicketModel,UserModel}
import org.apache.commons.codec.digest.DigestUtils
import play.api.Configuration
import play.api.Logger

class SearchIndexer(configuration: Configuration) extends Actor {

  /**
   * Receive an event.
   */
  def receive = {
    case event: EmperorEvent => doIndex(event)
  }

  /**
   * Index something based on the event received.
   */
  def doIndex(event: EmperorEvent) = {

    event match {
      // Handle a change to a ticket
      case cte: ChangeTicketEvent => {
        TicketModel.getFullById(cte.ticketId).map({ ft =>
          Logger.debug("Received change event for " + ft.ticketId + ", indexing.")
          SearchModel.indexTicket(ticket = ft)

          val newTicket = TicketModel.getFullByDataId(cte.newDataId)
          val oldTicket = TicketModel.getFullByDataId(cte.oldDataId)

          SearchModel.indexHistory(newTick = newTicket.get, oldTick = oldTicket.get, block = true)
        })
      }
      // Handle a ticket comment
      case tcomm: CommentTicketEvent => {
        TicketModel.getCommentById(tcomm.commentId).map({ c =>
          Logger.debug("Received comment event for " + c.ticketId + ", indexing.")
          SearchModel.indexComment(c, true)
        })
      }
      case lte: LinkTicketEvent => {
        Logger.debug("Received link event, indexing")
        TicketModel.getFullById(lte.parentId).map({ ft =>
          SearchModel.indexTicket(ticket = ft)
        })
        TicketModel.getFullById(lte.childId).map({ ft =>
          SearchModel.indexTicket(ticket = ft)
        })        
      }
      case lte: UnlinkTicketEvent => {
        Logger.debug("Received unlink event, indexing")
        TicketModel.getFullById(lte.parentId).map({ ft =>
          SearchModel.indexTicket(ticket = ft)
        })
        TicketModel.getFullById(lte.childId).map({ ft =>
          SearchModel.indexTicket(ticket = ft)
        })        
      }
      // Handle a new ticket
      case nte: NewTicketEvent => {
        TicketModel.getFullById(nte.ticketId).map({ ft =>
          Logger.debug("Received create event for " + ft.ticketId + ", indexing.")
          SearchModel.indexTicket(ticket = ft)

          val user = UserModel.getById(ft.user.id).get
          val eType = "EVENT_TYPE_TICKET_CREATE"
          SearchModel.indexEvent(models.Event(
            id            = eType + "-" + ft.ticketId,
            projectId     = ft.project.id,
            projectName   = ft.project.name,
            userId        = ft.user.id,
            userRealName  = ft.user.name,
            username      = user.username,
            userEmailDigest = DigestUtils.md5Hex(user.username),
            eKey          = ft.ticketId,
            eType         = "EVENT_TYPE_TICKET_CREATE",
            content       = ft.summary,
            url           = controllers.routes.Ticket.item("comments", ft.ticketId).url,
            dateCreated   = ft.dateCreated
          ), true)
        })
      }
      // Unknown event, just do nothing
      case _ => None
    }
  }
}

object SearchIndexer extends Plugin {

  def relevantEvents = List("ticket/changed", "ticket/commentedon", "ticket/created", "ticket/linked", "ticket/unlinked")
}