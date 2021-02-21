package chap06.section1

class User(val _id: Int, var name: String, var age: Int)

/*class User(_id: Int, _name: String, _age: Int) {
    val id: Int = _id // getter O setter X // val 형식은 불변, 따라서 setId 메서드 -> 존재하지 않음
    var name: String = _name // getter O setter O
    var age: Int = _age // getter O setter O
}*/

fun main() {
    val user = User(1, "Sean", 30)

    val name = user.name // Getter 실행 (getName 메서드 실행되는 원리)

    user.age = 41 // Setter 실행 (SetAge 메서드 실행되는 원리)

    println("name: $name, ${user.age}")
}