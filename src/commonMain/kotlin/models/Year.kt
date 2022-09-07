package models

class Year(videos: VideoStatistics) {

    private val history: MutableList<Month> = mutableListOf()
//    val year: Int = dateFormatYear.format(videos.firstTimeWatched).toInt()

    init {
        history.add(Month(videos))
    }

//    fun addMonth(video: VideoStatistics) {
//        val currentMonth = history.firstOrNull() { it.monthName == Month.getMonthName(video) }
//
//        if (currentMonth != null) {
//            currentMonth.addVideo(video)
//        } else {
//            history.add(Month(video))
//        }
//    }

    override fun toString(): String {
        val output = StringBuilder()
//        output.appendLine("## $year")
        output.appendLine()
        history.forEach {
            output.appendLine(it)
        }
        return output.toString()
    }

    companion object {
//        fun formatDateAsYear(date: Date): String {
//            return dateFormatYear.format(date)
//        }
//
//        private val dateFormatYear = SimpleDateFormat("yyyy")
    }
}