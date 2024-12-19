package com.singlepointsol.sharedpreferences

import android.content.SharedPreferences
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
    lateinit var passwordEditText:EditText
    lateinit var loadBtn:Button
    lateinit var saveBtn:Button
    lateinit var  sharedPreference:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //loading views into activity
        nameEditText=findViewById(R.id.editTextText)
        passwordEditText=findViewById(R.id.editTextPassword)
        loadBtn=findViewById(R.id.load_button)
        saveBtn=findViewById(R.id.save_button)
        //setting listeners
        loadBtn.setOnClickListener(this)
        saveBtn.setOnClickListener(this)
        sharedPreference=getSharedPreferences("SinglePointPreferences",
            MODE_PRIVATE)
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
                    val editor:SharedPreferences.Editor=sharedPreference.edit()
                    editor.putString("nameKey",nameEditText.text.toString())
                    editor.putString("passwordKey",passwordEditText.text.toString())
                    editor.apply()
                    nameEditText.text.clear()
                    passwordEditText.text.clear()

                }
                R.id.load_button ->{
                    if(sharedPreference.contains("nameKey"))
                    {
                        val name:String=sharedPreference.getString("nameKey",null).toString()
                        nameEditText.setText(name)
                    }
                    else
                    {
                        Toast.makeText(this,"Empty Name Preference",Toast.LENGTH_LONG).show()
                    }
                    if(sharedPreference.contains("passwordKey")){
                        val password:String=sharedPreference.getString("cpasswordKey",null).toString()
                        passwordEditText.setText(password)
                    }
                    else
                    {
                        Toast.makeText(this,"Empty Password Preference",Toast.LENGTH_LONG).show()
                    }

                }
            }
        }
    }
}