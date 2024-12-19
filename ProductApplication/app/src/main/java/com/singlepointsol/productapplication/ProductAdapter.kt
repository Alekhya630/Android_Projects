package com.singlepointsol.productapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val productArrayList: ArrayList<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.product_title)
        val idTextView: TextView = itemView.findViewById(R.id.product_id)
        val nameTextView: TextView = itemView.findViewById(R.id.product_name)
        val priceTextView: TextView = itemView.findViewById(R.id.product_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_product,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val product = productArrayList[position]
        holder.titleTextView.text = "Title:${product.title}"
        holder.idTextView.text = "Product Id:${product.id}"
        holder.nameTextView.text = "Product Name:${product.name}"
        holder.priceTextView.text ="Price:${product.price}"
    }

    override fun getItemCount(): Int = productArrayList.size
}
