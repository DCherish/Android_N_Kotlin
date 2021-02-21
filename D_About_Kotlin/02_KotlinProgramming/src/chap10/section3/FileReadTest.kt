package chap10.section3

import java.io.FileReader

fun main() {
    val path = "D:\\test\\OverTheRainbow.txt"

    try {
        val read = FileReader(path)
        println(read.readText())
    } catch (e: Exception) {
        println(e.message)
    }
}