package com.singlepointsol.sqlitedatabasetest

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
    lateinit var coloumnEditText: EditText
    lateinit var nameEditText: EditText
    lateinit var typeEditText: EditText
    lateinit var colorEditText: EditText
    lateinit var symbolismEditText: EditText
    lateinit var saveBtn:Button
    lateinit var loadBtn:Button
    lateinit var updateBtn:Button
    lateinit var deleteBtn:Button
    lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //loading views
        coloumnEditText=findViewById(R.id.col_id)
        nameEditText=findViewById(R.id.name_editText)
        typeEditText=findViewById(R.id.type_editText)
        colorEditText=findViewById(R.id.color_editText)
        symbolismEditText=findViewById(R.id.symbolism_editText)
        saveBtn=findViewById(R.id.save_button)
        loadBtn=findViewById(R.id.load_button)
        updateBtn=findViewById(R.id.update_button)
        deleteBtn=findViewById(R.id.delete_button)
            //setting listeners
        saveBtn.setOnClickListener(this)
        loadBtn.setOnClickListener(this)
        updateBtn.setOnClickListener(this)
        deleteBtn.setOnClickListener(this)
        dbHelper=DBHelper(this)

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
                    if (nameEditText.text.isNotEmpty() && typeEditText.text.isNotEmpty() && colorEditText.text.isNotEmpty() && symbolismEditText.text.isNotEmpty() ) {
                        val flowers=Flowers(nameEditText.text.toString(),typeEditText.text.toString(),colorEditText.text.toString(),symbolismEditText.text.toString())
                        val result=dbHelper.addFlowers(flowers)
                        if (result >=-1){
                            Toast.makeText(applicationContext,"Data Inserted!", Toast.LENGTH_LONG).show()
                            nameEditText.text.clear()
                            typeEditText.text.clear()
                            colorEditText.text.clear()
                            symbolismEditText.text.clear()
                        }
                        else{
                            Toast.makeText(applicationContext,"Fields cannot be blank",
                                Toast.LENGTH_LONG).show()
                        }
                    }

                }
                R.id.load_button ->{
                    val intent= Intent(this,FlowersDetailsActivity::class.java)
                    startActivity(intent)
                }
                R.id.update_button ->{
                    val isUpdated:Boolean=dbHelper.updateFlowers(coloumnEditText.text.toString(),nameEditText.text.toString(),typeEditText.text.toString(),colorEditText.text.toString(),symbolismEditText.text.toString())
                    if(isUpdated)
                    {
                        Toast.makeText(applicationContext,"Data Updated", Toast.LENGTH_LONG).show()
                    }
                    else{
                        Toast.makeText(applicationContext,"Data not found", Toast.LENGTH_LONG).show()

                    }
                }
                R.id.delete_button ->{
                    val rows = dbHelper.deleteFlowers(coloumnEditText.text.toString())
                    if (rows>0)
                    {
                        Toast.makeText(applicationContext,"Data Deleted Successfully", Toast.LENGTH_LONG).show()

                    }
                    else
                    {
                        Toast.makeText(applicationContext,"Data Not Found", Toast.LENGTH_LONG).show()

                    }
                }


            }
        }
    }
}