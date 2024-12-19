package com.singlepointsol.productapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.singlepointsol.productapplication.R

class MainActivity : AppCompatActivity(), ProductAlert.OnProductDataEnteredListener {

    private lateinit var productRecyclerView: RecyclerView
    private val productArrayList = ArrayList<Product>()
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        productRecyclerView = findViewById(R.id.productRecyclerView)
        productRecyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize Adapter and set it to RecyclerView
        productAdapter = ProductAdapter(productArrayList)
        productRecyclerView.adapter = productAdapter
    }

    // Inflate the options menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }

    // Handle menu item clicks
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.add_menu -> {

                ProductAlert().show(supportFragmentManager, "add item")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Handle the data passed from ProductAPROPRE3000Electronics
    // 4
    // LLenovo laptop
    // 30,000t dialog
    override fun onProductDataEntered(title: String, id: String, name: String, price: String) {
        // Add the new product to the list
        val newProduct = Product(title, id, name, price)
        productArrayList.add(newProduct)

        // Notify the adapter that a new product has been added
        productAdapter.notifyItemInserted(productArrayList.size - 1)

        Toast.makeText(this, "Product added successfully", Toast.LENGTH_SHORT).show()
    }
}