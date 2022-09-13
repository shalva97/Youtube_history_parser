package models

import kotlinx.datetime.Instant

data class VideoStatistics(
    val title: String,
    val firstTimeWatched: Instant,
    val timesClicked: Int,
    val url: String,
    val channel: Channel,
) {
    override fun toString(): String {
        return " - [${getVideoName(this)} - ${timesClicked}](${url})"
    }

    private fun getVideoName(music: VideoStatistics): String {
        return music.title.replace(VIDEO_PREFIX, "")
    }
}

data class Channel(val name: String, val url: String) {
    constructor(video: YoutubeVideo) : this(video.title, video.titleUrl!!)
}

private const val VIDEO_PREFIX = "Watched "
