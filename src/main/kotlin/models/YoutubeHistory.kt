package models

import VideoLengthProvider
import YoutubeVideo
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File
import java.time.Duration

class YoutubeHistory(
    private val videoLengthProvider: VideoLengthProvider = VideoLengthProvider(),
    resourcePath: File,
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
            }.ifEmpty { throw NoVideoFoundException(minVideoClicks) }
    }

    private fun getVideoHistoryJSON(history: File): List<YoutubeVideo> {
        val rawJson = history.readText()
        val parser = Json {
            ignoreUnknownKeys = true
        }

        return parser.decodeFromString(rawJson)
    }

    fun getTopTenVideos(): String {
        val results = StringBuilder()
        topTenVideos().forEach {
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

    fun totalTimeWatchedForTopTenVideos(): String {
        return topTenVideos().fold(Duration.ZERO) { accumulator: Duration, videoData ->
            val videoDurationByURL =
                videoLengthProvider.getVideoDurationByURL(videoData.url)
                    .multipliedBy(videoData.timesClicked.toLong())
            accumulator.plus(videoDurationByURL)

        }.run(::format)
    }

    private fun topTenVideos() = videoStatistics.sortedByDescending {
        it.timesClicked
    }.take(10)

    private fun format(du: Duration): String {
        var d = du
        val days = d.toDays()
        d = d.minusDays(days)
        val hours = d.toHours()
        d = d.minusHours(hours)
        val minutes = d.toMinutes()
        d = d.minusMinutes(minutes)
        val seconds = d.seconds
        return (if (days == 0L) "" else "$days days, ") +
                (if (hours == 0L) "" else "$hours hours, ") +
                (if (minutes == 0L) "" else "$minutes minutes, ") +
                if (seconds == 0L) "" else "$seconds seconds"
    }

    fun totalTimeWatched(): String {
        return videoStatistics.sortedByDescending { it.timesClicked }
            .fold(Duration.ZERO) { accumulator: Duration, videoData ->
                val videoDurationByURL = videoLengthProvider.getVideoDurationByURL(videoData.url)
                    .multipliedBy(videoData.timesClicked.toLong())
                accumulator.plus(videoDurationByURL)
            }.run(::format)
    }
}

class NoVideoFoundException(
    minVideoClicks: Int,
) : Exception("There is no video that appears $minVideoClicks times, please decrease minVideoClicks parameter")