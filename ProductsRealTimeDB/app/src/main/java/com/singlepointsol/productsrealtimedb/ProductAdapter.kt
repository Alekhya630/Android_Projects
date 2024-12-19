package com.singlepointsol.productsrealtimedb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val productArrayList: ArrayList<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val producttv: TextView =itemView.findViewById(R.id.product_tv)
        val memorytv: TextView =itemView.findViewById(R.id.memory_tv)
        val storagetv: TextView =itemView.findViewById(R.id.storage_tv)
        val featurestv: TextView =itemView.findViewById(R.id.features_tv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.prd_row,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productArrayList[position]
        holder.producttv.text=product.product
        holder.memorytv.text=product.memory
        holder.storagetv.text=product.storage
        holder.featurestv.text=product.features
    }

}
