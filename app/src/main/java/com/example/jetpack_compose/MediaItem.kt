package com.example.jetpack_compose

data class MediaItem(
    var id: Int,
    var title: String,
    var thumb: String, //Cargar url de la imagen
    var type: Type
){
    enum class Type{ PHOTO, VIDEO}
}

fun getMedia() = (1..10).map {
    MediaItem(
        id= it,
        title = "Title $it",
        thumb = "https://lorempixel.com/400/400/people/$it/",
        type = if(it % 3 == 0) MediaItem.Type.VIDEO else MediaItem.Type.PHOTO
    )
}