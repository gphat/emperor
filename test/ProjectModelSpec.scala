package test

import anorm._
import anorm.NotAssigned
import org.joda.time.DateTime
import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._

class ProjectModelSpec extends Specification {

  import models.{ProjectModel,WorkflowModel}

  "Project model" should {

    "recognize valid keys" in {
      ProjectModel.isValidKey("FOO") must beTrue // ASCII
      ProjectModel.isValidKey("ÎR") must beTrue // Unicode
      ProjectModel.isValidKey("1OO") must beFalse // Can't start with numbers
      ProjectModel.isValidKey("") must beFalse // Can't be empty
      ProjectModel.isValidKey("1234") must beFalse // Can't be all digits
    }

    "create, retrieve and delete" in {
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
        newProject must beAnInstanceOf[models.Project]

        // Get it by id
        val proj = ProjectModel.getById(newProject.id.get)
        proj must beSome
        proj.get must beAnInstanceOf[models.Project]

        // Change it
        val cProj = models.Project(
          id = proj.get.id,
          key = "TEST1",
          workflowId = proj.get.workflowId,
          name = "Test Project 1!",
          ownerId = proj.get.ownerId,
          permissionSchemeId = 1,
          defaultPriorityId = proj.get.defaultPriorityId,
          defaultSeverityId = proj.get.defaultSeverityId,
          defaultTypeId = proj.get.defaultTypeId,
          defaultAssignee = proj.get.defaultAssignee,
          dateCreated = new DateTime
        )
        val updateProj = ProjectModel.update(proj.get.id.get, cProj)
        updateProj must beSome
        updateProj.get.name mustEqual "Test Project 1!"

        // Nix it
        ProjectModel.delete(newProject.id.get)
        val gone =  ProjectModel.getById(newProject.id.get)
        gone must beNone
      }
    }

    "handle sequences" in {
      running(FakeApplication()) {

        val work = WorkflowModel.getById(1) // Assumes the default workflow exists

        val p = models.Project(
          name = "Test Project 2",
          key = "TEST2",
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

        // Verify it increments
        val neyext = ProjectModel.getNextSequence(newProject.id.get)
        neyext mustEqual(1)

        ProjectModel.delete(newProject.id.get)
        1 mustEqual(1)
      }
    }
  }
}
