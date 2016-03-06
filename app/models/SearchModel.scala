package models

import anorm._
import anorm.SqlParser._
import emp.text.Renderer
import emp.util.Pagination.Page
import emp.util.{Search,Stats}
import emp.util.Search._
import emp.JsonFormats._
import java.net.URL
import org.apache.commons.codec.digest.DigestUtils
import play.api._
import play.api.Logger
import play.api.Play.current
import play.api.db.DB
import play.api.libs.json.Json._
import play.api.libs.json._

import org.joda.time.format.DateTimeFormat

// XXX
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Try

import wabisabi.Client

import emp._
import scala.collection.JavaConversions._
import scala.util.{Failure,Success}

object SearchModel {

  val dateFormatter = DateTimeFormat.forPattern("yyyyMMdd'T'HHmmss'Z'").withZoneUTC()

  val config = Play.configuration.getConfig("emperor")

  val esURL = config.get.getString("es.url")

  Logger.debug("Trying to connect to " + esURL)
  val esClient = new Client(esURL.getOrElse("http://localhost:9200"))

  val getNextIndexQuery = SQL("SELECT nextval('search_index_counter')");

  // Ticket ES index
  val ticketIndex = "tickets"
  val ticketType = "ticket"
  val ticketFilterMap = Map(
    "assignee"    -> "assigneeId",
    "project"     -> "projectName",
    "priority"    -> "priorityName",
    "resolution"  -> "resolutionName",
    "severity"    -> "severityName",
    "status"      -> "statusName",
    "type"        -> "typeName",
    "relations"   -> "relations"
  )
  val ticketSortMap = Map(
    "date_created"-> "dateCreated",
    "id"          -> "id",
    "priority"    -> "priorityPosition",
    "severity"    -> "severityPosition",
    "type"        -> "typeName",
    "resolution"  -> "resolutionId"
  )
  val ticketMapping = """
  {
    "ticket": {
      "properties": {
        "ticketId": {
          "type": "string",
          "index": "not_analyzed"
        },
        "userId": {
          "type": "long",
          "index": "not_analyzed"
        },
        "projectId": {
          "type": "long",
          "index": "not_analyzed"
        },
        "projectName": {
          "type": "string",
          "index": "not_analyzed"
        },
        "priorityid": {
          "type": "long",
          "index": "not_analyzed"
        },
        "priorityName": {
          "type": "string",
          "index": "not_analyzed"
        },
        "priorityColor": {
          "type": "string",
          "index": "not_analyzed"
        },
        "priorityPosition": {
          "type": "integer",
          "index": "not_analyzed"
        },
        "resolutionId": {
          "type": "long",
          "index": "not_analyzed"
        },
        "resolutionName": {
          "type": "string",
          "index": "not_analyzed"
        },
        "assigneeId": {
          "type": "long",
          "index": "not_analyzed"
        },
        "attentionId": {
          "type": "long",
          "index": "not_analyzed"
        },
        "severityId": {
          "type": "long",
          "index": "not_analyzed"
        },
        "severityColor": {
          "type": "string",
          "index": "not_analyzed"
        },
        "severityName": {
          "type": "string",
          "index": "not_analyzed"
        },
        "severityPosition": {
          "type": "integer",
          "index": "not_analyzed"
        },
        "statusId": {
          "type": "long",
          "index": "not_analyzed"
        },
        "statusName": {
          "type": "string",
          "index": "not_analyzed"
        },
        "typeId": {
          "type": "long",
          "index": "not_analyzed"
        },
        "typeColor": {
          "type": "string",
          "index": "not_analyzed"
        },
        "typeName": {
          "type": "string",
          "index": "not_analyzed"
        },
        "workflowStatusId": {
          "type": "long",
          "index": "not_analyzed"
        },
        "workflowPosition": {
          "type": "integer",
          "index": "not_analyzed"
        },
        "summary": {
          "type": "string",
          "index": "analyzed"
        },
        "description": {
          "type": "string",
          "index": "analyzed"
        },
        "blocks": {
          "type": "string",
          "index": "not_analyzed"
        },
        "isBlockedBy": {
          "type": "string",
          "index": "not_analyzed"
        },
        "contains": {
          "type": "string",
          "index": "not_analyzed"
        },
        "isContainedIn": {
          "type": "string",
          "index": "not_analyzed"
        },
        "isRelatedTo": {
          "type": "string",
          "index": "not_analyzed"
        },
        "relations": {
          "type": "string",
          "index": "not_analyzed"
        },
        "dateCreated": {
          "type": "date",
          "format": "basic_date_time_no_millis"
        }
      }
    }
  }
  """

