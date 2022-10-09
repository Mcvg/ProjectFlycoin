package com.example.activity1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.activity1.R
import com.example.activity1.navigate.AppScreen

@Composable
fun FirstScreen(navController:NavController) {
    Scaffold() {
        BodyContent(navController)
    }
}
@Composable
fun BodyContent(navController:NavController){
    Column() {

        Image(
            painter = painterResource(id = R.drawable.ic__61458),
            contentDescription = ""
        )
        Text("user.name", style = MaterialTheme.typography.h6)
        Text("user.saldo", style = MaterialTheme.typography.h6)

        Row() {
            Button(onClick = { navController.navigate(AppScreen.SecondScreen.route) }) {
                Text(text = "Enviar Dinero")
            }
            Button(onClick = { navController.navigate(AppScreen.ThirdScreen.route) }) {
                Text(text = "Ver Movimientos")
            }
        }
    }
}