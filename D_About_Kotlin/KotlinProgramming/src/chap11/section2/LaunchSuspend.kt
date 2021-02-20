package chap11.section2

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun doWork1(): String {
    delay(1000)
    return "Work1"
}

suspend fun doWork2(): String {
    delay(3000)
    return "Work2"
}

private fun worksInSerial() : Job {
    val job = GlobalScope.launch {
        val one = doWork1()
        val two = doWork2()

        // 1초 후, 3초 후 println 실행
        println("Kotlin One: $one")
        println("Kotlin Two: $two")
    }

    return job
}

private fun worksInParallel() : Job {
    val one = GlobalScope.async {
        doWork1()
    }

    val two = GlobalScope.async {
        doWork2()
    }

    val job = GlobalScope.launch {
        val combined = one.await() + "_" + two.await()
        println("Kotlin Combined: $combined")
    }

    return job
}

fun main() {
    runBlocking {
        val time = measureTimeMillis {
//            val job = worksInSerial()
            val job = worksInParallel()
//
//            //readLine()
//            job.join()
            job.join()
        }
        println("time: $time")
    }
}