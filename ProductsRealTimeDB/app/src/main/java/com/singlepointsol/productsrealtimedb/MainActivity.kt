package com.singlepointsol.productsrealtimedb

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
    private lateinit var productEditText: EditText
    private lateinit var memoryEditText: EditText
    private lateinit var storageEditText: EditText
    private lateinit var featuresEditText: EditText
    private lateinit var savebtn:Button
    private lateinit var loadbtn:Button

    private lateinit var database: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //loading views
        productEditText=findViewById(R.id.product_editText)
        memoryEditText=findViewById(R.id.memory_editText)
        storageEditText=findViewById(R.id.storage_editText)
        featuresEditText=findViewById(R.id.features_editText)
        savebtn=findViewById(R.id.save_button)
        loadbtn=findViewById(R.id.load_button)
        //setting listeners
        savebtn.setOnClickListener(this)
        loadbtn.setOnClickListener(this)

        database = Firebase.database
        //db reference to push

        databaseReference=database.reference.child("Product")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id){
                R.id.save_button ->{
                    if (productEditText.text.toString().isNotEmpty() && memoryEditText.text.toString().isNotEmpty() && storageEditText.text.toString().isNotEmpty() && featuresEditText.text.toString().isNotEmpty())
                    {
                        val product = Product(productEditText.text.toString(),memoryEditText.text.toString(),storageEditText.text.toString(),featuresEditText.text.toString())
                        databaseReference.push().setValue(product)
                        Toast.makeText(applicationContext,"Data Inserted!", Toast.LENGTH_LONG).show()
                        productEditText.text.clear()
                        memoryEditText.text.clear()
                        storageEditText.text.clear()
                        featuresEditText.text.clear()
                    }


                }
                R.id.load_button ->{
                    val intent= Intent(this,ProductDetailsActivity::class.java)
                    startActivity(intent)

                }

            }
        }
    }
}