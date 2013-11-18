var resources = {
  dev: { translation: { 'key': 'value' } },
  en: { translation: { 'key': 'value' } },            
  'en-US': {
    translation: {
      'filter_link_name': '__name__: __value__',
      'pager_summary': '__start__ to __finish__ of __total__',
      'TLINE_EVENT_TYPE_TICKET_COMMIT': '__user__ committed on <a href="/ticket/__id__">__id__</a> at __date__',
      'TLINE_EVENT_TYPE_TICKET_COMMENT': '__user__ commented on <a href="/ticket/__id__">__id__</a> at __date__',
      'TLINE_EVENT_TYPE_TICKET_CHANGE': '__user__ changed <a href="/ticket/__id__">__id__</a> at __date__',
      'TLINE_EVENT_TYPE_TICKET_CREATE': '__user__ created <a href="/ticket/__id__">__id__</a> at __date__',
      'TLINE_EVENT_TYPE_TICKET_STATUS': '__user__ updated <a href="/ticket/__id__">__id__</a> at __date__',
      'TLINE_EVENT_TYPE_TICKET_RESOLVE': '__user__ resolved <a href="/ticket/__id__">__id__</a> at __date__',
      'TLINE_EVENT_TYPE_TICKET_UNRESOLVE': '__user__ unresolved <a href="/ticket/__id__">__id__</a> at __date__',
      'EVENT_TYPE_TICKET_CHANGE': 'Ticket Changed',
      'EVENT_TYPE_TICKET_COMMENT': 'Commented',
      'EVENT_TYPE_TICKET_COMMIT': 'Committed',
      'EVENT_TYPE_TICKET_CREATE': 'Ticket Created',
      'EVENT_TYPE_TICKET_RESOLVE': 'Ticket Resolved',
      'EVENT_TYPE_TICKET_STATUS': 'Ticket Status Changed',
      'EVENT_TYPE_TICKET_UNRESOLVE': 'Ticket Unresolved',
      'TICK_LINK_BLOCKS': 'blocking',
      'TICK_LINK_BLOCKED_BY': 'blocked by',
      'TICK_LINK_CONTAINS': 'containing',
      'TICK_LINK_CONTAINED_IN': 'contained in',
      'TICK_LINK_RELATED': 'related to',
      'TICK_PRIO_LOW': 'Low',
      'TICK_PRIO_NORMAL': 'Normal',
      'TICK_PRIO_HIGH': 'High',
      'TICK_RESO_CANTREPRO': 'Cannot Reproduce',
      'TICK_RESO_FIXED': 'Fixed',
      'TICK_RESO_UNRESOLVED': 'Unresolved',
      'TICK_RESO_WONTFIX': "Won't Fix",
      'TICK_SEV_DIFFICULT': 'Difficult',
      'TICK_SEV_NORMAL': 'Normal',
      'TICK_SEV_TRIVIAL': 'Trivial',
      'TICK_STATUS_NEW': 'New',
      'TICK_STATUS_OPEN': 'Open',
      'TICK_STATUS_IN_PROG': 'In Progress',
      'TICK_STATUS_IN_REVIEW': 'In Review',
      'TICK_STATUS_MERGED': 'Merged',
      'TICK_TYPE_BUG': 'Bug',
      'TICK_TYPE_IMPROVEMENT': 'Improvement',
      'TICK_TYPE_MILESTONE': 'Milestone',
      'TICK_TYPE_TASK': 'Task'
    }
  }
};
 
i18n.init({ resStore: resources });

ko.bindingHandlers.i18nText = {
  init: function(element, valueAccessor, allBindingsAccessor, viewModel, bindingContext) {
    // This will be called when the binding is first applied to an element
    // Set up any initial state, event handlers, etc. here
    return { 'controlsDescendantBindings': true };
  },
  update: function(element, valueAccessor, allBindingsAccessor, viewModel, bindingContext) {
    // This will be called once when the binding is first applied to an element,
    // and again whenever the associated observable changes value.
    // Update the DOM element based on the supplied values here.
    $(element).text(i18n.t.apply(i18n, ko.unwrap(valueAccessor())));
    // ko.utils.setTextContent(element, );
  }
};

ko.bindingHandlers.i18nHtml = {
  init: function(element, valueAccessor, allBindingsAccessor, viewModel, bindingContext) {
    // This will be called when the binding is first applied to an element
    // Set up any initial state, event handlers, etc. here
    return { 'controlsDescendantBindings': true };
  },
  update: function(element, valueAccessor, allBindingsAccessor, viewModel, bindingContext) {
    // This will be called once when the binding is first applied to an element,
    // and again whenever the associated observable changes value.
    // Update the DOM element based on the supplied values here.
    $(element).html(i18n.t.apply(i18n, ko.unwrap(valueAccessor())));
  }
};

