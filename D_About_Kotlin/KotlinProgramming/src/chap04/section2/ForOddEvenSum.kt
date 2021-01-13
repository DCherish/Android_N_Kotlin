package chap04.section2

fun main() {
    var total: Int = 0

    println("Odd numbers")
    for (num in 1..100 step 2) {
        print("$num ")
    }
    println()

    println("Even numbers")
    for (num in 0..99 step 2) {
        print("$num ")
    }
    println()

    for (num in 1..100 step 2) total += num
    println("Odd total: $total")

    total = 0

    for (num in 0..99 step 2) total += num
    println("Even total: $total")
}