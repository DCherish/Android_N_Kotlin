package org.techtown.parcelableex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val person = Person("Kildong", 30)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        butt_sub.setOnClickListener {

            val intent = Intent(this, SubActivity::class.java)
            var bundle = Bundle()
            bundle.putParcelable("selected_person", person)
            intent.putExtra("myBundle", bundle)
            startActivity(intent)
        }
    }
}