organization  := "com.example"

version       := "0.1"

scalaVersion  := "2.10.0-RC3"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  "typesafe repo"      at "http://repo.typesafe.com/typesafe/releases/",
  "spray repo"         at "http://repo.spray.io/"
)

libraryDependencies ++= Seq(
  "io.spray"            %   "spray-can"     % "1.1-M6",
  "io.spray"            %   "spray-routing" % "1.1-M6",
  "io.spray"            %   "spray-testkit" % "1.1-M6",
  "com.typesafe.akka"   %%  "akka-actor"    % "2.1.0-RC3"          cross CrossVersion.full,
  "org.specs2"          %%  "specs2"        % "1.12.3"    % "test" cross CrossVersion.full
)

seq(Revolver.settings: _*)