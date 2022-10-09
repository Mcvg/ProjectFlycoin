package com.example.activity1.navigate

sealed class AppScreen(val route: String){
    object FirstScreen: AppScreen("First_Screen")
    object SecondScreen: AppScreen("Second_Screen")
    object ThirdScreen: AppScreen("Third_Screen")
}

