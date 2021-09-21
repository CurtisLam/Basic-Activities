package edu.temple.basicactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    val secondActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        Log.d("Returned data", it.data?.getStringExtra("resultValue").toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Main activity state", "onCreate() fired")
        setContentView(R.layout.activity_main)



        val secondActivityIntent = Intent(this, SecondActivity::class.java)

        // Launch without any returned data
        findViewById<Button>(R.id.launchButton).setOnClickListener {startActivity(secondActivityIntent)}

        // Launch expecting returned data
        findViewById<Button>(R.id.launchForResultButton).setOnClickListener{secondActivityLauncher.launch(secondActivityIntent)}
    }

    override fun onStart() {
        super.onStart()
        Log.d("Main activity state", "onStart() fired")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Main activity state", "onResume() fired")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Main activity state", "onPause() fired")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Main activity state", "onStop() fired")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Main activity state", "onDestroy() fired")
    }
}