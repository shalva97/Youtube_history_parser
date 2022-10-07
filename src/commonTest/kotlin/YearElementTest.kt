import kotlin.test.Test
import kotlin.test.assertEquals

class YearElementTest {
    @Test
    fun toString_returnsCorrectText() {
        val history = YoutubeHistory(sampleData, 0).getVideoHistory()

        assertEquals(year2019, history[0].toString())
    }
}

private const val year2019 = """## 2019 | 12

### SEPTEMBER | 5

 - [Sabaton - To Hell And Back - 5](https://www.youtube.com/watch?v=-2ksLxpPhc8)

### OCTOBER | 7

 - [WIND ROSE - Diggy Diggy Hole (Official Video) | Napalm Records - 4](https://www.youtube.com/watch?v=34CZjsEI1yU)
 - [Happy Halloween (feat. Megumi) 【Intense Symphonic Metal Cover】 - 3](https://www.youtube.com/watch?v=z3lCroFnILs)
"""