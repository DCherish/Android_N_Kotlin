package chap06.section1.normal

class User(_id: Int, _name: String, _age: Int) {
    val id: Int = _id // getter O setter X // val 형식은 불변, 따라서 setId 메서드 -> 존재하지 않음
        get() = field

    var name: String = _name // getter O setter O
        get() = field
        set(value) {
            field = value
        }

    var age: Int = _age // getter O setter O
        get() = field
        set(value) {
            field = value
        }
}
// 사실 내부적으로 "이미" 구현되어 있기에 결과적으로 중복 선언

fun main() {
    val user1 = User(1, "Kildong", 30)

    // user1.id = 2 // val 프로퍼티 변경 불가

    user1.age = 35 // Setter 실행 (SetAge 메서드 실행되는 원리)

    println("user1.age = ${user1.age}")
}