
package views.html.ticket

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
object edit extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template10[String,Form[TicketData],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],AuthenticatedRequest,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(id: String, objForm: Form[(TicketData)], users: List[(String,String)], assignees: List[(String,String)], attentions: List[(String,String)], projs: List[(String,String)], ttypes: List[(String,String)], priorities: List[(String,String)], severities: List[(String,String)])(implicit request: AuthenticatedRequest):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import helper.bootstrap.bootstrapField


Seq[Any](format.raw/*1.313*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main(Messages("ticket.edit"))/*6.31*/ {_display_(Seq[Any](format.raw/*6.33*/("""
<h1>"""),_display_(Seq[Any](/*7.6*/Messages("ticket.edit"))),format.raw/*7.29*/("""</h1>
"""),_display_(Seq[Any](/*8.2*/helper/*8.8*/.form(action = routes.Ticket.update(id))/*8.48*/ {_display_(Seq[Any](format.raw/*8.50*/("""
 <fieldset>
  """),_display_(Seq[Any](/*10.4*/helper/*10.10*/.inputText(field = objForm("summary"), args = 'class -> "span8", '_label -> Messages("ticket.summary")))),format.raw/*10.113*/("""
  """),_display_(Seq[Any](/*11.4*/helper/*11.10*/.textarea(field = objForm("description"), args = 'class -> "span8", 'rows -> 5, '_label -> Messages("ticket.description")))),format.raw/*11.132*/("""
  """),_display_(Seq[Any](/*12.4*/helper/*12.10*/.select(field = objForm("userId"), options = users, args = '_label -> Messages("ticket.reporter")))),format.raw/*12.108*/("""
  """),_display_(Seq[Any](/*13.4*/helper/*13.10*/.select(field = objForm("assigneeId"), options = assignees, args = '_label -> Messages("ticket.assignee")))),format.raw/*13.116*/("""
  """),_display_(Seq[Any](/*14.4*/helper/*14.10*/.select(field = objForm("attentionId"), options = attentions, args = '_label -> Messages("ticket.attention")))),format.raw/*14.119*/("""
  """),_display_(Seq[Any](/*15.4*/helper/*15.10*/.select(field = objForm("typeId"), options = ttypes, args = 'class -> "foo", '_label -> Messages("ticket.type")))),format.raw/*15.122*/("""
  """),_display_(Seq[Any](/*16.4*/helper/*16.10*/.select(field = objForm("priorityId"), options = priorities, args = 'class -> "foo", '_label -> Messages("ticket.priority")))),format.raw/*16.134*/("""
  """),_display_(Seq[Any](/*17.4*/helper/*17.10*/.select(field = objForm("severityId"), options = severities, args = 'class -> "foo", '_label -> Messages("ticket.severity")))),format.raw/*17.134*/("""
  <div class="form-actions">
   <a href=""""),_display_(Seq[Any](/*19.14*/controllers/*19.25*/.routes.Ticket.item("comments", id))),format.raw/*19.60*/("""" class="btn"><i class="icon-remove"></i> """),_display_(Seq[Any](/*19.103*/Messages("form.cancel"))),format.raw/*19.126*/("""</a>
   <button type="submit" class="btn btn-primary"><i class="icon-check"></i> """),_display_(Seq[Any](/*20.78*/Messages("form.submit"))),format.raw/*20.101*/("""</button>
  </div>
 </fieldset>
""")))})),format.raw/*23.2*/("""
""")))})))}
    }
    
    def render(id:String,objForm:Form[TicketData],users:List[scala.Tuple2[String, String]],assignees:List[scala.Tuple2[String, String]],attentions:List[scala.Tuple2[String, String]],projs:List[scala.Tuple2[String, String]],ttypes:List[scala.Tuple2[String, String]],priorities:List[scala.Tuple2[String, String]],severities:List[scala.Tuple2[String, String]],request:AuthenticatedRequest): play.api.templates.HtmlFormat.Appendable = apply(id,objForm,users,assignees,attentions,projs,ttypes,priorities,severities)(request)
    
    def f:((String,Form[TicketData],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]],List[scala.Tuple2[String, String]]) => (AuthenticatedRequest) => play.api.templates.HtmlFormat.Appendable) = (id,objForm,users,assignees,attentions,projs,ttypes,priorities,severities) => (request) => apply(id,objForm,users,assignees,attentions,projs,ttypes,priorities,severities)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:17 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/ticket/edit.scala.html
                    HASH: 5347e8e79780a067535bd4a4d9d2fdcd255637b8
                    MATRIX: 846->1|1308->312|1336->371|1372->373|1409->402|1448->404|1488->410|1532->433|1573->440|1586->446|1634->486|1673->488|1724->504|1739->510|1865->613|1904->617|1919->623|2064->745|2103->749|2118->755|2239->853|2278->857|2293->863|2422->969|2461->973|2476->979|2608->1088|2647->1092|2662->1098|2797->1210|2836->1214|2851->1220|2998->1344|3037->1348|3052->1354|3199->1478|3278->1521|3298->1532|3355->1567|3435->1610|3481->1633|3599->1715|3645->1738|3709->1771
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|29->7|29->7|30->8|30->8|30->8|30->8|32->10|32->10|32->10|33->11|33->11|33->11|34->12|34->12|34->12|35->13|35->13|35->13|36->14|36->14|36->14|37->15|37->15|37->15|38->16|38->16|38->16|39->17|39->17|39->17|41->19|41->19|41->19|41->19|41->19|42->20|42->20|45->23
                    -- GENERATED --
                */
            