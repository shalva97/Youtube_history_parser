package models

import kotlinx.datetime.Instant

data class VideoStatistics(
    val title: String,
    val firstTimeWatched: Instant,
    val timesClicked: Int,
    val url: String,
    val channel: Channel,
)

data class Channel(val name: String, val url: String) {
    constructor(video: YoutubeVideo) : this(video.title, video.titleUrl!!)
}