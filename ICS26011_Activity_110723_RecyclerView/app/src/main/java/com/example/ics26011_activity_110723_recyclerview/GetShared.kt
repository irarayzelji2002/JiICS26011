package com.example.ics26011_activity_110723_recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class GetShared : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_shared)

        var sharedPreferences = getSharedPreferences("IRA_PREFERENCES", MODE_PRIVATE)
        var txtEmpName: TextView = findViewById(R.id.txtEmpName)
        var txtEmpAge: TextView = findViewById(R.id.txtEmpAge)
        var txtEmpSalary: TextView = findViewById(R.id.txtEmpSalary)
        var btnBack: Button = findViewById(R.id.btnBack)

        txtEmpName.setText(sharedPreferences.getString("SharedEmployee",""))
        txtEmpAge.setText(sharedPreferences.getInt("SharedAge",0).toString())
        txtEmpSalary.setText(sharedPreferences.getString("SharedSalary",""))

        btnBack.setOnClickListener {
            var sharedEditor = sharedPreferences.edit()
            sharedEditor.putString("From","GetShared")
            sharedEditor.apply()
            val intent = Intent(this, SharedActivity::class.java)
            startActivity(intent)
        }
    }
}