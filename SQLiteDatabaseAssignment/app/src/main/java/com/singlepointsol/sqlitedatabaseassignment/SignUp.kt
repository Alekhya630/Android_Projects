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

class SignUp : AppCompatActivity(), View.OnClickListener {

    lateinit var name_et: EditText
    lateinit var email_et: EditText
    lateinit var spassword: EditText
lateinit var dbHelper: DBHelper
    lateinit var signupbutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        name_et = findViewById(R.id.name_et)
        email_et = findViewById(R.id.email_et)
        spassword = findViewById(R.id.spassword_et)

        signupbutton = findViewById(R.id.signup_button)
         dbHelper = DBHelper(this)

        signupbutton.setOnClickListener(this)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        if (v != null && v.id == R.id.signup_button) {
            val username = name_et.text.toString().trim()
            val email=email_et.text.toString().trim()
            val password = spassword.text.toString().trim()

            if (username.isNotEmpty() && password.isNotEmpty() && email.isNotEmpty()) {
                val result = dbHelper.insertUser(username, email, password)
                if (result != -1L) {
                    Toast.makeText(this, "Sign-up successful", Toast.LENGTH_SHORT).show()
                    name_et.text.clear()
                    email_et.text.clear()
                    spassword.text.clear()

                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    Toast.makeText(this, "Error during sign-up", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}