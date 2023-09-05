package com.example.myfirstapp3ite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button //import button to solve reference prob
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            Toast.makeText(applicationContext,"This is a Toast", Toast.LENGTH_LONG).show()
        }
        */
    }

    fun toastMsg(view: View) {
        Toast.makeText(this,"This is a Toast", Toast.LENGTH_LONG).show()
    }
}