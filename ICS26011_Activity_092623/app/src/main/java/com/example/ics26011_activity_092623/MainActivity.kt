package com.example.ics26011_activity_092623

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var edtLoginUsername = findViewById<EditText>(R.id.edtLoginUsername)
        var edtLoginPassword = findViewById<EditText>(R.id.edtLoginPassword)
        var edtRegFullName = findViewById<EditText>(R.id.edtRegFullName)
        var edtRegSection = findViewById<EditText>(R.id.edtRegSection)
        var edtRegUsername = findViewById<EditText>(R.id.edtRegUsername)
        var edtRegPassword = findViewById<EditText>(R.id.edtRegPassword)

        var txtError = findViewById<TextView>(R.id.txtError)

        var btnLogin = findViewById<Button>(R.id.btnLogin)
        var btnRegister = findViewById<Button>(R.id.btnRegister)

        var arrayUsername = ArrayList<String>()
        var arrayPassword = ArrayList<String>()
        var arrayFullName = ArrayList<String>()
        var arraySection = ArrayList<String>()

        var ToastReg: String = ""
        var ErrSpecialCharacter: String = ""
        var ErrUppercase: String = ""
        var ErrLowercase: String = ""
        var ErrNumber: String = ""
        var ErrMinimum: String = ""
        var ErrCount: Int = 0

        btnRegister.setOnClickListener {
            try {
                val existingAccount = arrayUsername.stream().anyMatch {
                        x -> x == edtRegUsername.text.toString()
                }
                Log.i("info_ji", "Account existing: "+existingAccount.toString())
                if(edtRegUsername.text.toString().isNullOrEmpty() || edtRegPassword.text.toString().isNullOrEmpty() || edtRegFullName.text.toString().isNullOrEmpty() || edtRegSection.text.toString().isNullOrEmpty()) {
                    ToastReg = "All fields are required"
                    Toast.makeText(this, ToastReg, Toast.LENGTH_LONG).show()
                } else {
                    //Password Validation
                    if(edtRegPassword.text.toString().length<8) {
                        ErrMinimum = "a minimum of 8 characters, "
                        ErrCount++
                    }
                    if(!Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE).matcher(edtRegPassword.text.toString()).find()) { //no special character
                        ErrSpecialCharacter = "a special character, "
                        ErrCount++
                    }
                    if(!Pattern.compile("[A-Z]").matcher(edtRegPassword.text.toString()).find()) {
                        ErrUppercase = "an uppercase letter, "
                        ErrCount++
                    }
                    if(!Pattern.compile("[a-z]").matcher(edtRegPassword.text.toString()).find()) {
                        ErrLowercase = "a lowercase letter, "
                        ErrCount++
                        Log.i("reg", "no lowercase")
                    }
                    if(!Pattern.compile("[0-9]", Pattern.CASE_INSENSITIVE).matcher(edtRegPassword.text.toString()).find()) {
                        ErrNumber = "a number, "
                        ErrCount++
                    }
                    if(ErrCount>0) { //contains at least 1 error
                        ToastReg = "Password must have " + ErrMinimum + ErrSpecialCharacter + ErrUppercase + ErrLowercase + ErrNumber
                        ToastReg = ToastReg.substring(0, ToastReg.length-2)+"."
                        txtError.setText(ToastReg)
                        ErrSpecialCharacter = ""
                        ErrUppercase = ""
                        ErrLowercase = ""
                        ErrNumber = ""
                        ErrMinimum = ""
                        ErrCount = 0
                    } else {
                        if(!existingAccount) {
                            arrayUsername.add(edtRegUsername.text.toString())
                            arrayPassword.add(edtRegPassword.text.toString())
                            arrayFullName.add(edtRegFullName.text.toString())
                            arraySection.add(edtRegSection.text.toString())
                            Toast.makeText(this, "Account Added: "+edtRegUsername.text.toString(), Toast.LENGTH_SHORT).show()
                            edtRegUsername.setText("")
                            edtRegPassword.setText("")
                            edtRegFullName.setText("")
                            edtRegSection.setText("")
                        } else {
                            ToastReg = "There is an existing account"
                            Toast.makeText(this, ToastReg, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e("error_register",e.message.toString())
            }
        }

        btnLogin.setOnClickListener {
            try {
                if(edtLoginUsername.text.toString().isNullOrEmpty() || edtLoginPassword.text.toString().isNullOrEmpty()) {
                    Toast.makeText(this, "Username and Password fields are required", Toast.LENGTH_SHORT).show()
                } else {
                    val existingAccount = arrayUsername.indexOf(edtLoginUsername.text.toString())
                    if (existingAccount >= 0 && arrayPassword[existingAccount]==edtLoginPassword.text.toString()) {
                        val intent = Intent(this, Homepage::class.java).also{
                            it.putExtra("FULLNAME", arrayFullName[existingAccount])
                            it.putExtra("SECTION", arraySection[existingAccount])
                            startActivity(it)
                        }
                        edtLoginUsername.setText("")
                        edtLoginPassword.setText("")
                        edtRegUsername.setText("")
                        edtRegPassword.setText("")
                        edtRegFullName.setText("")
                        edtRegSection.setText("")
                    } else if (existingAccount >= 0) {
                        Toast.makeText(this, "Password is incorrect", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Account is not existing", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                Log.e("error_login",e.message.toString())
            }
        }
    }
}