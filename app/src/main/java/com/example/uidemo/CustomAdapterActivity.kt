package com.example.uidemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_custom_adapter.*

class CustomAdapterActivity : AppCompatActivity() {

    val studentList = mutableListOf<Student>()
    lateinit var stdAdapter : Studentdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_adapter)

        studentList.add(Student("A",1,90.0))
        studentList.add(Student("Aa",2,900.0))
        studentList.add(Student("Aaa",3,901.0))
        studentList.add(Student("Aaaa",4,902.0))
        studentList.add(Student("aaaaA",5,920.0))
        studentList.add(Student("A",1,90.0))
        studentList.add(Student("Aa",2,900.0))
        studentList.add(Student("Aaa",3,901.0))
        studentList.add(Student("Aaaa",4,902.0))
        studentList.add(Student("aaaaA",5,920.0))
        studentList.add(Student("A",1,90.0))
        studentList.add(Student("Aa",2,900.0))
        studentList.add(Student("Aaa",3,901.0))
        studentList.add(Student("Aaaa",4,902.0))
        studentList.add(Student("aaaaA",5,920.0))

        stdAdapter = Studentdapter(this, R.layout.student_list_item, studentList)
        studentL.adapter = stdAdapter


    }
}

data class Student(val name:String , val rid : Int , var marks : Double)




class Studentdapter(context: Context , layoutId : Int , data : List<Student>) :
    ArrayAdapter<Student>(context ,layoutId,data){


    //called for each ite, in the collection
    //return the view

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        Log.d("studentadapter  " ," getview is called for $position")

        //return super.getView(position, convertView, parent)
        //render the view//layout
        //bind data with it
        val view = LayoutInflater.from(context).inflate(R.layout.student_list_item , null)

        val std = getItem(position)

        val nameTextView = view.findViewById<TextView>(R.id.nameT)
        val idTextview = view.findViewById<TextView>(R.id.idT)
        val marksTextView = view.findViewById<TextView>(R.id.marksT)

        nameTextView.text = std?.name
        idTextview.text = "  ${std?.rid}"
        marksTextView.text = "${std?.marks}"

        return view



    }
    }