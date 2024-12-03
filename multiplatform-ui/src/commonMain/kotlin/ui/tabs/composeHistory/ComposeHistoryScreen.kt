package ui.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.HistoryFilesRepository
import data.HistoryFilesRepositoryState
import di.kodein
import kotlinx.coroutines.flow.StateFlow
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.compose.localDI
import org.kodein.di.instance

@Composable
fun ComposeHistoryScreen() {
    val viewModel by localDI().instance<ComposeHistoryScreenViewModel>()

    val scrollState = rememberScrollState()
    val history by viewModel.markdownText.collectAsState()
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
            .verticalScroll(scrollState)
    ) {
        when (val value = history) {
            is HistoryFilesRepositoryState.Error -> {
                Text(value.error)
            }
            HistoryFilesRepositoryState.Loading -> {
                Text("Loading...")
            }
            is HistoryFilesRepositoryState.Success -> {
                value.history
            }
        }
    }
}

class ComposeHistoryScreenViewModel : DIAware {
    override val di: DI = kodein
    private val historyFilesRepository by instance<HistoryFilesRepository>()

    val markdownText: StateFlow<HistoryFilesRepositoryState> = historyFilesRepository.history
}
