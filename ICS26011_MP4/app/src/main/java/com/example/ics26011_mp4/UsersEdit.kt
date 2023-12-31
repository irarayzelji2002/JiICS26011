package com.example.ics26011_mp4

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class UsersEdit : DialogFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.activity_users_edit, container, false)

        var bundle_argument = arguments
        var username = bundle_argument!!.getString("user")
        var currentUser = username.toString()

        var constraintLayoutShadow : ConstraintLayout = rootView.findViewById(R.id.constraintLayoutShadow)
        var fade_in : Animation = AnimationUtils.loadAnimation(rootView.context,R.anim.fade_in)
        var fade_out : Animation = AnimationUtils.loadAnimation(rootView.context,R.anim.fade_out)
        constraintLayoutShadow.setAnimation(fade_in)

        //Declaration of object
        var registerObject = RegisterClass()

        //Declaration of Buttons
        var btnUpdate : Button = rootView.findViewById(R.id.btnUpdate)
        var btnCancel : Button = rootView.findViewById(R.id.btnCancel)
        var btnChangePass : Button = rootView.findViewById(R.id.btnChangePassword)
        var btnReset : ImageButton = rootView.findViewById(R.id.btnReset)
        var btnExit : ImageButton = rootView.findViewById(R.id.btnExit)
        //Declaration of EditText
        var edtFirstName : EditText = rootView.findViewById(R.id.edtFirstName)
        var edtLastName : EditText = rootView.findViewById(R.id.edtLastName)
        var edtUsername : EditText = rootView.findViewById(R.id.edtUsername)
        var edtEmail : EditText = rootView.findViewById(R.id.edtEmail)
        var edtMobile : EditText = rootView.findViewById(R.id.edtMobileNumber)
        var edtBirthday : EditText = rootView.findViewById(R.id.edtBirthday)
        //Declaration of Spinner
        var spinnerAccess : Spinner = rootView.findViewById(R.id.spnAccess)
        //Declaration of TextViews
        var txtTitle : TextView = rootView.findViewById(R.id.txtTitle)
        var txtFirstNameErr : TextView = rootView.findViewById(R.id.txtFirstNameErr)
        var txtLastNameErr : TextView = rootView.findViewById(R.id.txtLastNameErr)
        var txtUsernameErr : TextView = rootView.findViewById(R.id.txtUsernameErr)
        var txtEmailErr : TextView = rootView.findViewById(R.id.txtEmailErr)
        var txtMobileErr : TextView = rootView.findViewById(R.id.txtMobileNumberErr)
        var txtBirthdayErr : TextView = rootView.findViewById(R.id.txtBitrthdayErr)

        //Populating the spinner
        val accesses = resources.getStringArray(R.array.Accesses)
        val adapter = ArrayAdapter(rootView.getContext(), R.layout.activity_spinner, R.id.txtSpinner, accesses)
        spinnerAccess.adapter = adapter

        txtTitle.text = getString(R.string.editUserTitle, username)

        //EditText filled user info
        edtFirstName.setText(username?.let { registerObject.getUserData(it, "firstname") })
        edtLastName.setText(username?.let { registerObject.getUserData(it, "lastname") })
        edtUsername.setText(username?.let { registerObject.getUserData(it, "username") })
        edtEmail.setText(username?.let { registerObject.getUserData(it, "email") })
        edtMobile.setText(username?.let { registerObject.getUserData(it, "mobilenumber") })
        edtBirthday.setText(username?.let { registerObject.getUserData(it, "birthday") })
        spinnerAccess.setSelection(accesses.indexOf(username?.let { registerObject.getUserData(it, "access") }))

        //Setting of onclick listeners
        edtBirthday.setOnClickListener {
            val calendar : Calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(
                rootView.getContext(), R.style.DialogTheme, {
                        it, year, month, day ->
                    val dat = ((month+1).toString() + '/' + day + '/' + year)
                    edtBirthday.setText(dat)
                }, year, month, day
            )
            datePickerDialog.show()
        }
        edtMobile.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int){}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int){
                try {
                    if(edtMobile.text.length >= 12) {
                        txtMobileErr.text = "Mobile number must be 11 digits."
                        edtMobile.setText(edtMobile.text.substring(0,edtMobile.length()-1))
                        edtMobile.setSelection(11)

                    }
                } catch (e : Exception) {
                    Log.e("error_mobile", e.message.toString())
                }
            }

            override fun afterTextChanged(p0: Editable?) {}
        })

        btnUpdate.setOnClickListener {
            var validationObject = ValidationClass()
            val (go1, error1) = validationObject.ValidateChangeUsername(currentUser, edtUsername.text.toString())
            val ErrUsername = "$error1"
            val (go2, error2) = validationObject.ValidateFirstName(edtFirstName.text.toString())
            val ErrFirstName = "$error2"
            val (go3, error3) = validationObject.ValidateLastName(edtLastName.text.toString())
            val ErrLastName = "$error3"
            val (go4, error4) = validationObject.ValidateEmail(edtEmail.text.toString())
            val ErrEmail = "$error4"
            val (go5, error5) = validationObject.ValidateMobile(edtMobile.text.toString())
            val ErrMobile = "$error5"
            val (go6, error6) = validationObject.ValidateBirthday(edtBirthday.text.toString())
            val ErrBirthday = "$error6"
            if("$go1"=="false" || "$go2"=="false" || "$go3"=="false" || "$go4"=="false" || "$go5"=="false" || "$go6"=="false") {
                txtUsernameErr.text=ErrUsername
                txtFirstNameErr.text=ErrFirstName
                txtLastNameErr.text=ErrLastName
                txtEmailErr.text=ErrEmail
                txtMobileErr.text=ErrMobile
                txtBirthdayErr.text=ErrBirthday
            } else {
                //Confirmation Dialog
                var fragmentObject = UsersEditConfirm()
                fragmentObject.setCancelable(false)

                var bundle = Bundle()

                var userData = ArrayList<String>()
                userData.add(edtFirstName.text.toString())               //0
                userData.add(edtLastName.text.toString())                //1
                userData.add(edtUsername.text.toString())                //2
                userData.add(edtEmail.text.toString())                   //3
                userData.add(edtMobile.text.toString())                  //4
                userData.add(edtBirthday.text.toString())                //5
                userData.add(spinnerAccess.getSelectedItem().toString()) //6
                if (username != null) {
                    userData.add(username)
                } //7

                bundle.putStringArrayList("userData", userData)

                fragmentObject.arguments = bundle
                fragmentObject.show(requireActivity().supportFragmentManager, "Custom Fragment")
                Log.i("UsersEdit_userData", userData.toString())
            }
        }
        btnChangePass.setOnClickListener {
            var fragmentObject = UsersEditPass()
            fragmentObject.setCancelable(false)

            var bundle = Bundle()
            bundle.putString("user", username)

            fragmentObject.arguments = bundle
            fragmentObject.show(requireActivity().supportFragmentManager, "Custom Fragment")
        }
        btnCancel.setOnClickListener {
            constraintLayoutShadow.setAnimation(fade_out)
            dismiss()
        }
        btnReset.setOnClickListener {
            edtFirstName.setText(username?.let { registerObject.getUserData(it, "firstname") })
            edtLastName.setText(username?.let { registerObject.getUserData(it, "lastname") })
            edtEmail.setText(username?.let { registerObject.getUserData(it, "email") })
            edtUsername.setText(username?.let { registerObject.getUserData(it, "username") })
            edtMobile.setText(username?.let { registerObject.getUserData(it, "mobilenumber") })
            edtBirthday.setText(username?.let { registerObject.getUserData(it, "birthday") })
            spinnerAccess.setSelection(accesses.indexOf(username?.let { registerObject.getUserData(it, "access") }))
        }
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