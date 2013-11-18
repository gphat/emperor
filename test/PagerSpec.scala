package test

import org.specs2.mutable._
import play.api.test._

class PagerSpec extends Specification {

  import emp.util.Pagination._

  "Page" should {

    "return sane results for first page" in {

      val pager = Page(
        items = List(1,2,3,4,5),
        requestedPage = 1,
        count = 2,
        total = 10
      )

      pager.offset mustEqual 0
      pager.range.start mustEqual 1
      pager.range.end mustEqual 6
      pager.prev must beNone
      pager.next must beSome
      pager.next.get mustEqual 2
    }

    "return sane results for mid-pages" in {

      val pager = Page(
        items = List(1,2,3,4,5),
        requestedPage = 2,
        count = 2,
        total = 10
      )

      pager.offset mustEqual 2
      pager.prev must beSome
      pager.prev.get mustEqual 1
      pager.next must beSome
      pager.next.get mustEqual 3
    }

    "return sane results for last page" in {

      val pager = Page(
        items = List(1,2,3,4,5),
        requestedPage = 5,
        count = 2,
        total = 10
      )

      pager.offset mustEqual 8
      pager.prev must beSome
      pager.prev.get mustEqual 4
      pager.next must beNone
    }

    "return sane results for out of bounds page (high)" in {

      val pager = Page(
        items = List(1,2,3,4,5),
        requestedPage = 6,
        count = 2,
        total = 10
      )

      pager.page mustEqual 5
      pager.offset mustEqual 8
      pager.prev must beSome
      pager.prev.get mustEqual 4
      pager.next must beNone
    }

    "return sane results for out of bounds page (low)" in {

      val pager = Page(
        items = List(1,2,3,4,5),
        requestedPage = -6,
        count = 2,
        total = 10
      )

      pager.page mustEqual 1
      pager.offset mustEqual 0
      pager.prev must beNone
      pager.next must beSome
      pager.next.get mustEqual 2
    }
  }
}