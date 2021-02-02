package chap06.section3

class KCustomer {
    companion object {
        const val LEVEL = "K-INTERMEDIATE"

        @JvmStatic
        fun login() = println("K-Login...")

        @JvmField
        val JOB = KJob()
        // 특정 자료형을 사용하기 위한 애노테이션
    }
}

class KJob {
    var title: String = "Programmer"
}