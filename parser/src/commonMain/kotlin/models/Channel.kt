package models

data class Channel(val name: String, val url: String) {
    companion object {
        operator fun invoke(video: YoutubeVideo): Channel {
            val first = video.channel?.first()
            return Channel(first?.name ?: "unknown channel", first?.url ?: "unknown url")
        }
    }
}