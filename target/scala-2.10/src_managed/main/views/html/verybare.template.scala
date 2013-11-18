
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
 * Very Bare template that does not assume anyone is logged in.  For use in places
 * like the error screens.
 */
object verybare extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Html,play.api.templates.HtmlFormat.Appendable] {

    /**
 * Very Bare template that does not assume anyone is logged in.  For use in places
 * like the error screens.
 */
    def apply/*5.2*/(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import views.html.util._


Seq[Any](format.raw/*5.17*/("""

"""),format.raw/*8.1*/("""
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Emperor: Error</title>
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
     """),_display_(Seq[Any](/*57.7*/content)),format.raw/*57.14*/("""
    </div>
    <footer>
	    """),_display_(Seq[Any](/*60.7*/Html(Messages("app.footer.blurb", emp.BuildInfo.version)))),format.raw/*60.64*/("""
	    <div class="pull-right">
	    <!-- A link to launch the Classic Widget -->
	    <a href="javascript:void(0)" data-uv-lightbox="classic_widget" data-uv-mode="full" data-uv-primary-color="#1abc9c" data-uv-link-color="#34495e" data-uv-default-mode="feedback" data-uv-forum-id="212933">Feedback &amp; Support</a>
	    </div>
   </footer>

    </footer>
  </body>
</html>
"""))}
    }
    
    def render(content:Html): play.api.templates.HtmlFormat.Appendable = apply(content)
    
    def f:((Html) => play.api.templates.HtmlFormat.Appendable) = (content) => apply(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:16 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/verybare.scala.html
                    HASH: 3ee0dbcd12bc0191eebd34851c80e2853ea0b51f
                    MATRIX: 783->119|917->134|945->162|1498->679|1513->685|1569->719|2081->1203|2110->1204|2457->1524|2485->1525|2933->1937|2948->1943|2983->1956|3121->2059|3150->2066|3216->2097|3295->2154
                    LINES: 25->5|29->5|31->8|43->20|43->20|43->20|56->33|56->33|60->37|60->37|75->52|75->52|75->52|80->57|80->57|83->60|83->60
                    -- GENERATED --
                */
            