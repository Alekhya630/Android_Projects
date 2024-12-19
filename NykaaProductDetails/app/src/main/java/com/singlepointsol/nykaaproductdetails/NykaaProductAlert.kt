package com.singlepointsol.nykaaproductdetails

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class NykaaProductAlert : DialogFragment() {

    interface OnProductDataListener {
        fun onProductData(productname: String, productprice: String, productmanufacture: String, country: String)
    }

    private var listener: OnProductDataListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = androidx.appcompat.app.AlertDialog.Builder(requireContext())
        val inflater: LayoutInflater = requireActivity().layoutInflater
        val view: View = inflater.inflate(R.layout.nykaaproduct_alert, null)

        val nameEditText = view.findViewById<EditText>(R.id.productname_et)
        val priceEditText = view.findViewById<EditText>(R.id.productprice_et)
        val manufactureEditText = view.findViewById<EditText>(R.id.productmanufacture_et)
        val countryEditText = view.findViewById<EditText>(R.id.productcountry_et)
        val addButton = view.findViewById<Button>(R.id.add_button)

        addButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val price = priceEditText.text.toString()
            val manufacture = manufactureEditText.text.toString()
            val country = countryEditText.text.toString()

            listener = activity as? OnProductDataListener
            listener?.onProductData(name, price, manufacture, country)
            dismiss()
        }

        builder.setView(view)
        return builder.create()
    }
}
