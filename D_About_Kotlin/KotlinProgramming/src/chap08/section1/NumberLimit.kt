package chap08.section1

class Calc<T: Number> {
    fun plus(arg1: T, arg2: T): Double {
        return arg1.toDouble() + arg2.toDouble()
    }
}

fun <T: Number> addLimit(a: T, b: T, op: (T, T) -> T) : T {
    return op(a, b)
}

fun main() {
    val calc = Calc<Int>()
    println(calc.plus(10, 20))

    val calc2 = Calc<Double>()
    val calc3 = Calc<Long>()

    //제한된 자료형으로 인해 오류 발생
    //val calc4 = Calc<String>()

    println(calc2.plus(2.5, 3.5))
    println(calc3.plus(5L, 10L))

    val result = addLimit(3L, 5L) {a, b -> a + b}
    println(result)

    //제한된 자료형으로 인해 오류 발생
    //val result2 = addLimit("abc", "def") {a, b -> a + b}
    //println(result2)
}