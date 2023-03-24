package ui.tabs

import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEvent
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.unit.dp
import data.HistoryFilesRepository
import di.kodein
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.jetbrains.skiko.SkikoPointerEvent
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.compose.localDI
import org.kodein.di.instance

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HistoryScreen() {

    val viewModel by localDI().instance<HistoryScreenViewModel>()

    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier.padding(horizontal = 16.dp).verticalScroll(scrollState)
            .onPointerEvent(PointerEventType.Scroll) {
                coroutineScope.launch {
                    scrollState.scrollBy(scrollAmount(it) ?: return@launch)
                }
            },
    ) {
        Text(viewModel.markdownText.collectAsState("").value)
    }
}

class HistoryScreenViewModel : DIAware {
    override val di: DI = kodein
    private val historyFilesRepository by instance<HistoryFilesRepository>()
    val markdownText = historyFilesRepository.markdownText
}

private fun scrollAmount(it: PointerEvent) =
    (it.nativeEvent as? SkikoPointerEvent)?.deltaY?.toFloat()
