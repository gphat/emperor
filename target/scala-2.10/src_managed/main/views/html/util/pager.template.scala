
package views.html.util

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**
 * Generate a pager control for a given [emp.util.Pagination.Page].
 */
object pager extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[emp.util.Pagination.Page[Any],Request[AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**
 * Generate a pager control for a given [emp.util.Pagination.Page].
 */
    def apply/*4.2*/(page: emp.util.Pagination.Page[Any])(implicit request: Request[AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import emp.util.Links


Seq[Any](format.raw/*4.78*/("""

"""),format.raw/*7.1*/("""
"""),_display_(Seq[Any](/*8.2*/if(page.items.isEmpty)/*8.24*/ {_display_(Seq[Any](format.raw/*8.26*/("""
"""),_display_(Seq[Any](/*9.2*/Messages("pager.empty"))),format.raw/*9.25*/("""
""")))}/*10.3*/else/*10.8*/{_display_(Seq[Any](format.raw/*10.9*/("""
<span class="summ">"""),_display_(Seq[Any](/*11.21*/Messages("pager.summary", page.offset + 1, page.offset + page.items.size, page.total))),format.raw/*11.106*/("""</span>
<div class="pagination pull-right">
  <ul>
    """),_display_(Seq[Any](/*14.6*/if(page.getWindow(10).head > page.range.start)/*14.52*/ {_display_(Seq[Any](format.raw/*14.54*/("""
    <li><a href=""""),_display_(Seq[Any](/*15.19*/Links/*15.24*/.pagerLink(params = request.queryString, path = request.path, page = page.range.start, count = page.count))),format.raw/*15.130*/("""">&laquo;</a></li>
    """)))})),format.raw/*16.6*/("""
    """),_display_(Seq[Any](/*17.6*/page/*17.10*/.prev.map/*17.19*/ { prev =>_display_(Seq[Any](format.raw/*17.29*/("""
    <li><a href=""""),_display_(Seq[Any](/*18.19*/Links/*18.24*/.pagerLink(params = request.queryString, path = request.path, page = page.prev.get, count = page.count))),format.raw/*18.127*/("""">&larr; """),_display_(Seq[Any](/*18.137*/Messages("pager.prev"))),format.raw/*18.159*/("""</a></li>
    """)))}/*19.6*/.getOrElse/*19.16*/ {_display_(Seq[Any](format.raw/*19.18*/("""
    <li class="disabled"><a href="#">&larr; """),_display_(Seq[Any](/*20.46*/Messages("pager.prev"))),format.raw/*20.68*/("""</a></li>
    """)))})),format.raw/*21.6*/("""
    """),_display_(Seq[Any](/*22.6*/page/*22.10*/.getWindow(10).map/*22.28*/ { pageNum =>_display_(Seq[Any](format.raw/*22.41*/("""
    <li """),_display_(Seq[Any](/*23.10*/if(pageNum == page.page)/*23.34*/ {_display_(Seq[Any](format.raw/*23.36*/(""" class="active" """)))})),format.raw/*23.53*/(""">
      <a href=""""),_display_(Seq[Any](/*24.17*/Links/*24.22*/.pagerLink(params = request.queryString, path = request.path, page = pageNum, count = page.count))),format.raw/*24.119*/("""">"""),_display_(Seq[Any](/*24.122*/{ pageNum })),format.raw/*24.133*/("""</a>
    </li>
    """)))})),format.raw/*26.6*/("""
    """),_display_(Seq[Any](/*27.6*/page/*27.10*/.next.map/*27.19*/ { next =>_display_(Seq[Any](format.raw/*27.29*/("""
    <li><a href=""""),_display_(Seq[Any](/*28.19*/Links/*28.24*/.pagerLink(params = request.queryString, path = request.path, page = page.next.get, count = page.count))),format.raw/*28.127*/("""">"""),_display_(Seq[Any](/*28.130*/Messages("pager.next"))),format.raw/*28.152*/(""" &rarr;</a></li>
    """)))}/*29.6*/.getOrElse/*29.16*/ {_display_(Seq[Any](format.raw/*29.18*/("""
    <li class="disabled"><a href="#">"""),_display_(Seq[Any](/*30.39*/Messages("pager.next"))),format.raw/*30.61*/(""" &rarr;</a></li>
    """)))})),format.raw/*31.6*/("""
    """),_display_(Seq[Any](/*32.6*/if(page.getWindow(10).last + 1 < page.range.end)/*32.54*/ {_display_(Seq[Any](format.raw/*32.56*/("""
    <li><a href=""""),_display_(Seq[Any](/*33.19*/Links/*33.24*/.pagerLink(params = request.queryString, path = request.path, page = page.range.end - 1, count = page.count))),format.raw/*33.132*/("""">&raquo;</a></li>
    """)))})),format.raw/*34.6*/("""
  </ul>
</div>
""")))})),format.raw/*37.2*/("""
"""))}
    }
    
    def render(page:emp.util.Pagination.Page[Any],request:Request[AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(page)(request)
    
    def f:((emp.util.Pagination.Page[Any]) => (Request[AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (page) => (request) => apply(page)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:18 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/util/pager.scala.html
                    HASH: db163aeb5edee3d344a5163b22914be530fec5e0
                    MATRIX: 746->77|938->153|966->178|1002->180|1032->202|1071->204|1107->206|1151->229|1171->232|1183->237|1221->238|1278->259|1386->344|1477->400|1532->446|1572->448|1627->467|1641->472|1770->578|1825->602|1866->608|1879->612|1897->621|1945->631|2000->650|2014->655|2140->758|2187->768|2232->790|2265->805|2284->815|2324->817|2406->863|2450->885|2496->900|2537->906|2550->910|2577->928|2628->941|2674->951|2707->975|2747->977|2796->994|2850->1012|2864->1017|2984->1114|3024->1117|3058->1128|3109->1148|3150->1154|3163->1158|3181->1167|3229->1177|3284->1196|3298->1201|3424->1304|3464->1307|3509->1329|3549->1351|3568->1361|3608->1363|3683->1402|3727->1424|3780->1446|3821->1452|3878->1500|3918->1502|3973->1521|3987->1526|4118->1634|4173->1658|4221->1675
                    LINES: 23->4|27->4|29->7|30->8|30->8|30->8|31->9|31->9|32->10|32->10|32->10|33->11|33->11|36->14|36->14|36->14|37->15|37->15|37->15|38->16|39->17|39->17|39->17|39->17|40->18|40->18|40->18|40->18|40->18|41->19|41->19|41->19|42->20|42->20|43->21|44->22|44->22|44->22|44->22|45->23|45->23|45->23|45->23|46->24|46->24|46->24|46->24|46->24|48->26|49->27|49->27|49->27|49->27|50->28|50->28|50->28|50->28|50->28|51->29|51->29|51->29|52->30|52->30|53->31|54->32|54->32|54->32|55->33|55->33|55->33|56->34|59->37
                    -- GENERATED --
                */
            