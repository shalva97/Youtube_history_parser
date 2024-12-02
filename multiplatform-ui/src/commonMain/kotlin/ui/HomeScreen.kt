@file:OptIn(ExperimentalMaterial3Api::class)

package ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.darkColorScheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CopyAll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import data.HistoryFilesRepository
import di.kodein
import io.github.vinceglb.filekit.core.FileKit
import io.github.vinceglb.filekit.core.PickerMode
import io.github.vinceglb.filekit.core.PickerType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import models.HistoryFile
import models.HomeTab
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.compose.localDI
import org.kodein.di.instance
import ui.tabs.DownloadsScreen
import ui.tabs.HistoryScreen
import ui.tabs.SettingsScreen
import ui.tabs.StatsScreen

@Composable
fun MainScreen() {
    val viewModel by localDI().instance<HomeScreenViewModel>()
    var selectedTab by remember { mutableStateOf(HomeTab.HISTORY) }

    Scaffold(topBar = {
        TopAppBar({
            Text("Youtube History Parser")
        }, actions = {
            if (selectedTab == HomeTab.HISTORY) {
                val clipboardManager = LocalClipboardManager.current
                IconButton({
                    clipboardManager.setText(AnnotatedString(viewModel.getHistoryAsMarkdown()))
                }) {
                    Icon(Icons.Filled.CopyAll, contentDescription = "Copy all")
                }
            }
        })
    }) {
        Row(modifier = Modifier.padding(it)) {
            NavigationRail {
                FloatingActionButton(onClick = {
                    viewModel.setSelectedFiles()
                }) {
                    Icon(Icons.Filled.Add, contentDescription = "Add")
                }

                Spacer(Modifier.height(16.dp))

                viewModel.destinations.forEach { item ->
                    NavigationRailItem(icon = {
                        Icon(item.icon, contentDescription = item.title)
                    },
                        label = { Text(item.title) },
                        selected = selectedTab == item,
                        onClick = { selectedTab = item })
                }
            }
            when (selectedTab) {
                HomeTab.HISTORY -> HistoryScreen()
                HomeTab.STATS -> StatsScreen()
                HomeTab.DOWNLOADS -> DownloadsScreen()
                HomeTab.SETTINGS -> SettingsScreen()
            }
        }
    }
}

class HomeScreenViewModel : DIAware {
    val destinations = listOf(HomeTab.HISTORY, HomeTab.SETTINGS)
    private val historyFilesRepository by instance<HistoryFilesRepository>()
    private val scope = CoroutineScope(Dispatchers.Default)

    fun setSelectedFiles() = scope.launch {

        val file = FileKit.pickFile(
            type = PickerType.File(listOf("json")),
            mode = PickerMode.Single,
            title = "Pick JSON file",
        )

        historyFilesRepository.selectedFiles.tryEmit(
            listOf(
                HistoryFile(
                    fileName = file?.name ?: return@launch,
                    contents = file.readBytes().decodeToString()
                )
            )
        )
    }

    fun getHistoryAsMarkdown() = historyFilesRepository.markdownText.value

    override val di: DI = kodein
}