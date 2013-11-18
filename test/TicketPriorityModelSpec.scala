package test

import anorm._
import anorm.NotAssigned
import org.joda.time.DateTime
import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._

class TicketPriorityModelSpec extends Specification {

  import models.TicketPriorityModel

  "Ticket Priority model" should {

    "create, retrieve and delete" in {
      running(FakeApplication()) {

        val p = models.TicketPriority(
          name = "Test Priority 1",
          color = "ffffff",
          position = 50,
          dateCreated = new DateTime
        )
        val newPrio = TicketPriorityModel.create(p)
        newPrio must beAnInstanceOf[models.TicketPriority]

        // Get it by id
        val prio = TicketPriorityModel.getById(newPrio.id.get)
        prio must beSome
        prio.get must beAnInstanceOf[models.TicketPriority]

        // // Change it
        val cPrio = prio.get.copy(name = "Test Priority 1!")
        val updatedPrio = TicketPriorityModel.update(cPrio.id.get, cPrio)
        updatedPrio must beSome
        updatedPrio.get.name mustEqual "Test Priority 1!"

        // Nix it
        TicketPriorityModel.delete(newPrio.id.get)
        val gone =  TicketPriorityModel.getById(newPrio.id.get)
        gone must beNone
      }
    }
  }
}
