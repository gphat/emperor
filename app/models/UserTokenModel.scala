package models

import anorm._
import anorm.SqlParser._
import emp.util.AnormExtension._
import emp.util.Pagination.Page
import java.util.UUID
import org.joda.time.DateTime
import play.api.db.DB
import play.api.Play.current

case class UserToken(
  token: Pk[String] = NotAssigned,
  userId: Long,
  comment: Option[String],
  dateCreated: DateTime
)

object UserTokenModel {

  val allQuery = SQL("SELECT * FROM user_tokens")
  val getByIdQuery = SQL("SELECT * FROM user_tokens WHERE token={token}")
  val getByIdAndUserQuery = SQL("SELECT * FROM user_tokens WHERE token={token} AND user_id={user_id")
  val getByUserIdQuery = SQL("SELECT * FROM user_tokens WHERE user_id={user_id}")
  val listQuery = SQL("SELECT * FROM user_tokens ORDER BY date_created LIMIT {count} OFFSET {offset}")
  val listCountQuery = SQL("SELECT count(*) FROM user_tokens")
  val listUserCountQuery = SQL("SELECT count(*) FROM user_tokens WHERE user_id={user_id}")
  val insertQuery = SQL("INSERT INTO user_tokens (token, user_id, comment) VALUES ({token}, {user_id}, {comment})")
  val deleteQuery = SQL("DELETE FROM user_tokens WHERE user_id={user_id} AND token={token}")

  val userToken = {
    get[Pk[String]]("token") ~
    get[Long]("user_id") ~
    get[Option[String]]("comment") ~
    get[DateTime]("date_created") map {
      case token~userId~comment~dateCreated => UserToken(token, userId, comment, dateCreated)
    }
  }

  /**
   * Add a user_token.
   */
  def create(userId: Long, comment: Option[String]): UserToken = {

    val tokenString = UUID.randomUUID.toString.replaceAll("-", "")

    DB.withConnection { implicit conn =>
      insertQuery.on(
        'token    -> tokenString,
        'user_id  -> userId,
        'comment  -> comment
      ).execute()

      this.getById(tokenString).get
    }
  }

  /**
   * Delete a user token. Returns the deleted token, if found
   */
  def delete(userId: Long, token: String): Option[UserToken] = {
    DB.withConnection { implicit conn =>
      val maybeT = this.getByIdAndUser(userId, token)
      maybeT.map({ t =>
        deleteQuery.on(
          'user_id  -> t.userId,
          'token    -> t.token
        ).execute
      })
      maybeT
    }
  }

  /**
   * Retrieve a user token by token.
   */
  def getById(token: String) : Option[UserToken] = {

    DB.withConnection { implicit conn =>
      getByIdQuery.on('token -> token).as(userToken.singleOpt)
    }
  }

  /**
   * Retrieve a user token by token and userId.
   */
  def getByIdAndUser(userId: Long, token: String) : Option[UserToken] = {

    DB.withConnection { implicit conn =>
      getByIdQuery.on(
        'user_id  -> userId,
        'token    -> token
      ).as(userToken.singleOpt)
    }
  }


  def getAll: List[UserToken] = {

    DB.withConnection { implicit conn =>
      allQuery.as(userToken.*)
    }
  }

  def getByUser(userId: Long) : Page[UserToken] = {

    DB.withConnection { implicit conn =>
      val tokens = getByUserIdQuery.on('user_id -> userId).as(userToken.*)

      val totalRows = listUserCountQuery.on('user_id -> userId).as(scalar[Long].single)

      Page(tokens, 1, 100, totalRows)
    }
  }

  def list(page: Int = 1, count: Int = 10) : Page[UserToken] = {

      val offset = count * (page - 1)

      DB.withConnection { implicit conn =>
        val userTokens = listQuery.on(
          'count  -> count,
          'offset -> offset
        ).as(userToken.*)

        val totalRows = listCountQuery.as(scalar[Long].single)

        Page(userTokens, page, count, totalRows)
      }
  }
}