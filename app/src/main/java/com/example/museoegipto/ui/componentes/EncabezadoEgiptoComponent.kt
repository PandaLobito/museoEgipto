package com.example.museoegipto.ui.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.museoegipto.R
import com.example.museoegipto.ui.theme.PaletaEgipcia

/**
 * Encabezado decorativo con degradado dorado, íconos egipcios laterales
 * y título con tipografía Cinzel Decorative.
 */
@Composable
fun EncabezadoEgiptoComponent(
    titulo: String,
    subtitulo: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        PaletaEgipcia.DoradoOscuro,
                        PaletaEgipcia.Dorado,
                        PaletaEgipcia.DoradoClaro,
                        PaletaEgipcia.Dorado,
                        PaletaEgipcia.DoradoOscuro
                    )
                ),
                shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)
            )
            .padding(horizontal = 16.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_ankh),
                contentDescription = null,
                tint = PaletaEgipcia.Lapislazuli,
                modifier = Modifier.size(28.dp)
            )
            Text(
                text = "  $titulo  ",
                style = MaterialTheme.typography.headlineSmall,
                color = PaletaEgipcia.LapislazuliOscuro,
                textAlign = TextAlign.Center
            )
            Icon(
                painter = painterResource(R.drawable.ic_ojo_horus),
                contentDescription = null,
                tint = PaletaEgipcia.Lapislazuli,
                modifier = Modifier.size(28.dp)
            )
        }
        Text(
            text = subtitulo,
            style = MaterialTheme.typography.bodyMedium,
            color = PaletaEgipcia.LapislazuliOscuro
        )
    }
}