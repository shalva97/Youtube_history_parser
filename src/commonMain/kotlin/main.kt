fun main(args: Array<String>): Unit {
//    val youtubeHistory = YoutubeHistory(
//        minVideoClicks = 0
//    )

    val results = StringBuilder().apply {
        append("# TOP 10")
        appendLine()
//        append(youtubeHistory.getTopTenVideos())
        appendLine()
//        append(youtubeHistory.getMusicHistory())
    }

    println(results)
}

