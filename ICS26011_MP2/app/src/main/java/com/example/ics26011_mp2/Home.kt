package com.example.ics26011_mp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(findViewById(R.id.main_toolbar))
        getSupportActionBar()?.setDisplayShowTitleEnabled(false);

        val message = intent.getStringExtra("EMOTION")
        val textView = findViewById<TextView>(R.id.textViewEmotion)
        textView.apply {
            text = message
        }

        val happy = findViewById<ImageButton>(R.id.gifImageButtonHappy)
        val sad = findViewById<ImageButton>(R.id.gifImageButtonSad)
        val surprised = findViewById<ImageButton>(R.id.gifImageButtonSurprised)
        val disgusted = findViewById<ImageButton>(R.id.gifImageButtonDisgusted)
        val angry = findViewById<ImageButton>(R.id.gifImageButtonAngry)
        val bad = findViewById<ImageButton>(R.id.gifImageButtonBad)
        val fearful = findViewById<ImageButton>(R.id.gifImageButtonFearful)
        happy.setOnClickListener {
            textView.text="Happy"
        }
        sad.setOnClickListener {
            textView.text="Sad"
        }
        surprised.setOnClickListener {
            textView.text="Surprised"
        }
        disgusted.setOnClickListener {
            textView.text="Disgusted"
        }
        angry.setOnClickListener {
            textView.text="Angry"
        }
        bad.setOnClickListener {
            textView.text="Bad"
        }
        fearful.setOnClickListener {
            textView.text="Fearful"
        }

        val continueBtn = findViewById<Button>(R.id.buttonContinue)
        continueBtn.setOnClickListener {
            if(textView.text=="Happy") {
                startActivity(Intent(this, Happy1Question::class.java))
            } else if(textView.text=="Sad") {
                startActivity(Intent(this, Sad1Question::class.java))
            } else if(textView.text=="Surprised") {
                startActivity(Intent(this, Surprised1Question::class.java))
            } else if(textView.text=="Disgusted") {
                startActivity(Intent(this, Disgusted1Question::class.java))
            } else if(textView.text=="Angry") {
                startActivity(Intent(this, Angry1Question::class.java))
            } else if(textView.text=="Bad") {
                startActivity(Intent(this, Bad1Question::class.java))
            } else if(textView.text=="Fearful") {
                startActivity(Intent(this, Fearful1Question::class.java))
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
                startActivity(Intent(this, Home::class.java).putExtra("EMOTION", findViewById<TextView>(R.id.textViewEmotion).text))
            }
            R.id.nav_info -> {
                startActivity(Intent(this, Info::class.java).putExtra("EMOTION", findViewById<TextView>(R.id.textViewEmotion).text))
            }
            //R.id.nav_home -> Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
            //R.id.nav_info ->
        }
        return super.onOptionsItemSelected(item)
    }

    fun toastMsg(view: View) {
        Toast.makeText(this,"This is a Toast", Toast.LENGTH_LONG).show()
    }
}