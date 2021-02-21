package chap09.section3

fun main() {
    val capitalCityMap: MutableMap<String, String> =
        mutableMapOf("Korea" to "Suwon", "China" to "Beijing", "Japan" to "Tokyo")
    println(capitalCityMap.values)
    println(capitalCityMap.keys)

    capitalCityMap.put("UK", "London")
    capitalCityMap.remove("China")
    println(capitalCityMap)

    val addData = mutableMapOf("USA" to "Washington", "France" to "Paris", "Korea" to "Seoul")
    capitalCityMap.putAll(addData)
    println(capitalCityMap)
}