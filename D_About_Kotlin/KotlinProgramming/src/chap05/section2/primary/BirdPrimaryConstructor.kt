package chap05.section2.primary

class Bird(var name: String = "default", var wing: Int = 2, var beak: String, var color: String) {

    init {
        println("------------초기화 블록 시작------------")
        println("Name: $name, Beak: $beak")
        this.sing(3)
        println("-------------초기화 블록 끝-------------")
    }

    fun fly() = println("Fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}

/*class Bird(var name: String, var wing: Int, var beak: String, var color: String) {
    fun fly() = println("Fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}*/

/*class Bird(_name: String, _wing: Int, _beak: String, _color: String) {
    var name: String = _name
    var wing: Int = _wing
    var beak: String = _beak
    var color: String = _color

    fun fly() = println("Fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}*/

/*class Bird constructor(_name: String, _wing: Int, _beak: String, _color: String) {
    var name: String = _name
    var wing: Int = _wing
    var beak: String = _beak
    var color: String = _color

    fun fly() = println("Fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}*/

fun main() {
    val coco = Bird("mybird", 2, "short", "blue")
    val coco2 = Bird( beak = "short", color = "blue")

    coco.color = "ash_green"
    println("coco.name: ${coco.name}")
    println("coco.color: ${coco.color}")
    coco.fly()
    coco.sing(3)

    coco2.color = "ash_blue"
    println("coco2.name: ${coco2.name}")
    println("coco2.color: ${coco2.color}")
    coco.fly()
    coco.sing(4)
}