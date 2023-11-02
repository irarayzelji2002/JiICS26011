package com.example.ics26011_mp4

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import com.google.android.material.navigation.NavigationView

class UsersEditConfirm : DialogFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView : View = inflater.inflate(R.layout.activity_users_edit_confirm, container, false)
        val usersFragmentView = inflater.inflate(R.layout.fragment_users, container, false)

        var bundle_argument = arguments
        var userData = bundle_argument!!.getStringArrayList("userData")

        var registerObject = RegisterClass()

        var btnExit : ImageButton = rootView.findViewById(R.id.btnExit)
        var btnContinue : Button = rootView.findViewById(R.id.btnContinue)
        var btnCancel : Button = rootView.findViewById(R.id.btnCancel)

        var txtTitle : TextView = rootView.findViewById(R.id.txtTitle)
        var txtFirstName : TextView = rootView.findViewById(R.id.txtFirstName)
        var txtLastName : TextView = rootView.findViewById(R.id.txtLastName)
        var txtUsername : TextView = rootView.findViewById(R.id.txtUsername)
        var txtEmail : TextView = rootView.findViewById(R.id.txtEmail)
        var txtMobile : TextView = rootView.findViewById(R.id.txtMobile)
        var txtBirthday : TextView = rootView.findViewById(R.id.txtBirthday)
        var txtAccess : TextView = rootView.findViewById(R.id.txtAccess)

        var username = userData?.get(7).toString()
        txtTitle.text = getString(R.string.editConfirmUserTitle, username)

        txtFirstName.text = userData?.get(0).toString()
        txtLastName.text = userData?.get(1).toString()
        txtUsername.text = userData?.get(2).toString()
        txtEmail.text = userData?.get(3).toString()
        txtMobile.text = userData?.get(4).toString()
        txtBirthday.text = userData?.get(5).toString()
        txtAccess.text = userData?.get(6).toString()

        btnExit.setOnClickListener {
            dismiss()
        }
        btnCancel.setOnClickListener {
            dismiss()
        }
        btnContinue.setOnClickListener {
            if (username != null) {
                registerObject.updateUserData(username, "firstname", userData?.get(0).toString())
                registerObject.updateUserData(username, "lastname", userData?.get(1).toString())
                registerObject.updateUserData(username, "username", userData?.get(2).toString())
                registerObject.updateUserData(username, "email", userData?.get(3).toString())
                registerObject.updateUserData(username, "mobilenumber", userData?.get(4).toString())
                registerObject.updateUserData(username, "birthday", userData?.get(5).toString())
                registerObject.updateUserData(username, "access", userData?.get(6).toString())

                val intent = Intent(rootView.getContext(), LoggedInAdminActivity::class.java).also{
                    it.putExtra("User", userData?.get(2).toString())
                    it.putExtra("From", "UsersEditConfirm")
                    startActivity(it)
                }
            } else {
                Toast.makeText(usersFragmentView.getContext(), "User update unsuccessful", Toast.LENGTH_SHORT)
            }
        }
        return rootView
    }

    override fun getTheme(): Int {
        return R.style.NoBackgroundDialogTheme
    }

}