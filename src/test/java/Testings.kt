import org.junit.Test
import java.time.Duration

class Testing {

    private val videos = getVideoHistoryJSON("testData.json")

    @Test
    fun `resources file loads`() {
        assert(videos.isNotEmpty())
    }

    @Test
    fun `sort by most watched urls`() {
        assert(sortVideos(videos).isNotEmpty())
        assert(sortVideos(videos).size == 3)
        // TODO
    }

    @Test
    fun `video length check`() {
        val videoLengthProvider = VideoLengthProvider()

        assert(videoLengthProvider.getVideoDurationByID("072VUBj4x04") == Duration.ofSeconds(199))
        assert(videoLengthProvider.getVideoDurationByID("qhnAiiWOARQ") == Duration.ofSeconds(36))
        assert(videoLengthProvider.getVideoDurationByID("_Kmh4BbJPz8") == Duration.ofSeconds(31))
    }

}

fun sortVideos(videos: List<YoutubeVideo>): List<YoutubeVideo> {
    return videos
}