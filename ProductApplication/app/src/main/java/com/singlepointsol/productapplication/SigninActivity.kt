package com.singlepointsol.productapplication

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
import com.google.firebase.auth.FirebaseAuth


    class SigninActivity : AppCompatActivity(), View.OnClickListener {
        lateinit var unameEt: EditText
        lateinit var passwordEt: EditText
        lateinit var signinBtn: Button
        lateinit var signupBtn: Button
        lateinit var auth: FirebaseAuth

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            //enableEdgeToEdge()
            setContentView(R.layout.activity_signin)

            unameEt = findViewById(R.id.username_et)
            passwordEt = findViewById(R.id.password_et)
            signinBtn = findViewById(R.id.signin_button)
            signupBtn = findViewById(R.id.signup_button)

            auth = FirebaseAuth.getInstance()

            signinBtn.setOnClickListener(this)
            signupBtn.setOnClickListener(this)

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

        override fun onClick(p0: View?) {
            if (p0 != null) {
                when (p0.id) {
                    R.id.signin_button -> {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)


                        val username = unameEt.text.toString().trim()
                        val password = passwordEt.text.toString().trim()

                        if (username.isNotEmpty() && password.isNotEmpty()) {
                            auth.signInWithEmailAndPassword(username, password)
                                .addOnCompleteListener {
                                    if (it.isSuccessful) {
                                        // Sign-in successful, navigate to MainActivity
                                        Toast.makeText(
                                            this,
                                            "Sign-in successful",
                                            Toast.LENGTH_SHORT
                                        ).show()

                                        // Navigate to MainActivity
                                        val intent = Intent(this, MainActivity::class.java)
                                        startActivity(intent)
                                        finish() // Close SigninActivity to prevent back navigation
                                    } else {
                                        // Show error message
                                        Toast.makeText(this, "Unable to sign in", Toast.LENGTH_LONG)
                                            .show()
                                    }
                                }
                        } else {
                            Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                    R.id.signup_button -> {
                        val intent = Intent(this, SignupActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }
