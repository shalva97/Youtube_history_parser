package models

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class Year(videos: VideoStatistics) {

    private val history: MutableList<Month> = mutableListOf()
    val year: Int = formatDateAsYear(videos.firstTimeWatched)

    init {
        history.add(Month(videos))
    }

    fun addMonth(video: VideoStatistics) {
        val currentMonth = history.firstOrNull() { it.monthName == Month.getMonthName(video) }

        if (currentMonth != null) {
            currentMonth.addVideo(video)
        } else {
            history.add(Month(video))
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
        fun formatDateAsYear(date: Instant): Int {
            return date.toLocalDateTime(TimeZone.UTC).year
        }
    }
}