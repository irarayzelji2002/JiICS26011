package com.example.ics26011_activity_102623

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Integer.parseInt
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val randomnum = Random
        var ranging = randomnum.nextInt(10) //0-10 random numbers
        ranging++
        var largestNum : Int = 0

        val txtRandom = findViewById<TextView>(R.id.txtRandomNo)
        val edtValue = findViewById<EditText>(R.id.edtValue)
        val btnRandomize = findViewById<TextView>(R.id.btnRandomize)
        val btnHashMap = findViewById<TextView>(R.id.btnHashMap)

        //txtRandom.text = ranging.toString()
        //Log.i("num", ranging.toString())

        btnRandomize.setOnClickListener {
            var intValue:Int
            if(edtValue.text.toString().isNullOrEmpty()) {
                Toast.makeText(this, "The field is required.", Toast.LENGTH_SHORT).show()
            } else if(edtValue.text.toString().toIntOrNull()==null) {
                Toast.makeText(this, "Please enter an integer.", Toast.LENGTH_SHORT).show()
            } else {
                intValue = parseInt(edtValue.text.toString())
                var ranging = randomnum.nextInt(intValue)
                ranging++
                txtRandom.text = ranging.toString()
                Log.i("else", ranging.toString())
                if(intValue>largestNum) {
                    largestNum=intValue
                }
            }
        }

        btnHashMap.setOnClickListener {
            val intent = Intent(this, HashMap::class.java).also{
                //it.putExtra("Index", "")
                startActivity(it)
            }
        }
    }
}