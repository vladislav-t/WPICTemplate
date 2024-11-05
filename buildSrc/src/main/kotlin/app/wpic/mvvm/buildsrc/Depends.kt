package app.wpic.mvvm.buildsrc

import app.wpic.mvvm.buildsrc.Depends.Versions.appVersionCode

object Depends {

    object Versions {
        const val appVersionCode = 1_000_000
        const val gradleVersion = "8.6.1"
        const val androidCompileSdkVersion = 34
        const val targetSdkVersion = 34
        const val minSdkVersion = 21
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        const val kotlinVersion = "2.0.0"
        const val gsonVersion = "2.11.0"
        const val retrofitConverterGson = "2.9.0"
        const val lifecycleVersion = "2.8.1"
        const val constraintLayoutVersion = "2.1.4"
        const val supportVersion = "1.4.1"
        const val materialVersion = "1.6.0-alpha03"
        const val coreKtxVersion = "1.9.0"
        const val navigationVersion = "2.5.2"
        const val pagingVersion = "3.3.0"
        const val multidexVersion = "2.0.1"
        const val fragmentExtVersion = "1.5.0-alpha03"
        const val recyclerviewVersion = "1.3.2"
        const val hiltVersion = "2.51.1"
        const val hiltNavigationComposeVersion = "1.2.0"
        const val timberVersion = "5.0.1"
        const val glideVersion = "4.16.0"
        const val dataStorePreferenceVersion = "1.0.0"
        const val coroutinesAndroidVersion = "1.8.1"
        const val sonarqubeVersion = "5.0.0.4638"
        const val detektVersion = "1.23.6"
        const val gradleDoctorVersion = "0.10.0"
        const val dependencyAnalysisVersion = "1.32.0"
        const val sonatypeScanGradleVersion = "2.5.3"
        const val leakCanaryVersion = "2.14"
    }

    object ClassPaths {
        const val gradle = "com.android.tools.build:gradle:${Versions.gradleVersion}"
        const val kotlin_gradle_plugin = "gradle-plugin"
        const val navigation_safe_args_gradle_plugin =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationVersion}"
        const val hilt_android_gradle_plugin =
            "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}"
        const val sonarqube_gradle_plugin =
            "org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:${Versions.sonarqubeVersion}"
        const val detekt_gradle_plugin =
            "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${Versions.detektVersion}"
    }

    object Libraries {
        const val kotlin =
            "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
        const val kotlin_reflect =
            "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlinVersion}"
        const val multidex = "androidx.multidex:multidex:${Versions.multidexVersion}"
        const val dagger_hilt_android = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
        const val dagger_hilt_compiler = "com.google.dagger:hilt-compiler:${Versions.hiltVersion}"
        const val dagger_hilt_navigation_compose =
            "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationComposeVersion}"
        const val fragment_ktx =
            "androidx.fragment:fragment-ktx:${Versions.fragmentExtVersion}"
        const val android_core_ktx =
            "androidx.core:core-ktx:${Versions.coreKtxVersion}"
        const val paging_runtime_ktx =
            "androidx.paging:paging-runtime-ktx:${Versions.pagingVersion}"
        const val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"
        const val material = "com.google.android.material:material:${Versions.materialVersion}"
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
        const val converter_gson =
            "com.squareup.retrofit2:converter-gson:${Versions.retrofitConverterGson}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.supportVersion}"
        const val lifecycle_livedata =
            "androidx.lifecycle:lifecycle-livedata:${Versions.lifecycleVersion}"
        const val constraintlayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
        const val navigation_fragment_ktx =
            "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
        const val navigation_ui_ktx =
            "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
        const val lifecycle_livedata_ktx =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
        const val lifecycle_runtime_ktx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
        const val lifecycle_viewmodel_runtime_ktx =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
        const val lifecycle_viewmodel_ktx =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
        const val recyclerview =
            "androidx.recyclerview:recyclerview:${Versions.recyclerviewVersion}"
        const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
        const val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"
        const val leak_canary =
            "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanaryVersion}"
        const val dataStore_preferences =
            "androidx.datastore:datastore-preferences:${Versions.dataStorePreferenceVersion}"
        const val coroutines_android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroidVersion}"
    }

    fun generateVersionName(): String {
        val patch: Int = appVersionCode.rem(1000)
        val minor: Int = (appVersionCode / 1000).rem(1000)
        val major: Int = (appVersionCode / 1000000).rem(1000)

        return "$major.$minor.$patch"
    }

}