plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    kotlin("plugin.serialization") version "2.1.0" apply false
    id("com.github.gmazzo.buildconfig") version "3.1.0" apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}

version = "2.2.1" // required for build-release.yml workflow