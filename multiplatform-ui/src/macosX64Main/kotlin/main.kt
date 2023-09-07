import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.window.Window
import di.kodein
import org.kodein.di.compose.withDI
import platform.AppKit.NSApp
import platform.AppKit.NSApplication
import ui.MainScreen

fun main() {
    NSApplication.sharedApplication()
    Window(
        title = "Youtube history",
    ) {
        withDI(di = kodein) {
            MaterialTheme(colorScheme = lightColorScheme()) {
                MainScreen()
            }
        }
    }
    NSApp?.run()
}
