package chap08.section1

open class Parent

class Child: Parent()

class Cup<T>

fun main() {
    val obj: Child = Child() // 당연 OK

    // 현재 Child 클래스는 Parent 클래스를 상속 받고 있고 있음
    val obj1: Parent = Child() // 상위 클래스 객체에 하위 클래스 객체 생성 가능

    //val obj2: Child = Parent() // 오류 !

    //val obj3: Cup<Parent> = Cup<Child>() // 오류 ! 서로 아무런 관련이 없음
    //val obj4: Cup<Child> = Cup<Parent>() // 오류 !

    val obj5 = Cup<Child>()
    val obj6: Cup<Child> = obj5
}