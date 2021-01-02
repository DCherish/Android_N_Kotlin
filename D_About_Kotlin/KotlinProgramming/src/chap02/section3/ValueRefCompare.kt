package chap02.section3

fun main() {
    val a: Int = 127
    val b = a

    println(a === b) // b 역시 자료형이 Int로 추론되며 값이 동일하므로 true

    val c: Int? = a
    val d: Int? = a
    val e: Int? = c
    println(c == d) // 값의 내용만 비교하는 경우
    println(c === d) // 참조 주소를 비교
    println(c === e) // 참조 주소를(참조 객체를) 비교
}