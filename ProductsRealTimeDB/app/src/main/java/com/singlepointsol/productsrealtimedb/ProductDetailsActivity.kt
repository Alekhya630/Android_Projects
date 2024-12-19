package com.singlepointsol.productsrealtimedb

import android.os.Bundle
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

class ProductDetailsActivity : AppCompatActivity(), ValueEventListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var databaseReference: DatabaseReference

    private lateinit var productArrayList: ArrayList<Product>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_product_details)

        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager= LinearLayoutManager(this)
        //array of data
        productArrayList=ArrayList()

        getProduct()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getProduct() {
        databaseReference= FirebaseDatabase.getInstance().getReference("Product")
        databaseReference.addValueEventListener(this)
    }

    override fun onDataChange(snapshot: DataSnapshot) {
        if (snapshot.exists()){
            for (userSnapshot in snapshot.children){
                val prd = userSnapshot.getValue(Product::class.java)
                if (prd != null) {
                    productArrayList.add(prd)
                }
                recyclerView.adapter=ProductAdapter(productArrayList)
            }
        }
    }

    override fun onCancelled(error: DatabaseError) {
        TODO("Not yet implemented")
    }
}