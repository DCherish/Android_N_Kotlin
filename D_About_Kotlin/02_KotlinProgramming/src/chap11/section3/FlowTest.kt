package chap11.section3

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun foo(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(300)
        emit(i)
    }
}

fun myFlow() = flow {
    emit("One")
    emit("Two")
    delay(100)
    emit("Three")
}

fun main() = runBlocking<Unit> {
    launch {
        for (k in 1..3) {
            println("I'm not blocked $k")
            delay(300)
        }
    }

    foo().collect { value -> println(value) }

    readLine()

    myFlow().collect {
        println(it)
    }
}