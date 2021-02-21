package chap05.section5.internal2

import chap05.section5.internal.*
//import chap05.section5.internal.InternalClass

class OtherFile {
    fun test() {
        val ic = InternalClass()
        ic.i = 5
        ic.icFunc()
    }
}

fun main() {
    val otheric = InternalClass()

    println(otheric.i)
    otheric.icFunc()
    otheric.access()

    val of = OtherFile()
    of.test()
}