plugins {
    id("org.sonarqube") version app.wpic.mvvm.buildsrc.Depends.Versions.sonarqubeVersion
    detekt
    id("com.osacky.doctor") version app.wpic.mvvm.buildsrc.Depends.Versions.gradleDoctorVersion
    id("com.autonomousapps.dependency-analysis") version app.wpic.mvvm.buildsrc.Depends.Versions.dependencyAnalysisVersion
    id("org.sonatype.gradle.plugins.scan") version app.wpic.mvvm.buildsrc.Depends.Versions.sonatypeScanGradleVersion
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(app.wpic.mvvm.buildsrc.Depends.ClassPaths.gradle)
        classpath(
            kotlin(
                app.wpic.mvvm.buildsrc.Depends.ClassPaths.kotlin_gradle_plugin,
                version = app.wpic.mvvm.buildsrc.Depends.Versions.kotlinVersion
            )
        )
        classpath(app.wpic.mvvm.buildsrc.Depends.ClassPaths.navigation_safe_args_gradle_plugin)
        classpath(app.wpic.mvvm.buildsrc.Depends.ClassPaths.hilt_android_gradle_plugin)
        classpath(app.wpic.mvvm.buildsrc.Depends.ClassPaths.sonarqube_gradle_plugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.google.com/")
        maven("https://jitpack.io")
        maven("https://plugins.gradle.org/m2/")
    }
}

configure<com.osacky.doctor.DoctorExtension> {
    disallowMultipleDaemons.set(false)
    negativeAvoidanceThreshold.set(500)
    warnWhenJetifierEnabled.set(true)

    javaHome {
        ensureJavaHomeIsSet.set(true)
        ensureJavaHomeMatches.set(true)
        failOnError.set(true)
    }
}
