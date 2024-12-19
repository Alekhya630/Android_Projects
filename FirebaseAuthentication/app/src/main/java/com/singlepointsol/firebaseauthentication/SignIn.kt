package com.singlepointsol.firebaseauthentication

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
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignIn : AppCompatActivity(), View.OnClickListener {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signinbtn:Button
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        emailEditText=findViewById(R.id.email_editText)
        passwordEditText=findViewById(R.id.password_editText)
        signinbtn=findViewById(R.id.signin_button)
        //
        auth=Firebase.auth
        signinbtn.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        val username = emailEditText.text.toString()
        val passwordEditText=passwordEditText.text.toString()
        auth.signInWithEmailAndPassword(username,passwordEditText).addOnCompleteListener {
            if(it.isSuccessful){
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Invalid user",Toast.LENGTH_LONG).show()
            }
        }
    }
}