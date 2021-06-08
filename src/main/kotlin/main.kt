import java.text.SimpleDateFormat

fun main(args: Array<String>) {
    val dateFormatYear = SimpleDateFormat("yyyy")
    val dateFormatMonth = SimpleDateFormat("MMM")
    val listOfYTYoutubeVideos = getVideoHistoryJSON("watch-history.json")
//    val listOfYTYoutubeVideos = getVideoHistoryJSON("testData.json")


    var state: String = ""

    listOfYTYoutubeVideos
        .reversed()
        .filter { it.titleUrl != null }
        .groupBy { it.titleUrl }
        .filter { it.value.size > 10 }
        .toList()
        .sortedByDescending { it.second.size }
        .fold(mutableListOf<Year>()) { acc, pair ->
            val currentYear = acc.firstOrNull { it.yearName == dateFormatYear.format(pair.second.first().time) }
            if (currentYear != null) {
                val monthName = dateFormatMonth.format(pair.second.first().time)
                val currentMonth = currentYear.history.firstOrNull() { it.monthName == monthName }
                if (currentMonth != null) {
                    currentMonth.musicList.add(pair.second.first().also { it.timesWatched = pair.second.size })
                } else {
                    currentYear.history.add(
                        Month(
                            dateFormatMonth.format(pair.second.first().time),
                            mutableListOf(pair.second.first().also { it.timesWatched = pair.second.size })
                        )
                    )
                }
            } else {
                acc.add(
                    Year(
                        dateFormatYear.format(pair.second.first().time), mutableListOf(
                            Month(
                                dateFormatMonth.format(pair.second.first().time),
                                mutableListOf(pair.second.first().also { it.timesWatched = pair.second.size })
                            )
                        )
                    )
                )
            }
            acc
        }.sortedBy {
            it.yearName.toInt()
        }.forEach { year ->
            println("### " + year.yearName)
            println()
            year.history.forEach { month ->
                println("#### ${month.monthName}")
                println()
                month.musicList.forEach {
//                    println("${it.title} - ${it.titleUrl} ${it.timesWatched}")
                    println(" - [${it.title.replace("Watched ", "")} - ${it.timesWatched}](${it.titleUrl})")
                    println()
                }
            }
        }
//        .run(::println)
}

data class Month(
    val monthName: String,
    val musicList: MutableList<YoutubeVideo>
)

data class Year(
    val yearName: String,
    val history: MutableList<Month>
)
