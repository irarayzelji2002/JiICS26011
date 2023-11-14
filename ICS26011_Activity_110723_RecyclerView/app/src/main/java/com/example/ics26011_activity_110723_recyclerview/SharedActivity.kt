package com.example.ics26011_activity_110723_recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Integer.parseInt

class SharedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared)

        var sharedPreferences = getSharedPreferences("IRA_PREFERENCES",MODE_PRIVATE)
        var edtEmpName : EditText = findViewById(R.id.edtEmpName)
        var edtEmpAge : EditText = findViewById(R.id.edtEmpAge)
        var edtEmpSalary : EditText = findViewById(R.id.edtEmpSalary)
        var btnSave : Button = findViewById(R.id.btnSave)
        var btnGet : Button = findViewById(R.id.btnGet)
        var btnRecyclerView : Button = findViewById(R.id.btnRecyclerView)

        if(sharedPreferences.getString("From","")=="GetShared") {
            edtEmpName.setText(sharedPreferences.getString("SharedEmployee",""))
            edtEmpAge.setText(sharedPreferences.getInt("SharedAge",0).toString())
            edtEmpSalary.setText(sharedPreferences.getString("SharedSalary",""))
        }

        btnSave.setOnClickListener {
            try{
                var sharedEditor = sharedPreferences.edit()
                sharedEditor.putString("SharedEmployee",edtEmpName.text.toString())
                sharedEditor.putInt("SharedAge",parseInt(edtEmpAge.text.toString()))//edtEmpAge.text.toInt()
                sharedEditor.putString("SharedSalary",edtEmpSalary.text.toString())
                sharedEditor.putString("From","SharedActivity")
                sharedEditor.apply()
                Toast.makeText(this, "Saved Successfully", Toast.LENGTH_SHORT).show()
            } catch (e:Exception) {
                Toast.makeText(this, e.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        btnGet.setOnClickListener {
            val intent = Intent(this, GetShared::class.java)
            startActivity(intent)
            /*Toast.makeText(this, sharedPreferences.getString("SharedEmployee","")
                    + "" + sharedPreferences.getInt("SharedAge",0)
                    + "" + sharedPreferences.getString("SharedSalary",""), Toast.LENGTH_SHORT).show()*/
        }
        btnRecyclerView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}