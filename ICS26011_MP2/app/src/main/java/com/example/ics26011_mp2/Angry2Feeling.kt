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

class Angry2Feeling : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_angry2_feeling)
        setSupportActionBar(findViewById(R.id.main_toolbar))
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)

        val back = findViewById<Button>(R.id.buttonBack)
        back.setOnClickListener {
            val intent = Intent(this, Angry1Question::class.java).also{
                startActivity(it)
            }
        }

        val radioGroupAngry = findViewById<RadioGroup>(R.id.radioGroupAngry)
        val radioLetDown = findViewById<RadioButton>(R.id.radioButtonLetDown)
        val radioGroupLetDown = findViewById<RadioGroup>(R.id.radioGroupLetDown)
        val radioHumiliated = findViewById<RadioButton>(R.id.radioButtonHumiliated)
        val radioGroupHumiliated = findViewById<RadioGroup>(R.id.radioGroupHumiliated)
        val radioBitter = findViewById<RadioButton>(R.id.radioButtonBitter)
        val radioGroupBitter = findViewById<RadioGroup>(R.id.radioGroupBitter)
        val radioMad = findViewById<RadioButton>(R.id.radioButtonMad)
        val radioGroupMad = findViewById<RadioGroup>(R.id.radioGroupMad)
        val radioAggressive = findViewById<RadioButton>(R.id.radioButtonAggressive)
        val radioGroupAggressive = findViewById<RadioGroup>(R.id.radioGroupAggressive)
        val radioFrustrated = findViewById<RadioButton>(R.id.radioButtonFrustrated)
        val radioGroupFrustrated = findViewById<RadioGroup>(R.id.radioGroupFrustrated)
        val radioDistant = findViewById<RadioButton>(R.id.radioButtonDistant)
        val radioGroupDistant = findViewById<RadioGroup>(R.id.radioGroupDistant)
        val radioCritical = findViewById<RadioButton>(R.id.radioButtonCritical)
        val radioGroupCritical = findViewById<RadioGroup>(R.id.radioGroupCritical)

        radioGroupAngry.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            if (radioLetDown.isChecked) radioGroupLetDown.setVisibility(View.VISIBLE)
            else if(!radioLetDown.isChecked) radioGroupLetDown.setVisibility(View.GONE)
            if (radioHumiliated.isChecked) radioGroupHumiliated.setVisibility(View.VISIBLE)
            else if(!radioHumiliated.isChecked) radioGroupHumiliated.setVisibility(View.GONE)
            if (radioBitter.isChecked) radioGroupBitter.setVisibility(View.VISIBLE)
            else if(!radioBitter.isChecked) radioGroupBitter.setVisibility(View.GONE)
            if (radioMad.isChecked) radioGroupMad.setVisibility(View.VISIBLE)
            else if(!radioMad.isChecked) radioGroupMad.setVisibility(View.GONE)
            if (radioAggressive.isChecked) radioGroupAggressive.setVisibility(View.VISIBLE)
            else if(!radioAggressive.isChecked) radioGroupAggressive.setVisibility(View.GONE)
            if (radioFrustrated.isChecked) radioGroupFrustrated.setVisibility(View.VISIBLE)
            else if(!radioFrustrated.isChecked) radioGroupFrustrated.setVisibility(View.GONE)
            if (radioDistant.isChecked) radioGroupDistant.setVisibility(View.VISIBLE)
            else if(!radioDistant.isChecked) radioGroupDistant.setVisibility(View.GONE)
            if (radioCritical.isChecked) radioGroupCritical.setVisibility(View.VISIBLE)
            else if(!radioCritical.isChecked) radioGroupCritical.setVisibility(View.GONE)
        })

        val messageFeeling = intent.getStringExtra("FEELING")
        if(messageFeeling=="Let down") radioLetDown.isChecked=true
        else if(messageFeeling=="Humiliated") radioHumiliated.isChecked=true
        else if(messageFeeling=="Bitter") radioBitter.isChecked=true
        else if(messageFeeling=="Mad") radioMad.isChecked=true
        else if(messageFeeling=="Aggressive") radioAggressive.isChecked=true
        else if(messageFeeling=="Frustrated") radioFrustrated.isChecked=true
        else if(messageFeeling=="Distant") radioDistant.isChecked=true
        else if(messageFeeling=="Critical") radioCritical.isChecked=true
        if(messageFeeling=="Betrayed") {
            radioLetDown.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonBetrayed).isChecked=true
        } else if(messageFeeling=="Resentful") {
            radioLetDown.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonResentful).isChecked=true
        } else if(messageFeeling=="Disrespected") {
            radioHumiliated.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonDisrespected).isChecked=true
        } else if(messageFeeling=="Ridiculed") {
            radioHumiliated.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonRidiculed).isChecked=true
        } else if(messageFeeling=="Indignant") {
            radioBitter.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonIndignant).isChecked=true
        } else if(messageFeeling=="Violated") {
            radioBitter.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonViolated).isChecked=true
        } else if(messageFeeling=="Furious") {
            radioMad.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonFurious).isChecked=true
        } else if(messageFeeling=="Jealous") {
            radioMad.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonJealous).isChecked=true
        } else if(messageFeeling=="Provoked") {
            radioAggressive.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonProvoked).isChecked=true
        } else if(messageFeeling=="Hostile") {
            radioAggressive.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonHostile).isChecked=true
        } else if(messageFeeling=="Infuriated") {
            radioFrustrated.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonInfuriated).isChecked=true
        } else if(messageFeeling=="Annoyed") {
            radioFrustrated.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonAnnoyed).isChecked=true
        } else if(messageFeeling=="Withdrawn") {
            radioDistant.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonWithdrawn).isChecked=true
        } else if(messageFeeling=="Numb") {
            radioDistant.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonNumb).isChecked=true
        } else if(messageFeeling=="Sceptical") {
            radioCritical.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonSceptical).isChecked=true
        } else if(messageFeeling=="Dismissive") {
            radioCritical.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonDismissive).isChecked=true
        }

        val next = findViewById<Button>(R.id.buttonNext)
        next.setOnClickListener {
            val selectedAngry: Int = radioGroupAngry.checkedRadioButtonId
            val selectedLetDown: Int = radioGroupLetDown.checkedRadioButtonId
            val selectedHumiliated: Int = radioGroupHumiliated.checkedRadioButtonId
            val selectedBitter: Int = radioGroupBitter.checkedRadioButtonId
            val selectedMad: Int = radioGroupMad.checkedRadioButtonId
            val selectedAggressive: Int = radioGroupAggressive.checkedRadioButtonId
            val selectedFrustrated: Int = radioGroupFrustrated.checkedRadioButtonId
            val selectedDistant: Int = radioGroupDistant.checkedRadioButtonId
            val selectedCritical: Int = radioGroupCritical.checkedRadioButtonId
            if (selectedAngry != -1) {
                if (selectedLetDown != -1 && radioGroupLetDown.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedLetDown)
                    gotoAngry3Quote(selectedRadioButton)
                } else if (selectedHumiliated != -1 && radioGroupHumiliated.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedHumiliated)
                    gotoAngry3Quote(selectedRadioButton)
                } else if (selectedBitter != -1 && radioGroupBitter.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedBitter)
                    gotoAngry3Quote(selectedRadioButton)
                } else if (selectedMad != -1 && radioGroupMad.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedMad)
                    gotoAngry3Quote(selectedRadioButton)
                } else if (selectedAggressive != -1 && radioGroupAggressive.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedAggressive)
                    gotoAngry3Quote(selectedRadioButton)
                } else if (selectedFrustrated != -1 && radioGroupFrustrated.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedFrustrated)
                    gotoAngry3Quote(selectedRadioButton)
                } else if (selectedDistant != -1 && radioGroupDistant.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedDistant)
                    gotoAngry3Quote(selectedRadioButton)
                } else if (selectedCritical != -1 && radioGroupCritical.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedCritical)
                    gotoAngry3Quote(selectedRadioButton)
                } else {
                    val selectedRadioButton = findViewById<RadioButton>(selectedAngry)
                    gotoAngry3Quote(selectedRadioButton)
                }
            }
        }
    }

    fun gotoAngry3Quote(selectedRadioButton: RadioButton) {
        val selected: String = selectedRadioButton.text.toString()
        val intent = Intent(this, Angry3Quote::class.java).also{
            it.putExtra("EMOTION", "Angry")
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