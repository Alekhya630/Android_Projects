package com.singlepointsol.passingdata

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() , View.OnClickListener{
    lateinit var dataEditText: EditText
    lateinit var sendButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //loading view into activity
        dataEditText = findViewById(R.id.data_et)
        sendButton = findViewById(R.id.send_button)
        //setting listener for button
            sendButton.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.send_button)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    override fun onClick(p0: View?){
        if (dataEditText.text.isNotEmpty()){
            val intent=Intent(this,DetailsActivity::class.java)
            intent.putExtra("data",dataEditText.text.toString())
            startActivity(intent)
        }
        else{
            Toast.makeText(this,"Enter the value",Toast.LENGTH_LONG).show()
        }

    }
}