plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.adarshr.test-logger")
    id("com.github.gmazzo.buildconfig")
    `maven-publish`
}

kotlin {
    jvm {
        val main by compilations.getting {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_11.toString()
            }
        }
    }

    js(IR) {
        browser()
    }

    macosX64()
    linuxX64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
            }
        }
        val commonTest by getting
        val jsMain by getting
    }
}

buildConfig {
    buildConfigField("String", "APP_VERSION", provider { "\"${rootProject.version}\"" })
}