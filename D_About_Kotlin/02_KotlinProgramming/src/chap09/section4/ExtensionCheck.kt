package chap09.section4

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val listOf = listOf(Pair("A", 300), Pair("B", 200), Pair("C", 100))
    val map = mapOf(11 to "Java", 22 to "Kotlin", 33 to "C++")

    println(list.all { it < 10 })
    println(list.all { it % 2 == 0 })

    println(list.any { it > 10 })
    println(list.any { it % 2 == 0 })

    println("contains: " + list.contains(2))
    println(2 in list)
    println(map.contains(11)) // key 요소를 check
    println(11 in map)

    println(map.containsValue("Java")) // key 요소를 check

    println("containsAll: " + list.containsAll(listOf(1, 2, 6)))

    println("none: " + list.none()) // 요소가 없으면 true, 있으면 false
    println("none: " + list.none { it > 6 }) // 요소가 없으면 true, 있으면 false

    println(list.isEmpty())
    println(list.isNotEmpty())
}