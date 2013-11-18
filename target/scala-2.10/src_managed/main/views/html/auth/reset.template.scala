
package views.html.auth

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
object reset extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Form[NewPassword],String,Request[AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(objForm: Form[NewPassword], token: String)(implicit request: Request[AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import helper.bootstrap.bootstrapField


Seq[Any](format.raw/*1.84*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/bare(Messages("auth.forgot"))/*6.31*/ {_display_(Seq[Any](format.raw/*6.33*/("""
<div class="signin">
 <ul class="nav nav-tabs nav-append-content">
  <li class="active"><a>"""),_display_(Seq[Any](/*9.26*/Messages("auth.reset"))),format.raw/*9.48*/("""</a></li>
 </ul>
 <div class="tab-content">
  <div id="signin" class="tab-pane active">
  """),_display_(Seq[Any](/*13.4*/objForm/*13.11*/.globalError.map/*13.27*/ { error =>_display_(Seq[Any](format.raw/*13.38*/("""
    <div class="alert alert-error">
      <a class="close" data-dismiss="alert" href="#">&times;</a>
      """),_display_(Seq[Any](/*16.8*/Messages(error.message))),format.raw/*16.31*/("""
    </div>
  """)))})),format.raw/*18.4*/("""
  """),_display_(Seq[Any](/*19.4*/helper/*19.10*/.form(action = controllers.routes.Auth.doReset(token))/*19.64*/ {_display_(Seq[Any](format.raw/*19.66*/("""
   <fieldset>
    <div class="inputs">
    <p>"""),_display_(Seq[Any](/*22.9*/Messages("auth.reset.blurb"))),format.raw/*22.37*/("""</p>
    """),_display_(Seq[Any](/*23.6*/helper/*23.12*/.inputPassword(objForm("password"), 'class -> "input-xlarge", 'placeholder -> Messages("general.password"), 'hideLabel -> ""))),format.raw/*23.137*/("""
    """),_display_(Seq[Any](/*24.6*/helper/*24.12*/.inputPassword(objForm("password2"), 'class -> "input-xlarge", 'placeholder -> Messages("general.password.confirm"), 'hideLabel -> ""))),format.raw/*24.146*/("""
    </div>
    <div class="form-actions">
     <button type="submit" class="btn btn-primary"><i class="icon-bolt"></i> """),_display_(Seq[Any](/*27.79*/Messages("auth.forgot.reset"))),format.raw/*27.108*/("""</button>
    </div>
   </fieldset>
  """)))})),format.raw/*30.4*/("""
  </div>
 </div>
</div>
""")))})),format.raw/*34.2*/("""
"""))}
    }
    
    def render(objForm:Form[NewPassword],token:String,request:Request[AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(objForm,token)(request)
    
    def f:((Form[NewPassword],String) => (Request[AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (objForm,token) => (request) => apply(objForm,token)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:16 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/auth/reset.scala.html
                    HASH: 12c1827d84f02bf0509fb6649c2cb5e6e7e8204a
                    MATRIX: 599->1|831->83|859->142|895->144|932->173|971->175|1099->268|1142->290|1268->381|1284->388|1309->404|1358->415|1502->524|1547->547|1593->562|1632->566|1647->572|1710->626|1750->628|1833->676|1883->704|1928->714|1943->720|2091->845|2132->851|2147->857|2304->991|2461->1112|2513->1141|2583->1180|2640->1206
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|31->9|31->9|35->13|35->13|35->13|35->13|38->16|38->16|40->18|41->19|41->19|41->19|41->19|44->22|44->22|45->23|45->23|45->23|46->24|46->24|46->24|49->27|49->27|52->30|56->34
                    -- GENERATED --
                */
            