
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
object error extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Request[AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(implicit request: Request[AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.41*/("""
<div class="alert alert-block alert-error">
  <h4 class="alert-heading">"""),_display_(Seq[Any](/*3.30*/Messages("general.error"))),format.raw/*3.55*/("""</h4>
  """),_display_(Seq[Any](/*4.4*/Messages("ticket.statuschange.error"))),format.raw/*4.41*/("""
</div>
"""))}
    }
    
    def render(request:Request[AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(request)
    
    def f:((Request[AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (request) => apply(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:17 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/ticket/error.scala.html
                    HASH: 7abf2f62aa5c20573520858597a4efc01108e104
                    MATRIX: 576->1|709->40|818->114|864->139|907->148|965->185
                    LINES: 19->1|22->1|24->3|24->3|25->4|25->4
                    -- GENERATED --
                */
            