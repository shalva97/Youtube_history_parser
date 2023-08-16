plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.adarshr.test-logger")
    id("org.jetbrains.compose")
}

kotlin {
    jvmToolchain(17)
    jvm()

    js(IR) {
        browser()
        binaries.executable()
    }
//    macosX64 { // TODO enable macos target
//        binaries {
//            executable {
//                entryPoint = "main"
//                baseName = "google-auth-decode-$version-macosX64"
//            }
//        }
//    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("com.darkrockstudios:mpfilepicker:2.0.2")
                implementation("junit:junit:4.13.2")
                implementation(kotlin("test-junit"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                implementation("org.kodein.di:kodein-di-framework-compose:7.20.1")
                implementation("org.kodein.di:kodein-di:7.19.0")
                implementation(compose.materialIconsExtended)
                implementation(compose.material3)
//                implementation(compose.desktop.currentOs)
                implementation(project(":parser"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
            }
        }
//        val jsMain by getting {
//            dependencies {
//                implementation(kotlin("stdlib-js"))
//                implementation("org.jetbrains.kotlinx:kotlinx-html:0.8.1")
//            }
//        }
        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
    }
}

compose.experimental {
    web.application {}
}
