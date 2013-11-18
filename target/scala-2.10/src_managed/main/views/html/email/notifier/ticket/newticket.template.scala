
package views.html.email.notifier.ticket

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
object newticket extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[models.FullTicket,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ticket: models.FullTicket):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import emp.text.Renderer


Seq[Any](format.raw/*1.29*/("""

"""),format.raw/*4.1*/("""
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

        <!-- Facebook sharing information tags -->
        <meta property="og:title" content=""""),_display_(Seq[Any](/*11.45*/Messages("email.ticket.new.teaser", ticket.ticketId))),format.raw/*11.97*/("""" />

        <title>"""),_display_(Seq[Any](/*13.17*/Messages("email.ticket.new.teaser", ticket.ticketId))),format.raw/*13.69*/("""</title>
    <style type="text/css">
      /* Client-specific Styles */
      #outlook a"""),format.raw/*16.17*/("""{"""),format.raw/*16.18*/("""padding:0;"""),format.raw/*16.28*/("""}"""),format.raw/*16.29*/(""" /* Force Outlook to provide a "view in browser" button. */
      body"""),format.raw/*17.11*/("""{"""),format.raw/*17.12*/("""width:100% !important;"""),format.raw/*17.34*/("""}"""),format.raw/*17.35*/(""" .ReadMsgBody"""),format.raw/*17.48*/("""{"""),format.raw/*17.49*/("""width:100%;"""),format.raw/*17.60*/("""}"""),format.raw/*17.61*/(""" .ExternalClass"""),format.raw/*17.76*/("""{"""),format.raw/*17.77*/("""width:100%;"""),format.raw/*17.88*/("""}"""),format.raw/*17.89*/(""" /* Force Hotmail to display emails at full width */
      body"""),format.raw/*18.11*/("""{"""),format.raw/*18.12*/("""-webkit-text-size-adjust:none;"""),format.raw/*18.42*/("""}"""),format.raw/*18.43*/(""" /* Prevent Webkit platforms from changing default text sizes. */

      /* Reset Styles */
      body"""),format.raw/*21.11*/("""{"""),format.raw/*21.12*/("""margin:0; padding:0;"""),format.raw/*21.32*/("""}"""),format.raw/*21.33*/("""
      img"""),format.raw/*22.10*/("""{"""),format.raw/*22.11*/("""border:0; height:auto; line-height:100%; outline:none; text-decoration:none;"""),format.raw/*22.87*/("""}"""),format.raw/*22.88*/("""
      table td"""),format.raw/*23.15*/("""{"""),format.raw/*23.16*/("""border-collapse:collapse;"""),format.raw/*23.41*/("""}"""),format.raw/*23.42*/("""
      #backgroundTable"""),format.raw/*24.23*/("""{"""),format.raw/*24.24*/("""height:100% !important; margin:0; padding:0; width:100% !important;"""),format.raw/*24.91*/("""}"""),format.raw/*24.92*/("""

      /* Template Styles */

      /* /\/\/\/\/\/\/\/\/\/\ STANDARD STYLING: COMMON PAGE ELEMENTS /\/\/\/\/\/\/\/\/\/\ */

      /**
      * tab Page
      * section background color
      * tip Set the background color for your email. You may want to choose one that matches your company's branding.
      * theme page
      */
      body, #backgroundTable"""),format.raw/*36.29*/("""{"""),format.raw/*36.30*/("""
        /*editable*/ background-color:#FAFAFA;
      """),format.raw/*38.7*/("""}"""),format.raw/*38.8*/("""

      /**
      * tab Page
      * section email border
      * tip Set the border for your email.
      */
      #templateContainer"""),format.raw/*45.25*/("""{"""),format.raw/*45.26*/("""
        /*editable*/ border: 1px solid #DDDDDD;
      """),format.raw/*47.7*/("""}"""),format.raw/*47.8*/("""

      /**
      * tab Page
      * section heading 1
      * tip Set the styling for all first-level headings in your emails. These should be the largest of your headings.
      * style heading 1
      */
      h1, .h1"""),format.raw/*55.14*/("""{"""),format.raw/*55.15*/("""
        /*editable*/ color:#202020;
        display:block;
        /*editable*/ font-family:Arial;
        /*editable*/ font-size:34px;
        /*editable*/ font-weight:bold;
        /*editable*/ line-height:100%;
        margin-top:0;
        margin-right:0;
        margin-bottom:10px;
        margin-left:0;
        /*editable*/ text-align:left;
      """),format.raw/*67.7*/("""}"""),format.raw/*67.8*/("""

      /**
      * tab Page
      * section heading 2
      * tip Set the styling for all second-level headings in your emails.
      * style heading 2
      */
      h2, .h2"""),format.raw/*75.14*/("""{"""),format.raw/*75.15*/("""
        /*editable*/ color:#202020;
        display:block;
        /*editable*/ font-family:Arial;
        /*editable*/ font-size:30px;
        /*editable*/ font-weight:bold;
        /*editable*/ line-height:100%;
        margin-top:0;
        margin-right:0;
        margin-bottom:10px;
        margin-left:0;
        /*editable*/ text-align:left;
      """),format.raw/*87.7*/("""}"""),format.raw/*87.8*/("""

      /**
      * tab Page
      * section heading 3
      * tip Set the styling for all third-level headings in your emails.
      * style heading 3
      */
      h3, .h3"""),format.raw/*95.14*/("""{"""),format.raw/*95.15*/("""
        /*editable*/ color:#202020;
        display:block;
        /*editable*/ font-family:Arial;
        /*editable*/ font-size:26px;
        /*editable*/ font-weight:bold;
        /*editable*/ line-height:100%;
        margin-top:0;
        margin-right:0;
        margin-bottom:10px;
        margin-left:0;
        /*editable*/ text-align:left;
      """),format.raw/*107.7*/("""}"""),format.raw/*107.8*/("""

      /**
      * tab Page
      * section heading 4
      * tip Set the styling for all fourth-level headings in your emails. These should be the smallest of your headings.
      * style heading 4
      */
      h4, .h4"""),format.raw/*115.14*/("""{"""),format.raw/*115.15*/("""
        /*editable*/ color:#202020;
        display:block;
        /*editable*/ font-family:Arial;
        /*editable*/ font-size:22px;
        /*editable*/ font-weight:bold;
        /*editable*/ line-height:100%;
        margin-top:0;
        margin-right:0;
        margin-bottom:10px;
        margin-left:0;
        /*editable*/ text-align:left;
      """),format.raw/*127.7*/("""}"""),format.raw/*127.8*/("""

      /* /\/\/\/\/\/\/\/\/\/\ STANDARD STYLING: PREHEADER /\/\/\/\/\/\/\/\/\/\ */

      /**
      * tab Header
      * section preheader style
      * tip Set the background color for your email's preheader area.
      * theme page
      */
      #templatePreheader"""),format.raw/*137.25*/("""{"""),format.raw/*137.26*/("""
        /*editable*/ background-color:#FAFAFA;
      """),format.raw/*139.7*/("""}"""),format.raw/*139.8*/("""

      /**
      * tab Header
      * section preheader text
      * tip Set the styling for your email's preheader text. Choose a size and color that is easy to read.
      */
      .preheaderContent div"""),format.raw/*146.28*/("""{"""),format.raw/*146.29*/("""
        /*editable*/ color:#505050;
        /*editable*/ font-family:Arial;
        /*editable*/ font-size:10px;
        /*editable*/ line-height:100%;
        /*editable*/ text-align:left;
      """),format.raw/*152.7*/("""}"""),format.raw/*152.8*/("""

      /**
      * tab Header
      * section preheader link
      * tip Set the styling for your email's preheader links. Choose a color that helps them stand out from your text.
      */
      .preheaderContent div a:link, .preheaderContent div a:visited, /* Yahoo! Mail Override */ .preheaderContent div a .yshortcuts /* Yahoo! Mail Override */"""),format.raw/*159.159*/("""{"""),format.raw/*159.160*/("""
        /*editable*/ color:#336699;
        /*editable*/ font-weight:normal;
        /*editable*/ text-decoration:underline;
      """),format.raw/*163.7*/("""}"""),format.raw/*163.8*/("""

      /* /\/\/\/\/\/\/\/\/\/\ STANDARD STYLING: HEADER /\/\/\/\/\/\/\/\/\/\ */

      /**
      * tab Header
      * section header style
      * tip Set the background color and border for your email's header area.
      * theme header
      */
      #templateHeader"""),format.raw/*173.22*/("""{"""),format.raw/*173.23*/("""
        /*editable*/ background-color:#FFFFFF;
        /*editable*/ border-bottom:0;
      """),format.raw/*176.7*/("""}"""),format.raw/*176.8*/("""

      /**
      * tab Header
      * section header text
      * tip Set the styling for your email's header text. Choose a size and color that is easy to read.
      */
      .headerContent"""),format.raw/*183.21*/("""{"""),format.raw/*183.22*/("""
        /*editable*/ color:#202020;
        /*editable*/ font-family:Arial;
        /*editable*/ font-size:34px;
        /*editable*/ font-weight:bold;
        /*editable*/ line-height:100%;
        /*editable*/ padding:0;
        /*editable*/ text-align:center;
        /*editable*/ vertical-align:middle;
      """),format.raw/*192.7*/("""}"""),format.raw/*192.8*/("""

      /**
      * tab Header
      * section header link
      * tip Set the styling for your email's header links. Choose a color that helps them stand out from your text.
      */
      .headerContent a:link, .headerContent a:visited, /* Yahoo! Mail Override */ .headerContent a .yshortcuts /* Yahoo! Mail Override */"""),format.raw/*199.138*/("""{"""),format.raw/*199.139*/("""
        /*editable*/ color:#336699;
        /*editable*/ font-weight:normal;
        /*editable*/ text-decoration:underline;
      """),format.raw/*203.7*/("""}"""),format.raw/*203.8*/("""

      #headerImage"""),format.raw/*205.19*/("""{"""),format.raw/*205.20*/("""
        height:auto;
        max-width:600px !important;
      """),format.raw/*208.7*/("""}"""),format.raw/*208.8*/("""

      /* /\/\/\/\/\/\/\/\/\/\ STANDARD STYLING: MAIN BODY /\/\/\/\/\/\/\/\/\/\ */

      /**
      * tab Body
      * section body style
      * tip Set the background color for your email's body area.
      */
      #templateContainer, .bodyContent"""),format.raw/*217.39*/("""{"""),format.raw/*217.40*/("""
        /*editable*/ background-color:#FFFFFF;
      """),format.raw/*219.7*/("""}"""),format.raw/*219.8*/("""

      /**
      * tab Body
      * section body text
      * tip Set the styling for your email's main content text. Choose a size and color that is easy to read.
      * theme main
      */
      .bodyContent div"""),format.raw/*227.23*/("""{"""),format.raw/*227.24*/("""
        /*editable*/ color:#505050;
        /*editable*/ font-family:Arial;
        /*editable*/ font-size:14px;
        /*editable*/ line-height:150%;
        /*editable*/ text-align:left;
      """),format.raw/*233.7*/("""}"""),format.raw/*233.8*/("""

      /**
      * tab Body
      * section body link
      * tip Set the styling for your email's main content links. Choose a color that helps them stand out from your text.
      */
      .bodyContent div a:link, .bodyContent div a:visited, /* Yahoo! Mail Override */ .bodyContent div a .yshortcuts /* Yahoo! Mail Override */"""),format.raw/*240.144*/("""{"""),format.raw/*240.145*/("""
        /*editable*/ color:#336699;
        /*editable*/ font-weight:normal;
        /*editable*/ text-decoration:underline;
      """),format.raw/*244.7*/("""}"""),format.raw/*244.8*/("""

      .bodyContent img"""),format.raw/*246.23*/("""{"""),format.raw/*246.24*/("""
        display:inline;
        height:auto;
      """),format.raw/*249.7*/("""}"""),format.raw/*249.8*/("""

      /* /\/\/\/\/\/\/\/\/\/\ STANDARD STYLING: FOOTER /\/\/\/\/\/\/\/\/\/\ */

      /**
      * tab Footer
      * section footer style
      * tip Set the background color and top border for your email's footer area.
      * theme footer
      */
      #templateFooter"""),format.raw/*259.22*/("""{"""),format.raw/*259.23*/("""
        /*editable*/ background-color:#FFFFFF;
        /*editable*/ border-top:0;
      """),format.raw/*262.7*/("""}"""),format.raw/*262.8*/("""

      /**
      * tab Footer
      * section footer text
      * tip Set the styling for your email's footer text. Choose a size and color that is easy to read.
      * theme footer
      */
      .footerContent div"""),format.raw/*270.25*/("""{"""),format.raw/*270.26*/("""
        /*editable*/ color:#707070;
        /*editable*/ font-family:Arial;
        /*editable*/ font-size:12px;
        /*editable*/ line-height:125%;
        /*editable*/ text-align:left;
      """),format.raw/*276.7*/("""}"""),format.raw/*276.8*/("""

      /**
      * tab Footer
      * section footer link
      * tip Set the styling for your email's footer links. Choose a color that helps them stand out from your text.
      */
      .footerContent div a:link, .footerContent div a:visited, /* Yahoo! Mail Override */ .footerContent div a .yshortcuts /* Yahoo! Mail Override */"""),format.raw/*283.150*/("""{"""),format.raw/*283.151*/("""
        /*editable*/ color:#336699;
        /*editable*/ font-weight:normal;
        /*editable*/ text-decoration:underline;
      """),format.raw/*287.7*/("""}"""),format.raw/*287.8*/("""

      .footerContent img"""),format.raw/*289.25*/("""{"""),format.raw/*289.26*/("""
        display:inline;
      """),format.raw/*291.7*/("""}"""),format.raw/*291.8*/("""

      /**
      * tab Footer
      * section social bar style
      * tip Set the background color and border for your email's footer social bar.
      * theme footer
      */
      #social"""),format.raw/*299.14*/("""{"""),format.raw/*299.15*/("""
        /*editable*/ background-color:#FAFAFA;
        /*editable*/ border:0;
      """),format.raw/*302.7*/("""}"""),format.raw/*302.8*/("""

      /**
      * tab Footer
      * section social bar style
      * tip Set the background color and border for your email's footer social bar.
      */
      #social div"""),format.raw/*309.18*/("""{"""),format.raw/*309.19*/("""
        /*editable*/ text-align:center;
      """),format.raw/*311.7*/("""}"""),format.raw/*311.8*/("""

      /**
      * tab Footer
      * section utility bar style
      * tip Set the background color and border for your email's footer utility bar.
      * theme footer
      */
      #utility"""),format.raw/*319.15*/("""{"""),format.raw/*319.16*/("""
        /*editable*/ background-color:#FFFFFF;
        /*editable*/ border:0;
      """),format.raw/*322.7*/("""}"""),format.raw/*322.8*/("""

      /**
      * tab Footer
      * section utility bar style
      * tip Set the background color and border for your email's footer utility bar.
      */
      #utility div"""),format.raw/*329.19*/("""{"""),format.raw/*329.20*/("""
        /*editable*/ text-align:center;
      """),format.raw/*331.7*/("""}"""),format.raw/*331.8*/("""

      #monkeyRewards img"""),format.raw/*333.25*/("""{"""),format.raw/*333.26*/("""
        max-width:190px;
      """),format.raw/*335.7*/("""}"""),format.raw/*335.8*/("""
    </style>
  </head>
    <body leftmargin="0" marginwidth="0" topmargin="0" marginheight="0" offset="0">
      <center>
          <table border="0" cellpadding="0" cellspacing="0" height="100%" width="100%" id="backgroundTable">
              <tr>
                  <td align="center" valign="top">
                        <!-- // Begin Template Preheader \\ -->
                        <table border="0" cellpadding="10" cellspacing="0" width="600" id="templatePreheader">
                            <tr>
                                <td valign="top" class="preheaderContent">

                                  <!-- // Begin Module: Standard Preheader \ -->
                                    <table border="0" cellpadding="10" cellspacing="0" width="100%">
                                      <tr>
                                          <td valign="top">
                                              <div mc:edit="std_preheader_content">
                                                   """),_display_(Seq[Any](/*353.53*/Messages("email.ticket.new.teaser", ticket.ticketId))),format.raw/*353.105*/("""
                                                </div>
                                            </td>
                                            <!-- *|IFNOT:ARCHIVE_PAGE|* -->
                      <td valign="top" width="190">
                                              <div mc:edit="std_preheader_links">
                                                  """),_display_(Seq[Any](/*359.52*/Messages("email.ticket.new.problem"))),format.raw/*359.88*/("""<br /><a href=""""),_display_(Seq[Any](/*359.104*/controllers/*359.115*/.routes.Ticket.item("comments", ticket.ticketId))),format.raw/*359.163*/("""" target="_blank">"""),_display_(Seq[Any](/*359.182*/Messages("email.ticket.new.problem.view"))),format.raw/*359.223*/("""</a>
                                                </div>
                                            </td>
                      <!-- *|END:IF|* -->
                                        </tr>
                                    </table>
                                  <!-- // End Module: Standard Preheader \ -->

                                </td>
                            </tr>
                        </table>
                        <!-- // End Template Preheader \\ -->
                      <table border="0" cellpadding="0" cellspacing="0" width="600" id="templateContainer">
                          <tr>
                              <td align="center" valign="top">
                                    <!-- // Begin Template Body \\ -->
                                  <table border="0" cellpadding="0" cellspacing="0" width="600" id="templateBody">
                                      <tr>
                                            <td valign="top" class="bodyContent">

                                                <!-- // Begin Module: Standard Content \\ -->
                                                <table border="0" cellpadding="20" cellspacing="0" width="100%">
                                                    <tr>
                                                        <td valign="top">
                                                            <div mc:edit="std_content00">
                                                                <h1 class="h1">"""),_display_(Seq[Any](/*384.81*/Messages("ticket.summary.with.id", ticket.ticketId, ticket.summary))),format.raw/*384.148*/("""</h1>
                                                                """),_display_(Seq[Any](/*385.66*/if(ticket.description.isDefined)/*385.98*/ {_display_(Seq[Any](format.raw/*385.100*/("""
                                                                  """),_display_(Seq[Any](/*386.68*/Html(Renderer.render(ticket.description)))),format.raw/*386.109*/("""
                                                                """)))}/*387.67*/else/*387.72*/{_display_(Seq[Any](format.raw/*387.73*/("""
                                                                  """),_display_(Seq[Any](/*388.68*/Messages("ticket.description.none"))),format.raw/*388.103*/("""
                                                                """)))})),format.raw/*389.66*/("""
                                                            </div>
                            </td>
                                                    </tr>
                                                </table>
                                                <!-- // End Module: Standard Content \\ -->

                                            </td>
                                        </tr>
                                    </table>
                                    <!-- // End Template Body \\ -->
                                </td>
                            </tr>
                          <tr>
                              <td align="center" valign="top">
                                    <!-- // Begin Template Footer \\ -->
                                  <table border="0" cellpadding="10" cellspacing="0" width="600" id="templateFooter">
                                      <tr>
                                          <td valign="top" class="footerContent">

                                                <!-- // Begin Module: Standard Footer \\ -->
                                                <table border="0" cellpadding="10" cellspacing="0" width="100%">
                                                    <tr>
                                                        <td colspan="2" valign="middle" id="social">
                                                            <div mc:edit="std_social">
                                                                &nbsp;<a href=""""),_display_(Seq[Any](/*414.81*/controllers/*414.92*/.routes.Ticket.item("comments", ticket.ticketId))),format.raw/*414.140*/("""" target="_blank">"""),_display_(Seq[Any](/*414.159*/Messages("email.ticket.new.problem.view"))),format.raw/*414.200*/("""</a>&nbsp;
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top" width="540">
                                                            <div mc:edit="std_footer">
                                                              """),_display_(Seq[Any](/*421.64*/Html(Messages("email.footer.blurb")))),format.raw/*421.100*/("""
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <!-- // End Module: Standard Footer \\ -->

                                            </td>
                                        </tr>
                                    </table>
                                    <!-- // End Template Footer \\ -->
                                </td>
                            </tr>
                        </table>
                        <br />
                    </td>
                </tr>
            </table>
        </center>
    </body>
</html>"""))}
    }
    
    def render(ticket:models.FullTicket): play.api.templates.HtmlFormat.Appendable = apply(ticket)
    
    def f:((models.FullTicket) => play.api.templates.HtmlFormat.Appendable) = (ticket) => apply(ticket)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 17 10:35:17 PST 2013
                    SOURCE: /Users/gphat/src/emperor/app/views/email/notifier/ticket/newticket.scala.html
                    HASH: b8141c2088a5cf7b949a13b58b2d4338d5a23440
                    MATRIX: 593->1|739->28|767->56|1118->371|1192->423|1250->445|1324->497|1440->585|1469->586|1507->596|1536->597|1634->667|1663->668|1713->690|1742->691|1783->704|1812->705|1851->716|1880->717|1923->732|1952->733|1991->744|2020->745|2111->808|2140->809|2198->839|2227->840|2357->942|2386->943|2434->963|2463->964|2501->974|2530->975|2634->1051|2663->1052|2706->1067|2735->1068|2788->1093|2817->1094|2868->1117|2897->1118|2992->1185|3021->1186|3408->1545|3437->1546|3518->1600|3546->1601|3708->1735|3737->1736|3819->1791|3847->1792|4095->2012|4124->2013|4507->2369|4535->2370|4738->2545|4767->2546|5150->2902|5178->2903|5380->3077|5409->3078|5793->3434|5822->3435|6073->3657|6103->3658|6487->4014|6516->4015|6813->4283|6843->4284|6925->4338|6954->4339|7188->4544|7218->4545|7443->4742|7472->4743|7850->5091|7881->5092|8041->5224|8070->5225|8368->5494|8398->5495|8518->5587|8547->5588|8768->5780|8798->5781|9140->6095|9169->6096|9520->6417|9551->6418|9711->6550|9740->6551|9789->6571|9819->6572|9911->6636|9940->6637|10220->6888|10250->6889|10332->6943|10361->6944|10605->7159|10635->7160|10860->7357|10889->7358|11248->7687|11279->7688|11439->7820|11468->7821|11521->7845|11551->7846|11631->7898|11660->7899|11962->8172|11992->8173|12109->8262|12138->8263|12384->8480|12414->8481|12639->8678|12668->8679|13031->9012|13062->9013|13222->9145|13251->9146|13306->9172|13336->9173|13395->9204|13424->9205|13644->9396|13674->9397|13787->9482|13816->9483|14019->9657|14049->9658|14124->9705|14153->9706|14376->9900|14406->9901|14519->9986|14548->9987|14754->10164|14784->10165|14859->10212|14888->10213|14943->10239|14973->10240|15033->10272|15062->10273|16106->11280|16182->11332|16586->11699|16645->11735|16699->11751|16721->11762|16793->11810|16850->11829|16915->11870|18464->13382|18555->13449|18663->13520|18705->13552|18747->13554|18852->13622|18917->13663|19003->13730|19017->13735|19057->13736|19162->13804|19221->13839|19320->13905|20891->15439|20912->15450|20984->15498|21041->15517|21106->15558|21634->16049|21694->16085
                    LINES: 19->1|23->1|25->4|32->11|32->11|34->13|34->13|37->16|37->16|37->16|37->16|38->17|38->17|38->17|38->17|38->17|38->17|38->17|38->17|38->17|38->17|38->17|38->17|39->18|39->18|39->18|39->18|42->21|42->21|42->21|42->21|43->22|43->22|43->22|43->22|44->23|44->23|44->23|44->23|45->24|45->24|45->24|45->24|57->36|57->36|59->38|59->38|66->45|66->45|68->47|68->47|76->55|76->55|88->67|88->67|96->75|96->75|108->87|108->87|116->95|116->95|128->107|128->107|136->115|136->115|148->127|148->127|158->137|158->137|160->139|160->139|167->146|167->146|173->152|173->152|180->159|180->159|184->163|184->163|194->173|194->173|197->176|197->176|204->183|204->183|213->192|213->192|220->199|220->199|224->203|224->203|226->205|226->205|229->208|229->208|238->217|238->217|240->219|240->219|248->227|248->227|254->233|254->233|261->240|261->240|265->244|265->244|267->246|267->246|270->249|270->249|280->259|280->259|283->262|283->262|291->270|291->270|297->276|297->276|304->283|304->283|308->287|308->287|310->289|310->289|312->291|312->291|320->299|320->299|323->302|323->302|330->309|330->309|332->311|332->311|340->319|340->319|343->322|343->322|350->329|350->329|352->331|352->331|354->333|354->333|356->335|356->335|374->353|374->353|380->359|380->359|380->359|380->359|380->359|380->359|380->359|405->384|405->384|406->385|406->385|406->385|407->386|407->386|408->387|408->387|408->387|409->388|409->388|410->389|435->414|435->414|435->414|435->414|435->414|442->421|442->421
                    -- GENERATED --
                */
            