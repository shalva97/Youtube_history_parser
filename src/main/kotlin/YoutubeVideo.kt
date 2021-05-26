import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.text.SimpleDateFormat
import java.util.*

@Serializable
data class YoutubeVideo(
    val header: String,
    val products: List<String>,
    @Serializable(with = DateSerializer::class)
    val time: Date,
    val title: String,
    val titleUrl: String? = null,
)

@Serializable
data class Subtitle(
    val name: String,
    val url: String
)

class DateSerializer : KSerializer<Date> {
    override fun deserialize(decoder: Decoder): Date {
        val rawData = decoder.decodeString().split("T")[0]
        return SimpleDateFormat("yyyy-MM-dd")
            .parse(rawData)
    }

    override val descriptor: SerialDescriptor = YoutubeVideo.serializer().descriptor

    override fun serialize(encoder: Encoder, value: Date) {
        TODO()
    }

}