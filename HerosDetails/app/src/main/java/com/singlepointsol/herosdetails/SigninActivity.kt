package com.singlepointsol.herosdetails

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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SigninActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signinButton: Button
    private lateinit var signupButton: Button
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signin)
        emailEditText = findViewById(R.id.email_editText)
        passwordEditText = findViewById(R.id.password_editText)
        // Button
        signinButton = findViewById(R.id.signin_button)
        signupButton = findViewById(R.id.signup_button)
        auth = Firebase.auth
        // Setting Listeners for Buttons
        signinButton.setOnClickListener(this)
        signupButton.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.signin_button -> {
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this, "Enter the details",Toast.LENGTH_LONG).show()
                    return
                }

                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        startActivity(Intent(this, MainActivity::class.java))
                    } else {
                        Toast.makeText(this,"User not found" ,Toast.LENGTH_LONG).show()
                    }
                }
            }
            R.id.signup_button -> {
                startActivity(Intent(this, SignupActivity::class.java))
            }
        }
    }
}