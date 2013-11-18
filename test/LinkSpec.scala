package test

import org.specs2.mutable._
import play.api.test._

class LinkSpec extends Specification {

  import emp.util.Links

  "Links" should {

     "create proper pager links" in {

      val req = FakeRequest()

      Links.pagerLink(req.queryString, req.path, 1, 10) mustEqual "/?page=1&count=10&"
      Links.pagerLink(req.queryString, req.path, 2, 4) mustEqual "/?page=2&count=4&"
      Links.pagerLink(req.queryString, req.path) mustEqual "/?page=1&count=10&"
      Links.pagerLink(req.queryString, req.path, count = 5) mustEqual "/?page=1&count=5&"
    }

    "create proper filter links" in {

      val req = FakeRequest()

      Links.filterLink(req.queryString, req.path, "foo", "bar") mustEqual "/?foo=bar&"
    }

    "create proper sort links" in {

      val req = FakeRequest()

      Links.sortLink(req.queryString, req.path, "foo") mustEqual "/?sort=foo&order=desc&"
    }
  }
}