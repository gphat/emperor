package test

import anorm._
import anorm.NotAssigned
import org.joda.time.DateTime
import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._

class TicketSeverityModelSpec extends Specification {

  import models.TicketSeverityModel

  "Ticket Severity model" should {

    "create, retrieve and delete" in {
      running(FakeApplication()) {

        val p = models.TicketSeverity(
          name = "Test Severity 1",
          color = "ffffff",
          position = 50,
          dateCreated = new DateTime
        )
        val newSev = TicketSeverityModel.create(p)
        newSev must beAnInstanceOf[models.TicketSeverity]

        // Get it by id
        val sev = TicketSeverityModel.getById(newSev.id.get)
        sev must beSome
        sev.get must beAnInstanceOf[models.TicketSeverity]

        // // Change it
        val cSev = sev.get.copy(name = "Test Severity 1!")
        val updatedSev = TicketSeverityModel.update(cSev.id.get, cSev)
        updatedSev must beSome
        updatedSev.get.name mustEqual "Test Severity 1!"

        // Nix it
        TicketSeverityModel.delete(newSev.id.get)
        val gone =  TicketSeverityModel.getById(newSev.id.get)
        gone must beNone
      }
    }
  }
}