//an observable that retrieves its value when first bound
ko.onDemandObservable = function(callback, target) {
  var _value = ko.observable();  //private observable

  var result = ko.dependentObservable({
    read: function() {
      //if it has not been loaded, execute the supplied function
      if (!result.loaded()) {
        callback.call(target);
      }
      //always return the current value
      return _value();
    },
    write: function(newValue) {
      //indicate that the value is now loaded and set it
      result.loaded(true);
      _value(newValue);
    },
    deferEvaluation: true  //do not evaluate immediately when created
  });

  //expose the current state, which can be bound against
  result.loaded = ko.observable();  
  //load it again
  result.refresh = function() {
      result.loaded(false);
  };

  return result;
};

$("#helpcloser").click(function() {
  $("#help").toggle();
});
$("#helper").click(function() {
  $("#help").toggle();
});

function ShowAlert(aclass, message) {

  // Get the alert area
  var area = $("#alert-area");
  // and find any existing alerts
  var existing = area.find("div.alert");
  // run the template
  var source   = $("#alerter").html();
  var template = Handlebars.compile(source);
  var al = $(template({ alert_class: aclass, message: message }));
  al.hide();

  // Stick the append into a function so we can use it later.
  var appender = function() { al.appendTo(area).slideDown(); };

  // If we have any existing alerts, trash 'em
  if(existing.size() > 0) {
    existing.slideUp("fast", function() {
      existing.remove();
      appender();
    });
  // else, just append it.
  } else {
    appender();
  }
}

function processJsonError(resp) {
  var data = JSON.parse(resp);
  if(typeof data !== "undefined") {
    for(var k in data) {
      if(data.hasOwnProperty(k)) {
        console.log("#field-" + k);
        $("#field-" + k).addClass("error");
      }
    }
  }
}

function Event(data) {
  this.projectId      = ko.observable(data.projectId);
  this.projectName    = ko.observable(data.projectName);
  this.userId         = ko.observable(data.userId);
  this.userRealName   = ko.observable(data.userRealname);
  this.username       = ko.observable(data.username);
  this.userEmailDigest= ko.observable(data.userEmailDigest);
  this.eKey           = ko.observable(data.ekey);
  this.eType          = ko.observable(data.etype);
  this.content        = ko.observable(data.content);
  this.url            = ko.observable(data.url);
  this.dateCreated    = ko.observable(data.dateCreated);
  this.iconClass      = ko.computed(function() {
    switch(this.eType()) {
      case 'EVENT_TYPE_TICKET_COMMIT':
        return 'icon-cogs';
      case 'EVENT_TYPE_TICKET_CHANGE':
        return 'icon-edit';
      case 'EVENT_TYPE_TICKET_CREATE':
        return 'icon-certificate';
      default:
        return 'icon-comments';
    }
  }, this);
}

function Facet(data) {
  this.value    = ko.observable(data.value);
  this.valueI18N= ko.observable(data.valueI18N);
  this.count    = ko.observable(data.count);
}

function FacetCollection(data) {
  this.name   = ko.observable(data.name);
  this.nameI18N = ko.observable(data.nameI18N);
  this.facets = ko.observableArray($.map(data.items, function(f) { return new Facet(f); }));
}

function Filter(name, value, valueI18N) {
  this.name = ko.observable(name);
  this.value = ko.observable(value);
  this.valueI18N = ko.observable(i18n.t(value));
}

function GroupUser(data) {
  this.id       = ko.observable(data.id);
  this.userId   = ko.observable(data.userId);
  this.groupId  = ko.observable(data.groupId);
  this.username = ko.observable(data.username);
  this.realName = ko.observable(data.realName);
  this.dateCreated = ko.observable(Date.parseExact(data.dateCreated, "yyyyMMddTHHmmssZ"));
}

function Pager(data, builder) {
  this.count    = ko.observable(data.pager.count);
  this.items    = ko.observableArray($.map(data.pager.items, builder));
  this.offset   = ko.observable(data.pager.offset);
  this.first    = ko.computed(function() {
    return this.offset() + 1;
  }, this);
  this.last     = ko.computed(function() {
    return this.offset() + this.items().length;
  }, this);
  this.page     = ko.observable(data.pager.page);
  this.range    = ko.observableArray(data.pager.range);
  this.requestedPage = ko.observable(data.pager.requestedPage);  
  this.total    = ko.observable(data.pager.total);
  this.window   = ko.observableArray(data.pager.window);
  this.next     = ko.observable(data.pager.next);
  this.noNext  = ko.computed(function() {
    return this.next() === null ? true : false;
  }, this);
  this.prev     = ko.observable(data.pager.prev);
  this.noPrev  = ko.computed(function() {
    return this.prev() === null ? true : false;
  }, this);
  this.facetCollection = ko.observableArray(
    $.map(data.facets,
      function(t) { return new FacetCollection(t); }
    )
  );
}

function Project(data) {
  this.id             = ko.observable(data.id);
  this.workflowId     = ko.observable(data.workflowId);
  this.name           = ko.observable(data.name);
  this.key            = ko.observable(data.key);
  this.ownerId        = ko.observable(data.ownerId);
  this.permissionSchemeId = ko.observable(data.permissionSchemeId);
  this.defaultPriorityId = ko.observable(data.defaultPriorityId);
  this.defaultSeverityId = ko.observable(data.defaultSeverityId);
  this.defaultTypeId  = ko.observable(data.defaultTypeId);
  this.defaultAssignee= ko.observable(data.defaultAssignee);
  this.dateCreated    = ko.observable(Date.parseExact(data.dateCreated, "yyyyMMddTHHmmssZ"));
}

