package com.example.roomdatatoturial.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun AppNavigation (modifier: Modifier){

 var navController= rememberNavController()
 NavHost(navController = navController, startDestination = Routes.HomePage){
  composable<Routes.HomePage>{

  }
 }
 }