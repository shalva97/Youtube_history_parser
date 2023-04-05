plugins {
    kotlin("multiplatform") version "1.8.10" apply false
    kotlin("plugin.serialization") version "1.8.0" apply false
    id("com.adarshr.test-logger") version "3.2.0" apply false
    id("org.jetbrains.compose") version "1.3.1" apply false
    id("com.github.johnrengelman.shadow") version "8.1.1" apply false
}

version = "2.2.1" // required for build-release.yml workflow