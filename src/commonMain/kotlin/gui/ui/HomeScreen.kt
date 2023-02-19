package gui.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gui.data.HistoryFilesRepository
import gui.di.kodein
import gui.domain.selectAndParseFilesFromDisk
import gui.models.HistoryFile
import gui.models.HomeTab
import gui.ui.tabs.DownloadsScreen
import gui.ui.tabs.HistoryScreen
import gui.ui.tabs.SettingsScreen
import gui.ui.tabs.StatsScreen
import kotlinx.coroutines.launch
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.compose.localDI
import org.kodein.di.instance

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val viewModel by localDI().instance<HomeScreenViewModel>()
    var selectedTab by remember { mutableStateOf(HomeTab.HISTORY) }
    val localScope = rememberCoroutineScope()

    Scaffold {
        Row {
            NavigationRail {
                FloatingActionButton(onClick = {
                    localScope.launch {
                        viewModel.setSelectedFiles(selectAndParseFilesFromDisk())
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
    val destinations = HomeTab.values()
    private val historyFilesRepository by instance<HistoryFilesRepository>()

    fun setSelectedFiles(files: List<HistoryFile>) {
        historyFilesRepository.selectedFiles.tryEmit(files)
    }

    override val di: DI = kodein
}
