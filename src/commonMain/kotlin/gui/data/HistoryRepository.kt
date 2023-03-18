package gui.data

import YoutubeHistory
import gui.di.MAIN
import gui.di.kodein
import gui.models.HistoryFile
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.instance

class HistoryFilesRepository : DIAware {
    override val di: DI = kodein
    private val settingsRepo by instance<SettingsRepo>()
    private val dispatcher by instance<CoroutineDispatcher>(tag = MAIN)
    private val historyFilesRepositoryScope = CoroutineScope(dispatcher)

    val selectedFiles: MutableStateFlow<List<HistoryFile>> = MutableStateFlow(emptyList())

    val markdownText =
        selectedFiles.combine(settingsRepo.minimumAmountOfVideoClicks, ::YoutubeHistoryParams)
            .map(::parseHistoryToMarkdown)
            .stateIn(historyFilesRepositoryScope, SharingStarted.Lazily, "")

    private fun parseHistoryToMarkdown(youtubeHistoryParams: YoutubeHistoryParams): String {
        return try {
            val first = youtubeHistoryParams.historyFiles.first() // TODO support multiple files
            YoutubeHistory(first.contents, youtubeHistoryParams.amount).toString()
        } catch (e: NoSuchElementException) {
            "No files selected"
        } catch (e: Exception) {
            e.message ?: "Unkown error"
        }
    }
}

private data class YoutubeHistoryParams(val historyFiles: List<HistoryFile>, val amount: Int)
