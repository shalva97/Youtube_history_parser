import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import models.YoutubeVideo
import kotlin.test.Test
import kotlin.test.assertTrue

class JSONParsingTest {

    private val parser = Json {
        ignoreUnknownKeys = true
    }

    @Test
    fun parseVideoHistoryJSON_doesNotReturnEmptyList() {
        val json = YoutubeHistory.parseVideoHistoryJSON(sampleData)

        assertTrue(json.isNotEmpty())
    }

    @Test
    fun blah() {
        parser.decodeFromString<YoutubeVideo>(brokenJSON)
        parser.decodeFromString<YoutubeVideo>(jsonWithoutUrlInSubtitles)
    }
}

const val brokenJSON = """{
  "header": "YouTube",
  "title": "Watched a video that has been removed",
  "time": "2013-11-27T23:53:04.336Z",
  "products": ["YouTube"],
  "activityControls": ["YouTube watch history"]
}"""

const val jsonWithoutUrlInSubtitles = """{
  "header": "YouTube",
  "title": "Watched Youjo senki Full OST original soundtrack 幼女戦記 スペシャルサウンドトラック",
  "titleUrl": "https://www.youtube.com/watch?v\u003dvvGvXYwQISI",
  "subtitles": [{
    "name": "OST"
  }],
  "time": "2019-01-13T21:09:51.361Z",
  "products": ["YouTube"],
  "activityControls": ["YouTube watch history"]
}"""