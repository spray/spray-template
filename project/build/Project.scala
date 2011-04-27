import sbt._
import Process._

class Project(info: ProjectInfo) extends DefaultWebProject(info) with AkkaProject {
  
  // -------------------------------------------------------------------------------------------------------------------
  // All repositories *must* go here! See ModuleConfigurations below.
  // -------------------------------------------------------------------------------------------------------------------
  object Repositories {
    // e.g. val AkkaRepo = MavenRepository("Akka Repository", "http://akka.io/repository")
  }
  
  // -------------------------------------------------------------------------------------------------------------------
  // ModuleConfigurations
  // Every dependency that cannot be resolved from the built-in repositories (Maven Central and Scala Tools Releases)
  // must be resolved from a ModuleConfiguration. This will result in a significant acceleration of the update action.
  // Therefore, if repositories are defined, this must happen as def, not as val.
  // -------------------------------------------------------------------------------------------------------------------
  import Repositories._
  val sprayModuleConfig     = ModuleConfiguration("cc.spray", ScalaToolsSnapshots)
  val parboiledModuleConfig = ModuleConfiguration("org.parboiled", ScalaToolsSnapshots)

  // -------------------------------------------------------------------------------------------------------------------
  // Dependencies
  // -------------------------------------------------------------------------------------------------------------------
  override val akkaActor  = akkaModule("actor") withSources() // it's good to always have the sources around
  val spray               = "cc.spray" %% "spray" % "0.6.0-SNAPSHOT" % "compile" withSources()

  val JETTY_VERSION = "8.0.0.M2" // e.g. "7.2.0.v20101020" for testing the Jetty7ConnectorServlet 
  val specs       = "org.scala-tools.testing" %% "specs" % "1.6.7" % "test"
  val jettyServer = "org.eclipse.jetty" % "jetty-server" % JETTY_VERSION % "test"
  val jettyWebApp = "org.eclipse.jetty" % "jetty-webapp" % JETTY_VERSION % "test"
}
