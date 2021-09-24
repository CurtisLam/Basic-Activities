package edu.temple.basicactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
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


        /*
         * Data saved in your implementation of onSavedInstanceState() can be retrieved here
         * or in onRestoreInstanceState(). Note that the bundle object can be null in onCreate()
         * but will never be null on onRestoreInstnaceState()
         */
        if (savedInstanceState != null) {
            // Retrieve previously saved state information
        } else {
            // Initialize state data with default values
        }

        val secondActivityIntent = Intent(this, SecondActivity::class.java)

        // Launch without any returned data
        findViewById<Button>(R.id.launchButton).setOnClickListener {startActivity(secondActivityIntent)}

        // Launch expecting returned data
        findViewById<Button>(R.id.launchForResultButton).setOnClickListener{secondActivityLauncher.launch(secondActivityIntent)}
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Overriding onRestoreInstanceState() allows you to separate your "initialization" code
        // from your "restoration" code.
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // This method is used to persist state data before the activity is destroyed by Android,
        // allowing it to be retrieved when the activity is recreated.
        // Please items in the Bundle argument and they will be returned when onCreate() and
        // onRestoreInstanceState() are called.
        //
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