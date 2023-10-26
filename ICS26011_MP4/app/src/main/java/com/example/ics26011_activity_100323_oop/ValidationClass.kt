package com.example.ics26011_activity_100323_oop

import android.util.Log
import java.time.LocalDate
import java.time.Period
import java.util.regex.Pattern

class ValidationClass {
    fun ValidateUsername(username : String): Pair<Boolean,String> {
        var ErrMsg = ""
        var go : Boolean = false
        try {
            var registerObject = RegisterClass()
            var findUsername = registerObject.ReturnArray().stream().anyMatch {x -> x.username.equals(username)}
            if (username.isNullOrEmpty()) {
                ErrMsg = "Username field is required."
            } else if(findUsername == true) {
                ErrMsg = "Username exists already."
            } else {
                return Pair(true, ErrMsg)
            }
        } catch (e : Exception) {
            Log.e("error_username", e.message.toString())
        }
        return Pair(go, ErrMsg)
    }

    fun ValidatePassword(password : String): Pair<Boolean,String> {
        var ErrMsg: String = ""
        var ErrSpecialCharacter: String = ""
        var ErrUppercase: String = ""
        var ErrLowercase: String = ""
        var ErrNumber: String = ""
        var ErrMinMax: String = ""
        var ErrCount: Int = 0
        var go : Boolean = false
        try {
            if (password.isNullOrEmpty()) {
                ErrMsg = "Password field is required."
            } else {
                if (password.length < 5 || password.length > 8) {
                    ErrMinMax = "a minimum of 5 characters or maximum of 8 characters, "
                    ErrCount++
                }
                if (!Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE).matcher(password)
                        .find()
                ) { //no special character
                    ErrSpecialCharacter = "a special character, "
                    ErrCount++
                }
                if (!Pattern.compile("[A-Z]").matcher(password).find()) {
                    ErrUppercase = "an uppercase letter, "
                    ErrCount++
                }
                if (!Pattern.compile("[a-z]").matcher(password).find()) {
                    ErrLowercase = "a lowercase letter, "
                    ErrCount++
                    Log.i("reg", "no lowercase")
                }
                if (!Pattern.compile("[0-9]", Pattern.CASE_INSENSITIVE).matcher(password).find()) {
                    ErrNumber = "a number, "
                    ErrCount++
                }
                if (ErrCount > 0) { //contains at least 1 error
                    ErrMsg =
                        "Password must have " + ErrMinMax + ErrSpecialCharacter + ErrUppercase + ErrLowercase + ErrNumber
                    ErrMsg = ErrMsg.substring(0, ErrMsg.length - 2) + "." //remove comma and space, adding dot
                    ErrSpecialCharacter = ""
                    ErrUppercase = ""
                    ErrLowercase = ""
                    ErrNumber = ""
                    ErrMinMax = ""
                    ErrCount = 0
                } else {
                    return Pair(true, ErrMsg)
                }
            }
        } catch (e : Exception) {
            Log.e("error_password", e.message.toString())
        }
        return Pair(go, ErrMsg)
    }

    fun ValidateFirstName(firstname : String): Pair<Boolean,String> {
        var ErrMsg = ""
        var go : Boolean = false
        try {
            if (firstname.isNullOrEmpty()) {
                ErrMsg = "First name field is required."
            } else {
                return Pair(true, ErrMsg)
            }
        } catch (e : Exception) {
            Log.e("error_firstname", e.message.toString())
        }
        return Pair(go, ErrMsg)
    }

    fun ValidateLastName(lastname : String): Pair<Boolean,String> {
        var ErrMsg = ""
        var go : Boolean = false
        try {
            if (lastname.isNullOrEmpty()) {
                ErrMsg = "Last name field is required."
            } else {
                return Pair(true, ErrMsg)
            }
        } catch (e : Exception) {
            Log.e("error_lastname", e.message.toString())
        }
        return Pair(go, ErrMsg)
    }

    fun ValidateEmail(email : String): Pair<Boolean,String> {
        var ErrMsg = ""
        var go : Boolean = false
        try{
            if (email.isNullOrEmpty()) {
                ErrMsg = "Email field is required."
            } else if(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {  //is a valid email
                return Pair(true, ErrMsg)
            } else {
                ErrMsg = "Not a valid email address."
            }
        } catch (e : Exception) {
            Log.e("error_email", e.message.toString())
        }
        return Pair(go, ErrMsg)
    }

    fun ValidateMobile(mobile : String): Pair<Boolean,String> {
        var ErrMsg =""
        var go : Boolean = false
        try {
            if (mobile.isNullOrEmpty()) {
                ErrMsg = "Mobile number field is required."
            } else {
                if (mobile.length != 11) {
                    ErrMsg = "Mobile number must be 11 digits."
                } else {
                    return Pair(true, ErrMsg)
                }
            }
        } catch (e : Exception) {
            Log.e("error_mobile", e.message.toString())
        }
        return Pair(go, ErrMsg)
    }

    fun ValidateBirthday(birthday : String): Pair<Boolean,String> {
        var ErrMsg = ""
        var go : Boolean = false
        try {
            Log.i("info_birthday", birthday)
            Log.i("info_day", LocalDate.now().toString())
            val bday = birthday.split("/").toTypedArray()
            var age = 0
            if (birthday.isNullOrEmpty()) {
                ErrMsg = "Birthday field is required."
            } else {
                age = Period.between(
                    LocalDate.of(bday[2].toInt(), bday[1].toInt(), bday[0].toInt()),
                    LocalDate.now()
                ).years
                if (age<18){
                    ErrMsg = "You are not 18 years old and above."
                } else {
                    return Pair(true, ErrMsg)
                }
            }
        } catch (e : Exception) {
            Log.e("error_birthday", e.message.toString())
        }
        return Pair(go, ErrMsg)
    }
}