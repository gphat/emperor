
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
 * Generate the top menu.
 */
object topmenu extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Option[Long],AuthenticatedRequest,play.api.templates.HtmlFormat.Appendable] {

    /**
 * Generate the top menu.
 */
    def apply/*4.2*/(currentProject: Option[Long] = None)(implicit request: AuthenticatedRequest):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*4.79*/("""

<ul class="nav">
 <li """),_display_(Seq[Any](/*7.7*/if(request.path.startsWith("/ticket/create"))/*7.52*/ {_display_(Seq[Any](format.raw/*7.54*/(""" class="active" """)))})),format.raw/*7.71*/("""><a href=""""),_display_(Seq[Any](/*7.82*/controllers/*7.93*/.routes.Ticket.create(project = currentProject))),format.raw/*7.140*/("""" target="_self">"""),_display_(Seq[Any](/*7.158*/Messages("ticket.add"))),format.raw/*7.180*/("""</a></li>
 <li """),_display_(Seq[Any](/*8.7*/if(request.path.startsWith("/search"))/*8.45*/ {_display_(Seq[Any](format.raw/*8.47*/(""" class="active" """)))})),format.raw/*8.64*/("""><a href=""""),_display_(Seq[Any](/*8.75*/controllers/*8.86*/.routes.Search.index())),format.raw/*8.108*/("""" target="_self">"""),_display_(Seq[Any](/*8.126*/Messages("general.ticket"))),format.raw/*8.152*/("""</a></li>
 <li """),_display_(Seq[Any](/*9.7*/if(request.path.startsWith("/project"))/*9.46*/ {_display_(Seq[Any](format.raw/*9.48*/(""" class="active" """)))})),format.raw/*9.65*/("""><a href=""""),_display_(Seq[Any](/*9.76*/controllers/*9.87*/.routes.Project.index())),format.raw/*9.110*/("""" target="_self">"""),_display_(Seq[Any](/*9.128*/Messages("general.projects"))),format.raw/*9.156*/("""</a></li>
 <li """),_display_(Seq[Any](/*10.7*/if(request.path.startsWith("/admin"))/*10.44*/ {_display_(Seq[Any](format.raw/*10.46*/(""" class="active" """)))})),format.raw/*10.63*/("""><a href=""""),_display_(Seq[Any](/*10.74*/controllers/*10.85*/.routes.Admin.index())),format.raw/*10.106*/("""" target="_self">"""),_display_(Seq[Any](/*10.124*/Messages("general.admin"))),format.raw/*10.149*/("""</a></li>
</ul>
<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"><i class="icon-align-justify"></i></a>
<div class="nav-collapse collapse navbar-responsive-collapse in">
 """),_display_(Seq[Any](/*14.3*/helper/*14.9*/.form(action = routes.Search.index(page = 1, count = 10), 'class -> "navbar-search form-search pull-left")/*14.115*/ {_display_(Seq[Any](format.raw/*14.117*/("""
  <div class="input-append">
   <input type="text" name="query" class="search-query span2" placeholder=""""),_display_(Seq[Any](/*16.77*/Messages("search.placeholder"))),format.raw/*16.107*/("""">
   <span class="add-on"><i class="icon-search"></i></span>
  </div>
 """)))})),format.raw/*19.3*/("""
 <ul class="nav pull-right">
  """),_display_(Seq[Any](/*21.4*/if(request.user.isAnonymous)/*21.32*/ {_display_(Seq[Any](format.raw/*21.34*/("""
   <a href=""""),_display_(Seq[Any](/*22.14*/controllers/*22.25*/.routes.Auth.login(redirectUrl = request.request.uri))),format.raw/*22.78*/("""" class="btn btn-primary" target="_self">"""),_display_(Seq[Any](/*22.120*/Messages("auth.login"))),format.raw/*22.142*/("""</a>
  """)))}/*23.5*/else/*23.10*/{_display_(Seq[Any](format.raw/*23.11*/("""
   <li class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
     """),_display_(Seq[Any](/*26.7*/request/*26.14*/.user.username)),format.raw/*26.28*/(""" <i class="icon-caret-down"></i>
    </a>
    <ul class="dropdown-menu">
     <li><a href=""""),_display_(Seq[Any](/*29.20*/controllers/*29.31*/.routes.User.edit(request.user.id.get))),format.raw/*29.69*/("""" target="_self"><i class="icon-user"></i> """),_display_(Seq[Any](/*29.113*/Messages("user.account"))),format.raw/*29.137*/("""</a></li>
     <li><a href=""""),_display_(Seq[Any](/*30.20*/routes/*30.26*/.Auth.logout)),format.raw/*30.38*/("""" target="_self"><i class="icon-signout"></i> """),_display_(Seq[Any](/*30.85*/Messages("auth.logout"))),format.raw/*30.108*/("""</a></li>
    </ul>
   </li>
  """)))})),format.raw/*33.4*/("""
 </ul>
</div>
"""))}
    }
    
    def render(currentProject:Option[Long],request:AuthenticatedRequest): play.api.templates.HtmlFormat.Appendable = apply(currentProject)(request)
    
    def f:((Option[Long]) => (AuthenticatedRequest) => play.api.templates.HtmlFormat.Appendable) = (currentProject) => (request) => apply(currentProject)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 21:25:08 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/util/topmenu.scala.html
                    HASH: 9df0c5ccb847baef9a673111300cffc851923b41
                    MATRIX: 648->35|819->112|878->137|931->182|970->184|1018->201|1064->212|1083->223|1152->270|1206->288|1250->310|1300->326|1346->364|1385->366|1433->383|1479->394|1498->405|1542->427|1596->445|1644->471|1694->487|1741->526|1780->528|1828->545|1874->556|1893->567|1938->590|1992->608|2042->636|2093->652|2139->689|2179->691|2228->708|2275->719|2295->730|2339->751|2394->769|2442->794|2677->994|2691->1000|2807->1106|2848->1108|2990->1214|3043->1244|3147->1317|3215->1350|3252->1378|3292->1380|3342->1394|3362->1405|3437->1458|3516->1500|3561->1522|3587->1531|3600->1536|3639->1537|3770->1633|3786->1640|3822->1654|3950->1746|3970->1757|4030->1795|4111->1839|4158->1863|4223->1892|4238->1898|4272->1910|4355->1957|4401->1980|4464->2012
                    LINES: 23->4|26->4|29->7|29->7|29->7|29->7|29->7|29->7|29->7|29->7|29->7|30->8|30->8|30->8|30->8|30->8|30->8|30->8|30->8|30->8|31->9|31->9|31->9|31->9|31->9|31->9|31->9|31->9|31->9|32->10|32->10|32->10|32->10|32->10|32->10|32->10|32->10|32->10|36->14|36->14|36->14|36->14|38->16|38->16|41->19|43->21|43->21|43->21|44->22|44->22|44->22|44->22|44->22|45->23|45->23|45->23|48->26|48->26|48->26|51->29|51->29|51->29|51->29|51->29|52->30|52->30|52->30|52->30|52->30|55->33
                    -- GENERATED --
                */
            