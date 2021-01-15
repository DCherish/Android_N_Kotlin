package chap05.section1.define

class Bird {
    var name: String = "default"
    var wing: Int = 2
    var beak: String = "default"
    var color: String = "default"

    fun fly() = println("Fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}

fun main() {
    val coco = Bird()
    coco.color = "ash_green"

    println("coco.color: ${coco.color}")
    coco.fly()
    coco.sing(3)
}