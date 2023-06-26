import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.adarshr.test-logger")
    id("org.jetbrains.compose")
}

kotlin {
    jvm {
        val main by compilations.getting {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_11.toString()
            }
            dependencies {
                implementation(compose.desktop.macos_x64)
                implementation("com.darkrockstudios:mpfilepicker:1.0.0")
            }
        }
    }

    js(IR) {
        browser()
        binaries.executable()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("junit:junit:4.13.2")
                implementation(kotlin("test-junit"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                implementation("org.kodein.di:kodein-di-framework-compose:7.20.2")
                implementation("org.kodein.di:kodein-di:7.19.0")
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.materialIconsExtended)
                @OptIn(ExperimentalComposeLibrary::class) implementation(compose.material3)
                implementation(compose.runtime)
                implementation(project(":parser"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))
                implementation("org.jetbrains.kotlinx:kotlinx-html:0.8.1")
            }
        }
    }
}

compose.experimental {
    web.application {}
}
