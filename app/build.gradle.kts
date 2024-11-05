import app.wpic.mvvm.buildsrc.Depends
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-parcelize")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Depends.Versions.androidCompileSdkVersion

    defaultConfig {
        multiDexEnabled = true
        applicationId = "app.wpic.mvvmtemplate"
        minSdk = Depends.Versions.minSdkVersion
        targetSdk = Depends.Versions.targetSdkVersion
        versionCode = Depends.Versions.appVersionCode
        versionName = Depends.generateVersionName()
        testInstrumentationRunner =
            Depends.Libraries.testInstrumentationRunner
    }

    buildTypes {
        named("debug") {
            isMinifyEnabled = false
            isShrinkResources = false
            isDebuggable = true
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-DEBUG"
            signingConfig = signingConfigs.getByName("debug")
        }
        named("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }
    }

    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        targetCompatibility = JavaVersion.VERSION_17
        sourceCompatibility = JavaVersion.VERSION_17
    }

    project.tasks.withType<KotlinCompile> {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    namespace = "app.wpic.mvvmtemplate"

    lint {
        abortOnError = false
    }
}

dependencies {
    implementation(Depends.Libraries.kotlin)
    implementation(Depends.Libraries.android_core_ktx)
    implementation(Depends.Libraries.multidex)
    implementation(Depends.Libraries.fragment_ktx)

    implementation(Depends.Libraries.dataStore_preferences)
    implementation(Depends.Libraries.coroutines_android)

    //dependency injection
    implementation(Depends.Libraries.dagger_hilt_android)
    implementation(Depends.Libraries.dagger_hilt_navigation_compose)
    kapt(Depends.Libraries.dagger_hilt_compiler)

    //other
    implementation(Depends.Libraries.timber)
    implementation(Depends.Libraries.material)
    debugImplementation(Depends.Libraries.leak_canary)

    implementation(project(":presentation"))
    implementation(project(":data"))
    implementation(project(":domain"))
}