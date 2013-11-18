package test

import anorm._
import anorm.NotAssigned
import org.joda.time.DateTime
import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._

class TicketResolutionModelSpec extends Specification {

  import models.TicketResolutionModel

  "Ticket Resolution model" should {

    "create, retrieve and delete" in {
      running(FakeApplication()) {

        val p = models.TicketResolution(
          name = "Test Resolution 1",
          dateCreated = new DateTime
        )
        val newPrio = TicketResolutionModel.create(p)
        newPrio must beAnInstanceOf[models.TicketResolution]

        // Get it by id
        val prio = TicketResolutionModel.getById(newPrio.id.get)
        prio must beSome
        prio.get must beAnInstanceOf[models.TicketResolution]

        // // Change it
        val cPrio = prio.get.copy(name = "Test Resolution 1!")
        val updatedPrio = TicketResolutionModel.update(cPrio.id.get, cPrio)
        updatedPrio must beSome
        updatedPrio.get.name mustEqual "Test Resolution 1!"

        // Nix it
        TicketResolutionModel.delete(newPrio.id.get)
        val gone =  TicketResolutionModel.getById(newPrio.id.get)
        gone must beNone
      }
    }
  }
}
