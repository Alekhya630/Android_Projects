package com.singlepointsol.recyclerdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NamesAdapter ( val namesArray: Array<String>) : RecyclerView.Adapter<NamesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NamesAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NamesAdapter.ViewHolder, position: Int) {
        holder.versionName.text=namesArray[position]
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val versionName:TextView=itemView.findViewById(R.id.textView)

    }

    override fun getItemCount(): Int {
        return namesArray.size
    }


}