function Ticket(data) {
  this.id           = ko.observable(data.id);
  this.assigneeId   = ko.observable(data.assigneeId);
  this.assigneeName = ko.observable(data.assigneeName);
  this.attentionId   = ko.observable(data.attentionId);
  this.attentionName = ko.observable(data.attentionName);
  this.dataId       = ko.observable(data.dataId);
  this.description  = ko.observable(data.description);
  this.ticketId     = ko.observable(data.ticketId);
  this.projectId    = ko.observable(data.projectId);
  this.projectName  = ko.observable(data.projectName);
  this.priorityId   = ko.observable(data.priorityId);
  this.priorityColor = ko.observable(data.priorityColor);
  this.priorityName = ko.observable(data.priorityName);
  this.priorityNameI18N = ko.observable(data.priorityNameI18N);
  this.resolutionId = ko.observable(data.resolutionId);
  this.resolutionName = ko.observable(data.resolutionName);
  this.resolutionNameI18N = ko.observable(data.resolutionNameI18N);
  this.severityColor = ko.observable(data.severityColor);
  this.severityId   = ko.observable(data.severityId);
  this.severityName = ko.observable(data.severityName);
  this.severityNameI18N = ko.observable(data.severityNameI18N);
  this.statusId     = ko.observable(data.statusId);
  this.statusName   = ko.observable(data.statusName);
  this.statusNameI18N = ko.observable(data.statusNameI18N);
  this.summary      = ko.observable(data.summary);
  this.shortSummary = ko.observable(data.shortSummary);
  this.typeName     = ko.observable(data.typeName);
  this.typeNameI18N = ko.observable(data.typeNameI18N);
  this.typeColor    = ko.observable(data.typeColor);
  this.userId       = ko.observable(data.userId);
  this.userName     = ko.observable(data.userName);
  this.workflowId   = ko.observable(data.workflowId);
  this.workflowStatusId = ko.observable(data.workflowStatusId);
  this.workflowPosition = ko.observable(data.workflowPosition);
  this.dateCreated  = ko.observable(Date.parseExact(data.dateCreated, "yyyyMMddTHHmmssZ"));

  this.url          = ko.computed(function() {
    return "/ticket/" + this.ticketId();
  }, this);
}

function TicketComment(data) {
  this.id = ko.observable(data.id);
  this.ctype = ko.observable(data.ctype);
  this.userId = ko.observable(data.userId);
  this.ticketId = ko.observable(data.ticketId);
  this.content = ko.observable(data.content);
  this.dateCreated = ko.observable(Date.parseExact(data.dateCreated, "yyyyMMddTHHmmssZ"));
  this.userName = ko.observable(data.userName);
  this.userRealName = ko.observable(data.userRealName);
  this.userEmailDigest = ko.observable(data.userEmailDigest);
}

function TicketLink(data) {
  this.id = ko.observable(data.id);
  this.typeId = ko.observable(data.typeId);
  this.typeName = ko.observable(data.typeName);
  this.typeNameI18N = ko.observable(data.typeNameI18N);
  this.parentId = ko.observable(data.parentId);
  this.parentTicketId = ko.observable(data.parentTicketId);
  this.parentResolutionId = ko.observable(data.parentResolutionId);
  this.parentSummary = ko.observable(data.parentSummary);
  this.childId = ko.observable(data.childId);
  this.childTicketId = ko.observable(data.childTicketId);
  this.childResolutionId = ko.observable(data.childResolutionId);
  this.childSummary = ko.observable(data.childSummary);
  this.dateCreated = ko.observable(Date.parseExact(data.dateCreated, "yyyyMMddTHHmmssZ"));
}

function TicketLinkType(data) {
  this.id = ko.observable(data.id);
  this.name = ko.observable(data.name);
  this.nameI18N = ko.observable(data.nameI18N);
  this.invertable = ko.observable(data.invertable);
  this.dateCreated = ko.observable(Date.parseExact(data.dateCreated, "yyyyMMddTHHmmssZ"));
}

function TicketPriority(data) {
  this.id = ko.observable(data.id);
  this.name = ko.observable(data.name);
  this.nameI18N = ko.observable(data.nameI18N);
  this.color = ko.observable(data.color);
  this.position = ko.observable(data.position);
  this.dateCreated = ko.observable(Date.parseExact(data.dateCreated, "yyyyMMddTHHmmssZ"));
}

function TicketResolution(data) {
  this.id = ko.observable(data.id);
  this.name = ko.observable(data.name);
  this.nameI18N = ko.observable(data.nameI18N);
  this.dateCreated = ko.observable(Date.parseExact(data.dateCreated, "yyyyMMddTHHmmssZ"));
}

function TicketStatus(data) {
  this.id = ko.observable(data.id);
  this.name = ko.observable(data.name);
  this.nameI18N = ko.observable(data.nameI18N);
  this.position = ko.observable(data.position);
  this.statusId = ko.observable(data.statusId);
  this.workflowId = ko.observable(Date.parseExact(data.dateCreated, "yyyyMMddTHHmmssZ"));
}

