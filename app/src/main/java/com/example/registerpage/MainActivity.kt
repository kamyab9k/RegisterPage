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
import com.example.registerpage.data.repository.UserRepository
import com.example.registerpage.data.session.UserSessionManager
import com.example.registerpage.ui.navigationCompose.SetupNavGraph
import com.example.registerpage.ui.viewModel.RegisterViewModel

class MainActivity : ComponentActivity() {
    private lateinit var registerViewModel: RegisterViewModel
    private lateinit var userRepository: UserRepository
    private lateinit var userSessionManager: UserSessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userSessionManager=UserSessionManager(applicationContext)
        userRepository = UserRepository(userSessionManager)
        registerViewModel = RegisterViewModel(userRepository)

        setContent {
            AppUI(
                navController = rememberNavController(),
                registerViewModel=registerViewModel
            )
        }
    }
}

@Composable
fun AppUI(navController: NavHostController, registerViewModel: RegisterViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        SetupNavGraph(navController = navController, registerViewModel = registerViewModel)
    }
}