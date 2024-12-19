package com.singlepointsol.optionsmenu

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
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

   override fun onOptionsItemSelected(item: MenuItem) : Boolean {
        return when (item.itemId) {
            R.id.dum_biryani -> {
                val dumActivityIntent = Intent(this,DumActivity::class.java)
                startActivity(dumActivityIntent)
                true
            }

            R.id.mandi_biryani -> {
                val newIntent = Intent(this, MandiActivity::class.java)
                startActivity(newIntent)
                true
            }

            R.id.butta_biryani -> {
                val newIntent = Intent(this,ButtaActivity::class.java)
                startActivity(newIntent)
                true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}