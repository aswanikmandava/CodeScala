ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.17"

lazy val root = (project in file("."))
  .settings(
    name := "CodeScala"
  )
// bind the custom task
lazy val customObj = taskKey[Unit]("My Custom task")
customObj := {
  // Calling the custom task
  CustomTask.printTask()
}

exportJars := true