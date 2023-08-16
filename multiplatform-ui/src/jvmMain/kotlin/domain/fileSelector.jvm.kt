package domain

import com.darkrockstudios.libraries.mpfilepicker.MPFile
import models.HistoryFile
import java.io.File

actual suspend fun MPFile<Any>.toDomainModel(): HistoryFile {
    val fileContent = (platformFile as File).readText()
    return HistoryFile(path, fileContent)
}