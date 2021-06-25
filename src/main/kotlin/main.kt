import models.Year

fun main(args: Array<String>) {
    val listOfYTYoutubeVideos = getVideoHistoryJSON("watch-history.json")

    val asdf = listOfYTYoutubeVideos
        .reversed()
        .filter { it.titleUrl != null }
        .groupBy { it.titleUrl }
        .filter { it.value.size > 10 }
        .toList()

    // print top 10 videos
    // TOP 10 x
    // 1. asdfgh - 33
    // 2. qwerty - 22
    // 3. ....
    println("# TOP 10")

    asdf.sortedByDescending { it.second.size }
        .take(10)
        .forEach {
            println()
            val currentVideo = it.second.first()
            println(" - [${currentVideo.title.replace("Watched ", "")} - ${it.second.size}](${currentVideo.titleUrl})")
        }

    asdf.sortedByDescending { it.second.size }
        .fold(mutableListOf<Year>()) { acc, pair ->
            val currentYear = acc.firstOrNull { it.year == Year.formatDateAsYear(pair.second.first().time).toInt() }
            if (currentYear != null) {
                currentYear.addMonth(pair.second.first(), pair.second.size)
            } else {
                acc.add(Year(pair.second.first(), pair.second.size))
            }
            acc
        }.sortedBy {
            it.year
        }.forEach { year ->
            print(year)
        }
}
