import kotlinx.datetime.Instant
import models.Channel
import models.VideoStatistics
import kotlin.test.Test
import kotlin.test.assertEquals

class MonthTest {
    @Test
    fun toString_returnsCorrectText() {

        val month = Month(someRandomVideo)
        assertEquals(someRandomVideoString, month.toString())

        val month2 = Month(anotherRandomVideo)
        assertEquals(anotherRandomVideoString, month2.toString())
    }
}

val someRandomVideo = VideoStatistics(
    title = "Watched Cepheid - Gaia (feat. Nonon & Sithu Aye)",
    firstTimeWatched = Instant.parse("2020-05-14T15:48:29.760Z"),
    timesClicked = 6,
    url = "https://www.youtube.com/watch?v=SZvrKO763Mc",
    channel = Channel(
        name = "Watched Cepheid -Gaia(feat.Nonon & Sithu Aye)",
        url = "https://www.youtube.com/watch?v=SZvrKO763Mc"
    )
)

const val someRandomVideoString = """### MAY

 - [Cepheid - Gaia (feat. Nonon & Sithu Aye) - 6](https://www.youtube.com/watch?v=SZvrKO763Mc)
"""

val anotherRandomVideo = VideoStatistics(
    title = "Watched Owl vision - zyborg | Music Visualization",
    firstTimeWatched = Instant.parse("2021-02-13T19:52:45.459Z"),
    timesClicked = 3,
    url = "https://www.youtube.com/watch?v=HkNU0FTBYEI",
    channel = Channel(
        name = "Watched Owl vision - zyborg | Music Visualization",
        url = "https://www.youtube.com/watch?v=HkNU0FTBYEI"
    )
)

const val anotherRandomVideoString = """### FEBRUARY

 - [Owl vision - zyborg | Music Visualization - 3](https://www.youtube.com/watch?v=HkNU0FTBYEI)
"""