function TicketType(data) {
  this.id = ko.observable(data.id);
  this.name = ko.observable(data.name);
  this.nameI18N = ko.observable(data.nameI18N);
  this.color = ko.observable(data.color);
  this.dateCreated = ko.observable(Date.parseExact(data.dateCreated, "yyyyMMddTHHmmssZ"));
}

function User(data) {
  this.id = ko.observable(data.id);
  this.username = ko.observable(data.username);
  this.password = ko.observable(data.password);
  this.realName = ko.observable(data.realName);
  this.realNameI18N = ko.observable(data.realNameI18N);
  this.email = ko.observable(data.email);
  this.timezone = ko.observable(data.timezone);
  this.location = ko.observable(data.location);
  this.title = ko.observable(data.title);
  this.url = ko.observable(data.url);
  this.dateCreated = ko.observable(Date.parseExact(data.dateCreated, "yyyyMMddTHHmmssZ"));
}

function UserToken(data) {
  this.token = ko.observable(data.token);
  this.userId = ko.observable(data.userId);
  this.comment = ko.observable(data.comment);
  this.dateCreated = ko.observable(Date.parseExact(data.dateCreated, "yyyyMMddTHHmmssZ"));
}


function GroupViewModel(groupId) {
  var self = this;
  self.users = ko.observableArray([]);

  self.addUser = function() {
    var username = $("#userInput").val();
    $.ajax({
      type: "PUT",
      url: "/api/group/" + groupId + "/" + username
    })
      .done(function(data) {
        self.users.push(new GroupUser(data));
        $("#userInput").val("");
      })
      .fail(function() { ShowAlert("alert-error", "XXX Failed to add user!"); });
  };

  self.removeUser = function(data) {
    $.ajax({
      type: "DELETE",
      url: "/api/group/" + groupId + "/" + data.id()
    })
      .done(function() {
        self.users.remove(data);
      })
      .fail(function() { ShowALert("alert-error", "XXX Failed to remove user!"); });
  };

  $.getJSON("/api/group/" + groupId + "/users")
    .done(function(data) {
      var mappedGUs = $.map(data, function(item) { return new GroupUser(item); });
      self.users(mappedGUs);
    })
    .fail(function() { ShowAlert("alert-error", "XXX Failed to retrieve group users!"); });
}

function BoardViewModel(project, statuses) {
  var self = this;
  self.empty    = ko.observable(true);
  self.url      = ko.observable(URI("/api/search").addSearch("project", project).addSearch("resolution", "TICK_RESO_UNRESOLVED").addSearch("count", 1000));
  self.pager    = ko.observable({ items: ko.observableArray([]), total: 0 });
  self.filters  = ko.observableArray([]);
  self.columns  = {};
  self.dragger  = ko.observable();
  self.intendedMover = ko.observable();
  self.intendedStatus = ko.observable({});
  self.statusComment = ko.observable("");
  self.showHelp = ko.observable(false);
  jQuery.each(statuses, function(index, s) { self.columns[s.name] = ko.observableArray([]); });

  function doSearch(url) {
    $.getJSON(url.toString())
     .done(function(data) {
        $.each(self.columns, function(k, v) {
          self.columns[k].removeAll();
        });
        self.pager(new Pager(data, function(item) { return new Ticket(item); }));
        if(self.pager().total() > 0) {
          self.empty(false);
        }
        $.each(self.pager().items(), function(i, tick) {
          self.columns[tick.statusName()].push(tick);
        });
     });
  }

  self.clearAll = function() {
    self.intendedMover(undefined);
    self.intendedStatus({});
    self.statusComment("");
  };

  self.doMove = function() {
    $.ajax({
      type: "POST",
      url: URI().segment(["api", "ticket", self.intendedMover().ticketId(), "status"]).toString(),
      contentType: "application/json; charset=utf-8",
      data: JSON.stringify({
        "statusId":  parseInt(self.intendedStatus().id, 10),
        "comment": self.statusComment()
      })
    })
      .success(function() {
        var mt = self.intendedMover();
        // Remove the mover from the old column
        self.columns[self.intendedMover().statusName()].remove(function(t) {
          return t.ticketId() == mt.ticketId();
        });
        // Set the id & name of the status so that future moves don't fail
        mt.statusId(self.intendedStatus().id);
        mt.statusName(self.intendedStatus().name);
        // Add it to the new one
        self.columns[self.intendedStatus().name].push(mt);
      })
      .error(function(e) {
        ShowAlert("alert-error", "XXX Failed to change status");
      })
      .complete(function() {
        self.clearAll();
      });
  };

  self.drop = function(data, event) {
    event.preventDefault();
    var target = $(event.target);
    // In case they dropped on an li or something.
    if(!target.is("ul")) {
      target = target.closest("ul");
    }

    // Clean up all over classes since we're done now.
    $(".column ul").removeClass("over");
    
    var sid = target.attr("data-status-id");

    // Set the intended, and reset the dragger
    var tick = self.dragger();
    self.dragger(undefined);
    
    if(tick.statusId() == sid) {
      // Dropped on the existing status, no change needed, ABORT
      return;
    }

    // This is a real change, set stuff up
    self.intendedMover(tick);
    // Set the intended status
    var match = $.grep(statuses, function(status, i) { return status.id == sid; });
    self.intendedStatus(match[0]);
    
    return true;
  };

  self.dragStart = function(data, event) {
    // Make this the dragger
    self.dragger(data);
    $(event.target).addClass("moving");
    event.originalEvent.dataTransfer.dropEffect = 'move';
    return true;
  };

  self.dragEnd = function(data, event) {
    $(event.target).removeClass("moving");
  };

  self.dragOver = function(data, event) {
    // This must exist for the d&d to work
    event.originalEvent.dataTransfer.dropEffect = 'move';
    event.preventDefault();
  };

  self.unhighlight = function(data, event) {
    event.preventDefault();
    if($(event.target).is("ul")) {
      $(event.target).removeClass("over");  
    }
  };

  self.highlight = function(data, event) {
    event.preventDefault();
    if($(event.target).is("ul")) {
      $(event.target).addClass("over");
    }
  };

  // Add a filter from the search URL
  self.addFilter = function(facet, parent) {
    self.filters.push(new Filter(parent.name(), facet.value(), facet.valueI18N()));
  };

  // Remove a filter from the search URL
  self.removeFilter = function(filter) {
    self.filters.remove(filter);
  };

  self.filters.subscribe(function(newvalue) {
    var url = self.url().clone();
    // Add any filters we have
    $.each(self.filters(), function(i, f) { url.addSearch(f.name(), f.value()); });
    doSearch(url.toString());
  });

  doSearch(self.url());
}

