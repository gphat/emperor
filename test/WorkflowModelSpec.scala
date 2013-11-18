package test

import anorm._
import anorm.NotAssigned
import org.joda.time.DateTime
import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._

class WorkflowModelSpec extends Specification {

  import models.WorkflowModel

  "Workflow model" should {

    "create, retrieve and delete" in {
      running(FakeApplication()) {

        val w = models.Workflow(
          name = "Test Workflow 1",
          description = None,
          dateCreated = new DateTime
        )
        val newWork = WorkflowModel.create(w)
        newWork must beAnInstanceOf[models.Workflow]

        // Get it by id
        val work = WorkflowModel.getById(newWork.id.get)
        work must beSome
        work.get must beAnInstanceOf[models.Workflow]

        // // Change it
        val cWork = work.get.copy(name = "Test Workflow 1!")
        val updatedWork = WorkflowModel.update(cWork.id.get, cWork)
        updatedWork must beSome
        updatedWork.get.name mustEqual "Test Workflow 1!"

        // Nix it
        WorkflowModel.delete(newWork.id.get)
        val goneWork =  WorkflowModel.getById(newWork.id.get)
        goneWork must beNone
      }
    }
  }
}
