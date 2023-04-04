import okio.FileSystem
import okio.Path.Companion.toPath

actual fun readFrom(input: List<String>): List<String> {
    return input.map(::readAllText)
}

fun readAllText(filePath: String): String {
    return FileSystem.SYSTEM.read(filePath.toPath()) { readUtf8() }
}