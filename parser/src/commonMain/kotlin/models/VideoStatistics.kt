package models

import kotlinx.datetime.Instant

data class VideoStatistics(
    private val title: String,
    val firstTimeWatched: Instant,
    val timesClicked: Int,
    val url: String,
    val channel: Channel,
) {
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

private val VideoStatistics.videoID
    get() = url.split('=').last()

private fun getVideoName(title: String): String {
    return title.replace(VIDEO_PREFIX, "")
}

private const val VIDEO_PREFIX = "Watched "
private const val QUITE_A_PLAYLIST = "https://quiteaplaylist.com/search?url="
private const val GOOGLE = "https://www.google.com/search?q="
