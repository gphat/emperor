# API

## Authentication

When using the API you may authenticate in one of two ways:

* Using the session cookies sent when you authenticate in the user's browser.
This is appropriate for JavaScript API use within Emperor.
* Using the `Authorization` header with a value of `Token token=XXX` where XXX
is a user's token as created within Emperor by the user.
* With the query parameter `authtoken` that has a value of a user's token as
created within Emperor by the user.

## Format

All data formats are JSON unless otherwise noted.

## JSONP

All API endpoints support JSONP.

## Errors

All methods will return errors in the form of:

```
{
  "error": "some.error.message"
}
```

unless otherwise noted. An appropriate HTTP status code will also be
used.

## Group

### Retrieve a group by id

`GET /api/group/:id`

Returns the group with the specified id.

#### Error

Returns a 404 and error message on failure.

### Get a list of all groups

`GET /api/group`

Returns a list of all groups.

### Find all groups that start with a string

`GET /api/group/startsWith?q=XXX`

Returns a list of groups that start with the string supplied in `q`.

### Get a list of all users in a group

`GET /api/group/:id/users

Returns a list of all users in the group with the specified id.

### Add a user to a group

`PUT /api/group/:id/:username`

Adds the user with the specified username to the group with the specified id.
Returns the GroupUser object on success.

### Remove a user from a group

`DELETE /api/group/:id/:username`