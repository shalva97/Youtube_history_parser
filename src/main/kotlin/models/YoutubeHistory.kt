package models

import VideoLengthProvider
import YoutubeVideo
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class YoutubeHistory(
    val videoLengthProvider: VideoLengthProvider = VideoLengthProvider(),
    resourcePath: String = "watch-history.json",
) {

    private val listOfYTYoutubeVideos by lazy {
        getVideoHistoryJSON(resourcePath)
            .filter { it.titleUrl != null }
    }

    fun getVideosWithMinClicks(num: Int = 10): List<VideoStatistics> {
        return listOfYTYoutubeVideos
            .groupBy { it.titleUrl }
            .map {
                val firstVideo = it.value.first()
                VideoStatistics(
                    title = firstVideo.title,
                    firstTimeWatched = it.value.minOf { it.time },
                    timesClicked = it.value.size,
                    url = firstVideo.titleUrl!!
                )
            }
    }

    private fun getVideoHistoryJSON(path: String): List<YoutubeVideo> {
        val rawJson = javaClass.getResource(path)?.readText()
            ?: throw IllegalStateException("Could not read $path, does it exists?")
        val parser = Json {
            ignoreUnknownKeys = true
        }

        return parser.decodeFromString(rawJson)
    }

}