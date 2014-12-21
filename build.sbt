name := """emperor"""

version := "2.0.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws,
  "org.specs2"    %% "specs2"                 % "2.4.15"           % "test",
  "org.mindrot"   % "jbcrypt"                 % "0.3m",
  "javax.mail"    % "mail"                    % "1.4.1",
  "org.apache.commons" % "commons-email"      % "1.2",
  "joda-time"     % "joda-time"               % "2.6",
  "wabisabi"      %% "wabisabi"               % "2.0.11",
  "org.pegdown"   % "pegdown"                 % "1.4.2",
  "org.postgresql"% "postgresql"              % "9.3-1102-jdbc41",
  "com.adrianhurt"%% "play-bootstrap3"        % "0.3"
)

resolvers += "gphat" at "https://raw.github.com/gphat/mvn-repo/master/releases/"

buildInfoSettings

sourceGenerators in Compile <+= buildInfo

buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion)

buildInfoPackage := "emp"
