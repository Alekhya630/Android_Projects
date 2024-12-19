package com.singlepointsol.productapplication

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class ProductAlert : DialogFragment() {

    interface OnProductDataEnteredListener {
        fun onProductDataEntered(title: String, id: String, name: String, price: String)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())

        // Inflate the dialog layout
        val inflater = LayoutInflater.from(requireContext())
        val view: View = inflater.inflate(R.layout.product_alert, null)

        // Initialize views from the custom layout
        val titleEditText: EditText = view.findViewById(R.id.title_editText)
        val idEditText: EditText = view.findViewById(R.id.proId_editText)
        val nameEditText: EditText = view.findViewById(R.id.proName_editText)
        val priceEditText: EditText = view.findViewById(R.id.price_editText)
        val addButton: Button = view.findViewById(R.id.add_Btn)

        dialog.setContentView(view)

        // Set listener to add button
        addButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val id = idEditText.text.toString()
            val name = nameEditText.text.toString()
            val price = priceEditText.text.toString()

            if (title.isNotEmpty() && id.isNotEmpty() && name.isNotEmpty() && price.isNotEmpty()) {
                // Pass data back to the activity using the listener
                val listener = activity as? OnProductDataEnteredListener
                listener?.onProductDataEntered(title, id, name, price)
                dialog.dismiss()
            } else {
                Toast.makeText(context,"Fill all the fields",Toast.LENGTH_SHORT).show()
        }
        }

  return dialog
  }
}

