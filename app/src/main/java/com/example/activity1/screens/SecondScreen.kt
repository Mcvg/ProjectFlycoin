package com.example.activity1.screens

import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.activity1.R
import com.example.activity1.navigate.AppScreen
import kotlin.random.Random

@Composable
fun SecondScreen(navController: NavController) {
    Scaffold() {
        Transaction(navController)
    }
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Transaction(navController:NavController){
    val typesBank = listOf("Bancolombia", "BBVA", "Av Villas", "Davivienda")
    val typesAccount = listOf("Ahorros", "Corriente")
    val defaultBank = "Seleccionar banco"
    val defaultAccount = "Seleccionar tipo"

    var expandedBank by remember { mutableStateOf(false) }
    var expandedAccount by remember { mutableStateOf(false) }
    var selectedTypeBank by remember { mutableStateOf(defaultBank) }
    var selectedTypeAccount by remember { mutableStateOf(defaultAccount) }
    var color by remember { mutableStateOf(Color.LightGray) }

    Column( Modifier.size(500.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row() {
            Text(text = "Transacción",
                fontSize = 30.sp)
        }
        Row{
            IconButton(onClick = { navController.popBackStack()}) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "Regresar"
                )
            }
        }

        Text(text = "Valor")
        Row {
            TextField(value = "", onValueChange = {})
            IconButton(
                onClick = {
                    val randomColor = Color(Random.nextLong(0xFF000000, 0xFFFFFFFF))
                    color = randomColor
                }) {
                Image(
                    painter = painterResource(id = R.drawable.dolar),
                    contentDescription = "Cambiar moneda",
                    modifier = Modifier.size(50.dp)
                )
            }
        }
        Text(text = "Banco")
        Row{
            ExposedDropdownMenuBox(
                expanded = expandedBank,
                onExpandedChange = {
                    expandedBank = !expandedBank
                },
            ) {
                TextField(
                    readOnly = true,
                    value = selectedTypeBank,
                    onValueChange = { },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon( // (5)
                            expanded = expandedBank
                        )
                    },
                )
                ExposedDropdownMenu(
                    expanded = expandedBank,
                    onDismissRequest = {
                        expandedBank = false
                    }
                ) {
                    typesBank.forEach { selectionOption ->
                        DropdownMenuItem(
                            onClick = {
                                selectedTypeBank = selectionOption
                                expandedBank = false
                            }
                        ) {
                            Text(text = selectionOption)
                        }
                    }
                }
            }
        }
        Text(text = "Tipo cuenta")
        Row{
            ExposedDropdownMenuBox(
                expanded = expandedAccount,
                onExpandedChange = {
                    expandedAccount = !expandedAccount
                },
            ) {
                TextField(
                    readOnly = true,
                    value = selectedTypeAccount,
                    onValueChange = { },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon( // (5)
                            expanded = expandedAccount
                        )
                    },
                )
                ExposedDropdownMenu(
                    expanded = expandedAccount,
                    onDismissRequest = {
                        expandedAccount = false
                    }
                ) {
                    typesAccount.forEach { selectionOption ->
                        DropdownMenuItem(
                            onClick = {
                                selectedTypeAccount = selectionOption
                                expandedAccount = false
                            }
                        ) {
                            Text(text = selectionOption)
                        }
                    }
                }
            }
        }
        Text(text = "Número Cuenta")
        TextField(value = "", onValueChange = {})

        Row{
            ExtendedFloatingActionButton(
                backgroundColor = Color(0xFF6200EE),
                text = {

                    val style = MaterialTheme.typography.button.copy(
                        fontSize = 13.sp
                    )
                    Text("Transferir", style = style)
                },
                onClick = { navController.navigate(AppScreen.ThirdScreen.route) })
        }
    }

}