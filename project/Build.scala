import sbt._
import Keys._
import cc.spray.HRPlugin._

object Build extends sbt.Build {
  import Dependencies._

  lazy val myProject = Project("spray-template", file("."))
    .settings(HotReload.hotReloadSettings: _*)
    .settings(
      organization  := "com.example",
      version       := "0.9.0-SNAPSHOT",
      scalaVersion  := "2.9.1",
      scalacOptions := Seq("-deprecation", "-encoding", "utf8"),
      resolvers     ++= Dependencies.resolutionRepos,
      libraryDependencies ++= Seq(
        Compile.akkaActor,
        Compile.sprayCan,
        Compile.sprayServer,
        Test.specs2,
        Container.akkaSlf4j,
        Container.slf4j,
        Container.logback
      )
    )
}

object Dependencies {
  val resolutionRepos = Seq(
    "Akka Repository" at "http://akka.io/repository/",
    ScalaToolsSnapshots
  )

  object V {
    val akka     = "1.3-RC4"
    val sprayCan = "0.9.2-SNAPSHOT"
    val spray    = "0.9.0-SNAPSHOT"
    val specs2   = "1.6.1"
    val slf4j    = "1.6.1"
    val logback  = "0.9.29"
  }

  object Compile {
    val akkaActor   = "se.scalablesolutions.akka" %  "akka-actor"      % V.akka     % "compile"
    val sprayCan    = "cc.spray.can"              %  "spray-can"       % V.sprayCan % "compile"
    val sprayServer = "cc.spray"                  %  "spray-server"    % V.spray    % "compile"
  }

  object Test {
    val specs2      = "org.specs2"                %% "specs2"          % V.specs2  % "test"
  }

  object Container {
    val akkaSlf4j   = "se.scalablesolutions.akka" %  "akka-slf4j"      % V.akka
    val slf4j       = "org.slf4j"                 %  "slf4j-api"       % V.slf4j
    val logback     = "ch.qos.logback"            %  "logback-classic" % V.logback
  }
}