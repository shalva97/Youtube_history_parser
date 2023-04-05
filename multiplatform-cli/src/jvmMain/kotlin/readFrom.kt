import java.io.File

actual fun readFrom(input: List<String>): List<String> {
    return input.map { File(it).readText() }
}