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
import com.example.roomdatatoturial.presentation.screen.HomeScreenUI


@Composable
fun AppNavigation (modifier: Modifier,contactViewModel: ContactViewModel=hiltViewModel()){

 val navController= rememberNavController()
 val appState=contactViewModel.state.collectAsState()
 NavHost(navController = navController, startDestination = Routes.HomeScreenUI){
  composable<Routes.HomeScreenUI>{
   HomeScreenUI(modifier,state=appState.value, viewModel = contactViewModel,navController)
  }

   composable<Routes.AddContact> {
    AddContact(state=appState.value, onEvent = {contactViewModel.insertContact()},navController=navController)
   }
 }
 }