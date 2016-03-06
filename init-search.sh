curl -XPUT 'http://localhost:9200/events_0' -d '{
    "settings" : {
        "number_of_shards" : 5,
        "number_of_replicas" : 0
    }
}'
curl -XPUT 'http://localhost:9200/tickets_0' -d '{
    "settings" : {
        "number_of_shards" : 5,
        "number_of_replicas" : 0
    }
}'
curl -XPUT 'http://localhost:9200/ticket_comments_0' -d '{
    "settings" : {
        "number_of_shards" : 5,
        "number_of_replicas" : 0
    }
}'

curl -XPOST 'http://localhost:9200/_aliases' -d '
{
    "actions" : [
        { "add" : { "index" : "events_0", "alias" : "events-read" } },
        { "add" : { "index" : "events_0", "alias" : "events-write" } },
        { "add" : { "index" : "tickets_0", "alias" : "tickets-read" } },
        { "add" : { "index" : "tickets_0", "alias" : "tickets-write" } },
        { "add" : { "index" : "ticket_comments_0", "alias" : "ticket_comments-read" } },
        { "add" : { "index" : "ticket_comments_0", "alias" : "ticket_comments-write" } }
    ]
}'
