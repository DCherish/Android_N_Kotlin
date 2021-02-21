package chap02.section4

fun main() {
    val number1 = 5 // 0000 ... 0101
    val number2 = -5 // 1111 ... 1011
    var y1 = 0b0100_0111_1111_1111_1111_1111_1111_1110
    var y = 0b1000_1111_1111_1111_1111_1111_1111_1100.toInt()
    var y2 = 0b1100_0111_1111_1111_1111_1111_1111_1110.toInt()

    println(number1 shr 1) // 0000 ... 0101 -> 0000 ... 0010
    println(number1 ushr 1) // 0000 ... 0101 -> 0000 ... 0010
    println(number2 shr 1) // 1111 ... 1011(2) -> 1111 ... 1101(2)
    println(number2 ushr 1) // 1111 ... 1011(2) -> 0111 ... 1101(2)

    println(y1)
    println(y ushr 1)

    println(y shr 1)
    println(y2)
}