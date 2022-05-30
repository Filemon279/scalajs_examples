ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "scalaExample",
    idePackagePrefix := Some("org.filemon.example")
  )

//Enable Scala JS
enablePlugins(ScalaJSPlugin)

//This is an application with a main method
scalaJSUseMainModuleInitializer := true