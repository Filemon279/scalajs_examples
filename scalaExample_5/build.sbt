ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "scalaExample_5"
  )

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "2.1.0",
  "com.github.japgolly.scalajs-react" %%% "core" % "2.0.1",
  "com.github.japgolly.scalajs-react" %%% "extra" % "2.1.0",
  "com.github.japgolly.scalajs-react" %%% "extra-ext-monocle2" % "2.1.0",
  "dev.optics" %%% "monocle-core"  % "3.1.0",
  "dev.optics" %%% "monocle-macro" % "3.1.0",
)

Global / scalacOptions += "-Ymacro-annotations"

Compile / npmDependencies ++= Seq(
  "react" -> "17.0.2",
  "react-dom" -> "17.0.2")

enablePlugins(ScalaJSBundlerPlugin)
enablePlugins(ScalaJSPlugin)

scalaJSUseMainModuleInitializer := true