function SearchViewModel() {
  var self = this;

  self.query    = ko.observable("*");
  self.count    = ko.observable(10);
  self.filters  = ko.observableArray([]);
  self.url      = ko.observable();
  self.sort     = ko.observable("priority");
  self.order    = ko.observable("desc");
  self.page     = ko.observable("1");
  self.pager    = ko.observable({
    first: ko.observable(0),
    items: ko.observableArray([]),
    last: ko.observable(0),
    range: ko.observableArray([]),
    total: ko.observable(0)
  });
  self.url      = ko.computed(function() {

    var u = URI("/api/search")
      .addSearch("count", self.count())
      .addSearch("page", self.page())
      .addSearch("query", self.query())
      .addSearch("sort", self.sort())
      .addSearch("order", self.order());
    $.each(self.filters(), function(i, f) { u.addSearch(f.name(), f.value()); });
    return u;
  }, this);

  // Set our current state from the URL provided
  self.deriveURL = function(url) {
    var currURL = URI(url);
    var currSearch = currURL.search(true);

    if("count" in currSearch) {
      self.count(currSearch.count);
    }
    if("page" in currSearch) {
      self.page(currSearch.page);
    }
    if("query" in currSearch) {
      self.query(currSearch.query);
    }
    if("sort" in currSearch) {
      self.sort(currSearch.sort);
    }
    if("order" in currSearch) {
      self.order(currSearch.order);
    }

    var filters = [ "assignee", "project", "priority","resolution", "severity", "status", "type" ];

    self.filters([]);
    $.each(filters, function(i, f) {
      if(f in currSearch) {
        self.filters.push(new Filter(f, currSearch[f], currSearch[f]));
      }
    });
  };

  function doSearch(shouldUpdateHistory) {
    if(shouldUpdateHistory) {
      var newURL = URI(document.URL);
      newURL.search("?"); // Clean out the search completely
      newURL.removeSearch("count").addSearch("count", self.count());
      newURL.removeSearch("page").addSearch("page", self.page());
      newURL.removeSearch("order").addSearch("order", self.order());
      newURL.removeSearch("sort").addSearch("sort", self.sort());
      $.each(self.filters(), function(i, f) { newURL.removeSearch(f.name()).addSearch(f.name(), f.value()); });
      window.history.pushState({}, "", newURL.resource());
    }
    $.getJSON(self.url().toString())
     .done(function(data) {
        self.pager(new Pager(data, function(item) { return new Ticket(item); }));
     });
  }

  self.changePage = function(page) {
    self.page(page);
  };

  self.changeSort = function(thing) {
    if(self.sort() == thing) {
      // Switch the order if this isn't a change
      self.order(self.order() == "desc" ? "asc" : "desc");
    } else {
      // Change the sort.
      self.sort(thing);
    }
  };

  // Add a filter from the search URL
  self.addFilter = function(facet, parent) {
    self.filters.push(new Filter(parent.name(), facet.value(), facet.valueI18N()));
  };

  // Remove a filter from the search URL
  self.removeFilter = function(filter) {
    self.filters.remove(filter);
  };

  self.deriveURL(document.URL);
  doSearch(false);

  // Subscribe after we've set everything up. Subsequent changes to any part
  // of the URL will redo the search.
  self.url.subscribe(function(newvalue) {
    doSearch(true);
  });

  window.onpopstate = function(event) {
    if(event.state !== null) {
      // Only re-up the search if we have some sort of non-null state, since that's
      // what we're passing when we pushState.
      self.deriveURL(document.location);
    }
  };
}

