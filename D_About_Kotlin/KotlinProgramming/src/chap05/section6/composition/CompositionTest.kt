package chap05.section6.composition

class Car(val name: String, val power: String) {
    private var engine = Engine(power)
    // Car 클래스가 생성되는 동시에 Engine 클래스도 생성됨

    fun startEngine() = engine.start()
    fun stopEngine() = engine.stop()
}

class Engine(power: String) {
    fun start() = println("Engine has been started.")
    fun stop() = println("Engine has been stopped.")
}

fun main() {
    val car = Car("tico", "100hp")
    car.startEngine()
    car.stopEngine()
}