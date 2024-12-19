package com.singlepointsol.activitylifecycle

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    private val TAG: String = "Activity Life Cycle"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Log.e(TAG, "I am in onCreate()")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "I am in onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "I am in onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "I am in onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "I am in onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "I am in onDestroy()")
    }
}