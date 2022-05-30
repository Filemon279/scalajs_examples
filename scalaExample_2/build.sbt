ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "scalaExample_2",
    idePackagePrefix := Some("org.filemon.example")
  )

//Add DOM dependency
libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.1.0"


enablePlugins(ScalaJSPlugin)
scalaJSUseMainModuleInitializer := true

