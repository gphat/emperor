
package views.html

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Project],AuthenticatedRequest,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(projects: List[Project])(implicit request: AuthenticatedRequest):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import emp.DateFormatter

import emp.util.Links

import views.html.util._


Seq[Any](format.raw/*1.67*/("""

"""),format.raw/*6.1*/("""
"""),_display_(Seq[Any](/*7.2*/main(Messages("general.timeline"))/*7.36*/ {_display_(Seq[Any](format.raw/*7.38*/("""
<div class="row-fluid">
 <div class="span2">
  <ul class="nav nav-list well well-small search-well">
    <li class="head"><i class="icon-filter"></i> """),_display_(Seq[Any](/*11.51*/Messages("search.facet.filters"))),format.raw/*11.83*/("""</li>
    <span data-bind="visible: events().items().length == 0">"""),_display_(Seq[Any](/*12.62*/Messages("search.facet.none"))),format.raw/*12.91*/("""</span>
    <!-- ko foreach: filters -->
    <li class="filter"><a data-bind="click: removeFilter" class="btn btn-mini btn-danger"><span data-bind="i18nText: [ 'filter_link_name', """),format.raw/*14.140*/("""{"""),format.raw/*14.141*/(""" 'name': name(), 'value': i18n.t(value()) """),format.raw/*14.183*/("""}"""),format.raw/*14.184*/(""" ]"></span><i class="pull-right icon-remove"></i></a></li>
    <!-- /ko -->
    <!-- ko foreach: events().facetCollection -->
    <li class="nav-header" data-bind="text: nameI18N"><li>
     <ul class="nav nav-list-sub" data-bind="foreach: facets">
      <li><a data-bind="click: function(data, event) """),format.raw/*19.54*/("""{"""),format.raw/*19.55*/(""" addFilter(data, $parent) """),format.raw/*19.81*/("""}"""),format.raw/*19.82*/(""""><span data-bind="text: valueI18N"></span> <span class="badge pull-right" data-bind="text: count"></span></a></li>
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
 <h1>"""),_display_(Seq[Any](/*30.7*/Messages("general.timeline"))),format.raw/*30.35*/("""</h1>
  <div class="alert alert-info" data-bind="visible: events().total() == 0">"""),_display_(Seq[Any](/*31.77*/Messages("general.timeline.empty"))),format.raw/*31.111*/("""</div>
  <div data-bind="if: events().total() > 0">
   <ul class="media-list" data-bind="foreach: events().items">
    <li class="media">
     <a class="pull-left" data-bind="attr: """),format.raw/*35.44*/("""{"""),format.raw/*35.45*/(""" href: '/user/' + userId() """),format.raw/*35.72*/("""}"""),format.raw/*35.73*/(""""><img class="media-object" data-bind="attr: """),format.raw/*35.118*/("""{"""),format.raw/*35.119*/(""" src: 'https://secure.gravatar.com/avatar/' + userEmailDigest() + '?s=32' """),format.raw/*35.193*/("""}"""),format.raw/*35.194*/(""""></a>
     <div class="media-body">
      <h4 class="media-heading">
       <a data-bind="attr: """),format.raw/*38.28*/("""{"""),format.raw/*38.29*/(""" href: url() """),format.raw/*38.42*/("""}"""),format.raw/*38.43*/(""""><i data-bind="css: iconClass"></i></a> <span data-bind="i18nHtml: [ 'TLINE_' + eType(), """),format.raw/*38.133*/("""{"""),format.raw/*38.134*/(""" 'user': userRealName(), 'id': eKey(), 'date': dateCreated() """),format.raw/*38.195*/("""}"""),format.raw/*38.196*/(""" ]"></span>
      </h4>
      <div class="media" data-bind="html: content"></div>
     </div>
    </li>
   </ul>
   <span data-bind="i18nText: [ 'pager_summary', """),format.raw/*44.50*/("""{"""),format.raw/*44.51*/(""" 'start': events().first(), 'finish': events().last(), 'total': events().total() """),format.raw/*44.132*/("""}"""),format.raw/*44.133*/(""" ]"></span>
   <div class="pagination pull-right">
    <ul>
     <li data-bind="click: function(data) """),format.raw/*47.43*/("""{"""),format.raw/*47.44*/(""" changePage(events().prev()) """),format.raw/*47.73*/("""}"""),format.raw/*47.74*/(""""><a><i class="icon-double-angle-left"></i></a></li>
     <!-- ko foreach: events().window -->
     <li data-bind="css: """),format.raw/*49.26*/("""{"""),format.raw/*49.27*/(""" active: $data == events().page() """),format.raw/*49.61*/("""}"""),format.raw/*49.62*/(""""><a data-bind="click: changePage, text: $data"></a></li>
     <!-- /ko -->
     <li data-bind="click: function(data) """),format.raw/*51.43*/("""{"""),format.raw/*51.44*/(""" changePage(events().next()) """),format.raw/*51.73*/("""}"""),format.raw/*51.74*/(""""><a><i class="icon-double-angle-right"></i></a></li>
    </ul>
   </div>
  </div>
 </div>
</div>
<script>
$(function()"""),format.raw/*58.13*/("""{"""),format.raw/*58.14*/("""
  $(document).ajaxStart(function() """),format.raw/*59.36*/("""{"""),format.raw/*59.37*/("""
    $("#loading").show(0);
  """),format.raw/*61.3*/("""}"""),format.raw/*61.4*/(""").ajaxComplete(function() """),format.raw/*61.30*/("""{"""),format.raw/*61.31*/("""
    $("#loading").hide(0)
  """),format.raw/*63.3*/("""}"""),format.raw/*63.4*/(""");

  var view = TimelineViewModel();
  ko.applyBindings(view);
"""),format.raw/*67.1*/("""}"""),format.raw/*67.2*/(""");
</script>
""")))})),format.raw/*69.2*/("""
"""))}
    }
    
    def render(projects:List[Project],request:AuthenticatedRequest): play.api.templates.HtmlFormat.Appendable = apply(projects)(request)
    
    def f:((List[Project]) => (AuthenticatedRequest) => play.api.templates.HtmlFormat.Appendable) = (projects) => (request) => apply(projects)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:16 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/index.scala.html
                    HASH: fdc89d7067579d2b9ad2d1d6d2dfedeb7daa4f16
                    MATRIX: 584->1|817->66|845->143|881->145|923->179|962->181|1150->333|1204->365|1307->432|1358->461|1567->641|1597->642|1668->684|1698->685|2027->986|2056->987|2110->1013|2139->1014|2523->1363|2573->1391|2691->1473|2748->1507|2957->1688|2986->1689|3041->1716|3070->1717|3144->1762|3174->1763|3277->1837|3307->1838|3432->1935|3461->1936|3502->1949|3531->1950|3650->2040|3680->2041|3770->2102|3800->2103|3990->2265|4019->2266|4129->2347|4159->2348|4289->2450|4318->2451|4375->2480|4404->2481|4552->2601|4581->2602|4643->2636|4672->2637|4818->2755|4847->2756|4904->2785|4933->2786|5080->2905|5109->2906|5173->2942|5202->2943|5259->2973|5287->2974|5341->3000|5370->3001|5426->3030|5454->3031|5545->3095|5573->3096|5618->3110
                    LINES: 19->1|27->1|29->6|30->7|30->7|30->7|34->11|34->11|35->12|35->12|37->14|37->14|37->14|37->14|42->19|42->19|42->19|42->19|53->30|53->30|54->31|54->31|58->35|58->35|58->35|58->35|58->35|58->35|58->35|58->35|61->38|61->38|61->38|61->38|61->38|61->38|61->38|61->38|67->44|67->44|67->44|67->44|70->47|70->47|70->47|70->47|72->49|72->49|72->49|72->49|74->51|74->51|74->51|74->51|81->58|81->58|82->59|82->59|84->61|84->61|84->61|84->61|86->63|86->63|90->67|90->67|92->69
                    -- GENERATED --
                */
            