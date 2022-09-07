plugins {
    kotlin("multiplatform") version "1.7.0"
    kotlin("plugin.serialization") version "1.6.10"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "me.shalva"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    commonMainImplementation("junit:junit:4.13.2")
    commonTestImplementation(kotlin("test-junit"))
    commonMainImplementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")
    commonMainImplementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
//    commonMainImplementation("com.squareup.okhttp3:okhttp:4.10.0") todo
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