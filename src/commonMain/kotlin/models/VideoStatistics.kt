package models

import java.util.*

data class VideoStatistics(
    val title: String,
    val firstTimeWatched: Date,
    val timesClicked: Int,
    val url: String,
)