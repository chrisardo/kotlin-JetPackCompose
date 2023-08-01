package com.example.jetpack_compose.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.navArgument
import com.example.jetpack_compose.navigation.AppScreens
import java.security.AccessController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FirstScreen(navController: NavController){
    Scaffold {
        BodyContent(navController)
    }
}

@Composable
fun BodyContent(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =  Alignment.CenterHorizontally
    ) {
        Text("Hola navegacion")
        Button(onClick = {
            navController.navigate(route = AppScreens.SecondScreen.route + "/Texto Parametro pasado")
        }){
            Text("Navega")
        }
    }
}
/*@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    FirstScreen()
}*/