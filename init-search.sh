curl -XPUT 'http://localhost:9200/events_13'
curl -XPUT 'http://localhost:9200/tickets_13'
curl -XPUT 'http://localhost:9200/ticket_comments_13'

curl -XPOST 'http://localhost:9200/_aliases' -d '
{
    "actions" : [
        { "add" : { "index" : "events_13", "alias" : "events-read" } },
        { "add" : { "index" : "events_13", "alias" : "events-write" } },
        { "add" : { "index" : "tickets_13", "alias" : "tickets-read" } },
        { "add" : { "index" : "tickets_13", "alias" : "tickets-write" } },
        { "add" : { "index" : "ticket_comments_13", "alias" : "ticket_comments-read" } },
        { "add" : { "index" : "ticket_comments_13", "alias" : "ticket_comments-write" } }
    ]
}'
