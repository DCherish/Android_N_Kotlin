package chap08.section2

import java.util.*

fun main() {
    val booksName = arrayOf("java", "c", "c++", "kotlin", "c#", "html")
    val price = 200.00f
    val studentDiscount = .25f
    val teacherDiscount = .15f

    val scanner = Scanner(System.`in`)

    println("** D 서점에 오신 걸 환영합니다 :) **")
    do {
        println("↓↓ 구매 가능한 책 목록 ↓↓")
        println(Arrays.toString(booksName))
        println("어떤 책을 원하시나요 ? (\'exit\' 또는 \'q\' 입력 시 종료)")
        print("답변: ")
        val book = scanner.nextLine()

        if (booksName.contains(book.toLowerCase())) {
            println("선택하신 책은 $book 입니다. 가격은 \$200")
            println("학생과 선생님인 경우에 할인을 적용하고 있습니다." +
            "\n당신의 직업은 무엇인가요 ? (student, teacher, etc)")
            print("답변: ")
            val occupation = scanner.nextLine()

            when (occupation.toLowerCase()) {
                "student" -> calculatePrice(price, studentDiscount)
                "teacher" -> calculatePrice(price, teacherDiscount)
                else -> println("할인 적용 대상이 아닙니다." +
                "\n최종 가격은 \$200입니다.")
            }
        } else if (book == "exit" || book == "q") {
            println("이용해주셔서 감사합니다 :)")
            break
        } else {
            println("죄송합니다. $book 의 재고가 없습니다.")
        }
    } while (true)
}

private fun calculatePrice(orig: Float, x: Float) : Unit {
    val result = orig - (orig * x)
    println("최종 가격은 \$$result 입니다.")
}