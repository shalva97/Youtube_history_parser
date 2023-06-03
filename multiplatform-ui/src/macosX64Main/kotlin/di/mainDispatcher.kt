package di

import kotlinx.coroutines.Dispatchers

actual fun mainDispatcher(): kotlinx.coroutines.CoroutineDispatcher {
    return Dispatchers.Main
}