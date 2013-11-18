package models

import anorm._
import anorm.SqlParser._
import emp.util.AnormExtension._
import emp.util.Pagination.Page
import org.joda.time.DateTime
import play.api.db.DB
import play.api.Play.current

case class TicketStatus(id: Pk[Long] = NotAssigned, name: String, dateCreated: DateTime)

object TicketStatusModel {

  val allQuery = SQL("SELECT * FROM ticket_statuses")
  val getByIdQuery = SQL("SELECT * FROM ticket_statuses WHERE id={id}")
  val listQuery = SQL("SELECT * FROM ticket_statuses LIMIT {count} OFFSET {offset}")
  val listCountQuery = SQL("SELECT count(*) FROM ticket_statuses")
  val insertQuery = SQL("INSERT INTO ticket_statuses (name) VALUES ({name})")
  val updateQuery = SQL("UPDATE ticket_statuses SET name={name} WHERE id={id}")
  val deleteQuery = SQL("DELETE FROM ticket_statuses WHERE id={id}")

  val ticket_status = {
    get[Pk[Long]]("id") ~
    get[String]("name") ~
    get[DateTime]("date_created") map {
      case id~name~dateCreated => TicketStatus(id, name, dateCreated)
    }
  }

  /**
   * Create a ticket status.
   */
  def create(ts: TicketStatus): TicketStatus = {

    DB.withConnection { implicit conn =>
      val id = insertQuery.on(
        'name   -> ts.name
      ).executeInsert()

      this.getById(id.get).get
    }
  }

  /**
   * Delete the ticket status.
   */
  def delete(id: Long) {
    DB.withConnection { implicit conn =>
      deleteQuery.on('id -> id).execute
    }
  }

  /**
   * Get a ticket status by id.
   */
  def getById(id: Long) : Option[TicketStatus] = {

    DB.withConnection { implicit conn =>
      getByIdQuery.on('id -> id).as(ticket_status.singleOpt)
    }
  }

  def getAll: List[TicketStatus] = {

    DB.withConnection { implicit conn =>
      allQuery.as(ticket_status.*)
    }
  }

  def list(page: Int = 1, count: Int = 10) : Page[TicketStatus] = {

      val offset = count * (page - 1)

      DB.withConnection { implicit conn =>
        val tss = listQuery.on(
          'count  -> count,
          'offset -> offset
        ).as(ticket_status.*)

        val totalRows = listCountQuery.as(scalar[Long].single)

        Page(tss, page, count, totalRows)
      }
  }

  /**
   * Update a ticket status.
   */
  def update(id: Long, ts: TicketStatus): Option[TicketStatus] = {

    DB.withConnection { implicit conn =>
      updateQuery.on(
        'id         -> id,
        'name       -> ts.name
      ).execute
      getById(id)
    }
  }
}