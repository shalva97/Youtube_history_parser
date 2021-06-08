import org.junit.Test

class Testing {

    private val videos = getVideoHistoryJSON("testData.json")

    @Test
    fun `resources file loads okay`() {
        assert(videos.isNotEmpty())
    }

    @Test
    fun `sort by most watched urls`() {

        assert(sortVideos(videos).isNotEmpty())
        assert(sortVideos(videos).size == 2)
    }

}

fun sortVideos(videos: List<YoutubeVideo>): List<YoutubeVideo> {
    return videos
}