
package views.html.project

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
object create extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template7[Form[Project],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],AuthenticatedRequest,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(objForm: Form[(Project)], users: List[(String,String)], asses: List[(String,String)], ttypes: List[(String,String)], priorities: List[(String,String)], severities: List[(String,String)])(implicit request: AuthenticatedRequest):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import helper.bootstrap.bootstrapField


Seq[Any](format.raw/*1.229*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main(Messages("project.add"))/*6.31*/ {_display_(Seq[Any](format.raw/*6.33*/("""
<h1>"""),_display_(Seq[Any](/*7.6*/Messages("project.add"))),format.raw/*7.29*/("""</h1>
"""),_display_(Seq[Any](/*8.2*/helper/*8.8*/.form(action = controllers.routes.Project.add)/*8.54*/ {_display_(Seq[Any](format.raw/*8.56*/("""
 <fieldset>
  """),_display_(Seq[Any](/*10.4*/helper/*10.10*/.inputText(objForm("name"), '_label -> Messages("project.name"), 'placeholder -> Messages("project.name.placeholder")))),format.raw/*10.128*/("""
  """),_display_(Seq[Any](/*11.4*/helper/*11.10*/.inputText(objForm("key"), '_label -> Messages("project.key"), 'placeholder -> Messages("project.key.placeholder")))),format.raw/*11.125*/("""
  """),_display_(Seq[Any](/*12.4*/helper/*12.10*/.select(field = objForm("owner_id"), options = users, args = '_label -> Messages("project.owner")))),format.raw/*12.108*/("""
  """),_display_(Seq[Any](/*13.4*/helper/*13.10*/.select(field = objForm("default_assignee"), options = asses, args = '_label -> Messages("project.default.assignee")))),format.raw/*13.127*/("""
  """),_display_(Seq[Any](/*14.4*/helper/*14.10*/.select(field = objForm("default_priority_id"), options = priorities, args = '_label -> Messages("project.default.priority")))),format.raw/*14.135*/("""
  """),_display_(Seq[Any](/*15.4*/helper/*15.10*/.select(field = objForm("default_severity_id"), options = severities, args = '_label -> Messages("project.default.severity")))),format.raw/*15.135*/("""
  """),_display_(Seq[Any](/*16.4*/helper/*16.10*/.select(field = objForm("default_type_id"), options = ttypes, args = '_label -> Messages("project.default.ttype")))),format.raw/*16.124*/("""
  <div class="form-actions">
   <button type="submit" class="btn btn-primary"><i class="icon-ok"></i> """),_display_(Seq[Any](/*18.75*/Messages("form.submit"))),format.raw/*18.98*/("""</button>
  </div>
 </fieldset>
""")))})),format.raw/*21.2*/("""
""")))})))}
    }
    
    def render(objForm:Form[Project],users:List[scala.Tuple2[String, String]],asses:List[scala.Tuple2[String, String]],ttypes:List[scala.Tuple2[String, String]],priorities:List[scala.Tuple2[String, String]],severities:List[scala.Tuple2[String, String]],request:AuthenticatedRequest): play.api.templates.HtmlFormat.Appendable = apply(objForm,users,asses,ttypes,priorities,severities)(request)
    
    def f:((Form[Project],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]]) => (AuthenticatedRequest) => play.api.templates.HtmlFormat.Appendable) = (objForm,users,asses,ttypes,priorities,severities) => (request) => apply(objForm,users,asses,ttypes,priorities,severities)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:17 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/project/create.scala.html
                    HASH: 358605d8bea9cda2a7abe9b82bda198a35a1eaa2
                    MATRIX: 768->1|1146->228|1174->287|1210->289|1247->318|1286->320|1326->326|1370->349|1411->356|1424->362|1478->408|1517->410|1568->426|1583->432|1724->550|1763->554|1778->560|1916->675|1955->679|1970->685|2091->783|2130->787|2145->793|2285->910|2324->914|2339->920|2487->1045|2526->1049|2541->1055|2689->1180|2728->1184|2743->1190|2880->1304|3020->1408|3065->1431|3129->1464
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|29->7|29->7|30->8|30->8|30->8|30->8|32->10|32->10|32->10|33->11|33->11|33->11|34->12|34->12|34->12|35->13|35->13|35->13|36->14|36->14|36->14|37->15|37->15|37->15|38->16|38->16|38->16|40->18|40->18|43->21
                    -- GENERATED --
                */
            