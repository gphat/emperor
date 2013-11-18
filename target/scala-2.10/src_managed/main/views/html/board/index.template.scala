
package views.html.board

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[models.Project,Seq[models.WorkflowStatus],AuthenticatedRequest,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(project: models.Project, workflow: Seq[models.WorkflowStatus])(implicit request: AuthenticatedRequest):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import emp.JsonFormats._

import emp.util.Links

import play.api.libs.json.Json


Seq[Any](format.raw/*1.105*/("""

"""),format.raw/*6.1*/("""
"""),_display_(Seq[Any](/*7.2*/main(currentProject = Some(project.id.get), title = Messages("general.board"))/*7.80*/ {_display_(Seq[Any](format.raw/*7.82*/("""
<a id="helper" class="btn btn-mini btn-success"><i class="icon-question-sign"></i></a>
<div id="help" class="alert alert-info" style="display: none">
 <button id="helpcloser" type="button" class="close">&times;</button>
 <strong>"""),_display_(Seq[Any](/*11.11*/Messages("help.kanban.title"))),format.raw/*11.40*/("""</strong> """),_display_(Seq[Any](/*11.51*/Html(Messages("help.kanban.blurb")))),format.raw/*11.86*/("""
</div>
<h1>"""),_display_(Seq[Any](/*13.6*/Messages("board.title", project.name))),format.raw/*13.43*/("""</h1>
<div class="row-fluid">
 <div class="span2">
  <ul class="nav nav-list well well-small search-well">
    <li class="head"><i class="icon-filter"></i> """),_display_(Seq[Any](/*17.51*/Messages("search.facet.filters"))),format.raw/*17.83*/("""</li>
    <span data-bind="visible: pager().items().length == 0">"""),_display_(Seq[Any](/*18.61*/Messages("search.facet.none"))),format.raw/*18.90*/("""</span>
    <!-- ko foreach: filters -->
    <li class="filter"><a id="help" data-bind="click: removeFilter" style="text-align: left" class="btn btn-mini btn-danger"><span data-bind="i18nText: [ 'filter_link_name', """),format.raw/*20.175*/("""{"""),format.raw/*20.176*/(""" 'name': name(), 'value': i18n.t(valueI18N()) """),format.raw/*20.222*/("""}"""),format.raw/*20.223*/(""" ]"></span><i class="icon-remove pull-right"></i></a></li>
    <!-- /ko -->
    <!-- ko foreach: pager().facetCollection -->
    <li class="nav-header" data-bind="text: nameI18N"><li>
    <!-- ko foreach: facets -->
    <li><a data-bind="click: function(data, event) """),format.raw/*25.52*/("""{"""),format.raw/*25.53*/(""" addFilter(data, $parent) """),format.raw/*25.79*/("""}"""),format.raw/*25.80*/(""""><span data-bind="text: valueI18N"></span> <span class="badge pull-right" data-bind="text: count"></span></a></li>
    <!-- /ko -->
    <!-- /ko -->
  </ul>
  <div id="loading" style="display: none">
   <div class="progress progress-striped active">
    <div class="bar" style="width: 100%;"></div>
   </div>
  </div>
 </div>
 <div class="span10 board">
  <div>
   <div class="alert alert-info" data-bind="visible: empty">"""),_display_(Seq[Any](/*37.62*/Messages("general.board.empty"))),format.raw/*37.93*/("""</div>
  </div>
  <div data-bind="visible: intendedMover" class="drawer">
  <form>
   <p>"""),_display_(Seq[Any](/*41.8*/Messages("board.confirm.status"))),format.raw/*41.40*/(""" <strong data-bind="text: intendedStatus().nameI18N"></strong></p>
   <textarea rows="2" data-bind="value: statusComment" placeholder=""""),_display_(Seq[Any](/*42.70*/Messages("ticket.comment.placeholder"))),format.raw/*42.108*/("""" class="span12"></textarea>
   <div class="form-actions">
   <a class="btn" data-bind="click: clearAll">"""),_display_(Seq[Any](/*44.48*/Messages("form.cancel"))),format.raw/*44.71*/("""</a>
    <button type="submit" data-bind="click: doMove" class="btn btn-primary">"""),_display_(Seq[Any](/*45.78*/Messages("form.submit"))),format.raw/*45.101*/("""</button>
   </div>
  </form>
  </div>
  <div class="columns">
   <div class="wrapper">
   """),_display_(Seq[Any](/*51.5*/workflow/*51.13*/.map/*51.17*/{ status =>_display_(Seq[Any](format.raw/*51.28*/("""
    <div class="column">
     <h5>"""),_display_(Seq[Any](/*53.11*/Messages(status.name))),format.raw/*53.32*/("""</h5>
     <ul data-status-id=""""),_display_(Seq[Any](/*54.27*/status/*54.33*/.id)),format.raw/*54.36*/("""" data-status-name-i18n=""""),_display_(Seq[Any](/*54.62*/Messages(status.name))),format.raw/*54.83*/("""" data-bind="event: """),format.raw/*54.103*/("""{"""),format.raw/*54.104*/(""" dragenter: highlight, dragover: dragOver, dragleave: unhighlight, drop: drop """),format.raw/*54.182*/("""}"""),format.raw/*54.183*/(""", foreach: columns['"""),_display_(Seq[Any](/*54.204*/{status.name})),format.raw/*54.217*/("""']">
      <li draggable="true" data-bind="attr: """),format.raw/*55.45*/("""{"""),format.raw/*55.46*/(""" id: ticketId """),format.raw/*55.60*/("""}"""),format.raw/*55.61*/(""", event: """),format.raw/*55.70*/("""{"""),format.raw/*55.71*/(""" dragstart: dragStart, dragend: dragEnd """),format.raw/*55.111*/("""}"""),format.raw/*55.112*/(""""><span class="label" data-bind="style: """),format.raw/*55.152*/("""{"""),format.raw/*55.153*/(""" 'backgroundColor': '#' + typeColor() """),format.raw/*55.191*/("""}"""),format.raw/*55.192*/(""", text: typeNameI18N"></span><a data-bind="text: ticketId, attr: """),format.raw/*55.257*/("""{"""),format.raw/*55.258*/(""" href: url """),format.raw/*55.269*/("""}"""),format.raw/*55.270*/(""""></a>: <span data-bind="html: summary"></span></li>
     </ul>
    </div>
   """)))})),format.raw/*58.5*/("""
   </div>
  </div>
 </div>
</div>
<script>
$(function()"""),format.raw/*64.13*/("""{"""),format.raw/*64.14*/("""
  $(document).ajaxStart(function() """),format.raw/*65.36*/("""{"""),format.raw/*65.37*/("""
    $("#loading").show(0);
  """),format.raw/*67.3*/("""}"""),format.raw/*67.4*/(""").ajaxComplete(function() """),format.raw/*67.30*/("""{"""),format.raw/*67.31*/("""
    $("#loading").hide(0)
  """),format.raw/*69.3*/("""}"""),format.raw/*69.4*/(""");

  var view = BoardViewModel(""""),_display_(Seq[Any](/*71.31*/project/*71.38*/.name)),format.raw/*71.43*/("""", """),_display_(Seq[Any](/*71.47*/Html(Json.toJson(workflow).toString))),format.raw/*71.83*/(""");
  ko.applyBindings(view);
"""),format.raw/*73.1*/("""}"""),format.raw/*73.2*/(""");
</script>
""")))})),format.raw/*75.2*/("""
"""))}
    }
    
    def render(project:models.Project,workflow:Seq[models.WorkflowStatus],request:AuthenticatedRequest): play.api.templates.HtmlFormat.Appendable = apply(project,workflow)(request)
    
    def f:((models.Project,Seq[models.WorkflowStatus]) => (AuthenticatedRequest) => play.api.templates.HtmlFormat.Appendable) = (project,workflow) => (request) => apply(project,workflow)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:17 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/board/index.scala.html
                    HASH: f4bb371c8037c97ec3aa302b311ed4c02f514cf1
                    MATRIX: 618->1|896->104|924->187|960->189|1046->267|1085->269|1352->500|1403->529|1450->540|1507->575|1555->588|1614->625|1807->782|1861->814|1963->880|2014->909|2258->1124|2288->1125|2363->1171|2393->1172|2688->1439|2717->1440|2771->1466|2800->1467|3260->1891|3313->1922|3438->2012|3492->2044|3664->2180|3725->2218|3867->2324|3912->2347|4030->2429|4076->2452|4203->2544|4220->2552|4233->2556|4282->2567|4354->2603|4397->2624|4465->2656|4480->2662|4505->2665|4567->2691|4610->2712|4659->2732|4689->2733|4796->2811|4826->2812|4884->2833|4920->2846|4997->2895|5026->2896|5068->2910|5097->2911|5134->2920|5163->2921|5232->2961|5262->2962|5331->3002|5361->3003|5428->3041|5458->3042|5552->3107|5582->3108|5622->3119|5652->3120|5762->3199|5846->3255|5875->3256|5939->3292|5968->3293|6025->3323|6053->3324|6107->3350|6136->3351|6192->3380|6220->3381|6290->3415|6306->3422|6333->3427|6373->3431|6431->3467|6487->3496|6515->3497|6560->3511
                    LINES: 19->1|27->1|29->6|30->7|30->7|30->7|34->11|34->11|34->11|34->11|36->13|36->13|40->17|40->17|41->18|41->18|43->20|43->20|43->20|43->20|48->25|48->25|48->25|48->25|60->37|60->37|64->41|64->41|65->42|65->42|67->44|67->44|68->45|68->45|74->51|74->51|74->51|74->51|76->53|76->53|77->54|77->54|77->54|77->54|77->54|77->54|77->54|77->54|77->54|77->54|77->54|78->55|78->55|78->55|78->55|78->55|78->55|78->55|78->55|78->55|78->55|78->55|78->55|78->55|78->55|78->55|78->55|81->58|87->64|87->64|88->65|88->65|90->67|90->67|90->67|90->67|92->69|92->69|94->71|94->71|94->71|94->71|94->71|96->73|96->73|98->75
                    -- GENERATED --
                */
            