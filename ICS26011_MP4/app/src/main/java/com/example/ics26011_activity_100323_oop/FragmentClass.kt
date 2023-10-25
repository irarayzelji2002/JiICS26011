package com.example.ics26011_activity_100323_oop

import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.ContextThemeWrapper
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment

class FragmentClass : DialogFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var rootView : View = inflater.inflate(R.layout.activity_fragment, container, false)

        var constraintLayoutShadow : ConstraintLayout = rootView.findViewById(R.id.constraintLayoutShadow)
        var fade_in : Animation = AnimationUtils.loadAnimation(rootView.context,R.anim.fade_in)
        var fade_out : Animation = AnimationUtils.loadAnimation(rootView.context,R.anim.fade_out)
        constraintLayoutShadow.setAnimation(fade_in) //show dialog shadow animation

        var bundle_argument = arguments
        //var firstNewVariable = bundle_argument!!.getString("firstName")
        var userData = bundle_argument!!.getStringArrayList("userData")

        var registerObject = RegisterClass()

        var btnExit : ImageButton = rootView.findViewById(R.id.btnExit)
        var btnContinue : Button = rootView.findViewById(R.id.btnContinue)
        var btnCancel : Button = rootView.findViewById(R.id.btnCancel)

        var txtUsername : TextView = rootView.findViewById(R.id.txtUsername)
        var txtFirstName : TextView = rootView.findViewById(R.id.txtFirstName)
        var txtLastName : TextView = rootView.findViewById(R.id.txtLastName)
        var txtEmail : TextView = rootView.findViewById(R.id.txtEmail)
        var txtMobile : TextView = rootView.findViewById(R.id.txtMobile)
        var txtBirthday : TextView = rootView.findViewById(R.id.txtBirthday)
        var txtAccess : TextView = rootView.findViewById(R.id.txtAccess)

        txtUsername.text = userData?.get(0).toString()
        txtFirstName.text = userData?.get(2).toString()
        txtLastName.text = userData?.get(3).toString()
        txtEmail.text = userData?.get(4).toString()
        txtMobile.text = userData?.get(5).toString()
        txtBirthday.text = userData?.get(6).toString()
        txtAccess.text = userData?.get(7).toString()

        btnExit.setOnClickListener {
            constraintLayoutShadow.setAnimation(fade_out)
            dismiss()
        }
        btnCancel.setOnClickListener {
            constraintLayoutShadow.setAnimation(fade_out)
            dismiss()
        }
        btnContinue.setOnClickListener {
            var userData = UserInfo(
                userData?.get(0).toString(), userData?.get(1).toString(),
                userData?.get(2).toString(), userData?.get(3).toString(),
                userData?.get(4).toString(), userData?.get(5).toString(),
                userData?.get(6).toString(), userData?.get(7).toString())
            registerObject.AddToArray(userData)
            Log.i("userdata", userData.toString())
            Log.i("object", registerObject.toString())
            constraintLayoutShadow.setAnimation(fade_out)
        }

        return rootView
    }

    override fun getTheme(): Int {
        return R.style.NoBackgroundDialogTheme
    }

}