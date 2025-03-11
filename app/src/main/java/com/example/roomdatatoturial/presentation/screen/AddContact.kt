package com.example.roomdatatoturial.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.roomdatatoturial.R
import com.example.roomdatatoturial.data.response.AppResponse


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddContact(
    modifier: Modifier = Modifier,
    onEvent: () -> Unit = {},
    state: AppResponse = AppResponse(),
    navController: NavHostController= rememberNavController()
) {

    var mobileNumber by rememberSaveable { mutableStateOf("") }
    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }


    Box(modifier =Modifier.fillMaxSize().padding(start = 10.dp, end = 10.dp, top = 30.dp)){
        Column {
            // Mobile Number Input
            OutlinedTextField(
                value = state.name.value,
                onValueChange = { state.name.value = it },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                label = { Text("Enter Name") },
                placeholder = { Text("Enter Name") }
            )

            OutlinedTextField(
                value = state.mobileNumber.value,
                onValueChange = {  state.mobileNumber.value = it },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                label = { Text("Enter Mobile Number") },
                placeholder = { Text("Enter Mobile Number") }
            )

            OutlinedTextField(
                value = state.email.value,
                onValueChange = { state.email.value = it },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                label = { Text("Enter Email") },
                placeholder = { Text("Enter Email") }
            )

            Button(
                onClick = {
                    onEvent.invoke()
                    navController.navigateUp()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_200)
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                Text(text = "Add Data")
            }
        }
    }
}