name := "ScalaCourse"

version := "0.1"

scalaVersion := "2.12.4"

triggeredMessage := Watched.clearWhenTriggered

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "org.specs2" %% "specs2-core" % "4.0.2" % "test",
  "org.specs2" %% "specs2-mock" % "4.0.2" % "test",
  "org.specs2" %% "specs2-scalacheck" % "4.0.2" % "test"
)

scalacOptions := Seq(
  "-feature",
  "-language:implicitConversions"
)
