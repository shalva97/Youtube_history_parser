import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.github.johnrengelman.shadow")
    application
}

application {
    mainClass.set("MainKt")
}

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
                baseName = "${rootProject.name}-${rootProject.version}-macosX64"
            }
        }
    }

    linuxX64 {
        binaries {
            executable {
                entryPoint = "main"
                baseName = "${rootProject.name}-${rootProject.version}-linuxX64"
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.6")
                implementation(project(":parser"))
                implementation("com.squareup.okio:okio:3.7.0")
            }
        }
        val jvmMain by getting
    }
}

tasks.withType<ShadowJar> {
    archiveFileName.set("${rootProject.name}-${rootProject.version}.jar")
}