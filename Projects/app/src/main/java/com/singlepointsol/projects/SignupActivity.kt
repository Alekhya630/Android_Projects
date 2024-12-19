package com.singlepointsol.projects

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {

    lateinit var firstNameEditText: EditText
    lateinit var lastNameEditText: EditText
    lateinit var dobEditText: EditText
    lateinit var mobileEditText: EditText
    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var confirmPasswordEditText: EditText
    lateinit var signupButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // Initialize the views
        firstNameEditText = findViewById(R.id.firstName_editText)
        lastNameEditText = findViewById(R.id.lastName_editText)
        dobEditText = findViewById(R.id.dob_editText)
        mobileEditText = findViewById(R.id.mobile_editText)
        emailEditText = findViewById(R.id.email_editText)
        passwordEditText = findViewById(R.id.password_editText)
        confirmPasswordEditText = findViewById(R.id.confirmPassword_editText)
        signupButton = findViewById(R.id.signup_button)

        //  listener
        signupButton.setOnClickListener {
            val firstName = firstNameEditText.text.toString()
            val lastName = lastNameEditText.text.toString()
            val dob = dobEditText.text.toString()
            val mobile = mobileEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (firstName.isNotEmpty() && lastName.isNotEmpty() && dob.isNotEmpty() &&
                mobile.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()
            ) {
                if (password == confirmPassword) {
                    Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show()
                    // Handle signup logic here, like saving the user data
                } else {
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
