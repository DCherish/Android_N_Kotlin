package chap06.section2

class LazyTest {
    init {
        println("init block")
    }

    val subject by lazy {
        println("lazy initialized")
        "Kotlin Programming"
    }
    // 외부에서 접근할 수 없게하도록 private으로 만드는 것을 추천

    fun flow() {
        println("not initialized")
        println("subject one: $subject")
        println("subject two: $subject")
    }
}

fun main() {
    val test = LazyTest()
    test.flow()
}