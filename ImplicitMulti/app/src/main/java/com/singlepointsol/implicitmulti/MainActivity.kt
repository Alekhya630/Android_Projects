package com.singlepointsol.implicitmulti

import android.content.Intent
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
    lateinit var name_et: EditText
    lateinit var password_et:EditText
    lateinit var signup: Button
    lateinit var signin:Button
    lateinit var sharedPreference: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        name_et=findViewById(R.id.name_et)
        password_et=findViewById(R.id.password_et)
        signin=findViewById(R.id.signin_button)
        signup=findViewById(R.id.signup_button)

        //set listeners
        signin.setOnClickListener(this)
        signup.setOnClickListener(this)
        sharedPreference=getSharedPreferences("SinglePointPreferences",
            MODE_PRIVATE)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(view: View?) {
        if (view !=null){
            when(view.id){
                R.id.signin_button ->{

                    if(name_et.text.toString().isEmpty()|| password_et.text.toString().isEmpty())
                    {
                        Toast.makeText(this,"Enter username & password!",Toast.LENGTH_LONG).show()
                    }
                    else if(name_et.text.toString()==sharedPreference.getString("nameKey", "") && password_et.text.toString()==sharedPreference.getString("passwordKey",""))
                    {
                        val welcomeIntent=Intent(this,Welcome::class.java)
                        startActivity(welcomeIntent)
                    }
                    else{
                        Toast.makeText(this,"Inavalid User!",Toast.LENGTH_LONG).show()
                    }


                }
                 R.id.signup_button ->{
                     val signUpIntent=Intent(this,SignUp::class.java)
                     startActivity(signUpIntent)
                 }

            }

        }


    }
}