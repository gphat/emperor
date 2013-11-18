package models

import anorm._
import anorm.SqlParser._
import emp.util.AnormExtension._
import emp.util.Pagination.Page
import org.joda.time.DateTime
import play.api.db.DB
import play.api.Play.current

case class TicketType(id: Pk[Long] = NotAssigned, name: String, color: String, dateCreated: DateTime)

object TicketTypeModel {

  val allQuery = SQL("SELECT * FROM ticket_types")
  val getByIdQuery = SQL("SELECT * FROM ticket_types WHERE id={id}")
  val listQuery = SQL("SELECT * FROM ticket_types LIMIT {count} OFFSET {offset}")
  val listCountQuery = SQL("SELECT count(*) FROM ticket_types")
  val insertQuery = SQL("INSERT INTO ticket_types (name, color) VALUES ({name}, {color})")
  val updateQuery = SQL("UPDATE ticket_types SET name={name}, color={color} WHERE id={id}")
  val deleteQuery = SQL("DELETE FROM ticket_types WHERE id={id}")

  val ticket_type = {
    get[Pk[Long]]("id") ~
    get[String]("name") ~
    get[String]("color") ~
    get[DateTime]("date_created") map {
      case id~name~color~dateCreated => TicketType(
        id = id,
        name = name,
        color = color,
        dateCreated = dateCreated
      )
    }
  }

  /**
   * Create a type.
   */
  def create(tt: TicketType): TicketType = {

    DB.withConnection { implicit conn =>
      val id = insertQuery.on(
        'name   -> tt.name,
        'color  -> tt.color
      ).executeInsert()

      this.getById(id.get).get
    }
  }

  /**
   * Delete a type.
   */
  def delete(id: Long) {
    DB.withConnection { implicit conn =>
      deleteQuery.on('id -> id).execute
    }
  }

  /**
   * Get a type by it's id.
   */
  def getById(id: Long): Option[TicketType] = {

    DB.withConnection { implicit conn =>
      getByIdQuery.on('id -> id).as(ticket_type.singleOpt)
    }
  }

  def getAll: List[TicketType] = {

    DB.withConnection { implicit conn =>
      allQuery.as(ticket_type.*)
    }
  }

  def list(page: Int = 1, count: Int = 10): Page[TicketType] = {

      val offset = count * (page - 1)

      DB.withConnection { implicit conn =>
        val tss = listQuery.on(
          'count  -> count,
          'offset -> offset
        ).as(ticket_type.*)

        val totalRows = listCountQuery.as(scalar[Long].single)

        Page(tss, page, count, totalRows)
      }
  }

  /**
   * Update a type.
   */
  def update(id: Long, ts: TicketType): Option[TicketType] = {

    DB.withConnection { implicit conn =>
      updateQuery.on(
        'id     -> id,
        'name   -> ts.name,
        'color  -> ts.color
      ).execute
      getById(id)
    }
  }
}
