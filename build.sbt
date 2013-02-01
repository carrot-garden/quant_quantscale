organization := "org.qslib"

name := "quantscale"

version := "0.1.0"

scalaVersion := "2.10.0"

scalacOptions <++= scalaVersion map { v =>
  if (v.startsWith("2.10"))
    Seq("-unchecked", "-deprecation", "-feature", "-language:implicitConversions")
  else
    Seq("-unchecked", "-deprecation")
}

libraryDependencies ++= Seq(
  "org.scalanlp" %% "breeze-math" % "0.2-SNAPSHOT",
  "org.scalanlp" %% "breeze-learn" % "0.2-SNAPSHOT",
  "org.scalanlp" %% "breeze-process" % "0.2-SNAPSHOT",
  "org.scalanlp" %% "breeze-viz" % "0.2-SNAPSHOT",
  "org.scalaj" % "scalaj-time_2.9.2" % "0.6",
  "org.scalatest" %% "scalatest" % "1.9.1" % "test",
  "junit" % "junit" % "4.11" % "test"
)

resolvers ++= Seq(
  "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
)