package com.singlepointsol.passingdata

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailsActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var value:TextView
    lateinit var homeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        //loading views into activity
       value=findViewById(R.id.enterdata_tv)
        homeButton=findViewById(R.id.home_button)
        val myvalue:String=intent.getStringExtra("data").toString()
        value.text=myvalue
        //seeting listeners
        homeButton.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {

        val intent:Intent=Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}