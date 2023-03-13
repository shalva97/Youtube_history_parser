import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class YoutubeHistoryTest {

    @Test
    fun topTenVideos_sortingIsByMostTimesClickedVideo() {
        val top10 = YoutubeHistory(sampleData, 0).topTenVideos()

        assertTrue(top10[0].name == "Sabaton - To Hell And Back")
        assertTrue(top10[1].name == "WIND ROSE - Diggy Diggy Hole (Official Video) | Napalm Records")
        assertTrue(top10[2].name == "Happy Halloween (feat. Megumi) 【Intense Symphonic Metal Cover】")
    }

    @Test
    fun getMusicHistory_dataShouldBeSortedByYear() {
        val history = YoutubeHistory(sampleData, 0).getVideoHistory()

        assertTrue(history[0].year == 2019)
        assertTrue(history[1].year == 2020)
        assertTrue(history[2].year == 2021)
        assertTrue(history[3].year == 2022)
    }

    @Test
    fun toString_returnsAllTheYoutubeHistorySortedByYearAndMonth() {
        val history = YoutubeHistory(sampleData, 0)

        assertEquals(youtubeHistory, history.toString())
    }
}

private fun Any.println() {
    println(this)
}

private const val youtubeHistory = """# Your history of 21 video clicks

# TOP 10 Videos

 - [Sabaton - To Hell And Back - 5](https://www.youtube.com/watch?v=-2ksLxpPhc8)
 - [WIND ROSE - Diggy Diggy Hole (Official Video) | Napalm Records - 4](https://www.youtube.com/watch?v=34CZjsEI1yU)
 - [Happy Halloween (feat. Megumi) 【Intense Symphonic Metal Cover】 - 3](https://www.youtube.com/watch?v=z3lCroFnILs)
 - [一首超好聽的日語歌 -【Spirits】《 中日歌詞》 - 3](https://www.youtube.com/watch?v=5QhwXoy8CT8)
 - [Owl vision - zyborg | Music Visualization - 3](https://www.youtube.com/watch?v=HkNU0FTBYEI)
 - [How to See Time on YouTube - 2](https://www.youtube.com/watch?v=e1ru-22K1JQ)
 - [Cepheid - Gaia (feat. Nonon & Sithu Aye) - 1](https://www.youtube.com/watch?v=SZvrKO763Mc)

# TOP 10 Channels

 - [W. Hugo - 5](https://www.youtube.com/channel/UCM4GP41J2L6tl3TBlTkOdrA)
 - [Napalm Records - 4](https://www.youtube.com/channel/UCG7AaCh_CiG6pq_rRDNw72A)
 - [FalKKonE - 3](https://www.youtube.com/channel/UChAHYPBvyaQIpjyTSdQhOMQ)
 - [Kundi - 3](https://www.youtube.com/channel/UCwhpoqym25kcis9efwlvAng)
 - [Miss Hentai Music - 3](https://www.youtube.com/channel/UCxeZ8I2gwi8cnxzRMDexiIg)
 - [Howfinity - 2](https://www.youtube.com/channel/UCrSvDunJEc1CME4-KvhW_3Q)
 - [Cepheid - 1](https://www.youtube.com/channel/UCUs2Csm28An8pzmcGP2UO2Q)

# Youtube Video History

## 2019 _ 12

### SEPTEMBER _ 5

 - [Sabaton - To Hell And Back - 5](https://www.youtube.com/watch?v=-2ksLxpPhc8)

### OCTOBER _ 7

 - [WIND ROSE - Diggy Diggy Hole (Official Video) | Napalm Records - 4](https://www.youtube.com/watch?v=34CZjsEI1yU)
 - [Happy Halloween (feat. Megumi) 【Intense Symphonic Metal Cover】 - 3](https://www.youtube.com/watch?v=z3lCroFnILs)

## 2020 _ 1

### MAY _ 1

 - [Cepheid - Gaia (feat. Nonon & Sithu Aye) - 1](https://www.youtube.com/watch?v=SZvrKO763Mc)

## 2021 _ 5

### FEBRUARY _ 3

 - [Owl vision - zyborg | Music Visualization - 3](https://www.youtube.com/watch?v=HkNU0FTBYEI)

### MAY _ 2

 - [How to See Time on YouTube - 2](https://www.youtube.com/watch?v=e1ru-22K1JQ)

## 2022 _ 3

### JANUARY _ 3

 - [一首超好聽的日語歌 -【Spirits】《 中日歌詞》 - 3](https://www.youtube.com/watch?v=5QhwXoy8CT8)
"""