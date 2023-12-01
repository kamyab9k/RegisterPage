package com.example.registerpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    private lateinit var userSessionManager: UserSessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userSessionManager = UserSessionManager(applicationContext)
        setContent {
            if (userSessionManager.getSignUpStatus()) {
                // User is already signed up, navigate to UserInfoScreen
                UserInfoContent(
                    navController = rememberNavController(),
                    userSessionManager = userSessionManager
                )
            } else {
                // User is not signed up, show the registration screen
                RegistrationContent(
                    navController = rememberNavController(),
                    userSessionManager = userSessionManager
                )
            }
        }
    }
}


@Composable
fun UserInfoContent(navController: NavHostController, userSessionManager: UserSessionManager) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        AppUI(navController = navController, userSessionManager = userSessionManager)
    }
}

@Composable
fun RegistrationContent(navController: NavHostController, userSessionManager: UserSessionManager) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        AppUI(navController = navController, userSessionManager = userSessionManager)
    }
}



@Composable
fun AppUI(navController: NavHostController, userSessionManager: UserSessionManager) {
    SetupNavGraph(navController = navController, userSessionManager = userSessionManager)
}