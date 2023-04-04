plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.github.johnrengelman.shadow")
    application
}

application {
    mainClass.set("MainKt")
}

version = "0.0.1"

kotlin {
    jvm {
        withJava() // Needed for application plugin to find main class
        val main by compilations.getting {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_11.toString()
            }
        }
    }

    macosX64 {
        binaries {
            executable {
                entryPoint = "main"
                baseName = "youtube-history-parser-$version-macosX64"
            }
        }
    }

    linuxX64 {
        binaries {
            executable {
                entryPoint = "main"
                baseName = "youtube-history-parser-$version-linuxX64"
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.5")
                implementation(project(":parser"))
                implementation("com.squareup.okio:okio:3.3.0")
            }
        }
        val jvmMain by getting
    }
}
