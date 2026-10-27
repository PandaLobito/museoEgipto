package com.example.museoegipto.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

/**
 * Lista de videos documentales de la sección. Cada título actúa como selector
 * y el reproductor se muestra debajo del video seleccionado.
 */
@Composable
fun ListaVideosComponent(
    urlsVideos: List<String>,
    titulosVideos: List<String>
) {
    var indiceSeleccionado by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Videos documentales (${urlsVideos.size})",
            style = MaterialTheme.typography.titleMedium
        )

        // Reproductor del video seleccionado
        ReproductorVideoComponent(urlVideo = urlsVideos[indiceSeleccionado])

        // Lista de títulos como selector de video
        urlsVideos.forEachIndexed { indice, _ ->
            val titulo = titulosVideos.getOrNull(indice) ?: "Video ${indice + 1}"
            val esSeleccionado = indice == indiceSeleccionado

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentDescription = "Reproducir $titulo"
                    },
                elevation = CardDefaults.cardElevation(
                    defaultElevation = if (esSeleccionado) 6.dp else 1.dp
                ),
                onClick = { indiceSeleccionado = indice }
            ) {
                Text(
                    text = if (esSeleccionado) "▶ $titulo" else "   $titulo",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}