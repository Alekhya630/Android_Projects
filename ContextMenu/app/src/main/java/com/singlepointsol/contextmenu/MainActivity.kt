package com.singlepointsol.contextmenu

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var contextBtn:Button
    lateinit var contextView: TextView
    lateinit var parentLayout:ConstraintLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //loading views
        contextBtn=findViewById(R.id.context_menu)
        parentLayout=findViewById(R.id.main)
        contextView=findViewById(R.id.title_txt)
        //register
        registerForContextMenu(contextBtn)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.context_menu,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.text_name ->{
                val updated ="Welcome to Single Point Solutions"
                contextView.text=updated
                true
            }
            R.id.color_bg ->{
                contextBtn.setBackgroundColor(resources.getColor(R.color.Context))
                    true
            }
            R.id.background_im ->{
               parentLayout.setBackgroundResource(R.drawable.baba)
                true
            }
            else -> {
                return super.onContextItemSelected(item)
            }
        }

    }
}