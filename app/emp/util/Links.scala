package emp.util

import collection.JavaConversions._
import scala.collection.mutable.ListBuffer

/**
 * Utilities for munging the Request's URL to emulate's [[http://search.cpan.org/dist/Catalyst-Runtime/lib/Catalyst/Request.pm Catalyst's uri_with]].
 * I suspect there there is a better way to do this, but I have yet to find it.
 */
object Links {

  /**
   * Return a String (URL) with a query parameter (`name`) and `value`.
   * It uses the request to populate existing query params and also
   * to provide the base query path.
   * To override the base path you can pass in a `path`.
   */
  def filterLink(params: Map[String,Seq[String]], path: String, name: String, value: String): String = {

    val q = params + (name -> List(value))

    // Filter out any empty values
    val clean = q.filterNot { p =>
      val vals = p._2.filter { v => v != "" }
      vals.isEmpty
    }

    val qs = clean.foldLeft("")(
      (acc, value) => acc + value._2.foldLeft("")(
        (acc2, param) => {
          value._1 match {
            case "page" => ""
            case _ => acc2 + value._1 + "=" + param + "&"
          }
        }
      )
    )

    path + "?" + qs
  }

  /**
   * Return a string (URL) with query parameters `page` and `count` set to the
   * appropriate values.
   */
  def pagerLink(params: Map[String,Seq[String]], path: String, page: Int = 1, count: Int = 10) : String = {

    val q = params + ("page" -> List(page.toString)) + ("count" -> List(count.toString))


    val qs = q.foldLeft("")(
      (acc, value) => acc + value._2.foldLeft("")(
        (acc2, param) => acc2 + value._1 + "=" + param + "&"
      )
    )

    path + "?" + qs
  }

  /**
   * Return a string (URL) with query parameters `sort` and `order` set. The
   * supplied `name` parameter will be set as the value of `sort` and `order`
   * will be one of `asc` or `desc` depending on it's current value.
   */
  def sortLink(params: Map[String,Seq[String]], path: String, name: String): String = {

    // Get rid of sort and order, we'll re-set those
    val cleanQ: Map[String,Seq[String]] = params.filterKeys { key => !key.equalsIgnoreCase("sort") && !key.equalsIgnoreCase("order") }

    // XXX This should NOT be reversed if the sort value is being changed.
    // Otherwise it reverses the first time you /change/ a sort.
    val order = params.get("order") match {
      case Some(v) if v.head.isEmpty => "desc"
      case Some(v) if v.head.equalsIgnoreCase("desc") => "asc"
      case _ => "desc"
    }
    val q = cleanQ ++ Map("sort" -> Seq(name), "order" -> Seq(order))

    val qs = q.foldLeft("")(
      (acc, value) => acc + value._2.foldLeft("")(
        (acc2, param) => acc2 + value._1 + "=" + param + "&"
      )
    )

    path + "?" + qs
  }
}
