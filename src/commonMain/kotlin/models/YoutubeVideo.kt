package models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class YoutubeVideo(
//    val header: String,
//    val products: List<String>,
    val time: Instant,
    val title: String,
    val titleUrl: String? = null,
    @SerialName("subtitles")
    val channel: List<Subtitle>? = null,
)

@Serializable
data class Subtitle(
    val name: String,
    val url: String
)