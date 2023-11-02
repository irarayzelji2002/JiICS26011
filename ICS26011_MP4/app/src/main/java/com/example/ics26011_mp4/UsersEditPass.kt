package com.example.ics26011_mp4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment

class UsersEditPass : DialogFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.activity_users_edit_pass, container, false)
        val usersFragmentView = inflater.inflate(R.layout.fragment_users, container, false)

        var bundle_argument = arguments
        var user = bundle_argument!!.getString("user")
        var username : String = user.toString()

        //Declaration of object
        var registerObject = RegisterClass()

        var btnExit : ImageButton = rootView.findViewById(R.id.btnExit)
        var btnContinue : Button = rootView.findViewById(R.id.btnContinue)
        var btnCancel : Button = rootView.findViewById(R.id.btnCancel)

        var txtOldPassErr : TextView = rootView.findViewById(R.id.txtOldPassErr)
        var txtNewPassErr : TextView = rootView.findViewById(R.id.txtNewPassErr)
        var txtConfirmPassErr : TextView = rootView.findViewById(R.id.txtConfirmPassErr)
        txtOldPassErr.setVisibility(View.GONE)
        txtNewPassErr.setVisibility(View.GONE)
        txtConfirmPassErr.setVisibility(View.GONE)

        var edtOldPass : EditText = rootView.findViewById(R.id.edtOldPass)
        var edtNewPass : EditText = rootView.findViewById(R.id.edtNewPass)
        var edtConfirmPass : EditText = rootView.findViewById(R.id.edtConfirmPass)

        btnExit.setOnClickListener {
            dismiss()
        }
        btnCancel.setOnClickListener {
            dismiss()
        }
        btnContinue.setOnClickListener {
            txtOldPassErr.setVisibility(View.GONE)
            txtNewPassErr.setVisibility(View.GONE)
            txtConfirmPassErr.setVisibility(View.GONE)

            //Verify Old Password is correct
            var typedPass = edtOldPass.text.toString()
            var ErrOldPass = ""
            var go1:Boolean = false
            if(typedPass.isNullOrEmpty()){
                ErrOldPass = "This field is required."
            } else {
                if(registerObject.VerifyLoginDetails(username,typedPass)) {
                    Log.i("info_correct_details", registerObject.VerifyLoginDetails(username,typedPass).toString())
                    go1 = true
                } else {
                    Log.i("info_wrong_details", registerObject.VerifyLoginDetails(username,typedPass).toString())
                    ErrOldPass = "Password is incorrect."
                }
            }
            //Validate New Password
            var validationObject = ValidationClass()
            val (go2, error2) = validationObject.ValidatePassword(edtNewPass.text.toString())
            val ErrNewPass = "$error2"
            //Verify Confirm Password
            var ErrConfirmPass = ""
            var go3:Boolean = false
            if(edtConfirmPass.text.toString().isNullOrEmpty()) {
                ErrConfirmPass = "This field is required."
            } else if(edtConfirmPass.text.toString()!=edtNewPass.text.toString()) {
                ErrConfirmPass = "Must match new password."
            } else {
                go3 = true
            }

            //Display Error or Continue
            if("$go1"=="false" || "$go2"=="false" || "$go3"=="false") {
                if(go1 == false) {
                    txtOldPassErr.setVisibility(View.VISIBLE)
                    txtOldPassErr.text=ErrOldPass
                }
                if(go2 == false) {
                    txtNewPassErr.setVisibility(View.VISIBLE)
                    txtNewPassErr.text=ErrNewPass
                }
                if(go3 == false) {
                    txtConfirmPassErr.setVisibility(View.VISIBLE)
                    txtConfirmPassErr.text=ErrConfirmPass
                }
            } else {
                var registerObject = RegisterClass()
                if (username != null) {
                    registerObject.updateUserData(username,"password",edtNewPass.text.toString())
                    val intent = Intent(rootView.getContext(), LoggedInAdminActivity::class.java).also{
                        it.putExtra("User", username)
                        it.putExtra("From", "UsersEditPass")
                        startActivity(it)
                    }
                } else {
                    Toast.makeText(usersFragmentView.getContext(), "Change password unsuccessful", Toast.LENGTH_SHORT)
                }
            }
        }

        return rootView
    }
}