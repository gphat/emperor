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

class TicketLinkAPISpec extends Specification {

  import models._

  "Ticket API" should {

    "handle link lifecycle" in {
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

        // Assume we have the default ticket priority, severity and type
        val result1 = route(FakeRequest(
          POST,
          "/api/project/" + newProject.id.get.toString + "/ticket",
          FakeHeaders(),
          Json.toJson(Map(
            "typeId" -> JsNumber(1), // Assumes default types are present
            "priorityId" -> JsNumber(1), // ^
            "severityId" -> JsNumber(1), // ^
            "summary" -> JsString("A ticket!")
          ))
        ).withHeaders("Authorization" -> tokenStr)).get
        status(result1) must equalTo(200)

        val apiTick1 = Json.fromJson[FullTicket](Json.parse(contentAsString(result1))).asOpt

        // Assume we have the default ticket priority, severity and type
        val result2 = route(FakeRequest(
          POST,
          "/api/project/" + newProject.id.get.toString + "/ticket",
          FakeHeaders(),
          Json.toJson(Map(
            "typeId" -> JsNumber(1), // Assumes default types are present
            "priorityId" -> JsNumber(1), // ^
            "severityId" -> JsNumber(1), // ^
            "summary" -> JsString("Another ticket!")
          ))
        ).withHeaders("Authorization" -> tokenStr)).get
        status(result2) must equalTo(200)

        val apiTick2 = Json.fromJson[FullTicket](Json.parse(contentAsString(result2))).asOpt

        // Verify no links are present
        val noLinks = route(FakeRequest(
        	GET,
        	"/api/ticket/" + apiTick1.get.ticketId + "/link"
        ).withHeaders("Authorization" -> tokenStr)).get
        contentAsString(noLinks) must be equalTo("[]")

        // Make a link
        val makeLink = route(FakeRequest(
        	PUT,
        	"/api/ticket/" + apiTick1.get.ticketId + "/link",
        	FakeHeaders(),
        	Json.toJson(Map(
        		"ticket_ids" -> JsString(apiTick2.get.ticketId),
        		"link_type_id" -> JsNumber(1)
        	))
        ).withHeaders("Authorization" -> tokenStr)).get
        status(makeLink) must equalTo(200)
        val fullLink = Json.fromJson[FullLink](Json.parse(contentAsString(makeLink))).asOpt

        // Verify a link
        val someLinks = route(FakeRequest(
        	GET,
        	"/api/ticket/" + apiTick1.get.ticketId + "/link"
        ).withHeaders("Authorization" -> tokenStr)).get
        contentAsString(someLinks) must contain("A ticket!")
        contentAsString(someLinks) must contain("Another ticket!")

        // Remove the link
        val delLink = route(FakeRequest(
        	DELETE,
        	"/api/ticket/" + apiTick1.get.ticketId + "/link/" + fullLink.get.id.get
        ).withHeaders("Authorization" -> tokenStr)).get
        status(delLink) must equalTo(200)

        TicketModel.delete(apiTick1.get.id.get)
        TicketModel.delete(apiTick2.get.id.get)
        ProjectModel.delete(newProject.id.get)
        UserTokenModel.delete(user.id.get, token.token.get)
        1 mustEqual(1)
      }
    }
  }
}