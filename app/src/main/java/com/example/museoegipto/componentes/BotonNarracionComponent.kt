package com.example.museoegipto.componentes

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VolumeOff
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

/**
 * Botón alternativo accesible (no gestual) para activar o detener
 * la narración de la sección completa.
 */
@Composable
fun BotonNarracionComponent(
    reproduciendo: Boolean,
    alAlternar: () -> Unit
) {
    Button(
        onClick = alAlternar,
        modifier = Modifier
            .fillMaxWidth()
            .semantics {
                contentDescription = if (reproduciendo)
                    "Detener narración de la sección" else "Escuchar narración de la sección"
            }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = if (reproduciendo) Icons.Filled.VolumeOff
                else Icons.Filled.VolumeUp,
                contentDescription = null
            )
            Text(
                text = if (reproduciendo) " Detener narración" else " Escuchar narración",
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}