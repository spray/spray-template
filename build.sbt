organization  := "com.example"

version       := "0.1"

scalaVersion  := "2.9.2"

scalacOptions := Seq("-Ydependent-method-types", "-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/",
  "akka repo" at "http://repo.akka.io/releases/"
)

libraryDependencies ++= Seq(
  "io.spray"            %   "spray-can"     % "1.0-M7",
  "io.spray"            %   "spray-routing" % "1.0-M7",
  "io.spray"            %   "spray-testkit" % "1.0-M7",
  "com.typesafe.akka"   %   "akka-actor"    % "2.0.5",
  "org.specs2"          %%  "specs2"        % "1.12.3" % "test"
)

seq(Revolver.settings: _*)