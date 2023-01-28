package me.shalva97

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
            var selectedFiles by remember { mutableStateOf<List<String>>(emptyList()) }
            Row {
                NavigationRail {
                    FloatingActionButton(onClick = {
                        localScope.launch {
                            selectedFiles = document.selectAndParseFilesFromDisk(".json")
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
                    Destinations.HISTORY -> HistoryPage(selectedFiles)
                    Destinations.STATS -> StatsPage()
                    Destinations.DOWNLOADS -> DownloadsPage()
                    Destinations.SETTINGS -> SettingsPage()
                }
            }
        }
    }
}

fun main1() {

    @Composable
    fun TextBox(text: String = "Item") {
        Box(
            modifier = Modifier.height(32.dp)
                .width(400.dp)
                .background(color = Color(200, 0, 0, 20))
                .padding(start = 10.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(text = text)
        }
    }

    onWasmReady {
        Window {
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(color = Color(180, 180, 180))
                    .padding(10.dp)
            ) {
                val stateVertical = rememberScrollState(0)
                val stateHorizontal = rememberScrollState(0)

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(stateVertical)
                        .padding(end = 12.dp, bottom = 12.dp)
                        .horizontalScroll(stateHorizontal)
                ) {
                    Column {
                        for (item in 0..30) {
                            TextBox("Item #$item")
                            if (item < 30) {
                                Spacer(modifier = Modifier.height(5.dp))
                            }
                        }
                    }
                }
                VerticalScrollbar(
                    modifier = Modifier.align(Alignment.CenterEnd)
                        .width(16.dp)
                        .fillMaxHeight(),
                    adapter = rememberScrollbarAdapter(stateVertical)
                )
                HorizontalScrollbar(
                    modifier = Modifier.align(Alignment.BottomStart)
                        .fillMaxWidth()
                        .padding(end = 12.dp),
                    adapter = rememberScrollbarAdapter(stateHorizontal)
                )
            }
        }
    }

}