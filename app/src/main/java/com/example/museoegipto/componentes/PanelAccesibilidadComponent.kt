package com.example.museoegipto.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.museoegipto.estado.EstadoAccesibilidad


/**
 * Panel de opciones de accesibilidad: tamaño de texto, alto contraste
 * y activación de audio descriptivo.
 */
@Composable
fun PanelAccesibilidadComponent(
    estadoAccesibilidad: EstadoAccesibilidad,
    alCambiarAccesibilidad: (EstadoAccesibilidad) -> Unit,
    alReproducirNarracion: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Opciones de accesibilidad",
            style = MaterialTheme.typography.titleMedium
        )

        // Control para modificar la escala del texto
        Text(text = "Tamaño de texto: ${"%.1f".format(estadoAccesibilidad.escalaTexto)}x")
        Slider(
            value = estadoAccesibilidad.escalaTexto,
            onValueChange = { nuevoValor ->
                alCambiarAccesibilidad(estadoAccesibilidad.copy(escalaTexto = nuevoValor))
            },
            valueRange = 0.8f..1.8f,
            modifier = Modifier.semantics {
                contentDescription = "Ajustar tamaño del texto"
            }
        )

        // Interruptor de alto contraste
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Alto contraste")
            Switch(
                checked = estadoAccesibilidad.altoContraste,
                onCheckedChange = { activado ->
                    alCambiarAccesibilidad(estadoAccesibilidad.copy(altoContraste = activado))
                },
                modifier = Modifier.semantics {
                    contentDescription = "Activar modo de alto contraste"
                }
            )
        }

        // Interruptor de audio descriptivo
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Audio descriptivo")
            Switch(
                checked = estadoAccesibilidad.audioDescriptivoActivo,
                onCheckedChange = { activado ->
                    alCambiarAccesibilidad(
                        estadoAccesibilidad.copy(audioDescriptivoActivo = activado)
                    )
                },
                modifier = Modifier.semantics {
                    contentDescription =
                        "Activar audio descriptivo para personas con discapacidad visual"
                }
            )
        }

        // Botón alternativo accesible (no solo por gesto) para reproducir narración
        IconButton(
            onClick = alReproducirNarracion,
            modifier = Modifier.semantics {
                contentDescription = "Reproducir narración en audio"
            }
        ) {
            Icon(
                imageVector = Icons.Filled.VolumeUp,
                contentDescription = null
            )
        }
    }
}