package chap09.section4

fun main() {
    val list1 = listOf("one", "two", "three")
    val list2 = listOf(1, 3, 4)
    val map1 = mapOf("hi" to 1, "hello" to 2, "goodbye" to 3)

    println(list1 + "four")
    println(list2 + "hello")
    println(list2 - 1)
    println(list1 - "one")
    // 요소가 list1에 추가된 것이 아니라
    // 새로운 컬렉션 생성되었다 보면 됨

    println(list1 + listOf("abc", "def"))

    println(map1 + Pair("Bye", 4))
    println(map1 - "hello")
    println(map1 + mapOf("Apple" to 4, "Orange" to 5))
    println(map1 - listOf("hi", "hello"))
}