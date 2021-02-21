package chap07.section1

interface Pet {
    // 추상 프로퍼티
    var category: String

    // val 선언 시 게터의 구현이 가능
    val msgTags: String
        get() = "I'm your lovely pet!"

    // 추상 프로퍼티
    var species: String

    // 추상 메서드
    fun feeding()

    // 일반 메서드
    fun patting() {
        println("Keep patting!")
    }
}

class Cat(name: String, override var category: String) : Pet, Animal(name) {
    override var species: String = "cat"

    override fun feeding() {
        println("Feed the cat a tuna can!")
    }
}

fun main() {
    val obj = Cat("miya", "small")
    println("Pet Category: ${obj.category}")
    obj.feeding()
    obj.patting()

    println("Pet Message Tags: ${obj.msgTags}")
}