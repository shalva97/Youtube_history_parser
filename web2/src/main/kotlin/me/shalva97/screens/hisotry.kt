package me.shalva97.screens

import YoutubeHistory
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun HistoryPage(selectedFiles: List<String>) {
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    Column(
        Modifier.padding(16.dp)
            .verticalScroll(scrollState)
            .draggable(orientation = Orientation.Vertical, state = rememberDraggableState { delta ->
                coroutineScope.launch {
                    scrollState.scrollBy(-delta)
                }
            })
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
