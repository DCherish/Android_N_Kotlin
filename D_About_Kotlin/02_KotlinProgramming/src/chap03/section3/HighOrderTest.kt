package chap03.section3

fun main() {
    var result: Int
    val multi = {x: Int, y: Int -> x * y}
    result = multi(10, 20)

    println(result)

    val multi2: (Int, Int) -> Int = {x: Int, y: Int ->
    println("x * y")
    x + y
    x - y
    x * y}

    println(multi2(3, 2))
}