package chap06.section2

import kotlin.properties.Delegates

fun main() {
    var max: Int by Delegates.vetoable(0) {
        prop, old, new ->
        new > old
    }

    println(max)
    max = 10
    println(max)

    max = 5
    println(max) // 5로 낮아지지 않음

    max = 50
    println(max)
}