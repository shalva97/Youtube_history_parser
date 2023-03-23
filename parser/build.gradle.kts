import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    kotlin("multiplatform") version "1.8.0"
    kotlin("plugin.serialization") version "1.8.0"
//    id("com.github.johnrengelman.shadow") version "7.1.2" // TODO also add support for jvm
    id("com.adarshr.test-logger") version "3.2.0"
    id("org.jetbrains.compose") version "1.3.0"
    `maven-publish`
}

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    commonMainImplementation("junit:junit:4.13.2")
    commonTestImplementation(kotlin("test-junit"))
    commonMainImplementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
    commonMainImplementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
    commonMainImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    commonMainImplementation("org.kodein.di:kodein-di-framework-compose:7.18.0")
    commonMainImplementation("org.kodein.di:kodein-di:7.18.0")
    commonMainImplementation(compose.ui)
    commonMainImplementation(compose.foundation)
    commonMainImplementation(compose.materialIconsExtended)
    @OptIn(ExperimentalComposeLibrary::class) commonMainImplementation(compose.material3)
    commonMainImplementation(compose.runtime)
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
