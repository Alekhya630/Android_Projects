package com.singlepointsol.project

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FlowersAdapter(private val flowersArrayList: ArrayList<Flowers>) : RecyclerView.Adapter<FlowersAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val flowerImage: ImageView = itemView.findViewById(R.id.flowerslist_image)
        val userName: TextView = itemView.findViewById(R.id.user_name)
        val viewCount: TextView = itemView.findViewById(R.id.view_count)
        val downloadCount: TextView = itemView.findViewById(R.id.download_count)
        val likesCount: TextView = itemView.findViewById(R.id.likes_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.flowers_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = flowersArrayList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val flower = flowersArrayList[position]

        // Load the image using Glide
        Glide.with(holder.itemView.context).load(flower.flowerImage).into(holder.flowerImage)

        // Set the text for the user, views, downloads, and likes
        holder.userName.text = "User: ${flower.user}"
        holder.viewCount.text = "Views: ${flower.views}"
        holder.downloadCount.text = "Downloads: ${flower.downloads}"
        holder.likesCount.text = "Likes: ${flower.likes}"

        // Handle item click event to pass the data to the next activity
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, FlowersActivity::class.java)
            intent.putExtra("flowerImage", flower.flowerImage)
            intent.putExtra("user", flower.user)
            intent.putExtra("views", flower.views) // Pass as Int
            intent.putExtra("downloads", flower.downloads) // Pass as Int
            intent.putExtra("likes", flower.likes) // Pass as Int
            holder.itemView.context.startActivity(intent)
        }
    }

}
