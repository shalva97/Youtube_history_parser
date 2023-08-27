package domain

import com.darkrockstudios.libraries.mpfilepicker.MPFile
import kotlinx.cinterop.ExperimentalForeignApi
import models.HistoryFile
import platform.Foundation.NSURL

@OptIn(ExperimentalForeignApi::class)
actual suspend fun MPFile<Any>.toDomainModel(): HistoryFile {
    val fileContent = (platformFile as NSURL)

//    memScoped {
//        val file = fopen(fileContent.path, "r")
//        if (file != null) {
//            val bufferSize = 1024
//            val buffer = ByteArray(bufferSize)
//
//            while (true) {
//                val bytesRead = fread(buffer.refTo(0), 1.convert(), bufferSize.convert(), file)
//                if (bytesRead <= 0u) break
//                val contentChunk = buffer.copyOfRange(0, bytesRead.toInt())
//                println(contentChunk.decodeToString())
//            }
//
//            fclose(file)
//        } else {
//            println("Failed to open the file.")
//        }
//    }
    return HistoryFile(path, "")
}