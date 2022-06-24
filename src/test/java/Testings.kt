import org.junit.Test
import java.time.Duration

class Testing {

    @Test
    fun `video length check`() {
        val videoLengthProvider = VideoLengthProvider()

        assert(videoLengthProvider.getVideoDurationByID("072VUBj4x04") == Duration.ofSeconds(199))
        assert(videoLengthProvider.getVideoDurationByID("qhnAiiWOARQ") == Duration.ofSeconds(36))
        assert(videoLengthProvider.getVideoDurationByID("_Kmh4BbJPz8") == Duration.ofSeconds(31))
    }

}