  // Event ES index
  val eventIndex = "events"
  val eventType = "event"
  val eventFilterMap = Map(
    "user" -> "userId",
    "project" -> "projectName",
    "etype" -> "etype"
  )
  val eventSortMap = Map(
    "date_created" -> "dateCreated"
  )
  val eventMapping = """
  {
    "event": {
      "properties": {
        "projectId": {
          "type": "long",
          "index": "not_analyzed"
        },
        "projectName": {
          "type": "string",
          "index": "not_analyzed"
        },
        "userId": {
          "type": "long",
          "index": "not_analyzed"
        },
        "ekey": {
          "type": "string",
          "index": "not_analyzed"
        },
        "etype": {
          "type": "string",
          "index": "not_analyzed"
        },
        "content": {
          "type": "string",
          "index": "not_analyzed"
        },
        "url": {
          "type": "string",
          "index": "not_analyzed"
        },
        "dateCreated": {
          "type": "date",
          "format": "basic_date_time_no_millis"
        }
      }
    }
  }
  """

  // Ticket Comment ES index
  val ticketCommentIndex = "ticket_comments"
  val ticketCommentType = "ticket_comment"
  val ticketCommentFilterMap = Map(
    "ticket_id" -> "ticketId",
    "type"      -> "type"
  )
  val ticketCommentSortMap = Map(
    "dateCreated"-> "dateCreated"
  )
  val ticketCommentMapping = """
  {
    "ticket_comment": {
      "properties": {
        "type": {
          "type": "string",
          "index": "not_analyzed"
        },
        "ticketId": {
          "type": "string",
          "index": "not_analyzed"
        },
        "userId": {
          "type": "long",
          "index": "not_analyzed"
        },
        "content": {
          "type": "string",
          "index": "analyzed"
        },
        "dateCreated": {
          "type": "date",
          "format": "basic_date_time_no_millis"
        }
      }
    }
  }
  """

  // Facets
  val ticketCommentFacets = Map(
    "user_id" -> "userId"
  )
  val eventFacets = Map(
    "project" -> "projectName",
    "user" -> "userId",
    "etype" -> "etype"
  )
  val ticketFacets = Map(
    "resolution" -> "resolutionName",
    "type" -> "typeName",
    "project" -> "projectName",
    "priority" -> "priorityName",
    "severity" -> "severityName",
    "status" -> "statusName",
    "assignee" -> "assigneeId",
    "relations" -> "relations"
  )

  val indexSettings = "{\"settings\": { \"index\": { \"number_of_shards\": 1 } } }"

  /**
   * Index an event.
   *
   * @param event The event to index
   * @param block Boolean determining if this method should block and refresh the index before returning.
   */
  def indexEvent(event: Event, block: Boolean = false) {
    Stats.addEvent("thingsIndexed", Map("thing" -> "event"))
    esClient.index(
      id = Some(event.id), index = eventIndex + "-write", `type` = eventType,
      data = toJson(event).toString, refresh = block
    )
  }

  /**
   * Index a comment.
   *
   * @param comment The comment to index
   * @param block Boolean determining if this method should block and refresh the index before returning
   */
  def indexComment(comment: Comment, block: Boolean = false) {
    esClient.index(
      index = ticketCommentIndex + "-write", `type` = ticketCommentType, id = Some(comment.id.get.toString),
      data = toJson(comment).toString, refresh = block
    )

    val ft = TicketModel.getFullById(comment.ticketId).get

    val user = UserModel.getById(comment.userId).get

    val eType = comment.ctype match {
      case "commit" => {
        Stats.addEvent("thingsIndexed", Map("thing" -> "commit"))
        "EVENT_TYPE_TICKET_COMMIT"
      }
      case _        => {
        Stats.addEvent("thingsIndexed", Map("thing" -> "comment"))
        "EVENT_TYPE_TICKET_COMMENT"
      }
    }

    indexEvent(Event(
      id            = eType + "-" + ft.ticketId + "-" + comment.id.toString,
      projectId     = ft.project.id,
      projectName   = ft.project.name,
      userId        = user.id.get,
      userRealName  = user.realName,
      username      = user.username,
      userEmailDigest =DigestUtils.md5Hex(user.username),
      eKey          = ft.ticketId,
      eType         = eType,
      content       = Renderer.render(Some(comment.content)),
      url           = controllers.routes.Ticket.item("commits", ft.ticketId).url + "#comment-" + comment.id.get,
      dateCreated   = comment.dateCreated
    ))
  }

