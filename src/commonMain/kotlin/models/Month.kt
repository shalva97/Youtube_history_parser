package models

class Month(video: VideoStatistics) {

//    val monthName: String = dateFormatMonth.format(video.firstTimeWatched)
    private val musicList: MutableList<VideoStatistics> = mutableListOf(video)

    fun addVideo(video: VideoStatistics) {
        musicList.add(video)
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()

//        stringBuilder.appendLine("### $monthName")
        stringBuilder.appendLine()
        musicList.forEach { music ->
            val name = getVideoName(music)
            stringBuilder.appendLine(" - [$name - ${music.timesClicked}](${music.url})")
        }
        stringBuilder.appendLine()

        return stringBuilder.toString()
    }

    private fun getVideoName(music: VideoStatistics): String {
        return music.title.replace(VIDEO_PREFIX, "")
    }

    companion object {
        //        fun getMonthName(video: VideoStatistics): String {
//            return dateFormatMonth.format(video.firstTimeWatched)
//        }
//
//        private val dateFormatMonth = SimpleDateFormat("MMM")
        private const val VIDEO_PREFIX = "Watched "
    }
}
