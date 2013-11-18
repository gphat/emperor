
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
object item extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[models.Project,play.api.libs.json.JsValue,Option[models.User],AuthenticatedRequest,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(project: models.Project, projectJson: play.api.libs.json.JsValue, owner: Option[models.User])(implicit request: AuthenticatedRequest):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import emp._

import views.html.util._


Seq[Any](format.raw/*1.136*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main(title = Messages("project.with.id", project.name), currentProject = Some(project.id.get))/*6.96*/ {_display_(Seq[Any](format.raw/*6.98*/("""
<a id="helper" class="btn btn-mini btn-success"><i class="icon-question-sign"></i></a>
<div id="help" class="alert alert-info" style="display: none">
 <button id="helpcloser" type="button" class="close">&times;</button>
 <strong>"""),_display_(Seq[Any](/*10.11*/Messages("help.projecthome.title"))),format.raw/*10.45*/("""</strong> """),_display_(Seq[Any](/*10.56*/Html(Messages("help.projecthome.blurb")))),format.raw/*10.96*/("""
</div>
<h1><a class="btn" href=""""),_display_(Seq[Any](/*12.27*/controllers/*12.38*/.routes.Project.edit(project.id.get))),format.raw/*12.74*/(""""><i class="icon-edit"></i></a> """),_display_(Seq[Any](/*12.107*/Messages("project.with.id", project.name))),format.raw/*12.148*/("""</h1>
<div class="row-fluid">
 <div class="span3">
   <ul class="well well-small nav nav-list">
    <li class="nav-header">"""),_display_(Seq[Any](/*16.29*/Messages("project.summary.links"))),format.raw/*16.62*/("""</li>
    <li><a href=""""),_display_(Seq[Any](/*17.19*/routes/*17.25*/.Board.index(project.id.get))),format.raw/*17.53*/("""">"""),_display_(Seq[Any](/*17.56*/Messages("project.summary.link.kanban"))),format.raw/*17.95*/("""</a></li>
    <li><a href=""""),_display_(Seq[Any](/*18.19*/routes/*18.25*/.Search.index())),format.raw/*18.40*/("""?project="""),_display_(Seq[Any](/*18.50*/project/*18.57*/.name)),format.raw/*18.62*/("""">"""),_display_(Seq[Any](/*18.65*/Messages("project.summary.link.all_tickets"))),format.raw/*18.109*/("""</a></li>
    <li><a href=""""),_display_(Seq[Any](/*19.19*/routes/*19.25*/.Search.index())),format.raw/*19.40*/("""?project="""),_display_(Seq[Any](/*19.50*/project/*19.57*/.name)),format.raw/*19.62*/("""&resolution=TICK_RESO_UNRESOLVED">"""),_display_(Seq[Any](/*19.97*/Messages("project.summary.link.open_tickets"))),format.raw/*19.142*/("""</a></li>
    <li class="nav-header">"""),_display_(Seq[Any](/*20.29*/Messages("project.summary.milestones"))),format.raw/*20.67*/("""</li>
    <!-- ko foreach: milestones().items -->
    <li><a data-bind="attr: """),format.raw/*22.29*/("""{"""),format.raw/*22.30*/(""" href: '/ticket/' + ticketId() """),format.raw/*22.61*/("""}"""),format.raw/*22.62*/(""""><span data-bind="text: ticketId"></span>: <span data-bind="attr: """),format.raw/*22.129*/("""{"""),format.raw/*22.130*/(""" href: '/ticket/' + ticketId() """),format.raw/*22.161*/("""}"""),format.raw/*22.162*/(""", text: summary"></span></a></li>
    <!-- /ko -->
    <li><div class="alert alert-info">"""),_display_(Seq[Any](/*24.40*/Messages("general.milestones.empty"))),format.raw/*24.76*/("""</div></li>
   </ul>
   <div id="loading" style="display: none">
    <div class="progress progress-striped active">
     <div class="bar" style="width: 100%;"></div>
    </div>
   </div>
 </div>
 <div class="span6">
  <h2>"""),_display_(Seq[Any](/*33.8*/Messages("general.timeline"))),format.raw/*33.36*/("""</h2>
  <div class="alert alert-info" data-bind="display: events().total > 0">"""),_display_(Seq[Any](/*34.74*/Messages("general.timeline.empty"))),format.raw/*34.108*/("""</div>
  <div data-bind="if: events().total > 0">
   <ul class="media-list" data-bind="foreach: events().items">
    <li class="media">
     <a class="pull-left" data-bind="attr: """),format.raw/*38.44*/("""{"""),format.raw/*38.45*/(""" href: '/user/' + userId() """),format.raw/*38.72*/("""}"""),format.raw/*38.73*/(""""><img class="media-object" data-bind="attr: """),format.raw/*38.118*/("""{"""),format.raw/*38.119*/(""" src: 'https://secure.gravatar.com/avatar/' + userEmailDigest() + '?s=32' """),format.raw/*38.193*/("""}"""),format.raw/*38.194*/(""""></a>
     <div class="media-body">
      <h4 class="media-heading">
       <a data-bind="attr: """),format.raw/*41.28*/("""{"""),format.raw/*41.29*/(""" href: url() """),format.raw/*41.42*/("""}"""),format.raw/*41.43*/(""""><i data-bind="css: iconClass"></i></a> <span data-bind="i18nHtml: [ eType(), """),format.raw/*41.122*/("""{"""),format.raw/*41.123*/(""" 'user': userRealName(), 'id': eKey(), 'date': dateCreated() """),format.raw/*41.184*/("""}"""),format.raw/*41.185*/(""" ]"></span>
      </h4>
      <div class="media" data-bind="html: content"></div>
     </div>
    </li>
   </ul>
   <span data-bind="i18nText: [ 'pager_summary', """),format.raw/*47.50*/("""{"""),format.raw/*47.51*/(""" 'start': events().first(), 'finish': events().last(), 'total': events().total() """),format.raw/*47.132*/("""}"""),format.raw/*47.133*/(""" ]"></span>
   <div class="pagination pull-right">
    <ul>
     <li data-bind="click: function(data) """),format.raw/*50.43*/("""{"""),format.raw/*50.44*/(""" changePage(events().prev()) """),format.raw/*50.73*/("""}"""),format.raw/*50.74*/(""""><a><i class="icon-double-angle-left"></i></a></li>
     <!-- ko foreach: events().window -->
     <li data-bind="css: """),format.raw/*52.26*/("""{"""),format.raw/*52.27*/(""" active: $data == events().page() """),format.raw/*52.61*/("""}"""),format.raw/*52.62*/(""""><a data-bind="click: changePage, text: $data"></a></li>
     <!-- /ko -->
     <li data-bind="click: function(data) """),format.raw/*54.43*/("""{"""),format.raw/*54.44*/(""" changePage(events().next()) """),format.raw/*54.73*/("""}"""),format.raw/*54.74*/(""""><a><i class="icon-double-angle-right"></i></a></li>
    </ul>
   </div>
  </div>
 </div>
 <div class="span3">
  <h2>"""),_display_(Seq[Any](/*60.8*/Messages("project.summary.owner"))),format.raw/*60.41*/("""</h2>
  """),_display_(Seq[Any](/*61.4*/if(owner.isDefined)/*61.23*/ {_display_(Seq[Any](format.raw/*61.25*/("""
   """),_display_(Seq[Any](/*62.5*/owner/*62.10*/.map/*62.14*/ { o =>_display_(Seq[Any](format.raw/*62.21*/("""
   <div class="profile">
    """),_display_(Seq[Any](/*64.6*/gravatar(o.id.get))),format.raw/*64.24*/("""
    <div><i class="icon-user"></i> """),_display_(Seq[Any](/*65.37*/o/*65.38*/.realName)),format.raw/*65.47*/("""</div>
    <div><i class="icon-envelope"></i> <a href="mailto:"""),_display_(Seq[Any](/*66.57*/o/*66.58*/.username)),format.raw/*66.67*/("""">"""),_display_(Seq[Any](/*66.70*/o/*66.71*/.username)),format.raw/*66.80*/("""</a></div>
   </div>
   """)))})),format.raw/*68.5*/("""
  """)))}/*69.5*/else/*69.10*/{_display_(Seq[Any](format.raw/*69.11*/("""
    """),_display_(Seq[Any](/*70.6*/Messages("project.summary.unowned"))),format.raw/*70.41*/("""
  """)))})),format.raw/*71.4*/("""
 </div>
</div>
<script>
$(function()"""),format.raw/*75.13*/("""{"""),format.raw/*75.14*/("""
  var view = ProjectViewModel("""),_display_(Seq[Any](/*76.32*/Html(projectJson.toString))),format.raw/*76.58*/(""");
  ko.applyBindings(view);

  $(document).ajaxStart(function() """),format.raw/*79.36*/("""{"""),format.raw/*79.37*/("""
    $("#loading").show(0);
  """),format.raw/*81.3*/("""}"""),format.raw/*81.4*/(""").ajaxComplete(function() """),format.raw/*81.30*/("""{"""),format.raw/*81.31*/("""
    $("#loading").hide(0)
  """),format.raw/*83.3*/("""}"""),format.raw/*83.4*/(""");
"""),format.raw/*84.1*/("""}"""),format.raw/*84.2*/(""");
</script>
""")))})),format.raw/*86.2*/("""
"""))}
    }
    
    def render(project:models.Project,projectJson:play.api.libs.json.JsValue,owner:Option[models.User],request:AuthenticatedRequest): play.api.templates.HtmlFormat.Appendable = apply(project,projectJson,owner)(request)
    
    def f:((models.Project,play.api.libs.json.JsValue,Option[models.User]) => (AuthenticatedRequest) => play.api.templates.HtmlFormat.Appendable) = (project,projectJson,owner) => (request) => apply(project,projectJson,owner)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:17 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/project/item.scala.html
                    HASH: 655850f3c5b90dc4ffc6ce1295f528ea50c92eb6
                    MATRIX: 639->1|907->135|935->177|971->179|1073->273|1112->275|1379->506|1435->540|1482->551|1544->591|1614->625|1634->636|1692->672|1762->705|1826->746|1986->870|2041->903|2101->927|2116->933|2166->961|2205->964|2266->1003|2330->1031|2345->1037|2382->1052|2428->1062|2444->1069|2471->1074|2510->1077|2577->1121|2641->1149|2656->1155|2693->1170|2739->1180|2755->1187|2782->1192|2853->1227|2921->1272|2995->1310|3055->1348|3161->1426|3190->1427|3249->1458|3278->1459|3374->1526|3404->1527|3464->1558|3494->1559|3620->1649|3678->1685|3936->1908|3986->1936|4101->2015|4158->2049|4365->2228|4394->2229|4449->2256|4478->2257|4552->2302|4582->2303|4685->2377|4715->2378|4840->2475|4869->2476|4910->2489|4939->2490|5047->2569|5077->2570|5167->2631|5197->2632|5387->2794|5416->2795|5526->2876|5556->2877|5686->2979|5715->2980|5772->3009|5801->3010|5949->3130|5978->3131|6040->3165|6069->3166|6215->3284|6244->3285|6301->3314|6330->3315|6484->3434|6539->3467|6583->3476|6611->3495|6651->3497|6691->3502|6705->3507|6718->3511|6763->3518|6829->3549|6869->3567|6942->3604|6952->3605|6983->3614|7082->3677|7092->3678|7123->3687|7162->3690|7172->3691|7203->3700|7259->3725|7281->3730|7294->3735|7333->3736|7374->3742|7431->3777|7466->3781|7531->3818|7560->3819|7628->3851|7676->3877|7769->3942|7798->3943|7855->3973|7883->3974|7937->4000|7966->4001|8022->4030|8050->4031|8080->4034|8108->4035|8153->4049
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|32->10|32->10|32->10|32->10|34->12|34->12|34->12|34->12|34->12|38->16|38->16|39->17|39->17|39->17|39->17|39->17|40->18|40->18|40->18|40->18|40->18|40->18|40->18|40->18|41->19|41->19|41->19|41->19|41->19|41->19|41->19|41->19|42->20|42->20|44->22|44->22|44->22|44->22|44->22|44->22|44->22|44->22|46->24|46->24|55->33|55->33|56->34|56->34|60->38|60->38|60->38|60->38|60->38|60->38|60->38|60->38|63->41|63->41|63->41|63->41|63->41|63->41|63->41|63->41|69->47|69->47|69->47|69->47|72->50|72->50|72->50|72->50|74->52|74->52|74->52|74->52|76->54|76->54|76->54|76->54|82->60|82->60|83->61|83->61|83->61|84->62|84->62|84->62|84->62|86->64|86->64|87->65|87->65|87->65|88->66|88->66|88->66|88->66|88->66|88->66|90->68|91->69|91->69|91->69|92->70|92->70|93->71|97->75|97->75|98->76|98->76|101->79|101->79|103->81|103->81|103->81|103->81|105->83|105->83|106->84|106->84|108->86
                    -- GENERATED --
                */
            