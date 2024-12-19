package com.singlepointsol.cardetailsfirebase

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class CarAdapter(private val carArrayList: ArrayList<Car>) : RecyclerView.Adapter<CarAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val manufactureTextView: TextView = itemView.findViewById(R.id.manufacture_textView)
        val modelTextView: TextView = itemView.findViewById(R.id.model_textView)
        val yearTextView: TextView = itemView.findViewById(R.id.year_textView)
        val fuelTextView: TextView = itemView.findViewById(R.id.fuelType_textView)
        val seaterTextView: TextView = itemView.findViewById(R.id.seaterCapacity_textView)
        val mileageTextView: TextView = itemView.findViewById(R.id.mileage_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return carArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val car = carArrayList[position]
        holder.manufactureTextView.text = car.manufacture
        holder.modelTextView.text = car.model
        holder.yearTextView.text = car.year
        holder.fuelTextView.text = car.fuel
        holder.seaterTextView.text = car.seater
        holder.mileageTextView.text = car.mileage
    }
}
