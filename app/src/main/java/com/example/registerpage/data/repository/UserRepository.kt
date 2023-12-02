package com.example.registerpage.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.registerpage.data.model.UserInformation
import com.example.registerpage.data.session.UserSessionManager

class UserRepository(context: Context) {

    private val userSessionManager= UserSessionManager(context)

    private val _userData = MutableLiveData<List<UserInformation>>()
    val userData: LiveData<List<UserInformation>> get() = _userData

    // Save the signup status
    fun saveSignUpStatus(isSignedUp: Boolean) {
        userSessionManager.saveSignUpStatus(isSignedUp)
    }
    fun updateUserData() {
        _userData.value = listOf(getUserData())
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