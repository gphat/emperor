
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
 * Prepare a generic HTML input.
 */
object input extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[play.api.data.Field,String,Array[scala.Tuple2[Symbol, Any]],_root_.scala.Function4[String, String, Option[String], Map[Symbol, Any], Html],views.html.helper.FieldConstructor,play.api.i18n.Lang,play.api.templates.HtmlFormat.Appendable] {

    /**
 * Prepare a generic HTML input.
 */
    def apply/*4.2*/(field: play.api.data.Field, dataBind: String, args: (Symbol, Any)* )(inputDef: (String, String, Option[String], Map[Symbol,Any]) => Html)(implicit handler: views.html.helper.FieldConstructor, lang: play.api.i18n.Lang):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper.bootstrap.bootstrapField

import views.html.helper.FieldElements

def /*9.2*/id/*9.4*/ = {{ args.toMap.get('id).map(_.toString).getOrElse(field.id) }};
Seq[Any](format.raw/*4.220*/("""

"""),format.raw/*8.1*/("""
"""),format.raw/*9.67*/("""

"""),_display_(Seq[Any](/*11.2*/bootstrapField(
    FieldElements(
        id,
        field,
        inputDef(id, field.name, field.value, args.filter(arg => !arg._1.name.startsWith("_") && arg._1 != 'id).toMap),
        args.toMap,
        lang
    )
))),format.raw/*19.2*/("""
"""))}
    }
    
    def render(field:play.api.data.Field,dataBind:String,args:Array[scala.Tuple2[Symbol, Any]],inputDef:_root_.scala.Function4[String, String, Option[String], Map[Symbol, Any], Html],handler:views.html.helper.FieldConstructor,lang:play.api.i18n.Lang): play.api.templates.HtmlFormat.Appendable = apply(field,dataBind,args:_*)(inputDef)(handler,lang)
    
    def f:((play.api.data.Field,String,Array[scala.Tuple2[Symbol, Any]]) => (_root_.scala.Function4[String, String, Option[String], Map[Symbol, Any], Html]) => (views.html.helper.FieldConstructor,play.api.i18n.Lang) => play.api.templates.HtmlFormat.Appendable) = (field,dataBind,args) => (inputDef) => (handler,lang) => apply(field,dataBind,args:_*)(inputDef)(handler,lang)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:17 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/helper/bootstrap/input.scala.html
                    HASH: 86e8e1cd6b39703e2a2a30752120700dd82b6b29
                    MATRIX: 831->42|1205->344|1214->346|1308->260|1336->342|1364->409|1402->412|1645->634
                    LINES: 23->4|28->9|28->9|29->4|31->8|32->9|34->11|42->19
                    -- GENERATED --
                */
            