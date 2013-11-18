
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
object edit extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template8[Long,Form[Project],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],AuthenticatedRequest,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(id: Long, objForm: Form[(Project)], users: List[(String,String)], asses: List[(String,String)], ttypes: List[(String,String)], priorities: List[(String,String)], severities: List[(String,String)])(implicit request: AuthenticatedRequest):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import helper.bootstrap.bootstrapField


Seq[Any](format.raw/*1.239*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main(Messages("project.edit"))/*6.32*/ {_display_(Seq[Any](format.raw/*6.34*/("""
<h1>"""),_display_(Seq[Any](/*7.6*/Messages("project.edit"))),format.raw/*7.30*/("""</h1>
"""),_display_(Seq[Any](/*8.2*/helper/*8.8*/.form(action = routes.Project.update(id))/*8.49*/ {_display_(Seq[Any](format.raw/*8.51*/("""
 <fieldset>
  """),_display_(Seq[Any](/*10.4*/helper/*10.10*/.inputText(objForm("name"), '_label -> Messages("project.name")))),format.raw/*10.74*/("""
  """),_display_(Seq[Any](/*11.4*/helper/*11.10*/.select(field = objForm("owner_id"), options = users, args = '_label -> Messages("project.owner")))),format.raw/*11.108*/("""
  """),_display_(Seq[Any](/*12.4*/helper/*12.10*/.select(field = objForm("default_assignee"), options = asses, args = '_label -> Messages("project.default.assignee")))),format.raw/*12.127*/("""
  """),_display_(Seq[Any](/*13.4*/helper/*13.10*/.select(field = objForm("default_priority_id"), options = priorities, args = '_label -> Messages("project.default.priority")))),format.raw/*13.135*/("""
  """),_display_(Seq[Any](/*14.4*/helper/*14.10*/.select(field = objForm("default_severity_id"), options = severities, args = '_label -> Messages("project.default.severity")))),format.raw/*14.135*/("""
  """),_display_(Seq[Any](/*15.4*/helper/*15.10*/.select(field = objForm("default_type_id"), options = ttypes, args = '_label -> Messages("project.default.ttype")))),format.raw/*15.124*/("""
  <div class="form-actions">
   <a href=""""),_display_(Seq[Any](/*17.14*/controllers/*17.25*/.routes.Project.index())),format.raw/*17.48*/("""" class="btn"><i class="icon-remove"></i> """),_display_(Seq[Any](/*17.91*/Messages("form.cancel"))),format.raw/*17.114*/("""</a>
   <button type="submit" class="btn btn-primary"><i class="icon-check"></i> """),_display_(Seq[Any](/*18.78*/Messages("form.submit"))),format.raw/*18.101*/("""</button>
  </div>
 </fieldset>
""")))})),format.raw/*21.2*/("""
""")))})))}
    }
    
    def render(id:Long,objForm:Form[Project],users:List[scala.Tuple2[String, String]],asses:List[scala.Tuple2[String, String]],ttypes:List[scala.Tuple2[String, String]],priorities:List[scala.Tuple2[String, String]],severities:List[scala.Tuple2[String, String]],request:AuthenticatedRequest): play.api.templates.HtmlFormat.Appendable = apply(id,objForm,users,asses,ttypes,priorities,severities)(request)
    
    def f:((Long,Form[Project],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]]) => (AuthenticatedRequest) => play.api.templates.HtmlFormat.Appendable) = (id,objForm,users,asses,ttypes,priorities,severities) => (request) => apply(id,objForm,users,asses,ttypes,priorities,severities)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:17 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/project/edit.scala.html
                    HASH: d6e03eceac62a45db50deca397cabfff2e42cd3c
                    MATRIX: 771->1|1159->238|1187->297|1223->299|1261->329|1300->331|1340->337|1385->361|1426->368|1439->374|1488->415|1527->417|1578->433|1593->439|1679->503|1718->507|1733->513|1854->611|1893->615|1908->621|2048->738|2087->742|2102->748|2250->873|2289->877|2304->883|2452->1008|2491->1012|2506->1018|2643->1132|2722->1175|2742->1186|2787->1209|2866->1252|2912->1275|3030->1357|3076->1380|3140->1413
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|29->7|29->7|30->8|30->8|30->8|30->8|32->10|32->10|32->10|33->11|33->11|33->11|34->12|34->12|34->12|35->13|35->13|35->13|36->14|36->14|36->14|37->15|37->15|37->15|39->17|39->17|39->17|39->17|39->17|40->18|40->18|43->21
                    -- GENERATED --
                */
            