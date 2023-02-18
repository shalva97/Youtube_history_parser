package gui.data

import gui.models.HistoryFile
import kotlinx.coroutines.flow.MutableStateFlow

class HistoryFilesRepository {
    val selectedFiles: MutableStateFlow<List<HistoryFile>> = MutableStateFlow(emptyList())
}