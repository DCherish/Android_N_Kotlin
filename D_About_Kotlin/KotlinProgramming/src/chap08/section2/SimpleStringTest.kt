package chap08.section2

fun main() {
    var deli = "Welcome to Kotlin"
    val sp = deli.split(" ")
    println(sp)
    println()

    val text = """
        |Tell me and I forget.
        |Teach me and I remember.
        |Involve me and I learn.
        |(Benjamin Franklin)
    """.trimMargin()
    println(text)
    println()

    val pi = 3.1415926535
    val dec = 10
    val s = "hello"
    println("pi = %.2f, %3d, %s".format(pi, dec, s))
}