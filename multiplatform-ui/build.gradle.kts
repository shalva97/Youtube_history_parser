@file:Suppress("OPT_IN_USAGE")

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.adarshr.test-logger")
    id("org.jetbrains.compose")
}

kotlin {
    jvmToolchain(17)
    targetHierarchy.default()
    jvm()

    js(IR) {
        browser()
        binaries.executable()
    }
    macosX64 { // TODO enable macos target
        binaries {
            executable {
                entryPoint = "main"
                baseName = "google-auth-decode-$version-macosX64"
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("com.darkrockstudios:mpfilepicker:2.1.0")
                implementation("junit:junit:4.13.2")
                implementation(kotlin("test-junit"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
                implementation("org.kodein.di:kodein-di-framework-compose:7.20.2")
                implementation("org.kodein.di:kodein-di:7.21.2")
                implementation(compose.materialIconsExtended)
                implementation(compose.material3)
                implementation(project(":parser"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }

        val nativeMain by getting {
            dependencies {
                implementation("com.squareup.okio:okio:3.5.0")
            }
        }
    }
}

compose.experimental {
    web.application {}
}
