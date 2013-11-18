
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
object create extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[User],AuthenticatedRequest,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(objForm: Form[(User)])(implicit request: AuthenticatedRequest):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import emp.DateFormatter

import helper._

import helper.bootstrap.bootstrapField


Seq[Any](format.raw/*1.65*/("""

"""),format.raw/*6.1*/("""
"""),_display_(Seq[Any](/*7.2*/main(Messages("admin.user.add"))/*7.34*/ {_display_(Seq[Any](format.raw/*7.36*/("""
<ul class="breadcrumb">
 <li>
  <a href=""""),_display_(Seq[Any](/*10.13*/routes/*10.19*/.Admin.index)),format.raw/*10.31*/("""">"""),_display_(Seq[Any](/*10.34*/Messages("admin.general"))),format.raw/*10.59*/("""</a>
 </li>
 <li>
  <a href=""""),_display_(Seq[Any](/*13.13*/controllers/*13.24*/.admin.routes.User.index())),format.raw/*13.50*/("""">"""),_display_(Seq[Any](/*13.53*/Messages("admin.user.list"))),format.raw/*13.80*/("""</a>
 </li>
 <li class="active">"""),_display_(Seq[Any](/*15.22*/Messages("admin.user.add"))),format.raw/*15.48*/("""</li>
</ul>
<h1>"""),_display_(Seq[Any](/*17.6*/Messages("admin.user.add"))),format.raw/*17.32*/("""</h1>
"""),_display_(Seq[Any](/*18.2*/helper/*18.8*/.form(action = controllers.admin.routes.User.add)/*18.57*/ {_display_(Seq[Any](format.raw/*18.59*/("""
 <fieldset>
  """),_display_(Seq[Any](/*20.4*/helper/*20.10*/.input(objForm("username"), '_label -> Messages("user.email"))/*20.72*/ { (id, name, value, args) =>_display_(Seq[Any](format.raw/*20.101*/("""
   <input type="email" name=""""),_display_(Seq[Any](/*21.31*/name)),format.raw/*21.35*/("""" value=""""),_display_(Seq[Any](/*21.45*/value)),format.raw/*21.50*/("""" id=""""),_display_(Seq[Any](/*21.57*/id)),format.raw/*21.59*/("""" """),_display_(Seq[Any](/*21.62*/toHtmlArgs(args))),format.raw/*21.78*/(""">
  """)))})),format.raw/*22.4*/("""
  """),_display_(Seq[Any](/*23.4*/helper/*23.10*/.checkbox(objForm("admin"), '_label -> Messages("user.admin")))),format.raw/*23.72*/("""
  """),_display_(Seq[Any](/*24.4*/helper/*24.10*/.inputPassword(objForm("password"), '_label -> Messages("user.password")))),format.raw/*24.83*/("""
  """),_display_(Seq[Any](/*25.4*/helper/*25.10*/.inputText(objForm("realName"), '_label -> Messages("user.realname")))),format.raw/*25.79*/("""
  """),_display_(Seq[Any](/*26.4*/helper/*26.10*/.select(field = objForm("timezone"), options = DateFormatter.timeZoneList, '_label -> Messages("user.timezone")))),format.raw/*26.122*/("""
  """),_display_(Seq[Any](/*27.4*/helper/*27.10*/.inputText(objForm("location"), '_label -> Messages("user.location")))),format.raw/*27.79*/("""
  """),_display_(Seq[Any](/*28.4*/helper/*28.10*/.inputText(objForm("url"), '_label -> Messages("user.url")))),format.raw/*28.69*/("""
  """),_display_(Seq[Any](/*29.4*/helper/*29.10*/.inputText(objForm("title"), '_label -> Messages("user.title")))),format.raw/*29.73*/("""
  <div class="form-actions">
   <button type="submit" class="btn btn-primary"><i class="icon-ok"></i> """),_display_(Seq[Any](/*31.75*/Messages("form.submit"))),format.raw/*31.98*/("""</button>
  </div>
 </fieldset>
""")))})),format.raw/*34.2*/("""
""")))})))}
    }
    
    def render(objForm:Form[User],request:AuthenticatedRequest): play.api.templates.HtmlFormat.Appendable = apply(objForm)(request)
    
    def f:((Form[User]) => (AuthenticatedRequest) => play.api.templates.HtmlFormat.Appendable) = (objForm) => (request) => apply(objForm)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 21:25:08 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/admin/user/create.scala.html
                    HASH: 95607a7d73a5589fdaecbff8a52319264c7b0543
                    MATRIX: 593->1|832->64|860->149|896->151|936->183|975->185|1054->228|1069->234|1103->246|1142->249|1189->274|1255->304|1275->315|1323->341|1362->344|1411->371|1480->404|1528->430|1580->447|1628->473|1670->480|1684->486|1742->535|1782->537|1833->553|1848->559|1919->621|1987->650|2054->681|2080->685|2126->695|2153->700|2196->707|2220->709|2259->712|2297->728|2333->733|2372->737|2387->743|2471->805|2510->809|2525->815|2620->888|2659->892|2674->898|2765->967|2804->971|2819->977|2954->1089|2993->1093|3008->1099|3099->1168|3138->1172|3153->1178|3234->1237|3273->1241|3288->1247|3373->1310|3513->1414|3558->1437|3622->1470
                    LINES: 19->1|27->1|29->6|30->7|30->7|30->7|33->10|33->10|33->10|33->10|33->10|36->13|36->13|36->13|36->13|36->13|38->15|38->15|40->17|40->17|41->18|41->18|41->18|41->18|43->20|43->20|43->20|43->20|44->21|44->21|44->21|44->21|44->21|44->21|44->21|44->21|45->22|46->23|46->23|46->23|47->24|47->24|47->24|48->25|48->25|48->25|49->26|49->26|49->26|50->27|50->27|50->27|51->28|51->28|51->28|52->29|52->29|52->29|54->31|54->31|57->34
                    -- GENERATED --
                */
            