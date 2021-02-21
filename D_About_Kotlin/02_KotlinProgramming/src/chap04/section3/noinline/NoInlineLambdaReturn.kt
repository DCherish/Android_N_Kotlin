package chap04.section3.noinline

fun main() {
    retFunc()
}

fun inlineLambda(a: Int, b: Int, out: (Int, Int) -> Unit) {
    out(a, b)
}

/*fun retFunc() {
    println("start of retFunc")
    inlineLambda(13, 3) lit@{ a, b ->
        val result = a + b
        if (result > 10) return@lit
        println("result: $result")
    }
    println("end of retFunc")
}*/

/*
fun retFunc() {
    println("start of retFunc")
    inlineLambda(13, 3) { a, b ->
        val result = a + b
        if (result > 10) return@inlineLambda
        println("result: $result")
    }
    println("end of retFunc")
}*/

fun retFunc() {
    println("start of retFunc")
    inlineLambda(13, 3, fun(a, b) {
        val result = a + b
        if (result > 10) return
        println("result: $result")
    })
    println("end of retFunc")
    //greet()()
}

//fun greet() = { println("hello") }
//fun greet() = fun() { println("hello")}