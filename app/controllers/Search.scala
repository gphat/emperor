
package controllers

import emp._
import collection.JavaConversions._
import models._
import play.api.mvc._

object Search extends Controller with Secured {

  def index(page: Int, count: Int, query: String, sort: Option[String] = None, order: Option[String] = None) = IsAuthenticated() { implicit request =>

    val existingTicket: Option[FullTicket] = if(TicketModel.isValidTicketId(query)) {
      TicketModel.getFullByStringId(query)
    } else {
      None
    }

    existingTicket.map({ t =>
      Redirect(routes.Ticket.item("comments", t.ticketId))
    }).getOrElse({
      Ok(views.html.search.index(request))
    })
  }
}
