// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Libs.com_android_tools_build_gradle)
        classpath(Libs.kotlin_gradle_plugin)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
    // Find latest version at https://plugins.gradle.org/plugin/jmfayard.github.io.gradle-kotlin-dsl-libs
    id("jmfayard.github.io.gradle-kotlin-dsl-libs") version "0.2.6" // $ ./gradlew syncLibs
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