import kotlin.test.Test
import kotlin.test.assertEquals

class VideoStatisticsTest {
    @Test
    fun toString_returnsMarkdownFormattedEntry() {
        assertEquals(statisticsText, someRandomVideo.toString())
    }
}

private const val statisticsText =
    " - [Cepheid - Gaia (feat. Nonon & Sithu Aye) - 6](https://www.youtube.com/watch?v=SZvrKO763Mc)"