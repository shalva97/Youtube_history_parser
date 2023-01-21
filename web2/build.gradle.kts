plugins {
    kotlin("js")
    id("org.jetbrains.compose") version "1.2.0-beta02"
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
    implementation("org.jetbrains.kotlinx:kotlinx-html:0.8.0")
    implementation(kotlin("stdlib-js"))
    implementation(rootProject)
    implementation(compose.ui)
    implementation(compose.foundation)
    implementation(compose.material)
    implementation(compose.runtime)

}

rootProject.extensions.configure<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension> {
    versions.webpackCli.version = "4.10.0"
}

compose.experimental {
    web.application {}
}

// fix warning: Task ':jsApp:jsProcessResources' uses this output of task ':common:unpackSkikoWasmRuntimeJs' ...
tasks.matching { it.name == "processResources" }.configureEach {
    inputs.dir(tasks.named<org.jetbrains.compose.experimental.web.tasks.ExperimentalUnpackSkikoWasmRuntimeTask>("unpackSkikoWasmRuntimeJs").map { it.outputDir })
}

// fix warning: Task ':jsApp:jsBrowserDevelopmentRun' uses this output of task ':common:jsDevelopmentExecutableCompileSync' ...
tasks.matching { it.name == "browserDevelopmentRun" }.configureEach {
    inputs.dir(tasks.named<Copy>("developmentExecutableCompileSync").map { it.destinationDir })
}