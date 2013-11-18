package test

import anorm._
import anorm.NotAssigned
import org.joda.time.DateTime
import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._

class OrganizationModelSpec extends Specification {

  import models.OrganizationModel

  "Organization model" should {

    "create, retrieve and delete" in {
      running(FakeApplication()) {

        val o = models.Organization(
          name = "Test Org 1"
        )
        val newOrg = OrganizationModel.create(o)
        newOrg must beAnInstanceOf[models.Organization]

        // Get it by id
        val org = OrganizationModel.getById(newOrg.id.get)
        org must beSome
        org.get must beAnInstanceOf[models.Organization]

        // // Change it
        val cOrg = org.get.copy(name = "Test Org 1!")
        val updatedOrg = OrganizationModel.update(cOrg.id.get, cOrg)
        updatedOrg must beSome
        updatedOrg.get.name mustEqual "Test Org 1!"

        // Nix it
        OrganizationModel.delete(newOrg.id.get)
        val gone =  OrganizationModel.getById(newOrg.id.get)
        gone must beNone
      }
    }
  }
}