function TimelineViewModel() {
  var self = this;

  self.filters  = ko.observableArray([]);
  self.page       = ko.observable("1");
  self.events     = ko.observable({
    first: ko.observable(0),
    items: ko.observableArray([]),
    last: ko.observable(0),
    range: ko.observableArray([]),
    total: ko.observable(0)
  });
  self.eventURL   = ko.computed(function() {

    var u = URI("/api/timeline")
      .addSearch("page", self.page());
    $.each(self.filters(), function(i, f) { u.addSearch(f.name(), f.value()); });
    return u;

  }, this);

  // Add a filter from the search URL
  self.addFilter = function(facet, parent) {
    self.filters.push(new Filter(parent.name(), facet.value(), facet.valueI18N()));
  };

  // Remove a filter from the search URL
  self.removeFilter = function(filter) {
    self.filters.remove(filter);
  };

  function doTimeline() {
    $.getJSON(self.eventURL().toString())
      .done(function(data) {
        self.events(new Pager(data, function(item) { return new Event(item); }));
      })
      .fail(function() {
        ShowAlert("alert-error", "XXX Failed to find events");
      });
  }

  self.changePage = function(page) {
    self.page(page);
  };

  doTimeline();

  self.eventURL.subscribe(function(newvalue) {
    doTimeline();
  });
}

function ProjectViewModel(project) {
  var self = this;

  self.page       = ko.observable("1");
  self.project    = ko.observable(new Project(project));
  self.events     = ko.observable({ total: ko.observable(0) });
  self.milestones = ko.observableArray([]);
  self.eventURL   = ko.computed(function() {

    return URI("/api/timeline")
      .addSearch("project", self.project().name())
      .addSearch("page", self.page());
  }, this);


  $.getJSON(URI().segment(['api', 'search']).addSearch("project", self.project().name()).addSearch("resolution", "TICK_RESO_UNRESOLVED").addSearch("type", "TICK_TYPE_MILESTONE").toString())
     .done(function(data) {
        self.milestones(new Pager(data, function(item) { return new Ticket(item); }));
     })
     .fail(function() {
      ShowAlert("alert-error", "XXX Failed to find milestones");
     });

  function doTimeline() {
    $.getJSON(self.eventURL().toString())
       .done(function(data) {
          self.events(new Pager(data, function(item) { return new Event(item); }));
       })
       .fail(function() {
        ShowAlert("alert-error", "XXX Failed to find events");
       });
  }

  self.changePage = function(page) {
    self.page(page);
  };

  doTimeline();

  self.eventURL.subscribe(function(newvalue) {
    doTimeline();
  });
}

