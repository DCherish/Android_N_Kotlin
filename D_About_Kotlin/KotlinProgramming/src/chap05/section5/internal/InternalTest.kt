package chap05.section5.internal

internal class InternalClass {
    internal var i = 1
    internal fun icFunc() {
        i += 1
        println(i)
    }

    fun access() {
        icFunc()
    }
}

class Other {
    internal val ic = InternalClass()
    // 프로퍼티 지정 시 internal 맞춰야 함
    // 문제는 없지만 private 사용하기를 권장

    fun test() {
        println(ic.i) // 접근 가능
        ic.icFunc() // 접근 가능
    }
}

fun main() {
    val mic = InternalClass() // 생성 가능
    println(mic.i) // 접근 가능
    mic.icFunc() // 접근 가능
}