package com.singlepointsol.project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.singlepointsol.project.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var flowersArrayList: ArrayList<Flowers>
    lateinit var flowersAdapter: FlowersAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the RecyclerView
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        flowersArrayList = arrayListOf()
        flowersAdapter = FlowersAdapter(flowersArrayList)
        recyclerView.adapter = flowersAdapter

        // Fetch flowers data from API
        fetchFlowersData()
    }

    // Coroutine scope to fetch data
    private fun fetchFlowersData() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitInstance.getRetrofitInstance()
                    .create(ApiService::class.java)
                    .getFlowers() // Calling suspend function

                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        val flowersList = response.body()?.hits ?: emptyList()
                        flowersArrayList.clear()
                        flowersArrayList.addAll(flowersList)
                        flowersAdapter.notifyDataSetChanged()
                    }
                }
            } catch (e: Exception) {
                // Handle errors
            }
        }
    }
}
