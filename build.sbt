lazy val commonSettings = Seq(
  name := "word-count",
  version := "0.0.2",
  organization := "com.example",
  scalaVersion := "2.10.4"
)

assemblyJarName in assembly := "word-count.jar"

lazy val app = (project in file("app")).
  settings(commonSettings: _*).
  settings(

  )

libraryDependencies ++= Seq(
	"com.github.scala-incubator.io" %% "scala-io-file" % "0.4.2"
)
