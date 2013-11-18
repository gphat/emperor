package models

import anorm._
import anorm.SqlParser._
import emp.util.AnormExtension._
import emp.util.Pagination.Page
import org.joda.time.DateTime
import play.api.db.DB
import play.api.Play.current

case class TicketPriority(
  id: Pk[Long] = NotAssigned,
  name: String,
  color: String,
  position: Int,
  dateCreated: DateTime
)

object TicketPriorityModel {

  val allQuery = SQL("SELECT * FROM ticket_priorities ORDER BY position ASC")
  val getByIdQuery = SQL("SELECT * FROM ticket_priorities WHERE id={id}")
  val listQuery = SQL("SELECT * FROM ticket_priorities ORDER BY position ASC LIMIT {count} OFFSET {offset}")
  val listCountQuery = SQL("SELECT count(*) FROM ticket_priorities")
  val insertQuery = SQL("INSERT INTO ticket_priorities (name, color, position) VALUES ({name}, {color}, {position})")
  val updateQuery = SQL("UPDATE ticket_priorities SET name={name}, color={color}, position={position} WHERE id={id}")
  val deleteQuery = SQL("DELETE FROM ticket_priorities WHERE id={id}")

  val ticket_priority = {
    get[Pk[Long]]("id") ~
    get[String]("name") ~
    get[String]("color") ~
    get[Int]("position") ~
    get[DateTime]("date_created") map {
      case id~name~color~position~dateCreated => TicketPriority(
        id = id,
        name = name,
        color = color,
        position = position,
        dateCreated = dateCreated
      )
    }
  }

  /**
   * Create a priority.
   */
  def create(tp: TicketPriority): TicketPriority = {

    DB.withConnection { implicit conn =>
      val id = insertQuery.on(
        'name     -> tp.name,
        'color    -> tp.color,
        'position -> tp.position
      ).executeInsert()

      this.getById(id.get).get
    }
  }

  /**
   * Delete a priority.
   */
  def delete(id: Long) {
    DB.withConnection { implicit conn =>
      deleteQuery.on(
        'id -> id
      ).execute
    }
  }

  /**
   * Get a priority by id.
   */
  def getById(id: Long) : Option[TicketPriority] = {

    DB.withConnection { implicit conn =>
      getByIdQuery.on('id -> id).as(ticket_priority.singleOpt)
    }
  }

  def getAll: List[TicketPriority] = {

    DB.withConnection { implicit conn =>
      allQuery.as(ticket_priority.*)
    }
  }

  def list(page: Int = 1, count: Int = 10) : Page[TicketPriority] = {

      val offset = count * (page - 1)

      DB.withConnection { implicit conn =>
        val tps = listQuery.on(
          'count  -> count,
          'offset -> offset
        ).as(ticket_priority.*)

        val totalRows = listCountQuery.as(scalar[Long].single)

        Page(tps, page, count, totalRows)
      }
  }

  /**
   * Update a priority.
   */
  def update(id: Long, tp: TicketPriority): Option[TicketPriority] = {

    DB.withConnection { implicit conn =>
      updateQuery.on(
        'id         -> id,
        'name       -> tp.name,
        'color      -> tp.color,
        'position   -> tp.position
      ).execute
      getById(id)
    }
  }
}
