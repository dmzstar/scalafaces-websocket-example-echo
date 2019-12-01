import Dependencies._

ThisBuild / scalaVersion     := "2.13.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

enablePlugins(TomcatPlugin)

containerLibs in Tomcat := Seq("com.github.jsimone" % "webapp-runner" % "9.0.27.1" intransitive())

webappWebInfClasses := true
unmanagedResourceDirectories in Test += baseDirectory.value / "src/main/webapp"

lazy val root = (project in file("."))
  .settings(
    name := "scalafaces-websocket-example",
    libraryDependencies += scalaTest % Test
  )


libraryDependencies += "org.jboss.weld.servlet" % "weld-servlet-core" % "3.1.1.Final"
libraryDependencies += "javax.websocket" % "javax.websocket-api" % "1.1" % "provided"

//libraryDependencies += "org.glassfish" % "javax.faces" % "2.3.9"

libraryDependencies += "org.apache.myfaces.core" % "myfaces-api" % "2.3.5"
libraryDependencies += "org.apache.myfaces.core" % "myfaces-impl" % "2.3.5"



// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
