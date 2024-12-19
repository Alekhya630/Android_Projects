package com.singlepointsol.sqlitedatabasetest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FlowersAdapter( private val flowersArrayList: ArrayList<Flowers>) : RecyclerView.Adapter<FlowersAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val name: TextView =itemView.findViewById(R.id.name_tv)
        val type: TextView =itemView.findViewById(R.id.type_tv)
        val color: TextView =itemView.findViewById(R.id.color_tv)
        val symbolism:TextView=itemView.findViewById(R.id.symbolism_tv)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View= LayoutInflater.from(parent.context).inflate(R.layout.flw_row,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return flowersArrayList.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val flw = flowersArrayList[position]
        holder.name.text = flw.name
        holder.type.text=flw.type
        holder.color.text=flw.color
        holder.symbolism.text=flw.symbolism


    }

}
