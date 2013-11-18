
package views.html.project

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
/**/
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[emp.util.Pagination.Page[models.Project],AuthenticatedRequest,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(page: emp.util.Pagination.Page[models.Project])(implicit request: AuthenticatedRequest):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import views.html.util._

import models.TicketModel


Seq[Any](format.raw/*1.90*/("""
"""),_display_(Seq[Any](/*4.2*/main(Messages("project.list"))/*4.32*/ {_display_(Seq[Any](format.raw/*4.34*/("""
<div class="btn-group btn-group-above-table pull-right">
 <a href=""""),_display_(Seq[Any](/*6.12*/controllers/*6.23*/.routes.Project.create)),format.raw/*6.45*/("""" class="btn"><i class="icon-plus-sign"></i> """),_display_(Seq[Any](/*6.91*/Messages("project.add"))),format.raw/*6.114*/("""</a>
</div>
<h1>"""),_display_(Seq[Any](/*8.6*/Messages("project.list"))),format.raw/*8.30*/("""</h1>
"""),_display_(Seq[Any](/*9.2*/if(page.items.isEmpty)/*9.24*/ {_display_(Seq[Any](format.raw/*9.26*/("""
<div class="alert alert-info">"""),_display_(Seq[Any](/*10.32*/Messages("general.projects.empty"))),format.raw/*10.66*/("""</a> <a href=""""),_display_(Seq[Any](/*10.81*/controllers/*10.92*/.routes.Project.create)),format.raw/*10.114*/("""">"""),_display_(Seq[Any](/*10.117*/Messages("general.projects.add"))),format.raw/*10.149*/("""</a></div>
""")))}/*11.3*/else/*11.8*/{_display_(Seq[Any](format.raw/*11.9*/("""
"""),_display_(Seq[Any](/*12.2*/Option(page.items)/*12.20*/.filterNot(_.isEmpty).map/*12.45*/ { projects =>_display_(Seq[Any](format.raw/*12.59*/("""
<ul class="thumbnails">
  """),_display_(Seq[Any](/*14.4*/projects/*14.12*/.map/*14.16*/ { project =>_display_(Seq[Any](format.raw/*14.29*/("""
  <li class="span4">
   <div class="thumbnail">
    <h3><a href=""""),_display_(Seq[Any](/*17.19*/controllers/*17.30*/.routes.Project.item(project.id.get))),format.raw/*17.66*/("""">"""),_display_(Seq[Any](/*17.69*/project/*17.76*/.name)),format.raw/*17.81*/("""</a></h3>
   </div>
  </li>
  """)))})),format.raw/*20.4*/("""
</ul>
""")))})),format.raw/*22.2*/("""
""")))})),format.raw/*23.2*/("""
""")))})),format.raw/*24.2*/("""
"""))}
    }
    
    def render(page:emp.util.Pagination.Page[models.Project],request:AuthenticatedRequest): play.api.templates.HtmlFormat.Appendable = apply(page)(request)
    
    def f:((emp.util.Pagination.Page[models.Project]) => (AuthenticatedRequest) => play.api.templates.HtmlFormat.Appendable) = (page) => (request) => apply(page)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:17 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/project/index.scala.html
                    HASH: fbc2a4f7dc3c1e4fb2d37532000c0911810d4f0f
                    MATRIX: 619->1|853->89|889->144|927->174|966->176|1070->245|1089->256|1132->278|1213->324|1258->347|1309->364|1354->388|1395->395|1425->417|1464->419|1532->451|1588->485|1639->500|1659->511|1704->533|1744->536|1799->568|1829->581|1841->586|1879->587|1916->589|1943->607|1977->632|2029->646|2092->674|2109->682|2122->686|2173->699|2276->766|2296->777|2354->813|2393->816|2409->823|2436->828|2498->859|2537->867|2570->869|2603->871
                    LINES: 19->1|25->1|26->4|26->4|26->4|28->6|28->6|28->6|28->6|28->6|30->8|30->8|31->9|31->9|31->9|32->10|32->10|32->10|32->10|32->10|32->10|32->10|33->11|33->11|33->11|34->12|34->12|34->12|34->12|36->14|36->14|36->14|36->14|39->17|39->17|39->17|39->17|39->17|39->17|42->20|44->22|45->23|46->24
                    -- GENERATED --
                */
            