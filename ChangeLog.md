## 0.0.7
 * Add a project owner field (EMP-16)
 * Add project assignee strategies: unassigned or project owner
 * Show unresolved tickets on project page
 * Add JSON serialization for Ticket Priority
 * Add edit button to projects (EMP-17)
 * Add YUI model for Project
 * Remove old, unused templates
 * Add project-level defaults for various ticket fields (EMP-12)
 * Default to "current" project when creating a ticket from various places (EMP-5)
 * Change link remove icon to an x (EMP-21)
 * Revamp link display to be more awesome (EMP-14)
 * Increase size of textareas in ticket modals (EMP-20)
 * Update play version to 2.0.3
 * Update elasticsearch version to 0.19.9
 * Show (elided, if necessary) summary in link header (EMP-13)
 * Add (bad) comment UI. (EMP-19)

## 0.0.6
 * There is now an edit button on the ticket view page. (EMP-2)
 * A ticket's resolution status is now clearly shown on the ticket view page (EMP-3)
 * Reporter now defaults to the logged in user when creating a ticket (EMP-4)
 * Resolution status (via strikethrough) and summary are now shown in links (EMP-6)
 * Ticket creation now shows up in the timeline without a reindex (EMP-7)
 * Project is now listed as the first item in ticket creation and editing (EMP-8)
 * Revamp search results page to show more information (EMP-9)
 * Ticket links are now styled
 * Ticket links can now be removed (and have an API call)
 * Add more API docs (but they are still bad)
 * Change color of search filter buttons

## 0.0.5.1
 * Fix JS error in linking button

## 0.0.5
 * Start of API
  * Getting a project
  * Getting a ticket
  * Linking two tickets
  * Setting the link ticket
  * Removing the link ticket
 * Revamped JS for linking and ticket workflow
 * Better link UI

## 0.0.4
 * Events
 * Ticket Linking
 * Ticket Resolution & Unresolution with comments
  * Full unit tests
 * Ticket advance & revert dialog w/refreshing
 * Case class docs
 * Timeline
