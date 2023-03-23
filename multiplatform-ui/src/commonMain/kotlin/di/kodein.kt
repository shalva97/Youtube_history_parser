package di

import data.HistoryFilesRepository
import data.SettingsRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.bindSingleton
import ui.HomeScreenViewModel
import ui.tabs.HistoryScreenViewModel

expect fun mainDispatcher(): CoroutineDispatcher

val kodein = DI {
    bindSingleton { SettingsRepo() }
    bindSingleton { HistoryScreenViewModel() }
    bindSingleton { HomeScreenViewModel() }
    bindSingleton { HistoryFilesRepository() }
    bindProvider(tag = DEFAULT) { Dispatchers.Default }
    bindProvider(tag = MAIN) { mainDispatcher() }
    bindProvider(tag = IO) { Dispatchers.Default }
}

const val DEFAULT = "Default"
const val MAIN = "Main"
const val IO = "IO"