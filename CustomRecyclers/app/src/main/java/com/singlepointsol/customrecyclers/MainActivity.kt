package com.singlepointsol.customrecyclers

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var socialmediaArrayList: ArrayList<SocialMedia>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //loading views
        recyclerView=findViewById(R.id.recycler_view)
        //select layout
        recyclerView.layoutManager= LinearLayoutManager(this)
        //arraylist
        socialmediaArrayList = ArrayList()
        socialmediaArrayList.add(SocialMedia(R.drawable.instagram,"Instagram"))
        socialmediaArrayList.add(SocialMedia(R.drawable.twitter,"Twitter"))
        socialmediaArrayList.add(SocialMedia(R.drawable.facebook,"Facebook"))
        socialmediaArrayList.add(SocialMedia(R.drawable.whatsapp,"Whatsapp"))
        socialmediaArrayList.add(SocialMedia(R.drawable.telegram,"Telegram"))
        socialmediaArrayList.add(SocialMedia(R.drawable.amazon,"Amazon"))
        socialmediaArrayList.add(SocialMedia(R.drawable.calling,"Calling"))
        socialmediaArrayList.add(SocialMedia(R.drawable.telegram,"Telegram"))
        socialmediaArrayList.add(SocialMedia(R.drawable.linkedin,"Linkedin"))
        socialmediaArrayList.add(SocialMedia(R.drawable.pintrest,"Pintrest"))






        //select adapter
        recyclerView.adapter=SocialMediaAdapter(socialmediaArrayList)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}