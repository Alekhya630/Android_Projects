package com.singlepointsol.nykaaproductdetails

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity(), NykaaProductAlert.OnProductDataListener {

    // Declare RecyclerView and Adapter properly
    private lateinit var nykaaProductRecyclerView: RecyclerView
    private lateinit var nykaaProductAdapter: NykaaProductAdapter
    private lateinit var databaseReference: DatabaseReference

    // Initialize the product list
    private val nykaaProductArrayList = ArrayList<NykaaProduct>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nykaaProductRecyclerView = findViewById(R.id.NykaaProductRecyclerView)
        nykaaProductRecyclerView.layoutManager = LinearLayoutManager(this)
        nykaaProductAdapter = NykaaProductAdapter(nykaaProductArrayList)
        nykaaProductRecyclerView.adapter = nykaaProductAdapter

        getNykaaProduct()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.add_menu -> {
                // Open the NykaaProductAlert dialog
                NykaaProductAlert().show(supportFragmentManager, "add_item")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getNykaaProduct() {
        databaseReference = FirebaseDatabase.getInstance().getReference("NykaaProduct")

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                nykaaProductArrayList.clear()
                for (productSnapshot in snapshot.children) {
                    val product = productSnapshot.getValue(NykaaProduct::class.java)
                    if (product != null) {
                        nykaaProductArrayList.add(product)
                    }
                }
                nykaaProductAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // Log the error
            }
        })
    }



    override fun onProductData(productname: String, productprice: String, productmanufacture: String, country: String) {
        val newProduct = NykaaProduct(productname, productprice, productmanufacture, country)

        // Add new product to the list
        nykaaProductArrayList.add(newProduct)

        // Notify the adapter that a new item was inserted
        nykaaProductAdapter.notifyItemInserted(nykaaProductArrayList.size - 1)

        // Show a success message
        Toast.makeText(this, "Product added successfully", Toast.LENGTH_SHORT).show()
    }
}
