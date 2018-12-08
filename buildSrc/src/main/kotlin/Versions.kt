import kotlin.String

/**
 * Find which updates are available by running
 *     `$ ./gradlew syncLibs`
 * This will only update the comments.
 *
 * YOU are responsible for updating manually the dependency version. */
object Versions {
    const val android_arch_navigation: String = "1.0.0-alpha08" 
            /* Could not find any version that matches android.arch.navigation:navigation-fragment-ktx:+.
            Versions rejected by component selection rules:
              - 1.0.0-alpha08
              - 1.0.0-alpha07 
            .... */

    const val appcompat: String = "1.1.0-alpha01" // exceed the version found: 1.0.2

    const val constraintlayout: String = "2.0.0-alpha2" // exceed the version found: 1.1.3

    const val lifecycle_extensions: String = "2.0.0" 

    const val androidx_room: String = "2.1.0-alpha03" // exceed the version found: 2.0.0

    const val espresso_core: String = "3.1.1-alpha01" // exceed the version found: 3.1.0

    const val androidx_test_runner: String = "1.1.1-alpha01" // exceed the version found: 1.1.0

    const val com_android_tools_build_gradle: String =
            "3.3.0-beta04" // exceed the version found: 3.2.1

    const val lint_gradle: String = "26.3.0-beta04" // exceed the version found: 26.2.1

    const val com_google_dagger: String = "2.19" //available: "2.19"

    const val jmfayard_github_io_gradle_kotlin_dsl_libs_gradle_plugin: String = "0.2.6" 

    const val junit: String = "4.12" 

    const val org_jetbrains_kotlin: String = "1.3.10" 

    /**
     *
     *   To update Gradle, edit the wrapper file at path:
     *      ./gradle/wrapper/gradle-wrapper.properties
     */
    object Gradle {
        const val runningVersion: String = "4.10.1"

        const val currentVersion: String = "5.0"

        const val nightlyVersion: String = "5.2-20181208000047+0000"

        const val releaseCandidate: String = ""
    }
}
