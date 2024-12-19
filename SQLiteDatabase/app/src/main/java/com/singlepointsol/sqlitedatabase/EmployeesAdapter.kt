package com.singlepointsol.sqlitedatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeesAdapter(private val employeesArrayList: ArrayList<Employee>) : RecyclerView.Adapter<EmployeesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val name:TextView=itemView.findViewById(R.id.name_tv)
        val email:TextView=itemView.findViewById(R.id.email_tv)
        val phone:TextView=itemView.findViewById(R.id.phone_tv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.emp_row,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return employeesArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val emp = employeesArrayList[position]
        holder.name.text = emp.name
        holder.email.text=emp.email
        holder.phone.text=emp.phone
    }

}
