package com.example.museoegipto.ui.componentes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import com.example.museoegipto.ui.theme.PaletaEgipcia

/**
 * Fondo decorativo que combina un degradado vertical con un patrón sutil
 * de puntos dorados que evocan la textura del papiro y la arena del desierto.
 */
@Composable
fun FondoPapiroComponent(
    modifier: Modifier = Modifier,
    contenido: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        PaletaEgipcia.ArenaClara,
                        PaletaEgipcia.Arena,
                        PaletaEgipcia.ArenaOscura
                    )
                )
            )
    ) {
        // Patrón decorativo de puntos en opacidad muy baja
        Canvas(modifier = Modifier.fillMaxSize()) {
            dibujarPatronPapiro(color = PaletaEgipcia.DoradoOscuro.copy(alpha = 0.06f))
        }
        contenido()
    }
}

/**
 * Dibuja puntos distribuidos regularmente sobre el lienzo
 * para simular el grano del papiro o la arena.
 */
private fun DrawScope.dibujarPatronPapiro(color: Color) {
    val separacion = 32.dp.toPx()
    var posicionY = 0f
    while (posicionY < size.height) {
        var posicionX = 0f
        while (posicionX < size.width) {
            drawCircle(
                color = color,
                radius = 2.dp.toPx(),
                center = Offset(posicionX, posicionY)
            )
            posicionX += separacion
        }
        posicionY += separacion
    }
}