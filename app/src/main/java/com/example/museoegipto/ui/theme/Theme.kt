package com.example.museoegipto.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * Esquema de color claro del museo, basado en la paleta egipcia.
 */
private val EsquemaClaro = lightColorScheme(
    primary = PaletaEgipcia.Dorado,
    onPrimary = PaletaEgipcia.TintaNegra,
    primaryContainer = PaletaEgipcia.DoradoClaro,
    onPrimaryContainer = PaletaEgipcia.TintaNegra,
    secondary = PaletaEgipcia.Lapislazuli,
    onSecondary = PaletaEgipcia.TextoClaro,
    secondaryContainer = PaletaEgipcia.LapislazuliClaro,
    onSecondaryContainer = PaletaEgipcia.TextoClaro,
    tertiary = PaletaEgipcia.Terracota,
    onTertiary = PaletaEgipcia.TextoClaro,
    background = PaletaEgipcia.ArenaClara,
    onBackground = PaletaEgipcia.TintaNegra,
    surface = PaletaEgipcia.Arena,
    onSurface = PaletaEgipcia.TintaNegra,
    surfaceVariant = PaletaEgipcia.ArenaOscura,
    onSurfaceVariant = PaletaEgipcia.TintaNegra,
    outline = PaletaEgipcia.DoradoOscuro
)

/**
 * Esquema de alto contraste: fondo negro, textos amarillos,
 * botones dorados brillantes. Cumple WCAG AAA.
 */
private val EsquemaAltoContraste = darkColorScheme(
    primary = Color(0xFFFFD700),
    onPrimary = Color.Black,
    primaryContainer = Color(0xFFFFA500),
    onPrimaryContainer = Color.Black,
    secondary = Color(0xFF00BFFF),
    onSecondary = Color.Black,
    tertiary = Color(0xFFFF6347),
    onTertiary = Color.Black,
    background = Color.Black,
    onBackground = Color.Yellow,
    surface = Color(0xFF1A1A1A),
    onSurface = Color.Yellow,
    surfaceVariant = Color(0xFF2A2A2A),
    onSurfaceVariant = Color.Yellow,
    outline = Color.Yellow
)

/**
 * Tema global del museo. Aplica escala de texto, alto contraste
 * y la tipografía temática Cinzel en títulos.
 */
@Composable
fun MuseoEgiptoTheme(
    escalaTexto: Float,
    altoContraste: Boolean,
    contenido: @Composable () -> Unit
) {
    val esquema = if (altoContraste) EsquemaAltoContraste else EsquemaClaro
    val base = TipografiaEgipcia

    // Escala todas las variantes tipográficas según la preferencia del usuario
    val tipografiaEscalada = Typography(
        headlineLarge = base.headlineLarge.copy(fontSize = base.headlineLarge.fontSize * escalaTexto),
        headlineSmall = base.headlineSmall.copy(fontSize = base.headlineSmall.fontSize * escalaTexto),
        titleLarge = base.titleLarge.copy(fontSize = base.titleLarge.fontSize * escalaTexto),
        titleMedium = base.titleMedium.copy(fontSize = base.titleMedium.fontSize * escalaTexto),
        titleSmall = base.titleSmall.copy(fontSize = base.titleSmall.fontSize * escalaTexto),
        bodyLarge = base.bodyLarge.copy(fontSize = base.bodyLarge.fontSize * escalaTexto),
        bodyMedium = base.bodyMedium.copy(fontSize = base.bodyMedium.fontSize * escalaTexto),
        bodySmall = base.bodySmall.copy(fontSize = base.bodySmall.fontSize * escalaTexto)
    )

    MaterialTheme(
        colorScheme = esquema,
        typography = tipografiaEscalada,
        content = contenido
    )
}