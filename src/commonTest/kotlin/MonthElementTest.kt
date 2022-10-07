import kotlin.test.Test
import kotlin.test.assertEquals

class MonthElementTest {
    @Test
    fun toString_returnsCorrectText() {

        val month = MonthElement(someRandomVideo)
        assertEquals(someRandomVideoString, month.toString())

        val month2 = MonthElement(anotherRandomVideo)
        assertEquals(anotherRandomVideoString, month2.toString())
    }
}

const val someRandomVideoString = """### MAY

 - [Cepheid - Gaia (feat. Nonon & Sithu Aye) - 6](https://www.youtube.com/watch?v=SZvrKO763Mc)
"""

const val anotherRandomVideoString = """### FEBRUARY

 - [Owl vision - zyborg | Music Visualization - 3](https://www.youtube.com/watch?v=HkNU0FTBYEI)
"""