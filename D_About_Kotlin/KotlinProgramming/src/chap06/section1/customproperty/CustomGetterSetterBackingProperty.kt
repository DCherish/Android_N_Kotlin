package chap06.section1.customproperty

class User(_id: Int, _name: String, _age: Int) {
    val id: Int = _id

    private var tempName: String? = null

    var name: String = _name
        get() {
            if (tempName == null) tempName = "NONAME"
            return tempName ?: throw AssertionError("Asserted by others")
        } // return tempName null 에러 처리

    var age: Int = _age
}
// 사실 내부적으로 "이미" 구현되어 있기에 결과적으로 중복 선언

fun main() {
    val user1 = User(1, "Kildong", 30)

    user1.name = "ABC" // Setter 실행

    println("user1.name = ${user1.name}")
}