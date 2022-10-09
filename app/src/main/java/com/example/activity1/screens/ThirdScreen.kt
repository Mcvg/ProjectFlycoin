package com.example.activity1.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun ThirdScreen(navController: NavController) {
    Scaffold() {
        TransactionHistory(navController)
    }
}
@Composable
fun TransactionHistory(navController: NavController){

    Column() {
       Row() {
           Text(text = "Movimientos")
           Button(onClick = { navController.popBackStack()}) {
               Text(text = "Volver")
       }
        }

            Row() {
                Text(text = "cantidad ", color = Color.Red)
                Text(text = "Banco")
            }
        Row() {
            Text(text = "cantidad ", color = Color.Green)
            Text(text = "Banco")
        }


    }
}
