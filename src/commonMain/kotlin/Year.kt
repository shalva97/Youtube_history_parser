import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import models.VideoStatistics

class Year(video: VideoStatistics) {

    private val history: MutableList<Month> = mutableListOf()
    val year: Int = formatDateAsYear(video.firstTimeWatched)

    init {
        history.add(Month(video))
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