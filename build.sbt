name := """emperor"""

version := "1.10.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws,
  "org.specs2"    %% "specs2"                 % "2.3.12"           % "test",
  "org.mindrot"   % "jbcrypt"                 % "0.3m",
  "javax.mail"    % "mail"                    % "1.4.1",
  "org.apache.commons" % "commons-email"      % "1.2",
  "joda-time"     % "joda-time"               % "2.3",
  "wabisabi"      %% "wabisabi"               % "2.0.10",
  "org.pegdown"   % "pegdown"                 % "1.4.2",
  "org.postgresql"% "postgresql"              % "9.3-1100-jdbc41"
)

resolvers += "gphat" at "https://raw.github.com/gphat/mvn-repo/master/releases/"

buildInfoSettings

sourceGenerators in Compile <+= buildInfo

buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion)

buildInfoPackage := "emp"
