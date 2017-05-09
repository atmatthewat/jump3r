name              := "jump3r"
organization      := "de.sciss"
version           := "1.0.4-SNAPSHOT"
scalaVersion      := "2.12.2"
licenses          := Seq("LGPL v2.1+" -> url("https://www.gnu.org/licenses/lgpl-2.1.txt"))
crossPaths        := false
autoScalaLibrary  := false

// libraryDependencies ++= Seq(
//   "de.sciss"     % "jawjaw"          % "0.1.0",
//   "com.novocode" % "junit-interface" % "0.11" % "test"
// )

homepage          := Some(url(s"https://github.com/Sciss/${name.value}"))
description       := "Java Unofficial MP3 EncodeR - a Java port of LAME"

lazy val commonJavaOptions = Seq("-source", "1.6")

javacOptions        := commonJavaOptions ++ Seq("-target", "1.6", "-g", "-Xlint:deprecation")
javacOptions in doc := commonJavaOptions  // cf. sbt issue #355

// ---- publishing to Maven Central ----
publishMavenStyle := true

publishTo := Some(
  if (isSnapshot.value)
    "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  else
    "Sonatype Releases"  at "https://oss.sonatype.org/service/local/staging/deploy/maven2"
)

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := { val n = name.value
  <scm>
    <url>git@github.com:Sciss/{n}.git</url>
    <connection>scm:git:git@github.com:Sciss/{n}.git</connection>
  </scm>
  <developers>
    <developer>
      <id>kenchis</id>
      <name>Ken Händel</name>
      <url>http://haendel.ddns.net/~ken/</url>
    </developer>
    <developer>
      <id>vikulin</id>
      <name>Vadym Vikulin</name>
      <url>https://github.com/vikulin</url>
    </developer>
    <developer>
      <id>sciss</id>
      <name>Hanns Holger Rutz</name>
      <url>http://www.sciss.de</url>
    </developer>
  </developers>
}
