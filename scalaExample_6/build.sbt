ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.8"


lazy val scalaExample_6 = (project in file("."))
  .aggregate(flashtalk.js, flashtalk.jvm)
  .settings(
    publish := {},
    publishLocal := {}
  )

lazy val flashtalk = crossProject(JSPlatform, JVMPlatform).in(file("."))
  .settings(
    name := "flashtalk",
    libraryDependencies ++= Seq(
      "io.circe" %%% "circe-core" % "0.14.1",
      "io.circe" %%% "circe-generic" % "0.14.1",
    )
  )
  .jvmSettings(
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor-typed" % "2.6.8",
      "com.typesafe.akka" %% "akka-stream" % "2.6.8",
      "com.typesafe.akka" %% "akka-http" % "10.2.9",
      "de.heikoseeberger" %% "akka-http-circe" % "1.29.1",
      "ch.megard" %% "akka-http-cors" % "1.1.3"
    )
  )
  .jsSettings(
    libraryDependencies ++= Seq(
      "com.softwaremill.sttp.client3" %%% "core" % "3.6.2",
      "com.softwaremill.sttp.client3" %%% "circe" % "3.6.2",

      "org.scala-js" %%% "scalajs-dom" % "2.1.0",
      "com.github.japgolly.scalajs-react" %%% "core" % "2.0.1",
      "com.github.japgolly.scalajs-react" %%% "extra" % "2.1.0",
      "com.github.japgolly.scalajs-react" %%% "extra-ext-monocle2" % "2.1.0",
      "dev.optics" %%% "monocle-core"  % "3.1.0",
      "dev.optics" %%% "monocle-macro" % "3.1.0",
    ),
    webpackBundlingMode := BundlingMode.LibraryAndApplication(),
    scalaJSUseMainModuleInitializer := true,
    Compile / npmDependencies ++= Seq(
      "react" -> "17.0.2",
      "react-dom" -> "17.0.2")
  ).jsConfigure { project => project.enablePlugins(ScalaJSBundlerPlugin) }



Global / scalacOptions += "-Ymacro-annotations"





