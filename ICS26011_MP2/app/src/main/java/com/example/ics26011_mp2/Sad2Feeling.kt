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

class Sad2Feeling : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sad2_feeling)
        setSupportActionBar(findViewById(R.id.main_toolbar))
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)

        val back = findViewById<Button>(R.id.buttonBack)
        back.setOnClickListener {
            val intent = Intent(this, Sad1Question::class.java).also {
                startActivity(it)
            }
        }

        val radioGroupSad = findViewById<RadioGroup>(R.id.radioGroupSad)
        val radioLonely = findViewById<RadioButton>(R.id.radioButtonLonely)
        val radioGroupLonely = findViewById<RadioGroup>(R.id.radioGroupLonely)
        val radioVulnerable = findViewById<RadioButton>(R.id.radioButtonVulnerable)
        val radioGroupVulnerable = findViewById<RadioGroup>(R.id.radioGroupVulnerable)
        val radioDespair = findViewById<RadioButton>(R.id.radioButtonDespair)
        val radioGroupDespair = findViewById<RadioGroup>(R.id.radioGroupDespair)
        val radioGuilty = findViewById<RadioButton>(R.id.radioButtonGuilty)
        val radioGroupGuilty = findViewById<RadioGroup>(R.id.radioGroupGuilty)
        val radioDepressed = findViewById<RadioButton>(R.id.radioButtonDepressed)
        val radioGroupDepressed = findViewById<RadioGroup>(R.id.radioGroupDepressed)
        val radioHurt = findViewById<RadioButton>(R.id.radioButtonHurt)
        val radioGroupHurt = findViewById<RadioGroup>(R.id.radioGroupHurt)


        radioGroupSad.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            if (radioLonely.isChecked) radioGroupLonely.setVisibility(View.VISIBLE)
            else if (!radioLonely.isChecked) radioGroupLonely.setVisibility(View.GONE)
            if (radioVulnerable.isChecked) radioGroupVulnerable.setVisibility(View.VISIBLE)
            else if (!radioVulnerable.isChecked) radioGroupVulnerable.setVisibility(View.GONE)
            if (radioDespair.isChecked) radioGroupDespair.setVisibility(View.VISIBLE)
            else if (!radioDespair.isChecked) radioGroupDespair.setVisibility(View.GONE)
            if (radioGuilty.isChecked) radioGroupGuilty.setVisibility(View.VISIBLE)
            else if (!radioGuilty.isChecked) radioGroupGuilty.setVisibility(View.GONE)
            if (radioDepressed.isChecked) radioGroupDepressed.setVisibility(View.VISIBLE)
            else if (!radioDepressed.isChecked) radioGroupDepressed.setVisibility(View.GONE)
            if (radioHurt.isChecked) radioGroupHurt.setVisibility(View.VISIBLE)
            else if (!radioHurt.isChecked) radioGroupHurt.setVisibility(View.GONE)
        })

        val messageFeeling = intent.getStringExtra("FEELING")
        if (messageFeeling == "Lonely") radioLonely.isChecked = true
        else if (messageFeeling == "Vulnerable") radioVulnerable.isChecked = true
        else if (messageFeeling == "Despair") radioDespair.isChecked = true
        else if (messageFeeling == "Guilty") radioGuilty.isChecked = true
        else if (messageFeeling == "Depressed") radioDepressed.isChecked = true
        else if (messageFeeling == "Hurt") radioHurt.isChecked = true
        if (messageFeeling == "Isolated") {
            radioLonely.isChecked = true
            findViewById<RadioButton>(R.id.radioButtonIsolated).isChecked = true
        } else if (messageFeeling == "Abandoned") {
            radioLonely.isChecked = true
            findViewById<RadioButton>(R.id.radioButtonAbandoned).isChecked = true
        } else if (messageFeeling == "Victimised") {
            radioVulnerable.isChecked = true
            findViewById<RadioButton>(R.id.radioButtonVictimised).isChecked = true
        } else if (messageFeeling == "Fragile") {
            radioVulnerable.isChecked = true
            findViewById<RadioButton>(R.id.radioButtonFragile).isChecked = true
        } else if (messageFeeling == "Grief") {
            radioDespair.isChecked = true
            findViewById<RadioButton>(R.id.radioButtonGrief).isChecked = true
        } else if (messageFeeling == "Powerless") {
            radioDespair.isChecked = true
            findViewById<RadioButton>(R.id.radioButtonPowerless).isChecked = true
        } else if (messageFeeling == "Ashamed") {
            radioGuilty.isChecked = true
            findViewById<RadioButton>(R.id.radioButtonAshamed).isChecked = true
        } else if (messageFeeling == "Remorseful") {
            radioGuilty.isChecked = true
            findViewById<RadioButton>(R.id.radioButtonRemorseful).isChecked = true
        } else if (messageFeeling == "Inferior") {
            radioDepressed.isChecked = true
            findViewById<RadioButton>(R.id.radioButtonInferior).isChecked = true
        } else if (messageFeeling == "Empty") {
            radioDepressed.isChecked = true
            findViewById<RadioButton>(R.id.radioButtonEmpty).isChecked = true
        } else if (messageFeeling == "Embarrassed") {
            radioHurt.isChecked = true
            findViewById<RadioButton>(R.id.radioButtonEmbarrassed).isChecked = true
        } else if (messageFeeling == "Disappointed") {
            radioHurt.isChecked = true
            findViewById<RadioButton>(R.id.radioButtonDisappointed).isChecked = true
        }

        val next = findViewById<Button>(R.id.buttonNext)
        next.setOnClickListener {
            val selectedSad: Int = radioGroupSad.checkedRadioButtonId
            val selectedLonely: Int = radioGroupLonely.checkedRadioButtonId
            val selectedVulnerable: Int = radioGroupVulnerable.checkedRadioButtonId
            val selectedDespair: Int = radioGroupDespair.checkedRadioButtonId
            val selectedGuilty: Int = radioGroupGuilty.checkedRadioButtonId
            val selectedDepressed: Int = radioGroupDepressed.checkedRadioButtonId
            val selectedHurt: Int = radioGroupHurt.checkedRadioButtonId
            if (selectedSad != -1) {
                if (selectedLonely != -1 && radioGroupLonely.visibility == View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedLonely)
                    gotoSad3Quote(selectedRadioButton)
                } else if (selectedVulnerable != -1 && radioGroupVulnerable.visibility == View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedVulnerable)
                    gotoSad3Quote(selectedRadioButton)
                } else if (selectedDespair != -1 && radioGroupDespair.visibility == View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedDespair)
                    gotoSad3Quote(selectedRadioButton)
                } else if (selectedGuilty != -1 && radioGroupGuilty.visibility == View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedGuilty)
                    gotoSad3Quote(selectedRadioButton)
                } else if (selectedDepressed != -1 && radioGroupDepressed.visibility == View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedDepressed)
                    gotoSad3Quote(selectedRadioButton)
                } else if (selectedHurt != -1 && radioGroupHurt.visibility == View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedHurt)
                    gotoSad3Quote(selectedRadioButton)
                } else {
                    val selectedRadioButton = findViewById<RadioButton>(selectedSad)
                    gotoSad3Quote(selectedRadioButton)
                }
            }
        }
    }

    fun gotoSad3Quote(selectedRadioButton: RadioButton?) {
        val selected: String = selectedRadioButton?.text.toString()
        val intent = Intent(this, Sad3Quote::class.java).also {
            it.putExtra("EMOTION", "Sad")
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
        when (item.itemId) {
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