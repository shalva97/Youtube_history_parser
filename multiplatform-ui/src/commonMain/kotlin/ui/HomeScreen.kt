package ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CopyAll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import data.HistoryFilesRepository
import di.kodein
import domain.selectAndParseFilesFromDisk
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val viewModel by localDI().instance<HomeScreenViewModel>()
    var selectedTab by remember { mutableStateOf(HomeTab.HISTORY) }
    val localScope = rememberCoroutineScope()

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
                    localScope.launch {
                        selectAndParseFilesFromDisk {
                            viewModel.setSelectedFiles(listOf(it))
                        }
                    }
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

    fun setSelectedFiles(files: List<HistoryFile>) {
        historyFilesRepository.selectedFiles.tryEmit(files)
    }

    fun getHistoryAsMarkdown() = historyFilesRepository.markdownText.value

    override val di: DI = kodein
}