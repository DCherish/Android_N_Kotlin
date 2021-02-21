package chap05.section5.protectedtest

open class Base {
    protected var i = 1
    protected fun protectedFunc() {
        i += 1
        println(i)
    }

    fun access() {
        protectedFunc()
    }

    protected class Nested // 내부 클레스에는 지시자 허용
}

class Derived : Base() {
    fun test(): Int {
        protectedFunc() // 접근 가능
        return i // 접근 가능
    }
}

fun main() {
    val base = Base() // 생성 가능
    // base.i // 접근 불가
    // base.protectedFunc() // 접근 불가
    base.access() // 접근 가능
}