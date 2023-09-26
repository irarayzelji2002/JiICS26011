package com.example.ics26011_activity_092623

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class Homepage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        var txtFullName = findViewById<TextView>(R.id.txtFullName)
        var txtSection = findViewById<TextView>(R.id.txtSection)
        var btnLogout = findViewById<Button>(R.id.btnLogout)

        val messageName = intent.getStringExtra("FULLNAME")
        txtFullName.apply {
            text = messageName
        }
        val messageSection = intent.getStringExtra("SECTION")
        txtSection.apply {
            text = messageSection
        }

        btnLogout.setOnClickListener {
            try {
                val Intent = Intent(this, MainActivity::class.java)
                startActivity(Intent)
            } catch (e: Exception) {
                Log.e("error_logout",e.message.toString())
            }
        }
    }
}