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

class SignUp : AppCompatActivity(), View.OnClickListener {
    private lateinit var snameEditText: EditText
    private lateinit var semailEditText: EditText
    private lateinit var spasswordEditText: EditText
    private lateinit var sconfirmpasswordEditText: EditText
    private lateinit var signupbtn:Button
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        snameEditText=findViewById(R.id.s_name_et)
        semailEditText=findViewById(R.id.semail_et)
        spasswordEditText=findViewById(R.id.spassword_et)
        sconfirmpasswordEditText=findViewById(R.id.sconfirm_password_et)
        signupbtn=findViewById(R.id.signup_button)
        auth = Firebase.auth
        signupbtn.setOnClickListener(this)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        val name = snameEditText.text.toString()
        val email = semailEditText.text.toString()
        val password = spasswordEditText.text.toString()
        val confPassword = sconfirmpasswordEditText.text.toString()
        if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confPassword.isNotEmpty()){
            if (password == confPassword){
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                    if (it.isSuccessful){
                        val intent = Intent(this,SignIn::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"Unable to signup",Toast.LENGTH_LONG).show()
                    }
                }
            }
            else{
                Toast.makeText(this,"Password not matched",Toast.LENGTH_LONG).show()
            }
        }

        snameEditText.text.clear()
        semailEditText.text.clear()
        spasswordEditText.text.clear()
        sconfirmpasswordEditText.text.clear()
    }
}