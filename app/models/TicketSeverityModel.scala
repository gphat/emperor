package models

import anorm._
import anorm.SqlParser._
import emp.util.AnormExtension._
import emp.util.Pagination.Page
import org.joda.time.DateTime
import play.api.db.DB
import play.api.Play.current

case class TicketSeverity(id: Pk[Long] = NotAssigned, name: String, color: String, position: Int, dateCreated: DateTime)

object TicketSeverityModel {

  val allQuery = SQL("SELECT * FROM ticket_severities ORDER BY position ASC")
  val getByIdQuery = SQL("SELECT * FROM ticket_severities WHERE id={id}")
  val listQuery = SQL("SELECT * FROM ticket_severities ORDER BY position ASC LIMIT {count} OFFSET {offset}")
  val listCountQuery = SQL("SELECT count(*) FROM ticket_severities")
  val insertQuery = SQL("INSERT INTO ticket_severities (name, color, position) VALUES ({name}, {color}, {position})")
  val updateQuery = SQL("UPDATE ticket_severities SET name={name}, color={color}, position={position} WHERE id={id}")
  val deleteQuery = SQL("DELETE FROM ticket_severities WHERE id={id}")

  val ticket_severity = {
    get[Pk[Long]]("id") ~
    get[String]("name") ~
    get[String]("color") ~
    get[Int]("position") ~
    get[DateTime]("date_created") map {
      case id~name~color~position~dateCreated => TicketSeverity(
        id = id,
        name = name,
        color = color,
        position = position,
        dateCreated = dateCreated
      )
    }
  }

  /**
  * Create a severity.
  */
  def create(ts: TicketSeverity): TicketSeverity = {

    DB.withConnection { implicit conn =>
      val id = insertQuery.on(
        'name     -> ts.name,
        'color    -> ts.color,
        'position -> ts.position
      ).executeInsert()

      this.getById(id.get).get
    }

  }

  /**
   * Delete a severity.
   */
  def delete(id: Long) {
    DB.withConnection { implicit conn =>
      deleteQuery.on(
        'id -> id
      ).execute
    }
  }

  /**
   * Get a severity by id
   */
  def getById(id: Long) : Option[TicketSeverity] = {

    DB.withConnection { implicit conn =>
      getByIdQuery.on('id -> id).as(ticket_severity.singleOpt)
    }
  }

  def getAll: List[TicketSeverity] = {

    DB.withConnection { implicit conn =>
      allQuery.as(ticket_severity.*)
    }
  }

  def list(page: Int = 1, count: Int = 10) : Page[TicketSeverity] = {

      val offset = count * (page - 1)

      DB.withConnection { implicit conn =>
        val tss = listQuery.on(
          'count  -> count,
          'offset -> offset
        ).as(ticket_severity.*)

        val totalRows = listCountQuery.as(scalar[Long].single)

        Page(tss, page, count, totalRows)
      }
  }

  /**
   * Update a severity.
   */
  def update(id: Long, ts: TicketSeverity): Option[TicketSeverity] = {

    DB.withConnection { implicit conn =>
      updateQuery.on(
        'id         -> id,
        'name       -> ts.name,
        'color      -> ts.color,
        'position   -> ts.position
      ).execute
    }
    getById(id)
  }
}
