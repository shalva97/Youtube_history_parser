import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class Learning {

    @Test
    fun someRandomLearningTest() = runTest {
        val someRandomScope = CoroutineScope(Dispatchers.Default)
        val selectedFiles = MutableStateFlow(123)
        val minimumAmountOfVideoClicks = MutableStateFlow(123)

        val data = selectedFiles.combine(minimumAmountOfVideoClicks) { i: Int, i1: Int -> i + i1 }
            .onEach { println("--- before debounce") }
            .debounce(2000)
            .onEach { println("--- after debounce") }
            .map(::doSomeWork)
            .stateIn(someRandomScope, SharingStarted.Lazily, 0)

        assertEquals(60516, data.take(2).last())
        assertEquals(60516, data.first())
    }

    private fun doSomeWork(n: Int): Int {
        return n * n
    }
}