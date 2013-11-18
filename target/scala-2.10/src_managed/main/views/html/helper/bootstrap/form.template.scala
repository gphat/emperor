
package views.html.helper.bootstrap

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
/**
 * Generate an HTML form.
 *
 * Example:
 * {{{
 * @form(action = routes.Users.submit, args = 'class -> "myForm") {
 *   ...
 * }
 * }}}
 *
 * @param action The submit action.
 * @param args Set of extra HTML attributes.
 * @param body The form body.
 */
object form extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[play.api.mvc.Call,String,Array[scala.Tuple2[Symbol, String]],Html,play.api.templates.HtmlFormat.Appendable] {

    /**
 * Generate an HTML form.
 *
 * Example:
 * {{{
 * @form(action = routes.Users.submit, args = 'class -> "myForm") {
 *   ...
 * }
 * }}}
 *
 * @param action The submit action.
 * @param args Set of extra HTML attributes.
 * @param body The form body.
 */
    def apply/*15.2*/(action: play.api.mvc.Call, dataBind: String, args: (Symbol,String)*)(body: => Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*15.86*/("""

<form action=""""),_display_(Seq[Any](/*17.16*/action/*17.22*/.url)),format.raw/*17.26*/("""" data-bind=""""),_display_(Seq[Any](/*17.40*/dataBind)),format.raw/*17.48*/("""" method=""""),_display_(Seq[Any](/*17.59*/action/*17.65*/.method)),format.raw/*17.72*/("""" """),_display_(Seq[Any](/*17.75*/toHtmlArgs(args.toMap))),format.raw/*17.97*/(""">
    """),_display_(Seq[Any](/*18.6*/body)),format.raw/*18.10*/("""
</form>"""))}
    }
    
    def render(action:play.api.mvc.Call,dataBind:String,args:Array[scala.Tuple2[Symbol, String]],body:Html): play.api.templates.HtmlFormat.Appendable = apply(action,dataBind,args:_*)(body)
    
    def f:((play.api.mvc.Call,String,Array[scala.Tuple2[Symbol, String]]) => ( => Html) => play.api.templates.HtmlFormat.Appendable) = (action,dataBind,args) => (body) => apply(action,dataBind,args:_*)(body)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:17 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/helper/bootstrap/form.scala.html
                    HASH: eafe6823c00ab68dd99a553c911e739273646705
                    MATRIX: 1140->260|1319->344|1372->361|1387->367|1413->371|1463->385|1493->393|1540->404|1555->410|1584->417|1623->420|1667->442|1709->449|1735->453
                    LINES: 45->15|48->15|50->17|50->17|50->17|50->17|50->17|50->17|50->17|50->17|50->17|50->17|51->18|51->18
                    -- GENERATED --
                */
            