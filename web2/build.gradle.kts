import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension

plugins {
    kotlin("js")
    id("org.jetbrains.compose")
}

kotlin {
    js(IR) {
        browser()
        binaries.executable()
    }
    sourceSets {
        val main by getting
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven") }
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-html:0.8.1")
    implementation("org.kodein.di:kodein-di-framework-compose:7.18.0")
    implementation("org.kodein.di:kodein-di:7.18.0")
    implementation(kotlin("stdlib-js"))
    implementation(rootProject)
    implementation(compose.ui)
    implementation(compose.foundation)
    implementation(compose.materialIconsExtended)
    @OptIn(ExperimentalComposeLibrary::class) implementation(compose.material3)
    implementation(compose.runtime)

}

rootProject.extensions.configure<NodeJsRootExtension> {
    versions.webpackCli.version = "4.10.0"
}

compose.experimental {
    web.application {}
}
