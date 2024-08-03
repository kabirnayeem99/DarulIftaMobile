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
            api(libs.koin.core)
            api(libs.kotlinx.datetime)
            api(libs.material.theme.prefs)
            api(libs.napier)

            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(compose.runtime)
            implementation(compose.ui)

            implementation(libs.coroutines.core)

            implementation(libs.koin.compose.multiplatform)
            implementation(libs.koin.core)
            implementation(libs.koin.test)

            implementation(libs.kotlinx.coroutines.core)

            implementation(libs.kotlinx.serialization.json)

            implementation(libs.ksoup)
            implementation(libs.ksoup.network)

            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.logging)

            implementation(libs.sqlDelight.coroutines.extensions)
            implementation(libs.sqlDelight.coroutinesExt)
            implementation(libs.sqlDelight.runtime)

            implementation(libs.stately.common)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            implementation(kotlin("test-annotations-common"))
            implementation(kotlin("test-common"))
            implementation(libs.coroutines.test)
            implementation(libs.koin.test)
        }


        androidMain.dependencies {
            api(libs.android.sqlcipher)
            api(libs.sqlDelight.android)
            implementation(libs.androidx.activity.compose)
            implementation(libs.bundles.androidx.sqlite)
            implementation(libs.coroutines.android)
            implementation(libs.koin.android)
        }

        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.ktor.client.okhttp)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
            implementation(libs.sqlDelight.native)
        }

        jvmMain.dependencies {
            implementation(libs.appdirs)
            implementation(libs.coroutines.swing)
            implementation(libs.slf4j)
            implementation(libs.sqlDelight.jvm)
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

