package chap09.section4

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val listWithNull = listOfNotNull(1, null, 3, null, 5, 6)

    println(list.map { it * 2 })

    val mapIndexed = list.mapIndexed { index, it -> index * it }
    println(mapIndexed)

    println(listWithNull.mapNotNull { it?.times(2) })
}