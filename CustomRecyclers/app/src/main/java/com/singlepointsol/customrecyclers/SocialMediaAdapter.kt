package com.singlepointsol.customrecyclers

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SocialMediaAdapter(private val socialmediaArrayList: ArrayList<SocialMedia>) : RecyclerView.Adapter<SocialMediaAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val socialImage: ImageView = itemView.findViewById(R.id.socialList_image)
        val socialName: TextView = itemView.findViewById(R.id.socialList_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.social_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return socialmediaArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val social = socialmediaArrayList[position]
        holder.socialImage.setImageResource(social.socialImage)
        holder.socialName.text = social.socialName

        val context = holder.itemView.context  // Get the context once

        val intent = Intent(context, SocialMediaActivity::class.java)
        intent.putExtra("socialImage", social.socialImage)
        intent.putExtra("socialName", social.socialName)

        // Set the click listener for both the image and name
        val clickListener = View.OnClickListener {
            context.startActivity(intent)
        }

        holder.socialImage.setOnClickListener(clickListener)
        holder.socialName.setOnClickListener(clickListener)
    }
}
