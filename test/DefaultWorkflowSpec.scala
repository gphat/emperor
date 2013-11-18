package test

import anorm._
import anorm.NotAssigned
import org.joda.time.DateTime
import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._

class DefaultWorkflowSpec extends Specification {

  import models.{TicketStatusModel,WorkflowModel}

  "Default Workflow" should {

    "have a sane starting status" in {
      running(FakeApplication()) {

        // Relies on the default workflow
        val wf = WorkflowModel.getById(1)
        wf must beSome

        val start = WorkflowModel.getStartingStatus(wf.get.id.get)
        start must beSome
      }
    }

    "have the correct number of statuses" in {
      running(FakeApplication()) {

        val statuses = WorkflowModel.getStatuses(1)
        statuses.size mustEqual(3)
      }
    }

    "have nothing before starting status" in {
      running(FakeApplication()) {

        // Relies on the workflow
        val wf = WorkflowModel.getById(1)
        wf must beSome

        val start = WorkflowModel.getStartingStatus(wf.get.id.get)

        val prev = WorkflowModel.getPreviousStatus(start.get.id.get)
        prev must beNone
      }
    }

    "have something after starting status" in {
      running(FakeApplication()) {

        // Relies on the workflow
        val wf = WorkflowModel.getById(1)
        wf must beSome

        val start = WorkflowModel.getStartingStatus(wf.get.id.get)

        val prev = WorkflowModel.getNextStatus(start.get.id.get)
        prev must beSome
      }
    }
  }
}
