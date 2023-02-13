package me.shalva97.di

import SettingsRepo
import me.shalva97.data.HistoryFilesRepository
import me.shalva97.screens.home.HomeScreenViewModel
import me.shalva97.screens.home.tabs.HistoryScreenViewModel
import org.kodein.di.DI
import org.kodein.di.bindSingleton

val kodein = DI {
    bindSingleton { SettingsRepo() }
    bindSingleton { HistoryScreenViewModel() }
    bindSingleton { HomeScreenViewModel() }
    bindSingleton { HistoryFilesRepository() }
}
