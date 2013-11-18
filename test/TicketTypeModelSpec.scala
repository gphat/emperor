package test

import anorm._
import anorm.NotAssigned
import org.joda.time.DateTime
import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._

class TicketTypeModelSpec extends Specification {

  import models.TicketTypeModel

  "Ticket Type model" should {

    "create, retrieve and delete" in {
      running(FakeApplication()) {

        val t = models.TicketType(
          name = "Test Type 1",
          color = "ffffff",
          dateCreated = new DateTime
        )
        val newType = TicketTypeModel.create(t)
        newType must beAnInstanceOf[models.TicketType]

        // Get it by id
        val ttype = TicketTypeModel.getById(newType.id.get)
        ttype must beSome
        ttype.get must beAnInstanceOf[models.TicketType]

        // // Change it
        val cType = ttype.get.copy(name = "Test Type 1!")
        val updatedType = TicketTypeModel.update(cType.id.get, cType)
        updatedType must beSome
        updatedType.get.name mustEqual "Test Type 1!"

        // Nix it
        TicketTypeModel.delete(newType.id.get)
        val gone =  TicketTypeModel.getById(newType.id.get)
        gone must beNone
      }
    }
  }
}
