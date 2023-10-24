package com.example.ics26011_activity_100323_oop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class FragmentClass : DialogFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView : View = inflater.inflate(R.layout.activity_fragment, container, false)

        var bundle_argument = arguments
        var firstNewVariable = bundle_argument!!.getString("firstName")
        var secondNewVariable = bundle_argument!!.getString("lastName")

        var btnExit : ImageButton = rootView.findViewById(R.id.btnExit)
        var txtFirstVal : TextView = rootView.findViewById(R.id.txtFirstVal)
        var txtSecondVal : TextView = rootView.findViewById(R.id.txtSecondVal)

        txtFirstVal.text = firstNewVariable
        txtSecondVal.text = secondNewVariable

        btnExit.setOnClickListener {
            dismiss()
        }

        return rootView
    }
}