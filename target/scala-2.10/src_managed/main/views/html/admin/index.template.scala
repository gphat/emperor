
package views.html.admin

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[AuthenticatedRequest,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(implicit request: AuthenticatedRequest):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.42*/("""

"""),_display_(Seq[Any](/*3.2*/main(title = Messages("admin.title"))/*3.39*/ {_display_(Seq[Any](format.raw/*3.41*/("""
<h2>"""),_display_(Seq[Any](/*4.6*/Messages("admin.title"))),format.raw/*4.29*/("""</h2>
<div class="well">
 <div class="row-fluid">
  <div class="span6">
   <ul class="nav nav-list">
    <li class="nav-header"><i class="icon-group"></i> """),_display_(Seq[Any](/*9.56*/Messages("admin.people"))),format.raw/*9.80*/("""</li>
    <li><a href=""""),_display_(Seq[Any](/*10.19*/controllers/*10.30*/.admin.routes.User.index())),format.raw/*10.56*/("""">"""),_display_(Seq[Any](/*10.59*/Messages("admin.user.menu.list"))),format.raw/*10.91*/("""</a></li>
   </ul>
   <ul class="nav nav-list">
    <li class="nav-header"><i class="icon-cogs"></i> """),_display_(Seq[Any](/*13.55*/Messages("admin.general"))),format.raw/*13.80*/("""</li>
    <li><a href=""""),_display_(Seq[Any](/*14.19*/controllers/*14.30*/.routes.Admin.reindex())),format.raw/*14.53*/("""">"""),_display_(Seq[Any](/*14.56*/Messages("admin.reindex"))),format.raw/*14.81*/("""</a></li>
   </ul>
  </div>
  <div class="span6">
   <ul class="nav nav-list">
    <li class="nav-header"><i class="icon-suitcase"></i> """),_display_(Seq[Any](/*19.59*/Messages("admin.projects"))),format.raw/*19.85*/("""</li>
    <li><a href=""""),_display_(Seq[Any](/*20.19*/controllers/*20.30*/.routes.Project.index())),format.raw/*20.53*/("""">"""),_display_(Seq[Any](/*20.56*/Messages("admin.project.menu.list"))),format.raw/*20.91*/("""</a></li>
   </ul>
  </div>
 </div>
</div>
""")))})),format.raw/*25.2*/("""
"""))}
    }
    
    def render(request:AuthenticatedRequest): play.api.templates.HtmlFormat.Appendable = apply(request)
    
    def f:((AuthenticatedRequest) => play.api.templates.HtmlFormat.Appendable) = (request) => apply(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 21:25:07 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/admin/index.scala.html
                    HASH: a512238dd91db1fdfbe659a366d270319ab5fff7
                    MATRIX: 576->1|710->41|747->44|792->81|831->83|871->89|915->112|1106->268|1151->292|1211->316|1231->327|1279->353|1318->356|1372->388|1510->490|1557->515|1617->539|1637->550|1682->573|1721->576|1768->601|1941->738|1989->764|2049->788|2069->799|2114->822|2153->825|2210->860|2285->904
                    LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4|30->9|30->9|31->10|31->10|31->10|31->10|31->10|34->13|34->13|35->14|35->14|35->14|35->14|35->14|40->19|40->19|41->20|41->20|41->20|41->20|41->20|46->25
                    -- GENERATED --
                */
            