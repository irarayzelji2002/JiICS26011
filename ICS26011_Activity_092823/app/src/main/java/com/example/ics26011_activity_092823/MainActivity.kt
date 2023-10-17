package com.example.ics26011_activity_092823

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var studentName = ji()
        var edtName: EditText = findViewById(R.id.edtName)
        var btnAdd: Button = findViewById(R.id.btnAdd)
        var btnShow: Button = findViewById(R.id.btnShow)
        var btnRedirect: Button = findViewById(R.id.btnRedirect)

        btnAdd.setOnClickListener {
            studentName = ji(edtName.text.toString())
            studentName.addToArray()
            edtName.setText("")
        }

        btnShow.setOnClickListener {
            studentName.showArray()
        }

        btnRedirect.setOnClickListener {
            var redirect = ji(edtName.text.toString())
            val intent = Intent(this, MainActivity2::class.java).also{
                it.putExtra("Index", studentName.arrayIndex.toString())
                startActivity(it)
            }
        }
        /*
        var student_one = ji("Ira",20,"Manila","irarayzel.ji.cics@ust.edu.ph","Single")
        var student_two = ji("irwin",23,"Manila","irwinrayseamsoji@gmail.com","Single")
        student_one.getJiStatus()
        Log.i("info_ji",student_one.name+" "+student_one.address+" "+student_one.age.toString()+" "+student_one.email+" "+student_one.status)
        Log.i("info_ji",student_one.name+" "+student_one.address+" "+student_one.age.toString()+" "+student_one.email+" "+student_one.status)
        */
    }
}