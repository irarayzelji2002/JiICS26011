package com.example.ics26011_activity_100323_oop

import android.util.Log
import java.lang.Integer.parseInt
import java.util.Optional
import java.util.stream.IntStream


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

    fun VerifyLoginDetails(username : String, password : String) : Boolean {
        val matchUsername : Optional<UserInfo>? = userArray.stream().filter { UserInfo -> UserInfo.username.equals(username)}.findFirst()
        Log.i("info_matchUsername", matchUsername.toString())
        val matchPassword : Optional<UserInfo>? = userArray.stream().filter { UserInfo -> UserInfo.password.equals(password)}.findFirst()
        Log.i("info_matchPassword", matchPassword.toString())
        return matchUsername == matchPassword
    }
}