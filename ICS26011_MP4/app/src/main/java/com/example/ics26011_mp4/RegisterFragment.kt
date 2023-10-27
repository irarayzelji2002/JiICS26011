package com.example.ics26011_mp4

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.util.Calendar

class RegisterFragment : Fragment(R.layout.fragment_register) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_register, container, false)

        //Declaration of object
        var registerObject = RegisterClass()

        //Declaration of Buttons
        var btnRegister : Button = rootView.findViewById(R.id.btnRegister)
        var btnMainMenu : Button = rootView.findViewById(R.id.btnMainMenu)
        //Declaration of EditText
        var edtFirstName : EditText = rootView.findViewById(R.id.edtFirstName)
        var edtLastName : EditText = rootView.findViewById(R.id.edtLastName)
        var edtUsername : EditText = rootView.findViewById(R.id.edtUsername)
        var edtPassword : EditText = rootView.findViewById(R.id.edtPassword)
        var edtEmail : EditText = rootView.findViewById(R.id.edtEmail)
        var edtMobile : EditText = rootView.findViewById(R.id.edtMobileNumber)
        var edtBirthday : EditText = rootView.findViewById(R.id.edtBirthday)
        //Declaration of Spinner
        var spinnerAccess : Spinner = rootView.findViewById(R.id.spnAccess)
        //Declaration of TextViews
        var txtUsernameErr : TextView = rootView.findViewById(R.id.txtUsernameErr)
        var txtPasswordErr : TextView = rootView.findViewById(R.id.txtPasswordErr)
        var txtFirstNameErr : TextView = rootView.findViewById(R.id.txtFirstNameErr)
        var txtLastNameErr : TextView = rootView.findViewById(R.id.txtLastNameErr)
        var txtEmailErr : TextView = rootView.findViewById(R.id.txtEmailErr)
        var txtMobileErr : TextView = rootView.findViewById(R.id.txtMobileNumberErr)
        var txtBirthdayErr : TextView = rootView.findViewById(R.id.txtBitrthdayErr)

        //Setting of onclick listeners
        edtBirthday.setOnClickListener {
            val calendar : Calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(
                rootView.getContext(), {
                        it, year, month, day ->
                    val dat = (day.toString() + '/' + (month+1) + '/' + year)
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

        btnRegister.setOnClickListener {
            //showConfirmationDialog()

            var validationObject = ValidationClass()
            val (go1, error1) = validationObject.ValidateUsername(edtUsername.text.toString())
            val ErrUsername = "$error1"
            val (go2, error2) = validationObject.ValidatePassword(edtPassword.text.toString())
            val ErrPassword = "$error2"
            val (go3, error3) = validationObject.ValidateFirstName(edtFirstName.text.toString())
            val ErrFirstName = "$error3"
            val (go4, error4) = validationObject.ValidateLastName(edtLastName.text.toString())
            val ErrLastName = "$error4"
            val (go5, error5) = validationObject.ValidateEmail(edtEmail.text.toString())
            val ErrEmail = "$error5"
            val (go6, error6) = validationObject.ValidateMobile(edtMobile.text.toString())
            val ErrMobile = "$error6"
            val (go7, error7) = validationObject.ValidateBirthday(edtBirthday.text.toString())
            val ErrBirthday = "$error7"
            //Testing
            Log.i("info_get1.1","$go1")
            Log.i("info_get1.2","$error1")
            Log.i("info_get1.3",ErrUsername)
            Log.i("infobeforeifelse","$go1, $go2, $go3, $go4, $go5, $go6, $go7")
            Log.i("infobeforeifelse",
                ("$go1"=="false" || "$go2"=="false" || "$go3"=="false" || "$go4"=="false" || "$go5"=="false" || "$go6"=="false" || "$go7"=="false").toString()
            )
            if("$go1"=="false" || "$go2"=="false" || "$go3"=="false" || "$go4"=="false" || "$go5"=="false" || "$go6"=="false" || "$go7"=="false") {
                txtUsernameErr.text = ErrUsername
                txtPasswordErr.text=ErrPassword
                txtFirstNameErr.text=ErrFirstName
                txtLastNameErr.text=ErrLastName
                txtEmailErr.text=ErrEmail
                txtMobileErr.text=ErrMobile
                txtBirthdayErr.text=ErrBirthday
                Log.i("info", "inside if")
            } else {
                Log.i("info", "inside else")
                //Confirmation Dialog
                var fragmentObject = FragmentClass()
                fragmentObject.setCancelable(false)

                var bundle = Bundle()

                var userData = ArrayList<String>()
                userData.add(edtUsername.text.toString())                //0
                userData.add(edtPassword.text.toString())                //1
                userData.add(edtFirstName.text.toString())               //2
                userData.add(edtLastName.text.toString())                //3
                userData.add(edtEmail.text.toString())                   //4
                userData.add(edtMobile.text.toString())                  //5
                userData.add(edtBirthday.text.toString())                //6
                userData.add(spinnerAccess.getSelectedItem().toString()) //7

                bundle.putStringArrayList("userData", userData)

                fragmentObject.arguments = bundle
                fragmentObject.show(requireActivity().supportFragmentManager, "Custom Fragment")
                Log.i("userData", userData.toString())
            }
        }

        btnMainMenu.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container, MainMenuFragment()).commit()
        }

        //Populating the spinner
        val accesses = resources.getStringArray(R.array.Accesses)
        val adapter = ArrayAdapter(rootView.getContext(), R.layout.activity_spinner, R.id.txtSpinner, accesses)
        spinnerAccess.adapter = adapter

        return rootView
    }
}