import sbt._

object Libraries {

  def onCompile(dep: ModuleID): ModuleID = dep % "compile"
  def onTest(dep: ModuleID): ModuleID = dep % "test"

  //Plugins:
  lazy val wartRemover = "org.brianmckenna" %% "wartremover" % Versions.wartremoverV
  lazy val androidSDKPlugin = "com.hanhuy.sbt" % "android-sdk-plugin" % Versions.androidPluginV

  object scala {

    lazy val scalaReflect = "org.scala-lang" % "scala-reflect" % Versions.scalaV
    lazy val scalap = "org.scala-lang" % "scalap" % Versions.scalaV
  }

  object android {

    def androidDep(module: String) = "com.android.support" % module % Versions.androidV

    lazy val androidSupportv4 = androidDep("support-v4")
    lazy val androidAppCompat = androidDep("appcompat-v7")
    lazy val androidRecyclerview = androidDep("recyclerview-v7")
    lazy val androidCardView = androidDep("cardview-v7")
  }
  
  lazy val androidMultidex = "com.android.support" % "multidex" % Versions.multidexV

  object akka {

    def akka(module: String) = "com.typesafe.akka" %% s"akka-$module" % Versions.akkaV

    lazy val akkaActor = akka("actor")
    lazy val akkaTestKit = akka("testkit")

  }

  object macroid {

    def macroid(module: String = "") =
      "org.macroid" %% s"macroid${if(!module.isEmpty) s"-$module" else ""}" % Versions.macroidV

    lazy val macroidRoot = macroid()
    lazy val macroidAkkaFragments = macroid("akka-fragments")
    lazy val macroidExtras = "com.fortysevendeg" %% "macroid-extras" % Versions.macroidExtras
  }
}