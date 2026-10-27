package com.example.museoegipto.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

/**
 * Galería horizontal de imágenes con audio descriptivo por imagen.
 * Cada imagen tiene dos alternativas: toque para zoom y botón para narración.
 */

@Composable
fun GaleriaImagenesComponent(
    imagenes: List<String>,
    textosAlternativos: List<String>,
    alSeleccionarImagen: (indice: Int, textoDescriptivo: String) -> Unit,
    alSolicitarNarracion: (textoDescriptivo: String) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Galería de imágenes (${imagenes.size})",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 4.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            itemsIndexed(imagenes) { indice, urlImagen ->
                val textoAlt = textosAlternativos.getOrNull(indice)
                    ?: "Imagen ${indice + 1} de la galería"

                Box(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .width(160.dp)
                        .height(120.dp)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(urlImagen),
                        contentDescription = textoAlt,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(160.dp)
                            .height(120.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .semantics {
                                contentDescription =
                                    "$textoAlt. Toca para ver en grande o usa el botón de audio."
                            }
                            .clickable { alSeleccionarImagen(indice, textoAlt) }
                    )

                    // Botón de audio descriptivo accesible (alternativa al toque)
                    Surface(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(4.dp),
                        tonalElevation = 4.dp,
                        shape = RoundedCornerShape(50)
                    ) {
                        IconButton(
                            onClick = { alSolicitarNarracion(textoAlt) },
                            modifier = Modifier.semantics {
                                contentDescription =
                                    "Escuchar descripción de la imagen ${indice + 1}"
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.VolumeUp,
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
    }
}