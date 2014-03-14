organization  := "com.example"

version       := "0.1"

scalaVersion  := "2.10.3"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/"
)

libraryDependencies ++= {
  val akkaV = "2.1.4"
  val sprayV = "1.1.1"
  Seq(
    "io.spray"            %   "spray-servlet" % sprayV,
    "io.spray"            %   "spray-routing" % sprayV,
    "org.eclipse.jetty"   %   "jetty-webapp"  % "9.1.0.v20131115" % "container",
    "org.eclipse.jetty"   %   "jetty-plus"    % "9.1.0.v20131115" % "container",
    "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container"  artifacts Artifact("javax.servlet", "jar", "jar"),
    "io.spray"            %   "spray-testkit" % sprayV % "test",
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV % "test",
    "org.specs2"          %%  "specs2"        % "2.2.3" % "test"
  )
}

seq(webSettings: _*)
