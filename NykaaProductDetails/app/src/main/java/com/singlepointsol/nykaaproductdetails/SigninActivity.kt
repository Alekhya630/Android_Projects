package com.singlepointsol.nykaaproductdetails

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
    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var signinBtn: Button
    lateinit var signupBtn: Button
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_signin)
      emailEditText=findViewById(R.id.email_et)
        passwordEditText=findViewById(R.id.password_et)
        signinBtn=findViewById(R.id.signin_button)
        signupBtn=findViewById(R.id.signup_button)
        auth = Firebase.auth
        signinBtn.setOnClickListener(this)
        signupBtn.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.signin_button -> {
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)

                    val email = emailEditText.text.toString().trim()
                    val password = passwordEditText.text.toString().trim()

                    if (email.isNotEmpty() && password.isNotEmpty()) {
                        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                                if (it.isSuccessful)
                                {
                                    Toast.makeText(this, "Sign-in successful", Toast.LENGTH_SHORT).show()

                                    val intent = Intent(this, MainActivity::class.java)
                                    startActivity(intent)
                                    finish()
                                } else
                                {

                                    Toast.makeText(this, "Unable to signin", Toast.LENGTH_LONG).show()
                                }
                            }
                    } else
                    {
                        Toast.makeText(this, "Please fill the details", Toast.LENGTH_LONG).show()
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