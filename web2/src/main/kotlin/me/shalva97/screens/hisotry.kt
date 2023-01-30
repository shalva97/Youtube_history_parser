package me.shalva97.screens

import YoutubeHistory
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.jetbrains.skiko.SkikoPointerEvent

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HistoryPage(selectedFiles: List<String>) {
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    Column(
        Modifier.padding(16.dp)
            .verticalScroll(scrollState)
            .onPointerEvent(PointerEventType.Scroll) {
                coroutineScope.launch {
                    scrollState.scrollBy((it.nativeEvent as SkikoPointerEvent).deltaY.toFloat())
                }
            }
    ) {
        if (selectedFiles.isNotEmpty()) {
            val text = try {
                YoutubeHistory(selectedFiles.first(), 10).toString()
            } catch (e: Exception) {
                e.message ?: "Unkown error"
            }
            Text(text)
        }
    }
}
