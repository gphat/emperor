package models

import anorm._
import anorm.SqlParser._
import emp.util.AnormExtension._
import emp._
import org.joda.time.DateTime
import play.api.db.DB
import play.Logger
import play.api.Play.current

/**
 * Class for events.
 */
case class Event(
  id: String,
  projectId: Long,
  projectName: String,
  userId: Long,
  userRealName: String,
  username: String,
  userEmailDigest: String,
  eKey: String,
  eType: String,
  content: String,
  url: String,
  dateCreated: DateTime
)

object EventModel {

}
