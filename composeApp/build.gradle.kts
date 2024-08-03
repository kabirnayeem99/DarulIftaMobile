import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.sqlDelight)
}

kotlin {
    sourceSets.iosMain {
        kotlin.srcDir("build/generated/ksp/metadata")
    }
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class) compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    jvm("desktop")

    listOf(
        iosX64(), iosArm64(), iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "DarulIftaMobile"
            isStatic = true
        }
    }

    applyDefaultHierarchyTemplate()

    sourceSets.commonMain {
        kotlin.srcDir("build/generated/ksp/metadata")
    }

    sourceSets {
        val desktopMain by getting

        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.ktor.client.android)
        }

        commonMain.dependencies {
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            api(libs.koin.core)
            implementation(libs.sqlDelight.runtime)
            implementation(libs.sqlDelight.coroutines.extensions)
            implementation(libs.koin.compose.multiplatform)
            implementation(libs.koin.test)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(compose.runtime)
            implementation(compose.ui)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.ksoup)
            implementation(libs.ksoup.network)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.logging)
            implementation(libs.coroutines.core)
            implementation(libs.sqlDelight.coroutinesExt)
            api(libs.kotlinx.datetime)
            api(libs.napier)
            implementation(libs.koin.core)
            api(libs.material.theme.prefs)
            implementation(libs.stately.common)
            implementation(libs.sqlDelight.coroutinesExt)
            api(libs.kotlinx.datetime)
            implementation(libs.coroutines.core)
            api(libs.napier)
            implementation(libs.stately.common)
            api(libs.material.theme.prefs)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(kotlin("test"))
            implementation(kotlin("test-common"))
            implementation(kotlin("test-annotations-common"))
            implementation(libs.coroutines.test)
            implementation(libs.koin.test)
        }

        androidMain.dependencies {
            implementation(libs.coroutines.android)
            api(libs.sqlDelight.android)
            implementation(libs.bundles.androidx.sqlite)
            api(libs.android.sqlcipher)
            implementation(libs.koin.android)
            implementation(libs.androidx.activity.compose)
            implementation(libs.koin.android)
        }

        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.ktor.client.okhttp)
        }

        iosMain.dependencies {
            implementation(libs.sqlDelight.native)
            implementation(libs.ktor.client.darwin)
        }

        jvmMain.dependencies {
            implementation(libs.sqlDelight.jvm)
            implementation(libs.appdirs)
            implementation(libs.slf4j)
            implementation(libs.coroutines.swing)
        }

        all {
            languageSettings.optIn("kotlin.RequiresOptIn")
        }
    }
}

sqldelight {
    databases {
        create("DarulIftaMobileDatabase") {
            packageName.set("io.github.kabirnayeem99.darulifta.db")
        }
    }
}

android {
    namespace = "io.github.kabirnayeem99.darulifta"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "io.github.kabirnayeem99.darulifta"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
    dependencies {
        debugImplementation(compose.uiTooling)
    }
}

kotlin.sourceSets.all {
    languageSettings.optIn("kotlinx.cinterop.ExperimentalForeignApi")
    languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "io.github.kabirnayeem99.darulifta"
            packageVersion = "1.0.0"
        }
    }
}

