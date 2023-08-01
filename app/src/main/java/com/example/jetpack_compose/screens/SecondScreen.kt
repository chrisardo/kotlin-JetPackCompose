package com.example.jetpack_compose.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SecondScreen(navController: NavController, text: String?){
    Scaffold(
        topBar = {
            TopAppBar() {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "img",
                    modifier = Modifier.clickable {
                        navController.popBackStack()//volver atras
                    })
                Spacer(modifier = Modifier.height(8.dp))//Separar textos
                Text(text = "SecondScreen")
            }
        }
    ) {
        SecondBodyContent(navController, text)
    }
}

@Composable
fun SecondBodyContent(navController: NavController, text: String?){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =  Alignment.CenterHorizontally
    ) {
        Text("He navegado")
        text?.let{
            Text(it)
        }
        Button(onClick = {
            navController.popBackStack()
        }){
            Text("Volver atrás")
        }
    }
}
/*@Preview(showBackground = true)
@Composable
fun SecondDefaultPreview(){
    SecondScreen()
}*/