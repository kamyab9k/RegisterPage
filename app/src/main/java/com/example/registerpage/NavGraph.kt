package com.example.registerpage

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


@Composable
fun SetupNavGraph(navController: NavHostController, userSessionManager: UserSessionManager) {
    NavHost(
        navController = navController,

        startDestination =
        if (userSessionManager.getSignUpStatus()) {
            Screen.UserInfo.route
        } else {
            Screen.Register.route
        }
    ) {
        composable(
            route = Screen.Register.route
        ) {
            RegisterScreen(navController, userSessionManager)
        }

        composable(
            route = Screen.UserInfo.route,
            arguments = listOf(
                navArgument(name = "name_key") {
                    type = NavType.StringType
                },
                navArgument(name = "lastName_key") {
                    type = NavType.StringType
                },
                navArgument(name = "id_key") {
                    type = NavType.StringType
                },
                navArgument(name = "pickedDate_key") {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->
            val name = userSessionManager.getName()
            val lastName = userSessionManager.getLastName()
            val id = userSessionManager.getIdNumber()
            val pickedDate = userSessionManager.getPickedDate()
            UserInfoScreen(name = name, lastName = lastName, id = id, pickedDate = pickedDate)
        }
    }
}