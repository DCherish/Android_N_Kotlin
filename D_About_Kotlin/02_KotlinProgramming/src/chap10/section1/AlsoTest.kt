package chap10.section1

fun main() {
    data class Person(var name: String, var skills: String)
    val person = Person("Kildong", "Kotlin")

    val a = person.let {
        it.skills = "Android"
        "success"
    }
    println(person)
    println("a: $a")

    val b = person.also {
        it.skills = "Java"
        "success" // 실행되지 않음
    }
    println(person)
    println("b: $b") // person 반환됨
}