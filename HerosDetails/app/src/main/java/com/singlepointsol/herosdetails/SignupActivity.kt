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

class SignupActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var snameEditText: EditText
    private lateinit var semailEditText: EditText
    private lateinit var spasswordEditText: EditText
    private lateinit var sconfirmPasswordEditText: EditText

    private lateinit var signUpButton: Button

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)

        snameEditText = findViewById(R.id.sname_et)
        semailEditText = findViewById(R.id.semail_et)
        spasswordEditText = findViewById(R.id.spassword_et)
        sconfirmPasswordEditText = findViewById(R.id.sconfirmpassword_et)
        signUpButton = findViewById(R.id.signUp_button)

        auth = Firebase.auth
        // Setting Listeners
        signUpButton.setOnClickListener(this)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.signUp_button -> {
                val sname = snameEditText.text.toString()
                val semail = semailEditText.text.toString()
                val spassword = spasswordEditText.text.toString()
                val sconfirmPassword = sconfirmPasswordEditText.text.toString()

                if (sname.isEmpty() || semail.isEmpty() || spassword.isEmpty() || sconfirmPassword.isEmpty() ) {
                    Toast.makeText(this, "Enter all details", Toast.LENGTH_LONG).show()
                    return
                } else
                    if (spassword == sconfirmPassword) {
                        auth.createUserWithEmailAndPassword(semail, spassword).addOnCompleteListener {
                            if (it.isSuccessful) {
                                val signInIntent = Intent(this, SigninActivity::class.java)
                                startActivity(signInIntent)
                            }
                            else {
                                Toast.makeText(this, "Unable to signup", Toast.LENGTH_LONG).show()
                            }
                        }
                    }
            }
            R.id.signin_button -> {
                val signInIntent = Intent (this, SigninActivity::class.java)
                startActivity(signInIntent)
            }
        }
    }
}