package com.example.ics26011_activity_092823

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var txtName: TextView = findViewById(R.id.txtName)
        var intent = intent.extras

        var name = intent?.getString("Index")
        txtName.apply {
            text = name
        }

        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
    }
}