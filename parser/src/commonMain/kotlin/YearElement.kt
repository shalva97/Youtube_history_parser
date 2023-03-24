import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import models.VideoStatistics

class YearElement(video: VideoStatistics, private val minVideoClicks: Int) {

    private val history: MutableList<MonthElement> = mutableListOf()
    val year: Int = formatDateAsYear(video.firstTimeWatched)

    init {
        history.add(MonthElement(video, minVideoClicks))
    }

    fun addMonth(video: VideoStatistics) {
        val currentMonth = history.firstOrNull() { it.monthName == MonthElement.getMonthName(video) }

        if (currentMonth != null) {
            currentMonth.addVideo(video)
        } else {
            history.add(MonthElement(video, minVideoClicks))
        }
    }

    override fun toString(): String {
        val output = StringBuilder()
        output.appendLine("## $year _ ${history.sumOf { it.totalVideosWatched }}")
        history.sortedBy { it.firstTimeWatched }.forEach {
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