import models.MarkdownResults
import models.VideoStatistics
import models.YoutubeHistory

fun main() {
    val youtubeHistory = YoutubeHistory(resourcePath = "/watch-history.json")
        .getVideosWithMinClicks(num = 10)

    val results = MarkdownResults().apply {
        add("# TOP 10")
        // TODO add time watched for top 10 videos
        add(youtubeHistory.getTopTenVideos())
        separator()
        // TODO total time watched for videos, which were clicked 10+ times
//        separator()
//        add(youtubeHistory.getMusicHistory()) TODO()
    }

    results.print()
}

//private fun List<VideoStatistics>.getMusicHistory(): String {
//    sortedByDescending { it.timesClicked }
//        .fold(mutableListOf<Year>()) { acc, videoStatistics ->
//            val currentYear =
//                acc.firstOrNull { it.year == Year.formatDateAsYear(videoStatistics.firstTimeWatched).toInt() }
//            if (currentYear != null) {
//                currentYear.addMonth(videoStatistics.second.first(), videoStatistics.second.size)
//            } else {
//                acc.add(Year(videoStatistics.second.first(), videoStatistics.second.size))
//            }
//            acc
//        }.sortedBy {
//            it.year
//        }.forEach { year ->
//            print(year)
//        }
//}

private fun List<VideoStatistics>.getTopTenVideos(): String {
    val results = StringBuilder()
    sortedByDescending {
        it.timesClicked
    }.take(10).forEach {
        results.append("\n - [${it.title.replace("Watched ", "")} - ${it.timesClicked}](${it.url})")
    }
    return results.toString()
}
