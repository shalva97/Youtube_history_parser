import models.YoutubeHistory

fun main() {
    val youtubeHistory = YoutubeHistory(resourcePath = "/watch-history.json", minVideoClicks = 10)

    val results = StringBuilder().apply {
        append("# TOP 10")
        appendLine()
        append("### " + youtubeHistory.totalTimeWatchedForTopTenVideos())
        appendLine()
        append(youtubeHistory.getTopTenVideos())
        appendLine()
        // TODO total time watched for videos, which were clicked 10+ times
//        separator()
        append(youtubeHistory.getMusicHistory())
    }

    println(results)
}
