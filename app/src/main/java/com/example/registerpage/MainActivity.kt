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
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
            ) {
                RegisterScreen()
            }
        }
    }
}

@Preview
@Composable
fun RegisterScreen() {
    var name by remember {
        mutableStateOf("")
    }
    var lastName by remember {
        mutableStateOf("")
    }
    var pickedDate by remember {
        mutableStateOf(LocalDate.now())
    }
    var idNumber by remember {
        mutableStateOf("")
    }

//    val formattedDate by remember {
//        derivedStateOf {
//            DateTimeFormatter
//                .ofPattern("MMM dd yyyy")
//                .format(pickedDate)
//        }
//    }

    val dateDialogState = rememberMaterialDialogState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Information", fontSize = 24.sp)

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
//                        "Clicked ok",
//                        Toast.LENGTH_LONG
//                    ).show()
                }
                negativeButton(text = "Cancel")
            }
        ) {
            datepicker(
                initialDate = LocalDate.now(),
                title = "Pick a date",
                allowedDateValidator = {
                    pickedDate >= it
                }
            ) {
                pickedDate = it
            }
        }
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
        Button(
            onClick = {
                /* Handle login logic here */
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "Register")
        }
    }
}

