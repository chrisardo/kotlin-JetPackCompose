package com.example.jetpack_compose

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.jetpack_compose.navigation.AppNavigation
import com.example.jetpack_compose.navigation.AppScreens

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewContainer()
            /*var show by rememberSaveable { mutableStateOf(false) }
            MyAlertDialog(show,
                { show = false },
                { Toast.makeText(this, "Confirmado", Toast.LENGTH_LONG).show() }
            )

            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Button(onClick = { show = true
                }) {
                    Text(text = "Boton")
                }
            }
            */
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun ViewContainer() {//Vista general
    var context = LocalContext.current
    var show by rememberSaveable { mutableStateOf(false) }
    MyAlertDialog(show,
        { show = false },
        { Toast.makeText(context, "Confirmado", Toast.LENGTH_LONG).show() }
    )
    /*
    Scaffold-> Posiciona los elementos tipicos que hay en una pantalla de material como la actionbar,
     menu lateral, la boton navigation, el floatingActionButton, es casi el equivalente al coordinatorLayot

     Artist -> Equivalente al box, implementa todas las ideas detrás de material.

     */
    Scaffold(
        topBar = { Toolbar() },
        content = { Content() },
        bottomBar = {
            //Box -> FrameLayout, se pueden organizar los elementos alineandolos con la caja que los contiene de una forma muy básica.
            Box(
                modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth(), contentAlignment = Alignment.Center) {
                Button(onClick = { show = true
                }) {
                    Text(text = "Boton")
                }
            }
        },

        floatingActionButton = {
            FAB()
        },
        floatingActionButtonPosition = FabPosition.End

    )
}

@Composable
fun boton() {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Button(onClick = {
            //show = true
        }) {
            Text(text = "Boton")
        }
    }
}

@Composable
fun MyAlertDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (show) {
        AlertDialog(onDismissRequest = { onDismiss() },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Confirma")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Cancelar")
                }
            },
            title = { Text(text = "Hola Chrisardo Rojas") },
            text = { Text(text = "¿Estas aprendiendo a desarrollador apps móbil con Kotlin?") }
        )
    }
}

@Composable
fun FAB() {
    var context = LocalContext.current
    FloatingActionButton(onClick = {
        //var show by rememberSaveable { mutableStateOf(false) }
        //var show = true
        //MyAlertDialog(show, {show = false},{ Log.i("aris", "click")})
    }) {
        Text("Click")
    }
}

@Composable
fun Toolbar() {
    TopAppBar(
        title = { Text(text = "Aprendiendo JetPsck Compose", color = colorResource(id = R.color.purple_700)) },
        backgroundColor = colorResource(id = R.color.orange)
    )
}

@Composable
fun Content() {
    var counter by rememberSaveable() { mutableStateOf(0) } //Contador desde 0, estado mutable a variar
    /*
    Lazyrow, lazyColumn y Lazyverticalgrid -> Permite posicionar en cada fila o columna una cantidad de
     elementos grandes de lo cual se necesita que se cargue de poco a poco, lo cual serian los sustituo de recyclerview

     */
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
            .padding(16.dp)

    ) {
        item {
            Image(
                modifier = Modifier.fillMaxWidth().height(400.dp),
                painter = painterResource(id = R.drawable.kotlin),
                contentDescription = "Logo Chrisardo"
            )
            Row(
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "like",
                    modifier = Modifier.clickable { counter++ },

                    )
                Text(
                    text = counter.toString(),
                    color = Color.White,
                    fontSize = 26.sp,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
            Text(
                text = "Chrisardo Rojas",
                fontSize = 36.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Desarrollo mobil",
                color = Color.White,
                textAlign = TextAlign.Left,
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 8.dp)
            )
            LazyRow(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                item {
                    Text(
                        text = "Java",
                        fontSize = 26.sp,
                        color = Color.White
                    )
                    Text(
                        text = "Kotlin",
                        fontSize = 26.sp,
                        color = Color.White
                    )
                    Text(
                        text = "Flutter",
                        fontSize = 26.sp,
                        color = Color.White
                    )
                    Text(
                        text = "React Js",
                        fontSize = 26.sp,
                        color = Color.White
                    )
                    Text(
                        text = "Dark",
                        fontSize = 26.sp,
                        color = Color.White
                    )
                }
            }
        }

    }
}

//https://youtu.be/CwR1VUeRjvs?list=PL8ie04dqq7_ORKWIwiaSTcyBKtasZtNUD