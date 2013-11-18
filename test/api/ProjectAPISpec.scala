package test.api

import anorm._
import anorm.NotAssigned
import emp.JsonFormats._
import org.joda.time.DateTime
import org.specs2.mutable._
import play.api.libs.json.Json
import play.api.test._
import play.api.test.Helpers._

class ProjectAPISpec extends Specification {

  import models._

  "Project API" should {

    "retrieve project and other sundries" in {
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

        val result2 = route(FakeRequest( GET, "/api/project").withHeaders("Authorization" -> tokenStr)).get
        status(result2) must equalTo(200)

        val result = route(FakeRequest( GET, "/api/project/" + newProject.id.get).withHeaders("Authorization" -> tokenStr)).get
        status(result) must equalTo(200)

        val apiProj = Json.fromJson[Project](Json.parse(contentAsString(result)))

        val result3 = route(FakeRequest( GET, "/api/project/" + newProject.id.get + "/assignees").withHeaders("Authorization" -> tokenStr)).get
        status(result3) must equalTo(200)
        contentAsString(result3) must contain("admin")

        UserTokenModel.delete(user.id.get, token.token.get)
        ProjectModel.delete(newProject.id.get)
        1 mustEqual(1)
      }
    }

  }
}
