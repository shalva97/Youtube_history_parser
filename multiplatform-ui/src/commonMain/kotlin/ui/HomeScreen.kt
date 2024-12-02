package ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.NavigationRail
import androidx.compose.material.NavigationRailItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.darkColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CopyAll
import androidx.compose.material.lightColors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import data.HistoryFilesRepository
import di.kodein
import domain.toDomainModel
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
fun App() {
    MaterialTheme(colors = if (isSystemInDarkTheme()) darkColors() else lightColors()) {
        MainScreen()
    }
}

@Composable
private fun MainScreen(modifier: Modifier = Modifier) {
    val viewModel by localDI().instance<HomeScreenViewModel>()
    var selectedTab by remember { mutableStateOf(HomeTab.HISTORY) }
    val localScope = rememberCoroutineScope()
    var isFileDialogShown by remember { mutableStateOf(false) }
    
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
                    isFileDialogShown = true
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

    FilePicker(isFileDialogShown, fileExtensions = listOf("json")) {
        isFileDialogShown = false
        localScope.launch {
            viewModel.setSelectedFiles(listOf(it?.toDomainModel() ?: return@launch))
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