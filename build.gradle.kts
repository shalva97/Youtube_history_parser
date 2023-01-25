plugins {
    kotlin("multiplatform") version "1.8.0"
    kotlin("plugin.serialization") version "1.8.0"
//    id("com.github.johnrengelman.shadow") version "7.1.2" // TODO also add support for jvm
    id("com.adarshr.test-logger") version "3.2.0"
}

group = "me.shalva97"
version = "2.0.4"

repositories {
    mavenCentral()
}

dependencies {
    commonMainImplementation("junit:junit:4.13.2")
    commonTestImplementation(kotlin("test-junit"))
    commonMainImplementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")
    commonMainImplementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
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