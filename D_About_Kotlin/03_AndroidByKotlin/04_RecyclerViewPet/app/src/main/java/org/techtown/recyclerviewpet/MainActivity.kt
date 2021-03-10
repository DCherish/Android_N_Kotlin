package org.techtown.recyclerviewpet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val dataArray = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addDataArray()

        rv_data_list.layoutManager = LinearLayoutManager(this)
    }

    private fun addDataArray() {
        dataArray.add("오리")
        dataArray.add("오징어")
        dataArray.add("너구리")
        dataArray.add("참새")
        dataArray.add("강아지")
        dataArray.add("고양이")
        dataArray.add("오소리")
        dataArray.add("원숭이")
        dataArray.add("물개")
        dataArray.add("펭귄")
        dataArray.add("하마")
        dataArray.add("미어캣")
        dataArray.add("타조")
    }
}