package com.example.museoegipto.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

/**
 * Visor de imagen con zoom por pellizco, desplazamiento por arrastre
 * y doble toque para reproducir audio descriptivo.
 * Incluye botones +/− y de audio como alternativas accesibles.
 */
@Composable
fun VisorImagenConZoomComponent(
    urlImagen: String,
    textoAlternativo: String,
    alSolicitarNarracion: () -> Unit
) {
    var escala by remember { mutableFloatStateOf(1f) }
    var desplazamientoX by remember { mutableFloatStateOf(0f) }
    var desplazamientoY by remember { mutableFloatStateOf(0f) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
            .semantics {
                contentDescription =
                    "$textoAlternativo. Pellizca para hacer zoom o usa los botones. Doble toque para escuchar la descripción."
            }
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, zoom, _ ->
                    escala = (escala * zoom).coerceIn(1f, 4f)
                    if (escala > 1f) {
                        desplazamientoX += pan.x
                        desplazamientoY += pan.y
                    } else {
                        desplazamientoX = 0f
                        desplazamientoY = 0f
                    }
                }
            }
            .pointerInput(Unit) {
                detectTapGestures(
                    onDoubleTap = { alSolicitarNarracion() }
                )
            }
    ) {
        Image(
            painter = rememberAsyncImagePainter(urlImagen),
            contentDescription = textoAlternativo,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp)
                .graphicsLayer(
                    scaleX = escala,
                    scaleY = escala,
                    translationX = desplazamientoX,
                    translationY = desplazamientoY
                )
        )

        // Controles accesibles alternativos a los gestos
        Surface(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(8.dp),
            tonalElevation = 4.dp
        ) {
            Row {
                IconButton(
                    onClick = { escala = (escala + 0.5f).coerceAtMost(4f) },
                    modifier = Modifier.semantics {
                        contentDescription = "Acercar imagen"
                    }
                ) {
                    Icon(Icons.Filled.Add, contentDescription = null)
                }
                IconButton(
                    onClick = {
                        escala = (escala - 0.5f).coerceAtLeast(1f)
                        if (escala == 1f) {
                            desplazamientoX = 0f
                            desplazamientoY = 0f
                        }
                    },
                    modifier = Modifier.semantics {
                        contentDescription = "Alejar imagen"
                    }
                ) {
                    Icon(Icons.Filled.Remove, contentDescription = null)
                }
                IconButton(
                    onClick = alSolicitarNarracion,
                    modifier = Modifier.semantics {
                        contentDescription = "Escuchar descripción de la imagen"
                    }
                ) {
                    Icon(Icons.Filled.VolumeUp, contentDescription = null)
                }
            }
        }
    }
}