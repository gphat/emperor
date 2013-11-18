
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
object forgot extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[ForgotUser],Request[AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(objForm: Form[ForgotUser])(implicit request: Request[AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import helper.bootstrap.bootstrapField


Seq[Any](format.raw/*1.68*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/bare(Messages("auth.forgot"))/*6.31*/ {_display_(Seq[Any](format.raw/*6.33*/("""
<div class="signin">
 <ul class="nav nav-tabs nav-append-content">
  <li class="active"><a>"""),_display_(Seq[Any](/*9.26*/Messages("auth.forgot"))),format.raw/*9.49*/("""</a></li>
 </ul>
 <div class="tab-content">
  <div id="signin" class="tab-pane active">
  """),_display_(Seq[Any](/*13.4*/objForm/*13.11*/.globalError.map/*13.27*/ { error =>_display_(Seq[Any](format.raw/*13.38*/("""
    <div class="alert alert-error">
      <a class="close" data-dismiss="alert" href="#">&times;</a>
      """),_display_(Seq[Any](/*16.8*/Messages(error.message))),format.raw/*16.31*/("""
    </div>
  """)))})),format.raw/*18.4*/("""
  """),_display_(Seq[Any](/*19.4*/helper/*19.10*/.form(action = controllers.routes.Auth.doForgot)/*19.58*/ {_display_(Seq[Any](format.raw/*19.60*/("""
   <fieldset>
    <div class="inputs">
    <p>"""),_display_(Seq[Any](/*22.9*/Messages("auth.forgot.blurb"))),format.raw/*22.38*/("""</p>
    """),_display_(Seq[Any](/*23.6*/helper/*23.12*/.input(objForm("username"), 'hideLabel -> "", 'class -> "input-xlarge")/*23.83*/ { (id, name, value, args) =>_display_(Seq[Any](format.raw/*23.112*/("""
    <input type="email" name=""""),_display_(Seq[Any](/*24.32*/name)),format.raw/*24.36*/("""" value=""""),_display_(Seq[Any](/*24.46*/value)),format.raw/*24.51*/("""" id=""""),_display_(Seq[Any](/*24.58*/id)),format.raw/*24.60*/("""" """),_display_(Seq[Any](/*24.63*/toHtmlArgs(args))),format.raw/*24.79*/(""" placeholder=""""),_display_(Seq[Any](/*24.94*/Messages("general.email"))),format.raw/*24.119*/("""">
    """)))})),format.raw/*25.6*/("""
    </div>
    <div class="form-actions">
     <button type="submit" class="btn btn-primary"><i class="icon-bolt"></i> """),_display_(Seq[Any](/*28.79*/Messages("auth.forgot.reset"))),format.raw/*28.108*/("""</button>
    </div>
   </fieldset>
  """)))})),format.raw/*31.4*/("""
  </div>
 </div>
</div>
""")))})),format.raw/*35.2*/("""
"""))}
    }
    
    def render(objForm:Form[ForgotUser],request:Request[AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(objForm)(request)
    
    def f:((Form[ForgotUser]) => (Request[AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (objForm) => (request) => apply(objForm)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:16 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/auth/forgot.scala.html
                    HASH: 522cc8b72a1341c1a3ff91d58f2aa7d9a36d10f6
                    MATRIX: 592->1|808->67|836->126|872->128|909->157|948->159|1076->252|1120->275|1246->366|1262->373|1287->389|1336->400|1480->509|1525->532|1571->547|1610->551|1625->557|1682->605|1722->607|1805->655|1856->684|1901->694|1916->700|1996->771|2064->800|2132->832|2158->836|2204->846|2231->851|2274->858|2298->860|2337->863|2375->879|2426->894|2474->919|2513->927|2670->1048|2722->1077|2792->1116|2849->1142
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|31->9|31->9|35->13|35->13|35->13|35->13|38->16|38->16|40->18|41->19|41->19|41->19|41->19|44->22|44->22|45->23|45->23|45->23|45->23|46->24|46->24|46->24|46->24|46->24|46->24|46->24|46->24|46->24|46->24|47->25|50->28|50->28|53->31|57->35
                    -- GENERATED --
                */
            