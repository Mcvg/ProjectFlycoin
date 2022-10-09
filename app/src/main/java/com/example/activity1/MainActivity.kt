package com.example.activity1

import androidx.lifecycle.viewmodel.compose.viewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.activity1.navigate.AppNav
import com.example.activity1.ui.theme.Activity1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Activity1Theme {
                AppNav()
            }
        }
    }

//    @Composable
//    private fun UserList(userViewModel: UserViewModel = viewModel()) {
//        userViewModel.fetchUser()
//        val users by userViewModel.users.collectAsState()
//        LazyColumn{
//            items(users.size){
//                ActivityMenuContent(user = users[it])
//            }
//        }
//    }

   /* @Composable
    private fun ActivityMenuContent(user: User){
            Column() {

                Image(
                    painter = painterResource(id = R.drawable.ic__61458),
                    contentDescription = ""
                )
                    Text(user.name, style = MaterialTheme.typography.h6)
                    Text(user.saldo, style = MaterialTheme.typography.h6)

            Row {
                    Button(onClick = { /*TODO*/ }) {

                    }
                    Button(onClick = { /*TODO*/ }) {

                    }
            }
        }
    }*/

//
//    @Preview(showBackground = true)
//    @Composable
//    fun ActivityMenuContentPreview() {
//        Activity1Theme{
//            ActivityMenuContent(User("", ""))
//        }
//    }


}