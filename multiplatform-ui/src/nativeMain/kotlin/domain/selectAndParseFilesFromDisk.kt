package domain

import com.darkrockstudios.libraries.mpfilepicker.MPFile
import models.HistoryFile
import okio.FileSystem
import okio.Path.Companion.toPath

actual suspend fun MPFile<Any>.toDomainModel(): HistoryFile {
    val fileContents: String = FileSystem.SYSTEM.read(path.toPath()) { readUtf8() }
    return HistoryFile(path, fileContents)
}