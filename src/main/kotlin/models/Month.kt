package models

import YoutubeVideo
import java.text.SimpleDateFormat

class Month(video: YoutubeVideo, timesWatched: Int) {

    val monthName: String = dateFormatMonth.format(video.time)
    private val musicList: MutableList<YoutubeVideoWithTimesWatched> = mutableListOf(video to timesWatched)

    fun addVideo(video: YoutubeVideo, timesWatched: Int) {
        musicList.add(video to timesWatched)
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()

        stringBuilder.appendLine("### $monthName")
        stringBuilder.appendLine()
        musicList.forEach { music: YoutubeVideoWithTimesWatched ->
            val name = getVideoName(music)
            stringBuilder.appendLine(" - [$name - ${music.second}](${music.first.titleUrl})")
        }
        stringBuilder.appendLine()

        return stringBuilder.toString()
    }

    private fun getVideoName(music: YoutubeVideoWithTimesWatched): String {
        return music.first.title.replace(VIDEO_PREFIX, "")
    }

    companion object {
        fun getMonthName(video: YoutubeVideo): String {
            return dateFormatMonth.format(video.time)
        }

        private val dateFormatMonth = SimpleDateFormat("MMM")
        private const val VIDEO_PREFIX = "Watched "
    }
}

typealias YoutubeVideoWithTimesWatched = Pair<YoutubeVideo, Int>
