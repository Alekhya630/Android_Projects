package com.singlepointsol.implicitintents

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.sql.Driver

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var call:Button
    lateinit var dial:Button
    lateinit var browse:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //loading views into activity
        call=findViewById(R.id.call_button)
        dial=findViewById(R.id.dial_button)
        browse=findViewById(R.id.browse_button)
        //
        call.setOnClickListener(this)
        dial.setOnClickListener(this)
        browse.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    override fun onClick(view: View?) {
        if (view !=null){
            when(view.id){
                R.id.call_button ->{
                    val callIntent=Intent(Intent.ACTION_CALL,Uri.parse("tel:9490123831"))
                    startActivity(callIntent)
                }
                R.id.dial_button->{
                   val dialIntent=Intent(Intent.ACTION_DIAL, Uri.parse("tel:9490123831"))
                    startActivity(dialIntent)
                }
                R.id.browse_button->{
                  val browseIntent=Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/guide/components/intents-common"))
                    startActivity(browseIntent)
                }
            }
        }
    }


}