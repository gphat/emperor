package test.api

import anorm._
import anorm.NotAssigned
import emp.JsonFormats._
import org.joda.time.DateTime
import org.specs2.mutable._
import play.api.libs.json.Json
import play.api.test._
import play.api.test.Helpers._

class TicketSeverityAPISpec extends Specification {

  import models._

  "Ticket Severity API" should {

    "retrieve all ticket severities" in {
      running(FakeApplication()) {

        val work = WorkflowModel.getById(1) // Assumes the default workflow exists

        val user = UserModel.getById(1).get

        val token = UserTokenModel.create(userId = user.id.get, comment = None)

        val tokenStr = "Token token=" + token.token.get

        // Assume we have the default ticket severities
        val result = route(FakeRequest(GET, "/api/ticketseverity").withHeaders("Authorization" -> tokenStr)).get
        status(result) must equalTo(200)
        contentAsString(result) must contain("TICK_SEV_DIFFICULT")

        UserTokenModel.delete(user.id.get, token.token.get)
        1 mustEqual(1)
      }
    }

    "retrieve ticket severity" in {
      running(FakeApplication()) {

        val work = WorkflowModel.getById(1) // Assumes the default workflow exists

        val user = UserModel.getById(1).get

        val token = UserTokenModel.create(userId = user.id.get, comment = None)

        val tokenStr = "Token token=" + token.token.get

        // Assume we have the default ticket severities
        val result = route(FakeRequest(GET, "/api/ticketseverity/1").withHeaders("Authorization" -> tokenStr)).get
        status(result) must equalTo(200)

        val apiSev = Json.fromJson[TicketSeverity](Json.parse(contentAsString(result))).asOpt
        apiSev must beSome
        apiSev.get.name must beEqualTo("TICK_SEV_DIFFICULT")

        UserTokenModel.delete(user.id.get, token.token.get)
        1 mustEqual(1)
      }
    }
  }
}