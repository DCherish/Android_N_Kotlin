package chap08.section1.limit

open class Animal(val size: Int) {
    fun feed() = println("Feeding...")
}

class Cat(val jump: Int): Animal(50)
class Spider(val poison: Boolean): Animal(1)

// 주 생성자에서는 val만 허용
class Box<out T: Animal>(val element: T) {
//    T는 반환 자료형에만 사용이 가능함
    fun getAnimal(): T = element
//    따라서, T는 in 위치에 쓸 수 없으므로 오류 !
//    fun set(new: T) {
//        element = new
//    }
}

fun main() {
    val c1: Cat = Cat(10)
    val s1: Spider = Spider(true)

    var a1: Animal = c1
    a1 = s1
    println("a1.size = ${a1.size}")

    val c2: Box<Animal> = Box<Cat>(Cat(10))
    println("c2.element.size = ${c2.element.size}")

//    val c3: Box<Cat> = Box<Animal>(10) // 공변성, 상하관계 오류 !
//    val c4: Box<Any> = Box<Int>(10) // 자료형 제한 오류 !
}