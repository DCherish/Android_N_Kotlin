package chap11.section2

import kotlinx.coroutines.*
import java.util.concurrent.Executors

fun main() = runBlocking(Dispatchers.Default) {

    val threadPool = Executors.newFixedThreadPool(4)
    val MyContext = threadPool.asCoroutineDispatcher()

    println("start of runBlocking")

    launch(Dispatchers.IO) {
        delay(1200L)
        println("Task from runBlocking")
    }

    println("middle of runBlocking")

    coroutineScope {
        launch {
            delay(1500L)
            println("Task from nested launch")
        }
        delay(1000L)
        println("Task from coroutineScope")
    }

    println("end of runBlocking")
}