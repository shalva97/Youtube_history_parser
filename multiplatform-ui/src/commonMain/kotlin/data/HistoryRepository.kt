package data

import YoutubeHistory
import di.MAIN
import di.kodein
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import models.HistoryFile
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.instance

class HistoryFilesRepository : DIAware {
    override val di: DI = kodein
    private val settingsRepo by instance<SettingsRepo>()
    private val dispatcher by instance<CoroutineDispatcher>(tag = MAIN)
    private val historyFilesRepositoryScope = CoroutineScope(dispatcher)

    val selectedFiles: MutableStateFlow<List<HistoryFile>> = MutableStateFlow(emptyList())

    val history: StateFlow<HistoryFilesRepositoryState> = selectedFiles
        .combine(settingsRepo.minimumAmountOfVideoClicks, ::YoutubeHistoryParams)
        .map(::parseHistory)
        .stateIn(
            historyFilesRepositoryScope,
            SharingStarted.Lazily,
            HistoryFilesRepositoryState.Loading
        )

    private fun parseHistory(youtubeHistoryParams: YoutubeHistoryParams): HistoryFilesRepositoryState {
        return try {
            val first = youtubeHistoryParams.historyFiles.first() // TODO support multiple files
            HistoryFilesRepositoryState.Success(
                YoutubeHistory(
                    jsonData = first.contents,
                    minVideoClicks = youtubeHistoryParams.amount
                )
            )
        } catch (e: NoSuchElementException) {
            HistoryFilesRepositoryState.Error("No files selected")
        } catch (e: Exception) {
            HistoryFilesRepositoryState.Error(e.message ?: "Unkown error")
        }
    }
}

sealed interface HistoryFilesRepositoryState {
    data object Loading : HistoryFilesRepositoryState
    data class Error(val error: String) : HistoryFilesRepositoryState
    data class Success(val history: YoutubeHistory) : HistoryFilesRepositoryState
}

private data class YoutubeHistoryParams(val historyFiles: List<HistoryFile>, val amount: Int)
