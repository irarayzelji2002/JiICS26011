package com.example.ics26011_mp4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class LoginFragment : Fragment(R.layout.fragment_login) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_login, container, false)
        val nav_view : NavigationView = requireActivity().findViewById(R.id.nav_view)

        var edtUsername : EditText = rootView.findViewById(R.id.edtUsername)
        var edtPassword : EditText = rootView.findViewById(R.id.edtPassword)
        var txtLoginErr : TextView = rootView.findViewById(R.id.txtLoginErr)
        var btnLogin : Button = rootView.findViewById(R.id.btnLogin)
        var btnRegister : Button = rootView.findViewById(R.id.btnRegister)

        btnLogin.setOnClickListener {
            var ErrMsg = ""
            try {
                var username = edtUsername.text.toString()
                var password = edtPassword.text.toString()
                var registerObject = RegisterClass()
                var findUsername = registerObject.ReturnArray().stream().anyMatch {x -> x.username.equals(username)}

                if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
                    ErrMsg = "Username and password field is required."
                } else if(findUsername == true) {
                    if(registerObject.VerifyLoginDetails(username,password)) {
                        Log.i("info_correct_details", registerObject.VerifyLoginDetails(username,password).toString())
                        if(registerObject.isUser(username)){
                            val intent = Intent(rootView.getContext(), LoggedInUserActivity::class.java).also{
                                it.putExtra("User", username)
                                startActivity(it)
                            }
                        } else { //is an admin
                            val intent = Intent(rootView.getContext(), LoggedInAdminActivity::class.java).also{
                                it.putExtra("User", username)
                                startActivity(it)
                            }
                        }
                    } else {
                        Log.i("info_wrong_details", registerObject.VerifyLoginDetails(username,password).toString())
                        ErrMsg = "Username or password is incorrect."
                    }
                } else { //no username found
                    ErrMsg = "Username or password is incorrect."
                }
                txtLoginErr.text = ErrMsg
            } catch (e : Exception) {
                Log.e("error_login", e.message.toString())
            }
        }

        btnRegister.setOnClickListener {
            nav_view.setCheckedItem(R.id.nav_register)
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container, RegisterFragment()).commit()
        }

        return rootView
    }
}