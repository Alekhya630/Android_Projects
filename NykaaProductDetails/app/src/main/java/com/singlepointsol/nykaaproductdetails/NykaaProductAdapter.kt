package com.singlepointsol.nykaaproductdetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NykaaProductAdapter(private val nykaaProductArrayList: ArrayList<NykaaProduct>) : RecyclerView.Adapter<NykaaProductAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.productname_tv)
        val priceTextView: TextView = itemView.findViewById(R.id.productprice_tv)
        val manufactureTextView: TextView = itemView.findViewById(R.id.productmanufacture_tv)
        val countryTextView: TextView = itemView.findViewById(R.id.productcountry_tv)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.product_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return nykaaProductArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = nykaaProductArrayList[position]
        holder.nameTextView.text=product.productname
        holder.priceTextView.text=product.productprice
        holder.manufactureTextView.text=product.productmanufacture
        holder.countryTextView.text=product.country
    }

}
