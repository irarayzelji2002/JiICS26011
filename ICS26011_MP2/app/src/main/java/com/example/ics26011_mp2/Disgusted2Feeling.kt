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

class Disgusted2Feeling : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disgusted2_feeling)
        setSupportActionBar(findViewById(R.id.main_toolbar))
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)

        val back = findViewById<Button>(R.id.buttonBack)
        back.setOnClickListener {
            val intent = Intent(this, Disgusted1Question::class.java).also{
                startActivity(it)
            }
        }

        val radioGroupDisgusted = findViewById<RadioGroup>(R.id.radioGroupDisgusted)
        val radioDisapproving = findViewById<RadioButton>(R.id.radioButtonDisapproving)
        val radioGroupDisapproving = findViewById<RadioGroup>(R.id.radioGroupDisapproving)
        val radioDisappointed = findViewById<RadioButton>(R.id.radioButtonDisappointed)
        val radioGroupDisappointed = findViewById<RadioGroup>(R.id.radioGroupDisappointed)
        val radioAwful = findViewById<RadioButton>(R.id.radioButtonAwful)
        val radioGroupAwful = findViewById<RadioGroup>(R.id.radioGroupAwful)
        val radioRepelled = findViewById<RadioButton>(R.id.radioButtonRepelled)
        val radioGroupRepelled = findViewById<RadioGroup>(R.id.radioGroupRepelled)

        radioGroupDisgusted.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            if (radioDisapproving.isChecked) radioGroupDisapproving.setVisibility(View.VISIBLE)
            else if(!radioDisapproving.isChecked) radioGroupDisapproving.setVisibility(View.GONE)
            if (radioDisappointed.isChecked) radioGroupDisappointed.setVisibility(View.VISIBLE)
            else if(!radioDisappointed.isChecked) radioGroupDisappointed.setVisibility(View.GONE)
            if (radioAwful.isChecked) radioGroupAwful.setVisibility(View.VISIBLE)
            else if(!radioAwful.isChecked) radioGroupAwful.setVisibility(View.GONE)
            if (radioRepelled.isChecked) radioGroupRepelled.setVisibility(View.VISIBLE)
            else if(!radioRepelled.isChecked) radioGroupRepelled.setVisibility(View.GONE)
        })

        val messageFeeling = intent.getStringExtra("FEELING")
        if(messageFeeling=="Disapproving") radioDisapproving.isChecked=true
        else if(messageFeeling=="Disappointed") radioDisappointed.isChecked=true
        else if(messageFeeling=="Awful") radioAwful.isChecked=true
        else if(messageFeeling=="Repelled") radioRepelled.isChecked=true
        if(messageFeeling=="Judgmental") {
            radioDisapproving.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonJudgmental).isChecked=true
        } else if(messageFeeling=="Embarrassed") {
            radioDisapproving.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonEmbarrassed).isChecked=true
        } else if(messageFeeling=="Appalled") {
            radioDisappointed.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonAppalled).isChecked=true
        } else if(messageFeeling=="Revolted") {
            radioDisappointed.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonRevolted).isChecked=true
        } else if(messageFeeling=="Nauseated") {
            radioAwful.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonNauseated).isChecked=true
        } else if(messageFeeling=="Detestable") {
            radioAwful.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonDetestable).isChecked=true
        } else if(messageFeeling=="Horrified") {
            radioRepelled.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonHorrified).isChecked=true
        } else if(messageFeeling=="Hesitant") {
            radioRepelled.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonHesitant).isChecked=true
        }

        val next = findViewById<Button>(R.id.buttonNext)
        next.setOnClickListener {
            val selectedDisgusted: Int = radioGroupDisgusted.checkedRadioButtonId
            val selectedDisapproving: Int = radioGroupDisapproving.checkedRadioButtonId
            val selectedDisappointed: Int = radioGroupDisappointed.checkedRadioButtonId
            val selectedAwful: Int = radioGroupAwful.checkedRadioButtonId
            val selectedRepelled: Int = radioGroupRepelled.checkedRadioButtonId
            if (selectedDisgusted != -1) {
                if (selectedDisapproving != -1 && radioGroupDisapproving.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedDisapproving)
                    gotoDisgusted3Quote(selectedRadioButton)
                } else if (selectedDisappointed != -1 && radioGroupDisappointed.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedDisappointed)
                    gotoDisgusted3Quote(selectedRadioButton)
                } else if (selectedAwful != -1 && radioGroupAwful.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedAwful)
                    gotoDisgusted3Quote(selectedRadioButton)
                } else if (selectedRepelled != -1 && radioGroupRepelled.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedRepelled)
                    gotoDisgusted3Quote(selectedRadioButton)
                } else {
                    val selectedRadioButton = findViewById<RadioButton>(selectedDisgusted)
                    gotoDisgusted3Quote(selectedRadioButton)
                }
            }
        }
    }

    fun gotoDisgusted3Quote(selectedRadioButton: RadioButton) {
        val selected: String = selectedRadioButton.text.toString()
        val intent = Intent(this, Disgusted3Quote::class.java).also{
            it.putExtra("EMOTION", "Disgusted")
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
                startActivity(Intent(this, Home::class.java).putExtra("EMOTION", "Disgusted"))
            }
            R.id.nav_info -> {
                startActivity(Intent(this, Info::class.java).putExtra("EMOTION", "Disgusted"))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}