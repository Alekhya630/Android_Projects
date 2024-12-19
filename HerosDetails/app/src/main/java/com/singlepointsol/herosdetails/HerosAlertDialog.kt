package com.singlepointsol.herosdetails

import android.annotation.SuppressLint
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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database

class HerosAlertDialog: AppCompatActivity(), View.OnClickListener {
    private lateinit var bornYearEditText: EditText
    private lateinit var actorEditText: EditText
    private lateinit var educationEditText: EditText
    private lateinit var nicknameEditText: EditText
    private lateinit var submitButton: Button
    private lateinit var database: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.heros_alert)
        bornYearEditText = findViewById(R.id.bornYear_editText)
        actorEditText = findViewById(R.id.actor_editText)
        educationEditText = findViewById(R.id.education_editText)
        nicknameEditText = findViewById(R.id.nickname_editText)

        submitButton = findViewById(R.id.submit_button)
        submitButton.setOnClickListener(this)

        database = Firebase.database
        databaseReference = database.reference.child("Hero")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.submit_button -> {
                val bornyear = bornYearEditText.text.toString()
                val actor = actorEditText.text.toString()
                val education = educationEditText.text.toString()
                val nickname = nicknameEditText.text.toString()


                if (bornyear.isEmpty() || actor.isEmpty() || education.isEmpty() || nickname.isEmpty() ) {
                    Toast.makeText(this,"Enter the fields", Toast.LENGTH_LONG).show()
                    return
                }

                if (bornyear.isNotEmpty() && actor.isNotEmpty() && education.isNotEmpty() && nickname.isNotEmpty() ) {
                    val hero = Heros(bornyear, actor, education, nickname)
                    databaseReference.push().setValue(hero)
                    Toast.makeText(this, "Data Inserted", Toast.LENGTH_LONG).show()
                    // To clear the entered Edit Text
                    bornYearEditText.text.clear()
                    actorEditText.text.clear()
                    educationEditText.text.clear()
                    nicknameEditText.text.clear()

                    val intent = Intent (this, MainActivity::class.java)
                    startActivity(intent)
                }
            }

        }
    }
}