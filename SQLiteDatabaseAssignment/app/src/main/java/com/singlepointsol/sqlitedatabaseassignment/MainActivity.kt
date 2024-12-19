package com.singlepointsol.sqlitedatabaseassignment

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
    private lateinit var email_edittext: EditText
    private lateinit var password_edittext: EditText
    private lateinit var signup: Button
    private lateinit var signin: Button

    private lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        email_edittext = findViewById(R.id.email_edittext)
        password_edittext = findViewById(R.id.password_edittext)
        signin = findViewById(R.id.signin_button)
        signup = findViewById(R.id.signup_button)

        dbHelper = DBHelper(this)


        signin.setOnClickListener(this)
        signup.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.signin_button -> {
                val email=email_edittext.text.toString().trim()
                val password=password_edittext.text.toString().trim()

                if (email.isNotEmpty() && password.isNotEmpty()) {
                    if (dbHelper.isUserValid(email, password)) {
                        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, WelcomeActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
                    }
                }
                else {
                    Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                }
            }

            R.id.signup_button -> {
                val signupintent = Intent(this, SignUp::class.java)
                startActivity(signupintent)
            }
        }
    }
}





