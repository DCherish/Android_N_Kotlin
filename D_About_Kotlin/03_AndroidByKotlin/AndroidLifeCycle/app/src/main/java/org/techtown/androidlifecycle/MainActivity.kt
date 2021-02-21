package org.techtown.androidlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("println - onCreate()")
        Log.i("LIFECYCLE", "onCreate()")
        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()

        println("println - onStart()")
        Log.i("LIFECYCLE", "onStart()")
        Toast.makeText(this, "onStart()", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()

        println("println - onResume()")
        Log.i("LIFECYCLE", "onResume()")
        Toast.makeText(this, "onResume()", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()

        println("println - onRestart)")
        Log.i("LIFECYCLE", "onRestart()")
        Toast.makeText(this, "onRestart()", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()

        println("println - onPause()")
        Log.i("LIFECYCLE", "onPause()")
        Toast.makeText(this, "onPause()", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()

        println("println - onStop()")
        Log.i("LIFECYCLE", "onStop()")
        Toast.makeText(this, "onStop()", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()

        println("println - onDestroy()")
        Log.i("LIFECYCLE", "onDestroy()")
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_SHORT).show()
    }
}