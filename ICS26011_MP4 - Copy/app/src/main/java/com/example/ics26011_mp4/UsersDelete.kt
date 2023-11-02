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

class UsersDelete : DialogFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.activity_users_delete, container, false)
        val usersFragmentView = inflater.inflate(R.layout.fragment_users, container, false)

        var bundle_argument = arguments
        var username = bundle_argument!!.getString("user")
        var currentUser = bundle_argument!!.getString("currentUser")
        var registerObject = RegisterClass()

        var constraintLayoutShadow : ConstraintLayout = rootView.findViewById(R.id.constraintLayoutShadow)
        var fade_in : Animation = AnimationUtils.loadAnimation(rootView.context,R.anim.fade_in)
        var fade_out : Animation = AnimationUtils.loadAnimation(rootView.context,R.anim.fade_out)
        constraintLayoutShadow.setAnimation(fade_in)

        var txtTitle : TextView = rootView.findViewById(R.id.txtTitle)
        var btnYes : Button = rootView.findViewById(R.id.btnYes)
        var btnNo : Button = rootView.findViewById(R.id.btnNo)
        var btnExit : ImageButton = rootView.findViewById(R.id.btnExit)

        txtTitle.text = getString(R.string.deleteUserTitle, username)

        btnNo.setOnClickListener {
            constraintLayoutShadow.setAnimation(fade_out)
            dismiss()
        }
        btnExit.setOnClickListener {
            constraintLayoutShadow.setAnimation(fade_out)
            dismiss()
        }
        btnYes.setOnClickListener {
            constraintLayoutShadow.setAnimation(fade_out)
            dismiss()
            if (username != null) {
                registerObject.deleteUser(username)
            } else {
                Toast.makeText(usersFragmentView.getContext(), "User deletion unsuccessful", Toast.LENGTH_SHORT)
            }
            if(currentUser!=username) {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, UsersFragment()).detach(this).attach(this)
                    .commit()
            } else {
                val intent = Intent(rootView.getContext(), MainActivity::class.java).also{
                    startActivity(it)
                }
            }
        }

        return rootView
    }

    override fun getTheme(): Int {
        return R.style.NoBackgroundDialogTheme
    }
}