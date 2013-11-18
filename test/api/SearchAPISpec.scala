package test.api

import anorm._
import anorm.NotAssigned
import emp.JsonFormats._
import org.joda.time.DateTime
import org.specs2.mutable._
import play.api.libs.json.Json
import play.api.test._
import play.api.test.Helpers._

class SearchAPISpec extends Specification {

  import models._

  "Search API" should {

    "perform a search" in {
      running(FakeApplication()) {

        val user = UserModel.getById(1).get

        val token = UserTokenModel.create(userId = user.id.get, comment = None)

        val tokenStr = "Token token=" + token.token.get

        val result1 = route(FakeRequest(GET, "/api/search").withHeaders("Authorization" -> tokenStr)).get
        status(result1) must equalTo(200)
        contentAsString(result1) must contain("pager")
      }
    }
  }
}
