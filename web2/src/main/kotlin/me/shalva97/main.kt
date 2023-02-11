package me.shalva97

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import common.selectAndParseFilesFromDisk
import di
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.launch
import me.shalva97.screens.DownloadsScreen
import me.shalva97.screens.HistoryScreen
import me.shalva97.screens.SettingsScreen
import me.shalva97.screens.StatsScreen
import org.jetbrains.skiko.wasm.onWasmReady
import org.kodein.di.compose.withDI

@OptIn(ExperimentalMaterial3Api::class)
fun main() {
    onWasmReady {
        withDI(di = di) {
            Window {
                val localScope = rememberCoroutineScope()
                var selectedTab by remember { mutableStateOf(HomeTab.HISTORY) }
                val destinations = HomeTab.values()
                var selectedFiles by remember { mutableStateOf<List<String>>(emptyList()) }

                MaterialTheme(colorScheme = preferredColorScheme()) {
                    Scaffold {
                        Row {
                            NavigationRail {
                                FloatingActionButton(onClick = {
                                    localScope.launch {
                                        selectedFiles =
                                            document.selectAndParseFilesFromDisk(".json")
                                    }
                                }) {
                                    Icon(Icons.Filled.Add, contentDescription = "Add")
                                }

                                Spacer(Modifier.height(16.dp))

                                destinations.forEach { item ->
                                    NavigationRailItem(icon = {
                                        Icon(item.icon, contentDescription = item.title)
                                    },
                                        label = { Text(item.title) },
                                        selected = selectedTab == item,
                                        onClick = { selectedTab = item })
                                }
                            }
                            when (selectedTab) {
                                HomeTab.HISTORY -> HistoryScreen(selectedFiles)
                                HomeTab.STATS -> StatsScreen()
                                HomeTab.DOWNLOADS -> DownloadsScreen()
                                HomeTab.SETTINGS -> SettingsScreen()
                            }
                        }
                    }
                }
            }
        }

    }
}

private fun preferredColorScheme(): ColorScheme {
    return if (window.matchMedia("(prefers-color-scheme: dark)").matches) darkColorScheme()
    else lightColorScheme()
}
