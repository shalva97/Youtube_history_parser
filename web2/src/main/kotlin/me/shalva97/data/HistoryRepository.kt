package me.shalva97.data

import kotlinx.coroutines.flow.MutableStateFlow
import models.HistoryFile

class HistoryFilesRepository {
    val selectedFileNames = mutableListOf<String>()
    val selectedFiles: MutableStateFlow<List<HistoryFile>> = MutableStateFlow(emptyList())
    val parsedHistory = ""
//    val
}