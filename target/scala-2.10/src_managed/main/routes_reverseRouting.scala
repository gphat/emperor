// @SOURCE:/Users/gphat/src/emperor/conf/routes
// @HASH:f8ee4fe950a5c17b8a9c6d118bcd6ef80860b8b9
// @DATE:Sun Nov 17 10:56:32 PST 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:18
// @LINE:17
package controllers.api.third {

// @LINE:17
class ReverseBitBucket {
    

// @LINE:17
def commit(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "api/third/bitbucket/commit")
}
                                                
    
}
                          

// @LINE:18
class ReverseGitHub {
    

// @LINE:18
def commit(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "api/third/github/commit")
}
                                                
    
}
                          
}
                  

// @LINE:97
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
// @LINE:88
// @LINE:87
// @LINE:85
// @LINE:84
// @LINE:82
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:69
// @LINE:67
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:8
// @LINE:6
package controllers {

// @LINE:97
class ReverseAssets {
    

// @LINE:97
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:69
// @LINE:8
class ReverseAdmin {
    

// @LINE:69
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "admin")
}
                                                

// @LINE:8
def reindex(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "admin/reindex")
}
                                                
    
}
                          

// @LINE:67
class ReverseBoard {
    

// @LINE:67
def index(projectId:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "board/" + implicitly[PathBindable[Long]].unbind("projectId", projectId))
}
                                                
    
}
                          

// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
class ReverseAuth {
    

// @LINE:59
def forgot(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "auth/forgot")
}
                                                

// @LINE:62
def reset(token:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "auth/reset/" + implicitly[PathBindable[String]].unbind("token", dynamicString(token)))
}
                                                

// @LINE:64
def doLogin(redirectUrl:String = "/"): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "auth/login" + queryString(List(if(redirectUrl == "/") None else Some(implicitly[QueryStringBindable[String]].unbind("redirectUrl", redirectUrl)))))
}
                                                

// @LINE:61
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "auth/logout")
}
                                                

// @LINE:60
def login(redirectUrl:String = "/"): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "auth/login" + queryString(List(if(redirectUrl == "/") None else Some(implicitly[QueryStringBindable[String]].unbind("redirectUrl", redirectUrl)))))
}
                                                

// @LINE:63
def doForgot(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "auth/forgot")
}
                                                

// @LINE:65
def doReset(token:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "auth/reset/" + implicitly[PathBindable[String]].unbind("token", dynamicString(token)))
}
                                                
    
}
                          

// @LINE:88
// @LINE:87
// @LINE:85
// @LINE:84
class ReverseTicket {
    

// @LINE:88
def edit(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ticket/edit/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                                                

// @LINE:84
def create(project:Option[Long] = None): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ticket/create" + queryString(List(if(project == None) None else Some(implicitly[QueryStringBindable[Option[Long]]].unbind("project", project)))))
}
                                                

// @LINE:87
def update(id:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "ticket/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                                                

// @LINE:85
def item(tab:String = "comments", id:String, page:Int = 1, count:Int = 10, query:String = "*"): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ticket/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + queryString(List(if(tab == "comments") None else Some(implicitly[QueryStringBindable[String]].unbind("tab", tab)), if(page == 1) None else Some(implicitly[QueryStringBindable[Int]].unbind("page", page)), if(count == 10) None else Some(implicitly[QueryStringBindable[Int]].unbind("count", count)), if(query == "*") None else Some(implicitly[QueryStringBindable[String]].unbind("query", query)))))
}
                                                
    
}
                          

// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
class ReverseProject {
    

// @LINE:77
def item(id:Long, page:Int = 1, count:Int = 10): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "project/" + implicitly[PathBindable[Long]].unbind("id", id) + queryString(List(if(page == 1) None else Some(implicitly[QueryStringBindable[Int]].unbind("page", page)), if(count == 10) None else Some(implicitly[QueryStringBindable[Int]].unbind("count", count)))))
}
                                                

// @LINE:75
def create(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "project/create")
}
                                                

// @LINE:76
def edit(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "project/edit/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                

// @LINE:78
def update(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "project/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                

// @LINE:80
def add(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "project")
}
                                                

// @LINE:79
def index(page:Int = 1, count:Int = 10): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "project" + queryString(List(if(page == 1) None else Some(implicitly[QueryStringBindable[Int]].unbind("page", page)), if(count == 10) None else Some(implicitly[QueryStringBindable[Int]].unbind("count", count)))))
}
                                                
    
}
                          

// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
class ReverseUser {
    

// @LINE:94
def item(id:Long, page:Int = 1, count:Int = 10): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user/" + implicitly[PathBindable[Long]].unbind("id", id) + queryString(List(if(page == 1) None else Some(implicitly[QueryStringBindable[Int]].unbind("page", page)), if(count == 10) None else Some(implicitly[QueryStringBindable[Int]].unbind("count", count)))))
}
                                                

// @LINE:90
def edit(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user/edit/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                

// @LINE:93
def update(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                

// @LINE:92
def updatePassword(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/" + implicitly[PathBindable[Long]].unbind("id", id) + "/password")
}
                                                

// @LINE:91
def generateToken(userId:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/token/" + implicitly[PathBindable[Long]].unbind("userId", userId))
}
                                                
    
}
                          

// @LINE:82
class ReverseSearch {
    

// @LINE:82
def index(page:Int = 1, count:Int = 10, query:String = "*"): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "search" + queryString(List(if(page == 1) None else Some(implicitly[QueryStringBindable[Int]].unbind("page", page)), if(count == 10) None else Some(implicitly[QueryStringBindable[Int]].unbind("count", count)), if(query == "*") None else Some(implicitly[QueryStringBindable[String]].unbind("query", query)))))
}
                                                
    
}
                          

