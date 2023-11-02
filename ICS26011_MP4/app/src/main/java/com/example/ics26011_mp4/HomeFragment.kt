package com.example.ics26011_mp4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.google.android.material.navigation.NavigationView
import java.util.Optional

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        val nav_view : NavigationView = requireActivity().findViewById(R.id.nav_view)

        var btnLogout : Button = rootView.findViewById(R.id.btnLogout)

        var txtGreeting : TextView = rootView.findViewById(R.id.txtGreeting)
        var txtUsername : TextView = rootView.findViewById(R.id.txtUsername)
        var txtFirstName : TextView = rootView.findViewById(R.id.txtFirstName)
        var txtLastName : TextView = rootView.findViewById(R.id.txtLastName)
        var txtEmail : TextView = rootView.findViewById(R.id.txtEmail)
        var txtMobile : TextView = rootView.findViewById(R.id.txtMobile)
        var txtBirthday : TextView = rootView.findViewById(R.id.txtBirthday)
        var txtAccess : TextView = rootView.findViewById(R.id.txtAccess)

        var username = activity?.intent?.getStringExtra("User").toString()
        txtGreeting.text = getString(R.string.greeting, username)
        txtUsername.text = username

        var registerObject = RegisterClass()
        txtFirstName.text = username?.let { registerObject.getUserData(it,"firstname") }
        txtLastName.text = username?.let { registerObject.getUserData(it,"lastname") }
        txtEmail.text = username?.let { registerObject.getUserData(it,"email") }
        txtMobile.text = username?.let { registerObject.getUserData(it,"mobilenumber") }
        txtBirthday.text = username?.let { registerObject.getUserData(it,"birthday") }
        txtAccess.text = username?.let { registerObject.getUserData(it,"access") }

        btnLogout.setOnClickListener {
            var fragmentObject = LogoutConfirm()
            fragmentObject.setCancelable(false)
            fragmentObject.show(requireActivity().supportFragmentManager, "Logout Confirm Dialog")
        }

        return rootView
    }
}