package com.example.roomdatatoturial.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.roomdatatoturial.data.viewModel.ContactViewModel
import com.example.roomdatatoturial.presentation.screen.AddContact


@Composable
fun AppNavigation (modifier: Modifier,contactViewModel: ContactViewModel=hiltViewModel()){

 val navController= rememberNavController()
 val appState=contactViewModel.state.collectAsState()
 NavHost(navController = navController, startDestination = Routes.HomePage){
  composable<Routes.HomePage>{
   Box(modifier.fillMaxSize().padding(50.dp)){
    Button(onClick = { navController.navigate(Routes.AddContact) }) {
     Text(text = "Go to Add Contact")
    }
   }
  }

   composable<Routes.AddContact> {
    AddContact(state=appState.value, onEvent = {contactViewModel.insertContact()},navController=navController)
   }
 }
 }