package models

data class ChannelStatistics(val channel: Channel, val videosWatched: Int) {
    override fun toString(): String {
        return " - [${channel.name} - ${videosWatched}](${channel.url})"
    }
}