function TicketViewModel(ticket) {
  var currURL = URI(document.URL);

  var self = this;

  self.getAssignees = function() {
    console.log("Lazily loading assignees");
    $.getJSON(URI().segment(['api', 'project', self.ticket().projectId(), 'assignees']).toString())
      .done(function(data) {
        self.assignees($.map(data, function(item) { return new User(item); }));
      })
      .fail(function() {
        ShowAlert("alert-error", "XXX Failed to load assignees");
      });
  };
  
  self.getComments = function() {
    $.getJSON(URI().segment(['api', 'ticket', self.ticket().ticketId(), 'comment']).addSearch("type", "comment").toString())
      .done(function(data) {
        self.comments($.map(data.pager.items, function(item) { return new TicketComment(item); }));
      })
      .fail(function() {
        ShowAlert("alert-error", "XXX Failed to load ticket comments");
      });
  };

  self.getCommits = function() {
    $.getJSON(URI().segment(['api', 'ticket', self.ticket().ticketId(), 'comment']).addSearch("type", "commit").toString())
      .done(function(data) {
        self.commits($.map(data.pager.items, function(item) { return new TicketComment(item); }));
      })
      .fail(function() {
        ShowAlert("alert-error", "XXX Failed to load ticket commits");
      });
  };

  self.getResolutions = function() {
    console.log("Lazily loading resolutions");
    $.getJSON(URI().segment(['api', 'ticketresolution']).toString())
      .done(function(data) {
        self.resolutions($.map(data, function(item) { return new TicketResolution(item); }));
      })
      .fail(function() { ShowAlert("alert-error", "XXX Failed to load ticket resolutions"); });
  };

  self.getTicketLinkTypes = function() {
    console.log("Lazily loading link types");
    $.getJSON(URI().segment(['api', 'ticketlinktype']).toString())
      .done(function(data) {
        self.linkTypes($.map(data, function(item) { return new TicketLinkType(item); }));
      })
      .fail(function() { ShowAlert("alert-error", "XXX Failed to load ticket link types"); });
  };

  self.getLinks = function() {
    $.getJSON(URI().segment(['api', 'ticket', self.ticket().ticketId(), 'link']).toString())
      .done(function(data) {
        var mappedLinks = $.map(data, function(item) { return new TicketLink(item); });
        self.links(mappedLinks);
      })
      .fail(function() { ShowAlert("alert-error", "XXX Failed to load ticket links"); });
  };

  self.action = ko.observable(undefined);
  self.assignees = ko.onDemandObservable(self.getAssignees, self);
  self.comment = ko.observable();
  self.comments = ko.onDemandObservable(self.getComments, self);
  self.commits = ko.onDemandObservable(self.getCommits, self);
  self.intendedAssignee = ko.observable();
  self.intendedLinkTickets = ko.observableArray([]);
  self.intendedResolution = ko.observable();
  self.intendedStatus = ko.observable();
  self.links = ko.observableArray([]);
  self.linkTickets = ko.observableArray([]);
  self.resolutions = ko.onDemandObservable(self.getResolutions, self);
  self.actionComment = ko.observable("");
  self.statuses = ko.observableArray([]);
  self.tab = ko.observable("comments");
  self.ticket = ko.observable(new Ticket(ticket));
  // Use a throttle to prevent searches immediately, make the user pause for 200ms
  self.instantLinkSearch = ko.observable("");
  self.linkSearch = ko.computed(this.instantLinkSearch).extend({ throttle: 200 });
  self.linkTypeId = ko.observable();
  self.linkTypes = ko.onDemandObservable(self.getTicketLinkTypes, self);

  $.getJSON(URI().segment(['api', 'workflow', self.ticket().workflowId() , 'statuses']).toString())
    .done(function(data) {
      var mappedStatuses = $.map(data, function(item) { return new TicketStatus(item); });
      self.statuses(mappedStatuses);
    })
    .fail(function() { ShowAlert("alert-error", "XXX Failed to load ticket workflow"); });

  self.getLinks();

  self.linkSearch.subscribe(function(newvalue) {
    if(newvalue) {
      doLinkSearch(newvalue);
    }
  });

  self.changeTab = function(tab) {
    if(self.tab() != tab) {
      self.tab(tab);
      window.history.pushState({}, "", currURL.fragment(tab).resource());
    }
  };

  self.clearAll = function() {
    self.action(undefined);
    self.actionComment("");
    self.intendedStatus(undefined);
    self.linkSearch("");
    self.linkTickets([]);
    self.intendedLinkTickets([]);
    self.linkTypeId(undefined);
  };

  self.doAssign = function(data) {
    $.ajax({
      type: "POST",
      url: URI().segment(["api", "ticket", self.ticket().ticketId(), "assign"]).toString(),
      contentType: "application/json; charset=utf-8",
      data: JSON.stringify({
        "userId":  self.intendedAssignee(),
        "comment": self.actionComment()
      })
    })
      .success(function(ticket) {
        self.ticket(new Ticket(ticket));
      })
      .error(function(e) {
        ShowAlert("alert-error", "XXX Failed to change status") ;
      });
    self.clearAll();
  };

  self.doChangeStatus = function(data) {
    $.ajax({
      type: "POST",
      url: URI().segment(["api", "ticket", self.ticket().ticketId(), "status"]).toString(),
      contentType: "application/json; charset=utf-8",
      data: JSON.stringify({
        "statusId":  self.intendedStatus().id(),
        "comment": self.actionComment()
      })
    })
      .success(function(ticket) {
        self.ticket(new Ticket(ticket));
      })
      .error(function(e) {
        ShowAlert("alert-error", "XXX Failed to change status");
      });
    self.clearAll();
  };

  self.doComment = function() {
    $.ajax({
      type: "PUT",
      url: URI().segment(["api", "ticket", self.ticket().ticketId(), "comment"]).toString(),
      contentType: "application/json; charset=utf-8",
      data: JSON.stringify({
        content: self.comment()
      })
    })
      .success(function(data) {
        self.comments(self.getComments());
        self.comment(undefined);
      })
      .error(function(e) {
        ShowAlert("alert-error", "XXX Failed to add comment");
      });
  };

  self.doLink = function() {
    $.each(self.intendedLinkTickets(), function(i, lt) {
      $.ajax({
        type: "PUT",
        url: URI().segment(["api", "ticket", self.ticket().ticketId(), "link"]).toString(),
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
          "linkTypeId": self.linkTypeId(),
          childTicketId: lt.ticketId()
        })
      })
        .error(function(e) {
          ShowAlert("alert-error", "XXX Failed to link tickets");
        });
    });
    self.clearAll();
    self.getLinks();
  };

  self.doLinkSearch = function(query) {
    $.getJSON(URI().segment(["api","search"]).addSearch("query", query).toString())
      .done(function(data) {
        var valid = $.grep(data.pager.items, function(item) { return item.ticketId != self.ticket().ticketId(); });
        var mappedTicks = $.map(valid, function(item) { return new Ticket(item); });
        self.linkTickets(mappedTicks);
      })
      .fail(function() { ShowAlert("alert-error", "XXX Failed to search for tickets to link to");});
  };

  self.doResolve = function() {
    $.ajax({
      type: "POST",
      url: URI().segment(["api", "ticket", self.ticket().ticketId(), "resolve"]).toString(),
      contentType: "application/json; charset=utf-8",
      data: JSON.stringify({
        "resolutionId":  self.intendedResolution(),
        "comment": self.actionComment()
      })
    })
      .success(function(ticket) {
        self.ticket(new Ticket(ticket));
      })
      .error(function(e) {
        ShowAlert("alert-error", "XXX Failed to resolve") ;
      });
    self.clearAll();
  };

  self.doUnResolve = function() {
    $.ajax({
      type: "POST",
      url: URI().segment(["api", "ticket", self.ticket().ticketId(), "unresolve"]).toString(),
      contentType: "application/json; charset=utf-8",
      data: JSON.stringify({
        "comment": self.actionComment()
      })
    })
      .success(function(ticket) {
        self.ticket(new Ticket(ticket));
      })
      .error(function(e) {
        ShowAlert("alert-error", "XXX Failed to unresolve");
      });
    self.clearAll();
  };

  self.pickStatus = function(status) {
    // Don't show the drawer if this is not a change.
    if(status.statusId() != self.ticket().statusId()) {
      self.action('status');
      self.intendedStatus(status);
    }
  };

  self.removeLink = function(data) {
    $.ajax({
      type: "DELETE",
      url: URI().segment(["api", "ticket", self.ticket().ticketId(), "link", data.id()]).toString()
    })
    .done(self.links.remove(data))
    .fail(function() { ShowAlert("alert-error", "XXX Failed to delete link!"); });
  };

  self.tab(currURL.fragment() || "comments");
}

