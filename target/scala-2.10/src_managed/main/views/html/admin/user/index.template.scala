
package views.html.admin.user

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[emp.util.Pagination.Page[models.User],AuthenticatedRequest,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(page: emp.util.Pagination.Page[models.User])(implicit request: AuthenticatedRequest):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import views.html.util._


Seq[Any](format.raw/*1.87*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main(Messages("admin.user.list"))/*5.35*/ {_display_(Seq[Any](format.raw/*5.37*/("""
<ul class="breadcrumb">
 <li>
  <a href=""""),_display_(Seq[Any](/*8.13*/routes/*8.19*/.Admin.index)),format.raw/*8.31*/("""">"""),_display_(Seq[Any](/*8.34*/Messages("general.admin"))),format.raw/*8.59*/("""</a>
 </li>
 <li class="divider"><i class="icon-ellipsis-vertical"></i></li>
 <li class="active">"""),_display_(Seq[Any](/*11.22*/Messages("admin.user.list"))),format.raw/*11.49*/("""</li>
</ul>
<div class="btn-group btn-group-above-table pull-right">
 <a href=""""),_display_(Seq[Any](/*14.12*/controllers/*14.23*/.admin.routes.User.create)),format.raw/*14.48*/("""" class="btn"><i class="icon-plus-sign"></i> """),_display_(Seq[Any](/*14.94*/Messages("admin.user.add"))),format.raw/*14.120*/("""</a>
</div>
<h1>"""),_display_(Seq[Any](/*16.6*/Messages("admin.user.list"))),format.raw/*16.33*/("""</h1>
"""),_display_(Seq[Any](/*17.2*/Option(page.items)/*17.20*/.filterNot(_.isEmpty).map/*17.45*/ { users =>_display_(Seq[Any](format.raw/*17.56*/("""
<table class="table table-bordered table-rounded table-striped">
 <thead>
  <th>"""),_display_(Seq[Any](/*20.8*/Messages("user.username"))),format.raw/*20.33*/("""</th>
  <th>"""),_display_(Seq[Any](/*21.8*/Messages("user.realname"))),format.raw/*21.33*/("""</th>
  <th>"""),_display_(Seq[Any](/*22.8*/Messages("general.actions"))),format.raw/*22.35*/("""</th>
 </thead>
 <tbody>
  """),_display_(Seq[Any](/*25.4*/users/*25.9*/.map/*25.13*/ { user =>_display_(Seq[Any](format.raw/*25.23*/("""
  <tr>
   <td><a href=""""),_display_(Seq[Any](/*27.18*/controllers/*27.29*/.routes.User.item(user.id.get))),format.raw/*27.59*/("""">"""),_display_(Seq[Any](/*27.62*/user/*27.66*/.username)),format.raw/*27.75*/("""</a></td>
   <td>"""),_display_(Seq[Any](/*28.9*/Messages(user.realName))),format.raw/*28.32*/("""</td>
   <td class="actions" style="width: 10%">
    <div class="btn-toolbar">
     <div class="btn-group">
      <a class="btn btn-mini" href=""""),_display_(Seq[Any](/*32.38*/controllers/*32.49*/.routes.User.edit(user.id.get))),format.raw/*32.79*/(""""><i class="icon-edit"></i> """),_display_(Seq[Any](/*32.108*/Messages("general.edit"))),format.raw/*32.132*/("""</a>
     </div>
    </div>
   </td>
  </tr>
  """)))})),format.raw/*37.4*/("""
 </tbody>
 <tfoot>
  <tr>
   <td colspan="4">
     """),_display_(Seq[Any](/*42.7*/pager(page))),format.raw/*42.18*/("""
    </td>
   </tr>
 </tfoot>
</table>
""")))})),format.raw/*47.2*/("""
""")))})))}
    }
    
    def render(page:emp.util.Pagination.Page[models.User],request:AuthenticatedRequest): play.api.templates.HtmlFormat.Appendable = apply(page)(request)
    
    def f:((emp.util.Pagination.Page[models.User]) => (AuthenticatedRequest) => play.api.templates.HtmlFormat.Appendable) = (page) => (request) => apply(page)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 21:25:08 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/admin/user/index.scala.html
                    HASH: 0589175c690159fa229cf1846530885e658bf6a0
                    MATRIX: 619->1|823->86|851->114|887->116|928->149|967->151|1045->194|1059->200|1092->212|1130->215|1176->240|1310->338|1359->365|1475->445|1495->456|1542->481|1624->527|1673->553|1725->570|1774->597|1816->604|1843->622|1877->647|1926->658|2043->740|2090->765|2138->778|2185->803|2233->816|2282->843|2345->871|2358->876|2371->880|2419->890|2480->915|2500->926|2552->956|2591->959|2604->963|2635->972|2688->990|2733->1013|2914->1158|2934->1169|2986->1199|3052->1228|3099->1252|3178->1300|3266->1353|3299->1364|3370->1404
                    LINES: 19->1|23->1|25->4|26->5|26->5|26->5|29->8|29->8|29->8|29->8|29->8|32->11|32->11|35->14|35->14|35->14|35->14|35->14|37->16|37->16|38->17|38->17|38->17|38->17|41->20|41->20|42->21|42->21|43->22|43->22|46->25|46->25|46->25|46->25|48->27|48->27|48->27|48->27|48->27|48->27|49->28|49->28|53->32|53->32|53->32|53->32|53->32|58->37|63->42|63->42|68->47
                    -- GENERATED --
                */
            