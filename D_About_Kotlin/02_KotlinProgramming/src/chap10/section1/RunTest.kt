package chap10.section1

fun main() {
    data class Person(var name: String, var skills: String)
    var person = Person("Kildong", "Kotlin")
    val returnObj = person.apply {
        name = "Sean"
        skills = "Java"
        "success"
    }

    println(person)
    println("returnObj: $returnObj")

    val returnObj2 = person.run {
        name = "Dooly"
        skills = "C#"
        "success"
    }
    println(person)
    println("returnObj2: $returnObj2")
}