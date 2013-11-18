package models

import anorm._
import anorm.SqlParser._
import emp.util.AnormExtension._
import emp.event._
import emp.util.Pagination.Page
import java.util.UUID
import org.joda.time.DateTime
import org.apache.commons.codec.digest.DigestUtils
import org.mindrot.jbcrypt.BCrypt
import play.api.cache.Cache
import play.api.db.DB
import play.api.i18n.Messages
import play.api.Play.current

case class User(
  id: Pk[Long] = NotAssigned,
  username: String,
  password: String,
  realName: String,
  timezone: String,
  location: Option[String] = None,
  title: Option[String] = None,
  url: Option[String] = None,
  active: Boolean = true,
  admin: Boolean = false,
  forgotPassword: Option[String] = None,
  dateCreated: DateTime = DateTime.now
) {

  def isAnonymous = username.equals("anonymous")
}

case class ForgotUser(username: String)

case class LoginUser(username: String, password: String)

case class NewPassword(password: String, password2: String)

object UserModel {

  val allQuery = SQL("SELECT * FROM users")
  val getAllAssignableQuery = SQL("SELECT * FROM users WHERE active=true")
  val getByForgotQuery = SQL("SELECT * FROM users WHERE forgot_password={forgot_password} AND active=true")
  val getByIdQuery = SQL("SELECT * FROM users WHERE id={id}")
  val getByUsernameQuery = SQL("SELECT * FROM users WHERE username={username} AND active=true")
  val getIdByUsernameQuery = SQL("SELECT id FROM users WHERE username={username} AND active=true")
  val listQuery = SQL("SELECT * FROM users ORDER BY username LIMIT {count} OFFSET {offset}")
  val listCountQuery = SQL("SELECT count(*) FROM users")
  val insertQuery = SQL("INSERT INTO users (username, password, realname, timezone, location, title, url, admin) VALUES ({username}, {password}, {realname}, {timezone}, {location}, {title}, {url}, {admin})")
  val startsWithQuery = SQL("SELECT * FROM users WHERE username LIKE {username}")
  val updateQuery = SQL("UPDATE users SET username={username}, realname={realname}, timezone={timezone}, location={location}, title={title}, url={url}, admin={admin} WHERE id={id}")
  val updatePassQuery = SQL("UPDATE users SET password={password} WHERE id={id}")
  val deleteQuery = SQL("UPDATE users SET active=false WHERE id={id}")
  val addForgotPasswordQuery = SQL("UPDATE users SET forgot_password={forgot_password} WHERE id={id}")
  val clearForgotPasswordQuery = SQL("UPDATE users SET forgot_password=NULL WHERE id={id}")

  val user = {
    get[Pk[Long]]("id") ~
    get[String]("username") ~
    get[String]("password") ~
    get[String]("realName") ~
    get[String]("timezone") ~
    get[Option[String]]("location") ~
    get[Option[String]]("title") ~
    get[Option[String]]("url") ~
    get[Boolean]("active") ~
    get[Boolean]("admin") ~
    get[Option[String]]("forgot_password") ~
    get[DateTime]("date_created") map {
      case id~username~password~realName~timezone~location~title~url~active~admin~forgotPassword~dateCreated => User(id, username, password, realName, timezone, location, title, url, active, admin, forgotPassword, dateCreated)
    }
  }

  /**
   * Add a user.
   */
  def create(user: User): User = {

    DB.withConnection { implicit conn =>
      val id = insertQuery.on(
        'username   -> user.username,
        'password   -> BCrypt.hashpw(user.password, BCrypt.gensalt(12)),
        'realname   -> user.realName,
        'location   -> user.location,
        'title      -> user.title,
        'url        -> user.url,
        'timezone   -> user.timezone,
        'admin      -> user.admin
      ).executeInsert()

      id.map { uid =>
        EmperorEventBus.publish(
          NewUserEvent(
            userId = uid
          )
        )
      }

      this.getById(id.get).get
    }
  }

  /**
   * Delete a user.
   */
  def delete(id: Long) {
    DB.withConnection { implicit conn =>
      deleteQuery.on(
        'id -> id
      ).execute
    }
  }

  def generateForgotPassword(id: Long): String = {
    val token = UUID.randomUUID.toString.replaceAll("-", "")
    DB.withConnection { implicit conn =>
      addForgotPasswordQuery.on(
        'forgot_password -> token,
        'id -> id
      ).execute
    }
    // Put it on the bus!
    EmperorEventBus.publish(
      ForgotPasswordEvent(
        userId = id
      )
    )

    token
  }

  /**
   * Retrieve a user by id.
   */
  def getById(id: Long) : Option[User] = {
    // Cache user info for 30 seconds, saving a bunch of queries for AJAX and whatnot
    Cache.getOrElse[Option[User]]("User-getById-" + id, 30) {
      DB.withConnection { implicit conn =>
        getByIdQuery.on('id -> id).as(user.singleOpt)
      }
    }
  }

  def getAll: List[User] = {

    DB.withConnection { implicit conn =>
      allQuery.as(user.*)
    }
  }

  def getAssignable(includeNobody: Boolean = true): List[User] = {

    val users = DB.withConnection { implicit conn =>
      getAllAssignableQuery.as(user.*)
    }

    if(includeNobody) {
      User(
        id       = NotAssigned,
        username = "",
        password = "",
        realName = Messages("ticket.unassigned"),
        timezone = "",
        location = None,
        title    = None,
        url      = None,
        dateCreated = new DateTime()
      ) +: users
    } else {
      users
    }
  }

  def getByUsername(username: String) : Option[User] = {

    DB.withConnection { implicit conn =>
      getByUsernameQuery.on(
        'username -> username
      ).as(UserModel.user.singleOpt)
    }
  }

  def getByForgotPassword(token: String) : Option[User] = {

    DB.withConnection { implicit conn =>
      getByForgotQuery.on(
        'forgot_password -> token
      ).as(UserModel.user.singleOpt)
    }
  }

  def getIdByUsername(username: String) : Option[Long] = {

    DB.withConnection { implicit conn =>
      getIdByUsernameQuery.on(
        'username -> username
      ).as(scalar[Long].singleOpt)
    }
  }

  /**
   * Find all users starting with a specific string. Used for
   * autocomplete.
   */
  def getStartsWith(query: String) : Seq[User] = {

    val likeQuery = query + "%"

    DB.withConnection { implicit conn =>
      startsWithQuery.on(
        'username -> likeQuery
      ).as(user.*)
    }
  }

  def list(page: Int = 1, count: Int = 10) : Page[User] = {

      val offset = count * (page - 1)

      DB.withConnection { implicit conn =>
        val users = listQuery.on(
          'count  -> count,
          'offset -> offset
        ).as(user.*)

        val totalRows = listCountQuery.as(scalar[Long].single)

        Page(users, page, count, totalRows)
      }
  }

  def update(id: Long, user: User): Option[User] = {

    DB.withConnection { implicit conn =>
      updateQuery.on(
        'id         -> id,
        'username   -> user.username,
        'realname   -> user.realName,
        'location   -> user.location,
        'title      -> user.title,
        'url        -> user.url,
        'timezone   -> user.timezone,
        'admin      -> user.admin
      ).execute
      getById(id)
    }
  }

  def updatePassword(id: Long, np: String) = {

    val hashedPass = BCrypt.hashpw(np, BCrypt.gensalt(12))

    DB.withTransaction { implicit conn =>
      updatePassQuery.on(
        'id         -> id,
        'password   -> hashedPass
      ).executeUpdate
      clearForgotPasswordQuery.on(
        'id -> id
      ).executeUpdate
    }
  }
}