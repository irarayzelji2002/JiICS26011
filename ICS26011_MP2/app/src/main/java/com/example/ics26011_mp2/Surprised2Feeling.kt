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

class Surprised2Feeling : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surprised2_feeling)
        setSupportActionBar(findViewById(R.id.main_toolbar))
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)

        val back = findViewById<Button>(R.id.buttonBack)
        back.setOnClickListener {
            val intent = Intent(this, Surprised1Question::class.java).also{
                startActivity(it)
            }
        }

        val radioGroupSurprised = findViewById<RadioGroup>(R.id.radioGroupSurprised)
        val radioStartled = findViewById<RadioButton>(R.id.radioButtonStartled)
        val radioGroupStartled = findViewById<RadioGroup>(R.id.radioGroupStartled)
        val radioConfused = findViewById<RadioButton>(R.id.radioButtonConfused)
        val radioGroupConfused = findViewById<RadioGroup>(R.id.radioGroupConfused)
        val radioAmazed = findViewById<RadioButton>(R.id.radioButtonAmazed)
        val radioGroupAmazed = findViewById<RadioGroup>(R.id.radioGroupAmazed)
        val radioExcited = findViewById<RadioButton>(R.id.radioButtonExcited)
        val radioGroupExcited = findViewById<RadioGroup>(R.id.radioGroupExcited)

        radioGroupSurprised.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            if (radioStartled.isChecked) radioGroupStartled.setVisibility(View.VISIBLE)
            else if(!radioStartled.isChecked) radioGroupStartled.setVisibility(View.GONE)
            if (radioConfused.isChecked) radioGroupConfused.setVisibility(View.VISIBLE)
            else if(!radioConfused.isChecked) radioGroupConfused.setVisibility(View.GONE)
            if (radioAmazed.isChecked) radioGroupAmazed.setVisibility(View.VISIBLE)
            else if(!radioAmazed.isChecked) radioGroupAmazed.setVisibility(View.GONE)
            if (radioExcited.isChecked) radioGroupExcited.setVisibility(View.VISIBLE)
            else if(!radioExcited.isChecked) radioGroupExcited.setVisibility(View.GONE)
        })

        val messageFeeling = intent.getStringExtra("FEELING")
        if(messageFeeling=="Startled") radioStartled.isChecked=true
        else if(messageFeeling=="Confused") radioConfused.isChecked=true
        else if(messageFeeling=="Amazed") radioAmazed.isChecked=true
        else if(messageFeeling=="Excited") radioExcited.isChecked=true
        if(messageFeeling=="Shocked") {
            radioStartled.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonShocked).isChecked=true
        } else if(messageFeeling=="Dismayed") {
            radioStartled.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonDismayed).isChecked=true
        } else if(messageFeeling=="Disillusioned") {
            radioConfused.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonDisillusioned).isChecked=true
        } else if(messageFeeling=="Perplexed") {
            radioConfused.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonPerplexed).isChecked=true
        } else if(messageFeeling=="Astonished") {
            radioAmazed.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonAstonished).isChecked=true
        } else if(messageFeeling=="Awe") {
            radioAmazed.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonAwe).isChecked=true
        } else if(messageFeeling=="Eager") {
            radioExcited.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonEager).isChecked=true
        } else if(messageFeeling=="Energetic") {
            radioExcited.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonEnergetic).isChecked=true
        }

        val next = findViewById<Button>(R.id.buttonNext)
        next.setOnClickListener {
            val selectedSurprised: Int = radioGroupSurprised.checkedRadioButtonId
            val selectedStartled: Int = radioGroupStartled.checkedRadioButtonId
            val selectedConfused: Int = radioGroupConfused.checkedRadioButtonId
            val selectedAmazed: Int = radioGroupAmazed.checkedRadioButtonId
            val selectedExcited: Int = radioGroupExcited.checkedRadioButtonId
            if (selectedSurprised != -1) {
                if (selectedStartled != -1 && radioGroupStartled.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedStartled)
                    gotoSurprised3Quote(selectedRadioButton)
                } else if (selectedConfused != -1 && radioGroupConfused.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedConfused)
                    gotoSurprised3Quote(selectedRadioButton)
                } else if (selectedAmazed != -1 && radioGroupAmazed.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedAmazed)
                    gotoSurprised3Quote(selectedRadioButton)
                } else if (selectedExcited != -1 && radioGroupExcited.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedExcited)
                    gotoSurprised3Quote(selectedRadioButton)
                } else {
                    val selectedRadioButton = findViewById<RadioButton>(selectedSurprised)
                    gotoSurprised3Quote(selectedRadioButton)
                }
            }
        }
    }

    fun gotoSurprised3Quote(selectedRadioButton: RadioButton) {
        val selected: String = selectedRadioButton.text.toString()
        val intent = Intent(this, Surprised3Quote::class.java).also{
            it.putExtra("EMOTION", "Surprised")
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