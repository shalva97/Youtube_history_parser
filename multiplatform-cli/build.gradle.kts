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
                jvmTarget = JavaVersion.VERSION_19.toString()
            }
        }
    }

    macosX64() {
        binaries
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.5")
            }
        }
        val jvmMain by getting
    }
}
