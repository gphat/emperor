package test

import anorm._
import anorm.NotAssigned
import org.joda.time.DateTime
import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._

class InvitationModelSpec extends Specification {

  import models.InvitationModel

  "Invitation model" should {

    "create, retrieve, update and delete" in {
      running(FakeApplication()) {

        val inv = models.Invitation(
          email = "test@example.com",
          secret = "ABC123"
        )
        val newInv = InvitationModel.create(inv)
        newInv must beAnInstanceOf[models.Invitation]

        val otherInv = InvitationModel.getById(newInv.id.get)
        otherInv must beSome
        otherInv.get.email must be equalTo("test@example.com")

        val otherInv2 = InvitationModel.getBySecret(newInv.secret)
        otherInv2 must beSome
        otherInv2.get.email must be equalTo("test@example.com")

        InvitationModel.delete(newInv.id.get)
        val goneInv = InvitationModel.getById(newInv.id.get)
        goneInv must beNone
      }
    }

    "accept" in {
      running(FakeApplication()) {

        val inv = models.Invitation(
          email = "test@example.com",
          secret = "ABC123"
        )
        val newInv = InvitationModel.create(inv)
        newInv must beAnInstanceOf[models.Invitation]

        val otherInv = InvitationModel.accept(newInv.secret)
        otherInv must beSome
        otherInv.get.email must be equalTo("test@example.com")
        otherInv.get.dateAccepted must beSome

        InvitationModel.delete(newInv.id.get)
        val goneInv = InvitationModel.getById(newInv.id.get)
        goneInv must beNone
      }
    }
  }
}