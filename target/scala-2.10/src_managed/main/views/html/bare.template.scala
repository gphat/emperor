
package views.html

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
 * Bare template that does not assume anyone is logged in.  For use in places
 * like the login screen.
 */
object bare extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,Request[AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**
 * Bare template that does not assume anyone is logged in.  For use in places
 * like the login screen.
 */
    def apply/*5.2*/(title : String)(content: Html)(implicit request: Request[AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import views.html.util._


Seq[Any](format.raw/*5.72*/("""

"""),format.raw/*8.1*/("""
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Emperor: """),_display_(Seq[Any](/*13.22*/title)),format.raw/*13.27*/("""</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href=""""),_display_(Seq[Any](/*20.35*/routes/*20.41*/.Assets.at("stylesheets/main.css"))),format.raw/*20.75*/("""">
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>

    <!--[if lt IE 9]>
      <script src="https://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script type="text/javascript">

      var _gaq = _gaq || [];
      _gaq.push(['_setAccount', 'UA-34502059-1']);
      _gaq.push(['_trackPageview']);

      (function() """),format.raw/*33.19*/("""{"""),format.raw/*33.20*/("""
        var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
      """),format.raw/*37.7*/("""}"""),format.raw/*37.8*/(""")();

    </script>
  </head>

  <body>

    <div class="navbar navbar-inverse">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href=""""),_display_(Seq[Any](/*52.35*/routes/*52.41*/.Core.index())),format.raw/*52.54*/("""">Emperor</a>
        </div>
      </div>
    </div>
    <div class="container-fluid main-body">
      <div id="alert-area">
      """),_display_(Seq[Any](/*58.8*/{ request.flash.get("success") match {
        case Some(message) => {
          <div class="alert alert-success">
           <a class="close" data-dismiss="alert" href="#">&times;</a>
           { Messages(message) }
          </div>
        }
        case None => { }
      }
      })),format.raw/*67.8*/("""
      """),_display_(Seq[Any](/*68.8*/{ request.flash.get("error") match {
        case Some(message) => {
          <div class="alert alert-error">
           <a class="close" data-dismiss="alert" href="#">&times;</a>
           { Messages(message) }
          </div>
        }
        case None => { }
      }
      })),format.raw/*77.8*/("""
      """),_display_(Seq[Any](/*78.8*/{ request.flash.get("info") match {
        case Some(message) => {
          <div class="alert alert-info">
           <a class="close" data-dismiss="alert" href="#">&times;</a>
           { Messages(message) }
          </div>
        }
        case None => { }
      }
      })),format.raw/*87.8*/("""
     </div>
     """),_display_(Seq[Any](/*89.7*/content)),format.raw/*89.14*/("""
    </div>
    <footer>
     """),_display_(Seq[Any](/*92.7*/Html(Messages("app.footer.blurb", emp.BuildInfo.version)))),format.raw/*92.64*/("""
    </footer>
  </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html,request:Request[AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(title)(content)(request)
    
    def f:((String) => (Html) => (Request[AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => (request) => apply(title)(content)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:16 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/bare.scala.html
                    HASH: 006ace700d74a4a3942d8caa937791159f5b34be
                    MATRIX: 794->113|983->183|1011->211|1138->302|1165->307|1623->729|1638->735|1694->769|2206->1253|2235->1254|2582->1574|2610->1575|3058->1987|3073->1993|3108->2006|3275->2138|3581->2423|3624->2431|3926->2712|3969->2720|4269->2999|4323->3018|4352->3025|4418->3056|4497->3113
                    LINES: 25->5|29->5|31->8|36->13|36->13|43->20|43->20|43->20|56->33|56->33|60->37|60->37|75->52|75->52|75->52|81->58|90->67|91->68|100->77|101->78|110->87|112->89|112->89|115->92|115->92
                    -- GENERATED --
                */
            