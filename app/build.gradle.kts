import com.android.build.gradle.ProguardFiles.getDefaultProguardFile
import org.gradle.internal.impldep.com.amazonaws.PredefinedClientConfigurations.defaultConfig
import org.jetbrains.kotlin.config.KotlinCompilerVersion
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt
import kotlin.script.experimental.jvm.util.KotlinJars.stdlib

plugins {
    id("com.android.application")
    id("androidx.navigation.safeargs")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "com.teaml.timemanagment"
        minSdkVersion( 16)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    //implementation fileTree (org.gradle.internal.impldep.bsh.commands.dir: 'libs', include: ['*.jar'])
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Support
    implementation(Libs.kotlin_stdlib_jdk7)
    implementation(Libs.appcompat)
    implementation(Libs.constraintlayout)
    implementation(Libs.lifecycle_extensions)
    // Room
    implementation(Libs.room_runtime)
    implementation(Libs.room_coroutines)
    // Navigation
    implementation (Libs.navigation_fragment_ktx)
    implementation (Libs.navigation_ui_ktx)
    // Dagger
    implementation(Libs.dagger_android)
    implementation(Libs.dagger_android_support)


    kapt(Libs.dagger_android_processor)
    kapt(Libs.dagger_compiler)
    kapt(Libs.room_compiler)

    testImplementation(Libs.room_testing)
    testImplementation(Libs.junit)

    androidTestImplementation(Libs.navigation_testing)
    androidTestImplementation(Libs.androidx_test_runner)
    androidTestImplementation(Libs.espresso_core)
}
