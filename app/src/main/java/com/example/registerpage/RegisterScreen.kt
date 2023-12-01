package com.example.registerpage

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun RegisterScreen(navController: NavHostController, userSessionManager: UserSessionManager) {

    var name by remember {
        mutableStateOf("")
    }
    var lastName by remember {
        mutableStateOf("")
    }
    var pickedDate by remember {
        mutableStateOf(LocalDate.now().toString())
    }
    var idNumber by remember {
        mutableStateOf("")
    }

    val dateDialogState = rememberMaterialDialogState()

//    val formattedDate by remember {
//        derivedStateOf {
//            DateTimeFormatter
//                .ofPattern("MMM dd yyyy")
//                .format(pickedDate)
//        }
//    }
    Column(modifier = Modifier.padding(24.dp)) {

        Spacer(modifier = Modifier.height(64.dp))
        Text(
            "Welcome",
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Let's get started by filling in the blanks",
            fontSize = 16.sp,
            fontWeight = FontWeight.Light
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {
        Spacer(modifier = Modifier.height(64.dp))

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text("Name")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(
            value = lastName,
            onValueChange = {
                lastName = it
            },
            label = {
                Text("Last name")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        )
        //        ID needs to be limited to 10 digits
        OutlinedTextField(
            value = idNumber,
            onValueChange = {
                idNumber = it
            },
            label = {
                Text("ID number")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        )
        OutlinedButton(
            onClick = {
                dateDialogState.show()
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .padding(8.dp)
        ) {
            Text(text = "Birthday")
        }
//        Text(text = formattedDate)
//        Spacer(modifier = Modifier.height(16.dp))

        MaterialDialog(
            dialogState = dateDialogState,
            buttons = {
                positiveButton(text = "Ok") {
//                    Toast.makeText(
//                        context,
//                        "show selected date here",
//                        Toast.LENGTH_LONG
//                    ).show()
                }
                negativeButton(text = "Cancel")
            }
        ) {
//            Has a bug when user wants to update the selected date again
            datepicker(
                initialDate = LocalDate.now(),
                title = "Pick a date",
                allowedDateValidator = {
                    pickedDate >= it.toString()
                }
            ) {
                pickedDate = it.toString()
            }
        }

        Button(
            onClick = {
//                navController.navigate(route = "userInfo_screen/$name/$lastName/$idNumber/$pickedDate")

                    // Validate the input fields before navigating
                    if (validateInputFields()) {
                        // Save user information to session manager
                        userSessionManager.saveUserInfo(name, lastName, idNumber, pickedDate)
                        userSessionManager.saveSignUpStatus(true)
                        // Navigate to UserInfoScreen
                        navController.navigate(route = "userInfo_screen/$name/$lastName/$idNumber/$pickedDate")
                    } else {
                        // Show an error message or handle validation failure
                    }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "Register")
        }
    }
}
//  Validate your input fields here
fun validateInputFields(): Boolean {
    // Implement your validation logic, return true if valid, false otherwise
    return true
}

