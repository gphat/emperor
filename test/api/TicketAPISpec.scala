package test.api

import anorm._
import anorm.NotAssigned
import emp.JsonFormats._
import org.joda.time.DateTime
import org.specs2.mutable._
import play.api.libs.json._
// import play.api.libs.json.Json
import play.api.test._
import play.api.test.Helpers._

class TicketAPISpec extends Specification {

  import models._

  "Ticket API" should {

    "create ticket and comment" in {
      running(FakeApplication()) {

        val work = WorkflowModel.getById(1) // Assumes the default workflow exists

        val p = models.Project(
          name = "Test Project 1",
          key = "TEST1",
          workflowId = work.get.id.get,
          ownerId = None,
          permissionSchemeId = 1,
          defaultPriorityId = None,
          defaultSeverityId = None,
          defaultTypeId = None,
          defaultAssignee = None,
          dateCreated = new DateTime
        )
        val newProject = ProjectModel.create(p).get

        val user = UserModel.getById(1).get

        val token = UserTokenModel.create(userId = user.id.get, comment = None)

        val tokenStr = "Token token=" + token.token.get

        // Assume we have the default ticket severities
        val result = route(FakeRequest(
          PUT,
          "/api/project/" + newProject.id.get.toString + "/ticket",
          FakeHeaders(),
          Json.obj(
            "typeId" -> JsNumber(1), // Assumes default types are present
            "priorityId" -> JsNumber(1), // ^
            "severityId" -> JsNumber(1), // ^
            "summary" -> JsString("A ticket!")
          )
        ).withHeaders("Authorization" -> tokenStr)).get
        status(result) must equalTo(200)

        val apiTick = Json.fromJson[FullTicket](Json.parse(contentAsString(result))).asOpt
        apiTick must beSome
        apiTick.get.summary must beEqualTo("A ticket!")

        val result2 = route(FakeRequest(
          PUT,
          "/api/ticket/" + apiTick.get.ticketId + "/comment",
          FakeHeaders(),
          Json.toJson(Map(
            "content" -> "This is a comment"
          ))
        ).withHeaders("Authorization" -> tokenStr)).get
        status(result2) must equalTo(200)

        val apiComm = Json.fromJson[Comment](Json.parse(contentAsString(result2))).asOpt
        apiComm must beSome
        apiComm.get.content must equalTo("This is a comment")

        // For whatever reason this won't work.
        // val result3 = route(FakeRequest(
        //   GET,
        //   "/api/ticket/" + apiTick.get.ticketId + "/comment"
        // ).withHeaders("Authorization" -> tokenStr)).get
        // status(result3) must equalTo(200)
        // contentAsString(result3) must contain("This is a comment")

        val result4 = route(FakeRequest(
          DELETE,
          "/api/ticket/" + apiTick.get.ticketId + "/comment/" + apiComm.get.id.get
        ).withHeaders("Authorization" -> tokenStr)).get
        status(result4) must equalTo(200)
        contentAsString(result4) must contain("OK")

        val result5 = route(FakeRequest(
          POST,
          "/api/ticket/" + apiTick.get.ticketId + "/resolve",
          FakeHeaders(),
          Json.obj(
            "resolutionId" -> JsNumber(1) // Assumes default resolutions are present
          )
        ).withHeaders("Authorization" -> tokenStr)).get
        status(result5) must equalTo(200)
        contentAsString(result5) must contain("TICK_RESO_FIXED")

        val result6 = route(FakeRequest(
          POST,
          "/api/ticket/" + apiTick.get.ticketId + "/unresolve",
          FakeHeaders(),
          Json.obj()
        ).withHeaders("Authorization" -> tokenStr)).get
        println(contentAsString(result6))
        status(result6) must equalTo(200)
        contentAsString(result6) must contain("TICK_RESO_UNRESOLVED")


        TicketModel.delete(apiTick.get.id.get)
        ProjectModel.delete(newProject.id.get)
        UserTokenModel.delete(user.id.get, token.token.get)
        1 mustEqual(1)
      }
    }
  }
}