  /**
   * Index a ticket.

   * @param ticket The ticket to index
   * @param block Boolean determining if this method should block and refresh the index before returning
   */
  def indexTicket(ticket: FullTicket, block: Boolean = false) {
    Stats.addEvent("thingsIndexed", Map("thing" -> "ticket"))
    esClient.index(
      index = ticketIndex + "-write", `type` = ticketType, id = Some(ticket.ticketId), data = toJson(ticket).toString,
      refresh = block
    )
  }

  /**
   * Index a history item by comparing a new and old ticket.
   *
   * @param oldTick The old ticket, before changes
   * @param newTick The new ticket, after changes
   * @param block Boolean determining if this method should block and refresh the index before returning
   */
  def indexHistory(oldTick: FullTicket, newTick: FullTicket, block: Boolean = false) {

    val projChanged = newTick.project.id != oldTick.project.id
    val prioChanged = newTick.priority.id != oldTick.priority.id
    val resoChanged = newTick.resolution.id != oldTick.resolution.id
    val assChanged = newTick.assignee.id != oldTick.assignee.id
    val attChanged = newTick.attention.id != oldTick.attention.id
    val sevChanged = newTick.severity.id != oldTick.severity.id
    val statChanged = newTick.status.id != oldTick.status.id
    val typeChanged = newTick.ttype.id != oldTick.ttype.id
    val summChanged = newTick.summary != oldTick.summary
    val descChanged = newTick.description != oldTick.description

    val hdoc: Map[String,JsValue] = Map(
      "ticketId"         -> JsNumber(newTick.id.get),
      "userId"           -> JsNumber(newTick.user.id),
      "userRealname"     -> JsString(newTick.user.name),
      "projectId"        -> JsNumber(newTick.project.id),
      "oldProjectId"    -> JsNumber(oldTick.project.id),
      "projectName"      -> JsString(newTick.project.name),
      "oldProjectName"  -> JsString(oldTick.project.name),
      "projectChanged"   -> JsBoolean(projChanged),
      "priorityId"       -> JsNumber(newTick.priority.id),
      "oldPriorityId"   -> JsNumber(oldTick.priority.id),
      "priorityName"     -> JsString(newTick.priority.name),
      "oldPriorityName" -> JsString(oldTick.priority.name),
      "priorityChanged"   -> JsBoolean(prioChanged),
      "resolutionId"     -> { newTick.resolution.id match {
        case Some(id) => JsNumber(id)
        case None     => JsNull
      } },
      "oldResolutionId" -> { oldTick.resolution.id match {
        case Some(id) => JsNumber(id)
        case None     => JsNull
      } },
      "resolutionName"   -> { newTick.resolution.name match {
        case Some(name) => JsString(name)
        case None       => JsString("TICK_RESO_UNRESOLVED")
      } },
      "oldResolutionName" -> JsString(oldTick.resolution.name.getOrElse("")),
      "resolutionChanged"-> JsBoolean(resoChanged),
      "assigneeId"       -> { newTick.assignee.id match {
        case Some(assId)=> JsNumber(assId)
        case None       => JsNull
      } },
      "oldAssigneeId"       -> { oldTick.assignee.id match {
        case Some(assId)=> JsNumber(assId)
        case None       => JsNull
      } },
      "assigneeName"     -> { newTick.assignee.name match {
        case Some(name) => JsString(name)
        case None       => JsNull
      } },
      "oldAssigneeName"     -> { oldTick.assignee.name match {
        case Some(name) => JsString(name)
        case None       => JsNull
      } },
      "assigneeChanged"  -> JsBoolean(assChanged),
      "attentionId"      -> { newTick.attention.id match {
        case Some(attId) => JsNumber(attId)
        case None        => JsNull
      } },
      "oldAttentionId"      -> { oldTick.attention.id match {
        case Some(attId) => JsNumber(attId)
        case None        => JsNull
      } },
      "attentionName"    -> { newTick.attention.name match {
        case Some(name) => JsString(name)
        case None       => JsNull
      } },
      "oldAttentionName"    -> { oldTick.attention.name match {
        case Some(name) => JsString(name)
        case None       => JsNull
      } },
      "attentionChanged" -> JsBoolean(attChanged),
      "severityId"       -> JsNumber(newTick.severity.id),
      "oldSeverityId"   -> JsNumber(oldTick.severity.id),
      "severityName"     -> JsString(newTick.severity.name),
      "oldSeverityName" -> JsString(oldTick.severity.name),
      "severityChanged"  -> JsBoolean(sevChanged),
      "statusId"         -> JsNumber(newTick.status.id),
      "oldStatusId"     -> JsNumber(oldTick.status.id),
      "statusName"       -> JsString(newTick.status.name),
      "oldStatusName"   -> JsString(oldTick.status.name),
      "statusChanged"    -> JsBoolean(statChanged),
      "typeId"           -> JsNumber(newTick.ttype.id),
      "oldTypeId"       -> JsNumber(oldTick.ttype.id),
      "typeName"         -> JsString(newTick.ttype.name),
      "oldTypeName"     -> JsString(oldTick.ttype.name),
      "typeChanged"      -> JsBoolean(typeChanged),
      "summary"           -> JsString(newTick.summary),
      "oldSummary"       -> JsString(oldTick.summary),
      "summaryChanged"   -> JsBoolean(summChanged),
      "description"       -> JsString(newTick.description.getOrElse("")),
      "oldDescription"   -> JsString(oldTick.description.getOrElse("")),
      "descriptionChanged" -> JsBoolean(descChanged),
      "dateCreated"      -> JsString(dateFormatter.print(newTick.dateCreated))
    )
    // esClient.index(
    //   index = ticketHistoryIndex + "-write", `type` = ticketHistoryType,
    //   id = Some(newTick.dataId.toString), data = toJson(hdoc).toString,
    //   refresh = block
    // )
    val eType = if(resoChanged && newTick.resolution.id.isDefined) {
      "EVENT_TYPE_TICKET_RESOLVE"
    } else if(resoChanged && !newTick.resolution.id.isDefined) {
      "EVENT_TYPE_TICKET_UNRESOLVE"
    } else if(statChanged) {
      "EVENT_TYPE_TICKET_STATUS"
    } else {
      "EVENT_TYPE_TICKET_CHANGE"
    }

    val user = UserModel.getById(newTick.user.id).get
    indexEvent(Event(
      id            = eType + "-" + newTick.ticketId + "-" + newTick.dataId.toString,
      projectId     = newTick.project.id,
      projectName   = newTick.project.name,
      userId        = newTick.user.id,
      userRealName  = newTick.user.name,
      username      = user.username,
      userEmailDigest = DigestUtils.md5Hex(user.username),
      eKey          = newTick.ticketId,
      eType         = eType,
      content       = newTick.summary,
      url           = controllers.routes.Ticket.item("comments", newTick.ticketId).url, // This should really link to the history tab's specific entry
      dateCreated   = newTick.dateChanged
    ))
  }

