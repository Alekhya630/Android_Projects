package com.singlepointsol.employeesrealtimedb

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
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var designationEditText:EditText
    private lateinit var saveButton:Button
    private lateinit var loadButton: Button

    private lateinit var database: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //loading views
        nameEditText=findViewById(R.id.name_editText)
        emailEditText=findViewById(R.id.email_editText)
        phoneEditText=findViewById(R.id.phone_editText)
        designationEditText=findViewById(R.id.designation_editText)
        saveButton=findViewById(R.id.save_button)
        loadButton=findViewById(R.id.load_button)
        //setting listeners
        saveButton.setOnClickListener(this)
        loadButton.setOnClickListener(this)
        //instance of firebase
        database = Firebase.database
        //db reference to push

        databaseReference=database.reference.child("Employees")

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
                    if (nameEditText.text.toString().isNotEmpty() && emailEditText.text.toString().isNotEmpty() && phoneEditText.text.toString().isNotEmpty() && designationEditText.text.toString().isNotEmpty())
                    {
                        val employee = Employee(nameEditText.text.toString(),emailEditText.text.toString(),phoneEditText.text.toString(),designationEditText.text.toString())
                        databaseReference.push().setValue(employee)
                        Toast.makeText(applicationContext,"Data Inserted!", Toast.LENGTH_LONG).show()
                        nameEditText.text.clear()
                        emailEditText.text.clear()
                        phoneEditText.text.clear()
                        designationEditText.text.clear()
                    }


                }
                R.id.load_button ->{
                   val intent= Intent(this,EmployeeDetails::class.java)
                    startActivity(intent)

                }

            }
        }
    }
}