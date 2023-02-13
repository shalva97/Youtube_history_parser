package me.shalva97

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.window.Window
import kotlinx.browser.window
import me.shalva97.di.kodein
import me.shalva97.screens.home.HomeScreen
import org.jetbrains.skiko.wasm.onWasmReady
import org.kodein.di.compose.withDI

fun main() {
    onWasmReady {
        Window {
            withDI(di = kodein) {
                MaterialTheme(colorScheme = preferredColorScheme()) {
                    HomeScreen()
                }
            }
        }
    }
}

private fun preferredColorScheme(): ColorScheme {
    return if (window.matchMedia("(prefers-color-scheme: dark)").matches) darkColorScheme()
    else lightColorScheme()
}
