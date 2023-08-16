package domain

import com.darkrockstudios.libraries.mpfilepicker.MPFile
import com.darkrockstudios.libraries.mpfilepicker.WebFile
import models.HistoryFile

actual suspend fun MPFile<Any>.toDomainModel(): HistoryFile {
    return HistoryFile(path, (platformFile as WebFile).getFileContents())
}