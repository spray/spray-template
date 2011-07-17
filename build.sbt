// Project specific settings.
name := "spray-template"

organization := "spray"

version := "0.7.0"

scalaVersion := "2.9.0-1"

// Some of the transitive dependencies have invalid md5 hashes in their Maven repos, so this
// bypasses that problem. This should probably be removed in the future once all those things
// are brought up to date. Recommended by Mark Harrah.
checksums := Nil

// Absolutely necessary dependencies.
libraryDependencies ++= Seq(
  "cc.spray" %% "spray-client" % "0.7.0-SNAPSHOT" % "compile" withSources(),
  "cc.spray" %% "spray-http" % "0.7.0-SNAPSHOT" % "compile" withSources(),
  "cc.spray" %% "spray-server" % "0.7.0-SNAPSHOT" % "compile" withSources(),
  "se.scalablesolutions.akka" % "akka" % "1.1.3"
)

// Testing dependencies.
libraryDependencies ++= Seq(
  "org.scala-tools.testing" %% "specs" % "1.6.8" % "test",
  "org.eclipse.jetty" % "jetty-server" % "8.0.0.M2" % "jetty",
  "org.eclipse.jetty" % "jetty-webapp" % "8.0.0.M2" % "jetty"
)

// slf4j is not required but a good option for logging. logback is a good slf4j backend.
libraryDependencies ++= Seq(
  "se.scalablesolutions.akka" % "akka-slf4j" % "1.1.3",
  "ch.qos.logback" % "logback-classic" % "0.9.28" % "runtime"
)

// Inject the xsbt-web-plugin webSettings into these project settings to enable
// commands such as jetty-run.
seq(webSettings :_*)

// We are using the 0.7.0 snapshot of Spray, so we need to add this resolver.
resolvers += ScalaToolsSnapshots

resolvers += "Akka Repository" at "http://akka.io/repository",

