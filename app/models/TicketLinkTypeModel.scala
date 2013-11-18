package models

import anorm._
import anorm.SqlParser._
import emp.util.AnormExtension._
import emp.util.Pagination.Page
import org.joda.time.DateTime
import play.api.db.DB
import play.api.Play.current

/**
 * Class for types of links.
 */
case class TicketLinkType(id: Pk[Long] = NotAssigned, name: String, inverse: Option[Long], dateCreated: DateTime)

object TicketLinkTypeModel {

  val allQuery = SQL("SELECT * FROM ticket_link_types ORDER BY name")
  val getByIdQuery = SQL("SELECT * FROM ticket_link_types WHERE id={id}")
  val listQuery = SQL("SELECT * FROM ticket_link_types LIMIT {count} OFFSET {offset}")
  val listCountQuery = SQL("SELECT count(*) FROM ticket_link_types")
  val insertQuery = SQL("INSERT INTO ticket_link_types (name) VALUES ({name})")
  val updateQuery = SQL("UPDATE ticket_link_types SET name={name} WHERE id={id}")
  val deleteQuery = SQL("DELETE FROM ticket_link_types WHERE id={id}")

  // parser for retrieving a link type
  val ticket_link_type = {
    get[Pk[Long]]("id") ~
    get[String]("name") ~
    get[Option[Long]]("inverse") ~
    get[DateTime]("date_created") map {
      case id~name~inverse~dateCreated => TicketLinkType(id, name, inverse, dateCreated)
    }
  }

  /**
   * Create a link type.
   */
  def create(ts: TicketLinkType): TicketLinkType = {

    val id = DB.withConnection { implicit conn =>
      insertQuery.on(
        'name       -> ts.name
      ).executeInsert()
    }

    getById(id.get).get
  }

  /**
   * Delete a link type.
   */
  def delete(id: Long) {
    DB.withConnection { implicit conn =>
      deleteQuery.on(
        'id -> id
      ).execute
    }
  }

  /**
   * Get a link type by id.
   */
  def getById(id: Long) : Option[TicketLinkType] = {

    DB.withConnection { implicit conn =>
      getByIdQuery.on('id -> id).as(ticket_link_type.singleOpt)
    }
  }

  def getAll: List[TicketLinkType] = {

    DB.withConnection { implicit conn =>
      allQuery.as(ticket_link_type.*)
    }
  }

  def list(page: Int = 1, count: Int = 10) : Page[TicketLinkType] = {

      val offset = count * (page - 1)

      DB.withConnection { implicit conn =>
        val tss = listQuery.on(
          'count  -> count,
          'offset -> offset
        ).as(ticket_link_type.*)

        val totalRows = listCountQuery.as(scalar[Long].single)

        Page(tss, page, count, totalRows)
      }
  }

  /**
   * Update a link type.
   */
  def update(id: Long, ts: TicketLinkType): Option[TicketLinkType] = {

    DB.withConnection { implicit conn =>
      updateQuery.on(
        'id         -> id,
        'name       -> ts.name
      ).execute
      getById(id)
    }
  }
}
