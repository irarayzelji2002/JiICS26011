package com.example.ics26011_activity_092823

import android.util.Log

var studentName = ArrayList<String>()

class ji(var name:String="") {
    /*
    class ji(var name:String, var age:Int, var address:String, var email:String, var status:String) {
    fun getJiStatus() {
        status = "Married"
    }
    */

    var arrayIndex: Int = 0
        get() {
            var idx = studentName.indexOf(name)
            return idx
        }

    fun addToArray() {
        try {
            if(!name.isNullOrBlank()) {
                studentName.add(name)
            }
        } catch (e:Exception) {
            Log.e("error",e.message.toString())
        }
    }

    fun showArray() {
        try {
            for(i in studentName) {
                Log.i("names",i)
            }
        } catch (e:Exception) {
            Log.e("error",e.message.toString())
        }
    }
}