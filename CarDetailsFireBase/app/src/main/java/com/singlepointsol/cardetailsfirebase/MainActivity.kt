package com.singlepointsol.cardetailsfirebase

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database

class MainActivity : AppCompatActivity(), View.OnClickListener {
    // Declaring Globally
    // Edit Text
    private lateinit var manufactureEditText: EditText
    private lateinit var modelEditText: EditText
    private lateinit var manufacturedYearEditText: EditText
    private lateinit var fuelTypeEditText: EditText
    private lateinit var seaterCapacityEditText: EditText
    private lateinit var carMileageEditText: EditText
    // Buttons
    private lateinit var submitButton: Button
    private lateinit var loadButton: Button
    // Declaring Firebase Variables
    private lateinit var database: FirebaseDatabase
    // Database Reference
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Loading Views into Activity
        // Edit Text
        manufactureEditText = findViewById(R.id.manufacture_editText)
        modelEditText = findViewById(R.id.model_editText)
        manufacturedYearEditText = findViewById(R.id.year_editText)
        fuelTypeEditText = findViewById(R.id.fuelType_editText)
        seaterCapacityEditText = findViewById(R.id.seater_editText)
        carMileageEditText = findViewById(R.id.mileage_editText)
        // Buttons
        submitButton = findViewById(R.id.submit_button)
        loadButton = findViewById(R.id.load_button)
        // Setting Listeners for Buttons
        submitButton.setOnClickListener(this)
        loadButton.setOnClickListener(this)

        // Firebase
        database = Firebase.database
        // Firebase Reference
        databaseReference = database.reference.child("Car")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.load_button -> {
                startActivity(Intent(this, CarActivityDetails::class.java))
            }
            R.id.submit_button -> {
                val manufacture = manufactureEditText.text.toString()
                val model = modelEditText.text.toString()
                val year = manufacturedYearEditText.text.toString()
                val fuel = fuelTypeEditText.text.toString()
                val seaterCapacity = seaterCapacityEditText.text.toString()
                val mileage = carMileageEditText.text.toString()
                if (manufacture.isNotEmpty() && model.isNotEmpty() && year.isNotEmpty() && fuel.isNotEmpty() && seaterCapacity.isNotEmpty() && mileage.isNotEmpty()) {
                        val car = Car(manufacture, model, year, fuel, seaterCapacity, mileage)
                        databaseReference.push().setValue(car)
                        Toast.makeText(this, "Data Inserted", Toast.LENGTH_LONG).show()
                        // To clear the entered Edit Text
                        manufactureEditText.text.clear()
                        modelEditText.text.clear()
                        manufacturedYearEditText.text.clear()
                        fuelTypeEditText.text.clear()
                        seaterCapacityEditText.text.clear()
                        carMileageEditText.text.clear()
                }
            }
        }
    }
}