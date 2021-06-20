package com.example.uidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_radio_button.*

class RadioButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button)

        when(cityRG.checkedRadioButtonId){

            R.id.blrR -> cityT.text = "Bangalore"
            R.id.dlhR -> cityT.text = "Delhi"
            R.id.mumR -> cityT.text = "Mumbai"
            R.id.hydR -> cityT.text = "Hyderbad"
            else -> cityT.text = "select City Please . "
            
        }

    }

    fun rbClicked(view: View) {

        val rBox = view as RadioButton
        var cityName = rBox.text.toString()
        if(rBox.isChecked){
            Toast.makeText(this,"${cityName}Radio Button click" , Toast.LENGTH_LONG).show()
            cityT.text = cityName
        }

    }

}