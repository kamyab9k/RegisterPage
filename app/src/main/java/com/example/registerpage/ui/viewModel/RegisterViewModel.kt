package com.example.registerpage.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.registerpage.data.model.UserInformation
import com.example.registerpage.data.repository.UserRepository

class RegisterViewModel(private val userRepository: UserRepository) : ViewModel() {

    val signUpStatus = userRepository.getSignUpStatus()

    val userInformation = userRepository.getUserData()

    fun saveSignUpStatus(isSignedUp: Boolean) {
        userRepository.saveSignUpStatus(isSignedUp)
    }

    fun clearSession() {
        userRepository.clearSession()
    }

    fun saveUserData(name: String, lastName: String, idNumber: String, pickedDate: String) {
        val newUser = UserInformation(name, lastName, idNumber, pickedDate)
        userRepository.saveUserData(newUser)
    }

}
