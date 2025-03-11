package com.example.roomdatatoturial.presentation.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
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
        LazyColumn(modifier = Modifier.fillMaxSize().padding(top =50.dp)){

            items(state.allContact){
                ContactUI(contact = it,viewModel,navController)
            }

        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContactUI(contact: Contact,viewModel: ContactViewModel,navController: NavController){


    Card(modifier = Modifier.fillMaxWidth().padding(top=10.dp, start = 10.dp, end = 10.dp).combinedClickable (
        onClick = {},
        onLongClick = {
            viewModel.state.value.name.value=contact.name
            viewModel.state.value.email.value=contact.email
            viewModel.state.value.mobileNumber.value=contact.phone
            viewModel.state.value.id.value=contact.id
            navController.navigate(Routes.AddContact)

        },
        onDoubleClick = {}
    ), shape = RoundedCornerShape(20.dp), colors = CardDefaults.cardColors(containerColor = Color.White)){

        Text("Name: ${contact.name}", fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp))
        Text("Phone: ${contact.phone}", fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp))
        Text("Email: ${contact.email}", fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp))

        Row (modifier = Modifier.fillMaxWidth().padding(10.dp)){
            Icon(Icons.Default.Delete,contentDescription = null, modifier = Modifier.padding(10.dp)
                .clickable {
                    viewModel.state.value.name.value=contact.name
                    viewModel.state.value.email.value=contact.email
                    viewModel.state.value.mobileNumber.value=contact.phone
                    viewModel.state.value.id.value=contact.id
                    viewModel.deleteContact()})
        }
    }

}