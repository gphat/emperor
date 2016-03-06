package controllers

import javax.inject.Inject

import emp._
import emp.util.Search._
import play.api._
import play.api.i18n.{I18nSupport,Messages,MessagesApi}
import play.api.mvc._
import play.api.mvc.Security._
import play.api.db._
import models.{ProjectModel,SearchModel}
import org.slf4j.{Logger,LoggerFactory}
import emp.util.Search._

class Core @Inject() (val messagesApi: MessagesApi) extends Controller with I18nSupport with Secured {

  def index(page: Int = 1, count: Int = 10) = IsAuthenticated() { implicit request =>

    val projects = models.ProjectModel.getAll

    val filters = request.queryString filterKeys { key =>
      key match {
        case "project"    => true
        case "priority"   => true
        case "resolution" => true
        case "severity"   => true
        case "type"       => true
        case _            => false // Nothing else is useful as a filter
      }
    }

    val query = SearchQuery(filters = filters, page = page, count = count)

    val response = SearchModel.searchEvent(query)

    Ok(views.html.index(projects))
  }
}
