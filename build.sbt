name := "Coding"

version := "0.1"

scalaVersion := "2.12.8"


lazy val commonSettings = Seq(
  version := "0.1",

  scalaVersion := "2.12.8",

  test in assembly := {},

  compileOrder := CompileOrder.JavaThenScala,
)


lazy val Crypto = (project in file("Crypto")).
  settings(commonSettings: _*).
  settings(
    name := "Crypto",
    version := "0.1",
    libraryDependencies += "org.scala-lang.modules" % "scala-swing_2.12" % "2.1.0"
  )

