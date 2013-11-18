
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
 * Generate an HTML input text.
 *
 * Example:
 * {{{
 * @inputText(field = myForm("name"), args = 'size -> 10, 'placeholder -> "Your name")
 * }}}
 *
 * @param field The form field.
 * @param args Set of extra attributes.
 * @param handler The field constructor.
 */
object inputText extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[play.api.data.Field,String,Array[scala.Tuple2[Symbol, Any]],views.html.helper.FieldConstructor,play.api.i18n.Lang,play.api.templates.HtmlFormat.Appendable] {

    /**
 * Generate an HTML input text.
 *
 * Example:
 * {{{
 * @inputText(field = myForm("name"), args = 'size -> 10, 'placeholder -> "Your name")
 * }}}
 *
 * @param field The form field.
 * @param args Set of extra attributes.
 * @param handler The field constructor.
 */
    def apply/*13.2*/(field: play.api.data.Field, dataBind: String, args: (Symbol,Any)*)(implicit handler: views.html.helper.FieldConstructor, lang: play.api.i18n.Lang):play.api.templates.HtmlFormat.Appendable = {
        _display_ {
def /*15.2*/inputType/*15.11*/ = {{ args.toMap.get('type).map(_.toString).getOrElse("text") }};
Seq[Any](format.raw/*13.149*/("""

"""),format.raw/*15.74*/("""

"""),_display_(Seq[Any](/*17.2*/views/*17.7*/.html.helper.bootstrap.input(field, dataBind, args.filter(_._1 != 'type):_*)/*17.83*/ { (id, name, value, htmlArgs) =>_display_(Seq[Any](format.raw/*17.116*/("""
    <input type=""""),_display_(Seq[Any](/*18.19*/inputType)),format.raw/*18.28*/("""" data-bind=""""),_display_(Seq[Any](/*18.42*/dataBind)),format.raw/*18.50*/("""" id=""""),_display_(Seq[Any](/*18.57*/id)),format.raw/*18.59*/("""" name=""""),_display_(Seq[Any](/*18.68*/name)),format.raw/*18.72*/("""" value=""""),_display_(Seq[Any](/*18.82*/value)),format.raw/*18.87*/("""" """),_display_(Seq[Any](/*18.90*/toHtmlArgs(htmlArgs))),format.raw/*18.110*/(""">
""")))})))}
    }
    
    def render(field:play.api.data.Field,dataBind:String,args:Array[scala.Tuple2[Symbol, Any]],handler:views.html.helper.FieldConstructor,lang:play.api.i18n.Lang): play.api.templates.HtmlFormat.Appendable = apply(field,dataBind,args:_*)(handler,lang)
    
    def f:((play.api.data.Field,String,Array[scala.Tuple2[Symbol, Any]]) => (views.html.helper.FieldConstructor,play.api.i18n.Lang) => play.api.templates.HtmlFormat.Appendable) = (field,dataBind,args) => (handler,lang) => apply(field,dataBind,args:_*)(handler,lang)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:17 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/helper/bootstrap/inputText.scala.html
                    HASH: 292ee809e8459b2b3fb3d13e6c9b6496115c5e75
                    MATRIX: 1219->273|1444->423|1462->432|1557->420|1587->495|1625->498|1638->503|1723->579|1795->612|1850->631|1881->640|1931->654|1961->662|2004->669|2028->671|2073->680|2099->684|2145->694|2172->699|2211->702|2254->722
                    LINES: 41->13|43->15|43->15|44->13|46->15|48->17|48->17|48->17|48->17|49->18|49->18|49->18|49->18|49->18|49->18|49->18|49->18|49->18|49->18|49->18|49->18
                    -- GENERATED --
                */
            