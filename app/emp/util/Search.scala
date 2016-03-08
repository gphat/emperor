package emp.util

import collection.JavaConversions._
import com.ning.http.client.Response
import emp.util.Pagination.Page
import models.{ProjectModel,SearchModel}
import play.api.Logger
import play.api.libs.json._
import scala.concurrent.Future
import wabisabi.Client

/**
 * Utilities for search.
 */
object Search {

  /**
   * Class for search queries
   */
  case class SearchQuery(
    page: Int = 1,
    count: Int = 10,
    query: String = "",
    projects: Seq[Long] = Seq(),
    /**
     * Map of filters.  Key is the name.
     */
    filters: Map[String, Seq[String]] = Map.empty,
    sortBy: Option[String] = Some("dateCreated"),
    sortOrder: Option[String] = None
  )

  /**
   * An aggregation of a search.
   */
  case class Aggregation(value: String, count: Long)

  /**
   * A collection of aggregations.
   */
  case class Aggregations(name: String, items: Seq[Aggregation])

  /**
   * A search result.
   */
  case class SearchResult[A](pager: Page[A], aggregations: Seq[Aggregations])

  /**
   * Contains logic for converting ES' crazy aggregation classes into something sane.
   */
  def parseSearchResponse[A](pager: Page[A], response: JsValue): SearchResult[A] = {

    // Logger.debug("Response:")
    // Logger.debug(Json.prettyPrint(response))
    val aggObj = (response \ "aggregations").as[JsObject]
    // Don't bother digging into the facets if there's only one of them
    val aggregations = if(aggObj.fields.length > 1) {
      aggObj.fields.map({ case (aggName, aggValue) =>
        // zip together the list of terms and their counts so we can make an aggregation
        val terms = (aggValue \ "terms" \\ "term").zip(aggValue \ "terms" \\ "count").map({ case (term, termCount) =>
          // It's possible to get a number back, since the user ID is a number. We'll just convert it
          // back to a string.
          val t = try {
            term.as[String]
          } catch {
            case e: Exception => term.as[Int].toString
          }
          Aggregation(value = t, count = termCount.as[Int])
        })
        Aggregations(name = aggName, items = terms)
      }) filter { f => f.items.size > 1 } // Eliminate facets with only one item
    } else { Seq() }

    SearchResult(pager = pager, aggregations = aggregations)
  }

  /**
   * Run a query against ElasticSearch. Creates a boolean filter query that
   * wraps a project limiting filter and the the supplied filters.
   *
   * It's worth mentioning that this method will strip filters for `projectId`
   * <b>out</b> of the filters supplied in `query` if they are not visible. If
   * `filterProjects` is true it will use the user in `query` to create a filter
   * of visible projects. See `getVisibleProjects` in [[models.ProjectModel]].
   */
  def runQuery(
    client: Client, index: String, query: SearchQuery, filterMap: Map[String,String],
    sortMap: Map[String,String], aggregations: Map[String,String] = Map.empty
  ): Future[Response] = {

    val termFilters: Seq[JsObject] = query.filters.flatMap({ kv =>
      kv._2.map({ v =>
        Json.obj("term" -> Json.obj(filterMap.get(kv._1).get -> v))
      })
    }).toSeq

    val q = if(query.query.isEmpty) "*" else query.query
    val qq = if(q == "*") {
      // No reason to do anything fancy for a query for "everything",
      // so we'll use a match all. phrase_prefix doesn't work without
      // something, so this is required, not just an optimization
      Json.obj("match_all" -> Json.obj())
    } else {
      Json.obj(
        // Use a combination of a text and query string parser to get everything!
        "bool" -> Json.obj(
          "should" -> Json.arr(
            Json.obj("multi_match" -> Json.obj(
              "query" -> q,
              "type" -> "phrase_prefix",
              "fields" -> "_all"
            )),
            Json.obj("queryString" -> Json.obj("query" -> q))
          )
        )
      )
    }

    val actualQuery = if(!termFilters.isEmpty) {
      Json.obj(
        "filtered" -> Json.obj(
          "query" -> qq,
          "filter" -> Json.obj(
            "and" -> termFilters
          )
        )
      )
    } else {
      qq
    }

    val sortOrder = query.sortOrder match {
      case Some(s) => if(s.equalsIgnoreCase("desc")) "desc" else "asc"
      case None => "desc"
    }

    val from = query.page match {
      case 0 => 0
      case 1 => 0
      case _ => (query.page - 1) * query.count
    }

    // Make a map of aggregations
    val finalAggs = aggregations.foldLeft(Json.obj())((acc, f) => {
      acc ++ Json.obj(
        f._1 -> Json.obj(
          "terms" -> Json.obj("field" -> f._2)
        )
      )
    })

    val fullSearch = Json.obj(
      "query" -> actualQuery,
      "from" -> from,
      "size" -> query.count,
      "sort" -> Json.arr(
        Json.obj(sortMap.get(query.sortBy.getOrElse("dateCreated")).getOrElse("dateCreated") -> Json.obj("order" -> sortOrder))
      ),
      "aggregations" -> finalAggs
    )

    // Logger.debug("Running ES query against index " + index + ":")
    // Logger.debug(Json.prettyPrint(fullSearch))

    client.search(index = index, query = fullSearch.toString)
  }
}
