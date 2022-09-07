import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.DurationUnit
import kotlin.time.toDuration

class Testing {

    @Test
    fun videoLengthCheck() {
        val videoLengthProvider = VideoLengthProvider()

        assertEquals(videoLengthProvider.getVideoDurationByID("072VUBj4x04"), 199.toDuration(DurationUnit.SECONDS))
        assertEquals(videoLengthProvider.getVideoDurationByID("qhnAiiWOARQ"), 36.toDuration(DurationUnit.SECONDS))
        assertEquals(videoLengthProvider.getVideoDurationByID("_Kmh4BbJPz8"), 31.toDuration(DurationUnit.SECONDS))
    }

}