function TicketAddViewModel(user, projects, selectedProject, assignees, ttypes, priorities, severities) {
  var self = this;
  self.user = ko.observable(user);

  self.projects = ko.observableArray($.map(projects, function(item) { return new Project(item); }));
  self.currentProject = ko.observable(new Project(selectedProject));
  self.summary = "";
  self.description = "";
  self.chosenProject = ko.observable(selectedProject.id);
  self.reporters = ko.observableArray(assignees);
  self.chosenReporter = ko.observable(user.id);
  self.assignees = ko.observableArray(assignees);
  self.chosenAssignee = ko.observable(null);
  self.ttypes = ko.observableArray(ttypes);
  self.chosenType = ko.observable(-1);
  self.priorities = ko.observableArray(priorities);
  self.chosenPriority = ko.observable(-1);
  self.severities = ko.observableArray(severities);
  self.chosenSeverity = ko.observable(-1);

  this.chosenProject.subscribe(function(data) {
    self.changeProject(data);
  });

  self.changeProject = function(data) {

    // Don't do anything unless we got a selection, as they could choose
    // the undefined caption
    if(typeof data !== "undefined") {
      self.currentProject(
        ko.utils.arrayFirst(self.projects(), function(item) {
          return item.id() === data;
        })
      );

      $.getJSON("/api/project/" + self.currentProject().id() + "/assignees")
        .done(function(data) {
          self.assignees(data);
        })
        .fail(function(e) { ShowAlert("alert-error", "XXX Failed to fetch assignees!"); });

      if(self.currentProject().defaultAssignee() == 1) {
        self.chosenAssignee(self.currentProject().ownerId());
      }
      self.chosenPriority(self.currentProject().defaultPriorityId());
      self.chosenSeverity(self.currentProject().defaultSeverityId());
      self.chosenType(self.currentProject().defaultTypeId);
    }
  };

  self.hasProject = function() {
    if(typeof this.chosenProject() !== "undefined") {
      return true;
    } else {
      return false;
    }
  };

  self.doSubmit = function(data) {
    $.ajax({
      type: "PUT",
      url: "/api/project/" + self.chosenProject() + "/ticket",
      contentType: "application/json; charset=utf-8",
      data: JSON.stringify({
        "reporterId": self.chosenReporter(),
        "assigneeId": self.chosenAssignee(),
        "projectId": self.chosenProject(),
        "priorityId": self.chosenPriority(),
        "severityId": self.chosenSeverity(),
        "typeId": self.chosenType(),
        "summary": self.summary,
        "description": self.description
      })
    })
      .success(function(ticket) {
        window.location = "/ticket/" + ticket.ticketId;
      })
      .error(function(e) {
        processJsonError(e.responseText);
      });
  };

  // Set the current information
  if(self.hasProject) {
    if(self.currentProject().defaultAssignee() == 1) {
      self.chosenAssignee(self.currentProject().ownerId());
    }
    self.chosenPriority(self.currentProject().defaultPriorityId());
    self.chosenSeverity(self.currentProject().defaultSeverityId());
    self.chosenType(self.currentProject().defaultTypeId());
  }
}

function UserEditViewModel(userId) {
  var self = this;
  self.tokens = ko.observableArray([]);

  function showTokens() {
    $.getJSON("/api/user/tokens/" + userId)
      .done(function(data) {
        var mappedTokens = $.map(data, function(item) { return new UserToken(item); });
        self.tokens(mappedTokens);
      })
      .fail(function() { ShowAlert("alert-error", "XXX Failed to retrieve tokens!"); });
  }

  self.removeToken = function(data) {
    var sure = confirm("Are you sure you want to remove this token?");
    if(sure === true) {
      $.ajax({
        type: "DELETE",
        url: "/api/user/token/" + data.token()
      })
      .done(self.tokens.remove(data))
      .fail(function() { ShowAlert("alert-error", "XXX Failed to delete token!"); });
    }
  };

  showTokens();
}