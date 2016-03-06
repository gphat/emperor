name := """emperor"""

version := "3.0.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala, BuildInfoPlugin)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  evolutions,
  cache,
  ws,
  specs2 % Test,
  "org.specs2"    %% "specs2"                 % "2.4.15"           % "test",
  "org.mindrot"   % "jbcrypt"                 % "0.3m",
  "javax.mail"    % "mail"                    % "1.4.1",
  "org.apache.commons" % "commons-email"      % "1.2",
  "joda-time"     % "joda-time"               % "2.9.2",
  "wabisabi"      %% "wabisabi"               % "2.1.4",
  "org.pegdown"   % "pegdown"                 % "1.6.0",
  "org.postgresql"% "postgresql"              % "9.4.1208.jre7",
  "com.typesafe.play" %% "anorm"              % "2.4.0",
  "com.adrianhurt"%% "play-bootstrap"         % "1.0-P24-B3-SNAPSHOT"
)

resolvers += "gphat" at "https://raw.github.com/gphat/mvn-repo/master/releases/"

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

routesGenerator := InjectedRoutesGenerator

// buildInfoSettings
//
// sourceGenerators in Compile <+= buildInfo

// lazy val root = (project in file(".")).
//   enablePlugins(BuildInfoPlugin).
//   settings(
//     buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
//     buildInfoPackage := "hello"
//   )

buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion)

buildInfoPackage := "emp"
