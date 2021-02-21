package chap07.section2

class Outer {
    val ov = 5

    class Nested {
        val nv = 10
        fun greeting() = "[Nested] Hello! $nv" // 외부의 ov는 접근 불가

        fun accessOuter() {
            println(country)
            getSomething()
        }
    }

    fun outside() {
        val msg = Nested().greeting()
        println("[Outer]: $msg, ${Nested().nv}") // 내부의 nv는 접근 가능
    }

    companion object {
        const val country = "Korea"
        fun getSomething() = println("Get something...")
    }
}

fun main() {
    val output = Outer.Nested().greeting()
    println(output)
    Outer.Nested().accessOuter()

    // Outer.outside() // 객체 생성 필요
    // Outer().outside()

    val outer = Outer()
    outer.outside()
}