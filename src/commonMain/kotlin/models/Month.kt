package models

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class Month(video: VideoStatistics) {

    val monthName: String = getMonthName(video)
    private val musicList: MutableList<VideoStatistics> = mutableListOf(video)

    fun addVideo(video: VideoStatistics) {
        musicList.add(video)
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.appendLine("### $monthName")
        stringBuilder.appendLine()

        musicList.forEach { music ->
            val name = getVideoName(music)
            stringBuilder.appendLine(" - [$name - ${music.timesClicked}](${music.url})")
        }

        return stringBuilder.toString()
    }

    private fun getVideoName(music: VideoStatistics): String {
        return music.title.replace(VIDEO_PREFIX, "")
    }

    companion object {
        fun getMonthName(video: VideoStatistics): String {
            return video.firstTimeWatched.toLocalDateTime(TimeZone.UTC).month.name
        }

        private const val VIDEO_PREFIX = "Watched "
    }
}
