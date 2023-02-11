import me.shalva97.screens.HistoryScreenViewModel
import org.kodein.di.DI
import org.kodein.di.bindSingleton

val di = DI {
    bindSingleton { SettingsRepo() }
    bindSingleton { HistoryScreenViewModel() }
}
