
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
object login extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Form[LoginUser],String,Request[AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(objForm: Form[LoginUser], redirectUrl: String)(implicit request: Request[AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import helper.bootstrap.bootstrapField


Seq[Any](format.raw/*1.88*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/bare(Messages("auth.login"))/*6.30*/ {_display_(Seq[Any](format.raw/*6.32*/("""
<div class="signin">
 <ul class="nav nav-tabs nav-append-content">
  <li class="active"><a>"""),_display_(Seq[Any](/*9.26*/Messages("general.signin"))),format.raw/*9.52*/("""</a></li>
 </ul>
 <div class="tab-content">
  <div id="signin" class="tab-pane active">
  """),_display_(Seq[Any](/*13.4*/objForm/*13.11*/.globalError.map/*13.27*/ { error =>_display_(Seq[Any](format.raw/*13.38*/("""
    <div class="alert alert-error">
      <a class="close" data-dismiss="alert" href="#">&times;</a>
      """),_display_(Seq[Any](/*16.8*/Messages(error.message))),format.raw/*16.31*/("""
    </div>
  """)))})),format.raw/*18.4*/("""
  """),_display_(Seq[Any](/*19.4*/helper/*19.10*/.form(action = controllers.routes.Auth.doLogin(redirectUrl))/*19.70*/ {_display_(Seq[Any](format.raw/*19.72*/("""
   <fieldset>
    <div class="inputs">
    """),_display_(Seq[Any](/*22.6*/helper/*22.12*/.input(objForm("username"), 'hideLabel -> "", 'class -> "input-xlarge")/*22.83*/ { (id, name, value, args) =>_display_(Seq[Any](format.raw/*22.112*/("""
    <input type="email" name=""""),_display_(Seq[Any](/*23.32*/name)),format.raw/*23.36*/("""" value=""""),_display_(Seq[Any](/*23.46*/value)),format.raw/*23.51*/("""" id=""""),_display_(Seq[Any](/*23.58*/id)),format.raw/*23.60*/("""" """),_display_(Seq[Any](/*23.63*/toHtmlArgs(args))),format.raw/*23.79*/(""" placeholder=""""),_display_(Seq[Any](/*23.94*/Messages("general.email"))),format.raw/*23.119*/("""">
    """)))})),format.raw/*24.6*/("""
    """),_display_(Seq[Any](/*25.6*/helper/*25.12*/.inputPassword(objForm("password"), 'class -> "input-xlarge", 'placeholder -> Messages("general.password"), 'hideLabel -> ""))),format.raw/*25.137*/("""
    </div>
    <div class="form-actions">
     <button type="submit" class="btn btn-primary"><i class="icon-signin"></i> """),_display_(Seq[Any](/*28.81*/Messages("auth.login"))),format.raw/*28.103*/("""</button>
     <a class="pull-right" href=""""),_display_(Seq[Any](/*29.35*/controllers/*29.46*/.routes.Auth.forgot)),format.raw/*29.65*/("""">"""),_display_(Seq[Any](/*29.68*/Messages("auth.forgot"))),format.raw/*29.91*/("""</a>
    </div>
   </fieldset>
  """)))})),format.raw/*32.4*/("""
  </div>
 </div>
</div>
""")))})),format.raw/*36.2*/("""
"""))}
    }
    
    def render(objForm:Form[LoginUser],redirectUrl:String,request:Request[AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(objForm,redirectUrl)(request)
    
    def f:((Form[LoginUser],String) => (Request[AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (objForm,redirectUrl) => (request) => apply(objForm,redirectUrl)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 21:25:08 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/auth/login.scala.html
                    HASH: 7d9bc2f40f7f63d2dc264e7e1afd139262c94f28
                    MATRIX: 597->1|833->87|861->146|897->148|933->176|972->178|1100->271|1147->297|1273->388|1289->395|1314->411|1363->422|1507->531|1552->554|1598->569|1637->573|1652->579|1721->639|1761->641|1841->686|1856->692|1936->763|2004->792|2072->824|2098->828|2144->838|2171->843|2214->850|2238->852|2277->855|2315->871|2366->886|2414->911|2453->919|2494->925|2509->931|2657->1056|2816->1179|2861->1201|2941->1245|2961->1256|3002->1275|3041->1278|3086->1301|3151->1335|3208->1361
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|31->9|31->9|35->13|35->13|35->13|35->13|38->16|38->16|40->18|41->19|41->19|41->19|41->19|44->22|44->22|44->22|44->22|45->23|45->23|45->23|45->23|45->23|45->23|45->23|45->23|45->23|45->23|46->24|47->25|47->25|47->25|50->28|50->28|51->29|51->29|51->29|51->29|51->29|54->32|58->36
                    -- GENERATED --
                */
            