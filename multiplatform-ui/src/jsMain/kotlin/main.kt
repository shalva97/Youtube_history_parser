import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.window.Window
import di.kodein
import kotlinx.browser.window
import org.jetbrains.skiko.wasm.onWasmReady
import org.kodein.di.compose.withDI
import ui.MainScreen

fun main() {
    onWasmReady {
        Window {
            withDI(di = kodein) {
                MaterialTheme(colorScheme = preferredColorScheme()) {
                    MainScreen()
                }
            }
        }
    }
}

private fun preferredColorScheme(): ColorScheme {
    return if (window.matchMedia("(prefers-color-scheme: dark)").matches) darkColorScheme()
    else lightColorScheme()
}
