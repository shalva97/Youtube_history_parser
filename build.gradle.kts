plugins {
    kotlin("multiplatform") version "1.8.0"
    kotlin("plugin.serialization") version "1.8.0"
//    id("com.github.johnrengelman.shadow") version "7.1.2" // TODO also add support for jvm
    id("com.adarshr.test-logger") version "3.2.0"
    id("org.jetbrains.compose") version "1.3.0-rc05" apply false
}

group = "me.shalva97"
version = "2.0.4"

repositories {
    mavenCentral()
}

dependencies {
    commonMainImplementation("junit:junit:4.13.2")
    commonTestImplementation(kotlin("test-junit"))
    commonMainImplementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
    commonMainImplementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
    commonMainImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
}

kotlin {
    jvm {
        val main by compilations.getting {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }

    js(IR) {
        browser()
    }

    sourceSets {
        val commonMain by getting
    }
}