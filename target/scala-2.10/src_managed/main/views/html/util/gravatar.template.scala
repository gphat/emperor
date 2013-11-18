
package views.html.util

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
 * Generate a gravatar img tag.
 */
object gravatar extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Long,Int,Request[AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**
 * Generate a gravatar img tag.
 */
    def apply/*4.2*/(userId: Long, size: Int = 64)(implicit request: Request[AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import org.apache.commons.codec.digest.DigestUtils

import models.UserModel


Seq[Any](format.raw/*4.71*/("""

"""),format.raw/*8.1*/("""
"""),_display_(Seq[Any](/*9.2*/UserModel/*9.11*/.getById(userId).map/*9.31*/ { user =>_display_(Seq[Any](format.raw/*9.41*/("""
<img class="media-object" src="https://secure.gravatar.com/avatar/"""),_display_(Seq[Any](/*10.68*/{ DigestUtils.md5Hex(user.username.trim.toLowerCase) })),format.raw/*10.122*/("""?s="""),_display_(Seq[Any](/*10.126*/size)),format.raw/*10.130*/("""">
""")))})),format.raw/*11.2*/("""
"""))}
    }
    
    def render(userId:Long,size:Int,request:Request[AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(userId,size)(request)
    
    def f:((Long,Int) => (Request[AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (userId,size) => (request) => apply(userId,size)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:18 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/util/gravatar.scala.html
                    HASH: 23e77716892c99691b5cdd922d84754b7271c46c
                    MATRIX: 656->41|895->110|923->189|959->191|976->200|1004->220|1051->230|1155->298|1232->352|1273->356|1300->360|1335->364
                    LINES: 23->4|29->4|31->8|32->9|32->9|32->9|32->9|33->10|33->10|33->10|33->10|34->11
                    -- GENERATED --
                */
            