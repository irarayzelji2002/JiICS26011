package com.example.ics26011_mp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

class Surprised1Question : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surprised1_question)
        setSupportActionBar(findViewById(R.id.main_toolbar))
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)

        val back = findViewById<Button>(R.id.buttonBack)
        back.setOnClickListener {
            val intent = Intent(this, Home::class.java).also{
                it.putExtra("EMOTION", "Surprised")
                startActivity(it)
            }
        }
        val sure = findViewById<Button>(R.id.buttonSure)
        sure.setOnClickListener {
            val intent = Intent(this, Surprised2Feeling::class.java).also{
                it.putExtra("EMOTION", "Surprised")
                it.putExtra("BUTTON_CLICKED", "Sure")
                startActivity(it)
            }
        }
        val nothanks = findViewById<Button>(R.id.buttonNoThanks)
        nothanks.setOnClickListener {
            val intent = Intent(this, Surprised3Quote::class.java).also{
                it.putExtra("EMOTION", "Surprised")
                it.putExtra("BUTTON_CLICKED", "No Thanks")
                startActivity(it)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_home -> {
                startActivity(Intent(this, Home::class.java))
            }
            R.id.nav_info -> {
                startActivity(Intent(this, Info::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}