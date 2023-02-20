import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import gui.di.kodein
import gui.ui.HomeScreen
import org.kodein.di.compose.withDI

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Youtube history",
        state = rememberWindowState(width = 700.dp, height = 400.dp)
    ) {
        withDI(di = kodein) {
            MaterialTheme(colorScheme = lightColorScheme()) {
                HomeScreen()
            }
        }
    }
}