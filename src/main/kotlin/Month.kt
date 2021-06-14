import java.text.SimpleDateFormat

class Month(videos: List<YoutubeVideo>) {
    val monthName: String
    val musicList: MutableList<YoutubeVideoWithTimesWatched>

    init {
        val firstVideo = videos.first()
        monthName = dateFormatMonth.format(firstVideo.time)
        musicList = mutableListOf(firstVideo to videos.size)
    }

    fun addVideo(video: YoutubeVideo, timesWatched: Int) {
        musicList.add(
            video to timesWatched
        )
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()

        stringBuilder.appendLine("### $monthName")
        stringBuilder.appendLine()
        musicList.forEach { music: YoutubeVideoWithTimesWatched ->
            val name = getVideoName(music)
            stringBuilder.appendLine(" - [$name - ${music.second}](${music.first.titleUrl})")
        }
        stringBuilder.appendLine()

        return stringBuilder.toString()
    }

    private fun getVideoName(music: YoutubeVideoWithTimesWatched): String {
        return music.first.title.replace(VIDEO_PREFIX, "")
    }

    companion object {
        private val dateFormatMonth = SimpleDateFormat("MMM")
        private const val VIDEO_PREFIX = "Watched "
    }
}

typealias YoutubeVideoWithTimesWatched = Pair<YoutubeVideo, Int>
