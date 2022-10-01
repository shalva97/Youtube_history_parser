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

const val someRandomVideoString = """### MAY

 - [Cepheid - Gaia (feat. Nonon & Sithu Aye) - 6](https://www.youtube.com/watch?v=SZvrKO763Mc)
"""

const val anotherRandomVideoString = """### FEBRUARY

 - [Owl vision - zyborg | Music Visualization - 3](https://www.youtube.com/watch?v=HkNU0FTBYEI)
"""