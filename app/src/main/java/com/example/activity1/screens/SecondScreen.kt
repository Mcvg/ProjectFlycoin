package com.example.activity1.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.activity1.navigate.AppScreen

@Composable
fun SecondScreen(navController: NavController) {
    Scaffold() {
        Transaction(navController)
    }
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Transaction(navController:NavController){
    val types = listOf("Bancolombia", "BBVA", "Av Villas", "Davivienda")
    val default = "Seleccionar banco"

    var expanded by remember { mutableStateOf(false) }
    var selectedType by remember { mutableStateOf(default) }

    Column() {
        Row() {
            Text(text = "Transacción")
            Button(onClick = { navController.popBackStack()}) {
                Text(text = "X")
            }
        }
        Text(text = "Valor")
        TextField(value = "", onValueChange = {})
        Text(text = "Banco")
        TextField(value = "", onValueChange = {})
        Text(text = "Tipo de cuenta")
        TextField(value = "", onValueChange = {})
        Text(text = "Número Cuenta")
        TextField(value = "", onValueChange = {})

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded // (2)
            },
            modifier = Modifier.width(200.dp)
        ) {
            TextField(
                readOnly = true, // (3)
                value = selectedType, // (4)
                onValueChange = { },
                label = { Text("Tipo Banco") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon( // (5)
                        expanded = expanded
                    )
                },
//                colors = ExposedDropdownMenuDefaults.textFieldColors()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {
                types.forEach { selectionOption ->
                    DropdownMenuItem(
                        onClick = {
                            selectedType = selectionOption
                            expanded = false
                        }
                    ) {
                        Text(text = selectionOption)
                    }
                }
            }
        }
    }

}