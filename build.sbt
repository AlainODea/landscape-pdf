name := "landscape-pdf"

version := "1.0"

organization := "net.homeunix.alainodea"

scalaVersion := "2.9.0"

libraryDependencies += "org.clapper" %% "argot" % "0.3.1"

libraryDependencies += "com.lowagie" % "itext" % "2.1.7" withSources() withJavadoc()