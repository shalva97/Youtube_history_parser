import java.time.Duration

fun main2(args: Array<String>) {
    val listOfYTYoutubeVideos = getVideoHistoryJSON("watch-history.json")
    val videoLengthProvider = VideoLengthProvider()

    val parsedData = listOfYTYoutubeVideos
        .reversed()
        .filter { it.titleUrl != null }
        .groupBy { it.titleUrl }
        .filter { it.value.size > 10 }
        .toList()

    val timesWatchedTOP10 = parsedData.sortedByDescending { it.second.size }
        .take(10)
        .fold(Duration.ZERO) { accumulator: Duration, videoData: Pair<String?, List<YoutubeVideo>> ->
            val titleUrl = videoData.second.first().titleUrl
            if (titleUrl != null) {
                val videoDurationByURL =
                    videoLengthProvider.getVideoDurationByURL(titleUrl).multipliedBy(videoData.second.size.toLong())
                accumulator.plus(videoDurationByURL)
            } else {
                accumulator
            }
        }.run(::format)

    val totalTimeWatchedFor10Plus = parsedData.sortedByDescending { it.second.size }
        .fold(Duration.ZERO) { accumulator: Duration, videoData: Pair<String?, List<YoutubeVideo>> ->
            val titleUrl = videoData.second.first().titleUrl
            if (titleUrl != null) {
                val videoDurationByURL =
                    videoLengthProvider.getVideoDurationByURL(titleUrl).multipliedBy(videoData.second.size.toLong())
                accumulator.plus(videoDurationByURL)
            } else {
                accumulator
            }
        }.run(::format)

    println("# TOP 10")
    println("### watch time of these: $timesWatchedTOP10")

    parsedData.sortedByDescending { it.second.size }
        .take(10)
        .forEach {
            println()
            val currentVideo = it.second.first()
            println(" - [${currentVideo.title.replace("Watched ", "")} - ${it.second.size}](${currentVideo.titleUrl})")
        }

    println()
    println("total time watched for 10+ videos: $totalTimeWatchedFor10Plus")
    println()

//time    parsedData.sortedByDescending { it.second.size }
//        .fold(mutableListOf<Year>()) { acc, pair ->
//            val currentYear = acc.firstOrNull { it.year == Year.formatDateAsYear(pair.second.first().time).toInt() }
//            if (currentYear != null) {
//                currentYear.addMonth(pair.second.first(), pair.second.size)
//            } else {
//                acc.add(Year(pair.second.first(), pair.second.size))
//            }
//            acc
//        }.sortedBy {
//            it.year
//        }.forEach { year ->
//            print(year)
//        }
}

fun format(du: Duration): String {
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