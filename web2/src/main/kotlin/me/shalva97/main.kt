package me.shalva97

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import common.selectAndParseFilesFromDisk
import kotlinx.browser.document
import kotlinx.coroutines.launch
import me.shalva97.screens.DownloadsPage
import me.shalva97.screens.HistoryPage
import me.shalva97.screens.SettingsPage
import me.shalva97.screens.StatsPage
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {
    onWasmReady {
        Window {
            val localScope = rememberCoroutineScope()
            var selectedDestination by remember { mutableStateOf(Destinations.HISTORY) }
            val destinations = Destinations.values()
            Row {
                NavigationRail {

                    FloatingActionButton(onClick = {
                        localScope.launch {
                            val files = document.selectAndParseFilesFromDisk(".txt")
                            println(files)
                        }
                    }, shape = RoundedCornerShape(10.dp)) {
                        Icon(Icons.Filled.Add, contentDescription = "Add")
                    }

                    Spacer(Modifier.height(16.dp))

                    destinations.forEach { item ->
                        NavigationRailItem(
                            icon = { Icon(item.icon, contentDescription = item.title) },
                            label = { Text(item.title) },
                            selected = selectedDestination == item,
                            onClick = { selectedDestination = item }
                        )
                    }
                }
                when (selectedDestination) {
                    Destinations.HISTORY -> HistoryPage()
                    Destinations.STATS -> StatsPage()
                    Destinations.DOWNLOADS -> DownloadsPage()
                    Destinations.SETTINGS -> SettingsPage()
                }
            }
        }
    }
}
