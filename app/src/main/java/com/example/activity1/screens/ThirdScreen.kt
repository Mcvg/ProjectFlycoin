package com.example.activity1.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.activity1.navigate.AppScreen

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
            Text(text = "Movimientos",
                fontSize = 30.sp)
            IconButton(onClick = { navController.popBackStack()}) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "Regresar"
                )
            }
        }
        Row{
            ListWithDividers()
        }
    }
//
//            Row() {
//                Text(text = "cantidad ", color = Color.Red)
//                Text(text = "Banco")
//            }
//        Row() {
//            Text(text = "cantidad ", color = Color.Green)
//            Text(text = "Banco")
//        }
//
//
//    }


}
@Composable
fun ListWithColumn(items: List<String>) { // (1)
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.verticalScroll(scrollState)) { // (2)
        items.forEach { item -> // (4)
            ListItemRow(item) // (5)
        }
    }
}

@Composable // (3)
fun ListItemRow(item: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(text = item, style = MaterialTheme.typography.subtitle1, color = Color(0xFF009B7D))
    }
}

@Composable
fun ListWithDividers() {
    val items = List(10) { "Item ${it + 1}" }

    Column {
        LazyColumn {
            items(items) { item ->
                ListItemRow(item)
                Divider()
            }
        }
    }
}