  /**
   * Delete all the existing indexes and recreate them. Then iterate over
   * all the tickets and index each one and it's history.  Finally
   * reindex all the ticket comments.
   */
  def reIndex = {

    Stats.addEvent("reindexes", Map("foo" -> "bar"))
    // Get the number of the next index.
    val newIndexNum = DB.withConnection { implicit conn =>
      getNextIndexQuery.as(scalar[Long].single)
    }
    val oldIndexNum = newIndexNum - 1

    val indexNames = List(eventIndex, ticketIndex, ticketCommentIndex)
    val typeNames = List(eventType, ticketType, ticketCommentType)
    val mappings = List(eventMapping, ticketMapping, ticketCommentMapping)

    // Create the indices and set the mappings.
    indexNames.zipWithIndex.foreach({ case (n, i) =>
      val oldName = n + "_" + oldIndexNum.toString
      val name = n + "_" + newIndexNum.toString
      Logger.debug(s"Checking index $name")
      esClient.verifyIndex(name = name) onComplete { maybeRes =>
        maybeRes match {
          case Success(res) => {
            if(res.getStatusCode == 404) {
              Logger.debug(s"Creating index $name")
              // If the verify fails, that means it doesn't exist. We don't care about
              // success because that means the index is there.
              esClient.createIndex(name = name, settings = Some(indexSettings)) map { f =>
                esClient.health(indices = Seq(name), waitForNodes = Some("1")) // XXX Number of shards should be configurable
              } map { f =>
                esClient.putMapping(indices = Seq(name), `type` = typeNames(i), body = mappings(i))
                // Create the write alias so that new writes go to the correct index
                Logger.debug(s"Aliasing $n -write to $name")
                Logger.debug("""{ "remove": { "index": """" + oldName + """", "alias": """" + n + """-write" } }, { "add": { "index": """ + name  + """", "alias": """" + n + """-write" } }""")
                println(Await.result(esClient.createAlias(actions = """{ "remove": { "index": """" + oldName + """", "alias": """" + n + """-write" } }, { "add": { "index": """" + name  + """", "alias": """" + n + """-write" } }"""), Duration(5, "seconds")).getResponseBody)
              } recover {
                case x: Throwable => {
                  Logger.error(s"Failed to create index: $name")
                  x.printStackTrace
                  // Rethrow!
                  throw x
                }
              }
            }
          }
          case Failure(res) => throw new RuntimeException("Problem creating indices")
        }
      }
    })

    // Verify we got all the indices created
    Await.result(esClient.health(indices = Seq(indexNames.last + "_" +  newIndexNum), waitForNodes = Some("1")), Duration(5, "seconds"))

    Logger.debug("Reindexing")

    // Reindex all tickets and their history
    TicketModel.getAllCurrentFull.foreach { ticket =>
      indexTicket(ticket)

      val user = UserModel.getById(ticket.user.id).get
      val eType = "EVENT_TYPE_TICKET_CREATE"
      indexEvent(Event(
        id            = eType + "-" + ticket.ticketId,
        projectId     = ticket.project.id,
        projectName   = ticket.project.name,
        userId        = ticket.user.id,
        userRealName  = ticket.user.name,
        username      = user.username,
        userEmailDigest = DigestUtils.md5Hex(user.username),
        eKey          = ticket.ticketId,
        eType         = eType,
        content       = ticket.summary,
        url           = controllers.routes.Ticket.item("comments", ticket.ticketId).url,
        dateCreated   = ticket.dateCreated
      ))

      val count = TicketModel.getAllFullCountById(ticket.id.get)
      if(count > 1) {
        TicketModel.getAllFullById(ticket.id.get).foldLeft(None: Option[FullTicket])((oldTick, newTick) => {
          // First run will NOT index history because oldTick is None (as None starts the fold)
          oldTick.map { ot => indexHistory(oldTick = ot, newTick = newTick) }

          Some(newTick)
        })
      }
    }
    // Reindex all ticket comments
    // XXX This should be nested within the above loop to avoid having to
    // re-fetch every fullticket.
    TicketModel.getAllComments.foreach { comment =>
      indexComment(comment)
    }

    // Create the read aliases and delete old index
    indexNames.foreach({ iname =>
      val oldName = iname + "_" + oldIndexNum.toString
      val newName = iname + "_" + newIndexNum.toString
      Logger.debug(s"Aliasing $iname -read to $newName")
      Await.result(esClient.createAlias(actions = """{ "remove": { "index": """" + oldName + """", "alias": """" + iname + """-read" }}, { "add": { "index": """" + newName  + """", "alias": """" + iname + """-read" }}"""), Duration(5, "seconds"))
      Await.result(esClient.deleteIndex(oldName), Duration(5, "seconds"))
    })

    Thread.sleep(1000) // Pause a second to let ES catch up
  }

