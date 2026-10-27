package com.example.museoegipto.estado

/**
 * Estado global de las preferencias de accesibilidad del usuario.
 * Se comparte entre pantallas mediante elevación de estado.
 */
data class EstadoAccesibilidad(
    val escalaTexto: Float = 1f,
    val altoContraste: Boolean = false,
    val audioDescriptivoActivo: Boolean = false
)