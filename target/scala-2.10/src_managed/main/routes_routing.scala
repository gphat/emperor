// @SOURCE:/Users/gphat/src/emperor/conf/routes
// @HASH:f8ee4fe950a5c17b8a9c6d118bcd6ef80860b8b9
// @DATE:Sun Nov 17 10:56:32 PST 2013


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Core_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:8
private[this] lazy val controllers_Admin_reindex1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/reindex"))))
        

// @LINE:10
private[this] lazy val controllers_api_Project_index2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/project"))))
        

// @LINE:11
private[this] lazy val controllers_api_Ticket_create3 = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/project/"),DynamicPart("projectId", """[^/]+""",true),StaticPart("/ticket"))))
        

// @LINE:12
private[this] lazy val controllers_api_Project_assignableUsers4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/project/"),DynamicPart("id", """[^/]+""",true),StaticPart("/assignees"))))
        

// @LINE:13
private[this] lazy val controllers_api_Project_item5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/project/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:15
private[this] lazy val controllers_api_Search_index6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/search"))))
        

// @LINE:17
private[this] lazy val controllers_api_third_BitBucket_commit7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/third/bitbucket/commit"))))
        

// @LINE:18
private[this] lazy val controllers_api_third_GitHub_commit8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/third/github/commit"))))
        

// @LINE:20
private[this] lazy val controllers_api_Ticket_assign9 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/ticket/"),DynamicPart("ticketId", """[^/]+""",true),StaticPart("/assign"))))
        

// @LINE:21
private[this] lazy val controllers_api_Ticket_comment10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/ticket/"),DynamicPart("ticketId", """[^/]+""",true),StaticPart("/comment"))))
        

// @LINE:22
private[this] lazy val controllers_api_Ticket_addComment11 = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/ticket/"),DynamicPart("ticketId", """[^/]+""",true),StaticPart("/comment"))))
        

// @LINE:23
private[this] lazy val controllers_api_Ticket_deleteComment12 = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/ticket/"),DynamicPart("ticketId", """[^/]+""",true),StaticPart("/comment/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:24
private[this] lazy val controllers_api_Ticket_resolve13 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/ticket/"),DynamicPart("ticketId", """[^/]+""",true),StaticPart("/resolve"))))
        

// @LINE:25
private[this] lazy val controllers_api_Ticket_unresolve14 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/ticket/"),DynamicPart("ticketId", """[^/]+""",true),StaticPart("/unresolve"))))
        

// @LINE:26
private[this] lazy val controllers_api_Ticket_changeStatus15 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/ticket/"),DynamicPart("ticketId", """[^/]+""",true),StaticPart("/status"))))
        

// @LINE:27
private[this] lazy val controllers_api_Ticket_links16 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/ticket/"),DynamicPart("ticketId", """[^/]+""",true),StaticPart("/link"))))
        

// @LINE:28
private[this] lazy val controllers_api_Ticket_link17 = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/ticket/"),DynamicPart("ticketId", """[^/]+""",true),StaticPart("/link"))))
        

// @LINE:29
private[this] lazy val controllers_api_Ticket_deleteLink18 = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/ticket/"),DynamicPart("ticketId", """[^/]+""",true),StaticPart("/link/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:30
private[this] lazy val controllers_api_Ticket_item19 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/ticket/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:32
private[this] lazy val controllers_api_TicketLinkType_index20 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/ticketlinktype"))))
        

// @LINE:33
private[this] lazy val controllers_api_TicketLinkType_item21 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/ticketlinktype/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:35
private[this] lazy val controllers_api_TicketPriority_index22 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/ticketpriority"))))
        

// @LINE:36
private[this] lazy val controllers_api_TicketPriority_item23 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/ticketpriority/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:38
private[this] lazy val controllers_api_TicketResolution_index24 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/ticketresolution"))))
        

// @LINE:39
private[this] lazy val controllers_api_TicketResolution_item25 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/ticketresolution/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:41
private[this] lazy val controllers_api_TicketSeverity_index26 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/ticketseverity"))))
        

// @LINE:42
private[this] lazy val controllers_api_TicketSeverity_item27 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/ticketseverity/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:44
private[this] lazy val controllers_api_TicketType_index28 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/tickettype"))))
        

// @LINE:45
private[this] lazy val controllers_api_TicketType_item29 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/tickettype/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:47
private[this] lazy val controllers_api_Timeline_index30 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/timeline"))))
        

// @LINE:49
private[this] lazy val controllers_api_User_index31 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/user"))))
        

// @LINE:50
private[this] lazy val controllers_api_User_item32 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/user/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:51
private[this] lazy val controllers_api_User_startsWith33 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/user/startswith"))))
        

// @LINE:52
private[this] lazy val controllers_api_User_deleteToken34 = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/user/token/"),DynamicPart("token", """[^/]+""",true))))
        

// @LINE:53
private[this] lazy val controllers_api_User_tokens35 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/user/tokens/"),DynamicPart("userId", """[^/]+""",true))))
        

// @LINE:55
private[this] lazy val controllers_api_Workflow_index36 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/workflow"))))
        

// @LINE:56
private[this] lazy val controllers_api_Workflow_item37 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/workflow/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:57
private[this] lazy val controllers_api_Workflow_statuses38 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/workflow/"),DynamicPart("id", """[^/]+""",true),StaticPart("/statuses"))))
        

// @LINE:59
private[this] lazy val controllers_Auth_forgot39 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/forgot"))))
        

// @LINE:60
private[this] lazy val controllers_Auth_login40 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/login"))))
        

// @LINE:61
private[this] lazy val controllers_Auth_logout41 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/logout"))))
        

// @LINE:62
private[this] lazy val controllers_Auth_reset42 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/reset/"),DynamicPart("token", """[^/]+""",true))))
        

// @LINE:63
private[this] lazy val controllers_Auth_doForgot43 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/forgot"))))
        

// @LINE:64
private[this] lazy val controllers_Auth_doLogin44 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/login"))))
        

// @LINE:65
private[this] lazy val controllers_Auth_doReset45 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/reset/"),DynamicPart("token", """[^/]+""",true))))
        

// @LINE:67
private[this] lazy val controllers_Board_index46 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("board/"),DynamicPart("projectId", """[^/]+""",true))))
        

// @LINE:69
private[this] lazy val controllers_Admin_index47 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin"))))
        

// @LINE:71
private[this] lazy val controllers_admin_User_create48 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/user/create"))))
        

// @LINE:72
private[this] lazy val controllers_admin_User_index49 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/user"))))
        

// @LINE:73
private[this] lazy val controllers_admin_User_add50 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/user"))))
        

// @LINE:75
private[this] lazy val controllers_Project_create51 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("project/create"))))
        

// @LINE:76
private[this] lazy val controllers_Project_edit52 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("project/edit/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:77
private[this] lazy val controllers_Project_item53 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("project/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:78
private[this] lazy val controllers_Project_update54 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("project/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:79
private[this] lazy val controllers_Project_index55 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("project"))))
        

// @LINE:80
private[this] lazy val controllers_Project_add56 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("project"))))
        

// @LINE:82
private[this] lazy val controllers_Search_index57 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("search"))))
        

// @LINE:84
private[this] lazy val controllers_Ticket_create58 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ticket/create"))))
        

// @LINE:85
private[this] lazy val controllers_Ticket_item59 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ticket/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:87
private[this] lazy val controllers_Ticket_update60 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ticket/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:88
private[this] lazy val controllers_Ticket_edit61 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ticket/edit/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:90
private[this] lazy val controllers_User_edit62 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/edit/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:91
private[this] lazy val controllers_User_generateToken63 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/token/"),DynamicPart("userId", """[^/]+""",true))))
        

// @LINE:92
private[this] lazy val controllers_User_updatePassword64 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/"),DynamicPart("id", """[^/]+""",true),StaticPart("/password"))))
        

// @LINE:93
private[this] lazy val controllers_User_update65 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:94
private[this] lazy val controllers_User_item66 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:97
private[this] lazy val controllers_Assets_at67 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Core.index(page:Int ?= 1, count:Int ?= 10)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/reindex""","""controllers.Admin.reindex"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/project""","""controllers.api.Project.index(callback:Option[String])"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/project/$projectId<[^/]+>/ticket""","""controllers.api.Ticket.create(projectId:Long, callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/project/$id<[^/]+>/assignees""","""controllers.api.Project.assignableUsers(id:Long, callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/project/$id<[^/]+>""","""controllers.api.Project.item(id:Long, callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/search""","""controllers.api.Search.index(page:Int ?= 1, count:Int ?= 10, query:String ?= "*", sort:Option[String] = None, order:Option[String] = None, callback:Option[String])"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/third/bitbucket/commit""","""controllers.api.third.BitBucket.commit"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/third/github/commit""","""controllers.api.third.GitHub.commit"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/ticket/$ticketId<[^/]+>/assign""","""controllers.api.Ticket.assign(ticketId:String, callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/ticket/$ticketId<[^/]+>/comment""","""controllers.api.Ticket.comment(ticketId:String, type:Option[String], callback:Option[String])"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/ticket/$ticketId<[^/]+>/comment""","""controllers.api.Ticket.addComment(ticketId:String, callback:Option[String])"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/ticket/$ticketId<[^/]+>/comment/$id<[^/]+>""","""controllers.api.Ticket.deleteComment(ticketId:String, id:Long, callback:Option[String])"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/ticket/$ticketId<[^/]+>/resolve""","""controllers.api.Ticket.resolve(ticketId:String, callback:Option[String])"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/ticket/$ticketId<[^/]+>/unresolve""","""controllers.api.Ticket.unresolve(ticketId:String, callback:Option[String])"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/ticket/$ticketId<[^/]+>/status""","""controllers.api.Ticket.changeStatus(ticketId:String, callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/ticket/$ticketId<[^/]+>/link""","""controllers.api.Ticket.links(ticketId:String, callback:Option[String])"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/ticket/$ticketId<[^/]+>/link""","""controllers.api.Ticket.link(ticketId:String, callback:Option[String])"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/ticket/$ticketId<[^/]+>/link/$id<[^/]+>""","""controllers.api.Ticket.deleteLink(ticketId:String, id:Long, callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/ticket/$id<[^/]+>""","""controllers.api.Ticket.item(id:String, callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/ticketlinktype""","""controllers.api.TicketLinkType.index(callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/ticketlinktype/$id<[^/]+>""","""controllers.api.TicketLinkType.item(id:Long, callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/ticketpriority""","""controllers.api.TicketPriority.index(callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/ticketpriority/$id<[^/]+>""","""controllers.api.TicketPriority.item(id:Long, callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/ticketresolution""","""controllers.api.TicketResolution.index(callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/ticketresolution/$id<[^/]+>""","""controllers.api.TicketResolution.item(id:Long, callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/ticketseverity""","""controllers.api.TicketSeverity.index(callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/ticketseverity/$id<[^/]+>""","""controllers.api.TicketSeverity.item(id:Long, callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/tickettype""","""controllers.api.TicketType.index(callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/tickettype/$id<[^/]+>""","""controllers.api.TicketType.item(id:Long, callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/timeline""","""controllers.api.Timeline.index(page:Int ?= 1, count:Int ?= 10, callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/user""","""controllers.api.User.index(callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/user/$id<[^/]+>""","""controllers.api.User.item(id:Long, callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/user/startswith""","""controllers.api.User.startsWith(q:Option[String], callback:Option[String])"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/user/token/$token<[^/]+>""","""controllers.api.User.deleteToken(token:String, callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/user/tokens/$userId<[^/]+>""","""controllers.api.User.tokens(userId:Long, callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/workflow""","""controllers.api.Workflow.index(callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/workflow/$id<[^/]+>""","""controllers.api.Workflow.item(id:Long, callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/workflow/$id<[^/]+>/statuses""","""controllers.api.Workflow.statuses(id:Long, callback:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/forgot""","""controllers.Auth.forgot"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/login""","""controllers.Auth.login(redirectUrl:String ?= "/")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/logout""","""controllers.Auth.logout"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/reset/$token<[^/]+>""","""controllers.Auth.reset(token:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/forgot""","""controllers.Auth.doForgot()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/login""","""controllers.Auth.doLogin(redirectUrl:String ?= "/")"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/reset/$token<[^/]+>""","""controllers.Auth.doReset(token:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """board/$projectId<[^/]+>""","""controllers.Board.index(projectId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin""","""controllers.Admin.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/user/create""","""controllers.admin.User.create"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/user""","""controllers.admin.User.index(page:Int ?= 1, count:Int ?= 10)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/user""","""controllers.admin.User.add"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """project/create""","""controllers.Project.create"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """project/edit/$id<[^/]+>""","""controllers.Project.edit(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """project/$id<[^/]+>""","""controllers.Project.item(id:Long, page:Int ?= 1, count:Int ?= 10)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """project/$id<[^/]+>""","""controllers.Project.update(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """project""","""controllers.Project.index(page:Int ?= 1, count:Int ?= 10)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """project""","""controllers.Project.add"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """search""","""controllers.Search.index(page:Int ?= 1, count:Int ?= 10, query:String ?= "*", sort:Option[String] = None, order:Option[String] = None)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ticket/create""","""controllers.Ticket.create(project:Option[Long] ?= None)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ticket/$id<[^/]+>""","""controllers.Ticket.item(tab:String ?= "comments", id:String, page:Int ?= 1, count:Int ?= 10, query:String ?= "*")"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ticket/$id<[^/]+>""","""controllers.Ticket.update(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ticket/edit/$id<[^/]+>""","""controllers.Ticket.edit(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/edit/$id<[^/]+>""","""controllers.User.edit(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/token/$userId<[^/]+>""","""controllers.User.generateToken(userId:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/$id<[^/]+>/password""","""controllers.User.updatePassword(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/$id<[^/]+>""","""controllers.User.update(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/$id<[^/]+>""","""controllers.User.item(id:Long, page:Int ?= 1, count:Int ?= 10)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Core_index0(params) => {
   call(params.fromQuery[Int]("page", Some(1)), params.fromQuery[Int]("count", Some(10))) { (page, count) =>
        invokeHandler(controllers.Core.index(page, count), HandlerDef(this, "controllers.Core", "index", Seq(classOf[Int], classOf[Int]),"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:8
case controllers_Admin_reindex1(params) => {
   call { 
        invokeHandler(controllers.Admin.reindex, HandlerDef(this, "controllers.Admin", "reindex", Nil,"GET", """""", Routes.prefix + """admin/reindex"""))
   }
}
        

// @LINE:10
case controllers_api_Project_index2(params) => {
   call(params.fromQuery[Option[String]]("callback", None)) { (callback) =>
        invokeHandler(controllers.api.Project.index(callback), HandlerDef(this, "controllers.api.Project", "index", Seq(classOf[Option[String]]),"GET", """""", Routes.prefix + """api/project"""))
   }
}
        

// @LINE:11
case controllers_api_Ticket_create3(params) => {
   call(params.fromPath[Long]("projectId", None), params.fromQuery[Option[String]]("callback", None)) { (projectId, callback) =>
        invokeHandler(controllers.api.Ticket.create(projectId, callback), HandlerDef(this, "controllers.api.Ticket", "create", Seq(classOf[Long], classOf[Option[String]]),"PUT", """""", Routes.prefix + """api/project/$projectId<[^/]+>/ticket"""))
   }
}
        

// @LINE:12
case controllers_api_Project_assignableUsers4(params) => {
   call(params.fromPath[Long]("id", None), params.fromQuery[Option[String]]("callback", None)) { (id, callback) =>
        invokeHandler(controllers.api.Project.assignableUsers(id, callback), HandlerDef(this, "controllers.api.Project", "assignableUsers", Seq(classOf[Long], classOf[Option[String]]),"GET", """""", Routes.prefix + """api/project/$id<[^/]+>/assignees"""))
   }
}
        

// @LINE:13
case controllers_api_Project_item5(params) => {
   call(params.fromPath[Long]("id", None), params.fromQuery[Option[String]]("callback", None)) { (id, callback) =>
        invokeHandler(controllers.api.Project.item(id, callback), HandlerDef(this, "controllers.api.Project", "item", Seq(classOf[Long], classOf[Option[String]]),"GET", """""", Routes.prefix + """api/project/$id<[^/]+>"""))
   }
}
        

// @LINE:15
case controllers_api_Search_index6(params) => {
   call(params.fromQuery[Int]("page", Some(1)), params.fromQuery[Int]("count", Some(10)), params.fromQuery[String]("query", Some("*")), Param[Option[String]]("sort", Right(None)), Param[Option[String]]("order", Right(None)), params.fromQuery[Option[String]]("callback", None)) { (page, count, query, sort, order, callback) =>
        invokeHandler(controllers.api.Search.index(page, count, query, sort, order, callback), HandlerDef(this, "controllers.api.Search", "index", Seq(classOf[Int], classOf[Int], classOf[String], classOf[Option[String]], classOf[Option[String]], classOf[Option[String]]),"GET", """""", Routes.prefix + """api/search"""))
   }
}
        

// @LINE:17
case controllers_api_third_BitBucket_commit7(params) => {
   call { 
        invokeHandler(controllers.api.third.BitBucket.commit, HandlerDef(this, "controllers.api.third.BitBucket", "commit", Nil,"POST", """""", Routes.prefix + """api/third/bitbucket/commit"""))
   }
}
        

// @LINE:18
case controllers_api_third_GitHub_commit8(params) => {
   call { 
        invokeHandler(controllers.api.third.GitHub.commit, HandlerDef(this, "controllers.api.third.GitHub", "commit", Nil,"POST", """""", Routes.prefix + """api/third/github/commit"""))
   }
}
        

// @LINE:20
case controllers_api_Ticket_assign9(params) => {
   call(params.fromPath[String]("ticketId", None), params.fromQuery[Option[String]]("callback", None)) { (ticketId, callback) =>
        invokeHandler(controllers.api.Ticket.assign(ticketId, callback), HandlerDef(this, "controllers.api.Ticket", "assign", Seq(classOf[String], classOf[Option[String]]),"POST", """""", Routes.prefix + """api/ticket/$ticketId<[^/]+>/assign"""))
   }
}
        

// @LINE:21
case controllers_api_Ticket_comment10(params) => {
   call(params.fromPath[String]("ticketId", None), params.fromQuery[Option[String]]("type", None), params.fromQuery[Option[String]]("callback", None)) { (ticketId, playframework_escape_type, callback) =>
        invokeHandler(controllers.api.Ticket.comment(ticketId, playframework_escape_type, callback), HandlerDef(this, "controllers.api.Ticket", "comment", Seq(classOf[String], classOf[Option[String]], classOf[Option[String]]),"GET", """""", Routes.prefix + """api/ticket/$ticketId<[^/]+>/comment"""))
   }
}
        

// @LINE:22
case controllers_api_Ticket_addComment11(params) => {
   call(params.fromPath[String]("ticketId", None), params.fromQuery[Option[String]]("callback", None)) { (ticketId, callback) =>
        invokeHandler(controllers.api.Ticket.addComment(ticketId, callback), HandlerDef(this, "controllers.api.Ticket", "addComment", Seq(classOf[String], classOf[Option[String]]),"PUT", """""", Routes.prefix + """api/ticket/$ticketId<[^/]+>/comment"""))
   }
}
        

// @LINE:23
case controllers_api_Ticket_deleteComment12(params) => {
   call(params.fromPath[String]("ticketId", None), params.fromPath[Long]("id", None), params.fromQuery[Option[String]]("callback", None)) { (ticketId, id, callback) =>
        invokeHandler(controllers.api.Ticket.deleteComment(ticketId, id, callback), HandlerDef(this, "controllers.api.Ticket", "deleteComment", Seq(classOf[String], classOf[Long], classOf[Option[String]]),"DELETE", """""", Routes.prefix + """api/ticket/$ticketId<[^/]+>/comment/$id<[^/]+>"""))
   }
}
        

// @LINE:24
case controllers_api_Ticket_resolve13(params) => {
   call(params.fromPath[String]("ticketId", None), params.fromQuery[Option[String]]("callback", None)) { (ticketId, callback) =>
        invokeHandler(controllers.api.Ticket.resolve(ticketId, callback), HandlerDef(this, "controllers.api.Ticket", "resolve", Seq(classOf[String], classOf[Option[String]]),"POST", """""", Routes.prefix + """api/ticket/$ticketId<[^/]+>/resolve"""))
   }
}
        

// @LINE:25
case controllers_api_Ticket_unresolve14(params) => {
   call(params.fromPath[String]("ticketId", None), params.fromQuery[Option[String]]("callback", None)) { (ticketId, callback) =>
        invokeHandler(controllers.api.Ticket.unresolve(ticketId, callback), HandlerDef(this, "controllers.api.Ticket", "unresolve", Seq(classOf[String], classOf[Option[String]]),"POST", """""", Routes.prefix + """api/ticket/$ticketId<[^/]+>/unresolve"""))
   }
}
        

// @LINE:26
case controllers_api_Ticket_changeStatus15(params) => {
   call(params.fromPath[String]("ticketId", None), params.fromQuery[Option[String]]("callback", None)) { (ticketId, callback) =>
        invokeHandler(controllers.api.Ticket.changeStatus(ticketId, callback), HandlerDef(this, "controllers.api.Ticket", "changeStatus", Seq(classOf[String], classOf[Option[String]]),"POST", """""", Routes.prefix + """api/ticket/$ticketId<[^/]+>/status"""))
   }
}
        

// @LINE:27
case controllers_api_Ticket_links16(params) => {
   call(params.fromPath[String]("ticketId", None), params.fromQuery[Option[String]]("callback", None)) { (ticketId, callback) =>
        invokeHandler(controllers.api.Ticket.links(ticketId, callback), HandlerDef(this, "controllers.api.Ticket", "links", Seq(classOf[String], classOf[Option[String]]),"GET", """""", Routes.prefix + """api/ticket/$ticketId<[^/]+>/link"""))
   }
}
        

// @LINE:28
case controllers_api_Ticket_link17(params) => {
   call(params.fromPath[String]("ticketId", None), params.fromQuery[Option[String]]("callback", None)) { (ticketId, callback) =>
        invokeHandler(controllers.api.Ticket.link(ticketId, callback), HandlerDef(this, "controllers.api.Ticket", "link", Seq(classOf[String], classOf[Option[String]]),"PUT", """""", Routes.prefix + """api/ticket/$ticketId<[^/]+>/link"""))
   }
}
        

// @LINE:29
case controllers_api_Ticket_deleteLink18(params) => {
   call(params.fromPath[String]("ticketId", None), params.fromPath[Long]("id", None), params.fromQuery[Option[String]]("callback", None)) { (ticketId, id, callback) =>
        invokeHandler(controllers.api.Ticket.deleteLink(ticketId, id, callback), HandlerDef(this, "controllers.api.Ticket", "deleteLink", Seq(classOf[String], classOf[Long], classOf[Option[String]]),"DELETE", """""", Routes.prefix + """api/ticket/$ticketId<[^/]+>/link/$id<[^/]+>"""))
   }
}
        

// @LINE:30
case controllers_api_Ticket_item19(params) => {
   call(params.fromPath[String]("id", None), params.fromQuery[Option[String]]("callback", None)) { (id, callback) =>
        invokeHandler(controllers.api.Ticket.item(id, callback), HandlerDef(this, "controllers.api.Ticket", "item", Seq(classOf[String], classOf[Option[String]]),"GET", """""", Routes.prefix + """api/ticket/$id<[^/]+>"""))
   }
}
        

// @LINE:32
case controllers_api_TicketLinkType_index20(params) => {
   call(params.fromQuery[Option[String]]("callback", None)) { (callback) =>
        invokeHandler(controllers.api.TicketLinkType.index(callback), HandlerDef(this, "controllers.api.TicketLinkType", "index", Seq(classOf[Option[String]]),"GET", """""", Routes.prefix + """api/ticketlinktype"""))
   }
}
        

// @LINE:33
case controllers_api_TicketLinkType_item21(params) => {
   call(params.fromPath[Long]("id", None), params.fromQuery[Option[String]]("callback", None)) { (id, callback) =>
        invokeHandler(controllers.api.TicketLinkType.item(id, callback), HandlerDef(this, "controllers.api.TicketLinkType", "item", Seq(classOf[Long], classOf[Option[String]]),"GET", """""", Routes.prefix + """api/ticketlinktype/$id<[^/]+>"""))
   }
}
        

// @LINE:35
case controllers_api_TicketPriority_index22(params) => {
   call(params.fromQuery[Option[String]]("callback", None)) { (callback) =>
        invokeHandler(controllers.api.TicketPriority.index(callback), HandlerDef(this, "controllers.api.TicketPriority", "index", Seq(classOf[Option[String]]),"GET", """""", Routes.prefix + """api/ticketpriority"""))
   }
}
        

// @LINE:36
case controllers_api_TicketPriority_item23(params) => {
   call(params.fromPath[Long]("id", None), params.fromQuery[Option[String]]("callback", None)) { (id, callback) =>
        invokeHandler(controllers.api.TicketPriority.item(id, callback), HandlerDef(this, "controllers.api.TicketPriority", "item", Seq(classOf[Long], classOf[Option[String]]),"GET", """""", Routes.prefix + """api/ticketpriority/$id<[^/]+>"""))
   }
}
        

// @LINE:38
case controllers_api_TicketResolution_index24(params) => {
   call(params.fromQuery[Option[String]]("callback", None)) { (callback) =>
        invokeHandler(controllers.api.TicketResolution.index(callback), HandlerDef(this, "controllers.api.TicketResolution", "index", Seq(classOf[Option[String]]),"GET", """""", Routes.prefix + """api/ticketresolution"""))
   }
}
        

// @LINE:39
case controllers_api_TicketResolution_item25(params) => {
   call(params.fromPath[Long]("id", None), params.fromQuery[Option[String]]("callback", None)) { (id, callback) =>
        invokeHandler(controllers.api.TicketResolution.item(id, callback), HandlerDef(this, "controllers.api.TicketResolution", "item", Seq(classOf[Long], classOf[Option[String]]),"GET", """""", Routes.prefix + """api/ticketresolution/$id<[^/]+>"""))
   }
}
        

// @LINE:41
case controllers_api_TicketSeverity_index26(params) => {
   call(params.fromQuery[Option[String]]("callback", None)) { (callback) =>
        invokeHandler(controllers.api.TicketSeverity.index(callback), HandlerDef(this, "controllers.api.TicketSeverity", "index", Seq(classOf[Option[String]]),"GET", """""", Routes.prefix + """api/ticketseverity"""))
   }
}
        

// @LINE:42
case controllers_api_TicketSeverity_item27(params) => {
   call(params.fromPath[Long]("id", None), params.fromQuery[Option[String]]("callback", None)) { (id, callback) =>
        invokeHandler(controllers.api.TicketSeverity.item(id, callback), HandlerDef(this, "controllers.api.TicketSeverity", "item", Seq(classOf[Long], classOf[Option[String]]),"GET", """""", Routes.prefix + """api/ticketseverity/$id<[^/]+>"""))
   }
}
        

// @LINE:44
case controllers_api_TicketType_index28(params) => {
   call(params.fromQuery[Option[String]]("callback", None)) { (callback) =>
        invokeHandler(controllers.api.TicketType.index(callback), HandlerDef(this, "controllers.api.TicketType", "index", Seq(classOf[Option[String]]),"GET", """""", Routes.prefix + """api/tickettype"""))
   }
}
        

// @LINE:45
case controllers_api_TicketType_item29(params) => {
   call(params.fromPath[Long]("id", None), params.fromQuery[Option[String]]("callback", None)) { (id, callback) =>
        invokeHandler(controllers.api.TicketType.item(id, callback), HandlerDef(this, "controllers.api.TicketType", "item", Seq(classOf[Long], classOf[Option[String]]),"GET", """""", Routes.prefix + """api/tickettype/$id<[^/]+>"""))
   }
}
        

// @LINE:47
case controllers_api_Timeline_index30(params) => {
   call(params.fromQuery[Int]("page", Some(1)), params.fromQuery[Int]("count", Some(10)), params.fromQuery[Option[String]]("callback", None)) { (page, count, callback) =>
        invokeHandler(controllers.api.Timeline.index(page, count, callback), HandlerDef(this, "controllers.api.Timeline", "index", Seq(classOf[Int], classOf[Int], classOf[Option[String]]),"GET", """""", Routes.prefix + """api/timeline"""))
   }
}
        

// @LINE:49
case controllers_api_User_index31(params) => {
   call(params.fromQuery[Option[String]]("callback", None)) { (callback) =>
        invokeHandler(controllers.api.User.index(callback), HandlerDef(this, "controllers.api.User", "index", Seq(classOf[Option[String]]),"GET", """""", Routes.prefix + """api/user"""))
   }
}
        

// @LINE:50
case controllers_api_User_item32(params) => {
   call(params.fromPath[Long]("id", None), params.fromQuery[Option[String]]("callback", None)) { (id, callback) =>
        invokeHandler(controllers.api.User.item(id, callback), HandlerDef(this, "controllers.api.User", "item", Seq(classOf[Long], classOf[Option[String]]),"GET", """""", Routes.prefix + """api/user/$id<[^/]+>"""))
   }
}
        

// @LINE:51
case controllers_api_User_startsWith33(params) => {
   call(params.fromQuery[Option[String]]("q", None), params.fromQuery[Option[String]]("callback", None)) { (q, callback) =>
        invokeHandler(controllers.api.User.startsWith(q, callback), HandlerDef(this, "controllers.api.User", "startsWith", Seq(classOf[Option[String]], classOf[Option[String]]),"GET", """""", Routes.prefix + """api/user/startswith"""))
   }
}
        

// @LINE:52
case controllers_api_User_deleteToken34(params) => {
   call(params.fromPath[String]("token", None), params.fromQuery[Option[String]]("callback", None)) { (token, callback) =>
        invokeHandler(controllers.api.User.deleteToken(token, callback), HandlerDef(this, "controllers.api.User", "deleteToken", Seq(classOf[String], classOf[Option[String]]),"DELETE", """""", Routes.prefix + """api/user/token/$token<[^/]+>"""))
   }
}
        

// @LINE:53
case controllers_api_User_tokens35(params) => {
   call(params.fromPath[Long]("userId", None), params.fromQuery[Option[String]]("callback", None)) { (userId, callback) =>
        invokeHandler(controllers.api.User.tokens(userId, callback), HandlerDef(this, "controllers.api.User", "tokens", Seq(classOf[Long], classOf[Option[String]]),"GET", """""", Routes.prefix + """api/user/tokens/$userId<[^/]+>"""))
   }
}
        

// @LINE:55
case controllers_api_Workflow_index36(params) => {
   call(params.fromQuery[Option[String]]("callback", None)) { (callback) =>
        invokeHandler(controllers.api.Workflow.index(callback), HandlerDef(this, "controllers.api.Workflow", "index", Seq(classOf[Option[String]]),"GET", """""", Routes.prefix + """api/workflow"""))
   }
}
        

// @LINE:56
case controllers_api_Workflow_item37(params) => {
   call(params.fromPath[Long]("id", None), params.fromQuery[Option[String]]("callback", None)) { (id, callback) =>
        invokeHandler(controllers.api.Workflow.item(id, callback), HandlerDef(this, "controllers.api.Workflow", "item", Seq(classOf[Long], classOf[Option[String]]),"GET", """""", Routes.prefix + """api/workflow/$id<[^/]+>"""))
   }
}
        

// @LINE:57
case controllers_api_Workflow_statuses38(params) => {
   call(params.fromPath[Long]("id", None), params.fromQuery[Option[String]]("callback", None)) { (id, callback) =>
        invokeHandler(controllers.api.Workflow.statuses(id, callback), HandlerDef(this, "controllers.api.Workflow", "statuses", Seq(classOf[Long], classOf[Option[String]]),"GET", """""", Routes.prefix + """api/workflow/$id<[^/]+>/statuses"""))
   }
}
        

// @LINE:59
case controllers_Auth_forgot39(params) => {
   call { 
        invokeHandler(controllers.Auth.forgot, HandlerDef(this, "controllers.Auth", "forgot", Nil,"GET", """""", Routes.prefix + """auth/forgot"""))
   }
}
        

// @LINE:60
case controllers_Auth_login40(params) => {
   call(params.fromQuery[String]("redirectUrl", Some("/"))) { (redirectUrl) =>
        invokeHandler(controllers.Auth.login(redirectUrl), HandlerDef(this, "controllers.Auth", "login", Seq(classOf[String]),"GET", """""", Routes.prefix + """auth/login"""))
   }
}
        

// @LINE:61
case controllers_Auth_logout41(params) => {
   call { 
        invokeHandler(controllers.Auth.logout, HandlerDef(this, "controllers.Auth", "logout", Nil,"GET", """""", Routes.prefix + """auth/logout"""))
   }
}
        

// @LINE:62
case controllers_Auth_reset42(params) => {
   call(params.fromPath[String]("token", None)) { (token) =>
        invokeHandler(controllers.Auth.reset(token), HandlerDef(this, "controllers.Auth", "reset", Seq(classOf[String]),"GET", """""", Routes.prefix + """auth/reset/$token<[^/]+>"""))
   }
}
        

// @LINE:63
case controllers_Auth_doForgot43(params) => {
   call { 
        invokeHandler(controllers.Auth.doForgot(), HandlerDef(this, "controllers.Auth", "doForgot", Nil,"POST", """""", Routes.prefix + """auth/forgot"""))
   }
}
        

// @LINE:64
case controllers_Auth_doLogin44(params) => {
   call(params.fromQuery[String]("redirectUrl", Some("/"))) { (redirectUrl) =>
        invokeHandler(controllers.Auth.doLogin(redirectUrl), HandlerDef(this, "controllers.Auth", "doLogin", Seq(classOf[String]),"POST", """""", Routes.prefix + """auth/login"""))
   }
}
        

// @LINE:65
case controllers_Auth_doReset45(params) => {
   call(params.fromPath[String]("token", None)) { (token) =>
        invokeHandler(controllers.Auth.doReset(token), HandlerDef(this, "controllers.Auth", "doReset", Seq(classOf[String]),"POST", """""", Routes.prefix + """auth/reset/$token<[^/]+>"""))
   }
}
        

// @LINE:67
case controllers_Board_index46(params) => {
   call(params.fromPath[Long]("projectId", None)) { (projectId) =>
        invokeHandler(controllers.Board.index(projectId), HandlerDef(this, "controllers.Board", "index", Seq(classOf[Long]),"GET", """""", Routes.prefix + """board/$projectId<[^/]+>"""))
   }
}
        

// @LINE:69
case controllers_Admin_index47(params) => {
   call { 
        invokeHandler(controllers.Admin.index, HandlerDef(this, "controllers.Admin", "index", Nil,"GET", """""", Routes.prefix + """admin"""))
   }
}
        

// @LINE:71
case controllers_admin_User_create48(params) => {
   call { 
        invokeHandler(controllers.admin.User.create, HandlerDef(this, "controllers.admin.User", "create", Nil,"GET", """""", Routes.prefix + """admin/user/create"""))
   }
}
        

// @LINE:72
case controllers_admin_User_index49(params) => {
   call(params.fromQuery[Int]("page", Some(1)), params.fromQuery[Int]("count", Some(10))) { (page, count) =>
        invokeHandler(controllers.admin.User.index(page, count), HandlerDef(this, "controllers.admin.User", "index", Seq(classOf[Int], classOf[Int]),"GET", """""", Routes.prefix + """admin/user"""))
   }
}
        

// @LINE:73
case controllers_admin_User_add50(params) => {
   call { 
        invokeHandler(controllers.admin.User.add, HandlerDef(this, "controllers.admin.User", "add", Nil,"POST", """""", Routes.prefix + """admin/user"""))
   }
}
        

// @LINE:75
case controllers_Project_create51(params) => {
   call { 
        invokeHandler(controllers.Project.create, HandlerDef(this, "controllers.Project", "create", Nil,"GET", """""", Routes.prefix + """project/create"""))
   }
}
        

// @LINE:76
case controllers_Project_edit52(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.Project.edit(id), HandlerDef(this, "controllers.Project", "edit", Seq(classOf[Long]),"GET", """""", Routes.prefix + """project/edit/$id<[^/]+>"""))
   }
}
        

// @LINE:77
case controllers_Project_item53(params) => {
   call(params.fromPath[Long]("id", None), params.fromQuery[Int]("page", Some(1)), params.fromQuery[Int]("count", Some(10))) { (id, page, count) =>
        invokeHandler(controllers.Project.item(id, page, count), HandlerDef(this, "controllers.Project", "item", Seq(classOf[Long], classOf[Int], classOf[Int]),"GET", """""", Routes.prefix + """project/$id<[^/]+>"""))
   }
}
        

// @LINE:78
case controllers_Project_update54(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.Project.update(id), HandlerDef(this, "controllers.Project", "update", Seq(classOf[Long]),"POST", """""", Routes.prefix + """project/$id<[^/]+>"""))
   }
}
        

// @LINE:79
case controllers_Project_index55(params) => {
   call(params.fromQuery[Int]("page", Some(1)), params.fromQuery[Int]("count", Some(10))) { (page, count) =>
        invokeHandler(controllers.Project.index(page, count), HandlerDef(this, "controllers.Project", "index", Seq(classOf[Int], classOf[Int]),"GET", """""", Routes.prefix + """project"""))
   }
}
        

// @LINE:80
case controllers_Project_add56(params) => {
   call { 
        invokeHandler(controllers.Project.add, HandlerDef(this, "controllers.Project", "add", Nil,"POST", """""", Routes.prefix + """project"""))
   }
}
        

// @LINE:82
case controllers_Search_index57(params) => {
   call(params.fromQuery[Int]("page", Some(1)), params.fromQuery[Int]("count", Some(10)), params.fromQuery[String]("query", Some("*")), Param[Option[String]]("sort", Right(None)), Param[Option[String]]("order", Right(None))) { (page, count, query, sort, order) =>
        invokeHandler(controllers.Search.index(page, count, query, sort, order), HandlerDef(this, "controllers.Search", "index", Seq(classOf[Int], classOf[Int], classOf[String], classOf[Option[String]], classOf[Option[String]]),"GET", """""", Routes.prefix + """search"""))
   }
}
        

// @LINE:84
case controllers_Ticket_create58(params) => {
   call(params.fromQuery[Option[Long]]("project", Some(None))) { (project) =>
        invokeHandler(controllers.Ticket.create(project), HandlerDef(this, "controllers.Ticket", "create", Seq(classOf[Option[Long]]),"GET", """""", Routes.prefix + """ticket/create"""))
   }
}
        

// @LINE:85
case controllers_Ticket_item59(params) => {
   call(params.fromQuery[String]("tab", Some("comments")), params.fromPath[String]("id", None), params.fromQuery[Int]("page", Some(1)), params.fromQuery[Int]("count", Some(10)), params.fromQuery[String]("query", Some("*"))) { (tab, id, page, count, query) =>
        invokeHandler(controllers.Ticket.item(tab, id, page, count, query), HandlerDef(this, "controllers.Ticket", "item", Seq(classOf[String], classOf[String], classOf[Int], classOf[Int], classOf[String]),"GET", """""", Routes.prefix + """ticket/$id<[^/]+>"""))
   }
}
        

// @LINE:87
case controllers_Ticket_update60(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.Ticket.update(id), HandlerDef(this, "controllers.Ticket", "update", Seq(classOf[String]),"POST", """""", Routes.prefix + """ticket/$id<[^/]+>"""))
   }
}
        

// @LINE:88
case controllers_Ticket_edit61(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.Ticket.edit(id), HandlerDef(this, "controllers.Ticket", "edit", Seq(classOf[String]),"GET", """""", Routes.prefix + """ticket/edit/$id<[^/]+>"""))
   }
}
        

// @LINE:90
case controllers_User_edit62(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.User.edit(id), HandlerDef(this, "controllers.User", "edit", Seq(classOf[Long]),"GET", """""", Routes.prefix + """user/edit/$id<[^/]+>"""))
   }
}
        

// @LINE:91
case controllers_User_generateToken63(params) => {
   call(params.fromPath[Long]("userId", None)) { (userId) =>
        invokeHandler(controllers.User.generateToken(userId), HandlerDef(this, "controllers.User", "generateToken", Seq(classOf[Long]),"POST", """""", Routes.prefix + """user/token/$userId<[^/]+>"""))
   }
}
        

// @LINE:92
case controllers_User_updatePassword64(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.User.updatePassword(id), HandlerDef(this, "controllers.User", "updatePassword", Seq(classOf[Long]),"POST", """""", Routes.prefix + """user/$id<[^/]+>/password"""))
   }
}
        

// @LINE:93
case controllers_User_update65(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.User.update(id), HandlerDef(this, "controllers.User", "update", Seq(classOf[Long]),"POST", """""", Routes.prefix + """user/$id<[^/]+>"""))
   }
}
        

// @LINE:94
case controllers_User_item66(params) => {
   call(params.fromPath[Long]("id", None), params.fromQuery[Int]("page", Some(1)), params.fromQuery[Int]("count", Some(10))) { (id, page, count) =>
        invokeHandler(controllers.User.item(id, page, count), HandlerDef(this, "controllers.User", "item", Seq(classOf[Long], classOf[Int], classOf[Int]),"GET", """""", Routes.prefix + """user/$id<[^/]+>"""))
   }
}
        

// @LINE:97
case controllers_Assets_at67(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     