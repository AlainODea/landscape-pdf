import sbt._

class LandscapePdfProject(info: ProjectInfo) extends DefaultProject(info) with IdeaProject {
  val scalaTest = "org.scalatest" % "scalatest" % "1.3" withSources()
}
