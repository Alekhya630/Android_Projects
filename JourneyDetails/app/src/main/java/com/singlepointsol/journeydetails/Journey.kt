package com.singlepointsol.journeydetails

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Journey : AppCompatActivity() {

    lateinit var sourcetextview:TextView
    lateinit var destinationtextview:TextView
    lateinit var travelingdateview:TextView
    lateinit var travelingtimeview:TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_journey)

        sourcetextview=findViewById(R.id.source_tv1)
        destinationtextview=findViewById(R.id.destination_tv)
       travelingdateview=findViewById(R.id.traveling_tv)
        travelingtimeview=findViewById(R.id.time_tv)


        val source_tv1:String=intent.getStringExtra("source").toString()
        sourcetextview.text=source_tv1
        val destination_tv:String=intent.getStringExtra("destination").toString()
        destinationtextview.text=destination_tv
        val date=intent.getStringExtra("date").toString()
        travelingdateview.text=date
        val time=intent.getStringExtra("time").toString()
        travelingtimeview.text=time
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}