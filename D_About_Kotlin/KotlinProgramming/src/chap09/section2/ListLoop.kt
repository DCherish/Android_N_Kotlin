package chap09.section2

fun main() {
    val fruits = listOf("apple", "banana", "kiwi")
    for (item in fruits) {
        println(item)
    }

    for (index in fruits.indices) {
        println("fruits[$index] = ${fruits[index]}")
    }

    val nonNullsList: List<Int> = listOfNotNull(2, 45, null, 5, null)
    println(nonNullsList)
}