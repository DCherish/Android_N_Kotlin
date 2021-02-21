package chap09.section4

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val listMixed = listOf(1, "Hello", 3, "World", 5, 'A')
    val listWithNull = listOf(1, null, 3, null, 5, 6)
    val listRepeated = listOf(2, 2, 3, 4, 5, 5, 6)
    val map = mapOf(11 to "Java", 22 to "Kotlin", 33 to "C++")

    println(list.filter { it % 2 == 0 }) // 짝수만 골라내기
    println(list.filterNot { it % 2 == 0 }) // 식 이외의 요소 골라내기
    println(listWithNull.filterNotNull()) // null 제외

    println("filterIndexed: " + list.filterIndexed { idx, value -> idx != 1 && value % 2 == 0 })

    val mutList = list.filterIndexedTo(mutableListOf()) { idx, value -> idx != 1 && value % 2 == 0 }
    println("filterIndexedTo: $mutList")

    println("filterKeys: " + map.filterKeys { it != 11 })
    println("filterValues: " + map.filterValues { it == "Java" || it == "C++" })

    println("filterInstance: " + listMixed.filterIsInstance<String>())

    println("slice: " + list.slice(listOf(0, 1, 2))) // 해당 index 요소 추출

    println(list.take(2))
    println(list.takeLast(2))
    println(list.takeWhile { it < 3 })

    println(list.drop(3))
    println(list.dropWhile { it < 3 })
    println(list.dropLastWhile { it > 3 })

    println("component1(): " + list.component1())

    println("distinct: " + listRepeated.distinct())
    println("intersect: " + list.intersect(listOf(5, 6, 7, 8)))
}