// @LINE:6
class ReverseCore {
    

// @LINE:6
def index(page:Int = 1, count:Int = 10): Call = {
   Call("GET", _prefix + queryString(List(if(page == 1) None else Some(implicitly[QueryStringBindable[Int]].unbind("page", page)), if(count == 10) None else Some(implicitly[QueryStringBindable[Int]].unbind("count", count)))))
}
                                                
    
}
                          
}
                  

// @LINE:73
// @LINE:72
// @LINE:71
package controllers.admin {

// @LINE:73
// @LINE:72
// @LINE:71
class ReverseUser {
    

// @LINE:72
def index(page:Int = 1, count:Int = 10): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "admin/user" + queryString(List(if(page == 1) None else Some(implicitly[QueryStringBindable[Int]].unbind("page", page)), if(count == 10) None else Some(implicitly[QueryStringBindable[Int]].unbind("count", count)))))
}
                                                

// @LINE:71
def create(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "admin/user/create")
}
                                                

// @LINE:73
def add(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "admin/user")
}
                                                
    
}
                          
}
                  

// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:47
// @LINE:45
// @LINE:44
// @LINE:42
// @LINE:41
// @LINE:39
// @LINE:38
// @LINE:36
// @LINE:35
// @LINE:33
// @LINE:32
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
package controllers.api {

// @LINE:39
// @LINE:38
class ReverseTicketResolution {
    

// @LINE:39
def item(id:Long, callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/ticketresolution/" + implicitly[PathBindable[Long]].unbind("id", id) + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:38
def index(callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/ticketresolution" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                
    
}
                          

// @LINE:47
class ReverseTimeline {
    

// @LINE:47
def index(page:Int = 1, count:Int = 10, callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/timeline" + queryString(List(if(page == 1) None else Some(implicitly[QueryStringBindable[Int]].unbind("page", page)), if(count == 10) None else Some(implicitly[QueryStringBindable[Int]].unbind("count", count)), Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                
    
}
                          

// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:11
class ReverseTicket {
    

// @LINE:20
def assign(ticketId:String, callback:Option[String]): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "api/ticket/" + implicitly[PathBindable[String]].unbind("ticketId", dynamicString(ticketId)) + "/assign" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:27
def links(ticketId:String, callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/ticket/" + implicitly[PathBindable[String]].unbind("ticketId", dynamicString(ticketId)) + "/link" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:30
def item(id:String, callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/ticket/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:21
def comment(ticketId:String, playframework_escape_type:Option[String], callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/ticket/" + implicitly[PathBindable[String]].unbind("ticketId", dynamicString(ticketId)) + "/comment" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("type", playframework_escape_type)), Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:24
def resolve(ticketId:String, callback:Option[String]): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "api/ticket/" + implicitly[PathBindable[String]].unbind("ticketId", dynamicString(ticketId)) + "/resolve" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:28
def link(ticketId:String, callback:Option[String]): Call = {
   Call("PUT", _prefix + { _defaultPrefix } + "api/ticket/" + implicitly[PathBindable[String]].unbind("ticketId", dynamicString(ticketId)) + "/link" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:11
def create(projectId:Long, callback:Option[String]): Call = {
   Call("PUT", _prefix + { _defaultPrefix } + "api/project/" + implicitly[PathBindable[Long]].unbind("projectId", projectId) + "/ticket" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:26
def changeStatus(ticketId:String, callback:Option[String]): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "api/ticket/" + implicitly[PathBindable[String]].unbind("ticketId", dynamicString(ticketId)) + "/status" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:22
def addComment(ticketId:String, callback:Option[String]): Call = {
   Call("PUT", _prefix + { _defaultPrefix } + "api/ticket/" + implicitly[PathBindable[String]].unbind("ticketId", dynamicString(ticketId)) + "/comment" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:23
def deleteComment(ticketId:String, id:Long, callback:Option[String]): Call = {
   Call("DELETE", _prefix + { _defaultPrefix } + "api/ticket/" + implicitly[PathBindable[String]].unbind("ticketId", dynamicString(ticketId)) + "/comment/" + implicitly[PathBindable[Long]].unbind("id", id) + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:25
def unresolve(ticketId:String, callback:Option[String]): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "api/ticket/" + implicitly[PathBindable[String]].unbind("ticketId", dynamicString(ticketId)) + "/unresolve" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:29
def deleteLink(ticketId:String, id:Long, callback:Option[String]): Call = {
   Call("DELETE", _prefix + { _defaultPrefix } + "api/ticket/" + implicitly[PathBindable[String]].unbind("ticketId", dynamicString(ticketId)) + "/link/" + implicitly[PathBindable[Long]].unbind("id", id) + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                
    
}
                          

// @LINE:45
// @LINE:44
class ReverseTicketType {
    

// @LINE:45
def item(id:Long, callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/tickettype/" + implicitly[PathBindable[Long]].unbind("id", id) + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:44
def index(callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/tickettype" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                
    
}
                          

// @LINE:57
// @LINE:56
// @LINE:55
class ReverseWorkflow {
    

// @LINE:56
def item(id:Long, callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/workflow/" + implicitly[PathBindable[Long]].unbind("id", id) + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:55
def index(callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/workflow" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:57
def statuses(id:Long, callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/workflow/" + implicitly[PathBindable[Long]].unbind("id", id) + "/statuses" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                
    
}
                          

// @LINE:42
// @LINE:41
class ReverseTicketSeverity {
    

// @LINE:42
def item(id:Long, callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/ticketseverity/" + implicitly[PathBindable[Long]].unbind("id", id) + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:41
def index(callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/ticketseverity" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                
    
}
                          

// @LINE:13
// @LINE:12
// @LINE:10
class ReverseProject {
    

// @LINE:13
def item(id:Long, callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/project/" + implicitly[PathBindable[Long]].unbind("id", id) + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:10
def index(callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/project" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:12
def assignableUsers(id:Long, callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/project/" + implicitly[PathBindable[Long]].unbind("id", id) + "/assignees" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                
    
}
                          

// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
class ReverseUser {
    

// @LINE:53
def tokens(userId:Long, callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/user/tokens/" + implicitly[PathBindable[Long]].unbind("userId", userId) + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:51
def startsWith(q:Option[String], callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/user/startswith" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("q", q)), Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:49
def index(callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/user" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:52
def deleteToken(token:String, callback:Option[String]): Call = {
   Call("DELETE", _prefix + { _defaultPrefix } + "api/user/token/" + implicitly[PathBindable[String]].unbind("token", dynamicString(token)) + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:50
def item(id:Long, callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/user/" + implicitly[PathBindable[Long]].unbind("id", id) + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                
    
}
                          

// @LINE:15
class ReverseSearch {
    

// @LINE:15
def index(page:Int = 1, count:Int = 10, query:String = "*", callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/search" + queryString(List(if(page == 1) None else Some(implicitly[QueryStringBindable[Int]].unbind("page", page)), if(count == 10) None else Some(implicitly[QueryStringBindable[Int]].unbind("count", count)), if(query == "*") None else Some(implicitly[QueryStringBindable[String]].unbind("query", query)), Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                
    
}
                          

// @LINE:33
// @LINE:32
class ReverseTicketLinkType {
    

// @LINE:33
def item(id:Long, callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/ticketlinktype/" + implicitly[PathBindable[Long]].unbind("id", id) + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:32
def index(callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/ticketlinktype" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                
    
}
                          

// @LINE:36
// @LINE:35
class ReverseTicketPriority {
    

// @LINE:36
def item(id:Long, callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/ticketpriority/" + implicitly[PathBindable[Long]].unbind("id", id) + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                

// @LINE:35
def index(callback:Option[String]): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/ticketpriority" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("callback", callback)))))
}
                                                
    
}
                          
}
                  


// @LINE:18
// @LINE:17
package controllers.api.third.javascript {

// @LINE:17
class ReverseBitBucket {
    

// @LINE:17
def commit : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.third.BitBucket.commit",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/third/bitbucket/commit"})
      }
   """
)
                        
    
}
              

// @LINE:18
class ReverseGitHub {
    

// @LINE:18
def commit : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.third.GitHub.commit",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/third/github/commit"})
      }
   """
)
                        
    
}
              
}
        

// @LINE:97
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
// @LINE:88
// @LINE:87
// @LINE:85
// @LINE:84
// @LINE:82
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:69
// @LINE:67
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:8
// @LINE:6
package controllers.javascript {

// @LINE:97
class ReverseAssets {
    

// @LINE:97
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:69
// @LINE:8
class ReverseAdmin {
    

// @LINE:69
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin"})
      }
   """
)
                        

// @LINE:8
def reindex : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.reindex",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/reindex"})
      }
   """
)
                        
    
}
              

// @LINE:67
class ReverseBoard {
    

// @LINE:67
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Board.index",
   """
      function(projectId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "board/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("projectId", projectId)})
      }
   """
)
                        
    
}
              

// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
class ReverseAuth {
    

// @LINE:59
def forgot : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Auth.forgot",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/forgot"})
      }
   """
)
                        

// @LINE:62
def reset : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Auth.reset",
   """
      function(token) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/reset/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("token", encodeURIComponent(token))})
      }
   """
)
                        

// @LINE:64
def doLogin : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Auth.doLogin",
   """
      function(redirectUrl) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/login" + _qS([(redirectUrl == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("redirectUrl", redirectUrl))])})
      }
   """
)
                        

// @LINE:61
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Auth.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/logout"})
      }
   """
)
                        

// @LINE:60
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Auth.login",
   """
      function(redirectUrl) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/login" + _qS([(redirectUrl == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("redirectUrl", redirectUrl))])})
      }
   """
)
                        

// @LINE:63
def doForgot : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Auth.doForgot",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/forgot"})
      }
   """
)
                        

// @LINE:65
def doReset : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Auth.doReset",
   """
      function(token) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/reset/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("token", encodeURIComponent(token))})
      }
   """
)
                        
    
}
              

// @LINE:88
// @LINE:87
// @LINE:85
// @LINE:84
class ReverseTicket {
    

// @LINE:88
def edit : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Ticket.edit",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ticket/edit/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:84
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Ticket.create",
   """
      function(project) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ticket/create" + _qS([(project == null ? null : (""" + implicitly[QueryStringBindable[Option[Long]]].javascriptUnbind + """)("project", project))])})
      }
   """
)
                        

// @LINE:87
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Ticket.update",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ticket/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:85
def item : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Ticket.item",
   """
      function(tab,id,page,count,query) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ticket/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + _qS([(tab == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("tab", tab)), (page == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("page", page)), (count == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("count", count)), (query == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("query", query))])})
      }
   """
)
                        
    
}
              

// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
class ReverseProject {
    

// @LINE:77
def item : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Project.item",
   """
      function(id,page,count) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "project/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + _qS([(page == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("page", page)), (count == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("count", count))])})
      }
   """
)
                        

// @LINE:75
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Project.create",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "project/create"})
      }
   """
)
                        

// @LINE:76
def edit : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Project.edit",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "project/edit/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:78
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Project.update",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "project/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:80
def add : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Project.add",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "project"})
      }
   """
)
                        

// @LINE:79
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Project.index",
   """
      function(page,count) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "project" + _qS([(page == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("page", page)), (count == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("count", count))])})
      }
   """
)
                        
    
}
              

// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
class ReverseUser {
    

// @LINE:94
def item : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.User.item",
   """
      function(id,page,count) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + _qS([(page == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("page", page)), (count == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("count", count))])})
      }
   """
)
                        

// @LINE:90
def edit : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.User.edit",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/edit/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:93
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.User.update",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:92
def updatePassword : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.User.updatePassword",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/password"})
      }
   """
)
                        

// @LINE:91
def generateToken : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.User.generateToken",
   """
      function(userId) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/token/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("userId", userId)})
      }
   """
)
                        
    
}
              

// @LINE:82
class ReverseSearch {
    

// @LINE:82
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Search.index",
   """
      function(page,count,query) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "search" + _qS([(page == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("page", page)), (count == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("count", count)), (query == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("query", query))])})
      }
   """
)
                        
    
}
              

// @LINE:6
class ReverseCore {
    

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Core.index",
   """
      function(page,count) {
      return _wA({method:"GET", url:"""" + _prefix + """" + _qS([(page == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("page", page)), (count == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("count", count))])})
      }
   """
)
                        
    
}
              
}
        

// @LINE:73
// @LINE:72
// @LINE:71
package controllers.admin.javascript {

// @LINE:73
// @LINE:72
// @LINE:71
class ReverseUser {
    

// @LINE:72
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.admin.User.index",
   """
      function(page,count) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/user" + _qS([(page == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("page", page)), (count == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("count", count))])})
      }
   """
)
                        

// @LINE:71
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.admin.User.create",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/user/create"})
      }
   """
)
                        

