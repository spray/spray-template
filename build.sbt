organization  := "com.example"

version       := "0.1"

scalaVersion  := "2.9.3"

scalacOptions := Seq("-Ydependent-method-types", "-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/",
  "akka repo" at "http://repo.akka.io/releases/"
)

libraryDependencies ++= Seq(
  "io.spray"                %   "spray-servlet" % "1.0-M8.1",
  "io.spray"                %   "spray-routing" % "1.0-M8.1",
  "io.spray"                %   "spray-testkit" % "1.0-M8.1",
  "com.typesafe.akka"       %   "akka-actor"    % "2.0.5",
  "com.typesafe.akka"       %   "akka-testkit"  % "2.0.5",
  "org.eclipse.jetty"       %   "jetty-webapp"  % "8.1.10.v20130312" % "container",
  "org.eclipse.jetty.orbit" %   "javax.servlet" % "3.0.0.v201112011016" % "container" artifacts Artifact("javax.servlet", "jar", "jar"),
  "org.specs2"              %%  "specs2"        % "1.12.4.1" % "test"
)

seq(webSettings: _*)