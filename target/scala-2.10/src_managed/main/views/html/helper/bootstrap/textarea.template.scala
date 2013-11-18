
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
 * Generate an HTML textarea.
 *
 * Example:
 * {{{
 * @textarea(field = myForm("address"), args = 'rows -> 3, 'cols -> 50)
 * }}}
 *
 * @param field The form field.
 * @param args Set of extra attributes.
 * @param handler The field constructor.
 */
object textarea extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[play.api.data.Field,String,Array[scala.Tuple2[Symbol, Any]],views.html.helper.FieldConstructor,play.api.i18n.Lang,play.api.templates.HtmlFormat.Appendable] {

    /**
 * Generate an HTML textarea.
 *
 * Example:
 * {{{
 * @textarea(field = myForm("address"), args = 'rows -> 3, 'cols -> 50)
 * }}}
 *
 * @param field The form field.
 * @param args Set of extra attributes.
 * @param handler The field constructor.
 */
    def apply/*13.2*/(field: play.api.data.Field, dataBind: String, args: (Symbol,Any)*)(implicit handler: views.html.helper.FieldConstructor, lang: play.api.i18n.Lang):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*13.149*/("""

"""),_display_(Seq[Any](/*15.2*/views/*15.7*/.html.helper.bootstrap.input(field, dataBind, args:_*)/*15.61*/ { (id, name, value, htmlArgs) =>_display_(Seq[Any](format.raw/*15.94*/("""
    <textarea id=""""),_display_(Seq[Any](/*16.20*/id)),format.raw/*16.22*/("""" data-bind=""""),_display_(Seq[Any](/*16.36*/dataBind)),format.raw/*16.44*/("""" name=""""),_display_(Seq[Any](/*16.53*/name)),format.raw/*16.57*/("""" """),_display_(Seq[Any](/*16.60*/toHtmlArgs(htmlArgs))),format.raw/*16.80*/(""">"""),_display_(Seq[Any](/*16.82*/value)),format.raw/*16.87*/("""</textarea>
""")))})))}
    }
    
    def render(field:play.api.data.Field,dataBind:String,args:Array[scala.Tuple2[Symbol, Any]],handler:views.html.helper.FieldConstructor,lang:play.api.i18n.Lang): play.api.templates.HtmlFormat.Appendable = apply(field,dataBind,args:_*)(handler,lang)
    
    def f:((play.api.data.Field,String,Array[scala.Tuple2[Symbol, Any]]) => (views.html.helper.FieldConstructor,play.api.i18n.Lang) => play.api.templates.HtmlFormat.Appendable) = (field,dataBind,args) => (handler,lang) => apply(field,dataBind,args:_*)(handler,lang)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:17 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/helper/bootstrap/textarea.scala.html
                    HASH: c9562a293ec1b31edfe9fb7cacebeda7711ac598
                    MATRIX: 1184->256|1427->403|1465->406|1478->411|1541->465|1612->498|1668->518|1692->520|1742->534|1772->542|1817->551|1843->555|1882->558|1924->578|1962->580|1989->585
                    LINES: 41->13|44->13|46->15|46->15|46->15|46->15|47->16|47->16|47->16|47->16|47->16|47->16|47->16|47->16|47->16|47->16
                    -- GENERATED --
                */
            