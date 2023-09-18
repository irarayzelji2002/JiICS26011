package com.example.ics26011_mp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class Info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        setSupportActionBar(findViewById(R.id.main_toolbar))
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)

        val message = intent.getStringExtra("EMOTION")

        if(message=="Happy") emotion="Happy"
        if(message=="Sad") emotion="Sad"
        if(message=="Surprised") emotion="Surprised"
        if(message=="Disgusted") emotion="Disgusted"
        if(message=="Angry") emotion="Angry"
        if(message=="Bad") emotion="Bad"
        if(message=="Fearful") emotion="Fearful"
    }
    public var emotion: String = ""
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_home -> {
                startActivity(Intent(this, Home::class.java).putExtra("EMOTION", emotion))
            }
            R.id.nav_info -> {
                startActivity(Intent(this, Info::class.java).putExtra("EMOTION", emotion))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}