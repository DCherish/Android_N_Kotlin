package chap02.section3

fun main() {
    val num = 256

    if (num is Int) {
        println(num)
    } else if (num !is Int) {
        println("Not a Int")
    }

    var temp: Any = 1
    temp = 20L

    if (temp is Int) {
        println("This is Int: $temp")
    } else if (temp is Long) {
        println("This is Long: $temp")
    }

    var x: Any = 123
    println("$x")

    x = 120L
    println("$x")

    x += 12.2f
    println("$x")

    x += 14.4
    println("$x")

    x = 4
    println("$x")
}