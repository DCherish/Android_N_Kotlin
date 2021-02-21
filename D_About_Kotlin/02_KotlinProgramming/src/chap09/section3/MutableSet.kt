package chap09.section3

fun main() {
    val animals = mutableSetOf("Lion", "Dog", "Cat", "Python", "Hippo")
    println(animals)

    animals.add("Dog") // 이미 존재하므로 변화 없음
    println(animals)

    animals.remove("Python")
    println(animals)
}