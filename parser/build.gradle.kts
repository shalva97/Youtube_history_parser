plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.adarshr.test-logger")
    id("com.github.gmazzo.buildconfig")
    `maven-publish`
}

kotlin {
    jvmToolchain(17)
    jvm()

    js(IR) {
        browser()
    }

    macosX64()
    linuxX64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")
            }
        }
    }
}

buildConfig {
    buildConfigField("String", "APP_VERSION", provider { "\"${rootProject.version}\"" })
}