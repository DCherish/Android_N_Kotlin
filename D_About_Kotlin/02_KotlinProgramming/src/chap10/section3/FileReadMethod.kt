package chap10.section3

import java.io.*
import java.util.*

fun main() {
    val path = "D:\\test\\OverTheRainbow.txt"

    try {
        val read = FileReader(path)
        println(read.readText())
    } catch (e: Exception) {
        println(e.message)
    }

    println()

// #1 원문
//    val file = File(path)
//    val inputStream: InputStream = file.inputStream()
//    val inputStreamReader = InputStreamReader(inputStream)
//    val sb = StringBuilder()
//    var line: String?
//    val br = BufferedReader(inputStreamReader)
//
//    try {
//        line = br.readLine()
//        while (line != null) {
//            sb.append(line, '\n')
//            line = br.readLine()
//        }
//        println(sb)
//    } catch (e: Exception) {
//    } finally {
//        br.close()
//    }

// #2 간략화
//    val file = File(path)
//    val inputStream: InputStream = file.inputStream()
//    val text = inputStream.bufferedReader().use { it.readText() }
//    println(text)

// #3 간략화
//    val bufferReader: BufferedReader = File(path).bufferedReader()
//    val inputString = bufferReader.use { it.readText() }
//    println(inputString)

// #4 줄 단위 처리
//    val bufferReader = File(path).bufferedReader()
//    val lineList = mutableListOf<String>()
//    bufferReader.useLines { lines -> lines.forEach { lineList.add(it) } }
//    lineList.forEach { println("> " + it) }

// #5 줄 단위 처리, 간략화
    val lineList = mutableListOf<String>()
    File(path).useLines { lines -> lines.forEach { lineList.add(it) } }
    lineList.forEach { println("> " + it) }

    // File(path).copyTo(File("D:\\test\\file2.txt")) // copyTo ; 파일이 이미 있을 시 에러

    // 파일의 내용 출력하기
    File(path).forEachLine { println(it) }

    println()

    // 바이트 단위로 읽기 (쓰기는 writeBytes())
    val bytes = File(path).readBytes()
    println(Arrays.toString(bytes))

    println()

    // 줄 단위로 읽기
    val lines = File(path).readLines()
    lines.forEach { println(it) }

    println()

    // 텍스트 단위로 읽기 (쓰기는 writeText)
    val text = File(path).readText()
    println(text)
}