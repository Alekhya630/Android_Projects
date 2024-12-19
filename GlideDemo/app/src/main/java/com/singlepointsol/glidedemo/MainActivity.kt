package com.singlepointsol.glidedemo

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    lateinit var glideImageView: ImageView
    lateinit var glideImageView2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        glideImageView=findViewById(R.id.glide_imageView)
        glideImageView2=findViewById(R.id.imageView2)

        val imageUrl="https://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/Prabhas_at_Saaho_Pre_release_event_%28cropped%29.jpg/640px-Prabhas_at_Saaho_Pre_release_event_%28cropped%29.jpg"
        val imageURL1="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtt5E9SGRv7HC3eS-r4c08Iv88YVgC4iE2rA&s"

        Glide.with(this).load(imageUrl).into(glideImageView)
        Glide.with(this).load(imageURL1).into(glideImageView2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}