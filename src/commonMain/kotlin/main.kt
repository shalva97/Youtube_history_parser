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

//    fun getTopTenVideos(): String {
//        val results = StringBuilder()
//        topTenVideos().forEach {
//            results.append("\n - [${it.title.replace("Watched ", "")} - ${it.timesClicked}](${it.url})")
//        }
//        return results.toString()
//    }
