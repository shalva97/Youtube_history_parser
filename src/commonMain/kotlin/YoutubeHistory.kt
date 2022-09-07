import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import models.YoutubeVideo

class YoutubeHistory(
//    resourcePath: File,
    val minVideoClicks: Int = 10,
) {

//    private val listOfYTYoutubeVideos by lazy {
//        getVideoHistoryJSON(resourcePath)
//            .filter { it.titleUrl != null }
//    }
//
//    private val videoStatistics by lazy {
//        getVideosWithMinClicks()
//    }

//    private fun getVideosWithMinClicks(): List<VideoStatistics> {
//        return listOfYTYoutubeVideos
//            .groupBy { it.titleUrl }
//            .map {
//                val firstVideo = it.value.first()
//                VideoStatistics(
//                    title = firstVideo.title,
//                    firstTimeWatched = it.value.minOf { it.time },
//                    timesClicked = it.value.size,
//                    url = firstVideo.titleUrl!!
//                )
//            }.filter {
//                it.timesClicked > minVideoClicks
//            }.ifEmpty { throw NoVideoFoundException(minVideoClicks) }
//    }
//
//
//    fun getTopTenVideos(): String {
//        val results = StringBuilder()
//        topTenVideos().forEach {
//            results.append("\n - [${it.title.replace("Watched ", "")} - ${it.timesClicked}](${it.url})")
//        }
//        return results.toString()
//    }
//
//    fun getMusicHistory(): String {
//        val result = StringBuilder()
//        videoStatistics.sortedByDescending { it.timesClicked }
//            .fold(mutableListOf<Year>()) { acc, videoStatistics ->
//                val currentYear =
//                    acc.firstOrNull { it.year == Year.formatDateAsYear(videoStatistics.firstTimeWatched).toInt() }
//                if (currentYear != null) {
//                    currentYear.addMonth(videoStatistics)
//                } else {
//                    acc.add(Year(videoStatistics))
//                }
//                acc
//            }.sortedBy {
//                it.year
//            }.forEach { year ->
//                result.append(year)
//            }
//        return result.toString()
//    }
//
//    private fun topTenVideos() = videoStatistics.sortedByDescending {
//        it.timesClicked
//    }.take(10)

    companion object {
        fun parseVideoHistoryJSON(text: String): List<YoutubeVideo> {
            val parser = Json {
                ignoreUnknownKeys = true
            }

            return parser.decodeFromString(text)
        }
    }

}

class NoVideoFoundException(
    minVideoClicks: Int,
) : Exception("There is no video that appears $minVideoClicks times, please decrease minVideoClicks parameter")