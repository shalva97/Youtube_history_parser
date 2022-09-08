import kotlin.test.Test
import kotlin.test.assertTrue


class YoutubeHistoryTest {

    @Test
    fun parseVideoHistoryJSON_doesNotReturnEmptyList() {
        val json = YoutubeHistory.parseVideoHistoryJSON(sampleData)

        assertTrue(json.isNotEmpty())
    }

    @Test
    fun topTenVideos_sortingIsByMostTimesClickedVideo() {
        val top10 = YoutubeHistory(sampleData, 0).topTenVideos()

        assertTrue(top10[0].title == "Watched Sabaton - To Hell And Back")
        assertTrue(top10[1].title == "Watched WIND ROSE - Diggy Diggy Hole (Official Video) | Napalm Records")
        assertTrue(top10[2].title == "Watched Happy Halloween (feat. Megumi) 【Intense Symphonic Metal Cover】")
    }

    @Test
    fun getMusicHistory_dataShouldBeSortedByYear() {
        val history = YoutubeHistory(sampleData, 0).getMusicHistory()

        assertTrue(history[0].year == 2019)
        assertTrue(history[1].year == 2020)
        assertTrue(history[2].year == 2021)
        assertTrue(history[3].year == 2022)
    }

}

private val year2019 = """
    ## 2019

    ### SEPTEMBER

     - [Sabaton - To Hell And Back - 5](https://www.youtube.com/watch?v=-2ksLxpPhc8)


    ### OCTOBER

     - [WIND ROSE - Diggy Diggy Hole (Official Video) | Napalm Records - 4](https://www.youtube.com/watch?v=34CZjsEI1yU)
     - [Happy Halloween (feat. Megumi) 【Intense Symphonic Metal Cover】 - 3](https://www.youtube.com/watch?v=z3lCroFnILs)

""".trimIndent()

private val output = """
    
""".trimIndent()