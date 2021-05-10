package org.techtown.asynctaskex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

// Deprecated AsyncTask
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val task = ImageDownloadTask(this, root_layout, progress_bar, tv_message)

        btn_start.setOnClickListener {
            task.execute(
                    "https://picsum.photos/200/300",
                    "https://picsum.photos/200/300",
                    "https://picsum.photos/200/300",
                    "https://picsum.photos/200/300",
                    "https://picsum.photos/200/300"
            )
        }

        btn_stop.setOnClickListener {
            task.cancel(true)
        }
    }
}