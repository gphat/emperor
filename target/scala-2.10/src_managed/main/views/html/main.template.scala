
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
 * Main template for use by all of Emperor's pages.
 */
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[String,Option[Long],Html,AuthenticatedRequest,play.api.templates.HtmlFormat.Appendable] {

    /**
 * Main template for use by all of Emperor's pages.
 */
    def apply/*4.2*/(title: String, currentProject: Option[Long] = None)(content: Html)(implicit request: AuthenticatedRequest):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.api.Play.current

import play.api.Play

import views.html.util._


Seq[Any](format.raw/*4.109*/("""

"""),format.raw/*9.1*/("""
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Emperor: """),_display_(Seq[Any](/*14.22*/title)),format.raw/*14.27*/("""</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
    <link rel="stylesheet" href=""""),_display_(Seq[Any](/*20.35*/routes/*20.41*/.Assets.at("stylesheets/bootstrap-modal.css"))),format.raw/*20.86*/("""">
    <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href=""""),_display_(Seq[Any](/*22.35*/routes/*22.41*/.Assets.at("stylesheets/main.css"))),format.raw/*22.75*/("""">
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/handlebars.js/1.0.0/handlebars.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/knockout/2.3.0/knockout-min.js"></script>
    <script src=""""),_display_(Seq[Any](/*27.19*/routes/*27.25*/.Assets.at("js/URI.js"))),format.raw/*27.48*/(""""></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/datejs/1.0/date.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/underscore.js/1.5.1/underscore.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/i18next/1.6.3/i18next-1.6.3.min.js"></script>
    <!--[if lt IE 9]>
      <script src="https://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    """),_display_(Seq[Any](/*34.6*/if(Play.isProd)/*34.21*/ {_display_(Seq[Any](format.raw/*34.23*/("""
    <script type="text/javascript">

      var _gaq = _gaq || [];
      _gaq.push(['_setAccount', 'UA-34502059-1']);
      _gaq.push(['_trackPageview']);

      (function() """),format.raw/*41.19*/("""{"""),format.raw/*41.20*/("""
        var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
      """),format.raw/*45.7*/("""}"""),format.raw/*45.8*/(""")();

    </script>
    """)))})),format.raw/*48.6*/("""
  </head>

  <body>

    <div class="navbar">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class="brand" href=""""),_display_(Seq[Any](/*56.35*/routes/*56.41*/.Core.index())),format.raw/*56.54*/("""">Emperor</a>
          """),_display_(Seq[Any](/*57.12*/topmenu(currentProject = currentProject)/*57.52*/(request))),format.raw/*57.61*/("""
        </div>
      </div>
    </div>
    <div class="container-fluid">
     <div id="alert-area">
      """),_display_(Seq[Any](/*63.8*/{ request.flash.get("success") match {
        case Some(message) => {
          <div class="alert alert-success">
           <a class="close" data-dismiss="alert" href="#">&times;</a>
           { Messages(message) }
          </div>
        }
        case None => { }
      }
      })),format.raw/*72.8*/("""
      """),_display_(Seq[Any](/*73.8*/{ request.flash.get("error") match {
        case Some(message) => {
          <div class="alert alert-error">
           <a class="close" data-dismiss="alert" href="#">&times;</a>
           { Messages(message) }
          </div>
        }
        case None => { }
      }
      })),format.raw/*82.8*/("""
      """),_display_(Seq[Any](/*83.8*/{ request.flash.get("info") match {
        case Some(message) => {
          <div class="alert alert-info">
           <a class="close" data-dismiss="alert" href="#">&times;</a>
           { Messages(message) }
          </div>
        }
        case None => { }
      }
      })),format.raw/*92.8*/("""
     </div>
     """),_display_(Seq[Any](/*94.7*/content)),format.raw/*94.14*/("""
    </div>

   <footer>
    """),_display_(Seq[Any](/*98.6*/Html(Messages("app.footer.blurb", emp.BuildInfo.version)))),format.raw/*98.63*/("""
    <div class="pull-right">
    <a href="http://emperorapp.com/docs" target="_blank">"""),_display_(Seq[Any](/*100.59*/Messages("general.documentation"))),format.raw/*100.92*/("""</a>
    <i class="icon-ellipsis-vertical"></i>
    <!-- A link to launch the Classic Widget -->
    <a href="javascript:void(0)" data-uv-lightbox="classic_widget" data-uv-mode="full" data-uv-primary-color="#1abc9c" data-uv-link-color="#34495e" data-uv-default-mode="feedback" data-uv-forum-id="212933">"""),_display_(Seq[Any](/*103.208*/Html(Messages("general.support")))),format.raw/*103.241*/("""</a>
    </div>
   </footer>
   <script src=""""),_display_(Seq[Any](/*106.18*/routes/*106.24*/.Assets.at("js/emp.js"))),format.raw/*106.47*/(""""></script>
   <!-- XXX This should go -->
   <script id="alerter" type="text/x-handlebars-template">
    <div class="alert """),format.raw/*109.23*/("""{"""),format.raw/*109.24*/("""{"""),format.raw/*109.25*/("""alert_class"""),format.raw/*109.36*/("""}"""),format.raw/*109.37*/("""}"""),format.raw/*109.38*/("""">
     <a class="close" data-dismiss="alert" href="#">&times;</a>
     """),format.raw/*111.6*/("""{"""),format.raw/*111.7*/("""{"""),format.raw/*111.8*/("""message"""),format.raw/*111.15*/("""}"""),format.raw/*111.16*/("""}"""),format.raw/*111.17*/("""
    </div>
   </script>
   <!-- UserVoice JavaScript SDK (only needed once on a page) -->
   <script>(function()"""),format.raw/*115.23*/("""{"""),format.raw/*115.24*/("""var uv=document.createElement('script');uv.type='text/javascript';uv.async=true;uv.src='//widget.uservoice.com/k2vsMPS6yFIY0fUsksUaQ.js';var s=document.getElementsByTagName('script')[0];s.parentNode.insertBefore(uv,s)"""),format.raw/*115.241*/("""}"""),format.raw/*115.242*/(""")()</script>
  </body>
</html>
"""))}
    }
    
    def render(title:String,currentProject:Option[Long],content:Html,request:AuthenticatedRequest): play.api.templates.HtmlFormat.Appendable = apply(title,currentProject)(content)(request)
    
    def f:((String,Option[Long]) => (Html) => (AuthenticatedRequest) => play.api.templates.HtmlFormat.Appendable) = (title,currentProject) => (content) => (request) => apply(title,currentProject)(content)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:16 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/main.scala.html
                    HASH: 7d895206a79390876b516335954755e90efcfb0c
                    MATRIX: 704->61|983->168|1011->248|1138->339|1165->344|1522->665|1537->671|1604->716|1778->854|1793->860|1849->894|2283->1292|2298->1298|2343->1321|2791->1734|2815->1749|2855->1751|3057->1925|3086->1926|3433->2246|3461->2247|3517->2272|3705->2424|3720->2430|3755->2443|3816->2468|3865->2508|3896->2517|4039->2625|4345->2910|4388->2918|4690->3199|4733->3207|5033->3486|5087->3505|5116->3512|5181->3542|5260->3599|5385->3687|5441->3720|5783->4024|5840->4057|5923->4103|5939->4109|5985->4132|6138->4256|6168->4257|6198->4258|6238->4269|6268->4270|6298->4271|6398->4343|6427->4344|6456->4345|6492->4352|6522->4353|6552->4354|6694->4467|6724->4468|6971->4685|7002->4686
                    LINES: 23->4|31->4|33->9|38->14|38->14|44->20|44->20|44->20|46->22|46->22|46->22|51->27|51->27|51->27|58->34|58->34|58->34|65->41|65->41|69->45|69->45|72->48|80->56|80->56|80->56|81->57|81->57|81->57|87->63|96->72|97->73|106->82|107->83|116->92|118->94|118->94|122->98|122->98|124->100|124->100|127->103|127->103|130->106|130->106|130->106|133->109|133->109|133->109|133->109|133->109|133->109|135->111|135->111|135->111|135->111|135->111|135->111|139->115|139->115|139->115|139->115
                    -- GENERATED --
                */
            