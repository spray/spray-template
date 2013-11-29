organization  := "com.example"

version       := "0.1"

scalaVersion  := "2.9.3"

scalacOptions := Seq("-Ydependent-method-types", "-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/",
  "akka repo" at "http://repo.akka.io/releases/"
)

libraryDependencies ++= {
  val akkaV = "2.0.5"
  val sprayV = "1.0.0"
  Seq(
    "io.spray"            %   "spray-servlet" % sprayV,
    "io.spray"            %   "spray-routing" % sprayV,
    "io.spray"            %   "spray-testkit" % sprayV,
    "org.eclipse.jetty"       %   "jetty-webapp"  % "8.1.13.v20130916"    % "container",
    "org.eclipse.jetty.orbit" %   "javax.servlet" % "3.0.0.v201112011016" % "container"  artifacts Artifact("javax.servlet", "jar", "jar"),
    "com.typesafe.akka"   %   "akka-actor"    % akkaV,
    "com.typesafe.akka"   %   "akka-testkit"  % akkaV,
    "org.specs2"          %%  "specs2"        % "1.12.4.1" % "test"
  )
}

seq(webSettings: _*)
