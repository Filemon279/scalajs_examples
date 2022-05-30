addSbtPlugin("org.jetbrains.scala" % "sbt-ide-settings" % "1.1.1")
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.10.0")

// module bundler for Scala.js projects that use npm packages
// it bundles the .js file emitted by the Scala.js compiler with its npm dependencies into a single .js file executable by Web browsers.
addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.20.0")

