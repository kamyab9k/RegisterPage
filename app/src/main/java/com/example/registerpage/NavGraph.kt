package com.example.registerpage

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Register.route
    ) {
        composable(
            route = Screen.Register.route
        ) {
            RegisterScreen(navController)
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
                } ,
                navArgument(name = "pickedDate_key") {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->
            val name = navBackStackEntry.arguments?.getString("name_key")
            val lastName = navBackStackEntry.arguments?.getString("lastName_key")
            val id = navBackStackEntry.arguments?.getString("id_key")
            val pickedDate = navBackStackEntry.arguments?.getString("pickedDate_key")
           UserInfoScreen(name = name, lastName =lastName, id = id, pickedDate =pickedDate)
        }
    }
}