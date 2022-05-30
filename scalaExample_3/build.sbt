ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.8"


lazy val root = (project in file("."))
  .settings(
    name := "scalaExample_3",
    idePackagePrefix := Some("org.filemon.example")
  )

libraryDependencies ++= Seq(
  "com.github.japgolly.scalajs-react" %%% "core" % "2.0.1",
  "org.scala-js" %%% "scalajs-dom" % "2.1.0")

Compile / npmDependencies ++= Seq(
  "react" -> "17.0.2",
  "react-dom" -> "17.0.2")

enablePlugins(ScalaJSBundlerPlugin)
enablePlugins(ScalaJSPlugin)
scalaJSUseMainModuleInitializer := true



