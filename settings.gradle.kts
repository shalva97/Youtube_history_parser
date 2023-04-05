rootProject.name = "Youtube-history-parser"
include("multiplatform-ui")
include("parser")
include("multiplatform-cli")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}