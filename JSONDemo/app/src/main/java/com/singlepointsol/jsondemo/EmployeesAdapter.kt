package com.singlepointsol.jsondemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class EmployeesAdapter(private val employeesArray: ArrayList<Employee>) : RecyclerView.Adapter<EmployeesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val empName:TextView=itemView.findViewById(R.id.name_tv)
        val empEmail:TextView=itemView.findViewById(R.id.email_tv)
        val empPhone:TextView=itemView.findViewById(R.id.phone_tv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.emp_row,parent,false)
        return ViewHolder(view)

    }

    override fun getItemCount():Int {
        return employeesArray.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val emp=employeesArray[position]
        holder.empName.text=emp.name
        holder.empEmail.text=emp.email
        holder.empPhone.text=emp.phone
    }

}
