package com.singlepointsol.assignment

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

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    // Declaring Globally
    // Edit Text
    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var mobileEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    // Buttons
    private lateinit var signUpButton: Button
    private lateinit var signInButton: Button
    // Firebase
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        // Loading Views into Activity
        // Edit Text
        firstNameEditText = findViewById(R.id.firstNameSignUp_editText)
        lastNameEditText =findViewById(R.id.lastNameSignUp_editText)
        mobileEditText = findViewById(R.id.mobileSignUp_editText)
        emailEditText = findViewById(R.id.emailSignUp_editText)
        passwordEditText = findViewById(R.id.passwordSignUp_editText)
        confirmPasswordEditText = findViewById(R.id.confirmpasswordSignUp_editText)
        // Buttons
        signInButton = findViewById(R.id.signIn_button)
        signUpButton = findViewById(R.id.signUp_button)
        // Intialize Firebase Authentication
        auth = Firebase.auth
        // Setting Listeners for Buttons
        signUpButton.setOnClickListener(this)
        signInButton.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.signUp_button -> {
                val firstName = firstNameEditText.text.toString()
                val lastName = lastNameEditText.text.toString()
                val mobile = mobileEditText.text.toString()
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                val confirmPassword = confirmPasswordEditText.text.toString()

                if (firstName.isEmpty() || lastName.isEmpty() || mobile.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(this, getString(R.string.Fields_Missing), Toast.LENGTH_LONG).show()
                    return
                } else
                if (password == confirmPassword) {
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val signInIntent = Intent(this, SignInActivity::class.java)
                            startActivity(signInIntent)
                        }
                        else {
                            Toast.makeText(this,
                                getString(R.string.unable_to_sign_up), Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
            R.id.signIn_button -> {
                val signInIntent = Intent (this, SignInActivity::class.java)
                startActivity(signInIntent)
            }
        }
    }
}