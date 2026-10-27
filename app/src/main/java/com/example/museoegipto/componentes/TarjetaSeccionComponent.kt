package com.example.museoegipto.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.museoegipto.modelo.SeccionTematicaModel
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import com.example.museoegipto.R
import com.example.museoegipto.ui.theme.PaletaEgipcia



/**
 * Tarjeta de sección temática con marco dorado decorativo, ícono de escarabajo
 * y degradado para legibilidad del texto.
 */
@Composable
fun TarjetaSeccionComponent(
    seccion: SeccionTematicaModel,
    alAbrirSeccion: () -> Unit,
    alPulsacionLarga: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.6f)
            .border(
                width = 2.dp,
                brush = Brush.linearGradient(
                    listOf(PaletaEgipcia.Dorado, PaletaEgipcia.DoradoOscuro)
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .semantics {
                contentDescription =
                    "${seccion.titulo}. ${seccion.descripcion}. Doble toque para abrir"
            }
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { alAbrirSeccion() },
                    onLongPress = { alPulsacionLarga() }
                )
            },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = rememberAsyncImagePainter(seccion.urlImagenPortada),
                contentDescription = seccion.textoAlternativoPortada,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // Degradado oscuro para legibilidad
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                PaletaEgipcia.LapislazuliOscuro.copy(alpha = 0.85f)
                            )
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_escarabajo),
                    contentDescription = null,
                    tint = PaletaEgipcia.DoradoClaro,
                   modifier = Modifier.size(28.dp)
                )
                Text(
                    text = seccion.titulo,
                    color = PaletaEgipcia.DoradoClaro,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = seccion.descripcion,
                    color = PaletaEgipcia.TextoClaro.copy(alpha = 0.9f),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

