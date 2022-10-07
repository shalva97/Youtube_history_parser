import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import models.Channel
import models.ChannelStatistics
import models.VideoStatistics
import models.YoutubeVideo

class YoutubeHistory(
    jsonData: String,
    private val minVideoClicks: Int = 10,
) {

    private val listOfYTYoutubeVideos by lazy {
        parseVideoHistoryJSON(jsonData)
    }

    private val videoStatistics: List<VideoStatistics> by lazy {
        getVideosWithMinClicks()
    }

    private fun getVideosWithMinClicks(): List<VideoStatistics> {
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
            }
    }

    fun getVideoHistory(): List<YearElement> {
        return videoStatistics.fold(mutableListOf<YearElement>()) { acc, videoStatistics ->
            val currentYear =
                acc.firstOrNull { it.year == YearElement.formatDateAsYear(videoStatistics.firstTimeWatched) }
            if (currentYear != null) {
                currentYear.addMonth(videoStatistics)
            } else {
                acc.add(YearElement(videoStatistics, minVideoClicks))
            }
            acc
        }.sortedBy {
            it.year
        }
    }

    fun topTenVideos(): List<VideoStatistics> = videoStatistics.sortedByDescending {
        it.timesClicked
    }.take(10)

    fun getTopTenChannels(): List<ChannelStatistics> {
        return listOfYTYoutubeVideos
            .map { Channel(it) }
            .groupBy { it }
            .toList()
            .map { ChannelStatistics(it.first, it.second.count()) }
            .sortedByDescending { it.videosWatched }
            .take(10)
    }

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
        val results = buildString {
            append("# TOP 10 Videos")
            appendLine()
            append(getTopTenVideos())
            appendLine()
            append("# TOP 10 Channels")
            appendLine()
            appendLine()
            getTopTenChannels().forEach {
                append(it)
                appendLine()
            }
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