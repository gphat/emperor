package controllers.api

import emp.JsonFormats._
import emp.util.Search._
import controllers._
import models._
import play.api.i18n.Messages
import play.api.libs.json._
import play.api.libs.json.Json
import play.api.mvc._

object Timeline extends Controller with Secured {

  def index(page: Int = 1, count: Int = 10, callback: Option[String]) = IsAuthenticated() { implicit request =>

    val projects = models.ProjectModel.getAll

    val filters = request.queryString filterKeys { key =>
      SearchModel.eventFilterMap.get(key).isDefined
    }

    val query = SearchQuery(filters = filters, page = page, count = count)

    val results = SearchModel.searchEvent(query)

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
          val i18n = if(fs.name == "user") {
            UserModel.getById(f.value.toLong).map({ user =>
              user.realName
            }).getOrElse(f.value)
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