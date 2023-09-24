package domain

import com.darkrockstudios.libraries.mpfilepicker.MPFile
import com.darkrockstudios.libraries.mpfilepicker.WebFile
import models.HistoryFile

actual suspend fun MPFile<Any>.toDomainModel(): HistoryFile {
    val contents = (this as WebFile).getFileContents()
    return HistoryFile(path, contents)
}
