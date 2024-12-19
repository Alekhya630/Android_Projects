package com.singlepointsol.herosdetails

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity(), ValueEventListener {
    private lateinit var recyclerView: RecyclerView
    // Array Declaration
    private lateinit var herosArrayList: ArrayList<Heros>
    // Database Reference
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        // Adding Layout to Recycler View
        recyclerView.layoutManager = LinearLayoutManager(this)
        // Array of Data
        herosArrayList = ArrayList()


        getHeros()

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
                val herosAlertIntent = Intent(this, HerosAlertDialog::class.java)
                startActivity(herosAlertIntent)
                true
            }

            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    private fun getHeros() {
        databaseReference = FirebaseDatabase.getInstance().getReference("Heros")
        databaseReference.addValueEventListener(this)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onDataChange(snapshot: DataSnapshot) {
        if (snapshot.exists()) {
            for (userSnapshot in snapshot.children) {
                val heros = userSnapshot.getValue(Heros::class.java)
                if (heros != null) {
                    herosArrayList.add(heros)
                }
                recyclerView.adapter = HerosAdapter(herosArrayList)
            }
            recyclerView.adapter?.notifyDataSetChanged()
        }
    }

    override fun onCancelled(error: DatabaseError) {
        TODO("Not yet implemented")
    }
}