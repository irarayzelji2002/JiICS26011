package com.example.ics26011_activity_111423_firebaseapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnWrite : Button = findViewById(R.id.btnWrite)
        var btnUpdate : Button = findViewById(R.id.btnUpdate)
        var btnRead : Button = findViewById(R.id.btnRead)
        var btnRemove : Button = findViewById(R.id.btnRemove)

        //create table if not existing
        databaseReference = FirebaseDatabase.getInstance().getReference("DatabaseName")

        var databaseClass = DatabaseClass("Ira","Software Engineer","IT")

        btnWrite.setOnClickListener {
            //insert data to DatabaseName (table), IraItem (id), databaseClass (details id)
            var dataKey = databaseReference.push().getKey() //option for id
            databaseReference.child("uniqueId").setValue(databaseClass).addOnSuccessListener {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            }
        }

        btnUpdate.setOnClickListener {
            //update
            var empUpdate = mapOf<String, String>("empName" to "Ira Rayzel Ji", "empPosition" to "Staff Engineer", "empDepartment" to "Engineering")
            databaseReference.child("uniqueId").updateChildren(empUpdate).addOnSuccessListener {
                Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show()
            }
        }

        btnRemove.setOnClickListener{
            databaseReference.child("uniqueId").removeValue().addOnSuccessListener {
                Toast.makeText(this, "Removed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}