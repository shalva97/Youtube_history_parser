package me.shalva97.data

import kotlinx.coroutines.flow.MutableStateFlow
import models.HistoryFile

class HistoryFilesRepository {
    val selectedFileNames = mutableListOf<String>()
    val selectedFiles = MutableStateFlow(emptyList<HistoryFile>())
    val parsedHistory = ""
//    val
}