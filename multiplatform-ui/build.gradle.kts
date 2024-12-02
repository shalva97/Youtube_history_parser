import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    kotlin("plugin.serialization")
}


kotlin {
    jvm("desktop")

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        moduleName = "composeApp"
        browser {
            val rootDirPath = project.rootDir.path
            val projectDirPath = project.projectDir.path
            commonWebpackConfig {
                outputFileName = "composeApp.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(rootDirPath)
                        add(projectDirPath)
                    }
                }
            }
        }
        binaries.executable()
    }

    sourceSets {
        val desktopMain by getting

        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
        }
    }
}


compose.desktop {
    application {
        mainClass = "org.example.project.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "org.example.project"
            packageVersion = "1.0.0"
        }
    }
}

//
//kotlin {
//    jvmToolchain(17)
//    targetHierarchy.default()
//    jvm()
//
//    js(IR) {
//        browser()
//        binaries.executable()
//    }
//    macosX64 { // TODO enable macos target
//        binaries {
//            executable {
//                entryPoint = "main"
//                baseName = "google-auth-decode-$version-macosX64"
//            }
//        }
//    }
//
//    sourceSets {
//        val commonMain by getting {
//            dependencies {
//                implementation("com.darkrockstudios:mpfilepicker:2.1.0")
//                implementation("junit:junit:4.13.2")
//                implementation(kotlin("test-junit"))
//                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
//                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")
//                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
//                implementation("org.kodein.di:kodein-di-framework-compose:7.20.2")
//                implementation("org.kodein.di:kodein-di:7.20.2")
//                implementation(compose.materialIconsExtended)
//                implementation(compose.material3)
//                implementation(project(":parser"))
//            }
//        }
//        val commonTest by getting {
//            dependencies {
//                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
//            }
//        }
//
//        val jvmMain by getting {
//            dependencies {
//                implementation(compose.desktop.currentOs)
//            }
//        }
//
//        val nativeMain by getting {
//            dependencies {
//                implementation("com.squareup.okio:okio:3.5.0")
//            }
//        }
//    }
//}
//
//compose.experimental {
//    web.application {}
//}
