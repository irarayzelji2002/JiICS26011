package com.example.ics26011_activity_100323_oop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class MainMenuFragment : Fragment(R.layout.fragment_main_menu) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_main_menu, container, false)

        var btnLogin : Button = rootView.findViewById(R.id.btnLogin)
        var btnRegister : Button = rootView.findViewById(R.id.btnRegister)

        btnLogin.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container, LoginFragment()).commit()
        }

        btnRegister.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container, RegisterFragment()).commit()
        }

        return rootView
    }
}