package com.singlepointsol.assignment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity(), View.OnClickListener, ValueEventListener {
    // Declaring Global Variables
    // Buttons
    private lateinit var signOutButton: FloatingActionButton
    // Recycler View
    private lateinit var recyclerView: RecyclerView
    // Array Declaration
    private lateinit var badmintonArrayList: ArrayList<Badminton>
    // Database Reference
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Loading Views into Activity
        signOutButton = findViewById(R.id.signOut_button)
        recyclerView = findViewById(R.id.recyclerView)
        // Adding Layout to Recycler View
        recyclerView.layoutManager = LinearLayoutManager(this)
        // Array of Data
        badmintonArrayList = ArrayList()

        // To receive data from the Real Time Database On the Main Activity
        getBadminton()
        //recyclerView.adapter = BadmintonAdapter(badmintonArrayList)

        // Setting Listeners for Button
        signOutButton.setOnClickListener(this)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_add -> {
                val badmintonAlertIntent = Intent(this, BadmintonPlayerAlertDialog::class.java)
                startActivity(badmintonAlertIntent)
                true
            }

            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onClick(v: View?) {
        val signOutIntent = Intent (this, SignInActivity:: class.java )
        startActivity(signOutIntent)
    }

    private fun getBadminton() {
        databaseReference = FirebaseDatabase.getInstance().getReference("Badminton")
        databaseReference.addValueEventListener(this)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onDataChange(snapshot: DataSnapshot) {
        if (snapshot.exists()) {
            for (userSnapshot in snapshot.children) {
                val badminton = userSnapshot.getValue(Badminton::class.java)
                if (badminton != null) {
                    badmintonArrayList.add(badminton)
                }
                recyclerView.adapter = BadmintonAdapter(badmintonArrayList)
            }
            recyclerView.adapter?.notifyDataSetChanged()
        }
    }


    override fun onCancelled(error: DatabaseError) {
        TODO("Not yet implemented")
    }

}