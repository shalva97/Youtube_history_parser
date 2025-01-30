import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import models.VideoStatistics

class MonthElement(video: VideoStatistics, private val minVideoClicks: Int = 0) {

    val monthName: String = getMonthName(video)
    val firstTimeWatched = getDate(video)
    private val _videos: MutableList<VideoStatistics> = mutableListOf(video)
    val videos: List<VideoStatistics>
        get() = _videos
            .filter { it.timesClicked > minVideoClicks }
            .sortedByDescending { it.timesClicked }
    val totalVideosWatched get() = videos.sumOf { it.timesClicked }

    fun addVideo(video: VideoStatistics) {
        _videos.add(video)
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.appendLine("### $monthName _ $totalVideosWatched")
        stringBuilder.appendLine()
        
        videos.forEach { video ->
            stringBuilder.appendLine(video)
        }

        return stringBuilder.toString()
    }

    companion object {
        fun getMonthName(video: VideoStatistics): String {
            return video.firstTimeWatched.toLocalDateTime(TimeZone.UTC).month.name.lowercase()
        }

        private fun getDate(video: VideoStatistics): LocalDateTime {
            return video.firstTimeWatched.toLocalDateTime(TimeZone.UTC)
        }

    }
}
