import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

fun getResourceAsText(path: String): String? {
    return object {}.javaClass.getResource(path)?.readText()
}

fun getVideoHistoryJSON(path: String): List<YoutubeVideo> {
    val rawJson = getResourceAsText(path)
    val parser = Json {
        ignoreUnknownKeys = true
    }

    return parser.decodeFromString(rawJson!!)
}