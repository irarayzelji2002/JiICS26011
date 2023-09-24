package com.example.ics26011_activity_21923

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Declaration of an array list
        var arrayAccount = ArrayList<String>()
        var arrayPassword = ArrayList<String>()

        //Declaration of an array
        var implicit_array = arrayOf(1,2,"3",4,5,6)
        var explicit_array = arrayOf<Int>(1,2,3,4,5,6)

        var textAccount = findViewById<TextView>(R.id.txtAccount)
        var textAccounts = findViewById<TextView>(R.id.txtAccounts)

        var buttonAccount = findViewById<Button>(R.id.btnAccount)
        var buttonShow = findViewById<Button>(R.id.btnShow)
        var buttonUpdate = findViewById<Button>(R.id.btnUpdate)
        var buttonDelete = findViewById<Button>(R.id.btnDelete)

        var editAccount = findViewById<EditText>(R.id.edtAccount)
        var editPassword = findViewById<EditText>(R.id.edtPassword)

        var addToastStatement: String = "Account is already existing"
        var updateToastStatement: String = "Account is not existing"

        buttonAccount.setOnClickListener {
            //getText() && setText()
            try {
                val existingAccount = arrayAccount.stream().anyMatch {
                    x -> x == editAccount.text.toString()
                }
                Log.i("info_ji", existingAccount.toString())
                if(!existingAccount) {
                    arrayAccount.add(editAccount.text.toString())
                    textAccount.setText(arrayAccount.size.toString())
                    addToastStatement = "Account added successfully!"
                    Log.i("info_ji", addToastStatement.toString())
                }
                Toast.makeText(this, addToastStatement, Toast.LENGTH_SHORT).show()
                addToastStatement = "Account is already existing"
            } catch (e: Exception) {
                Log.e("error_ji",e.message.toString())
            }
            arrayPassword.add(editPassword.text.toString())
        }

        buttonUpdate.setOnClickListener {
            try {
                val existingAccount = arrayAccount.indexOf(editAccount.text.toString())
                if(existingAccount>=0) {
                    arrayAccount[existingAccount] = arrayAccount[existingAccount] + "_updated"
                    updateToastStatement = "Account Updated Successfully!"
                    Log.i("info_ji", updateToastStatement)
                    Toast.makeText(this, "Updated account: " + arrayAccount[existingAccount], Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Account is not existing", Toast.LENGTH_SHORT).show()
                }
                updateToastStatement = "Account is not existing!"

            } catch (e: Exception) {
                Log.e("error_ji",e.message.toString())
            }
        }

        buttonShow.setOnClickListener {
            try {
                if(!textAccounts.text.isNullOrEmpty()) {
                    textAccounts.setText("")
                }
                val arraySize: Int = arrayAccount.size
                for (i in 0 until arraySize) {
                    textAccounts.append(arrayAccount.get(i))
                    textAccounts.append("\n");
                    Log.i("Show with for loop", arrayAccount[i].toString())
                }
                var i: Int = 0
                while(i<arraySize) {
                    Log.i("Show with while loop", arrayAccount[i].toString())
                    i++
                }
                i = 0
                do {
                    Log.i("Show with do while loop", arrayAccount[i].toString())
                    i++
                } while(i<arraySize)
            } catch (e: Exception) {
                Log.e("error_ji",e.message.toString())
            }
        }

        buttonDelete.setOnClickListener {
            try {
                val existingAccount = arrayAccount.indexOf(editAccount.text.toString())
                if(existingAccount>=0) {
                    arrayAccount.removeAt(existingAccount)
                    Toast.makeText(this, "Deleted Account: " + editAccount.text.toString(), Toast.LENGTH_SHORT).show()
                    textAccount.setText(arrayAccount.size.toString())
                    editAccount.setText("")
                    Log.i("info_ji", arrayAccount.toString())
                } else {
                    Toast.makeText(this, "Account is not existing", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Log.e("error_ji",e.message.toString())
            }
        }
    }
}