package com.example.registerpage.ui.navigationCompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.registerpage.ui.screen.RegisterScreen
import com.example.registerpage.ui.screen.UserInfoScreen
import com.example.registerpage.ui.viewModel.RegisterViewModel


@Composable
fun SetupNavGraph(navController: NavHostController, registerViewModel: RegisterViewModel) {

    NavHost(

        navController = navController,

        startDestination =
        if (registerViewModel.signUpStatus) {
            Screen.UserInfo.route
        } else {
            Screen.Register.route
        }
    ) {
        composable(
            route = Screen.Register.route
        ) {
            RegisterScreen(navController, registerViewModel)
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
        ) {
            val name = registerViewModel.userInformation.name
            val lastName = registerViewModel.userInformation.lastName
            val id = registerViewModel.userInformation.idNumber
            val pickedDate = registerViewModel.userInformation.pickedDate
            UserInfoScreen(name = name, lastName = lastName, id = id, pickedDate = pickedDate,navController,registerViewModel)
        }
    }
}