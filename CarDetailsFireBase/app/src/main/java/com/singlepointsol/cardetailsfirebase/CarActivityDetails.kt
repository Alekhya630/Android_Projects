package com.singlepointsol.cardetailsfirebase

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CarActivityDetails : AppCompatActivity(), ValueEventListener {
    // Declaring Variables Globally
    // Recycler View
    private lateinit var recyclerView: RecyclerView
    // Array Declaration
    private lateinit var carArrayList: ArrayList<Car>
    // Database Reference declaring Globally
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_car_details)
        // Loading views into Activity
        recyclerView = findViewById(R.id.recycler_view)
        // Adding Layout to Recycler View
        recyclerView.layoutManager = LinearLayoutManager(this)
        // Array of Data
        carArrayList = ArrayList()

        // To receive data from the Real Time Database on the clicking the Load Button
        getCar()
        // Click on the Red Bulb and add the function
        // Loading Adapter
        // recyclerView.adapter = CarAdapter(carArrayList)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getCar() {
        databaseReference =FirebaseDatabase.getInstance().getReference("Car")
        databaseReference.addValueEventListener(this)
    }

    override fun onDataChange(snapshot: DataSnapshot) {
        if (snapshot.exists()) {
            for (userSnapshot in snapshot.children) {
                val car = userSnapshot.getValue(Car::class.java)
                if (car != null) {
                    carArrayList.add(car)
                }
                recyclerView.adapter =CarAdapter(carArrayList)
            }
        }
    }

    override fun onCancelled(error: DatabaseError) {
        TODO("Not yet implemented")
    }
}