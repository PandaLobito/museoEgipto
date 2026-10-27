package com.example.museoegipto.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.museoegipto.modelo.ArticuloModel
import com.example.museoegipto.modelo.NivelAudienciaModel
import com.example.museoegipto.modelo.obtenerTextoPorNivel

/**
 * Tarjeta que muestra un artículo educativo con su imagen, texto adaptado
 * al nivel de audiencia y botón para reproducir su narración.
 */
@Composable
fun TarjetaArticuloComponent(
    articulo: ArticuloModel,
    nivelAudiencia: NivelAudienciaModel,
    alReproducirNarracion: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .semantics {
                contentDescription = "${articulo.titulo}. ${articulo.textoAlternativo}"
            },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            Image(
                painter = rememberAsyncImagePainter(articulo.urlImagen),
                contentDescription = articulo.textoAlternativo,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = articulo.titulo,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(
                        onClick = alReproducirNarracion,
                        modifier = Modifier.semantics {
                            contentDescription =
                                "Reproducir narración del artículo ${articulo.titulo}"
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.VolumeUp,
                            contentDescription = null
                        )
                    }
                }

                Text(
                    text = articulo.obtenerTextoPorNivel(nivelAudiencia),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}