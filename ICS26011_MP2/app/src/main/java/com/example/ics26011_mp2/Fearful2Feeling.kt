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

class Fearful2Feeling : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fearful2_feeling)
        setSupportActionBar(findViewById(R.id.main_toolbar))
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)

        val back = findViewById<Button>(R.id.buttonBack)
        back.setOnClickListener {
            val intent = Intent(this, Fearful1Question::class.java).also{
                startActivity(it)
            }
        }

        val radioGroupFearful = findViewById<RadioGroup>(R.id.radioGroupFearful)
        val radioScared = findViewById<RadioButton>(R.id.radioButtonScared)
        val radioGroupScared = findViewById<RadioGroup>(R.id.radioGroupScared)
        val radioAnxious = findViewById<RadioButton>(R.id.radioButtonAnxious)
        val radioGroupAnxious = findViewById<RadioGroup>(R.id.radioGroupAnxious)
        val radioInsecure = findViewById<RadioButton>(R.id.radioButtonInsecure)
        val radioGroupInsecure = findViewById<RadioGroup>(R.id.radioGroupInsecure)
        val radioWeak = findViewById<RadioButton>(R.id.radioButtonWeak)
        val radioGroupWeak = findViewById<RadioGroup>(R.id.radioGroupWeak)
        val radioRejected = findViewById<RadioButton>(R.id.radioButtonRejected)
        val radioGroupRejected = findViewById<RadioGroup>(R.id.radioGroupRejected)
        val radioThreatened = findViewById<RadioButton>(R.id.radioButtonThreatened)
        val radioGroupThreatened = findViewById<RadioGroup>(R.id.radioGroupThreatened)

        radioGroupFearful.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            if (radioScared.isChecked) radioGroupScared.setVisibility(View.VISIBLE)
            else if(!radioScared.isChecked) radioGroupScared.setVisibility(View.GONE)
            if (radioAnxious.isChecked) radioGroupAnxious.setVisibility(View.VISIBLE)
            else if(!radioAnxious.isChecked) radioGroupAnxious.setVisibility(View.GONE)
            if (radioInsecure.isChecked) radioGroupInsecure.setVisibility(View.VISIBLE)
            else if(!radioInsecure.isChecked) radioGroupInsecure.setVisibility(View.GONE)
            if (radioWeak.isChecked) radioGroupWeak.setVisibility(View.VISIBLE)
            else if(!radioWeak.isChecked) radioGroupWeak.setVisibility(View.GONE)
            if (radioRejected.isChecked) radioGroupRejected.setVisibility(View.VISIBLE)
            else if(!radioRejected.isChecked) radioGroupRejected.setVisibility(View.GONE)
            if (radioThreatened.isChecked) radioGroupThreatened.setVisibility(View.VISIBLE)
            else if(!radioThreatened.isChecked) radioGroupThreatened.setVisibility(View.GONE)
        })

        val messageFeeling = intent.getStringExtra("FEELING")
        if(messageFeeling=="Scared") radioScared.isChecked=true
        else if(messageFeeling=="Anxious") radioAnxious.isChecked=true
        else if(messageFeeling=="Insecure") radioInsecure.isChecked=true
        else if(messageFeeling=="Weak") radioWeak.isChecked=true
        else if(messageFeeling=="Rejected") radioRejected.isChecked=true
        else if(messageFeeling=="Threatened") radioThreatened.isChecked=true
        if(messageFeeling=="Helpless") {
            radioScared.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonHelpless).isChecked=true
        } else if(messageFeeling=="Frightened") {
            radioScared.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonFrightened).isChecked=true
        } else if(messageFeeling=="Overwhelmed") {
            radioAnxious.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonOverwhelmed).isChecked=true
        } else if(messageFeeling=="Worried") {
            radioAnxious.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonWorried).isChecked=true
        } else if(messageFeeling=="Inadequate") {
            radioInsecure.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonInadequate).isChecked=true
        } else if(messageFeeling=="Inferior") {
            radioInsecure.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonInferior).isChecked=true
        } else if(messageFeeling=="Worthless") {
            radioWeak.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonWorthless).isChecked=true
        } else if(messageFeeling=="Insignificant") {
            radioWeak.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonInsignificant).isChecked=true
        } else if(messageFeeling=="Excluded") {
            radioRejected.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonExcluded).isChecked=true
        } else if(messageFeeling=="Persecuted") {
            radioRejected.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonPersecuted).isChecked=true
        } else if(messageFeeling=="Nervous") {
            radioThreatened.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonNervous).isChecked=true
        } else if(messageFeeling=="Threatened") {
            radioThreatened.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonThreatened).isChecked=true
        }

        val next = findViewById<Button>(R.id.buttonNext)
        next.setOnClickListener {
            val selectedFearful: Int = radioGroupFearful.checkedRadioButtonId
            val selectedScared: Int = radioGroupScared.checkedRadioButtonId
            val selectedAnxious: Int = radioGroupAnxious.checkedRadioButtonId
            val selectedInsecure: Int = radioGroupInsecure.checkedRadioButtonId
            val selectedWeak: Int = radioGroupWeak.checkedRadioButtonId
            val selectedRejected: Int = radioGroupRejected.checkedRadioButtonId
            val selectedThreatened: Int = radioGroupThreatened.checkedRadioButtonId
            if (selectedFearful != -1) {
                if (selectedScared != -1 && radioGroupScared.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedScared)
                    gotoFearful3Quote(selectedRadioButton)
                } else if (selectedAnxious != -1 && radioGroupAnxious.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedAnxious)
                    gotoFearful3Quote(selectedRadioButton)
                } else if (selectedInsecure != -1 && radioGroupInsecure.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedInsecure)
                    gotoFearful3Quote(selectedRadioButton)
                } else if (selectedWeak != -1 && radioGroupWeak.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedWeak)
                    gotoFearful3Quote(selectedRadioButton)
                } else if (selectedRejected != -1 && radioGroupRejected.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedRejected)
                    gotoFearful3Quote(selectedRadioButton)
                } else if (selectedThreatened != -1 && radioGroupThreatened.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedThreatened)
                    gotoFearful3Quote(selectedRadioButton)
                } else {
                    val selectedRadioButton = findViewById<RadioButton>(selectedFearful)
                    gotoFearful3Quote(selectedRadioButton)
                }
            }
        }
    }

    fun gotoFearful3Quote(selectedRadioButton: RadioButton) {
        val selected: String = selectedRadioButton.text.toString()
        val intent = Intent(this, Fearful3Quote::class.java).also{
            it.putExtra("EMOTION", "Fearful")
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