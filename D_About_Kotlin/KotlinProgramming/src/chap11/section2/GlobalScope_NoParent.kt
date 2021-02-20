package chap11.section2

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    println("runBlocking: $coroutineContext")
    val request = launch {
        println("request: $coroutineContext")
        GlobalScope.launch { // 프로그램 전역으로 독립적인 수행
            println("job1: before suspend function, $coroutineContext")
            delay(1000)
            println("job1: after suspend function, $coroutineContext")
        }
        launch { // 부모의 문맥을 상속 (상위 launch 자식)
        //launch(Dispatchers.Default) { // 부모의 문맥을 상속 (상위 launch 자식, Dispatchers 적용, 문맥을 살짝 변경)
        //CoroutineScope(Dispatchers.Default).launch { // 새로운 스코프가 구성되어 request, 즉 상위 launch 무관
            delay(100)
            println("job2: before suspend function, $coroutineContext")
            delay(1000)
            println("job2: after suspend function, $coroutineContext")
        }
    }
    delay(500)
    request.cancel()
    delay(1000)
    println("end")
}