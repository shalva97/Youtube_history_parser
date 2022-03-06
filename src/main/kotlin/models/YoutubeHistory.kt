package models

import VideoLengthProvider
import YoutubeVideo
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class YoutubeHistory(
    val videoLengthProvider: VideoLengthProvider = VideoLengthProvider(),
    resourcePath: String = "watch-history.json",
    val minVideoClicks: Int = 10,
) {

    private val listOfYTYoutubeVideos by lazy {
        getVideoHistoryJSON(resourcePath)
            .filter { it.titleUrl != null }
    }

    private val videoStatistics by lazy {
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
                    url = firstVideo.titleUrl!!
                )
            }.filter {
                it.timesClicked > minVideoClicks
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

    fun getTopTenVideos(): String {
        val results = StringBuilder()
        videoStatistics.sortedByDescending {
            it.timesClicked
        }.take(10).forEach {
            results.append("\n - [${it.title.replace("Watched ", "")} - ${it.timesClicked}](${it.url})")
        }
        return results.toString()
    }

    fun getMusicHistory(): String {
        val result = StringBuilder()
        videoStatistics.sortedByDescending { it.timesClicked }
            .fold(mutableListOf<Year>()) { acc, videoStatistics ->
                val currentYear =
                    acc.firstOrNull { it.year == Year.formatDateAsYear(videoStatistics.firstTimeWatched).toInt() }
                if (currentYear != null) {
                    currentYear.addMonth(videoStatistics)
                } else {
                    acc.add(Year(videoStatistics))
                }
                acc
            }.sortedBy {
                it.year
            }.forEach { year ->
                result.append(year)
            }
        return result.toString()
    }
}