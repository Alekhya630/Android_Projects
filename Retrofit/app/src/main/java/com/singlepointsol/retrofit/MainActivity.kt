package com.singlepointsol.retrofit

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.singlepointsol.retrofit.databinding.ActivityMainBinding
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val retrofitService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)

        val responseLiveData:LiveData<Response<Albums>> =
            liveData{
                val response = retrofitService.getAlbums()
                emit(response)
            }
        responseLiveData.observe(this, Observer {
            val albumList = it.body()?.listIterator()
            if(albumList != null){
                while (albumList.hasNext()){
                    val albumItem=albumList.next()

                    val albumTitle = "Album Title: ${albumItem.title} \n"
                    binding.titleTextView.append(albumTitle)
                }
            }
        })
        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

         */


    }
}