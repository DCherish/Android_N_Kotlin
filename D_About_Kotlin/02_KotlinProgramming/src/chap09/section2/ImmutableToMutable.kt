package chap09.section2

fun main() {
    val names: List<String> = listOf("one", "two", "three")
    val mutableName = names.toMutableList()
    mutableName.add("four")
    println(mutableName)
}