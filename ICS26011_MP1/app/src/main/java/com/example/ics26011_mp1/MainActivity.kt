package com.example.ics26011_mp1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun toastMsg(view: View) {
        Toast.makeText(this,"This is a Toast", Toast.LENGTH_LONG).show()
    }
}