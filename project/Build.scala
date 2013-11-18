import sbt._
import Keys._
import play.Project._
import sbtbuildinfo.Plugin._

object ApplicationBuild extends Build {

  val appName         = "emperor"
  val appVersion      = "1.10.0"

  val appDependencies = Seq(
    jdbc,
    cache,
    anorm,
    "org.specs2"    %% "specs2"                 % "2.2.2"           % "test",
    "org.mindrot"   % "jbcrypt"                 % "0.3m",
    "javax.mail"    % "mail"                    % "1.4.1",
    "org.apache.commons" % "commons-email"      % "1.2",
    "joda-time"     % "joda-time"               % "2.3",
    "wabisabi"      %% "wabisabi"               % "2.0.8",
    "org.pegdown"   % "pegdown"                 % "1.4.1"
  )

  scalacOptions ++= Seq(
    "-unchecked", "-deprecation", "-feature", "-encoding", "UTF-8", "-target:jvm-1.6",
    "-Ywarn-adapted-args", "-Ywarn-value-discard", "-Xlint"
  )

  val main = play.Project(appName, appVersion, appDependencies, settings = playScalaSettings ++ buildInfoSettings).settings(
    // Add your own project settings here
    scalaVersion := "2.10.2"
  ).settings(
    resolvers += "gphat" at "https://raw.github.com/gphat/mvn-repo/master/releases/",
    resolvers += "teamon.eu repo" at "http://repo.teamon.eu",
    sourceGenerators in Compile <+= buildInfo,
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "emp"
  )
}
