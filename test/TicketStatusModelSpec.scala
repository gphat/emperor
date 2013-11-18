package test

import anorm._
import anorm.NotAssigned
import org.joda.time.DateTime
import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._

class TicketStatusModelSpec extends Specification {

  import models.TicketStatusModel

  "Ticket Status model" should {

    "create, retrieve and delete" in {
      running(FakeApplication()) {

        val s = models.TicketStatus(
          name = "Ticket Status 1",
          dateCreated = new DateTime
        )
        val newStatus = TicketStatusModel.create(s)
        newStatus must beAnInstanceOf[models.TicketStatus]

        // Get it by id
        val status = TicketStatusModel.getById(newStatus.id.get)
        status must beSome
        status.get must beAnInstanceOf[models.TicketStatus]

        // // Change it
        val cStatus = status.get.copy(name = "Test Status 1!")
        val updatedStatus = TicketStatusModel.update(cStatus.id.get, cStatus)
        updatedStatus must beSome
        updatedStatus.get.name mustEqual "Test Status 1!"

        // Nix it
        TicketStatusModel.delete(newStatus.id.get)
        val gone =  TicketStatusModel.getById(newStatus.id.get)
        gone must beNone
      }
    }
  }
}
