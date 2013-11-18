
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
object item extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[models.FullTicket,play.api.libs.json.JsValue,List[scala.Tuple2[String, String]],Form[models.Assignment],AuthenticatedRequest,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ticket: models.FullTicket,
  ticketJson: play.api.libs.json.JsValue,
  assignees: List[(String,String)],
  assignForm: Form[models.Assignment]
)(implicit request: AuthenticatedRequest):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import emp.DateFormatter

import emp.text.Renderer

import helper.bootstrap.bootstrapField

import views.html.util._


Seq[Any](format.raw/*5.42*/("""

"""),format.raw/*11.1*/("""
"""),_display_(Seq[Any](/*12.2*/main(title = Messages("ticket.page.title", ticket.ticketId, ticket.summary), currentProject = Some(ticket.project.id))/*12.120*/ {_display_(Seq[Any](format.raw/*12.122*/("""
  <div class="statuses">
   <div class="btn-group" data-bind="foreach: statuses, visible: !ticket().resolutionId()">
    <a class="btn" data-bind="click: pickStatus, css: """),format.raw/*15.55*/("""{"""),format.raw/*15.56*/(""" 'active': id() == ticket().workflowStatusId() """),format.raw/*15.103*/("""}"""),format.raw/*15.104*/(""""><i data-bind="visible: id() == ticket().workflowStatusId()" class="icon-map-marker"></i> <span data-bind="text: nameI18N"></span></a>
   </div>
  </div>

  <div class="card">
   <header data-bind="style: """),format.raw/*20.30*/("""{"""),format.raw/*20.31*/(""" backgroundColor: '#' + ticket().typeColor() """),format.raw/*20.76*/("""}"""),format.raw/*20.77*/("""">
    <hgroup>
     <a class="btn pull-left" href="/ticket/edit/"""),_display_(Seq[Any](/*22.51*/ticket/*22.57*/.ticketId)),format.raw/*22.66*/(""""><i class="icon-edit"></i></a>
     <h1><span data-bind="text: ticket().typeNameI18N"></span>: <span data-bind="text: ticket().summary"></span></h1>
     <h4>
      <a data-bind="attr: """),format.raw/*25.27*/("""{"""),format.raw/*25.28*/(""" href: '/project/' + ticket().projectId() """),format.raw/*25.70*/("""}"""),format.raw/*25.71*/(""", text: ticket().projectName"></a>: <span data-bind="text: ticket().ticketId"></span>
     </h4>
    </hgroup>
    <div class="pull-right">
    </div>
   </header>
   <div class="drawer" data-bind="template: """),format.raw/*31.45*/("""{"""),format.raw/*31.46*/(""" name: 'action-' + action() + '-template', if: action() """),format.raw/*31.102*/("""}"""),format.raw/*31.103*/(""", visible: action()"></div>
   <div class="description" data-bind="html: ticket().description"></div>
   <div class="card-info">
    <ul>
     <li>
      """),_display_(Seq[Any](/*36.8*/Messages("ticket.assignee"))),format.raw/*36.35*/("""
      <span data-bind="visible: ticket().assigneeId"><a class="action btn btn-small" data-bind="click: function(data) """),format.raw/*37.119*/("""{"""),format.raw/*37.120*/(""" action('assign') """),format.raw/*37.138*/("""}"""),format.raw/*37.139*/(""""><i class="icon-edit"></i> <span data-bind="text: ticket().assigneeName"></span></a></span>
      <span data-bind="visible: !ticket().assigneeId()"><a class="action btn btn-small" data-bind="click: function(data) """),format.raw/*38.122*/("""{"""),format.raw/*38.123*/(""" action('assign') """),format.raw/*38.141*/("""}"""),format.raw/*38.142*/(""""><i class="icon-edit"></i> <span>"""),_display_(Seq[Any](/*38.177*/Messages("ticket.unassigned"))),format.raw/*38.206*/("""</span></a></span>
     </li>
     <li>"""),_display_(Seq[Any](/*40.11*/Messages("ticket.reporter"))),format.raw/*40.38*/(""" <strong><a data-bind="attr: """),format.raw/*40.67*/("""{"""),format.raw/*40.68*/(""" href: '/user/' + ticket().userId() """),format.raw/*40.104*/("""}"""),format.raw/*40.105*/(""", text: ticket().userName"></a></strong></li>
     <li data-bind="style: """),format.raw/*41.28*/("""{"""),format.raw/*41.29*/(""" borderTopColor: '#' + ticket().priorityColor() """),format.raw/*41.77*/("""}"""),format.raw/*41.78*/("""">"""),_display_(Seq[Any](/*41.81*/Messages("ticket.priority"))),format.raw/*41.108*/(""" <strong data-bind="text: ticket().priorityNameI18N"></strong></li>
     <li data-bind="style: """),format.raw/*42.28*/("""{"""),format.raw/*42.29*/(""" borderTopColor: '#' + ticket().severityColor() """),format.raw/*42.77*/("""}"""),format.raw/*42.78*/("""">"""),_display_(Seq[Any](/*42.81*/Messages("ticket.severity"))),format.raw/*42.108*/(""" <strong data-bind="text: ticket().severityNameI18N"></strong></li>
     <li>"""),_display_(Seq[Any](/*43.11*/Messages("ticket.resolution"))),format.raw/*43.40*/(""" <strong data-bind="text: ticket().resolutionNameI18N"></strong></li>
     <li>
      <a class="btn btn-danger" data-bind="click: function(data) """),format.raw/*45.66*/("""{"""),format.raw/*45.67*/(""" action('unresolve') """),format.raw/*45.88*/("""}"""),format.raw/*45.89*/(""", visible: ticket().resolutionId()"><i class="icon-remove-sign"></i> """),_display_(Seq[Any](/*45.159*/Messages("ticket.unresolve"))),format.raw/*45.187*/("""</a>
      <a class="btn btn-success" data-bind="click: function(data) """),format.raw/*46.67*/("""{"""),format.raw/*46.68*/(""" action('resolve') """),format.raw/*46.87*/("""}"""),format.raw/*46.88*/(""", visible: !ticket().resolutionId()"><i class="icon-check-sign"></i> """),_display_(Seq[Any](/*46.158*/Messages("ticket.resolve"))),format.raw/*46.184*/("""</a>
     </li>
    </ul>
   </div>
  </div>

  <div id="loading" style="display: none; margin-top: 5px">
   <div class="progress progress-striped active">
    <div class="bar" style="width: 100%;"></div>
   </div>
  </div>

  <div id="link-body" ng-show="links.length > 0">
   <h4>"""),_display_(Seq[Any](/*59.9*/Messages("ticket.links"))),format.raw/*59.33*/(""" <a class="pull-right btn btn-small" data-bind="click: function(data) """),format.raw/*59.103*/("""{"""),format.raw/*59.104*/(""" action('link') """),format.raw/*59.120*/("""}"""),format.raw/*59.121*/("""" class="btn"><i class="icon-link"></i> """),_display_(Seq[Any](/*59.162*/Messages("ticket.action.link"))),format.raw/*59.192*/("""</a></h4>
    <table class="table table-striped table-condensed ticket-links">
     <tbody data-bind="foreach: links">
      <tr>
       <td class="type" data-bind="text: typeNameI18N"></td>
       <td data-bind="css: """),format.raw/*64.28*/("""{"""),format.raw/*64.29*/(""" resolved: childResolutionId """),format.raw/*64.58*/("""}"""),format.raw/*64.59*/("""" class="link"><a data-bind="attr: """),format.raw/*64.94*/("""{"""),format.raw/*64.95*/(""" href: '/ticket/' + childTicketId() """),format.raw/*64.131*/("""}"""),format.raw/*64.132*/(""", text: childTicketId"></a></td>
       <td data-bind="text: childSummary" class="link"></td>
       <td class="actions"><a data-bind="click: removeLink"><i class="remover icon-remove"></a></td>
      </tr>
     </tbody>
    </table>
  </div>
  <div id="tabarea">
   <ul class="nav nav-tabs nav-append-content">
    <li data-bind="css: """),format.raw/*73.25*/("""{"""),format.raw/*73.26*/(""" active: tab() == 'comments' """),format.raw/*73.55*/("""}"""),format.raw/*73.56*/(""""><a data-bind="click: function() """),format.raw/*73.90*/("""{"""),format.raw/*73.91*/(""" changeTab('comments') """),format.raw/*73.114*/("""}"""),format.raw/*73.115*/("""">"""),_display_(Seq[Any](/*73.118*/Messages("ticket.comment.list"))),format.raw/*73.149*/("""</a></li>
    <li data-bind="css: """),format.raw/*74.25*/("""{"""),format.raw/*74.26*/(""" active: tab() == 'commits' """),format.raw/*74.54*/("""}"""),format.raw/*74.55*/(""""><a data-bind="click: function() """),format.raw/*74.89*/("""{"""),format.raw/*74.90*/(""" changeTab('commits') """),format.raw/*74.112*/("""}"""),format.raw/*74.113*/("""">"""),_display_(Seq[Any](/*74.116*/Messages("ticket.commit.list"))),format.raw/*74.146*/("""</a></li>
    <li data-bind="css: """),format.raw/*75.25*/("""{"""),format.raw/*75.26*/(""" active: tab() == 'history' """),format.raw/*75.54*/("""}"""),format.raw/*75.55*/(""""><a data-bind="click: function() """),format.raw/*75.89*/("""{"""),format.raw/*75.90*/(""" changeTab('history') """),format.raw/*75.112*/("""}"""),format.raw/*75.113*/("""">"""),_display_(Seq[Any](/*75.116*/Messages("ticket.history.list"))),format.raw/*75.147*/("""</a></li>
   </ul>
   <div class="tab-content" data-bind="template: """),format.raw/*77.50*/("""{"""),format.raw/*77.51*/(""" name: tab() + '-template' """),format.raw/*77.78*/("""}"""),format.raw/*77.79*/(""""></div>
  </div>

<script type="text/html" id="action-assign-template">
 <form>
  <div class="control-group">
   <label class="control-label" for="intendedAssignee">"""),_display_(Seq[Any](/*83.57*/Messages("ticket.assignee"))),format.raw/*83.84*/("""</label>
   <select data-bind="options: assignees, optionsText: 'realName', optionsValue: 'id', value: intendedAssignee" required ng-model="intendedAssignee" id="intendedAssignee" name="intendedAssignee"></select>
  </div>
  <textarea rows="2" data-bind="value: actionComment" placeholder=""""),_display_(Seq[Any](/*86.69*/Messages("ticket.comment.placeholder"))),format.raw/*86.107*/("""" class="span12"></textarea>
  <div class="form-actions">
   <a class="btn" data-bind="click: clearAll">"""),_display_(Seq[Any](/*88.48*/Messages("form.cancel"))),format.raw/*88.71*/("""</a>
   <button type="submit" data-bind="click: doAssign" class="btn btn-primary">"""),_display_(Seq[Any](/*89.79*/Messages("form.submit"))),format.raw/*89.102*/("""</button>
  </div>
 </form>
</script>
<script type="text/html" id="action-link-template">
 <form name="linkForm" ng-submit="doLink()">
  <div class="control-group">
   <label class="control-label" for="linkTypeId">"""),_display_(Seq[Any](/*96.51*/Messages("ticket.linktype"))),format.raw/*96.78*/("""</label>
   <div class="controls">
    <select data-bind="options: linkTypes, optionsText: 'nameI18N', optionsValue: 'id', value: linkTypeId" id="linkTypeId"></select>
   </div>
  </div>
  <ul class="unstyled inline" data-bind="foreach: intendedLinkTickets">
   <li><span class="label label-info label-removable"><span data-bind="text: ticketId"></span> &nbsp;<a class="remover" data-bind="click: function(il) """),format.raw/*102.152*/("""{"""),format.raw/*102.153*/(""" intendedLinkTickets.remove(il) """),format.raw/*102.185*/("""}"""),format.raw/*102.186*/(""""><i class="icon-remove"></i></a></span></li>
  </ul>
  <div class="control-group">
   <label class="control-label" for="linkTick">"""),_display_(Seq[Any](/*105.49*/Messages("ticket.linkticket"))),format.raw/*105.78*/("""</label>
   <div class="controls">
    <input type="text" data-bind="value: instantLinkSearch, valueUpdate: 'keyup'" id="linkTick" name="linkTick" class="span2">
   </div>
  </div>
  <ul data-bind="foreach: linkTickets">
   <li><a data-bind="click: function(data) """),format.raw/*111.44*/("""{"""),format.raw/*111.45*/(""" if(intendedLinkTickets.indexOf(data) < 0) """),format.raw/*111.88*/("""{"""),format.raw/*111.89*/(""" intendedLinkTickets.push(data) """),format.raw/*111.121*/("""}"""),format.raw/*111.122*/(""" """),format.raw/*111.123*/("""}"""),format.raw/*111.124*/(""""><span data-bind="text: ticketId"></span> <span data-bind="text: summary"></span></a></li>
  </ul>
  <div class="form-actions">
   <a class="btn" data-bind="click: clearAll">"""),_display_(Seq[Any](/*114.48*/Messages("form.cancel"))),format.raw/*114.71*/("""</a>
   <button type="submit" data-bind="click: doLink" class="btn btn-primary">"""),_display_(Seq[Any](/*115.77*/Messages("form.submit"))),format.raw/*115.100*/("""</button>
  </div>
 </form>
</script>
<script type="text/html" id="action-resolve-template">
 <form>
  <div class="control-group">
   <label class="control-label" for="resolutionId">"""),_display_(Seq[Any](/*122.53*/Messages("ticket.resolution"))),format.raw/*122.82*/("""</label>
   <select data-bind="options: resolutions, optionsText: 'nameI18N', optionsValue: 'id', value: intendedResolution"></select>
  </div>
  <textarea rows="2" data-bind="value: actionComment" placeholder=""""),_display_(Seq[Any](/*125.69*/Messages("ticket.comment.placeholder"))),format.raw/*125.107*/("""" class="span12"></textarea>
  <div class="form-actions">
   <a class="btn" data-bind="click: clearAll">"""),_display_(Seq[Any](/*127.48*/Messages("form.cancel"))),format.raw/*127.71*/("""</a>
   <button type="submit" data-bind="click: doResolve" class="btn btn-primary">"""),_display_(Seq[Any](/*128.80*/Messages("form.submit"))),format.raw/*128.103*/("""</button>
  </div>
 </form>
</script>
<script type="text/html" id="action-status-template">
 <form>
  <textarea rows="2" data-bind="value: actionComment" placeholder=""""),_display_(Seq[Any](/*134.69*/Messages("ticket.comment.placeholder"))),format.raw/*134.107*/("""" class="span12"></textarea>
  <div class="form-actions">
   <a class="btn" data-bind="click: clearAll">"""),_display_(Seq[Any](/*136.48*/Messages("form.cancel"))),format.raw/*136.71*/("""</a>
   <button type="submit" data-bind="click: doChangeStatus" class="btn btn-primary">"""),_display_(Seq[Any](/*137.85*/Messages("form.submit"))),format.raw/*137.108*/("""</button>
  </div>
 </form>
</script>
<script type="text/html" id="action-unresolve-template">
 <form>
  <textarea rows="2" data-bind="value: actionComment" placeholder=""""),_display_(Seq[Any](/*143.69*/Messages("ticket.comment.placeholder"))),format.raw/*143.107*/("""" class="span12"></textarea>
  <div class="form-actions">
   <a class="btn" data-bind="click: clearAll">"""),_display_(Seq[Any](/*145.48*/Messages("form.cancel"))),format.raw/*145.71*/("""</a>
   <button type="submit" data-bind="click: doUnResolve" class="btn btn-primary">"""),_display_(Seq[Any](/*146.82*/Messages("form.submit"))),format.raw/*146.105*/("""</button>
  </div>
 </form>
</script>
<script type="text/html" id="comments-template">
 <ul class="media-list" data-bind="foreach: comments">
  <li class="media">
   <a class="pull-left" data-bind="attr: """),format.raw/*153.42*/("""{"""),format.raw/*153.43*/(""" href: '/user/' + userId() """),format.raw/*153.70*/("""}"""),format.raw/*153.71*/(""""><img class="media-object" data-bind="attr: """),format.raw/*153.116*/("""{"""),format.raw/*153.117*/(""" src: 'https://secure.gravatar.com/avatar/' + userEmailDigest() + '?s=32' """),format.raw/*153.191*/("""}"""),format.raw/*153.192*/(""""></a>
   <div class="media-body">
    <h4 class="media-heading"><a data-bind="attr: """),format.raw/*155.51*/("""{"""),format.raw/*155.52*/(""" name: 'comment-' + id() """),format.raw/*155.77*/("""}"""),format.raw/*155.78*/(""""></a>"""),_display_(Seq[Any](/*155.85*/Messages("ticket.comment.attribution.prefix"))),format.raw/*155.130*/(""" <a data-bind="attr: """),format.raw/*155.151*/("""{"""),format.raw/*155.152*/(""" href: '/user/' + userId() """),format.raw/*155.179*/("""}"""),format.raw/*155.180*/(""", text: userRealName"></a> """),_display_(Seq[Any](/*155.208*/Messages("ticket.comment.postfix"))),format.raw/*155.242*/(""" <time data-bind="attr: """),format.raw/*155.266*/("""{"""),format.raw/*155.267*/(""" datetime: dateCreated(), title: dateCreated() """),format.raw/*155.314*/("""}"""),format.raw/*155.315*/(""", text: dateCreated()"></time></h4>
    <div class="media"><span data-bind="html: content"></span></div>
   </div>
  </li>
 </ul>
 <form class="form-linline comment">
  <fieldset>
   <button data-bind="click: doComment" class="btn btn-primary"  style="vertical-align: top"><i class="icon-check"></i> """),_display_(Seq[Any](/*162.122*/Messages("ticket.comment"))),format.raw/*162.148*/("""</button>
   <textarea class="span12" rows="1" data-bind="value: comment" name="comment" id="comment" placeholder=""""),_display_(Seq[Any](/*163.107*/Messages("ticket.comment.placeholder"))),format.raw/*163.145*/(""""></textarea>
  </fieldset>
 </form>
</script>
<script type="text/html" id="commits-template">
 <ul class="media-list" data-bind="foreach: commits">
  <li class="media">
   <a class="pull-left" data-bind="attr: """),format.raw/*170.42*/("""{"""),format.raw/*170.43*/(""" href: '/user/' + userId """),format.raw/*170.68*/("""}"""),format.raw/*170.69*/(""""><img class="media-object" data-bind="attr: """),format.raw/*170.114*/("""{"""),format.raw/*170.115*/(""" src: 'https://secure.gravatar.com/avatar/' + userEmailDigest() + '?s=32' """),format.raw/*170.189*/("""}"""),format.raw/*170.190*/(""""></a>
   <div class="media-body">
    <h4 class="media-heading"><a data-bind="attr: """),format.raw/*172.51*/("""{"""),format.raw/*172.52*/(""" name: 'comment-' + id() """),format.raw/*172.77*/("""}"""),format.raw/*172.78*/(""""></a>"""),_display_(Seq[Any](/*172.85*/Messages("ticket.comment.attribution.prefix"))),format.raw/*172.130*/(""" <a data-bind="attr: """),format.raw/*172.151*/("""{"""),format.raw/*172.152*/(""" href: '/user/' + userId() """),format.raw/*172.179*/("""}"""),format.raw/*172.180*/(""", text: userRealName"></a> """),_display_(Seq[Any](/*172.208*/Messages("ticket.comment.postfix"))),format.raw/*172.242*/(""" <time data-bind="attr: """),format.raw/*172.266*/("""{"""),format.raw/*172.267*/(""" datetime: dateCreated(), title: dateCreated() """),format.raw/*172.314*/("""}"""),format.raw/*172.315*/(""", text: dateCreated()"></time></h4>
    <div class="media" data-bind="html: content"></div>
   </div>
  </li>
 </ul>
</script>
<script type="text/html" id="history-template">
</script>

<script>
$(function()"""),format.raw/*182.13*/("""{"""),format.raw/*182.14*/("""
  $(document).ajaxStart(function() """),format.raw/*183.36*/("""{"""),format.raw/*183.37*/("""
    $("#loading").show(0);
  """),format.raw/*185.3*/("""}"""),format.raw/*185.4*/(""").ajaxComplete(function() """),format.raw/*185.30*/("""{"""),format.raw/*185.31*/("""
    $("#loading").hide(0)
  """),format.raw/*187.3*/("""}"""),format.raw/*187.4*/(""");

  var view = TicketViewModel("""),_display_(Seq[Any](/*189.31*/Html(ticketJson.toString))),format.raw/*189.56*/(""");
  ko.applyBindings(view);
"""),format.raw/*191.1*/("""}"""),format.raw/*191.2*/(""");
</script>
""")))})),format.raw/*193.2*/("""
"""))}
    }
    
    def render(ticket:models.FullTicket,ticketJson:play.api.libs.json.JsValue,assignees:List[scala.Tuple2[String, String]],assignForm:Form[models.Assignment],request:AuthenticatedRequest): play.api.templates.HtmlFormat.Appendable = apply(ticket,ticketJson,assignees,assignForm)(request)
    
    def f:((models.FullTicket,play.api.libs.json.JsValue,List[scala.Tuple2[String, String]],Form[models.Assignment]) => (AuthenticatedRequest) => play.api.templates.HtmlFormat.Appendable) = (ticket,ticketJson,assignees,assignForm) => (request) => apply(ticket,ticketJson,assignees,assignForm)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:17 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/ticket/item.scala.html
                    HASH: f4eaaeeb8dd12f8fee75653309744ee919105884
                    MATRIX: 680->1|1076->186|1105->306|1142->308|1270->426|1311->428|1511->600|1540->601|1616->648|1646->649|1880->855|1909->856|1982->901|2011->902|2113->968|2128->974|2159->983|2373->1169|2402->1170|2472->1212|2501->1213|2737->1421|2766->1422|2851->1478|2881->1479|3071->1634|3120->1661|3268->1780|3298->1781|3345->1799|3375->1800|3618->2014|3648->2015|3695->2033|3725->2034|3797->2069|3849->2098|3925->2138|3974->2165|4031->2194|4060->2195|4125->2231|4155->2232|4256->2305|4285->2306|4361->2354|4390->2355|4429->2358|4479->2385|4602->2480|4631->2481|4707->2529|4736->2530|4775->2533|4825->2560|4939->2638|4990->2667|5163->2812|5192->2813|5241->2834|5270->2835|5377->2905|5428->2933|5527->3004|5556->3005|5603->3024|5632->3025|5739->3095|5788->3121|6106->3404|6152->3428|6251->3498|6281->3499|6326->3515|6356->3516|6434->3557|6487->3587|6733->3805|6762->3806|6819->3835|6848->3836|6911->3871|6940->3872|7005->3908|7035->3909|7399->4245|7428->4246|7485->4275|7514->4276|7576->4310|7605->4311|7657->4334|7687->4335|7727->4338|7781->4369|7843->4403|7872->4404|7928->4432|7957->4433|8019->4467|8048->4468|8099->4490|8129->4491|8169->4494|8222->4524|8284->4558|8313->4559|8369->4587|8398->4588|8460->4622|8489->4623|8540->4645|8570->4646|8610->4649|8664->4680|8760->4748|8789->4749|8844->4776|8873->4777|9076->4944|9125->4971|9452->5262|9513->5300|9654->5405|9699->5428|9818->5511|9864->5534|10115->5749|10164->5776|10604->6186|10635->6187|10697->6219|10728->6220|10897->6352|10949->6381|11242->6645|11272->6646|11344->6689|11374->6690|11436->6722|11467->6723|11498->6724|11529->6725|11742->6901|11788->6924|11906->7005|11953->7028|12173->7211|12225->7240|12474->7452|12536->7490|12678->7595|12724->7618|12845->7702|12892->7725|13097->7893|13159->7931|13301->8036|13347->8059|13473->8148|13520->8171|13728->8342|13790->8380|13932->8485|13978->8508|14101->8594|14148->8617|14381->8821|14411->8822|14467->8849|14497->8850|14572->8895|14603->8896|14707->8970|14738->8971|14852->9056|14882->9057|14936->9082|14966->9083|15010->9090|15079->9135|15130->9156|15161->9157|15218->9184|15249->9185|15315->9213|15373->9247|15427->9271|15458->9272|15535->9319|15566->9320|15905->9621|15955->9647|16109->9763|16171->9801|16411->10012|16441->10013|16495->10038|16525->10039|16600->10084|16631->10085|16735->10159|16766->10160|16880->10245|16910->10246|16964->10271|16994->10272|17038->10279|17107->10324|17158->10345|17189->10346|17246->10373|17277->10374|17343->10402|17401->10436|17455->10460|17486->10461|17563->10508|17594->10509|17830->10716|17860->10717|17925->10753|17955->10754|18013->10784|18042->10785|18097->10811|18127->10812|18184->10841|18213->10842|18284->10876|18332->10901|18389->10930|18418->10931|18464->10945
                    LINES: 19->1|33->5|35->11|36->12|36->12|36->12|39->15|39->15|39->15|39->15|44->20|44->20|44->20|44->20|46->22|46->22|46->22|49->25|49->25|49->25|49->25|55->31|55->31|55->31|55->31|60->36|60->36|61->37|61->37|61->37|61->37|62->38|62->38|62->38|62->38|62->38|62->38|64->40|64->40|64->40|64->40|64->40|64->40|65->41|65->41|65->41|65->41|65->41|65->41|66->42|66->42|66->42|66->42|66->42|66->42|67->43|67->43|69->45|69->45|69->45|69->45|69->45|69->45|70->46|70->46|70->46|70->46|70->46|70->46|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|88->64|88->64|88->64|88->64|88->64|88->64|88->64|88->64|97->73|97->73|97->73|97->73|97->73|97->73|97->73|97->73|97->73|97->73|98->74|98->74|98->74|98->74|98->74|98->74|98->74|98->74|98->74|98->74|99->75|99->75|99->75|99->75|99->75|99->75|99->75|99->75|99->75|99->75|101->77|101->77|101->77|101->77|107->83|107->83|110->86|110->86|112->88|112->88|113->89|113->89|120->96|120->96|126->102|126->102|126->102|126->102|129->105|129->105|135->111|135->111|135->111|135->111|135->111|135->111|135->111|135->111|138->114|138->114|139->115|139->115|146->122|146->122|149->125|149->125|151->127|151->127|152->128|152->128|158->134|158->134|160->136|160->136|161->137|161->137|167->143|167->143|169->145|169->145|170->146|170->146|177->153|177->153|177->153|177->153|177->153|177->153|177->153|177->153|179->155|179->155|179->155|179->155|179->155|179->155|179->155|179->155|179->155|179->155|179->155|179->155|179->155|179->155|179->155|179->155|186->162|186->162|187->163|187->163|194->170|194->170|194->170|194->170|194->170|194->170|194->170|194->170|196->172|196->172|196->172|196->172|196->172|196->172|196->172|196->172|196->172|196->172|196->172|196->172|196->172|196->172|196->172|196->172|206->182|206->182|207->183|207->183|209->185|209->185|209->185|209->185|211->187|211->187|213->189|213->189|215->191|215->191|217->193
                    -- GENERATED --
                */
            