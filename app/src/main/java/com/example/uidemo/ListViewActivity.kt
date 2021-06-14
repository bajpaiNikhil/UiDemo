package com.example.uidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    val langList = mutableListOf("kotlin" , "Jaba" , "Swift" , "Dart" ,"kotlin" , "Jaba" , "Swift" , "Dart" , "kotlin" , "Jaba" , "Swift" , "Dart" )

    lateinit var adapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)


        //adapter  - Supply Data to the list view or view also decides layout of each item .
        /*
        ArrayAdapter - if data is part of a collection
        CursorAdapter - if data is a part of cursor as a result of query .

        listView , Spinner , GridVIew , RecyclerView - AdapterViews

        custom adapter - custom layout or custion data type

        */

        adapter = ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 , langList )


        lv.adapter = adapter
        lv.onItemClickListener = this
        registerForContextMenu(lv)


    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val lang = langList[position]
        Toast.makeText(this,"selection : $lang" , Toast.LENGTH_LONG).show()
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?, //this is entire listview
        menuInfo: ContextMenu.ContextMenuInfo? // postion of the item long pressed by the user
    ) {

        val  info = menuInfo as AdapterView.AdapterContextMenuInfo
        val lang = langList[info.position]

        menu?.add("Edit")

        menu?.add(0 , 1 ,0 ,"Delete $lang")

        menu?.add("View")

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo


        when(item.itemId){
            1 -> {
                //delete
                langList.removeAt(info.position)
                Toast.makeText(this,"deleted by the leader ${info.position}" , Toast.LENGTH_LONG).show()

                //call notifyDaaSet whenever data set is updated ,this will make the list view refresh


                adapter.notifyDataSetChanged()

            }
            2 -> {
                //view
            }
        }
        return super.onContextItemSelected(item)
    }
}