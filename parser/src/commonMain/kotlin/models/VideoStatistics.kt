package models

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.minus
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.toLocalDateTime

data class VideoStatistics(
    private val title: String,
    val firstTimeWatched: Instant,
    val timesClicked: Int,
    val url: String,
    val channel: Channel,
) {
    val watchedTimeAgo: String = firstTimeWatched.toTimeAgo()
    val name: String = getVideoName(title)
    val isDeleted: Boolean = name == url

    override fun toString(): String {
        return if (isDeleted) {
            " - Deleted Video $videoID - [quiteaplaylist]($QUITE_A_PLAYLIST$url) - [Google]($GOOGLE$url) - $timesClicked"
        } else {
            " - [${name} - ${timesClicked}](${url})"
        }
    }
}

private fun Instant.toTimeAgo(): String{
    val now = Clock.System.now()
    val duration = now - this

    val years = duration.inWholeDays / 365
    val months = duration.inWholeDays / 30
    val days = duration.inWholeDays

    return buildString {
        if (years > 0) {
            append("$years year${if (years > 1) "s" else ""}")
            if (months % 12 > 0) {
                append(" and ${months % 12} month${if (months % 12 > 1) "s" else ""}")
            }
            append(" ago")
        } else if (months > 0) {
            append("$months month${if (months > 1) "s" else ""} ago")
        } else if (days > 0) {
            append("$days day${if (days > 1) "s" else ""} ago")
        } else {
            append("less than a day ago")
        }
    }
}

private val VideoStatistics.videoID
    get() = url.split('=').last()

private fun getVideoName(title: String): String = title.replace(VIDEO_PREFIX, "")

private const val VIDEO_PREFIX = "Watched "
const val QUITE_A_PLAYLIST = "https://quiteaplaylist.com/search?url="
const val GOOGLE = "https://www.google.com/search?q="
