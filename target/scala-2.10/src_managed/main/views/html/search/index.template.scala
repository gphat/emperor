
package views.html.search

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[AuthenticatedRequest,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(implicit request: AuthenticatedRequest):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import emp.util.Links

import views.html.util._


Seq[Any](format.raw/*1.42*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main(Messages("search.results"))/*6.34*/ {_display_(Seq[Any](format.raw/*6.36*/("""
<div class="row-fluid">
 <div class="span2">
  <ul class="nav nav-list well well-small search-well">
    <li class="head"><i class="icon-filter"></i> """),_display_(Seq[Any](/*10.51*/Messages("search.facet.filters"))),format.raw/*10.83*/("""</li>
    <span data-bind="visible: pager().items().length == 0">"""),_display_(Seq[Any](/*11.61*/Messages("search.facet.none"))),format.raw/*11.90*/("""</span>
    <!-- ko foreach: filters -->
    <li class="filter"><a data-bind="click: removeFilter" class="btn btn-mini btn-danger"><span data-bind="i18nText: [ 'filter_link_name', """),format.raw/*13.140*/("""{"""),format.raw/*13.141*/(""" 'name': name(), 'value': i18n.t(value()) """),format.raw/*13.183*/("""}"""),format.raw/*13.184*/(""" ]"></span><i class="pull-right icon-remove"></i></a></li>
    <!-- /ko -->
    <!-- ko foreach: pager().facetCollection -->
    <li class="nav-header" data-bind="text: nameI18N"><li>
     <ul class="nav nav-list-sub" data-bind="foreach: facets">
      <li><a data-bind="click: function(data, event) """),format.raw/*18.54*/("""{"""),format.raw/*18.55*/(""" addFilter(data, $parent) """),format.raw/*18.81*/("""}"""),format.raw/*18.82*/(""""><span data-bind="text: valueI18N"></span> <span class="badge pull-right" data-bind="text: count"></span></a></li>
     </ul>
    <!-- /ko -->
  </ul>
  <div id="loading" style="display: none">
   <div class="progress progress-striped active">
    <div class="bar" style="width: 100%;"></div>
   </div>
  </div>
 </div>
 <div class="span10">
  <div data-bind="visible: pager().items().length == 0" class="alert alert-warning">"""),_display_(Seq[Any](/*29.86*/Messages("search.results.none"))),format.raw/*29.117*/("""</div>
  <table class="table table-bordered table-hover table-rounded table-striped ticket-search" data-bind="visible: pager().items().length > 0">
   <thead>
    <th><a href="#" data-bind="click: function(data, event) """),format.raw/*32.61*/("""{"""),format.raw/*32.62*/(""" changeSort('id', data, event) """),format.raw/*32.93*/("""}"""),format.raw/*32.94*/("""">"""),_display_(Seq[Any](/*32.97*/Messages("ticket.ticket"))),format.raw/*32.122*/("""</a></th>
    <th><a data-bind="click: function(data, event) """),format.raw/*33.52*/("""{"""),format.raw/*33.53*/(""" changeSort('type', data, event) """),format.raw/*33.86*/("""}"""),format.raw/*33.87*/("""">"""),_display_(Seq[Any](/*33.90*/Messages("ticket.type"))),format.raw/*33.113*/("""</a></th>
    <th><a data-bind="click: function(data, event) """),format.raw/*34.52*/("""{"""),format.raw/*34.53*/(""" changeSort('status', data, event) """),format.raw/*34.88*/("""}"""),format.raw/*34.89*/("""">"""),_display_(Seq[Any](/*34.92*/Messages("ticket.status"))),format.raw/*34.117*/("""</a></th>
    <th>"""),_display_(Seq[Any](/*35.10*/Messages("ticket.summary"))),format.raw/*35.36*/("""</th>
    <th><a data-bind="click: function(data, event) """),format.raw/*36.52*/("""{"""),format.raw/*36.53*/(""" changeSort('priority', data, event) """),format.raw/*36.90*/("""}"""),format.raw/*36.91*/("""">"""),_display_(Seq[Any](/*36.94*/Messages("ticket.priority"))),format.raw/*36.121*/("""</a></th>
    <th><a data-bind="click: function(data, event) """),format.raw/*37.52*/("""{"""),format.raw/*37.53*/(""" changeSort('severity', data, event) """),format.raw/*37.90*/("""}"""),format.raw/*37.91*/("""">"""),_display_(Seq[Any](/*37.94*/Messages("ticket.severity"))),format.raw/*37.121*/("""</a></th>
   </thead>
   <tbody data-bind="foreach: pager().items">
    <tr data-bind="css: """),format.raw/*40.25*/("""{"""),format.raw/*40.26*/(""" resolved: resolutionId """),format.raw/*40.50*/("""}"""),format.raw/*40.51*/("""">
     <td style="width: 10%"><a data-bind="attr: """),format.raw/*41.49*/("""{"""),format.raw/*41.50*/(""" href: url """),format.raw/*41.61*/("""}"""),format.raw/*41.62*/(""", text: ticketId"></a></td>
     <td><span class="label" data-bind="style: """),format.raw/*42.48*/("""{"""),format.raw/*42.49*/(""" 'backgroundColor': '#' + typeColor() """),format.raw/*42.87*/("""}"""),format.raw/*42.88*/(""", text: typeNameI18N"></span></td>
     <td><span class="label" data-bind="text: statusNameI18N, visible: !resolutionId()"></span></td>
     <td style="width: 80%"><a data-bind="attr: """),format.raw/*44.49*/("""{"""),format.raw/*44.50*/(""" href: url """),format.raw/*44.61*/("""}"""),format.raw/*44.62*/(""", html: summary"></a></td>
     <td><span class="label" data-bind="style: """),format.raw/*45.48*/("""{"""),format.raw/*45.49*/(""" 'backgroundColor': '#' + priorityColor() """),format.raw/*45.91*/("""}"""),format.raw/*45.92*/(""", text: priorityNameI18N"></span></td>
     <td><span class="label" data-bind="style: """),format.raw/*46.48*/("""{"""),format.raw/*46.49*/(""" 'backgroundColor': '#' + severityColor() """),format.raw/*46.91*/("""}"""),format.raw/*46.92*/(""", text: severityNameI18N"></span></td>
    </tr>
   </tbody>
   <tfoot>
    <tr>
     <td colspan="7">
      <span data-bind="i18nText: [ 'pager_summary', """),format.raw/*52.53*/("""{"""),format.raw/*52.54*/(""" 'start': pager().first(), 'finish': pager().last(), 'total': pager().total() """),format.raw/*52.132*/("""}"""),format.raw/*52.133*/(""" ]"></span>
      <div class="pagination pull-right">
        <ul>
          <li data-bind="click: function(data) """),format.raw/*55.48*/("""{"""),format.raw/*55.49*/(""" changePage(pager().prev()) """),format.raw/*55.77*/("""}"""),format.raw/*55.78*/(""", css: """),format.raw/*55.85*/("""{"""),format.raw/*55.86*/(""" disabled: pager().noPrev """),format.raw/*55.112*/("""}"""),format.raw/*55.113*/(""""><a><i class="icon-double-angle-left"></i></a></li>
          <!-- ko foreach: pager().window -->
          <li data-bind="css: """),format.raw/*57.31*/("""{"""),format.raw/*57.32*/(""" active: $data == pager().page() """),format.raw/*57.65*/("""}"""),format.raw/*57.66*/(""""><a data-bind="click: changePage, text: $data"></a></li>
          <!-- /ko -->
          <li data-bind="click: function(data) """),format.raw/*59.48*/("""{"""),format.raw/*59.49*/(""" changePage(pager().next()) """),format.raw/*59.77*/("""}"""),format.raw/*59.78*/(""", css: """),format.raw/*59.85*/("""{"""),format.raw/*59.86*/(""" disabled: pager().noNext """),format.raw/*59.112*/("""}"""),format.raw/*59.113*/(""""><a><i class="icon-double-angle-right"></i></a></li>
        </ul>
      </div>
     </td>
    </tr>
   </tfoot>
  </table>
 </div>
</div>
<script>
$(function()"""),format.raw/*69.13*/("""{"""),format.raw/*69.14*/("""
  $(document).ajaxStart(function() """),format.raw/*70.36*/("""{"""),format.raw/*70.37*/("""
    $("#loading").show(0);
  """),format.raw/*72.3*/("""}"""),format.raw/*72.4*/(""").ajaxComplete(function() """),format.raw/*72.30*/("""{"""),format.raw/*72.31*/("""
    $("#loading").hide(0)
  """),format.raw/*74.3*/("""}"""),format.raw/*74.4*/(""");

  var view = SearchViewModel();
  ko.applyBindings(view);

  // window.onpopstate = function(event) """),format.raw/*79.42*/("""{"""),format.raw/*79.43*/("""
  //   console.log(event);
  // """),format.raw/*81.6*/("""}"""),format.raw/*81.7*/("""

"""),format.raw/*83.1*/("""}"""),format.raw/*83.2*/(""");
</script>
""")))})),format.raw/*85.2*/("""
"""))}
    }
    
    def render(request:AuthenticatedRequest): play.api.templates.HtmlFormat.Appendable = apply(request)
    
    def f:((AuthenticatedRequest) => play.api.templates.HtmlFormat.Appendable) = (request) => apply(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:17 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/search/index.scala.html
                    HASH: fd39c8a9452bb6db996e37b6171f33b06ad34bc3
                    MATRIX: 577->1|759->41|787->92|823->94|863->126|902->128|1090->280|1144->312|1246->378|1297->407|1506->587|1536->588|1607->630|1637->631|1965->931|1994->932|2048->958|2077->959|2541->1387|2595->1418|2842->1637|2871->1638|2930->1669|2959->1670|2998->1673|3046->1698|3135->1759|3164->1760|3225->1793|3254->1794|3293->1797|3339->1820|3428->1881|3457->1882|3520->1917|3549->1918|3588->1921|3636->1946|3691->1965|3739->1991|3824->2048|3853->2049|3918->2086|3947->2087|3986->2090|4036->2117|4125->2178|4154->2179|4219->2216|4248->2217|4287->2220|4337->2247|4457->2339|4486->2340|4538->2364|4567->2365|4646->2416|4675->2417|4714->2428|4743->2429|4846->2504|4875->2505|4941->2543|4970->2544|5182->2728|5211->2729|5250->2740|5279->2741|5381->2815|5410->2816|5480->2858|5509->2859|5623->2945|5652->2946|5722->2988|5751->2989|5934->3144|5963->3145|6070->3223|6100->3224|6242->3338|6271->3339|6327->3367|6356->3368|6391->3375|6420->3376|6475->3402|6505->3403|6662->3532|6691->3533|6752->3566|6781->3567|6937->3695|6966->3696|7022->3724|7051->3725|7086->3732|7115->3733|7170->3759|7200->3760|7389->3921|7418->3922|7482->3958|7511->3959|7568->3989|7596->3990|7650->4016|7679->4017|7735->4046|7763->4047|7895->4151|7924->4152|7984->4185|8012->4186|8041->4188|8069->4189|8114->4203
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|32->10|32->10|33->11|33->11|35->13|35->13|35->13|35->13|40->18|40->18|40->18|40->18|51->29|51->29|54->32|54->32|54->32|54->32|54->32|54->32|55->33|55->33|55->33|55->33|55->33|55->33|56->34|56->34|56->34|56->34|56->34|56->34|57->35|57->35|58->36|58->36|58->36|58->36|58->36|58->36|59->37|59->37|59->37|59->37|59->37|59->37|62->40|62->40|62->40|62->40|63->41|63->41|63->41|63->41|64->42|64->42|64->42|64->42|66->44|66->44|66->44|66->44|67->45|67->45|67->45|67->45|68->46|68->46|68->46|68->46|74->52|74->52|74->52|74->52|77->55|77->55|77->55|77->55|77->55|77->55|77->55|77->55|79->57|79->57|79->57|79->57|81->59|81->59|81->59|81->59|81->59|81->59|81->59|81->59|91->69|91->69|92->70|92->70|94->72|94->72|94->72|94->72|96->74|96->74|101->79|101->79|103->81|103->81|105->83|105->83|107->85
                    -- GENERATED --
                */
            