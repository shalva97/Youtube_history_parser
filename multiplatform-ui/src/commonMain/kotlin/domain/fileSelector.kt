package domain

import com.darkrockstudios.libraries.mpfilepicker.MPFile
import models.HistoryFile

expect suspend fun MPFile<Any>.toDomainModel(): HistoryFile