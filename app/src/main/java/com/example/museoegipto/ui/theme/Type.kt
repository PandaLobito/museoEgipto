package com.example.museoegipto.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.museoegipto.R

/**
 * Familias tipográficas del museo.
 * Cinzel se usa en títulos (evoca inscripciones romanas y jeroglíficas talladas).
 * Cinzel Decorative se usa en énfasis y títulos principales.
 */
val FamiliaCinzel = FontFamily(
    Font(R.font.cinzel_regular, FontWeight.Normal),
    Font(R.font.cinzel_bold, FontWeight.Bold)
)

val FamiliaCinzelDecorativa = FontFamily(
    Font(R.font.cinzel_decorative_regular, FontWeight.Normal)
)

/**
 * Tipografía base del museo. Usa Cinzel para títulos decorativos
 * y un cuerpo sans-serif legible para el texto largo.
 */
val TipografiaEgipcia = Typography(
    // Títulos grandes: portada y encabezados principales
    headlineLarge = TextStyle(
        fontFamily = FamiliaCinzelDecorativa,
        fontWeight = FontWeight.Normal,
        fontSize = 34.sp,
        lineHeight = 40.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = FamiliaCinzel,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 30.sp
    ),
    // Títulos de sección y tarjetas
    titleLarge = TextStyle(
        fontFamily = FamiliaCinzel,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FamiliaCinzel,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 24.sp
    ),
    titleSmall = TextStyle(
        fontFamily = FamiliaCinzel,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 20.sp
    ),
    // Cuerpo de texto: legible, sin adornos
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        lineHeight = 24.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 21.sp
    ),
    bodySmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = 18.sp
    )
)