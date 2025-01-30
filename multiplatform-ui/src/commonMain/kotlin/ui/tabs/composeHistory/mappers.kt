package ui.tabs.composeHistory

import MonthElement
import YearElement
import YoutubeHistory
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import icons.Eye
import kotlinx.coroutines.launch
import models.QUITE_A_PLAYLIST
import models.VideoStatistics

@Composable
fun YoutubeHistory.ToCompose() {

    val years = getVideoHistory()
    val pagerState = rememberPagerState { years.size }
    val coroutineScope = rememberCoroutineScope()
    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = pagerState.currentPage) {
            years.forEachIndexed { index, yearElement ->
                Tab(text = { Text(yearElement.year.toString()) },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.scrollToPage(index)
                        }
                    })
            }
        }

        HorizontalPager(
            state = pagerState,
        ) {
            years[it].ToCompose()
        }
    }
}

@Composable
fun YearElement.ToCompose() {
    val state = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(state = state)
    ) {
        history.forEach {
            it.ToCompose()
        }
    }
}

@Composable
fun MonthElement.ToCompose() {
    HorizontalDivider()
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = monthName, style = MaterialTheme.typography.headlineMedium)
        Icon(
            modifier = Modifier.padding(start = 20.dp),
            imageVector = Icons.Eye,
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = totalVideosWatched.toString(),
            style = MaterialTheme.typography.labelSmall
        )
    }
    videos.forEach {
        it.ToCompose()
    }
}

@Composable
fun VideoStatistics.ToCompose() {
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier.padding(bottom = 8.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "${channel.name} · $watchedTimeAgo",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Text(
            if (isDeleted) "Deleted Video: $url" else name,
            style = MaterialTheme.typography.titleSmall
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = Modifier, imageVector = Icons.Eye, contentDescription = null
            )
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = timesClicked.toString(),
                style = MaterialTheme.typography.labelSmall
            )
            if (isDeleted) {
                Text(
                    modifier = Modifier.padding(start = 8.dp).clickable {
                        uriHandler.openUri(QUITE_A_PLAYLIST + url)
                    },
                    text = "Search on Google",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textDecoration = TextDecoration.Underline
                )
                Text(
                    modifier = Modifier.padding(start = 8.dp).clickable {
                        uriHandler.openUri(QUITE_A_PLAYLIST + url)
                    },
                    text = "Search on Quite A Playlist",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textDecoration = TextDecoration.Underline
                )
            } else {
                Text(
                    modifier = Modifier.padding(start = 8.dp).clickable {
                        uriHandler.openUri(url)
                    },
                    text = "YouTube",
                    style = MaterialTheme.typography.labelSmall,
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}