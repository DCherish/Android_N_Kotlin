package chap02.section2

fun main() {
    println("Byte min: " + Byte.MIN_VALUE + ", Byte max: " + Byte.MAX_VALUE)
    println("Short min: " + Short.MIN_VALUE + ", Short max: " + Short.MAX_VALUE)
    println("Int min: " + Int.MIN_VALUE + ", Int max: " + Int.MAX_VALUE)
    println("Long min: " + Long.MIN_VALUE + ", Long max: " + Long.MAX_VALUE)
    println("Float min: " + Float.MIN_VALUE + ", Float max: " + Float.MAX_VALUE)
    println("Double min: " + Double.MIN_VALUE + ", Double max: " + Double.MAX_VALUE)

    var num: Double = 0.1

    for (x in 0..999) {
        num += 0.1 // num = num + 0.1
    }

    println(num)
}