package org.techtown.countdownex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {

    private val TAG = "COUNTDOWN"
    private lateinit var job: CompletableJob

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!::job.isInitialized) {
            initJob()
        }

        /*val job = GlobalScope.launch(Dispatchers.Main, start = CoroutineStart.LAZY) {
            for (i in 10 downTo 1) {
                tv_message.text = "countdown $i"
                delay(1000)
            }
            tv_message.text = "done!"
        }*/

        btn_start.setOnClickListener {
            if (tv_message.text.contains("countdown")) { // running
                // job reset
                resetJob()
            }
            else {
                // process
                CoroutineScope(Main + job).launch {
                    Log.d(TAG, "$job is activated: $this")
                    for (i in 10 downTo 1) {
                        tv_message.text = "countdown $i"
                        delay(1000)
                    }
                    tv_message.text = "done!"
                }
            }
        }

        btn_stop.setOnClickListener {
            resetJob()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    private fun resetJob() {
        if (job.isActive || job.isCompleted) {
            job.cancel(CancellationException("cancel job"))
        }

        initJob()
    }

    private fun initJob() {
        job = Job()
        job.invokeOnCompletion {
            it?.message.let {
                var msg = it
                if (msg.isNullOrBlank()) {
                    msg = "Unknown error"
                }
                Log.e(TAG,"$job is completed: $msg")
            }
            tv_message.text = "Completed"
        }
        tv_message.text = "Ready"
    }
}