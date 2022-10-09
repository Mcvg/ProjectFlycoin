package com.example.activity1.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.activity1.screens.FirstScreen
import com.example.activity1.screens.SecondScreen
import com.example.activity1.screens.ThirdScreen

@Composable
fun AppNav(){
    var navController= rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.FirstScreen.route){
        composable(route= AppScreen.FirstScreen.route){
            FirstScreen(navController)
        }
        composable(route= AppScreen.SecondScreen.route){
            SecondScreen(navController)
        }
        composable(route= AppScreen.ThirdScreen.route){
            ThirdScreen(navController)
        }
    }
}