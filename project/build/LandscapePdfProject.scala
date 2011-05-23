import sbt._

class LandscapePdfProject(info: ProjectInfo) extends DefaultProject(info) with IdeaProject {
  val argot = "org.clapper" %% "argot" % "0.3.1"
  val iText = "com.lowagie" % "itext" % "2.1.7" withSources() withJavadoc()
}
