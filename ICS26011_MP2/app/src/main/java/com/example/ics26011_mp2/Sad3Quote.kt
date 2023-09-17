package com.example.ics26011_mp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView

class Sad3Quote : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sad3_quote)
        setSupportActionBar(findViewById(R.id.main_toolbar))
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)

        val messageFrom = intent.getStringExtra("BUTTON_CLICKED")
        val messageFeeling = intent.getStringExtra("FEELING")
        val back = findViewById<Button>(R.id.buttonBack)
        back.setOnClickListener {
            if(messageFrom=="No Thanks") { startActivity(Intent(this, Sad1Question::class.java)) }
            else if(messageFrom=="Sure") {
                val intent = Intent(this, Sad2Feeling::class.java).also{
                    it.putExtra("FEELING", messageFeeling)
                    startActivity(it)
                }
            }
        }
        val anotherquote = findViewById<Button>(R.id.buttonAnotherQuote)
        val quote = findViewById<TextView>(R.id.quote)
        anotherquote.setOnClickListener {
            val intent = Intent(this, Home::class.java).also{
                quote.text = "Spread love everywhere you go. Let no one ever come to you without leaving happier."
            }
        }
        val backhome = findViewById<Button>(R.id.buttonBackHome)
        backhome.setOnClickListener {
            val intent = Intent(this, Home::class.java).also{
                it.putExtra("EMOTION", "Sad")
                startActivity(it)
            }
        }
        quote.apply {
            if(messageFeeling!=null) { text = "Quote about feeling " + messageFeeling }
            else { text = "Quote about feeling Sad" }
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