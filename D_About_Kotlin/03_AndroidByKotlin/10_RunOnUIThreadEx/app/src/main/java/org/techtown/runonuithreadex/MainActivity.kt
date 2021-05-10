package org.techtown.runonuithreadex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener {
            Thread(Runnable {
                while (true) { // 앱이 꺼져도 Background에서 계속 돌아감
                    Thread.sleep(100)
                    val time = System.currentTimeMillis()

                    this@MainActivity.runOnUiThread {
                        tv_message.text = "Time: $time"
                    }
                }
                //tv_message.text = "Time: $time" // 직접 접근 error
            }).start()
        }
    }
}