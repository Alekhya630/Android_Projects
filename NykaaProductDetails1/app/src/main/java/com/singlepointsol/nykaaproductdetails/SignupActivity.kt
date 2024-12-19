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

class SignupActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var nameEditText: EditText
    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var confirmpassworddEditText: EditText
    lateinit var signupButton: Button
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        nameEditText=findViewById(R.id.name_editText)
        emailEditText=findViewById(R.id.email_editText)
        passwordEditText=findViewById(R.id.password_editText)
        confirmpassworddEditText=findViewById(R.id.confirmpassword_editText)
        signupButton=findViewById(R.id.signup_btn)

        auth = Firebase.auth
        signupButton.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        val name = nameEditText.text.toString()
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        val confirmPassword = confirmpassworddEditText.text.toString()
        if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()){
            if (password == confirmPassword){
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                    val intent = Intent(this,SigninActivity::class.java)
                    startActivity(intent)
                    if (it.isSuccessful){
                        nameEditText.text.clear()
                        emailEditText.text.clear()
                        passwordEditText.text.clear()
                        confirmpassworddEditText.text.clear()
                    }
                    else{
                        Toast.makeText(this,"Unable to signup", Toast.LENGTH_LONG).show()
                    }
                }
            }

        }


    }

}