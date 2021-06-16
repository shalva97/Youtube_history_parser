import models.Year

fun main(args: Array<String>) {
    val listOfYTYoutubeVideos = getVideoHistoryJSON("watch-history.json")

    listOfYTYoutubeVideos
        .reversed()
        .filter { it.titleUrl != null }
        .groupBy { it.titleUrl }
        .filter { it.value.size > 10 }
        .toList()
        .sortedByDescending { it.second.size }
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
