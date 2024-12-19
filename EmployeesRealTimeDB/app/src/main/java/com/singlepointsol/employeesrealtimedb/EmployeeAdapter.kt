package com.singlepointsol.employeesrealtimedb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdapter(private val employeeArrayList: ArrayList<Employee>) : RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val nametv:TextView=itemView.findViewById(R.id.name_tv)
        val emailtv:TextView=itemView.findViewById(R.id.email_tv)
        val phonetv:TextView=itemView.findViewById(R.id.phone_tv)
        val designationtv:TextView=itemView.findViewById(R.id.designation_tv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val row=LayoutInflater.from(parent.context).inflate(R.layout.emp_row,parent,false)
        return ViewHolder(row)
    }

    override fun getItemCount(): Int {
        return employeeArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val employee = employeeArrayList[position]
        holder.nametv.text=employee.name
        holder.emailtv.text=employee.email
        holder.phonetv.text=employee.phone
        holder.designationtv.text=employee.designation
    }

}
