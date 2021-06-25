package models

import YoutubeVideo
import java.text.SimpleDateFormat
import java.util.*

class Year(videos: YoutubeVideo, timesWatched: Int) {

    private val history: MutableList<Month> = mutableListOf()
    val year: Int = dateFormatYear.format(videos.time).toInt()

    init {
        history.add(Month(videos, timesWatched))
    }

    fun addMonth(video: YoutubeVideo, timesWatched: Int) {
        val currentMonth = history.firstOrNull() { it.monthName == Month.getMonthName(video) }

        if (currentMonth != null) {
            currentMonth.addVideo(video, timesWatched)
        } else {
            history.add(Month(video, timesWatched))
        }
    }

    override fun toString(): String {
        val output = StringBuilder()
        output.appendLine("## $year")
        output.appendLine()
        history.forEach {
            output.appendLine(it)
        }
        return output.toString()
    }

    companion object {
        fun formatDateAsYear(date: Date): String {
            return dateFormatYear.format(date)
        }

        private val dateFormatYear = SimpleDateFormat("yyyy")
    }
}