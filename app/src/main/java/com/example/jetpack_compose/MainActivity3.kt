package com.example.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.jetpack_compose.ui.theme.Jetpack_composeTheme

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_composeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    //Greeting("Android")
                    //ButtonText()
                    //MediaItem()
                    MediaList()
                }
            }
        }
    }
}

//@ExperimentalFoundationApi
//@ExperimentalCoilApi
@Preview(
    showBackground = true
)
@Composable
fun MediaList() {
    LazyColumn( //LazyColumn
        contentPadding = PaddingValues(10.dp),
        //cells = GridCells.Fixed(2)
        //verticalArrangement = Arrangement.spacedBy(12.dp)//ponerlo de forma vertical la lista del LazyColumn
        //horizontalArrangement = Arrangement.spacedBy(4.dp) //ponerlo en forma horizontal la lista en el LazyRow

    ){
        items(getMedia()){item ->
            MediaListItem(item)
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun MediaListItem(item: MediaItem) {
    Column(
        modifier = Modifier
            //.width(200.dp)
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .background(color = Color.Red),
            contentAlignment = Alignment.Center
        ) {
            /*AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.thumb)
                    .crossfade(3000)
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)//Darle forma circular a la imagen
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )*/
            Image(
                /*painter = rememberImagePainter(
                    data = item.thumb,
                    /*builder = {
                        transformations(CircleCropTransformation())
                        crossfade(true)
                    }*/
                ),*/
                painter = painterResource(
                    id = R.drawable.kotlin
                    ),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            if(item.type == MediaItem.Type.VIDEO) {
                Icon(
                    imageVector = Icons.Default.PlayCircleOutline,
                    contentDescription = null,
                    modifier = Modifier.size(92.dp),
                    tint = Color.White//Pinta el icono en blanco
                )
            }
            /*Icon(
                painter =   painterResource(
                    id = R.drawable.ic_favorite
                ),
                contentDescription = null
            )*/
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.secondary)
                .padding(16.dp)
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.h4
            )
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}

//@Preview(showBackground = true, widthDp =100, heightDp = 200)
@Composable
fun ButtonText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "Hello",
            color = Color.Blue,//Ponerle de color al texto
            fontSize = 16.sp, //Fuente del texto
            fontStyle = FontStyle.Italic, //Estilo del texto
            fontWeight = FontWeight.ExtraBold, //Distinto niveles del nivel de la fuente
            fontFamily = FontFamily.Monospace,// tipo de letra de la fuente
            letterSpacing = 5.sp, // identifica ciertos espacio de cada una de la letra
            /*
            TextDecoration.LineThrough->tachado de la letra
             */
            textDecoration = TextDecoration.LineThrough,
            textAlign = TextAlign.Justify, //Alinear texto, extendera las letras para ocupar todo el espacio
            maxLines = 2,//Definir la linea del texto
            softWrap = true, //Hace un recorte del texto para que no aparezca ninguna palabra a media
            overflow = TextOverflow.Ellipsis, //Añade 3 puntos al fnal del texto indicando que el texto continua
            style = MaterialTheme.typography.h5.copy(
                shadow = Shadow(//Darle sombra al texto
                    offset = Offset(6f, 6f),//Desplazamiento de la sombra
                    blurRadius = 6f,//Desenfoque la sombra
                    color = Color.Blue.copy(alpha = 0.6f)//darle color a la sombra y su tonalidad
                )
            ),

            modifier = Modifier

                .clickable { /*todo*/ }
                .background(Color.Green)
                .border(width = 2.dp, color = Color.Blue)
                .padding(horizontal = 16.dp, vertical = 8.dp)


        )
    }
}

/*@Preview(
    showBackground = true,
    widthDp = 400,
    heightDp = 200
    )
@Composable
fun DefaultPreview() {
    Jetpack_composeTheme {

        /*Box(
            modifier = Modifier.fillMaxSize(),

                //.background(Color.LightGray),
            contentAlignment = Alignment.Center, //Alinear en el centro
            verticalAlignment = Alignment.CenterVertically

        ) {
            Greeting("Android")

            Greeting(
                "Chrisardo",
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }*/

        Column(
            modifier = Modifier.fillMaxSize(),
            /*
            Arrangement.SpaceEvenly->Coloca los elementos en funcion del espacio de que tienen lo va a repartir
             Arrangement.SpaceBetween -> Evita poner espacio en los bordes
             Arrangement.SpaceAround-> Deja el mismo espacio arriba y abajo de cada uno de los elementos
             */
            verticalArrangement = Arrangement.SpaceAround,
            /*
            Alignment.CenterHorizontally-> Posiciona en horizontal, en el centro de la pantalla
             */
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Greeting(
                "Android",
                modifier = Modifier
                    .background(Color.LightGray)
                    .weight(2f)
            )
            Greeting(
                "Chrisardo",
                modifier = Modifier
                    .background(Color.Yellow)
                    .weight(1f)
            )
        }
    }
}
 */
 