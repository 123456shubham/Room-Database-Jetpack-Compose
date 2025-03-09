package com.example.roomdatatoturial.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.roomdatatoturial.data.entity.Contact
import com.example.roomdatatoturial.data.response.AppResponse
import com.example.roomdatatoturial.data.viewModel.ContactViewModel
import com.example.roomdatatoturial.presentation.navigation.Routes


@Composable
fun HomeScreenUI(modifier: Modifier=Modifier,state: AppResponse,viewModel: ContactViewModel = hiltViewModel(),navController: NavController){


    Scaffold(floatingActionButton = { FloatingActionButton(onClick = {navController.navigate(Routes.AddContact)}) {
        Icon( Icons.Rounded.Add, contentDescription = null)
    } }) {
        it
        LazyColumn(modifier = Modifier.fillMaxSize().padding(12.dp)){

            items(state.allContact){
                ContactUI(contact = it)
            }

        }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ContactUI(contact: Contact= Contact()){


    Card(modifier = Modifier.fillMaxWidth().padding(top=50.dp, start = 10.dp, end = 10.dp).clickable {}, shape = RoundedCornerShape(20.dp), colors = CardDefaults.cardColors(containerColor = Color.White)){

        Text("Name: ${contact.name}", fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp))
        Text("Phone: ${contact.phone}", fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp))
        Text("Email: ${contact.email}", fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp))
    }

}