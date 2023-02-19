package gui.di

import gui.data.HistoryFilesRepository
import gui.data.SettingsRepo
import gui.ui.HomeScreenViewModel
import gui.ui.tabs.HistoryScreenViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.bindSingleton

val kodein = DI {
    bindSingleton { SettingsRepo() }
    bindSingleton { HistoryScreenViewModel() }
    bindSingleton { HomeScreenViewModel() }
    bindSingleton { HistoryFilesRepository() }
    bindProvider(tag = DEFAULT) { Dispatchers.Default }
    bindProvider<CoroutineDispatcher>(tag = MAIN) { Dispatchers.Main }
    bindProvider(tag = IO) { Dispatchers.Default }
}

const val DEFAULT = "Default"
const val MAIN = "Main"
const val IO = "IO"