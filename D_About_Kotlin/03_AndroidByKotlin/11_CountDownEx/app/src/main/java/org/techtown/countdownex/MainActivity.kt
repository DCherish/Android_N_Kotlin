package org.techtown.countdownex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val job = GlobalScope.launch(Dispatchers.Main, start = CoroutineStart.LAZY) {
            for (i in 10 downTo 1) {
                tv_message.text = "countdown $i"
                delay(1000)
            }
            tv_message.text = "done!"
        }

        btn_start.setOnClickListener {
            job.start()
        }

        btn_stop.setOnClickListener {
            job.cancel()
        }
    }
}