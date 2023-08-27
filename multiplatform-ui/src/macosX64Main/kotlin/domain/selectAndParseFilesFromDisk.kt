package domain

import com.darkrockstudios.libraries.mpfilepicker.MPFile
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.convert
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.refTo
import models.HistoryFile
import platform.Foundation.NSURL
import platform.posix.fclose
import platform.posix.fopen
import platform.posix.fread

// TODO optimize. reading a file takes too much time and program stops responding
@OptIn(ExperimentalForeignApi::class)
actual suspend fun MPFile<Any>.toDomainModel(): HistoryFile {
    val selectedFile = (platformFile as NSURL)
    var fileContents: String = ""

    memScoped {
        val file = fopen(selectedFile.path, "r")
        if (file != null) {
            val bufferSize = 1024
            val buffer = ByteArray(bufferSize)

            while (true) {
                val bytesRead = fread(buffer.refTo(0), 1.convert(), bufferSize.convert(), file)
                if (bytesRead <= 0u) break
                val contentChunk = buffer.copyOfRange(0, bytesRead.toInt())
                fileContents += contentChunk.decodeToString()
            }

            fclose(file)
        } else {
            println("Failed to open the file.")
        }
    }
    return HistoryFile(path, fileContents)
}