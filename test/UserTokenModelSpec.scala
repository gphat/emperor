package test

import anorm._
import anorm.NotAssigned
import org.joda.time.DateTime
import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._

class UserTokenModelSpec extends Specification {

  import models.{OrganizationModel,UserModel,UserTokenModel}

  "User Token model" should {

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

        val token = UserTokenModel.create(userId = newUser.id.get, comment = None)
        token must beAnInstanceOf[models.UserToken]

        val eToken = UserTokenModel.getById(token.token.get)
        eToken must beSome
        eToken.get must beAnInstanceOf[models.UserToken]
        eToken.get.token.get must beEqualTo(token.token.get)

        val uToken = UserTokenModel.getByIdAndUser(userId = newUser.id.get, token = token.token.get)
        uToken must beSome
		    uToken.get must beAnInstanceOf[models.UserToken]
        uToken.get.token.get must beEqualTo(token.token.get)

        UserTokenModel.delete(userId = newUser.id.get, token = token.token.get)
        UserModel.delete(newUser.id.get)
        OrganizationModel.delete(newOrg.id.get)
        val goneUser =  UserModel.getById(newUser.id.get)
        goneUser must beNone
      }
    }
  }
}