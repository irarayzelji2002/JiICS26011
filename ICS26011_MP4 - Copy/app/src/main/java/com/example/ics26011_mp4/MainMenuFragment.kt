package com.example.ics26011_mp4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainMenuFragment : Fragment(R.layout.fragment_main_menu) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        val rootView = inflater.inflate(R.layout.fragment_main_menu, container, false)
        val nav_view : NavigationView = requireActivity().findViewById(R.id.nav_view)

        var btnLogin : Button = rootView.findViewById(R.id.btnLogin)
        var btnRegister : Button = rootView.findViewById(R.id.btnRegister)

        btnLogin.setOnClickListener {
            nav_view.setCheckedItem(R.id.nav_login)
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container, LoginFragment()).commit()
        }

        btnRegister.setOnClickListener {
            nav_view.setCheckedItem(R.id.nav_register)
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container, RegisterFragment()).commit()
        }

        return rootView
    }
}