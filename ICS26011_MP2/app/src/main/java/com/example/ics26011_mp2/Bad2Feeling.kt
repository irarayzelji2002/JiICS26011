package com.example.ics26011_mp2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Bad2Feeling : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bad2_feeling)
        setSupportActionBar(findViewById(R.id.main_toolbar))
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)

        val back = findViewById<Button>(R.id.buttonBack)
        back.setOnClickListener {
            val intent = Intent(this, Bad1Question::class.java).also{
                startActivity(it)
            }
        }

        val radioGroupBad = findViewById<RadioGroup>(R.id.radioGroupBad)
        val radioBored = findViewById<RadioButton>(R.id.radioButtonBored)
        val radioGroupBored = findViewById<RadioGroup>(R.id.radioGroupBored)
        val radioBusy = findViewById<RadioButton>(R.id.radioButtonBusy)
        val radioGroupBusy = findViewById<RadioGroup>(R.id.radioGroupBusy)
        val radioStressed = findViewById<RadioButton>(R.id.radioButtonStressed)
        val radioGroupStressed = findViewById<RadioGroup>(R.id.radioGroupStressed)
        val radioTired = findViewById<RadioButton>(R.id.radioButtonTired)
        val radioGroupTired = findViewById<RadioGroup>(R.id.radioGroupTired)

        radioGroupBad.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            if (radioBored.isChecked) radioGroupBored.setVisibility(View.VISIBLE)
            else if(!radioBored.isChecked) radioGroupBored.setVisibility(View.GONE)
            if (radioBusy.isChecked) radioGroupBusy.setVisibility(View.VISIBLE)
            else if(!radioBusy.isChecked) radioGroupBusy.setVisibility(View.GONE)
            if (radioStressed.isChecked) radioGroupStressed.setVisibility(View.VISIBLE)
            else if(!radioStressed.isChecked) radioGroupStressed.setVisibility(View.GONE)
            if (radioTired.isChecked) radioGroupTired.setVisibility(View.VISIBLE)
            else if(!radioTired.isChecked) radioGroupTired.setVisibility(View.GONE)
        })

        val messageFeeling = intent.getStringExtra("FEELING")
        if(messageFeeling=="Bored") radioBored.isChecked=true
        else if(messageFeeling=="Busy") radioBusy.isChecked=true
        else if(messageFeeling=="Stressed") radioStressed.isChecked=true
        else if(messageFeeling=="Tired") radioTired.isChecked=true
        if(messageFeeling=="Indifferent") {
            radioBored.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonIndifferent).isChecked=true
        } else if(messageFeeling=="Apathetic") {
            radioBored.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonApathetic).isChecked=true
        } else if(messageFeeling=="Pressured") {
            radioBusy.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonPressured).isChecked=true
        } else if(messageFeeling=="Rushed") {
            radioBusy.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonRushed).isChecked=true
        } else if(messageFeeling=="Overwhelmed") {
            radioStressed.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonOverwhelmed).isChecked=true
        } else if(messageFeeling=="Out of control") {
            radioStressed.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonOutOfControl).isChecked=true
        } else if(messageFeeling=="Sleepy") {
            radioTired.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonSleepy).isChecked=true
        } else if(messageFeeling=="Unfocused") {
            radioTired.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonUnfocused).isChecked=true
        }

        val next = findViewById<Button>(R.id.buttonNext)
        next.setOnClickListener {
            val selectedBad: Int = radioGroupBad.checkedRadioButtonId
            val selectedBored: Int = radioGroupBored.checkedRadioButtonId
            val selectedBusy: Int = radioGroupBusy.checkedRadioButtonId
            val selectedStressed: Int = radioGroupStressed.checkedRadioButtonId
            val selectedTired: Int = radioGroupTired.checkedRadioButtonId
            if (selectedBad != -1) {
                if (selectedBored != -1 && radioGroupBored.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedBored)
                    gotoBad3Quote(selectedRadioButton)
                } else if (selectedBusy != -1 && radioGroupBusy.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedBusy)
                    gotoBad3Quote(selectedRadioButton)
                } else if (selectedStressed != -1 && radioGroupStressed.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedStressed)
                    gotoBad3Quote(selectedRadioButton)
                } else if (selectedTired != -1 && radioGroupTired.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedTired)
                    gotoBad3Quote(selectedRadioButton)
                } else {
                    val selectedRadioButton = findViewById<RadioButton>(selectedBad)
                    gotoBad3Quote(selectedRadioButton)
                }
            }
        }
    }

    fun gotoBad3Quote(selectedRadioButton: RadioButton) {
        val selected: String = selectedRadioButton.text.toString()
        val intent = Intent(this, Bad3Quote::class.java).also{
            it.putExtra("EMOTION", "Bad")
            it.putExtra("FEELING", selected)
            it.putExtra("BUTTON_CLICKED", "Sure")
            startActivity(it)
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