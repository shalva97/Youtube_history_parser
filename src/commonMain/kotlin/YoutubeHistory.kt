import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import models.Channel
import models.VideoStatistics
import models.YoutubeVideo

class YoutubeHistory(
    jsonData: String,
    minVideoClicks: Int = 10,
) {

    private val listOfYTYoutubeVideos by lazy {
        parseVideoHistoryJSON(jsonData)
    }

    private val videoStatistics: List<VideoStatistics> by lazy {
        getVideosWithMinClicks(minVideoClicks)
    }

    private fun getVideosWithMinClicks(minVideoClicks: Int): List<VideoStatistics> {
        return listOfYTYoutubeVideos
            .groupBy { it.titleUrl }
            .map {
                val firstVideo = it.value.first()
                VideoStatistics(
                    title = firstVideo.title,
                    firstTimeWatched = it.value.minOf { it.time },
                    timesClicked = it.value.size,
                    url = firstVideo.titleUrl!!,
                    channel = Channel(firstVideo)
                )
            }.filter {
                it.timesClicked > minVideoClicks
            }.ifEmpty { throw NoVideoFoundException(minVideoClicks) }
    }

    fun getVideoHistory(): List<Year> {
        return videoStatistics.sortedByDescending { it.timesClicked }
            .fold(mutableListOf<Year>()) { acc, videoStatistics ->
                val currentYear =
                    acc.firstOrNull { it.year == Year.formatDateAsYear(videoStatistics.firstTimeWatched) }
                if (currentYear != null) {
                    currentYear.addMonth(videoStatistics)
                } else {
                    acc.add(Year(videoStatistics))
                }
                acc
            }.sortedBy {
                it.year
            }
    }

    fun topTenVideos(): List<VideoStatistics> = videoStatistics.sortedByDescending {
        it.timesClicked
    }.take(10)

    private fun getTopTenVideos(): String {
        val results = StringBuilder()
        topTenVideos().forEach {
            results.appendLine()
            results.append(it)
        }
        results.appendLine()
        return results.toString()
    }

    override fun toString(): String {
        val results = StringBuilder().apply {
            append("# TOP 10")
            appendLine()
            append(getTopTenVideos())
            appendLine()
            append("# Youtube Video History")
            appendLine()
            getVideoHistory().forEach {
                appendLine()
                append(it)
            }
        }

        return results.toString()
    }

    companion object {
        fun parseVideoHistoryJSON(text: String): List<YoutubeVideo> {
            val parser = Json {
                ignoreUnknownKeys = true
            }

            return parser.decodeFromString<List<YoutubeVideo>>(text)
                .filter { it.titleUrl != null }
        }
    }

}

class NoVideoFoundException(
    minVideoClicks: Int,
) : Exception("There is no video that appears $minVideoClicks times, please decrease minVideoClicks parameter")