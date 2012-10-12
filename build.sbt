organization  := "com.example"

version       := "1.0-M3"

scalaVersion  := "2.9.2"

scalacOptions := Seq("-Ydependent-method-types", "-unchecked", "-deprecation", "-encoding", "utf8")

resolvers += "spray repo" at "http://repo.spray.io/"

libraryDependencies ++= Seq(
  "io.spray"            %   "spray-can"     % "1.0-M3",
  "io.spray"            %   "spray-routing" % "1.0-M3",
  "io.spray"            %   "spray-testkit" % "1.0-M3",
  "com.typesafe.akka"   %   "akka-actor"    % "2.0.3",
  "org.specs2"          %%  "specs2"        % "1.12.2" % "test"
)

seq(Revolver.settings: _*)