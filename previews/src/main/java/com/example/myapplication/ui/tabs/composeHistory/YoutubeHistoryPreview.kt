package com.example.myapplication.ui.tabs.composeHistory

import YoutubeHistory
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.sampleData
import com.example.myapplication.ui.theme.MyApplicationTheme
import icons.Eye
import models.QUITE_A_PLAYLIST
import models.VideoStatistics
import ui.tabs.composeHistory.ToCompose

val json = YoutubeHistory(sampleData)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        json.ToCompose()
    }
}

@Preview
@Composable
fun YoutubeHistoryPreview() {
    MyApplicationTheme {
        Surface {
            json.getVideoHistory().first().history.first().videos.first().ToCompose()
        }
    }
}