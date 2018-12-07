// Top-level build file where you can add configuration options common to all sub-projects/modules.
object Version {
    const val KOTLIN_VERSION = "1.3.10"
}

buildscript {

    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.3.0-beta04")
        //classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.KOTLIN_VERSION}")
        classpath(kotlin("gradle-plugin", "1.3.10"))

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}