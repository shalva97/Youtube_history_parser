package me.shalva97.di

import SettingsRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import me.shalva97.data.HistoryFilesRepository
import me.shalva97.screens.home.HomeScreenViewModel
import me.shalva97.screens.home.tabs.HistoryScreenViewModel
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