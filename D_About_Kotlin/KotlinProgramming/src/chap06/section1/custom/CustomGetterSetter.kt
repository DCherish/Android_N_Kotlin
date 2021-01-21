package chap06.section1.custom

class User(_id: Int, _name: String, _age: Int) {
    val id: Int = _id // getter O setter X // val 형식은 불변, 따라서 setId 메서드 -> 존재하지 않음
        get() = field

    var name: String = _name // getter O setter O
        set(value) {
            println("The name was changed")
            field = value.toUpperCase()
        }

    var age: Int = _age // getter O setter O
        set(value) {
            println("The value was changed")
            field = value + 10
        }
}
// 사실 내부적으로 "이미" 구현되어 있기에 결과적으로 중복 선언

fun main() {
    val user1 = User(1, "Kildong", 30)

    // user1.id = 2 // val 프로퍼티 변경 불가

    user1.name = "coco" // Setter 실행
    user1.age = 40 // Setter 실행

    println("user1.name = ${user1.name}")
    println("user1.age = ${user1.age}")
}