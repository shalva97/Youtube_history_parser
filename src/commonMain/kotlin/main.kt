import models.YoutubeHistory

fun main(args: Array<String>): Unit {
    val youtubeHistory = YoutubeHistory(
        resourcePath = historyJsonFile,
        minVideoClicks = 0
    )

    val results = StringBuilder().apply {
        append("# TOP 10")
        appendLine()
        append("### " + youtubeHistory.totalTimeWatchedForTopTenVideos())
        appendLine()
        append(youtubeHistory.getTopTenVideos())
        appendLine()
        append("### " + youtubeHistory.totalTimeWatched())
        appendLine()
        append(youtubeHistory.getMusicHistory())
    }

    println(results)
}
