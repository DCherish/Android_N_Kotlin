package chap05.section2.secondary

class Bird {
    var name: String
    var wing: Int
    var beak: String
    var color: String

    constructor(name: String, wing: Int, beak: String, color: String) {
        this.name = name
        this.wing = wing
        this.beak = beak
        this.color = color
    }

    constructor(_name: String, _color: String) {
        name = _name
        color = _color
        wing = 2
        beak = "short"
    }

    fun fly() = println("Fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}

fun main() {
    val coco = Bird("mybird", 2, "short", "blue")
    val coco2 = Bird("mybird2","red")

    coco.color = "ash_green"
    println("coco.name: ${coco.name}")
    println("coco.color: ${coco.color}")
    coco.fly()
    coco.sing(3)

    coco2.color = "ash_blue"
    println("coco2.name: ${coco2.name}")
    println("coco2.beak: ${coco2.beak}")
    println("coco2.color: ${coco2.color}")
    coco2.fly()
    coco2.sing(4)
}