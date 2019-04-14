enablePlugins(ScalaJSBundlerPlugin)

name := "scalajs-react-example"

scalaVersion := "2.12.8"
val scalaJSReactVersion = "1.2.0"
val scalaCssVersion = "0.5.5"
val reactJSVersion = "16.3.2"

npmDependencies in Compile += "react" -> "16.8.6"
npmDependencies in Compile += "react-dom" -> "16.8.6"
npmDependencies in Compile += "react-proxy" -> "1.1.8"

npmDevDependencies in Compile += "file-loader" -> "3.0.1"
npmDevDependencies in Compile += "style-loader" -> "0.23.1"
npmDevDependencies in Compile += "css-loader" -> "2.1.1"
npmDevDependencies in Compile += "html-webpack-plugin" -> "3.2.0"
npmDevDependencies in Compile += "copy-webpack-plugin" -> "5.0.2"
npmDevDependencies in Compile += "webpack-merge" -> "4.2.1"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.5",
  "com.github.japgolly.scalajs-react" %%% "core" % scalaJSReactVersion,
  "com.github.japgolly.scalajs-react" %%% "extra" % scalaJSReactVersion,
  "com.github.japgolly.scalacss" %%% "core" % scalaCssVersion,
  "com.github.japgolly.scalacss" %%% "ext-react" % scalaCssVersion
)

libraryDependencies += "org.scalatest" %%% "scalatest" % "3.0.5" % Test

scalacOptions += "-P:scalajs:sjsDefinedByDefault"
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)

version in webpack := "4.29.6"
version in startWebpackDevServer:= "3.2.1"

webpackResources := baseDirectory.value / "webpack" * "*"

webpackConfigFile in fastOptJS := Some(baseDirectory.value / "webpack" / "webpack-fastopt.config.js")
webpackConfigFile in fullOptJS := Some(baseDirectory.value / "webpack" / "webpack-opt.config.js")
webpackConfigFile in Test := Some(baseDirectory.value / "webpack" / "webpack-core.config.js")

webpackDevServerExtraArgs in fastOptJS := Seq("--inline", "--hot")
webpackBundlingMode in fastOptJS := BundlingMode.LibraryOnly()

requireJsDomEnv in Test := true

addCommandAlias("serve", ";fastOptJS::startWebpackDevServer;~fastOptJS")

addCommandAlias("devBuild", "fastOptJS")

addCommandAlias("build", "fullOptJS::webpack")
