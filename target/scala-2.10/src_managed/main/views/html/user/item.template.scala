
package views.html.user

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
object item extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[models.User,AuthenticatedRequest,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(user: models.User)(implicit request: AuthenticatedRequest):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import emp._

import views.html.util._


Seq[Any](format.raw/*1.61*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main(title = Messages("user.with.id", user.realName))/*6.55*/ {_display_(Seq[Any](format.raw/*6.57*/("""
<div class="row-fluid">
 <div class="span3">
  <div class="bigprofile">
   """),_display_(Seq[Any](/*10.5*/gravatar(user.id.get, 80))),format.raw/*10.30*/("""
   <h2>"""),_display_(Seq[Any](/*11.9*/Messages(user.realName))),format.raw/*11.32*/("""</h2>
   <h4><i class="icon-envelope"></i> <a href="mailto:"""),_display_(Seq[Any](/*12.55*/user/*12.59*/.username)),format.raw/*12.68*/("""">"""),_display_(Seq[Any](/*12.71*/user/*12.75*/.username)),format.raw/*12.84*/("""</a></h4>
   """),_display_(Seq[Any](/*13.5*/if(user.location.isDefined)/*13.32*/ {_display_(Seq[Any](format.raw/*13.34*/("""
   <div><i class="icon-map-marker"></i> """),_display_(Seq[Any](/*14.42*/user/*14.46*/.location)),format.raw/*14.55*/("""</div>
   """)))})),format.raw/*15.5*/("""
   """),_display_(Seq[Any](/*16.5*/if(user.title.isDefined)/*16.29*/ {_display_(Seq[Any](format.raw/*16.31*/("""
   <div><i class="icon-briefcase"></i> """),_display_(Seq[Any](/*17.41*/user/*17.45*/.title)),format.raw/*17.51*/("""</div>
   """)))})),format.raw/*18.5*/("""
   """),_display_(Seq[Any](/*19.5*/if(user.url.isDefined)/*19.27*/ {_display_(Seq[Any](format.raw/*19.29*/("""
   <div><i class="icon-globe"></i> <a href=""""),_display_(Seq[Any](/*20.46*/user/*20.50*/.url)),format.raw/*20.54*/("""">"""),_display_(Seq[Any](/*20.57*/user/*20.61*/.url)),format.raw/*20.65*/("""</a></div>
   """)))})),format.raw/*21.5*/("""
  </div>
 </div>
 <div class="span6">
  <h2>"""),_display_(Seq[Any](/*25.8*/Messages("general.timeline"))),format.raw/*25.36*/("""</h2>
  
 </div>
 <div class="span3">
 </div>
</div>
""")))})),format.raw/*31.2*/("""
"""))}
    }
    
    def render(user:models.User,request:AuthenticatedRequest): play.api.templates.HtmlFormat.Appendable = apply(user)(request)
    
    def f:((models.User) => (AuthenticatedRequest) => play.api.templates.HtmlFormat.Appendable) = (user) => (request) => apply(user)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:18 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/user/item.scala.html
                    HASH: f04b722fcf6e11622e98fd6d69d7f37420671152
                    MATRIX: 586->1|778->60|806->102|842->104|903->157|942->159|1054->236|1101->261|1145->270|1190->293|1286->353|1299->357|1330->366|1369->369|1382->373|1413->382|1462->396|1498->423|1538->425|1616->467|1629->471|1660->480|1702->491|1742->496|1775->520|1815->522|1892->563|1905->567|1933->573|1975->584|2015->589|2046->611|2086->613|2168->659|2181->663|2207->667|2246->670|2259->674|2285->678|2331->693|2412->739|2462->767|2547->821
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|32->10|32->10|33->11|33->11|34->12|34->12|34->12|34->12|34->12|34->12|35->13|35->13|35->13|36->14|36->14|36->14|37->15|38->16|38->16|38->16|39->17|39->17|39->17|40->18|41->19|41->19|41->19|42->20|42->20|42->20|42->20|42->20|42->20|43->21|47->25|47->25|53->31
                    -- GENERATED --
                */
            