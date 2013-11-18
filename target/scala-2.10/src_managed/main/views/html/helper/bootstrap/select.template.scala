
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
 * Generate an HTML select.
 *
 * Example:
 * {{{
 * @select(field = myForm("isDone"), options = options("Yes","No"))
 * }}}
 *
 * @param field The form field.
 * @param args Set of extra attributes.
 * @param handler The field constructor.
 */
object select extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[play.api.data.Field,String,Array[scala.Tuple2[Symbol, Any]],views.html.helper.FieldConstructor,play.api.i18n.Lang,play.api.templates.HtmlFormat.Appendable] {

    /**
 * Generate an HTML select.
 *
 * Example:
 * {{{
 * @select(field = myForm("isDone"), options = options("Yes","No"))
 * }}}
 *
 * @param field The form field.
 * @param args Set of extra attributes.
 * @param handler The field constructor.
 */
    def apply/*14.2*/(field: play.api.data.Field, dataBind: String, args: (Symbol,Any)*)(implicit handler: views.html.helper.FieldConstructor, lang: play.api.i18n.Lang):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*14.149*/("""

"""),_display_(Seq[Any](/*16.2*/views/*16.7*/.html.helper.bootstrap.input(field, dataBind, args:_*)/*16.61*/ { (id, name, value, htmlArgs) =>_display_(Seq[Any](format.raw/*16.94*/("""
    <select id=""""),_display_(Seq[Any](/*17.18*/id)),format.raw/*17.20*/("""" data-bind=""""),_display_(Seq[Any](/*17.34*/dataBind)),format.raw/*17.42*/("""" name=""""),_display_(Seq[Any](/*17.51*/name)),format.raw/*17.55*/("""" """),_display_(Seq[Any](/*17.58*/toHtmlArgs(htmlArgs))),format.raw/*17.78*/(""">
        """),_display_(Seq[Any](/*18.10*/args/*18.14*/.toMap.get('_default).map/*18.39*/ { defaultValue =>_display_(Seq[Any](format.raw/*18.57*/("""
            <option class="blank" value="">"""),_display_(Seq[Any](/*19.45*/defaultValue)),format.raw/*19.57*/("""</option>
        """)))})),format.raw/*20.10*/("""
    </select>
""")))})))}
    }
    
    def render(field:play.api.data.Field,dataBind:String,args:Array[scala.Tuple2[Symbol, Any]],handler:views.html.helper.FieldConstructor,lang:play.api.i18n.Lang): play.api.templates.HtmlFormat.Appendable = apply(field,dataBind,args:_*)(handler,lang)
    
    def f:((play.api.data.Field,String,Array[scala.Tuple2[Symbol, Any]]) => (views.html.helper.FieldConstructor,play.api.i18n.Lang) => play.api.templates.HtmlFormat.Appendable) = (field,dataBind,args) => (handler,lang) => apply(field,dataBind,args:_*)(handler,lang)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:17 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/helper/bootstrap/select.scala.html
                    HASH: 5835b27cfc554bbf8efb41676aacf1f72dce4632
                    MATRIX: 1170->251|1413->398|1451->401|1464->406|1527->460|1598->493|1652->511|1676->513|1726->527|1756->535|1801->544|1827->548|1866->551|1908->571|1955->582|1968->586|2002->611|2058->629|2139->674|2173->686|2224->705
                    LINES: 41->14|44->14|46->16|46->16|46->16|46->16|47->17|47->17|47->17|47->17|47->17|47->17|47->17|47->17|48->18|48->18|48->18|48->18|49->19|49->19|50->20
                    -- GENERATED --
                */
            