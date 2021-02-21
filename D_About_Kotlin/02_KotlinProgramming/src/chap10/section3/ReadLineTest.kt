package chap10.section3

import java.util.*

fun main() {
    print("Enter: ")
    val input = readLine()!!
    println("You entered: $input")

    val reader = Scanner(System.`in`)
    var integer: Int = reader.nextInt()
    println(integer)
}