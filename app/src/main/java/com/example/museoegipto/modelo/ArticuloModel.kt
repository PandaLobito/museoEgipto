package com.example.museoegipto.modelo

/**
 * Modelo que representa un artículo educativo dentro de una sección temática.
 * Cada artículo incluye su propio contenido adaptado por edad, una imagen
 * representativa y un texto alternativo para audio descriptivo accesible.
 */
data class ArticuloModel(
    val identificador: String,
    val titulo: String,
    val textoNinos: String,
    val textoAdolescentes: String,
    val textoAdultos: String,
    val urlImagen: String,
    val textoAlternativo: String,
    val recursoNarracion: Int
)