  /**
   * Search for ticket changes, or history.
   */
  def searchChange(page: Int, count: Int, query: String, filters: Map[String, Seq[String]]): SearchResult[JsValue] = {

    val pager = Page(List[JsValue](), 0, 0, 0)
    SearchResult(pager, Seq())

  //   // This shouldn't have to live here. It annoys me. Surely there's a better
  //   // way.
  //   var q = query
  //   if(q.isEmpty) {
  //     q = "*"
  //   }

  //   var actualQuery : BaseQueryBuilder = queryString(q)

  //   // If we have filters, build up a filterquery and swap out our actualQuery
  //   // with a filtered version!
  //   if(!filters.isEmpty) {
  //     val fqs: Iterable[FilterBuilder] = filters map {
  //       case (key, values) => termFilter(key, values.head).asInstanceOf[FilterBuilder]
  //     }
  //     actualQuery = filteredQuery(actualQuery, andFilter(fqs.toSeq:_*))
  //   }

  //   esClient.search(index = ticketHistoryIndex, query = actualQuery.toString)

  //   // indexer.search(
  //   //   query = actualQuery,
  //   //   indices = Seq("ticket_histories-read"),
  //   //   facets = Seq(
  //   //     // termsFacet("user_id").field("user_id"), // XXX Broken due to differing classes
  //   //     termsFacet("changed_priority").field("priority_changed"),
  //   //     termsFacet("changed_resolution").field("resolution_changed"),
  //   //     termsFacet("changed_severity").field("severity_changed"),
  //   //     termsFacet("changed_status").field("status_changed")
  //   //   ),
  //   //   size = Some(count),
  //   //   from = page match {
  //   //     case 0 => Some(0)
  //   //     case 1 => Some(0)
  //   //     case _ => Some((page - 1) * count)
  //   //   },
  //   //   sortings = Seq(FieldSort(field = "date_created", order = SortOrder.DESC))
  //   // )
  }

