import sbt._
import Keys._
import com.github.siasia.WebPlugin

object Build extends sbt.Build {
  import Dependencies._

  lazy val myProject = Project(
    "spray-template",
    file("."),
    settings = basicSettings ++ WebPlugin.webSettings ++ Seq(
      libraryDependencies ++= Seq(
        Compile.akkaActor,
        Compile.sprayServer,
        Test.specs2,
        Test.jettyServer,
        Test.jettyWebApp,
        Test.jettyPlugin,
        Runtime.akkaSlf4j,
        Runtime.slf4j,
        Runtime.logback
      )
    )
  )

  lazy val basicSettings = Defaults.defaultSettings ++ Seq(
    organization  := "com.example",
    version       := "0.8.0-RC1",
    scalaVersion  := "2.9.1",
    scalacOptions := Seq("-deprecation", "-encoding", "utf8"),
    resolvers     ++= Dependencies.resolutionRepos
  )
}

object Dependencies {
  val resolutionRepos = Seq(
    "Akka Repository" at "http://akka.io/repository/",
    ScalaToolsSnapshots
  )

  object V {
    val akka    = "1.2"
    val spray   = "0.8.0-RC1"
    val specs2  = "1.6.1"
    val jetty   = "8.0.3.v20111011"
    val slf4j   = "1.6.1"
    val logback = "0.9.29"
  }

  object Compile {
    val akkaActor   = "se.scalablesolutions.akka" %  "akka-actor"      % V.akka    % "compile"
    val sprayServer = "cc.spray"                  %  "spray-server"    % V.spray   % "compile"
  }

  object Test {
    val specs2      = "org.specs2"                %% "specs2"          % V.specs2  % "test"
    val jettyServer = "org.eclipse.jetty"         %  "jetty-server"    % V.jetty   % "test"
    val jettyWebApp = "org.eclipse.jetty"         %  "jetty-webapp"    % V.jetty   % "test"
    val jettyPlugin = "org.eclipse.jetty"         %  "jetty-webapp"    % V.jetty   % "jetty" // web-plugin
  }

  object Runtime {
    val akkaSlf4j   = "se.scalablesolutions.akka" %  "akka-slf4j"      % V.akka    % "runtime"
    val slf4j       = "org.slf4j"                 %  "slf4j-api"       % V.slf4j   % "runtime"
    val logback     = "ch.qos.logback"            %  "logback-classic" % V.logback % "runtime"
  }
}