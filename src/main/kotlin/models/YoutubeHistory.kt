package models

import VideoLengthProvider
import YoutubeVideo
import getResourceAsText
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class YoutubeHistory(
    val videoLengthProvider: VideoLengthProvider = VideoLengthProvider(),
    resourcePath: String = "watch-history.json"
) {

    private val listOfYTYoutubeVideos by lazy {
        getVideoHistoryJSON(resourcePath)
            .filter { it.titleUrl != null }
    }

    fun getVideosWithMinClicks(num: Int = 10): List<Pair<String?, List<YoutubeVideo>>> {
        return listOfYTYoutubeVideos
            .reversed()
            .groupBy { it.titleUrl!! }
            .filter { it.value.size > num }
            .toList()
    }

    private fun getVideoHistoryJSON(path: String): List<YoutubeVideo> {
        val rawJson = javaClass.getResource(path)?.readText()
        val parser = Json {
            ignoreUnknownKeys = true
        }

        return parser.decodeFromString(rawJson ?: throw IllegalStateException("Could not parse resource"))
    }

}