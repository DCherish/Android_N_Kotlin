package chap06.section1

open class First {
    open val x: Int = 0
        get() {
            println("First x")
            return field
        }
    val y: Int = 0
}

class Second : First() {
    override var x: Int = 0
        get() {
            println("Second x")
            return field + 3
        }
        set(value) {
            field = value + 10
        }
    // override val y: Int = 0 // 오버라이딩 당연히 불가 (위에 open 선언되어 있지 않음)
}

fun main() {
    val second = Second()
    println(second.x)
    println(second.y)
    second.x = 3
    println(second.x) // Setter를 통하여 +10, Getter를 통하여 +3, 총 3 + 10 + 3 = 16
    println(second.y)
}