import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")


}

android {
    compileSdkVersion(28)

    defaultConfig {
        applicationId = "com.teaml.timemanagment"
        minSdkVersion(16)
        targetSdkVersion(28)
        versionCode =  1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            //minifyEnabled false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation (fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin("stdlib-jdk7", KotlinCompilerVersion.VERSION))
    implementation ("androidx.appcompat:appcompat:1.1.0-alpha01")
    implementation ("androidx.constraintlayout:constraintlayout:2.0.0-alpha2")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.0.0")
    testImplementation ("junit:junit:4.12")
    androidTestImplementation ("androidx.test:runner:1.1.1-alpha01")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.1.1-alpha01")

    implementation ("com.google.android.material:material:1.0.0")
    implementation ("androidx.appcompat:appcompat:1.0.2")
}
