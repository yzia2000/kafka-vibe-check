val scala3Version = "3.2.2"

Global / fork := true
Global / cancelable := true
Global / connectInput := true
Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val root = project
  .in(file("."))
  .settings(
    name := "kafka-vibe-check",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio-http" % "0.0.4"
    ),
    executableScriptName := "main"
  )
  .enablePlugins(JavaAppPackaging)
