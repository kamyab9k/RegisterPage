package com.example.registerpage

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun UserInfoScreen(
    name: String?,
    lastName: String?,
    id: String?,
    pickedDate: String?,
    userSessionManager: UserSessionManager,
    navController: NavHostController,
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {

        Text(text = "Your Information", fontSize = 32.sp)

        Text(text = "Name: $name", fontSize = 16.sp)

        Text(text = "LastName: $lastName", fontSize = 16.sp)

        Text(text = "ID: $id", fontSize = 16.sp)

        Text(text = "PickedDate: $pickedDate", fontSize = 16.sp)

        Button(
            onClick = {
                userSessionManager.clearSession()
                navController.popBackStack()
                navController.navigate(route = Screen.Register.route)
            },
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Text(text = "Log Out")
        }
        Button(
            onClick = {
                (context as? Activity)?.finish()
                navController.popBackStack()
            },
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Text(text = "Exit")
        }
    }
}