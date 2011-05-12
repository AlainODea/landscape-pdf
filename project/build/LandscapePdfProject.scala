import sbt._

class LandscapePdfProject(info: ProjectInfo) extends DefaultProject(info) with IdeaProject {
  val scalaTest = "org.scalatest" % "scalatest" % "1.3" withSources()
  val jewelcli = "uk.co.flamingpenguin.jewelcli" % "jewelcli" % "0.6" withSources() withJavadoc()
  val iText = "com.lowagie" % "itext" % "2.1.7" withSources() withJavadoc()
}
