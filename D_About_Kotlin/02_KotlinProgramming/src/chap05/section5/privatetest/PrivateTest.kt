package chap05.section5.privatetest

private class PrivateClass {
    private var i = 1
    private fun privateFunc() {
        i += 1
        println(i)
    }

    fun access() {
        privateFunc()
    }
}

class OtherClass {
    // val opc = PrivateClass() // ** 접근 불가 **
    private val opc = PrivateClass() // 생성 가능
    fun test() {
        val pc = PrivateClass() // 생성 가능
    }
}
// ** WHY **
// Top-Level 함수인 main 함수 및 TopFunction 함수에서는 PrivateClass 생성 가능
// But, 분리된 기타 클래스에서는 공개적으로 생성 불가능하며
// 1. private 2. 또 다른 함수의 내부로 가리는 형태 -> 생성 가능

fun main() {
    val pc = PrivateClass() // 생성 가능
    // pc.i = 3 // 접근 불가
    // pc.privateFunc() // 접근 불가
    pc.access() // 접근 가능
}

fun TopFunction() {
    val tpc = PrivateClass() // 생성 가능
}