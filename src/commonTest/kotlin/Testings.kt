import kotlin.test.Test
import kotlin.test.assertTrue


class Testing {

    @Test
    fun dateTime() {
        val json = YoutubeHistory.parseVideoHistoryJSON(sampleData)

        assertTrue(
            json.isNotEmpty()
        )
    }



}