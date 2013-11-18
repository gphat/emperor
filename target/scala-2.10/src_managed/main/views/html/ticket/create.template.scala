
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
object create extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template8[Form[models.NewTicket],String,String,String,String,String,String,AuthenticatedRequest,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(objForm: Form[(models.NewTicket)],
  users: String,
  projs: String,
  ttypes: String,
  priorities: String,
  severities: String,
  project: String
)(implicit request: AuthenticatedRequest):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import emp.JsonFormats._

import helper._

import helper.bootstrap.bootstrapField

import play.api.libs.json.Json


Seq[Any](format.raw/*8.42*/("""

"""),format.raw/*14.1*/("""
"""),_display_(Seq[Any](/*15.2*/main(Messages("ticket.add"))/*15.30*/ {_display_(Seq[Any](format.raw/*15.32*/("""
<h1>"""),_display_(Seq[Any](/*16.6*/Messages("ticket.add"))),format.raw/*16.28*/("""</h1>
<div data-bind="visible: projects().length == 0" class="alert alert-info">"""),_display_(Seq[Any](/*17.76*/Messages("general.projects.empty"))),format.raw/*17.110*/("""</a> <a href=""""),_display_(Seq[Any](/*17.125*/controllers/*17.136*/.routes.Project.create)),format.raw/*17.158*/("""">"""),_display_(Seq[Any](/*17.161*/Messages("general.projects.add"))),format.raw/*17.193*/("""</a></div>
"""),_display_(Seq[Any](/*18.2*/helper/*18.8*/.bootstrap.form(action = controllers.routes.Ticket.create(), dataBind = "submit: doSubmit", args = 'class -> "form-horizontal", 'id -> "add-ticket")/*18.156*/ {_display_(Seq[Any](format.raw/*18.158*/("""
 <fieldset data-bind="visible: projects().length > 0">
  """),_display_(Seq[Any](/*20.4*/helper/*20.10*/.bootstrap.select(field = objForm("projectId"), dataBind = "options: projects(), optionsCaption: '" + Messages("ticket.project.caption") + "', optionsText: 'name', optionsValue: 'id', value: chosenProject", args = '_label -> Messages("ticket.project")))),format.raw/*20.262*/("""
  """),_display_(Seq[Any](/*21.4*/helper/*21.10*/.bootstrap.inputText(field = objForm("summary"), dataBind = "value: summary", args = 'class -> "span8", '_label -> Messages("ticket.summary")))),format.raw/*21.152*/("""
  """),_display_(Seq[Any](/*22.4*/helper/*22.10*/.bootstrap.textarea(field = objForm("description"), dataBind="value: description", args = 'class -> "span8", 'rows -> 5, '_label -> Messages("ticket.description")))),format.raw/*22.173*/("""
  """),_display_(Seq[Any](/*23.4*/helper/*23.10*/.bootstrap.select(field = objForm("reporterId"), dataBind = "options: reporters(), value: chosenReporter, optionsText: 'realName', optionsValue: 'id'", args = '_label -> Messages("ticket.reporter")))),format.raw/*23.208*/("""
  """),_display_(Seq[Any](/*24.4*/helper/*24.10*/.bootstrap.select(field = objForm("assigneeId"), dataBind = "options: assignees(), value: chosenAssignee, optionsText: 'realName', optionsValue: 'id'", args = '_label -> Messages("ticket.assignee")))),format.raw/*24.208*/("""
  """),_display_(Seq[Any](/*25.4*/helper/*25.10*/.bootstrap.select(field = objForm("typeId"), dataBind = "options: ttypes(), value: chosenType, optionsText: 'nameI18N', optionsValue: 'id'", args = '_label -> Messages("ticket.type")))),format.raw/*25.193*/("""
  """),_display_(Seq[Any](/*26.4*/helper/*26.10*/.bootstrap.select(field = objForm("priorityId"), dataBind = "options: priorities(), value: chosenPriority, optionsText: 'nameI18N', optionsValue: 'id'", args = '_label -> Messages("ticket.priority")))),format.raw/*26.209*/("""
  """),_display_(Seq[Any](/*27.4*/helper/*27.10*/.bootstrap.select(field = objForm("severityId"), dataBind = "options: severities(), value: chosenSeverity, optionsText: 'nameI18N', optionsValue: 'id'", args = '_label -> Messages("ticket.severity")))),format.raw/*27.209*/("""
  <div class="form-actions">
   <button type="submit" data-bind="enable: hasProject()" class="btn btn-primary"><i class="icon-check"></i> """),_display_(Seq[Any](/*29.111*/Messages("form.submit"))),format.raw/*29.134*/("""</button>
  </div>
 </fieldset>
""")))})),format.raw/*32.2*/("""
<script>
$(function()"""),format.raw/*34.13*/("""{"""),format.raw/*34.14*/("""
  var view = TicketAddViewModel(
    """),_display_(Seq[Any](/*36.6*/Html(Json.toJson(request.user).toString))),format.raw/*36.46*/(""",
    """),_display_(Seq[Any](/*37.6*/Html(projs))),format.raw/*37.17*/(""",
    """),_display_(Seq[Any](/*38.6*/Html(project))),format.raw/*38.19*/(""",
    """),_display_(Seq[Any](/*39.6*/Html(users))),format.raw/*39.17*/(""",
    """),_display_(Seq[Any](/*40.6*/Html(ttypes))),format.raw/*40.18*/(""",
    """),_display_(Seq[Any](/*41.6*/Html(priorities))),format.raw/*41.22*/(""",
    """),_display_(Seq[Any](/*42.6*/Html(severities))),format.raw/*42.22*/("""
  );
  ko.applyBindings(view);
"""),format.raw/*45.1*/("""}"""),format.raw/*45.2*/(""");
</script>
""")))})),format.raw/*47.2*/("""
"""))}
    }
    
    def render(objForm:Form[models.NewTicket],users:String,projs:String,ttypes:String,priorities:String,severities:String,project:String,request:AuthenticatedRequest): play.api.templates.HtmlFormat.Appendable = apply(objForm,users,projs,ttypes,priorities,severities,project)(request)
    
    def f:((Form[models.NewTicket],String,String,String,String,String,String) => (AuthenticatedRequest) => play.api.templates.HtmlFormat.Appendable) = (objForm,users,projs,ttypes,priorities,severities,project) => (request) => apply(objForm,users,projs,ttypes,priorities,severities,project)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:17 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/ticket/create.scala.html
                    HASH: f2015bf9ddd92a57a3746d7df7a5db367e4203d8
                    MATRIX: 643->1|1042->192|1071->309|1108->311|1145->339|1185->341|1226->347|1270->369|1387->450|1444->484|1496->499|1517->510|1562->532|1602->535|1657->567|1704->579|1718->585|1876->733|1917->735|2011->794|2026->800|2301->1052|2340->1056|2355->1062|2520->1204|2559->1208|2574->1214|2760->1377|2799->1381|2814->1387|3035->1585|3074->1589|3089->1595|3310->1793|3349->1797|3364->1803|3570->1986|3609->1990|3624->1996|3846->2195|3885->2199|3900->2205|4122->2404|4299->2544|4345->2567|4409->2600|4459->2622|4488->2623|4562->2662|4624->2702|4666->2709|4699->2720|4741->2727|4776->2740|4818->2747|4851->2758|4893->2765|4927->2777|4969->2784|5007->2800|5049->2807|5087->2823|5146->2855|5174->2856|5219->2870
                    LINES: 19->1|36->8|38->14|39->15|39->15|39->15|40->16|40->16|41->17|41->17|41->17|41->17|41->17|41->17|41->17|42->18|42->18|42->18|42->18|44->20|44->20|44->20|45->21|45->21|45->21|46->22|46->22|46->22|47->23|47->23|47->23|48->24|48->24|48->24|49->25|49->25|49->25|50->26|50->26|50->26|51->27|51->27|51->27|53->29|53->29|56->32|58->34|58->34|60->36|60->36|61->37|61->37|62->38|62->38|63->39|63->39|64->40|64->40|65->41|65->41|66->42|66->42|69->45|69->45|71->47
                    -- GENERATED --
                */
            