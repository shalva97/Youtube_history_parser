package data

import kotlinx.coroutines.flow.MutableStateFlow

class SettingsRepo {
    val minimumAmountOfVideoClicks = MutableStateFlow(10)
    val darkMode = MutableStateFlow(Theme.AUTO)

    fun setMinClicks(amount: Int) {
        minimumAmountOfVideoClicks.tryEmit(amount)
    }
}

enum class Theme {
    DARK, LIGHT, AUTO
}
