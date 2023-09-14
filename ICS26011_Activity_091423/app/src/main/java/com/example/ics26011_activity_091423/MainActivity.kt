package com.example.ics26011_activity_091423

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
    public var letterValue: String = ""
    public var numValue: Int = 0
    public var operation: String = ""
    public var continueOperation: Boolean = false
    fun buttonACLicked(view: View) {
        if(operation=="Plus" && continueOperation==true) {
            letterValue+="A"
            Toast.makeText(this,letterValue, Toast.LENGTH_SHORT).show()
        }
        else if(operation=="Minus" && continueOperation==true) {
            if(letterValue.isNullOrEmpty()) {
                Toast.makeText(this,"No letters to drop", Toast.LENGTH_SHORT).show()
            }
            else {
                letterValue = letterValue.substring(0, letterValue.length - 1)
                if(letterValue.isNullOrEmpty()) {
                    Toast.makeText(this,"No Value", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this,letterValue, Toast.LENGTH_SHORT).show()
                }
            }
        }
        else {
            Toast.makeText(this,"Please click an operation first", Toast.LENGTH_SHORT).show()
        }
        continueOperation = false
    }
    fun buttonBCLicked(view: View) {
        if(operation=="Plus" && continueOperation==true) {
            letterValue+="B"
            Toast.makeText(this,letterValue, Toast.LENGTH_SHORT).show()
        }
        else if(operation=="Minus" && continueOperation==true) {
            if(letterValue.isNullOrEmpty()) {
                Toast.makeText(this,"No letters to drop", Toast.LENGTH_SHORT).show()
            }
            else {
                letterValue = letterValue.substring(0, letterValue.length - 1)
                if(letterValue.isNullOrEmpty()) {
                    Toast.makeText(this,"No Value", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this,letterValue, Toast.LENGTH_SHORT).show()
                }
            }
        }
        else {
            Toast.makeText(this,"Please click an operation first", Toast.LENGTH_SHORT).show()
        }
        continueOperation = false
    }
    fun buttonCCLicked(view: View) {
        if(operation=="Plus" && continueOperation==true) {
            letterValue+="C"
            Toast.makeText(this,letterValue, Toast.LENGTH_SHORT).show()
        }
        else if(operation=="Minus" && continueOperation==true) {
            if(letterValue.isNullOrEmpty()) {
                Toast.makeText(this,"No letters to drop", Toast.LENGTH_SHORT).show()
            }
            else {
                letterValue = letterValue.substring(0, letterValue.length - 1)
                if(letterValue.isNullOrEmpty()) {
                    Toast.makeText(this,"No Value", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this,letterValue, Toast.LENGTH_SHORT).show()
                }
            }
        }
        else {
            Toast.makeText(this,"Please click an operation first", Toast.LENGTH_SHORT).show()
        }
        continueOperation = false
    }
    fun button1CLicked(view: View) {
        if(operation=="Plus" && continueOperation==true) {
            numValue+=1
            Toast.makeText(this,numValue.toString(), Toast.LENGTH_SHORT).show()
        }
        else if(operation=="Minus" && continueOperation==true) {
            if(numValue<1) {
                Toast.makeText(this,"No numbers to minus or number too large to minus", Toast.LENGTH_SHORT).show()
                numValue=0
            }
            else {
                numValue-=1
                Toast.makeText(this,numValue.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        else {
            Toast.makeText(this,"Please click an operation first", Toast.LENGTH_SHORT).show()
        }
        continueOperation = false
    }
    fun button2CLicked(view: View) {
        if(operation=="Plus" && continueOperation==true) {
            numValue+=2
            Toast.makeText(this,numValue.toString(), Toast.LENGTH_SHORT).show()
        }
        else if(operation=="Minus" && continueOperation==true) {
            if(numValue<2) {
                Toast.makeText(this,"No numbers to minus or number too large to minus", Toast.LENGTH_SHORT).show()
                numValue=0
            }
            else {
                numValue-=2
                Toast.makeText(this,numValue.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        else {
            Toast.makeText(this,"Please click an operation first", Toast.LENGTH_SHORT).show()
        }
        continueOperation = false
    }
    fun button3CLicked(view: View) {
        if(operation=="Plus" && continueOperation==true) {
            numValue+=3
            Toast.makeText(this,numValue.toString(), Toast.LENGTH_SHORT).show()
        }
        else if(operation=="Minus" && continueOperation==true) {
            if(numValue<3) {
                Toast.makeText(this,"No numbers to minus or number too large to minus", Toast.LENGTH_SHORT).show()
                numValue=0
            }
            else {
                numValue-=3
                Toast.makeText(this,numValue.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        else {
            Toast.makeText(this,"Please click an operation first", Toast.LENGTH_SHORT).show()
        }
        continueOperation = false
    }
    fun buttonPlusCLicked(view: View) {
        operation = "Plus"
        continueOperation = true
        //Toast.makeText(this,"Please click a letter or number", Toast.LENGTH_SHORT).show()
    }
    fun buttonMinusCLicked(view: View) {
        operation = "Minus"
        continueOperation = true
        //Toast.makeText(this,"Please click a letter or number", Toast.LENGTH_SHORT).show()
    }
}