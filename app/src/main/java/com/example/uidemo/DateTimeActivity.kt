package com.example.uidemo

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast

class DateTimeActivity : AppCompatActivity() , DatePickerDialog.OnDateSetListener ,TimePickerDialog.OnTimeSetListener{


    lateinit var dateTextView : TextView
    lateinit var timeTImeView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_time)

        dateTextView = findViewById(R.id.dateT)
        timeTImeView = findViewById(R.id.timeT)

    }


    fun timeClick(view: View) {
        val dlg = MyDialog()
        val b  = Bundle()
        b.putInt("type" , 4)

        dlg.arguments = b
        dlg.show(supportFragmentManager,"def")

    }

    fun dateClick(view: View) {

        val dlg = MyDialog()
        val b  = Bundle()
        b.putInt("type" , 3)

        dlg.arguments = b
        dlg.show(supportFragmentManager,"deef")
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

        Log.d("dateTimeActivity" , "onDateSet")

        val date = "$dayOfMonth - ${month+1} - $year"
        Toast.makeText(this , "date and time found $date ",Toast.LENGTH_LONG).show()
        dateTextView.text = date


    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {

        var amPm = ""

        if (view?.hour!! >12){
            amPm = "pm"
        }else{
            amPm = "am"
        }

        Log.d("dateTimeActivity" , "onTimeSet")
        val time = "$hourOfDay hrs $minute sec of $amPm"
        Toast.makeText(this,"time is $hourOfDay hrs $minute sec is :" , Toast.LENGTH_LONG).show()
        timeTImeView.text = time

    }
}