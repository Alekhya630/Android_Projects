package com.singlepointsol.customrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class VersionsAdapter(private val socialmediaArray: ArrayList<Version>) : RecyclerView.Adapter<VersionsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val versionImage:ImageView=itemView.findViewById(R.id.version_image)
        val versionName:TextView=itemView.findViewById(R.id.version_name)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersionsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: VersionsAdapter.ViewHolder, position: Int) {
        val version=versionsArray[position]
     holder.versionName.text=version.vName
        holder.versionImage.setImageResource(version.vImage)
 }

    override fun getItemCount(): Int {
        return versionsArray.size


    }

}
