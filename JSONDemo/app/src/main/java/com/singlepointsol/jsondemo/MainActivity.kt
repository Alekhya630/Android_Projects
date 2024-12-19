package com.singlepointsol.jsondemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var employeesArray: ArrayList<Employee>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.recycler_view)
        recyclerView.layoutManager=LinearLayoutManager(this)
        employeesArray=ArrayList()

        val jsonObject = JSONObject(loadJsonFromAssets())
        val empArray = jsonObject.getJSONArray("employees")
        for(emp in 0 until empArray.length()){
            val empObject = empArray.getJSONObject(emp)
            val name = empObject.getString("name")
            val email = empObject.getString("email")
            val phone = empObject.getString("phone")
            employeesArray.add(Employee(name, email, phone))
        }

        recyclerView.adapter=EmployeesAdapter(employeesArray)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun loadJsonFromAssets(): String {
        val inputStream = assets.open("employees.json")
        val buffer = ByteArray(inputStream.available())
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer)
        return json

    }


}