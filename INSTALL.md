# Installation

## Note

These instructions are suitable for developers, not for a permanent installation.

## Install a JDK

JDK 6 is required.  7 is used for development, but not required.

## Install Play framework

[Here are instructions.](http://www.playframework.com/documentation/2.1.1/Installing)

## Install PostgreSQL

[However is best for your system.](http://www.postgresql.org/download/)

I recommend [Postgres.app](http://postgresapp.com/) for Macs, cuz it's easy!

## Download ElasticSearch

[However is best for your system.](http://www.elasticsearch.org/download/)

## Create A Database User & Database

Create a user called `emperor`:

  CREATE USER emperor;

Create a database called `emperor`.

  CREATE DATABASE emperor OWNER emperor ENCODING 'utf8';

Here are some configuration options you may want to define:

* emperor.mail.smtp.server
* emperor.mail.smtp.from.address
* emperor.mail.smtp.from.name
* emperor.mail.smtp.tls (true or false)
* emperor.mail.smtp.username
* emperor.mail.smtp.password

You can enter these configurations in `conf/application-local.conf` and it
will be automatically included.

## Start ElasticSearch

If you merely downloaded ElasticSearch unzip it and run:

  bin/elasticsearch -f

If you installed some manner of package, you'll have to figure out how to run
it based on the package's instructions.

## Reindex

Request /admin/reindex *twice*. Gotta do it twice to get the aliases set up correctly.

## Start the Application

  cd emperor
  play
  run (after play prompt comes up)

## Setup Emperor

  visit [http://127.0.0.1:9000](http://127.0.0.1:9000)
  Click "apply" when prompted to populate your database

## Log In

Login as the user 'admin' with the password 'test'.
