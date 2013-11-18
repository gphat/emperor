
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
object edit extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[Long,Form[User],Form[models.UserToken],Form[NewPassword],AuthenticatedRequest,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(id: Long, objForm: Form[(User)], tokenForm: Form[models.UserToken], passForm: Form[(NewPassword)])(implicit request: AuthenticatedRequest):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import emp.DateFormatter

import helper._

import helper.bootstrap.bootstrapField


Seq[Any](format.raw/*1.141*/("""

"""),format.raw/*6.1*/("""
"""),_display_(Seq[Any](/*7.2*/main(Messages("user.edit"))/*7.29*/ {_display_(Seq[Any](format.raw/*7.31*/("""
<div class="row-fluid">
 <div class="span6">
  <h1>"""),_display_(Seq[Any](/*10.8*/Messages("user.edit"))),format.raw/*10.29*/("""</h1>
  """),_display_(Seq[Any](/*11.4*/helper/*11.10*/.form(action = controllers.routes.User.update(id))/*11.60*/ {_display_(Seq[Any](format.raw/*11.62*/("""
   <fieldset>
    """),_display_(Seq[Any](/*13.6*/helper/*13.12*/.input(objForm("username"), '_label -> Messages("user.email"))/*13.74*/ { (id, name, value, args) =>_display_(Seq[Any](format.raw/*13.103*/("""
     <input type="email" name=""""),_display_(Seq[Any](/*14.33*/name)),format.raw/*14.37*/("""" value=""""),_display_(Seq[Any](/*14.47*/value)),format.raw/*14.52*/("""" id=""""),_display_(Seq[Any](/*14.59*/id)),format.raw/*14.61*/("""" """),_display_(Seq[Any](/*14.64*/toHtmlArgs(args))),format.raw/*14.80*/(""">
    """)))})),format.raw/*15.6*/("""
    """),_display_(Seq[Any](/*16.6*/helper/*16.12*/.inputText(objForm("realName"), '_label -> Messages("user.realname")))),format.raw/*16.81*/("""
    """),_display_(Seq[Any](/*17.6*/helper/*17.12*/.select(field = objForm("timezone"), options = DateFormatter.timeZoneList, '_label -> Messages("user.timezone")))),format.raw/*17.124*/("""
    """),_display_(Seq[Any](/*18.6*/helper/*18.12*/.inputText(objForm("location"), '_label -> Messages("user.location")))),format.raw/*18.81*/("""
    """),_display_(Seq[Any](/*19.6*/helper/*19.12*/.inputText(objForm("url"), '_label -> Messages("user.url")))),format.raw/*19.71*/("""
    """),_display_(Seq[Any](/*20.6*/helper/*20.12*/.inputText(objForm("title"), '_label -> Messages("user.title")))),format.raw/*20.75*/("""
    <div class="form-actions">
     <button type="submit" class="btn btn-primary"><i class="icon-ok"></i> """),_display_(Seq[Any](/*22.77*/Messages("form.submit"))),format.raw/*22.100*/("""</button>
    </div>
   </fieldset>
  """)))})),format.raw/*25.4*/("""
 </div>
 <div class="span6">
  <h1>"""),_display_(Seq[Any](/*28.8*/Messages("user.changepassword"))),format.raw/*28.39*/("""</h1>
  """),_display_(Seq[Any](/*29.4*/passForm/*29.12*/.globalError.map/*29.28*/ { error =>_display_(Seq[Any](format.raw/*29.39*/("""
    <div class="alert alert-error">"""),_display_(Seq[Any](/*30.37*/Messages(error.message))),format.raw/*30.60*/("""</div>
  """)))})),format.raw/*31.4*/("""
  """),_display_(Seq[Any](/*32.4*/helper/*32.10*/.form(action = controllers.routes.User.updatePassword(id))/*32.68*/ {_display_(Seq[Any](format.raw/*32.70*/("""
   <fieldset>
    """),_display_(Seq[Any](/*34.6*/helper/*34.12*/.inputPassword(passForm("password"), '_label -> Messages("user.password")))),format.raw/*34.86*/("""
    """),_display_(Seq[Any](/*35.6*/helper/*35.12*/.inputPassword(passForm("password2"), '_label -> Messages("user.password.confirm")))),format.raw/*35.95*/("""
   </fieldset>
   <div class="form-actions">
    <button type="submit" class="btn btn-primary"><i class="icon-ok"></i> """),_display_(Seq[Any](/*38.76*/Messages("form.submit"))),format.raw/*38.99*/("""</button>
   </div>
  """)))})),format.raw/*40.4*/("""
  <div class="btn-group btn-group-above-table pull-right">
   <a class="btn" data-toggle="modal" href="#token"><i class="icon-plus"></i> """),_display_(Seq[Any](/*42.80*/Messages("user.token.add"))),format.raw/*42.106*/("""</a>
  </div>
  <h1>"""),_display_(Seq[Any](/*44.8*/Messages("user.token.list"))),format.raw/*44.35*/("""</h1>
  <p data-bind="visible: tokens().length < 1">"""),_display_(Seq[Any](/*45.48*/Messages("user.token.none"))),format.raw/*45.75*/("""</p>
  <table data-bind="visible: tokens().length >= 1" class="table table-bordered table-striped">
   <thead>
    <tr>
     <th>"""),_display_(Seq[Any](/*49.11*/Messages("user.token.token"))),format.raw/*49.39*/("""</th>
     <th>"""),_display_(Seq[Any](/*50.11*/Messages("user.token.comment"))),format.raw/*50.41*/("""</th>
     <th>"""),_display_(Seq[Any](/*51.11*/Messages("user.token.date_created"))),format.raw/*51.46*/("""</th>
     <th>"""),_display_(Seq[Any](/*52.11*/Messages("general.actions"))),format.raw/*52.38*/("""</th>
    </tr>
   </thead>
   <tbody data-bind="foreach: tokens()">
    <tr>
     <td data-bind="text: token"></td>
     <td data-bind="text: comment"></td>
     <td data-bind="text: dateCreated"></td>
     <td class="actions">
      <div class="btn-group">
       <button data-bind="click: removeToken" class="btn btn-danger btn-mini">"""),_display_(Seq[Any](/*62.80*/Messages("general.delete"))),format.raw/*62.106*/("""</button>
      </div>
    </tr>
   </tbody>
  </table>
 </div>
<div id="ajax-modal" class="modal hide fade" tabindex="-1"></div>
<div class="modal hide" id="token">
 """),_display_(Seq[Any](/*70.3*/helper/*70.9*/.form(action = routes.User.generateToken(id), args = 'method -> "POST")/*70.80*/ {_display_(Seq[Any](format.raw/*70.82*/("""
 <div class="modal-header">
  <button type="button" class="close" data-dismiss="modal">×</button>
  <h3>"""),_display_(Seq[Any](/*73.8*/Messages("user.token.add"))),format.raw/*73.34*/("""</h3>
 </div>
 <div class="modal-body">
   <p>"""),_display_(Seq[Any](/*76.8*/Html(Messages("user.token.summary")))),format.raw/*76.44*/("""</p>
   <fieldset>
     """),_display_(Seq[Any](/*78.7*/helper/*78.13*/.inputText(field = tokenForm("comment"), args = 'class -> "span4", '_label -> Messages("user.token.comment")))),format.raw/*78.122*/("""
   </fieldset>
 </div>
 <div class="modal-footer">
  <a href="#" class="btn" data-dismiss="modal">"""),_display_(Seq[Any](/*82.49*/Messages("form.cancel"))),format.raw/*82.72*/("""</a>
  <button type="submit" class="btn btn-primary"><i class="icon-ok"></i> """),_display_(Seq[Any](/*83.74*/Messages("form.submit"))),format.raw/*83.97*/("""</button>
 </div>
 """)))})),format.raw/*85.3*/("""
</div>
<script>
$(function()"""),format.raw/*88.13*/("""{"""),format.raw/*88.14*/("""
  var view = UserEditViewModel("""),_display_(Seq[Any](/*89.33*/id)),format.raw/*89.35*/(""");
  ko.applyBindings(view);
"""),format.raw/*91.1*/("""}"""),format.raw/*91.2*/(""");
</script>
""")))})))}
    }
    
    def render(id:Long,objForm:Form[User],tokenForm:Form[models.UserToken],passForm:Form[NewPassword],request:AuthenticatedRequest): play.api.templates.HtmlFormat.Appendable = apply(id,objForm,tokenForm,passForm)(request)
    
    def f:((Long,Form[User],Form[models.UserToken],Form[NewPassword]) => (AuthenticatedRequest) => play.api.templates.HtmlFormat.Appendable) = (id,objForm,tokenForm,passForm) => (request) => apply(id,objForm,tokenForm,passForm)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:17 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/user/edit.scala.html
                    HASH: 41939b53c406387df904d9e5bec70ec28220f885
                    MATRIX: 631->1|947->140|975->225|1011->227|1046->254|1085->256|1173->309|1216->330|1260->339|1275->345|1334->395|1374->397|1429->417|1444->423|1515->485|1583->514|1652->547|1678->551|1724->561|1751->566|1794->573|1818->575|1857->578|1895->594|1933->601|1974->607|1989->613|2080->682|2121->688|2136->694|2271->806|2312->812|2327->818|2418->887|2459->893|2474->899|2555->958|2596->964|2611->970|2696->1033|2840->1141|2886->1164|2956->1203|3028->1240|3081->1271|3125->1280|3142->1288|3167->1304|3216->1315|3289->1352|3334->1375|3375->1385|3414->1389|3429->1395|3496->1453|3536->1455|3591->1475|3606->1481|3702->1555|3743->1561|3758->1567|3863->1650|4020->1771|4065->1794|4119->1817|4294->1956|4343->1982|4399->2003|4448->2030|4537->2083|4586->2110|4752->2240|4802->2268|4854->2284|4906->2314|4958->2330|5015->2365|5067->2381|5116->2408|5490->2746|5539->2772|5742->2940|5756->2946|5836->3017|5876->3019|6017->3125|6065->3151|6147->3198|6205->3234|6265->3259|6280->3265|6412->3374|6548->3474|6593->3497|6707->3575|6752->3598|6803->3618|6860->3647|6889->3648|6958->3681|6982->3683|7038->3712|7066->3713
                    LINES: 19->1|27->1|29->6|30->7|30->7|30->7|33->10|33->10|34->11|34->11|34->11|34->11|36->13|36->13|36->13|36->13|37->14|37->14|37->14|37->14|37->14|37->14|37->14|37->14|38->15|39->16|39->16|39->16|40->17|40->17|40->17|41->18|41->18|41->18|42->19|42->19|42->19|43->20|43->20|43->20|45->22|45->22|48->25|51->28|51->28|52->29|52->29|52->29|52->29|53->30|53->30|54->31|55->32|55->32|55->32|55->32|57->34|57->34|57->34|58->35|58->35|58->35|61->38|61->38|63->40|65->42|65->42|67->44|67->44|68->45|68->45|72->49|72->49|73->50|73->50|74->51|74->51|75->52|75->52|85->62|85->62|93->70|93->70|93->70|93->70|96->73|96->73|99->76|99->76|101->78|101->78|101->78|105->82|105->82|106->83|106->83|108->85|111->88|111->88|112->89|112->89|114->91|114->91
                    -- GENERATED --
                */
            