// @LINE:73
def add : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.admin.User.add",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/user"})
      }
   """
)
                        
    
}
              
}
        

// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:47
// @LINE:45
// @LINE:44
// @LINE:42
// @LINE:41
// @LINE:39
// @LINE:38
// @LINE:36
// @LINE:35
// @LINE:33
// @LINE:32
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
package controllers.api.javascript {

// @LINE:39
// @LINE:38
class ReverseTicketResolution {
    

// @LINE:39
def item : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.TicketResolution.item",
   """
      function(id,callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ticketresolution/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:38
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.TicketResolution.index",
   """
      function(callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ticketresolution" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        
    
}
              

// @LINE:47
class ReverseTimeline {
    

// @LINE:47
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.Timeline.index",
   """
      function(page,count,callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/timeline" + _qS([(page == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("page", page)), (count == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("count", count)), (""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        
    
}
              

// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:11
class ReverseTicket {
    

// @LINE:20
def assign : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.Ticket.assign",
   """
      function(ticketId,callback) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ticket/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("ticketId", encodeURIComponent(ticketId)) + "/assign" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:27
def links : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.Ticket.links",
   """
      function(ticketId,callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ticket/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("ticketId", encodeURIComponent(ticketId)) + "/link" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:30
def item : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.Ticket.item",
   """
      function(id,callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ticket/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:21
def comment : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.Ticket.comment",
   """
      function(ticketId,type,callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ticket/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("ticketId", encodeURIComponent(ticketId)) + "/comment" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("type", type), (""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:24
def resolve : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.Ticket.resolve",
   """
      function(ticketId,callback) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ticket/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("ticketId", encodeURIComponent(ticketId)) + "/resolve" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:28
def link : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.Ticket.link",
   """
      function(ticketId,callback) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ticket/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("ticketId", encodeURIComponent(ticketId)) + "/link" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:11
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.Ticket.create",
   """
      function(projectId,callback) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/project/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("projectId", projectId) + "/ticket" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:26
def changeStatus : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.Ticket.changeStatus",
   """
      function(ticketId,callback) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ticket/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("ticketId", encodeURIComponent(ticketId)) + "/status" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:22
def addComment : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.Ticket.addComment",
   """
      function(ticketId,callback) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ticket/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("ticketId", encodeURIComponent(ticketId)) + "/comment" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:23
def deleteComment : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.Ticket.deleteComment",
   """
      function(ticketId,id,callback) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ticket/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("ticketId", encodeURIComponent(ticketId)) + "/comment/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:25
def unresolve : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.Ticket.unresolve",
   """
      function(ticketId,callback) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ticket/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("ticketId", encodeURIComponent(ticketId)) + "/unresolve" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:29
def deleteLink : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.Ticket.deleteLink",
   """
      function(ticketId,id,callback) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ticket/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("ticketId", encodeURIComponent(ticketId)) + "/link/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        
    
}
              

// @LINE:45
// @LINE:44
class ReverseTicketType {
    

// @LINE:45
def item : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.TicketType.item",
   """
      function(id,callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/tickettype/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:44
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.TicketType.index",
   """
      function(callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/tickettype" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        
    
}
              

// @LINE:57
// @LINE:56
// @LINE:55
class ReverseWorkflow {
    

// @LINE:56
def item : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.Workflow.item",
   """
      function(id,callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/workflow/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:55
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.Workflow.index",
   """
      function(callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/workflow" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:57
def statuses : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.Workflow.statuses",
   """
      function(id,callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/workflow/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/statuses" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        
    
}
              

// @LINE:42
// @LINE:41
class ReverseTicketSeverity {
    

// @LINE:42
def item : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.TicketSeverity.item",
   """
      function(id,callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ticketseverity/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:41
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.TicketSeverity.index",
   """
      function(callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ticketseverity" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        
    
}
              

// @LINE:13
// @LINE:12
// @LINE:10
class ReverseProject {
    

// @LINE:13
def item : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.Project.item",
   """
      function(id,callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/project/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:10
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.Project.index",
   """
      function(callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/project" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:12
def assignableUsers : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.Project.assignableUsers",
   """
      function(id,callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/project/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/assignees" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        
    
}
              

// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
class ReverseUser {
    

// @LINE:53
def tokens : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.User.tokens",
   """
      function(userId,callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/tokens/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("userId", userId) + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:51
def startsWith : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.User.startsWith",
   """
      function(q,callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/startswith" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("q", q), (""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:49
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.User.index",
   """
      function(callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:52
def deleteToken : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.User.deleteToken",
   """
      function(token,callback) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/token/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("token", encodeURIComponent(token)) + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:50
def item : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.User.item",
   """
      function(id,callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        
    
}
              

// @LINE:15
class ReverseSearch {
    

// @LINE:15
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.Search.index",
   """
      function(page,count,query,callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/search" + _qS([(page == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("page", page)), (count == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("count", count)), (query == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("query", query)), (""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        
    
}
              

// @LINE:33
// @LINE:32
class ReverseTicketLinkType {
    

// @LINE:33
def item : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.TicketLinkType.item",
   """
      function(id,callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ticketlinktype/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:32
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.TicketLinkType.index",
   """
      function(callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ticketlinktype" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        
    
}
              

// @LINE:36
// @LINE:35
class ReverseTicketPriority {
    

// @LINE:36
def item : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.TicketPriority.item",
   """
      function(id,callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ticketpriority/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        

// @LINE:35
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.api.TicketPriority.index",
   """
      function(callback) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ticketpriority" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("callback", callback)])})
      }
   """
)
                        
    
}
              
}
        


// @LINE:18
// @LINE:17
package controllers.api.third.ref {


// @LINE:17
class ReverseBitBucket {
    

// @LINE:17
def commit(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.third.BitBucket.commit(), HandlerDef(this, "controllers.api.third.BitBucket", "commit", Seq(), "POST", """""", _prefix + """api/third/bitbucket/commit""")
)
                      
    
}
                          

// @LINE:18
class ReverseGitHub {
    

// @LINE:18
def commit(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.third.GitHub.commit(), HandlerDef(this, "controllers.api.third.GitHub", "commit", Seq(), "POST", """""", _prefix + """api/third/github/commit""")
)
                      
    
}
                          
}
        

// @LINE:97
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
// @LINE:88
// @LINE:87
// @LINE:85
// @LINE:84
// @LINE:82
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:69
// @LINE:67
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:8
// @LINE:6
package controllers.ref {


// @LINE:97
class ReverseAssets {
    

// @LINE:97
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:69
// @LINE:8
class ReverseAdmin {
    

// @LINE:69
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.index(), HandlerDef(this, "controllers.Admin", "index", Seq(), "GET", """""", _prefix + """admin""")
)
                      

// @LINE:8
def reindex(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.reindex(), HandlerDef(this, "controllers.Admin", "reindex", Seq(), "GET", """""", _prefix + """admin/reindex""")
)
                      
    
}
                          

// @LINE:67
class ReverseBoard {
    

// @LINE:67
def index(projectId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Board.index(projectId), HandlerDef(this, "controllers.Board", "index", Seq(classOf[Long]), "GET", """""", _prefix + """board/$projectId<[^/]+>""")
)
                      
    
}
                          

// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
class ReverseAuth {
    

// @LINE:59
def forgot(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Auth.forgot(), HandlerDef(this, "controllers.Auth", "forgot", Seq(), "GET", """""", _prefix + """auth/forgot""")
)
                      

// @LINE:62
def reset(token:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Auth.reset(token), HandlerDef(this, "controllers.Auth", "reset", Seq(classOf[String]), "GET", """""", _prefix + """auth/reset/$token<[^/]+>""")
)
                      

// @LINE:64
def doLogin(redirectUrl:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Auth.doLogin(redirectUrl), HandlerDef(this, "controllers.Auth", "doLogin", Seq(classOf[String]), "POST", """""", _prefix + """auth/login""")
)
                      

// @LINE:61
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Auth.logout(), HandlerDef(this, "controllers.Auth", "logout", Seq(), "GET", """""", _prefix + """auth/logout""")
)
                      

// @LINE:60
def login(redirectUrl:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Auth.login(redirectUrl), HandlerDef(this, "controllers.Auth", "login", Seq(classOf[String]), "GET", """""", _prefix + """auth/login""")
)
                      

// @LINE:63
def doForgot(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Auth.doForgot(), HandlerDef(this, "controllers.Auth", "doForgot", Seq(), "POST", """""", _prefix + """auth/forgot""")
)
                      

// @LINE:65
def doReset(token:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Auth.doReset(token), HandlerDef(this, "controllers.Auth", "doReset", Seq(classOf[String]), "POST", """""", _prefix + """auth/reset/$token<[^/]+>""")
)
                      
    
}
                          

// @LINE:88
// @LINE:87
// @LINE:85
// @LINE:84
class ReverseTicket {
    

// @LINE:88
def edit(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Ticket.edit(id), HandlerDef(this, "controllers.Ticket", "edit", Seq(classOf[String]), "GET", """""", _prefix + """ticket/edit/$id<[^/]+>""")
)
                      

// @LINE:84
def create(project:Option[Long]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Ticket.create(project), HandlerDef(this, "controllers.Ticket", "create", Seq(classOf[Option[Long]]), "GET", """""", _prefix + """ticket/create""")
)
                      

// @LINE:87
def update(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Ticket.update(id), HandlerDef(this, "controllers.Ticket", "update", Seq(classOf[String]), "POST", """""", _prefix + """ticket/$id<[^/]+>""")
)
                      

// @LINE:85
def item(tab:String, id:String, page:Int, count:Int, query:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Ticket.item(tab, id, page, count, query), HandlerDef(this, "controllers.Ticket", "item", Seq(classOf[String], classOf[String], classOf[Int], classOf[Int], classOf[String]), "GET", """""", _prefix + """ticket/$id<[^/]+>""")
)
                      
    
}
                          

// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
class ReverseProject {
    

// @LINE:77
def item(id:Long, page:Int, count:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Project.item(id, page, count), HandlerDef(this, "controllers.Project", "item", Seq(classOf[Long], classOf[Int], classOf[Int]), "GET", """""", _prefix + """project/$id<[^/]+>""")
)
                      

// @LINE:75
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Project.create(), HandlerDef(this, "controllers.Project", "create", Seq(), "GET", """""", _prefix + """project/create""")
)
                      

// @LINE:76
def edit(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Project.edit(id), HandlerDef(this, "controllers.Project", "edit", Seq(classOf[Long]), "GET", """""", _prefix + """project/edit/$id<[^/]+>""")
)
                      

// @LINE:78
def update(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Project.update(id), HandlerDef(this, "controllers.Project", "update", Seq(classOf[Long]), "POST", """""", _prefix + """project/$id<[^/]+>""")
)
                      

// @LINE:80
def add(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Project.add(), HandlerDef(this, "controllers.Project", "add", Seq(), "POST", """""", _prefix + """project""")
)
                      

// @LINE:79
def index(page:Int, count:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Project.index(page, count), HandlerDef(this, "controllers.Project", "index", Seq(classOf[Int], classOf[Int]), "GET", """""", _prefix + """project""")
)
                      
    
}
                          

// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
class ReverseUser {
    

// @LINE:94
def item(id:Long, page:Int, count:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.User.item(id, page, count), HandlerDef(this, "controllers.User", "item", Seq(classOf[Long], classOf[Int], classOf[Int]), "GET", """""", _prefix + """user/$id<[^/]+>""")
)
                      

// @LINE:90
def edit(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.User.edit(id), HandlerDef(this, "controllers.User", "edit", Seq(classOf[Long]), "GET", """""", _prefix + """user/edit/$id<[^/]+>""")
)
                      

// @LINE:93
def update(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.User.update(id), HandlerDef(this, "controllers.User", "update", Seq(classOf[Long]), "POST", """""", _prefix + """user/$id<[^/]+>""")
)
                      

// @LINE:92
def updatePassword(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.User.updatePassword(id), HandlerDef(this, "controllers.User", "updatePassword", Seq(classOf[Long]), "POST", """""", _prefix + """user/$id<[^/]+>/password""")
)
                      

// @LINE:91
def generateToken(userId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.User.generateToken(userId), HandlerDef(this, "controllers.User", "generateToken", Seq(classOf[Long]), "POST", """""", _prefix + """user/token/$userId<[^/]+>""")
)
                      
    
}
                          

// @LINE:82
class ReverseSearch {
    

// @LINE:82
def index(page:Int, count:Int, query:String, sort:Option[String], order:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Search.index(page, count, query, sort, order), HandlerDef(this, "controllers.Search", "index", Seq(classOf[Int], classOf[Int], classOf[String], classOf[Option[String]], classOf[Option[String]]), "GET", """""", _prefix + """search""")
)
                      
    
}
                          

// @LINE:6
class ReverseCore {
    

// @LINE:6
def index(page:Int, count:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Core.index(page, count), HandlerDef(this, "controllers.Core", "index", Seq(classOf[Int], classOf[Int]), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          
}
        

// @LINE:73
// @LINE:72
// @LINE:71
package controllers.admin.ref {


// @LINE:73
// @LINE:72
// @LINE:71
class ReverseUser {
    

// @LINE:72
def index(page:Int, count:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.admin.User.index(page, count), HandlerDef(this, "controllers.admin.User", "index", Seq(classOf[Int], classOf[Int]), "GET", """""", _prefix + """admin/user""")
)
                      

// @LINE:71
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.admin.User.create(), HandlerDef(this, "controllers.admin.User", "create", Seq(), "GET", """""", _prefix + """admin/user/create""")
)
                      

// @LINE:73
def add(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.admin.User.add(), HandlerDef(this, "controllers.admin.User", "add", Seq(), "POST", """""", _prefix + """admin/user""")
)
                      
    
}
                          
}
        

// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:47
// @LINE:45
// @LINE:44
// @LINE:42
// @LINE:41
// @LINE:39
// @LINE:38
// @LINE:36
// @LINE:35
// @LINE:33
// @LINE:32
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
package controllers.api.ref {


// @LINE:39
// @LINE:38
class ReverseTicketResolution {
    

// @LINE:39
def item(id:Long, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.TicketResolution.item(id, callback), HandlerDef(this, "controllers.api.TicketResolution", "item", Seq(classOf[Long], classOf[Option[String]]), "GET", """""", _prefix + """api/ticketresolution/$id<[^/]+>""")
)
                      

// @LINE:38
def index(callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.TicketResolution.index(callback), HandlerDef(this, "controllers.api.TicketResolution", "index", Seq(classOf[Option[String]]), "GET", """""", _prefix + """api/ticketresolution""")
)
                      
    
}
                          

// @LINE:47
class ReverseTimeline {
    

// @LINE:47
def index(page:Int, count:Int, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.Timeline.index(page, count, callback), HandlerDef(this, "controllers.api.Timeline", "index", Seq(classOf[Int], classOf[Int], classOf[Option[String]]), "GET", """""", _prefix + """api/timeline""")
)
                      
    
}
                          

// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:11
class ReverseTicket {
    

// @LINE:20
def assign(ticketId:String, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.Ticket.assign(ticketId, callback), HandlerDef(this, "controllers.api.Ticket", "assign", Seq(classOf[String], classOf[Option[String]]), "POST", """""", _prefix + """api/ticket/$ticketId<[^/]+>/assign""")
)
                      

// @LINE:27
def links(ticketId:String, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.Ticket.links(ticketId, callback), HandlerDef(this, "controllers.api.Ticket", "links", Seq(classOf[String], classOf[Option[String]]), "GET", """""", _prefix + """api/ticket/$ticketId<[^/]+>/link""")
)
                      

// @LINE:30
def item(id:String, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.Ticket.item(id, callback), HandlerDef(this, "controllers.api.Ticket", "item", Seq(classOf[String], classOf[Option[String]]), "GET", """""", _prefix + """api/ticket/$id<[^/]+>""")
)
                      

// @LINE:21
def comment(ticketId:String, playframework_escape_type:Option[String], callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.Ticket.comment(ticketId, playframework_escape_type, callback), HandlerDef(this, "controllers.api.Ticket", "comment", Seq(classOf[String], classOf[Option[String]], classOf[Option[String]]), "GET", """""", _prefix + """api/ticket/$ticketId<[^/]+>/comment""")
)
                      

// @LINE:24
def resolve(ticketId:String, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.Ticket.resolve(ticketId, callback), HandlerDef(this, "controllers.api.Ticket", "resolve", Seq(classOf[String], classOf[Option[String]]), "POST", """""", _prefix + """api/ticket/$ticketId<[^/]+>/resolve""")
)
                      

// @LINE:28
def link(ticketId:String, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.Ticket.link(ticketId, callback), HandlerDef(this, "controllers.api.Ticket", "link", Seq(classOf[String], classOf[Option[String]]), "PUT", """""", _prefix + """api/ticket/$ticketId<[^/]+>/link""")
)
                      

// @LINE:11
def create(projectId:Long, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.Ticket.create(projectId, callback), HandlerDef(this, "controllers.api.Ticket", "create", Seq(classOf[Long], classOf[Option[String]]), "PUT", """""", _prefix + """api/project/$projectId<[^/]+>/ticket""")
)
                      

// @LINE:26
def changeStatus(ticketId:String, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.Ticket.changeStatus(ticketId, callback), HandlerDef(this, "controllers.api.Ticket", "changeStatus", Seq(classOf[String], classOf[Option[String]]), "POST", """""", _prefix + """api/ticket/$ticketId<[^/]+>/status""")
)
                      

// @LINE:22
def addComment(ticketId:String, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.Ticket.addComment(ticketId, callback), HandlerDef(this, "controllers.api.Ticket", "addComment", Seq(classOf[String], classOf[Option[String]]), "PUT", """""", _prefix + """api/ticket/$ticketId<[^/]+>/comment""")
)
                      

// @LINE:23
def deleteComment(ticketId:String, id:Long, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.Ticket.deleteComment(ticketId, id, callback), HandlerDef(this, "controllers.api.Ticket", "deleteComment", Seq(classOf[String], classOf[Long], classOf[Option[String]]), "DELETE", """""", _prefix + """api/ticket/$ticketId<[^/]+>/comment/$id<[^/]+>""")
)
                      

// @LINE:25
def unresolve(ticketId:String, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.Ticket.unresolve(ticketId, callback), HandlerDef(this, "controllers.api.Ticket", "unresolve", Seq(classOf[String], classOf[Option[String]]), "POST", """""", _prefix + """api/ticket/$ticketId<[^/]+>/unresolve""")
)
                      

// @LINE:29
def deleteLink(ticketId:String, id:Long, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.Ticket.deleteLink(ticketId, id, callback), HandlerDef(this, "controllers.api.Ticket", "deleteLink", Seq(classOf[String], classOf[Long], classOf[Option[String]]), "DELETE", """""", _prefix + """api/ticket/$ticketId<[^/]+>/link/$id<[^/]+>""")
)
                      
    
}
                          

// @LINE:45
// @LINE:44
class ReverseTicketType {
    

// @LINE:45
def item(id:Long, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.TicketType.item(id, callback), HandlerDef(this, "controllers.api.TicketType", "item", Seq(classOf[Long], classOf[Option[String]]), "GET", """""", _prefix + """api/tickettype/$id<[^/]+>""")
)
                      

// @LINE:44
def index(callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.TicketType.index(callback), HandlerDef(this, "controllers.api.TicketType", "index", Seq(classOf[Option[String]]), "GET", """""", _prefix + """api/tickettype""")
)
                      
    
}
                          

// @LINE:57
// @LINE:56
// @LINE:55
class ReverseWorkflow {
    

// @LINE:56
def item(id:Long, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.Workflow.item(id, callback), HandlerDef(this, "controllers.api.Workflow", "item", Seq(classOf[Long], classOf[Option[String]]), "GET", """""", _prefix + """api/workflow/$id<[^/]+>""")
)
                      

// @LINE:55
def index(callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.Workflow.index(callback), HandlerDef(this, "controllers.api.Workflow", "index", Seq(classOf[Option[String]]), "GET", """""", _prefix + """api/workflow""")
)
                      

// @LINE:57
def statuses(id:Long, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.Workflow.statuses(id, callback), HandlerDef(this, "controllers.api.Workflow", "statuses", Seq(classOf[Long], classOf[Option[String]]), "GET", """""", _prefix + """api/workflow/$id<[^/]+>/statuses""")
)
                      
    
}
                          

// @LINE:42
// @LINE:41
class ReverseTicketSeverity {
    

// @LINE:42
def item(id:Long, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.TicketSeverity.item(id, callback), HandlerDef(this, "controllers.api.TicketSeverity", "item", Seq(classOf[Long], classOf[Option[String]]), "GET", """""", _prefix + """api/ticketseverity/$id<[^/]+>""")
)
                      

// @LINE:41
def index(callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.TicketSeverity.index(callback), HandlerDef(this, "controllers.api.TicketSeverity", "index", Seq(classOf[Option[String]]), "GET", """""", _prefix + """api/ticketseverity""")
)
                      
    
}
                          

// @LINE:13
// @LINE:12
// @LINE:10
class ReverseProject {
    

// @LINE:13
def item(id:Long, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.Project.item(id, callback), HandlerDef(this, "controllers.api.Project", "item", Seq(classOf[Long], classOf[Option[String]]), "GET", """""", _prefix + """api/project/$id<[^/]+>""")
)
                      

// @LINE:10
def index(callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.Project.index(callback), HandlerDef(this, "controllers.api.Project", "index", Seq(classOf[Option[String]]), "GET", """""", _prefix + """api/project""")
)
                      

// @LINE:12
def assignableUsers(id:Long, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.Project.assignableUsers(id, callback), HandlerDef(this, "controllers.api.Project", "assignableUsers", Seq(classOf[Long], classOf[Option[String]]), "GET", """""", _prefix + """api/project/$id<[^/]+>/assignees""")
)
                      
    
}
                          

// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
class ReverseUser {
    

// @LINE:53
def tokens(userId:Long, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.User.tokens(userId, callback), HandlerDef(this, "controllers.api.User", "tokens", Seq(classOf[Long], classOf[Option[String]]), "GET", """""", _prefix + """api/user/tokens/$userId<[^/]+>""")
)
                      

// @LINE:51
def startsWith(q:Option[String], callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.User.startsWith(q, callback), HandlerDef(this, "controllers.api.User", "startsWith", Seq(classOf[Option[String]], classOf[Option[String]]), "GET", """""", _prefix + """api/user/startswith""")
)
                      

// @LINE:49
def index(callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.User.index(callback), HandlerDef(this, "controllers.api.User", "index", Seq(classOf[Option[String]]), "GET", """""", _prefix + """api/user""")
)
                      

// @LINE:52
def deleteToken(token:String, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.User.deleteToken(token, callback), HandlerDef(this, "controllers.api.User", "deleteToken", Seq(classOf[String], classOf[Option[String]]), "DELETE", """""", _prefix + """api/user/token/$token<[^/]+>""")
)
                      

// @LINE:50
def item(id:Long, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.User.item(id, callback), HandlerDef(this, "controllers.api.User", "item", Seq(classOf[Long], classOf[Option[String]]), "GET", """""", _prefix + """api/user/$id<[^/]+>""")
)
                      
    
}
                          

// @LINE:15
class ReverseSearch {
    

// @LINE:15
def index(page:Int, count:Int, query:String, sort:Option[String], order:Option[String], callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.Search.index(page, count, query, sort, order, callback), HandlerDef(this, "controllers.api.Search", "index", Seq(classOf[Int], classOf[Int], classOf[String], classOf[Option[String]], classOf[Option[String]], classOf[Option[String]]), "GET", """""", _prefix + """api/search""")
)
                      
    
}
                          

// @LINE:33
// @LINE:32
class ReverseTicketLinkType {
    

// @LINE:33
def item(id:Long, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.TicketLinkType.item(id, callback), HandlerDef(this, "controllers.api.TicketLinkType", "item", Seq(classOf[Long], classOf[Option[String]]), "GET", """""", _prefix + """api/ticketlinktype/$id<[^/]+>""")
)
                      

// @LINE:32
def index(callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.TicketLinkType.index(callback), HandlerDef(this, "controllers.api.TicketLinkType", "index", Seq(classOf[Option[String]]), "GET", """""", _prefix + """api/ticketlinktype""")
)
                      
    
}
                          

// @LINE:36
// @LINE:35
class ReverseTicketPriority {
    

// @LINE:36
def item(id:Long, callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.TicketPriority.item(id, callback), HandlerDef(this, "controllers.api.TicketPriority", "item", Seq(classOf[Long], classOf[Option[String]]), "GET", """""", _prefix + """api/ticketpriority/$id<[^/]+>""")
)
                      

// @LINE:35
def index(callback:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.api.TicketPriority.index(callback), HandlerDef(this, "controllers.api.TicketPriority", "index", Seq(classOf[Option[String]]), "GET", """""", _prefix + """api/ticketpriority""")
)
                      
    
}
                          
}
        
    