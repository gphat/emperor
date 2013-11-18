package test

import anorm._
import anorm.NotAssigned
import org.joda.time.DateTime
import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._

class UserModelSpec extends Specification {

  import models.{OrganizationModel,UserModel}

  "User model" should {

    "create, retrieve and delete" in {
      running(FakeApplication()) {

        val o = models.Organization(
          name = "Test Org 1"
        )
        val newOrg = OrganizationModel.create(o)

        val iu = models.User(
          organizationId = newOrg.id.get,
          username = "test@example.com",
          password = "1234",
          realName = "Test User",
          timezone = "America/Chicago",
          location = None,
          title    = None,
          url      = None,
          dateCreated = new DateTime
        )
        val newUser = UserModel.create(iu)
        newUser must beAnInstanceOf[models.User]

        // Get it by id
        val user = UserModel.getById(newUser.id.get)
        user must beSome
        user.get must beAnInstanceOf[models.User]

        // // Change it
        val cUser = models.User(
          organizationId = newOrg.id.get,
          username = "test@example.com",
          password = "1234",
          realName = "Testy User",
          timezone = "America/Chicago",
          location = None,
          title    = None,
          url      = None,
          dateCreated = new DateTime
        )
        val updatedUser = UserModel.update(newUser.id.get, cUser)
        updatedUser must beSome
        updatedUser.get must beAnInstanceOf[models.User]
        updatedUser.get.realName mustEqual "Testy User"

        // Nix it
        UserModel.delete(newUser.id.get)
        val goneUser =  UserModel.getById(newUser.id.get)
        OrganizationModel.delete(newOrg.id.get)
        goneUser must beNone
      }
    }
  }
}