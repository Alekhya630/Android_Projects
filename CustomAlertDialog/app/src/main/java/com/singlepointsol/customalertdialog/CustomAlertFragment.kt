package com.singlepointsol.customalertdialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class CustomAlertFragment:DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder=AlertDialog.Builder(context)
        builder.setView(R.layout.custom_alert_layout)
        return builder.create()
    }
}