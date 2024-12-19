package com.singlepointsol.sqlitedatabase

import android.annotation.SuppressLint
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

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var nameEditText: EditText
    lateinit var emailEditText: EditText
    lateinit var phoneEditText: EditText
    lateinit var saveBtn:Button
    lateinit var loadBtn:Button
    lateinit var updateBtn:Button
    lateinit var deleteBtn:Button
    lateinit var dbHelper: DBHelper
    lateinit var columnEditText: EditText
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        nameEditText=findViewById(R.id.name_editText)
        emailEditText=findViewById(R.id.email_editText)
        phoneEditText=findViewById(R.id.phone_editText)
        saveBtn=findViewById(R.id.save_button)
        loadBtn=findViewById(R.id.load_button)
        updateBtn=findViewById(R.id.update_button)
        deleteBtn=findViewById(R.id.delete_button)

        saveBtn.setOnClickListener(this)
        loadBtn.setOnClickListener(this)
        updateBtn.setOnClickListener(this)
        deleteBtn.setOnClickListener(this)
        dbHelper=DBHelper(this)
        columnEditText=findViewById(R.id.col_id)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id){
                R.id.save_button->{
                    if (nameEditText.text.isNotEmpty() && emailEditText.text.isNotEmpty() && phoneEditText.text.isNotEmpty()){
                        val employee=Employee(nameEditText.text.toString(),emailEditText.text.toString(),phoneEditText.text.toString())
                        val result=dbHelper.addEmployee(employee)
                        if (result >=-1){
                            Toast.makeText(applicationContext,"Data Inserted!",Toast.LENGTH_LONG).show()
                            nameEditText.text.clear()
                            emailEditText.text.clear()
                            phoneEditText.text.clear()
                        }
                        else{
                            Toast.makeText(applicationContext,"name or email or phone cannot be blank",Toast.LENGTH_LONG).show()
                        }
                    }

                }
                R.id.load_button ->{
                    val intent= Intent(this,EmployeesDetails::class.java)
                    startActivity(intent)
                }
                R.id.update_button ->{
                    val isUpdated:Boolean=dbHelper.updateEmployee(columnEditText.text.toString(),nameEditText.text.toString(),emailEditText.text.toString(),phoneEditText.text.toString())
                    if(isUpdated)
                    {
                        Toast.makeText(applicationContext,"Data Updated",Toast.LENGTH_LONG).show()
                    }
                    else{
                        Toast.makeText(applicationContext,"Data not found",Toast.LENGTH_LONG).show()

                    }
                }
                R.id.delete_button ->{
                    val rows = dbHelper.deleteEmployee(columnEditText.text.toString())
                    if (rows>0)
                    {
                        Toast.makeText(applicationContext,"Data Deleted Successfully",Toast.LENGTH_LONG).show()

                    }
                    else
                    {
                        Toast.makeText(applicationContext,"Data Not Found",Toast.LENGTH_LONG).show()

                    }
                }


            }
        }
    }
}