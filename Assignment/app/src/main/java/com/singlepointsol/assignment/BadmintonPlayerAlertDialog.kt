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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database

class BadmintonPlayerAlertDialog : AppCompatActivity(), View.OnClickListener {
    // Declaring Variables Globally
    // Edit Text
    private lateinit var playerNameEditText: EditText
    private lateinit var playerCountryEditText: EditText
    private lateinit var playerBornYearEditText: EditText
    private lateinit var playerHandednessEditText: EditText
    private lateinit var playerCoachNameEditText: EditText
    private lateinit var playerMatchesEditText: EditText

    // Buttons
    private lateinit var submitButton: Button


    // Firebase
    private lateinit var database: FirebaseDatabase

    // Firebase Reference
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_badminton_player_alert_dialog)

        // Loading Views into Activity
        // Edit Text
        playerNameEditText = findViewById(R.id.name_editText)
        playerCountryEditText = findViewById(R.id.country_editText)
        playerBornYearEditText = findViewById(R.id.bornYear_editText)
        playerHandednessEditText = findViewById(R.id.handedness_editText)
        playerCoachNameEditText = findViewById(R.id.coach_editText)
        playerMatchesEditText = findViewById(R.id.matches_editText)
        // Buttons
        submitButton = findViewById(R.id.submit_button)

        // Setting Listeners for Buttons
        submitButton.setOnClickListener(this)

        // Initialize Firebase
        database = Firebase.database
        databaseReference = database.reference.child("Badminton")

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.submit_button -> {
                val name = playerNameEditText.text.toString()
                val country = playerCountryEditText.text.toString()
                val year = playerBornYearEditText.text.toString()
                val handedness = playerHandednessEditText.text.toString()
                val coachName = playerCoachNameEditText.text.toString()
                val matches = playerMatchesEditText.text.toString()

                if (name.isEmpty() || country.isEmpty() || year.isEmpty() || handedness.isEmpty() || coachName.isEmpty() || matches.isEmpty()) {
                    Toast.makeText(this, getString(R.string.Fields_Missing), Toast.LENGTH_LONG).show()
                    return
                }

                if (name.isNotEmpty() && country.isNotEmpty() && year.isNotEmpty() && handedness.isNotEmpty() && coachName.isNotEmpty() && matches.isNotEmpty()) {
                    val player = Badminton(name, country, year, handedness, coachName, matches)
                    databaseReference.push().setValue(player)
                    Toast.makeText(this, "Data Inserted", Toast.LENGTH_LONG).show()
                    // To clear the entered Edit Text
                    playerNameEditText.text.clear()
                    playerCountryEditText.text.clear()
                    playerBornYearEditText.text.clear()
                    playerHandednessEditText.text.clear()
                    playerCoachNameEditText.text.clear()
                    playerMatchesEditText.text.clear()
                }
            }

        }
    }
}