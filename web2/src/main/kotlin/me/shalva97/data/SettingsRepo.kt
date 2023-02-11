import kotlinx.coroutines.flow.MutableStateFlow

class SettingsRepo {
    val minimumAmountOfVideoClicks = MutableStateFlow(10)
    val darkMode = MutableStateFlow(Theme.AUTO)

}

enum class Theme {
    DARK, LIGHT, AUTO
}