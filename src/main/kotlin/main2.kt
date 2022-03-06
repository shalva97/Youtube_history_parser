import models.YoutubeHistory

fun main() {
    val youtubeHistory = YoutubeHistory(resourcePath = "/watch-history.json", minVideoClicks = 10)

    val results = StringBuilder().apply {
        append("# TOP 10")
        // TODO add time watched for top 10 videos
        append(youtubeHistory.getTopTenVideos())
        appendLine()
        // TODO total time watched for videos, which were clicked 10+ times
//        separator()
        append(youtubeHistory.getMusicHistory())
    }

    println(results)
}
