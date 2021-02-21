package chap11.section3

import kotlinx.coroutines.*

fun main() = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("caught $exception")
    }

    val supervisor = SupervisorJob()
    //val supervisor = Job()

    with(CoroutineScope(coroutineContext + supervisor)) {
        val firstChild = launch(handler) {
            println("First Child is failing")
            throw kotlin.AssertionError("First child is cancelled")
        }

        val secondChild = launch {
            firstChild.join()

            println("firstChild.isCancelled: ${firstChild.isCancelled}, but second child is still active")

            try {
                delay(Long.MAX_VALUE)
            } finally {
                println("Second child is cancelled cuz supervisor is cancelled")
            }
        }
        firstChild.join()
        println("Cancelling supervisor")
        supervisor.cancel()
        secondChild.join()
    }
}