package com.example.jetpack_compose

import android.content.res.Configuration
import android.media.VolumeShaper
import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack_compose.navigation.AppNavigation
import com.example.jetpack_compose.screens.SecondScreen
import com.example.jetpack_compose.ui.theme.Jetpack_composeTheme
private val messages: List<MyMessage> = listOf(
    MyMessage("Hola1", "Cuarta lección del curso de Jetpack Compose desde cero para principiantes con Kotlin y Android Studio. En esta clase hablaremos de animaciones y almacenamiento de variables y estados en Jetpack Compose."),
    MyMessage("Hola2", "Cuarta lección del curso de Jetpack Compose desde cero para principiantes con Kotlin y Android Studio. En esta clase hablaremos de animaciones y almacenamiento de variables y estados en Jetpack Compose."),
    MyMessage("Hola3", "Cuarta lección del curso de Jetpack Compose desde cero para principiantes con Kotlin y Android Studio. En esta clase hablaremos de animaciones y almacenamiento de variables y estados en Jetpack Compose."),
    MyMessage("Hola4", "Cuarta lección del curso de Jetpack Compose desde cero para principiantes con Kotlin y Android Studio. En esta clase hablaremos de animaciones y almacenamiento de variables y estados en Jetpack Compose."),
    MyMessage("Hola5", "Cuarta lección del curso de Jetpack Compose desde cero para principiantes con Kotlin y Android Studio. En esta clase hablaremos de animaciones y almacenamiento de variables y estados en Jetpack Compose."),
    MyMessage("Hola6", "Cuarta lección del curso de Jetpack Compose desde cero para principiantes con Kotlin y Android Studio. En esta clase hablaremos de animaciones y almacenamiento de variables y estados en Jetpack Compose."),
    MyMessage("Hola7", "Cuarta lección del curso de Jetpack Compose desde cero para principiantes con Kotlin y Android Studio. En esta clase hablaremos de animaciones y almacenamiento de variables y estados en Jetpack Compose."),
    MyMessage("Hola8", "Cuarta lección del curso de Jetpack Compose desde cero para principiantes con Kotlin y Android Studio. En esta clase hablaremos de animaciones y almacenamiento de variables y estados en Jetpack Compose."),
    MyMessage("Hola9", "Cuarta lección del curso de Jetpack Compose desde cero para principiantes con Kotlin y Android Studio. En esta clase hablaremos de animaciones y almacenamiento de variables y estados en Jetpack Compose."),
    MyMessage("Hola10", "Cuarta lección del curso de Jetpack Compose desde cero para principiantes con Kotlin y Android Studio. En esta clase hablaremos de animaciones y almacenamiento de variables y estados en Jetpack Compose."),
    MyMessage("Hola11", "Cuarta lección del curso de Jetpack Compose desde cero para principiantes con Kotlin y Android Studio. En esta clase hablaremos de animaciones y almacenamiento de variables y estados en Jetpack Compose."),
    MyMessage("Hola12", "Cuarta lección del curso de Jetpack Compose desde cero para principiantes con Kotlin y Android Studio. En esta clase hablaremos de animaciones y almacenamiento de variables y estados en Jetpack Compose."),
    MyMessage("Hola13", "Cuarta lección del curso de Jetpack Compose desde cero para principiantes con Kotlin y Android Studio. En esta clase hablaremos de animaciones y almacenamiento de variables y estados en Jetpack Compose."),
    MyMessage("Hola14", "Cuarta lección del curso de Jetpack Compose desde cero para principiantes con Kotlin y Android Studio. En esta clase hablaremos de animaciones y almacenamiento de variables y estados en Jetpack Compose.")

)
class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_composeTheme {
                MyMessages(messages)
                /*
                Surface->Se pueden aplicar mejor los elementos como la elevacion, los bordes,
                es más inteligente en la seleccion de colores basados en el tema de material.

                cart->Equivalente al Surface, representa a una card o tarjeta de material
                 */
                Surface(color = MaterialTheme.colors.background) {
                    AppNavigation()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)//Modo oscuro
@Composable
fun PreviewComponent() {
    Jetpack_composeTheme {
        AppNavigation()
        MyMessages(messages)

        /*val scrollState = rememberScrollState()//Scroll
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            MyComponent()
            MyComponent()
            MyComponent()
        }*/

    }

}

@Composable
fun MyComponent(message: MyMessage) {
    //Row-> LinearLayout horizontal, posiciona los elementos en forma horizontal
    Row(//fila
        modifier = Modifier
            .background(MaterialTheme.colors.background)//Fondo de la fila
            .padding(8.dp)
    ) {
        MyImage()
        MyTexts(message)
    }
}

@Composable
fun MyMessages(messages: List<MyMessage>) {
    LazyColumn {
        items(messages){message ->
            MyComponent(message)
        }
    }
   
}

@Composable
fun MyImage() {
    Image(
        painterResource(R.drawable.ic_favorite),
        "decripcion de la imagen",
        modifier = Modifier
            .size(34.dp)//darle tamaño de la iagen
            .clip(CircleShape)//darle forma
            .background(MaterialTheme.colors.primary)//fondo de la imagen

    )
}

data class MyMessage(val title: String, val body: String)

@Composable
fun MyTexts(message: MyMessage) {
    var columnexpanded by remember { mutableStateOf(false) }
    /*
    Column->LinarLayout vertical, posiciona los elementos en forma vertical, tambien se puede aplicar pesos para
            decidir cuanto ocupara cada elemento
     */
    Column(
        modifier = Modifier.padding(start = 8.dp).clickable {
                        columnexpanded != columnexpanded
                    }
    ) {
        MyText(
            message.title,
            MaterialTheme.colors.primary,//Darle color al texto
            MaterialTheme.typography.subtitle1 //Tipografia del texto
        )
        Spacer(modifier = Modifier.height(16.dp))//Separar textos
        MyText(
            message.body,
            MaterialTheme.colors.onBackground,//Color del texto
            MaterialTheme.typography.subtitle2,
            if(columnexpanded) Int.MAX_VALUE else 1
        )
    }
}

@Composable
fun MyText(name: String, color: Color, style: TextStyle, lines: Int = Int.MAX_VALUE) {
    Text(name, color = color, style = style, maxLines = lines)
}

