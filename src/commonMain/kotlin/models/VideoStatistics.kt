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

data class ChannelStatistics(val channel: Channel, val timesClicked: Int) {
    override fun toString(): String {
        return " - [${channel.name} - ${timesClicked}](${channel.url})"
    }
}

data class Channel(val name: String, val url: String) {
    companion object {
        operator fun invoke(video: YoutubeVideo): Channel {
            val first = video.channel?.first()
            return Channel(first?.name ?: "unknown channel", first?.url ?: "unknown url")
        }
    }
}

private const val VIDEO_PREFIX = "Watched "
