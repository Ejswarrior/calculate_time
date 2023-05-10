package com.example.age_calculator

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.util.Calendar

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_actvity)

        val datePicker : Button = findViewById(R.id.buttonDate)
        datePicker.setOnClickListener {
            clickDatePicker()
        }
    }

    private fun clickDatePicker() {
         val myCalendar = Calendar.getInstance()
         val year = myCalendar.get(Calendar.YEAR)
         val month = myCalendar.get(Calendar.MONTH)
         val day = myCalendar.get(Calendar.DAY_OF_MONTH)
         val dateText : TextView = findViewById(R.id.date)
         val minutesPassedText : TextView = findViewById(R.id.calculated_age)

        DatePickerDialog(this,
        { view, year, month, dayOfMonth ->
            val selectedDate="$month/$dayOfMonth/$year"
            dateText.text = selectedDate
            minutesPassedText.text = calculateTimePassed(dayOfMonth, month, year)
        },
        year, month, day
        ).show()
    }

    private fun calculateTimePassed(day: Int, month: Int, year: Int): String {
        val totalDayMinutes = day * 1440
        val totalMonthMinutes = month * (30 * 1440)
        val totalYearMinutes = (year * (12 * 30)) * 1440

        return "${totalDayMinutes + totalMonthMinutes + totalYearMinutes}"
    }

}