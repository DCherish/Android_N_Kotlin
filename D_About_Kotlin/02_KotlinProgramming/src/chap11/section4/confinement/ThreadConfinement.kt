package chap11.section4.confinement

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

val counterContext = newSingleThreadContext("CounterContext")
var counter = 0

suspend fun massiveRun(action: suspend () -> Unit) {
    val n = 1000
    val k = 1000
    val time = measureTimeMillis {
        val jobs = List(n) {
            GlobalScope.launch {
                repeat(k) { action() }
            }
        }
        jobs.forEach { it.join() }
    }
    println("Completed ${n * k} actions in ${time}ms")
}

fun main() = runBlocking<Unit> {
    massiveRun {
        withContext(counterContext) {
            counter++
        }
    }
    println("Counter = $counter")
}
