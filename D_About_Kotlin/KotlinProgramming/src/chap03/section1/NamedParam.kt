package chap03.section1

fun main(args: Array<String>) {
    namedParams(x = 200, z = 100)
    namedParams(z = 150)
}

fun namedParams(x: Int = 100, y: Int = 200, z: Int) {
    println(x + y + z)
}