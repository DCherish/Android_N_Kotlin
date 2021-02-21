package chap08.section1

fun <T> find(a: Array<T>, Target: T): Int {
    for (i in a.indices) {
        if (a[i] == Target) return i
    }
    return -1
}

fun main() {
    val arr1: Array<String> = arrayOf("Apple", "Banana", "Cherry", "Durian")
    val arr2: Array<Int> = arrayOf(1, 2, 3, 4)

    println("arr1.indices ${arr1.indices}")
    println(find<String>(arr1, "Cherry"))
    println(find<Int>(arr2, 2))
}