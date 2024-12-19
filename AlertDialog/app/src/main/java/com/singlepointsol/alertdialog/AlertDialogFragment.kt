package com.singlepointsol.alertdialog

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class AlertDialogFragment:DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder=context?.let { AlertDialog.Builder(it) }
        if (builder != null){
            builder.setTitle("Erase data?")
            builder.setMessage("All media will be deleted!")
            builder.setPositiveButton("Erase"){
                dialog,id->Toast.makeText(context,"Media deleted Successfully!",Toast.LENGTH_LONG).show()
            }
            builder.setNegativeButton("Cancel"){
                    dialog,id->Toast.makeText(context,"Cancel the alert!",Toast.LENGTH_LONG).show()

            }
        }
        return builder!!.create()

    }
}