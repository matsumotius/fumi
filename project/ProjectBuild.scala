import sbt._
import sbt.Keys._

object ProjectBuild extends Build {

  lazy val root = Project(
    id = "root",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "fumi",
      organization := "com.myatsumoto",
      version := "1.0",
      scalaVersion := "2.9.2",
      libraryDependencies += "org.scalatest" %% "scalatest" % "1.8" % "test"
    )
  ).dependsOn(wabi)

  lazy val wabi = uri("git://github.com/myatsumoto/wabi.git")

}
