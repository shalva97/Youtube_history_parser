import java.io.File

actual fun readFrom(input: String): String {
    return File(input).readText()
}