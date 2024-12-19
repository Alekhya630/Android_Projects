package com.singlepointsol.herosdetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class HerosAdapter(private val herosArrayList: ArrayList<Heros>) : RecyclerView.Adapter<HerosAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val bornyear: TextView = itemView.findViewById(R.id.bornYear_textView)
        val actor: TextView = itemView.findViewById(R.id.actor_textView)
        val education: TextView = itemView.findViewById(R.id.education_textView)
        val nickname: TextView = itemView.findViewById(R.id.nickname_textView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.heros_row, parent, false)
        return ViewHolder(view)    }

    override fun getItemCount(): Int {
        return herosArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hero = herosArrayList[position]
        holder.bornyear.setText(hero.bornyear)
        holder.actor.setText(hero.actor)
        holder.education.setText(hero.education)
        holder.nickname.setText(hero.nickname)

    }

}
