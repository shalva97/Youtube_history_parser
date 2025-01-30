import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import models.VideoStatistics

class YearElement(video: VideoStatistics, private val minVideoClicks: Int) {
    private val _history: MutableList<MonthElement> = mutableListOf()
    val history: List<MonthElement>
        get() = _history.sortedBy { it.firstTimeWatched }
    val year: Int = formatDateAsYear(video.firstTimeWatched)

    init {
        _history.add(MonthElement(video, minVideoClicks))
    }

    fun addMonth(video: VideoStatistics) {
        val currentMonth = history.firstOrNull() { it.monthName == MonthElement.getMonthName(video) }

        if (currentMonth != null) {
            currentMonth.addVideo(video)
        } else {
            _history.add(MonthElement(video, minVideoClicks))
        }
    }

    override fun toString(): String {
        val output = StringBuilder()
        output.appendLine("## $year _ ${history.sumOf { it.totalVideosWatched }}")
        history.forEach {
            output.appendLine()
            output.append(it)
        }
        return output.toString()
    }

    companion object {
        fun formatDateAsYear(date: Instant): Int {
            return date.toLocalDateTime(TimeZone.UTC).year
        }
    }
}