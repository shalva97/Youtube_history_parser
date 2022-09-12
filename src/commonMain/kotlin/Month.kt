import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import models.VideoStatistics

class Month(video: VideoStatistics) {

    val monthName: String = getMonthName(video)
    val firstTimeWatched = getDate(video)
    private val videos: MutableList<VideoStatistics> = mutableListOf(video)

    fun addVideo(video: VideoStatistics) {
        videos.add(video)
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.appendLine("### $monthName")
        stringBuilder.appendLine()

        videos.forEach { video ->
            stringBuilder.appendLine(video)
        }

        return stringBuilder.toString()
    }

    companion object {
        fun getMonthName(video: VideoStatistics): String {
            return video.firstTimeWatched.toLocalDateTime(TimeZone.UTC).month.name
        }

        private fun getDate(video: VideoStatistics): LocalDateTime {
            return video.firstTimeWatched.toLocalDateTime(TimeZone.UTC)
        }

    }
}
