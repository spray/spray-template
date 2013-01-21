organization  := "com.example"

version       := "0.1"

scalaVersion  := "2.9.2"

scalacOptions := Seq("-Ydependent-method-types", "-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/",
  "akka repo" at "http://repo.akka.io/releases/"
)

libraryDependencies ++= Seq(
  "io.spray"                %   "spray-servlet" % "1.0-M7",
  "io.spray"                %   "spray-routing" % "1.0-M7",
  "io.spray"                %   "spray-testkit" % "1.0-M7",
  "com.typesafe.akka"       %   "akka-actor"    % "2.0.5",
  "org.eclipse.jetty"       %   "jetty-webapp"  % "8.1.7.v20120910" % "container",
  "org.eclipse.jetty.orbit" %   "javax.servlet" % "3.0.0.v201112011016" % "container" artifacts Artifact("javax.servlet", "jar", "jar"),
  "org.specs2"              %%  "specs2"        % "1.12.3" % "test"
)

seq(webSettings: _*)