  /**
   * Search for ticket comments.
   */
  def searchComment(query: SearchQuery): SearchResult[Comment] = {

    val res = Search.runQuery(
      client = esClient, index = ticketCommentIndex + "-read", query = query,
      filterMap = ticketCommentFilterMap, sortMap = ticketCommentSortMap,
      facets = ticketCommentFacets
    )
    Try({ Await.result(res, Duration(1, "seconds")).getResponseBody }).map({ response =>

      val jres = Json.parse(response)
      val total = (jres \ "hits" \ "total").asOpt[Int].getOrElse(0)
      val hits = (jres \ "hits" \ "hits" \\ "_source").map({ h => Json.fromJson[models.Comment](h).asOpt.get })

      val pager = Page(hits, query.page, query.count, total)
      emp.util.Search.parseSearchResponse(pager = pager, response = jres)
    }).getOrElse(SearchResult[Comment](
      pager = Page[Comment](
        items = Seq[Comment](),
        requestedPage = query.page,
        count = query.count,
        total = 0
      ),
      facets = Seq())
    )
  }

  /**
   * Search for events.
   */
  def searchEvent(query: SearchQuery): SearchResult[Event] = {

    val res = Search.runQuery(esClient, eventIndex + "-read", query, eventFilterMap, eventSortMap, eventFacets)
    Try({ Await.result(res, Duration(1, "seconds")).getResponseBody }).map({ response =>

      val jres = Json.parse(response)
      val total = (jres \ "hits" \ "total").asOpt[Int].getOrElse(0)
      val hits = (jres \ "hits" \ "hits" \\ "_source").map({ h => Json.fromJson[models.Event](h).asOpt.get })

      val pager = Page(hits, query.page, query.count, total)
      emp.util.Search.parseSearchResponse(pager = pager, response = jres)
    }).getOrElse(SearchResult[Event](
      pager = Page[Event](
        items = Seq[Event](),
        requestedPage = query.page,
        count = query.count,
        total = 0
      ),
      facets = Seq())
    )
  }

  /**
   * Search for tickets.
   */
  def searchTickets(query: SearchQuery): SearchResult[FullTicket] = {

    val res = runQuery(esClient, ticketIndex + "-read", query, ticketFilterMap, ticketSortMap, ticketFacets)

    val attempt = Try({ Await.result(res, Duration(1, "seconds")).getResponseBody }).map({ response =>
      val jres = Json.parse(response)
      val total = (jres \ "hits" \ "total").asOpt[Int].getOrElse(0)
      val hits = (jres \ "hits" \ "hits" \\ "_source").map({ h => Json.fromJson[models.FullTicket](h).asOpt.get })
      val pager = Page(hits, query.page, query.count, total)
      emp.util.Search.parseSearchResponse(pager = pager, response = jres)
    })

    attempt match {
      case Failure(thrown) => {
        thrown.printStackTrace
        SearchResult[FullTicket](
          pager = Page[FullTicket](
            items = Seq[FullTicket](),
            requestedPage = query.page,
            count = query.count,
            total = 0
          ),
          facets = Seq()
        )
      }
      case Success(s) => s
    }
  }
}
