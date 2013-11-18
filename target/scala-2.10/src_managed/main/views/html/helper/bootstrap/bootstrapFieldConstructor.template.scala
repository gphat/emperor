
package views.html.helper.bootstrap

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
object bootstrapFieldConstructor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[helper.FieldElements,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(elements: helper.FieldElements):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.api.i18n._

import views.html.helper._


Seq[Any](format.raw/*1.34*/("""

"""),format.raw/*5.1*/("""
<div id="field-"""),_display_(Seq[Any](/*6.17*/elements/*6.25*/.field.id)),format.raw/*6.34*/("""" class="control-group """),_display_(Seq[Any](/*6.58*/if(elements.hasErrors)/*6.80*/ {_display_(Seq[Any](format.raw/*6.82*/("""error""")))})),format.raw/*6.88*/("""">
 """),_display_(Seq[Any](/*7.3*/if(!elements.args.get('hideLabel).isDefined)/*7.47*/ {_display_(Seq[Any](format.raw/*7.49*/("""
 <label class="control-label" for=""""),_display_(Seq[Any](/*8.37*/elements/*8.45*/.id)),format.raw/*8.48*/("""">"""),_display_(Seq[Any](/*8.51*/elements/*8.59*/.label)),format.raw/*8.65*/("""</label>
 """)))})),format.raw/*9.3*/("""
 <div class="controls">

  <div class=""""),_display_(Seq[Any](/*12.16*/if(elements.args.get('prepend).isDefined)/*12.57*/ {_display_(Seq[Any](format.raw/*12.59*/("""input-prepend""")))})),format.raw/*12.73*/(""" """),_display_(Seq[Any](/*12.75*/if(elements.args.get('append).isDefined)/*12.115*/ {_display_(Seq[Any](format.raw/*12.117*/("""input-append""")))})),format.raw/*12.130*/("""">
  """),_display_(Seq[Any](/*13.4*/if(elements.args.get('prepend).isDefined)/*13.45*/ {_display_(Seq[Any](format.raw/*13.47*/("""
  <span class="add-on">"""),_display_(Seq[Any](/*14.25*/elements/*14.33*/.args.get('prepend))),format.raw/*14.52*/("""</span>
  """)))})),format.raw/*15.4*/("""
  """),_display_(Seq[Any](/*16.4*/elements/*16.12*/.input)),format.raw/*16.18*/(""" """),_display_(Seq[Any](/*16.20*/if(elements.args.get('append).isDefined)/*16.60*/ {_display_(Seq[Any](format.raw/*16.62*/(""" <span class="add-on">"""),_display_(Seq[Any](/*16.85*/elements/*16.93*/.args.get('append))),format.raw/*16.111*/("""</span> """)))})),format.raw/*16.120*/("""
  </div>
  <span class="help-block">"""),_display_(Seq[Any](/*18.29*/elements/*18.37*/.errors.mkString(", "))),format.raw/*18.59*/("""</span>
 </div>
</div>
"""))}
    }
    
    def render(elements:helper.FieldElements): play.api.templates.HtmlFormat.Appendable = apply(elements)
    
    def f:((helper.FieldElements) => play.api.templates.HtmlFormat.Appendable) = (elements) => apply(elements)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:17 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/helper/bootstrap/bootstrapFieldConstructor.scala.html
                    HASH: be2ac5c6d18b968da66e21da906102b3fab39c0b
                    MATRIX: 607->1|784->33|812->87|864->104|880->112|910->121|969->145|999->167|1038->169|1075->175|1114->180|1166->224|1205->226|1277->263|1293->271|1317->274|1355->277|1371->285|1398->291|1439->302|1516->343|1566->384|1606->386|1652->400|1690->402|1740->442|1781->444|1827->457|1868->463|1918->504|1958->506|2019->531|2036->539|2077->558|2119->569|2158->573|2175->581|2203->587|2241->589|2290->629|2330->631|2389->654|2406->662|2447->680|2489->689|2563->727|2580->735|2624->757
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|28->6|28->6|28->6|28->6|29->7|29->7|29->7|30->8|30->8|30->8|30->8|30->8|30->8|31->9|34->12|34->12|34->12|34->12|34->12|34->12|34->12|34->12|35->13|35->13|35->13|36->14|36->14|36->14|37->15|38->16|38->16|38->16|38->16|38->16|38->16|38->16|38->16|38->16|38->16|40->18|40->18|40->18
                    -- GENERATED --
                */
            