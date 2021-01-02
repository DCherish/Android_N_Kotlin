package chap02.section4

fun main() {
    val num = 4

    println(num.shl(2)) // 0100(2) -> 0001 0000(2)
    println(num shl 2) // 중위 표현법 (infix)

    println(num.shr(2)) // 0100(2) -> 0001(2)
    println(num shr 2)
    println(num ushr 2) // 0100(2) -> 0001(2)

    val m_num = -4

    println(m_num.shl(2)) // 1111 1111 .... 1111 1100(2) -> 1111 1111 .... 1111 0000(2)
    println(m_num shl 2) // 중위 표현법 (infix)

    println(m_num.shr(2)) // 1111 1111 .... 1111 1100(2) -> 1111 1111 .... 1111 1111(2)
    println(m_num shr 2)
    println(m_num ushr 2) // 1111 1111 .... 1111 1100(2) -> 0011 1111 .... 1111 1111(2)

    val m_num2 = -16

    println(m_num2.shl(1)) // 1111 1111 .... 1111 0000(2) -> 1111 1111 .... 1110 0000(2)
    println(m_num2 shl 1) // 중위 표현법 (infix)

    println(m_num2.shr(1)) // 1111 1111 .... 1111 0000(2) -> 1111 1111 .... 1111 1000(2)
    println(m_num2 shr 1)
    println(m_num2 ushr 1) // 1111 1111 .... 1111 0000(2) -> 0111 1111 .... 1111 1000(2)
}