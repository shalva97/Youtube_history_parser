plugins {
    kotlin("multiplatform") version "1.8.0" apply false
    kotlin("plugin.serialization") version "1.8.0" apply false
//    id("com.github.johnrengelman.shadow") version "7.1.2" // TODO also add support for jvm
    id("com.adarshr.test-logger") version "3.2.0" apply false
    id("org.jetbrains.compose") version "1.3.0" apply false
    `maven-publish`
}