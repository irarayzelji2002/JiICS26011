package com.example.ics26011_activity_21923

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arrayAccount = ArrayList<String>()
        var arrayPassword = ArrayList<String>()

        var textAccount = findViewById<TextView>(R.id.txtAccount)
        var textAccounts = findViewById<TextView>(R.id.txtAccounts)

        var buttonAdd = findViewById<Button>(R.id.btnAdd)
        var buttonShow = findViewById<Button>(R.id.btnShow)
        var buttonUpdate = findViewById<Button>(R.id.btnUpdate)
        var buttonDelete = findViewById<Button>(R.id.btnDelete)

        var editAccount = findViewById<EditText>(R.id.edtAccount)
        var editPassword = findViewById<EditText>(R.id.edtPassword)

        buttonAdd.setOnClickListener {
            try {
                if(editAccount.text.toString().isNullOrEmpty() || editPassword.text.toString().isNullOrEmpty()) {
                    Toast.makeText(this, "Username and Password fields are required", Toast.LENGTH_SHORT).show()
                } else {
                    val existingAccount = arrayAccount.stream().anyMatch {
                        x -> x == editAccount.text.toString()
                    }
                    Log.i("info_add", "Account exist: "+existingAccount.toString())
                    if(!existingAccount) {
                        arrayAccount.add(editAccount.text.toString())
                        arrayPassword.add(editPassword.text.toString())
                        textAccount.setText(arrayAccount.size.toString())
                        val addedAccount = arrayAccount.indexOf(editAccount.text.toString())
                        Toast.makeText(this, "Added Account: " + arrayAccount[addedAccount], Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Account is already existing", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                Log.e("error_add",e.message.toString())
            }
        }

        buttonUpdate.setOnClickListener {
            try {
                if(editAccount.text.toString().isNullOrEmpty() || editPassword.text.toString().isNullOrEmpty()) {
                    Toast.makeText(this, "Username and Password fields are required", Toast.LENGTH_SHORT).show()
                } else {
                    val existingAccount = arrayAccount.indexOf(editAccount.text.toString())
                    if (existingAccount >= 0 && arrayPassword[existingAccount]==editPassword.text.toString()) {
                        var countExact = arrayAccount.count { it==arrayAccount[existingAccount]+"_updated" }
                        var countRepeated = arrayAccount.count { it.substring(0,it.length-1)==arrayAccount[existingAccount]+"_updated" }
                        var count = countExact + countRepeated
                        if (count == 0) {
                            arrayAccount[existingAccount] = arrayAccount[existingAccount] + "_updated"
                            arrayPassword[existingAccount] = arrayPassword[existingAccount] + "_updated"
                            Log.i("info_update", "1st update on same username")
                        } else if (count>0) {
                            var lastOccurrenceNoNum = arrayAccount.findLast{ it==arrayAccount[existingAccount]+"_updated" }
                            var lastOccurrenceWithNum = arrayAccount.findLast{ it.substring(0,it.length-1)==arrayAccount[existingAccount]+"_updated" }
                            var numToAdd: Int = 0
                            if (lastOccurrenceNoNum != null && lastOccurrenceNoNum.last()=='d' && lastOccurrenceWithNum==null) {
                                arrayAccount[existingAccount] = arrayAccount[existingAccount] + "_updated2"
                                arrayPassword[existingAccount] = arrayPassword[existingAccount] + "_updated2"
                                Log.i("info_update", "2nd update on same username")
                            } else if (lastOccurrenceWithNum != null) {
                                numToAdd = lastOccurrenceWithNum.last().digitToInt()+1
                                arrayAccount[existingAccount] = arrayAccount[existingAccount] + "_updated" + numToAdd
                                arrayPassword[existingAccount] = arrayPassword[existingAccount] + "_updated" + numToAdd
                                Log.i("info_update", "Nth update on same username")
                            } else {
                                Log.i("error","Failed to update account")
                            }
                        }
                        Toast.makeText(this, "Updated account: " + arrayAccount[existingAccount], Toast.LENGTH_SHORT).show()
                    } else if(existingAccount >= 0) {
                        Toast.makeText(this, "Password is incorrect", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Account is not existing", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                Log.e("error_update",e.message.toString())
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
                    Log.i("Show with for loop", "Username: "+arrayAccount[i].toString()+", Password: "+arrayPassword[i].toString())
                }
                var i: Int = 0
                while(i<arraySize) {
                    Log.i("Show with while loop", "Username: "+arrayAccount[i].toString()+", Password: "+arrayPassword[i].toString())
                    i++
                }
                i = 0
                do {
                    Log.i("Show with do while loop", "Username: "+arrayAccount[i].toString()+", Password: "+arrayPassword[i].toString())
                    i++
                } while(i<arraySize)
            } catch (e: Exception) {
                Log.e("error_show",e.message.toString())
            }
        }

        buttonDelete.setOnClickListener {
            try {
                if(editAccount.text.toString().isNullOrEmpty() || editPassword.text.toString().isNullOrEmpty()) {
                    Toast.makeText(this, "Username and Password fields are required", Toast.LENGTH_SHORT).show()
                } else {
                    val existingAccount = arrayAccount.indexOf(editAccount.text.toString())
                    if (existingAccount >= 0 && arrayPassword[existingAccount]==editPassword.text.toString()) {
                        arrayAccount.removeAt(existingAccount)
                        arrayPassword.removeAt(existingAccount)
                        Toast.makeText(this, "Deleted Account: " + editAccount.text.toString(), Toast.LENGTH_SHORT).show()
                        textAccount.setText(arrayAccount.size.toString())
                        editAccount.setText("")
                        editPassword.setText("")
                    } else if (existingAccount >= 0) {
                        Toast.makeText(this, "Password is incorrect", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Account is not existing", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                Log.e("error_delete",e.message.toString())
            }
        }
    }
}