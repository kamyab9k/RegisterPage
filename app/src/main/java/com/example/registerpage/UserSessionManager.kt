package com.example.registerpage

import android.content.Context
import java.time.LocalDate

class UserSessionManager(context: Context) {
    private val sharedPreferences =
        context.getSharedPreferences("UserSession", Context.MODE_PRIVATE)
    private val isSignedUpKey = "is_signed_up"

//    fun saveUserSession(userId: String) {
//        sharedPreferences.edit().putString("userId", userId).apply()}

    // Save the signup status
    fun saveSignUpStatus(isSignedUp: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(isSignedUpKey, isSignedUp)
        editor.apply()
    }

    // Get the signup status
    fun getSignUpStatus(): Boolean {
        return sharedPreferences.getBoolean(isSignedUpKey, false)
    }

        fun clearSession() {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
        }


        fun saveUserInfo(name: String, lastName: String, idNumber: String, pickedDate: LocalDate) {
            val editor = sharedPreferences.edit()
            editor.putString("name", name)
            editor.putString("lastName", lastName)
            editor.putString("idNumber", idNumber)
            editor.putString("pickedDate", pickedDate.toString())
            editor.apply()
        }

        fun getName(): String? {
            return sharedPreferences.getString("name", null)
        }

        fun getLastName(): String? {
            return sharedPreferences.getString("lastName", null)
        }

        fun getIdNumber(): String? {
            return sharedPreferences.getString("idNumber", null)
        }

        fun getPickedDate(): LocalDate? {
            val epochDay = sharedPreferences.getLong("pickedDate", -1)
            return if (epochDay != -1L) LocalDate.ofEpochDay(epochDay) else null
        }
    }
