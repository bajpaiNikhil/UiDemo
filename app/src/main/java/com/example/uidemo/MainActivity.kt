package com.example.uidemo

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var pDlg : ProgressDialog

    lateinit var progressBar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menu?.add("Exit")
        menu?.add("setting")
        menu?.add("Start")
        menu?.add("Stop")


        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.title){
            "setting" ->{
                val dlg = MyDialog()
                val myBundle = Bundle()
                myBundle.putInt("type" , 2)

                dlg.arguments = myBundle
                dlg.show(supportFragmentManager,"qwe")
            }
            "Exit" -> {
                //show dialog
                var dlg =MyDialog()

                val myBundle = Bundle() // to handle dialog message in activity without hard coding it in dialog class
                myBundle.putString("msg" , " Do you Want to Quit?")
                myBundle.putString("title" , "confirmation from here .")
                myBundle.putInt("type",1)

                //myBundle.putInt("msg1" , 1)

                dlg.isCancelable = false
                dlg.arguments = myBundle
                dlg.show(supportFragmentManager,"abcdef")

                //finish()

            }
            "Start" ->{
                //Staring the task
                //Show [progress dialog
                //pDlg = ProgressDialog.show(this , "Downloading..." ,"Please wait.")  old version .
                progressBar.visibility = View.VISIBLE

            }
            "Stop" ->{

            //cancel the dialog
            //    pDlg.cancel()
                progressBar.visibility = View.INVISIBLE
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        val dlg = MyDialog()
        val myBundle = Bundle()
        myBundle.putString("msg" , " Do you Want to Quit?")
        myBundle.putString("title" , "confirmation from here .")
        myBundle.putInt("type", 1)


        //myBundle.putInt("msg1" , 1)

        dlg.isCancelable = false
        dlg.arguments = myBundle
        dlg.show(supportFragmentManager,"abc")

    }

    fun fabClick(view: View) {


        Toast.makeText(this , "reached to fab" , Toast.LENGTH_LONG).show()

        val i = Intent(this , DateTimeActivity::class.java)
        startActivity(i)


    }
}
