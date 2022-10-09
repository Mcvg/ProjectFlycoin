package com.example.activity1.screens

import androidx.compose.animation.core.animateIntSizeAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Column(
        Modifier.size(500.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.user),
            contentDescription = "",
            contentScale = ContentScale.Inside,

        )
        Text("user.name", style = MaterialTheme.typography.h6,modifier = Modifier.align(Alignment.CenterHorizontally))
        Text("user.saldo", style = MaterialTheme.typography.h6)

        Row() {
            ExtendedFloatingActionButton(
                backgroundColor = Color(0xFF6200EE),
                text = {

                    val style = MaterialTheme.typography.button.copy(
                        fontSize = 13.sp
                    )
                    Text("Enviar Dinero", style = style)
                },
                onClick = { navController.navigate(AppScreen.SecondScreen.route) })


                ExtendedFloatingActionButton(
                    backgroundColor = Color(0xFF6200EE),
                    text = {

                        val style = MaterialTheme.typography.button.copy(
                            fontSize = 13.sp
                        )
                        Text("Movimientos", style = style)
                    },
                    onClick = { navController.navigate(AppScreen.ThirdScreen.route) })

        }
    }
}

