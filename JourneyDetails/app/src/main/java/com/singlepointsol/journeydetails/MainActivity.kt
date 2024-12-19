package com.singlepointsol.journeydetails

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener, DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {
    lateinit var source_et:EditText
    lateinit var destination_et:EditText
    lateinit var date_button:Button
    lateinit var time_button:Button
    lateinit var submit_button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//load views
        source_et=findViewById(R.id.source_et1)
        destination_et=findViewById(R.id.destination_et)
        date_button=findViewById(R.id.date_button)
        time_button=findViewById(R.id.time_button)
        submit_button=findViewById(R.id.submit_button)
        //set default text for date and time buttons

        //set listeners
        date_button.setOnClickListener(this)
        time_button.setOnClickListener(this)
        submit_button.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.source_et)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }



    @SuppressLint("SuspiciousIndentation")
    override fun onClick(p0: View?) {
        val calendar= Calendar.getInstance()
        val hour:Int=calendar.get(Calendar.HOUR_OF_DAY)
        val minute: Int = calendar.get(Calendar.MINUTE)
        val year:Int=calendar.get(Calendar.YEAR)
        val month=calendar.get(Calendar.MONTH)
        val day_of_month=calendar.get(Calendar.DAY_OF_MONTH)

            when(p0?.id) {
                R.id.time_button -> {
                    TimePickerDialog(this, this, hour, minute, false).show()
                }

                R.id.date_button -> {
                    DatePickerDialog(this, this, year, month, day_of_month).show()
                }

                R.id.submit_button -> {
                    if (source_et.text.toString().isEmpty() || destination_et.text.toString().isEmpty())
                    {
                        Toast.makeText(this, "Enter the details", Toast.LENGTH_LONG).show()
                    }
                    else if (date_button.text.toString() == "Select Date")
                    {
                        Toast.makeText(this, "Select Date", Toast.LENGTH_LONG).show()
                    }
                    else if (time_button.text.toString() == "Select Time") {
                        Toast.makeText(this, "Select Time", Toast.LENGTH_LONG).show()
                    }
                    else {
                        // Handle submit button click
                        val submitIntent = Intent(this, Journey::class.java)
                        submitIntent.putExtra("source", source_et.text.toString())
                        submitIntent.putExtra("destination", destination_et.text.toString())
                        submitIntent.putExtra("date", date_button.text.toString())
                        submitIntent.putExtra("time", time_button.text.toString())
                        startActivity(submitIntent)
                    }
                }


            }

    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        val dateSelected="$p1/${p2+1}/$p3"
        date_button.text =dateSelected
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        val timeSelected="$p1:$p2"
        time_button.text=timeSelected
    }

}