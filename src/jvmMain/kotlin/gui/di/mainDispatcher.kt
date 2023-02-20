package gui.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual fun mainDispatcher(): CoroutineDispatcher = Dispatchers.Default