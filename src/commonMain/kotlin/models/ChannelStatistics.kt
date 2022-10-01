package models

data class ChannelStatistics(val channel: Channel, val timesClicked: Int) {
    override fun toString(): String {
        return " - [${channel.name} - ${timesClicked}](${channel.url})"
    }
}