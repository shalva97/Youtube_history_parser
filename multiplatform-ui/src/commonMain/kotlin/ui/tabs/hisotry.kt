package ui.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.HistoryFilesRepository
import di.kodein
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.compose.localDI
import org.kodein.di.instance

@Composable
fun HistoryScreen() {

    val viewModel by localDI().instance<HistoryScreenViewModel>()

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
            .verticalScroll(scrollState)
    ) {
        Text(viewModel.markdownText.collectAsState("").value)
    }
}

class HistoryScreenViewModel : DIAware {
    override val di: DI = kodein
    private val historyFilesRepository by instance<HistoryFilesRepository>()
    val markdownText = historyFilesRepository.markdownText
}
