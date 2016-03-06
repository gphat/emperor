package controllers.api

import javax.inject.Inject

import controllers.Secured
import emp._
import emp.JsonFormats._
import emp.util.Stats
import models._
import play.api.i18n.{I18nSupport,Messages,MessagesApi}
import play.api.libs.json._
import play.api.libs.json.Json
import play.api.mvc._

class Search @Inject() (val messagesApi: MessagesApi) extends Controller with I18nSupport with Secured {

  def index(page: Int, count: Int, query: String, sort: Option[String] = None, order: Option[String] = None, callback: Option[String]) = IsAuthenticated() { implicit request =>

    val filters = request.queryString filterKeys { key =>
      SearchModel.ticketFilterMap.get(key).isDefined
    }

    val sort = request.queryString.get("sort").map({ vals => Some(vals.head) }).getOrElse(None);
    val order = request.queryString.get("order").map({ vals => Some(vals.head) }).getOrElse(None);
    val q = emp.util.Search.SearchQuery(
      page = page, count = count, query = query,
      filters = filters, sortBy = sort, sortOrder = order
    )
    val results = SearchModel.searchTickets(q)

    Stats.addEvent("performedSearches", Map("query" -> query))

    Ok(Json.obj(
      "pager" -> Json.obj(
        "items" -> Json.toJson(results.pager.items),
        "page" -> results.pager.page,
        "requestedPage" -> results.pager.requestedPage,
        "range" -> results.pager.range,
        "window" -> results.pager.getWindow(10),
        "count" -> results.pager.count,
        "total" -> results.pager.total,
        "next"  -> results.pager.next,
        "prev"  -> results.pager.prev,
        "offset"-> results.pager.offset
      ),
      "facets" -> results.facets.map(fs => Json.obj(
        "name" -> fs.name,
        "nameI18N" -> Messages("search.facet." + fs.name),
        "items" -> fs.items.map(f => {
          val i18n = if(fs.name == "assignee") {
            UserModel.getById(f.value.toLong).map({ user =>
              user.realName
            }).getOrElse(Messages("TICK_UNASSIGNED"))
          } else {
            Messages(f.value)
          }
          Json.obj(
            "value" -> f.value,
            "valueI18N" -> i18n,
            "count" -> f.count
          )
        })
      ))
    ))
  }
}
