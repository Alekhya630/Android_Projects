package com.singlepointsol.customrecyclers

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SocialMediaActivity : AppCompatActivity() {
    lateinit var socialImageView:ImageView
    lateinit var socialTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_social_media)
        //loading views
        socialImageView=findViewById(R.id.social_imageView)
        socialTextView=findViewById(R.id.social_textView)
        val imagePosition=intent.getIntExtra("socialImage",100)
        socialImageView.setImageResource(imagePosition)
        socialTextView.text=intent.getStringExtra("socialName")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}