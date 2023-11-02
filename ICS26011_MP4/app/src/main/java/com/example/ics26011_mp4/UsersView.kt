package com.example.ics26011_mp4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment

class UsersView : DialogFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.activity_users_view, container, false)

        var bundle_argument = arguments
        var username = bundle_argument!!.getString("user")
        var registerObject = RegisterClass()

        var constraintLayoutShadow : ConstraintLayout = rootView.findViewById(R.id.constraintLayoutShadow)
        var fade_in : Animation = AnimationUtils.loadAnimation(rootView.context,R.anim.fade_in)
        var fade_out : Animation = AnimationUtils.loadAnimation(rootView.context,R.anim.fade_out)
        constraintLayoutShadow.setAnimation(fade_in)

        var txtTitle : TextView = rootView.findViewById(R.id.txtTitle)
        var txtUsername : TextView = rootView.findViewById(R.id.txtUsername)
        var txtFirstName : TextView = rootView.findViewById(R.id.txtFirstName)
        var txtLastName : TextView = rootView.findViewById(R.id.txtLastName)
        var txtEmail : TextView = rootView.findViewById(R.id.txtEmail)
        var txtMobile : TextView = rootView.findViewById(R.id.txtMobile)
        var txtBirthday : TextView = rootView.findViewById(R.id.txtBirthday)
        var txtAccess : TextView = rootView.findViewById(R.id.txtAccess)

        txtTitle.text = getString(R.string.viewUserTitle, username)

        txtUsername.text = username
        txtFirstName.text = username?.let { registerObject.getUserData(it,"firstname") }
        txtLastName.text = username?.let { registerObject.getUserData(it,"lastname") }
        txtEmail.text = username?.let { registerObject.getUserData(it,"email") }
        txtMobile.text = username?.let { registerObject.getUserData(it,"mobilenumber") }
        txtBirthday.text = username?.let { registerObject.getUserData(it,"birthday") }
        txtAccess.text = username?.let { registerObject.getUserData(it,"access") }

        var btnExit : ImageButton = rootView.findViewById(R.id.btnExit)
        btnExit.setOnClickListener {
            constraintLayoutShadow.setAnimation(fade_out)
            dismiss()
        }

        return rootView
    }

    override fun getTheme(): Int {
        return R.style.NoBackgroundDialogTheme
    }
}