
package views.html.error

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
object missing extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*2.2*/verybare/*2.10*/ {_display_(Seq[Any](format.raw/*2.12*/("""
<h1>"""),_display_(Seq[Any](/*3.6*/Messages("missing.header"))),format.raw/*3.32*/("""</h1>
<h4>"""),_display_(Seq[Any](/*4.6*/Html(Messages("missing.blurb")))),format.raw/*4.37*/("""</h4>
""")))})),format.raw/*5.2*/("""
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:17 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/error/missing.scala.html
                    HASH: eee576a4f280dcc10517cb21711fbe137b927839
                    MATRIX: 654->2|670->10|709->12|749->18|796->44|841->55|893->86|930->93
                    LINES: 22->2|22->2|22->2|23->3|23->3|24->4|24->4|25->5
                    -- GENERATED --
                */
            