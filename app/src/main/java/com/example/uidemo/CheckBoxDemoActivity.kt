package com.example.uidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_check_box_demo.*

class CheckBoxDemoActivity : AppCompatActivity() {

    val cityList = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_box_demo)
    }

    fun cbClicked(view: View) {
        val cBox = view as CheckBox
        var cityName = cBox.text.toString()

        when (cBox.id){
            R.id.blrB -> cityName = "BLR"
            R.id.DLHB -> cityName = "Dlh"
            R.id.puneB -> cityName = "PNE"
            R.id.hydB -> cityName = "HYD"
        }

        if (cBox.isChecked){
            Toast.makeText(this,"${cBox.text} selected" , Toast.LENGTH_LONG).show()
            //add in the lsit
            cityList.add(cityName)
        }
        else{
            Toast.makeText(this,"${cBox.text} unchecked " , Toast.LENGTH_LONG).show()
            cityList.remove(cityName)
        }
        //update my text view

        locationT.text = "$cityList"
    }
}