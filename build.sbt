name := "mbench"
organization := "roy"
version := "0.1"
scalaVersion := "2.12.8"

import pl.project13.scala.sbt.JmhPlugin

lazy val global = project
  .in(file("."))
  .aggregate(
    mbench,
    mapp
  )

lazy val mapp = project
  .settings(
    name := "mapp",
    resolvers += Resolver.bintrayRepo("ultrabrew", "m2"),
    libraryDependencies ++= Seq(
      "io.dropwizard.metrics" % "metrics-core" % "3.1.5",
      "io.ultrabrew.metrics" % "metrics-core" % "0.3.0",
      "org.scalatest" %% "scalatest" % "3.0.5" % Test
    )
  )

lazy val mbench = project
  .enablePlugins(JmhPlugin)
  .settings(
    name := "mbench"
  )
  .dependsOn(
    mapp
  )
