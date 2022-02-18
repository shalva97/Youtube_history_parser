import okhttp3.OkHttpClient
import okhttp3.Request
import java.time.Duration

class VideoLengthProvider {

    private val httpClient = OkHttpClient()

    fun getVideoDurationByURL(videoUrl: String): Duration {
        val id = videoUrl.replace("https://www.youtube.com/watch?v=", "")
        return getVideoDurationByID(id)
    }

    fun getVideoDurationByID(videoID: String): Duration {
        val req = createRequest(videoID)
        val resp = httpClient.newCall(req).execute().body?.string()

        //videoDetails - lengthSeconds
        val regex = Regex("lengthSeconds.{3}([0-9].+?)\"")

        val result = regex.find(resp.toString())
        return Duration.ofSeconds(result?.groupValues?.get(1)?.toLong() ?: 0L)
    }

    private fun createRequest(videoID: String): Request {
        return Request.Builder()
            .get()
            .url("https://www.youtube.com/watch?v=$videoID")
            .build()
    }

}