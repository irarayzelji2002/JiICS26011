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

class Happy2Feeling : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_happy2_feeling)
        setSupportActionBar(findViewById(R.id.main_toolbar))
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)

        val back = findViewById<Button>(R.id.buttonBack)
        back.setOnClickListener {
            val intent = Intent(this, Happy1Question::class.java).also{
                startActivity(it)
            }
        }

        val radioGroupHappy = findViewById<RadioGroup>(R.id.radioGroupHappy)
        val radioPlayful = findViewById<RadioButton>(R.id.radioButtonPlayful)
        val radioGroupPlayful = findViewById<RadioGroup>(R.id.radioGroupPlayful)
        val radioContent = findViewById<RadioButton>(R.id.radioButtonContent)
        val radioGroupContent = findViewById<RadioGroup>(R.id.radioGroupContent)
        val radioInterested = findViewById<RadioButton>(R.id.radioButtonInterested)
        val radioGroupInterested = findViewById<RadioGroup>(R.id.radioGroupInterested)
        val radioProud = findViewById<RadioButton>(R.id.radioButtonProud)
        val radioGroupProud = findViewById<RadioGroup>(R.id.radioGroupProud)
        val radioAccepted = findViewById<RadioButton>(R.id.radioButtonAccepted)
        val radioGroupAccepted = findViewById<RadioGroup>(R.id.radioGroupAccepted)
        val radioPowerful = findViewById<RadioButton>(R.id.radioButtonPowerful)
        val radioGroupPowerful = findViewById<RadioGroup>(R.id.radioGroupPowerful)
        val radioPeaceful = findViewById<RadioButton>(R.id.radioButtonPeaceful)
        val radioGroupPeaceful = findViewById<RadioGroup>(R.id.radioGroupPeaceful)
        val radioTrusting = findViewById<RadioButton>(R.id.radioButtonTrusting)
        val radioGroupTrusting = findViewById<RadioGroup>(R.id.radioGroupTrusting)
        val radioOptimistic = findViewById<RadioButton>(R.id.radioButtonOptimistic)
        val radioGroupOptimistic = findViewById<RadioGroup>(R.id.radioGroupOptimistic)


        radioGroupHappy.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            if (radioPlayful.isChecked) radioGroupPlayful.setVisibility(View.VISIBLE)
            else if(!radioPlayful.isChecked) radioGroupPlayful.setVisibility(View.GONE)
            if (radioContent.isChecked) radioGroupContent.setVisibility(View.VISIBLE)
            else if(!radioContent.isChecked) radioGroupContent.setVisibility(View.GONE)
            if (radioInterested.isChecked) radioGroupInterested.setVisibility(View.VISIBLE)
            else if(!radioInterested.isChecked) radioGroupInterested.setVisibility(View.GONE)
            if (radioProud.isChecked) radioGroupProud.setVisibility(View.VISIBLE)
            else if(!radioProud.isChecked) radioGroupProud.setVisibility(View.GONE)
            if (radioAccepted.isChecked) radioGroupAccepted.setVisibility(View.VISIBLE)
            else if(!radioAccepted.isChecked) radioGroupAccepted.setVisibility(View.GONE)
            if (radioPowerful.isChecked) radioGroupPowerful.setVisibility(View.VISIBLE)
            else if(!radioPowerful.isChecked) radioGroupPowerful.setVisibility(View.GONE)
            if (radioPeaceful.isChecked) radioGroupPeaceful.setVisibility(View.VISIBLE)
            else if(!radioPeaceful.isChecked) radioGroupPeaceful.setVisibility(View.GONE)
            if (radioTrusting.isChecked) radioGroupTrusting.setVisibility(View.VISIBLE)
            else if(!radioTrusting.isChecked) radioGroupTrusting.setVisibility(View.GONE)
            if (radioOptimistic.isChecked) radioGroupOptimistic.setVisibility(View.VISIBLE)
            else if(!radioOptimistic.isChecked) radioGroupOptimistic.setVisibility(View.GONE)
        })

        val messageFeeling = intent.getStringExtra("FEELING")
        if(messageFeeling=="Playful") radioPlayful.isChecked=true
        else if(messageFeeling=="Content") radioContent.isChecked=true
        else if(messageFeeling=="Interested") radioInterested.isChecked=true
        else if(messageFeeling=="Proud") radioProud.isChecked=true
        else if(messageFeeling=="Accepted") radioAccepted.isChecked=true
        else if(messageFeeling=="Powerful") radioPowerful.isChecked=true
        else if(messageFeeling=="Peaceful") radioPeaceful.isChecked=true
        else if(messageFeeling=="Trusting") radioTrusting.isChecked=true
        else if(messageFeeling=="Optimistic") radioOptimistic.isChecked=true
        if(messageFeeling=="Aroused") {
            radioPlayful.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonAroused).isChecked=true
        } else if(messageFeeling=="Cheeky") {
            radioPlayful.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonCheeky).isChecked=true
        } else if(messageFeeling=="Free") {
            radioContent.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonFree).isChecked=true
        } else if(messageFeeling=="Joyful") {
            radioContent.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonJoyful).isChecked=true
        } else if(messageFeeling=="Curious") {
            radioInterested.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonCurious).isChecked=true
        } else if(messageFeeling=="Inquisitive") {
            radioInterested.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonInquisitive).isChecked=true
        } else if(messageFeeling=="Successful") {
            radioProud.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonSuccessful).isChecked=true
        } else if(messageFeeling=="Confident") {
            radioProud.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonConfident).isChecked=true
        } else if(messageFeeling=="Respected") {
            radioAccepted.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonRespected).isChecked=true
        } else if(messageFeeling=="Valued") {
            radioAccepted.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonValued).isChecked=true
        } else if(messageFeeling=="Courageous") {
            radioPowerful.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonCourageous).isChecked=true
        } else if(messageFeeling=="Creative") {
            radioPowerful.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonCreative).isChecked=true
        } else if(messageFeeling=="Loving") {
            radioPeaceful.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonLoving).isChecked=true
        } else if(messageFeeling=="Thankful") {
            radioPeaceful.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonThankful).isChecked=true
        } else if(messageFeeling=="Sensitive") {
            radioTrusting.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonSensitive).isChecked=true
        } else if(messageFeeling=="Intimate") {
            radioTrusting.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonIntimate).isChecked=true
        } else if(messageFeeling=="Hopeful") {
            radioOptimistic.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonHopeful).isChecked=true
        } else if(messageFeeling=="Inspired") {
            radioOptimistic.isChecked=true
            findViewById<RadioButton>(R.id.radioButtonInspired).isChecked=true
        }

        val next = findViewById<Button>(R.id.buttonNext)
        next.setOnClickListener {
            val selectedHappy: Int = radioGroupHappy.checkedRadioButtonId
            val selectedPlayful: Int = radioGroupPlayful.checkedRadioButtonId
            val selectedContent: Int = radioGroupContent.checkedRadioButtonId
            val selectedInterested: Int = radioGroupInterested.checkedRadioButtonId
            val selectedProud: Int = radioGroupProud.checkedRadioButtonId
            val selectedAccepted: Int = radioGroupAccepted.checkedRadioButtonId
            val selectedPowerful: Int = radioGroupPowerful.checkedRadioButtonId
            val selectedPeaceful: Int = radioGroupPeaceful.checkedRadioButtonId
            val selectedTrusting: Int = radioGroupTrusting.checkedRadioButtonId
            val selectedOptimistic: Int = radioGroupOptimistic.checkedRadioButtonId
            if (selectedHappy != -1) {
                if (selectedPlayful != -1 && radioGroupPlayful.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedPlayful)
                    gotoHappy3Quote(selectedRadioButton)
                } else if (selectedContent != -1 && radioGroupContent.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedContent)
                    gotoHappy3Quote(selectedRadioButton)
                } else if (selectedInterested != -1 && radioGroupInterested.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedInterested)
                    gotoHappy3Quote(selectedRadioButton)
                } else if (selectedProud != -1 && radioGroupProud.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedProud)
                    gotoHappy3Quote(selectedRadioButton)
                } else if (selectedAccepted != -1 && radioGroupAccepted.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedAccepted)
                    gotoHappy3Quote(selectedRadioButton)
                } else if (selectedPowerful != -1 && radioGroupPowerful.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedPowerful)
                    gotoHappy3Quote(selectedRadioButton)
                } else if (selectedPeaceful != -1 && radioGroupPeaceful.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedPeaceful)
                    gotoHappy3Quote(selectedRadioButton)
                } else if (selectedTrusting != -1 && radioGroupTrusting.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedTrusting)
                    gotoHappy3Quote(selectedRadioButton)
                } else if (selectedOptimistic != -1 && radioGroupOptimistic.visibility==View.VISIBLE) {
                    val selectedRadioButton = findViewById<RadioButton>(selectedOptimistic)
                    gotoHappy3Quote(selectedRadioButton)
                } else {
                    val selectedRadioButton = findViewById<RadioButton>(selectedHappy)
                    gotoHappy3Quote(selectedRadioButton)
                }
            }
        }
    }

    fun gotoHappy3Quote(selectedRadioButton: RadioButton) {
        val selected: String = selectedRadioButton.text.toString()
        val intent = Intent(this, Happy3Quote::class.java).also{
            it.putExtra("EMOTION", "Happy")
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
                startActivity(Intent(this, Home::class.java).putExtra("EMOTION", "Happy"))
            }
            R.id.nav_info -> {
                startActivity(Intent(this, Info::class.java).putExtra("EMOTION", "Happy"))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}