package com.example.registerpage

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
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
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(64.dp))
        Text(
            text = "User Information",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                CustomDivider()
            }
            item {
                DataItem("Name : ", name.orEmpty())
            }
            item {
                CustomDivider()
            }

            item {
                DataItem("Last Name : ", lastName.orEmpty())
            }
            item {
                CustomDivider()
            }
            item {
                DataItem("ID Number : ", id.orEmpty())
            }
            item {
                CustomDivider()
            }
            item {
                DataItem("Picked Date : ", pickedDate.orEmpty())
            }
            item {
                CustomDivider()
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {
        Spacer(modifier = Modifier.height(128.dp))
        Button(
            onClick = {
                userSessionManager.clearSession()
                navController.popBackStack()
                navController.navigate(route = Screen.Register.route)
            },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Log Out", modifier = Modifier.padding(start = 8.dp))
        }

        Button(
            onClick = {
                (context as? Activity)?.finish()
                navController.popBackStack()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Text(text = "Exit", modifier = Modifier.padding(start = 8.dp))
        }
    }
}

@Composable
fun DataItem(fieldName: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = fieldName, fontWeight = FontWeight.Bold)
        Text(text = value)
    }
}

@Composable
fun CustomDivider() {
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
    )
}