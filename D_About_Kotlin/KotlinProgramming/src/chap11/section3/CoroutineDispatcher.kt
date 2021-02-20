package chap11.section3

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val jobs = arrayListOf<Job>()
    jobs += launch {
        println("launch: ${this.coroutineContext}, ${Thread.currentThread()}")
    }

    jobs += launch(Dispatchers.Default) {
        println("launch(Default): ${this.coroutineContext}, ${Thread.currentThread()}")
    }

    jobs += launch(Dispatchers.Unconfined) {
        println("launch(d_b_Unconfined): ${this.coroutineContext}, ${Thread.currentThread()}")
        delay(500)
        println("launch(d_a_Unconfined): ${this.coroutineContext}, ${Thread.currentThread()}")
    }

    jobs += launch(Dispatchers.IO) {
        println("launch(IO): ${this.coroutineContext}, ${Thread.currentThread()}")
    }

    jobs += launch(newSingleThreadContext("mythread")) {
        println("launch(new): ${this.coroutineContext}, ${Thread.currentThread()}")
    }

    jobs.forEach { it.join() }
}