package com.example.registerpage.data.repository

import android.content.Context
import com.example.registerpage.data.model.UserInformation
import com.example.registerpage.data.session.UserSessionManager

class UserRepository(context: Context) {

    private val userSessionManager = UserSessionManager(context)

    // Save the signup status
    fun saveSignUpStatus(isSignedUp: Boolean) {
        userSessionManager.saveSignUpStatus(isSignedUp)
    }

    // Get the signup status
    fun getSignUpStatus(): Boolean {
        return userSessionManager.getSignUpStatus()
    }

    fun clearSession() {
        userSessionManager.clearSession()
    }

    fun saveUserData(userData: UserInformation) {
        userSessionManager.saveUserInfo(
            userData.name.orEmpty(),
            userData.lastName.orEmpty(),
            userData.idNumber.orEmpty(),
            userData.pickedDate.orEmpty()
        )
    }

    fun getUserData(): UserInformation {
        return UserInformation(
            userSessionManager.getName(),
            userSessionManager.getLastName(),
            userSessionManager.getIdNumber(),
            userSessionManager.getPickedDate()
        )
    }
}