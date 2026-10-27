package com.example.museoegipto.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.museoegipto.modelo.NivelAudienciaModel

/**
 * Selector horizontal de nivel de audiencia, con descripción accesible
 * en cada opción para lectores de pantalla.
 */
@Composable
fun SelectorAudienciaComponent(
    nivelSeleccionado: NivelAudienciaModel,
    alSeleccionarNivel: (NivelAudienciaModel) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        NivelAudienciaModel.entries.forEach { nivel ->
            FilterChip(
                selected = nivel == nivelSeleccionado,
                onClick = { alSeleccionarNivel(nivel) },
                label = { Text(nivel.etiqueta) },
                colors = FilterChipDefaults.filterChipColors(),
                modifier = Modifier.semantics {
                    contentDescription = "Nivel de audiencia ${nivel.etiqueta}"
                }
            )
        }
    }
}
