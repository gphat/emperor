
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
 * Generate a timeline listing.
 */
object timeline extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[emp.util.Search.SearchResult[models.Event],AuthenticatedRequest,play.api.templates.HtmlFormat.Appendable] {

    /**
 * Generate a timeline listing.
 */
    def apply/*4.2*/(timeline: emp.util.Search.SearchResult[models.Event])(implicit request: AuthenticatedRequest):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import emp.DateFormatter


Seq[Any](format.raw/*4.96*/("""

"""),format.raw/*7.1*/("""
"""),_display_(Seq[Any](/*8.2*/if(timeline.pager.items.isEmpty)/*8.34*/ {_display_(Seq[Any](format.raw/*8.36*/("""
<div class="alert alert-info">"""),_display_(Seq[Any](/*9.32*/Messages("general.timeline.empty"))),format.raw/*9.66*/("""</div>
""")))}/*10.3*/else/*10.8*/{_display_(Seq[Any](format.raw/*10.9*/("""
<ul class="media-list">
"""),_display_(Seq[Any](/*12.2*/timeline/*12.10*/.pager.items.map/*12.26*/ { event =>_display_(Seq[Any](format.raw/*12.37*/("""
<li class="media">
   <a class="pull-left" href=""""),_display_(Seq[Any](/*14.32*/routes/*14.38*/.User.item(event.userId))),format.raw/*14.62*/("""">"""),_display_(Seq[Any](/*14.65*/gravatar(event.userId, 32))),format.raw/*14.91*/("""</a>
   <div class="media-body">
    <h4 class="media-heading">
     """),_display_(Seq[Any](/*17.7*/defining(event.eType)/*17.28*/ { etype =>_display_(Seq[Any](format.raw/*17.39*/("""
      """),_display_(Seq[Any](/*18.8*/etype/*18.13*/ match/*18.19*/ {/*19.8*/case "commit" =>/*19.24*/ {_display_(Seq[Any](format.raw/*19.26*/("""
        <a href=""""),_display_(Seq[Any](/*20.19*/event/*20.24*/.url)),format.raw/*20.28*/(""""><i class="icon-cogs"></i></a> """),_display_(Seq[Any](/*20.61*/Html(Messages("event.action", event.userId, Messages(event.userRealName), Messages("event.action." + event.eType))))),format.raw/*20.176*/(""" <a href=""""),_display_(Seq[Any](/*20.187*/controllers/*20.198*/.routes.Ticket.item("commits", event.eKey))),format.raw/*20.240*/("""">"""),_display_(Seq[Any](/*20.243*/event/*20.248*/.eKey)),format.raw/*20.253*/("""</a>
       """)))}/*22.8*/case "comment" =>/*22.25*/ {_display_(Seq[Any](format.raw/*22.27*/("""
        <a href=""""),_display_(Seq[Any](/*23.19*/event/*23.24*/.url)),format.raw/*23.28*/(""""><i class="icon-comments"></i></a> """),_display_(Seq[Any](/*23.65*/Html(Messages("event.action", event.userId, Messages(event.userRealName), Messages("event.action." + event.eType))))),format.raw/*23.180*/(""" <a href=""""),_display_(Seq[Any](/*23.191*/controllers/*23.202*/.routes.Ticket.item("comments", event.eKey))),format.raw/*23.245*/("""">"""),_display_(Seq[Any](/*23.248*/event/*23.253*/.eKey)),format.raw/*23.258*/("""</a>
       """)))}/*25.8*/case "ticket_change" =>/*25.31*/ {_display_(Seq[Any](format.raw/*25.33*/("""
        <a href=""""),_display_(Seq[Any](/*26.19*/event/*26.24*/.url)),format.raw/*26.28*/(""""><i class="icon-edit"></i></a> """),_display_(Seq[Any](/*26.61*/Html(Messages("event.action", event.userId, Messages(event.userRealName), Messages("event.action." + event.eType))))),format.raw/*26.176*/(""" <a href=""""),_display_(Seq[Any](/*26.187*/controllers/*26.198*/.routes.Ticket.item("comments", event.eKey))),format.raw/*26.241*/("""">"""),_display_(Seq[Any](/*26.244*/event/*26.249*/.eKey)),format.raw/*26.254*/("""</a>
       """)))}/*28.8*/case "ticket_create" =>/*28.31*/ {_display_(Seq[Any](format.raw/*28.33*/("""
        <a href=""""),_display_(Seq[Any](/*29.19*/event/*29.24*/.url)),format.raw/*29.28*/(""""><i class="icon-certificate"></i></a> """),_display_(Seq[Any](/*29.68*/Html(Messages("event.action", event.userId, Messages(event.userRealName), Messages("event.action." + event.eType))))),format.raw/*29.183*/(""" <a href=""""),_display_(Seq[Any](/*29.194*/controllers/*29.205*/.routes.Ticket.item("comments", event.eKey))),format.raw/*29.248*/("""">"""),_display_(Seq[Any](/*29.251*/event/*29.256*/.eKey)),format.raw/*29.261*/("""</a>
       """)))}/*31.8*/case _ =>/*31.17*/ {_display_(Seq[Any](format.raw/*31.19*/(""" """),_display_(Seq[Any](/*31.21*/etype)),format.raw/*31.26*/(""" """)))}})),format.raw/*32.8*/("""
     """)))})),format.raw/*33.7*/("""
     """),_display_(Seq[Any](/*34.7*/Messages("event.attribution.postfix"))),format.raw/*34.44*/(""" <time datetime=""""),_display_(Seq[Any](/*34.62*/DateFormatter/*34.75*/.displayISO8601(event.dateCreated))),format.raw/*34.109*/("""" title=""""),_display_(Seq[Any](/*34.119*/DateFormatter/*34.132*/.displayLongDateTime(event.dateCreated))),format.raw/*34.171*/("""">"""),_display_(Seq[Any](/*34.174*/DateFormatter/*34.187*/.displayLongDateTime(event.dateCreated))),format.raw/*34.226*/("""</time>
    </h4>
    <div class="media">"""),_display_(Seq[Any](/*36.25*/Html(event.content))),format.raw/*36.44*/("""</div>
  </div>
</li>
""")))})),format.raw/*39.2*/("""
</ul>
"""),_display_(Seq[Any](/*41.2*/pager(timeline.pager))),format.raw/*41.23*/("""
""")))})))}
    }
    
    def render(timeline:emp.util.Search.SearchResult[models.Event],request:AuthenticatedRequest): play.api.templates.HtmlFormat.Appendable = apply(timeline)(request)
    
    def f:((emp.util.Search.SearchResult[models.Event]) => (AuthenticatedRequest) => play.api.templates.HtmlFormat.Appendable) = (timeline) => (request) => apply(timeline)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:18 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/util/timeline.scala.html
                    HASH: d36023d88f0391e99320b8979de59b3595cf4b2c
                    MATRIX: 691->41|904->135|932->163|968->165|1008->197|1047->199|1114->231|1169->265|1195->274|1207->279|1245->280|1306->306|1323->314|1348->330|1397->341|1484->392|1499->398|1545->422|1584->425|1632->451|1737->521|1767->542|1816->553|1859->561|1873->566|1888->572|1898->582|1923->598|1963->600|2018->619|2032->624|2058->628|2127->661|2265->776|2313->787|2334->798|2399->840|2439->843|2454->848|2482->853|2513->874|2539->891|2579->893|2634->912|2648->917|2674->921|2747->958|2885->1073|2933->1084|2954->1095|3020->1138|3060->1141|3075->1146|3103->1151|3134->1172|3166->1195|3206->1197|3261->1216|3275->1221|3301->1225|3370->1258|3508->1373|3556->1384|3577->1395|3643->1438|3683->1441|3698->1446|3726->1451|3757->1472|3789->1495|3829->1497|3884->1516|3898->1521|3924->1525|4000->1565|4138->1680|4186->1691|4207->1702|4273->1745|4313->1748|4328->1753|4356->1758|4387->1779|4405->1788|4445->1790|4483->1792|4510->1797|4544->1807|4582->1814|4624->1821|4683->1858|4737->1876|4759->1889|4816->1923|4863->1933|4886->1946|4948->1985|4988->1988|5011->2001|5073->2040|5151->2082|5192->2101|5246->2124|5289->2132|5332->2153
                    LINES: 23->4|27->4|29->7|30->8|30->8|30->8|31->9|31->9|32->10|32->10|32->10|34->12|34->12|34->12|34->12|36->14|36->14|36->14|36->14|36->14|39->17|39->17|39->17|40->18|40->18|40->18|40->19|40->19|40->19|41->20|41->20|41->20|41->20|41->20|41->20|41->20|41->20|41->20|41->20|41->20|42->22|42->22|42->22|43->23|43->23|43->23|43->23|43->23|43->23|43->23|43->23|43->23|43->23|43->23|44->25|44->25|44->25|45->26|45->26|45->26|45->26|45->26|45->26|45->26|45->26|45->26|45->26|45->26|46->28|46->28|46->28|47->29|47->29|47->29|47->29|47->29|47->29|47->29|47->29|47->29|47->29|47->29|48->31|48->31|48->31|48->31|48->31|48->32|49->33|50->34|50->34|50->34|50->34|50->34|50->34|50->34|50->34|50->34|50->34|50->34|52->36|52->36|55->39|57->41|57->41
                    -- GENERATED --
                */
            