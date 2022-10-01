import kotlin.test.Test
import kotlin.test.assertEquals

class VideoStatisticsTest {
    @Test
    fun toString_returnsMarkdownFormattedEntry() {
        assertEquals(statisticsText, someRandomVideo.toString())
    }

    @Test
    fun toString_returnsCorrectTextWhenVideoIsDeleted() {
        assertEquals(deletedVideoText, someRandomDeletedVideo.toString())
    }

}

private const val statisticsText =
    " - [Cepheid - Gaia (feat. Nonon & Sithu Aye) - 6](https://www.youtube.com/watch?v=SZvrKO763Mc)"

private const val deletedVideoText =
    " - Deleted Video _rfxqRRN2hM - [quiteaplaylist](https://quiteaplaylist.com/search?url=https://www.youtube.com/watch?v=_rfxqRRN2hM) - [Google](https://www.google.com/search?q=https://www.youtube.com/watch?v=_rfxqRRN2hM)"