package test.api

import anorm._
import anorm.NotAssigned
import emp.JsonFormats._
import org.joda.time.DateTime
import org.specs2.mutable._
import play.api.libs.json.Json
import play.api.test._
import play.api.test.Helpers._

class TicketPriorityAPISpec extends Specification {

  import models._

  "Ticket Priority API" should {

    "retrieve all ticket priorities" in {
      running(FakeApplication()) {

        val work = WorkflowModel.getById(1) // Assumes the default workflow exists

        val user = UserModel.getById(1).get

        val token = UserTokenModel.create(userId = user.id.get, comment = None)

        val tokenStr = "Token token=" + token.token.get

        // Assume we have the default ticket priorities
        val result = route(FakeRequest(GET, "/api/ticketpriority").withHeaders("Authorization" -> tokenStr)).get
        status(result) must equalTo(200)
        contentAsString(result) must contain("TICK_PRIO_HIGH")

        UserTokenModel.delete(user.id.get, token.token.get)
        1 mustEqual(1)
      }
    }

    "retrieve ticket priority" in {
      running(FakeApplication()) {

        val work = WorkflowModel.getById(1) // Assumes the default workflow exists

        val user = UserModel.getById(1).get

        val token = UserTokenModel.create(userId = user.id.get, comment = None)

        val tokenStr = "Token token=" + token.token.get

        // Assume we have the default ticket priorities
        val result = route(FakeRequest(GET, "/api/ticketpriority/1").withHeaders("Authorization" -> tokenStr)).get
        status(result) must equalTo(200)

        val apiPrio = Json.fromJson[TicketPriority](Json.parse(contentAsString(result))).asOpt
        apiPrio must beSome
        apiPrio.get.name must beEqualTo("TICK_PRIO_HIGH")

        UserTokenModel.delete(user.id.get, token.token.get)
        1 mustEqual(1)
      }
    }
  }
}