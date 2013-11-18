
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
object error extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*3.2*/verybare/*3.10*/ {_display_(Seq[Any](format.raw/*3.12*/("""
<h1>"""),_display_(Seq[Any](/*4.6*/Messages("error.header"))),format.raw/*4.30*/("""</h1>
<h4>"""),_display_(Seq[Any](/*5.6*/Html(Messages("error.blurb")))),format.raw/*5.35*/("""</h4>
""")))})),format.raw/*6.2*/("""
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:17 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/error/error.scala.html
                    HASH: d27a6ce5921237dc9ebd91d67a7661f0d50d61ca
                    MATRIX: 652->3|668->11|707->13|747->19|792->43|837->54|887->83|924->90
                    LINES: 22->3|22->3|22->3|23->4|23->4|24->5|24->5|25->6
                    -- GENERATED --
                */
            