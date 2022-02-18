package models

import YoutubeVideo

class VideoStatistics(
   private val video: List<YoutubeVideo>
) {
    val title = video.first().title
    val firstTimeWatched = video.first().time
    val timesClicked = video.size
}