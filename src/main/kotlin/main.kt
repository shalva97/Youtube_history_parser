fun main(args: Array<String>) {
    val listOfYTYoutubeVideos = getVideoHistoryJSON("watch-history.json")

    val stringBuilder = StringBuilder()

    listOfYTYoutubeVideos
//        .sortedBy { it.time }
        .groupBy { it.titleUrl }
        .toList()
        .filter {
            it.first?.isNotEmpty() == true && it.second.size > 10
        }
        .forEach {
            println("${it.first} ${it.second.first().title} ${it.second.size}")

        }
//        .run(::println)

}
