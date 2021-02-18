package chap10.section3

import java.io.File
import java.io.PrintWriter

fun main() {
    val outString: String = "안녕하세요!\tHello\r\nWorld!"
    val path = "D:\\test\\testfile.txt"

    val file = File(path)
    val printWriter = PrintWriter(file)

    //printWriter.write(outString)
    //printWriter.flush() // 버퍼에 남아있는 내용을 전부 flush
    //printWriter.close()

    //printWriter.println(outString)
    //printWriter.close()

    //File(path).printWriter().use { out -> out.println(outString) }

    File(path).printWriter().use { it.println(outString) }
}