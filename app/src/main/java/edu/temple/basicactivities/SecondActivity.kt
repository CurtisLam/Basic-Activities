package edu.temple.basicactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Second activity state", "onCreate() fired")
        setContentView(R.layout.activity_second)

        // Create an intent to pass information to calling activity
        val resultIntent = Intent().putExtra("resultValue", "Second activity closed with Back button")
        // Set code and data for returned result
        setResult(RESULT_OK, resultIntent)

        findViewById<Button>(R.id.closeButton).setOnClickListener {

            // Replace Extra information in intent
            resultIntent.putExtra("resultValue", "Second activity closed with finish()")
            // Set code and data for returned result
            setResult(RESULT_OK, resultIntent)
            // Close activity
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Second activity state", "onStart() fired")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Second activity state", "onResume() fired")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Second activity state", "onPause() fired")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Second activity state", "onStop() fired")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Second activity state", "onDestroy() fired")
    }
}