package com.example.uidemo

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import java.util.*


class MyDialog : androidx.fragment.app.DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        lateinit var myDlg : Dialog

        //reference to activity
        val parent = activity
        val args = arguments
        val message = args?.getString("msg")
        val dlgTitle = args?.getString("title")
        val dlgType = args?.getInt("type")

        //Create AlertDialog
        var builder = AlertDialog.Builder(parent)
        when(dlgType) {
            1 -> {
                    builder.setTitle(dlgTitle)

                    builder.setMessage(message)

                    builder.setPositiveButton("yes") { _, _ ->
                        //close the activity
                        parent?.finish()

                    }

                    builder.setNegativeButton("NO", DialogInterface.OnClickListener { dialog, Index ->
                        //continue the activity
                        dialog.cancel()
                    })
                builder.setIcon(R.drawable.ic_launcher_foreground)
                myDlg = builder.create()
            }

            2 -> {
                //custom dialog
                builder.setView(R.layout.custom_dlg)
                builder.setIcon(R.drawable.ic_launcher_foreground)
                myDlg = builder.create()
            }
            3 -> {

                //date Picker dialog.

                val cal = Calendar.getInstance()
                val year = cal.get(Calendar.YEAR)
                val month = cal.get(Calendar.MONTH)
                val day = cal.get(Calendar.DAY_OF_MONTH)

                myDlg = DatePickerDialog(parent!! , parent as DatePickerDialog.OnDateSetListener, year, month, day)
            }
            4 -> {
                myDlg = TimePickerDialog(parent, parent as TimePickerDialog.OnTimeSetListener , 6,0,false)

            }
        }
                //builder.setIcon(R.drawable.ic_launcher_foreground)
                //myDlg = builder.create()
                return myDlg

        }

    }