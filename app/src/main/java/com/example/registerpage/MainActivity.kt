package com.example.registerpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.registerpage.data.session.UserSessionManager
import com.example.registerpage.ui.navigationCompose.SetupNavGraph

class MainActivity : ComponentActivity() {
    private lateinit var userSessionManager: UserSessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userSessionManager = UserSessionManager(applicationContext)

        setContent {
            AppUI(
                navController = rememberNavController(),
                userSessionManager = userSessionManager
            )
        }
    }
}

@Composable
fun AppUI(navController: NavHostController, userSessionManager: UserSessionManager) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        SetupNavGraph(navController = navController, userSessionManager = userSessionManager)
    }
}