package com.singlepointsol.recyclerdemo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    var namesArray= arrayOf("Alekhya","Purnima","Nikki","Niha","Sai","Ammu","Alekhya","Purnima","Nikki","Niha","Sai","Ammu","Alekhya","Purnima","Nikki","Niha","Sai","Ammu",
            "Alekhya","Purnima","Nikki","Niha","Sai","Ammu",
        "Alekhya","Purnima","Nikki","Niha","Sai","Ammu")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //loading views
        recyclerView=findViewById(R.id.recycler_view)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=NamesAdapter(namesArray)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}