package com.example.ics26011_mp4

import android.util.Log
import java.util.Optional
import kotlin.jvm.optionals.getOrElse
import kotlin.jvm.optionals.getOrNull

var userArray = ArrayList<UserInfo>() //userinfo model

class RegisterClass {
    fun AddToArray(userInfo : UserInfo) {
        try{
            userArray.add(userInfo)
            ShowArray()
        }
        catch (e : Exception) {
            Log.e("RegisterClass_AddToArray_error", e.message.toString())
        }
    }

    private fun ShowArray() {
        for(element in userArray) {
            Log.i("RegisterClass_ShowArray",element.username)
        }
    }

    fun ReturnArray() : ArrayList<UserInfo> {
        return userArray
    }

    fun VerifyLoginDetails(username : String, password : String) : Boolean {
        val matchUsername : Optional<UserInfo>? = userArray.stream().filter { UserInfo -> UserInfo.username.equals(username)}.findFirst()
        Log.i("RegisterClass_VerifyLoginDetails_matchUsername", matchUsername.toString())
        var correctPass = ""
        if(matchUsername!!.isPresent()) {
            var user = matchUsername.get()
            correctPass = user.password
        }
        return password == correctPass
    }

    fun isUser(username : String): Boolean {
        val user : Optional<UserInfo>? = userArray.stream().filter { UserInfo -> UserInfo.username.equals(username)}.findFirst()
        if(user!!.isPresent()) {
            var userData = user.get()
            if(userData.access=="User")
                return true
            else if(userData.access=="Admin")
                return false
        }
        return true
    }

    fun deleteUser(username : String) {
        try{
            val matchUsername : Optional<UserInfo>? = userArray.stream().filter { UserInfo -> UserInfo.username.equals(username)}.findFirst()
            Log.i("RegisterClass_deleteUser_matchUsername", matchUsername.toString())
            if(matchUsername!!.isPresent()) {
                var user = matchUsername.get()
                userArray.remove(user)
            }
        }
        catch (e : Exception) {
            Log.e("RegisterClass_deleteUser_error", e.message.toString())
        }
    }

    fun getUserData(username : String, detail : String) : String {
        var info = ""
        try {
            val matchUsername : Optional<UserInfo>? = userArray.stream().filter { UserInfo -> UserInfo.username.equals(username)}.findFirst()
            Log.i("RegisterClass_getUserData_matchUsername", matchUsername.toString())
            Log.i("RegisterClass_getUserData_UserInfo", ReturnArray().toString())

            if(matchUsername!!.isPresent()) {
                if(matchUsername!!.isPresent()) {
                var user = matchUsername.get()

                if(detail=="firstname")
                    info = user.firstname
                else if(detail=="lastname")
                    info = user.lastname
                else if(detail=="username")
                    info = user.username
                else if(detail=="email")
                    info = user.email
                else if(detail=="mobilenumber")
                    info = user.mobilenumber
                else if(detail=="birthday")
                    info = user.birthday
                else if(detail=="access")
                    info = user.access
                }
            }
        } catch (e : Exception) {
            Log.e("RegisterClass_getUserData_error", e.message.toString())
        }
        return info
    }

    fun updateUserData(username : String, detail : String, update: String) {
        try {
            val matchUsername : Optional<UserInfo>? = userArray.stream().filter { UserInfo -> UserInfo.username.equals(username)}.findFirst()
            Log.i("RegisterClass_updateUserData_matchUsername", matchUsername.toString())
            var info = ""
            if(matchUsername!!.isPresent()) {
                var user = matchUsername.get()
                var index = userArray.indexOf(user)
                if(detail=="firstname") {
                    var updatedUser = UserInfo(user.username,user.password,update,user.lastname,user.email,user.mobilenumber,user.birthday,user.access)
                    userArray.set(index,updatedUser)
                }
                else if(detail=="lastname") {
                    var updatedUser = UserInfo(user.username,user.password,user.firstname,update,user.email,user.mobilenumber,user.birthday,user.access)
                    userArray.set(index,updatedUser)
                }
                else if(detail=="username") {
                    var updatedUser = UserInfo(update,user.password,user.firstname,user.lastname,user.email,user.mobilenumber,user.birthday,user.access)
                    userArray.set(index,updatedUser)
                }
                else if(detail=="password") {
                    var updatedUser = UserInfo(user.username,update,user.firstname,user.lastname,user.email,user.mobilenumber,user.birthday,user.access)
                    userArray.set(index,updatedUser)
                }
                else if(detail=="email") {
                    var updatedUser = UserInfo(user.username,user.password,user.firstname,user.lastname,update,user.mobilenumber,user.birthday,user.access)
                    userArray.set(index,updatedUser)
                }
                else if(detail=="mobilenumber") {
                    var updatedUser = UserInfo(user.username,user.password,user.firstname,user.lastname,user.email,update,user.birthday,user.access)
                    userArray.set(index,updatedUser)
                }
                else if(detail=="birthday") {
                    var updatedUser = UserInfo(user.username,user.password,user.firstname,user.lastname,user.email,user.mobilenumber,update,user.access)
                    userArray.set(index,updatedUser)
                }
                else if(detail=="access") {
                    var updatedUser = UserInfo(user.username,user.password,user.firstname,user.lastname,user.email,user.mobilenumber,user.birthday,update)
                    userArray.set(index,updatedUser)
                }
            }
        } catch (e : Exception) {
            Log.e("RegisterClass_updateUserData_error", e.message.toString())
        }
    }
}