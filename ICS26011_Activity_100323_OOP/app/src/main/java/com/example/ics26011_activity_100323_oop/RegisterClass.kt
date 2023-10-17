package com.example.ics26011_activity_100323_oop

import android.util.Log

var userArray = ArrayList<UserInfo>() //userinfo model

class RegisterClass {
    fun AddToArray(userInfo : UserInfo) {
        try{
            userArray.add(userInfo)
            ShowArray()
        }
        catch (e : Exception) {
            Log.e("error", e.message.toString())
        }
    }

    private fun ShowArray() {
        for(element in userArray) {
            Log.i("info",element.username)
        }
    }

    fun ReturnArray() : ArrayList<UserInfo> {
        return userArray
    }
}