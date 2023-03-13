import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class Learning {

    @Test
    fun someRandomLearningTest() = runTest {
        val viewModelScope = CoroutineScope(Dispatchers.Default)
        var minClicks = 10
        var numberOfMapExecution = 0


        val mutableSharedFlow = MutableSharedFlow<Int>()
        val data = mutableSharedFlow
            .map {
                println("Doing some heavy calculations")
                numberOfMapExecution += 1
                it + 5
            }
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), 0)
            .onSubscription { println("-- subscribed") }
            .onCompletion { println("-- onCompletion") }

        val asdf = (data.take(2).first())
        val asdf1 = data.first()
        val asdf2 = data.first()
//        assertEquals(6, data.first())
//        assertEquals(6, data.first())
//        assertEquals(1, numberOfMapExecution)
        1
    }
}