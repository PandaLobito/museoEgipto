package com.example.museoegipto.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.museoegipto.modelo.ArticuloModel
import com.example.museoegipto.modelo.NivelAudienciaModel
import kotlinx.coroutines.launch

/**
 * Carrusel de artículos con desplazamiento horizontal por gesto (swipe)
 * y botones "Anterior"/"Siguiente" como alternativa accesible.
 * Muestra indicador "Artículo X de N" para orientación.
 */
@Composable
fun CarruselArticulosComponent(
    listaArticulos: List<ArticuloModel>,
    nivelAudiencia: NivelAudienciaModel,
    alReproducirNarracion: (ArticuloModel) -> Unit
) {
    if (listaArticulos.isEmpty()) return

    val estadoPaginador = rememberPagerState(pageCount = { listaArticulos.size })
    val alcanceCorrutina = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Artículos (${listaArticulos.size})",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Carrusel con gesto de swipe
        HorizontalPager(
            state = estadoPaginador,
            modifier = Modifier
                .fillMaxWidth()
                .semantics {
                    contentDescription =
                        "Carrusel de artículos. Desliza horizontalmente para navegar."
                }
        ) { pagina ->
            val articuloActual = listaArticulos[pagina]
            TarjetaArticuloComponent(
                articulo = articuloActual,
                nivelAudiencia = nivelAudiencia,
                alReproducirNarracion = { alReproducirNarracion(articuloActual) }
            )
        }

        Text(
            text = "Artículo ${estadoPaginador.currentPage + 1} de ${listaArticulos.size}",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 4.dp)
        )

        // Botones alternativos accesibles (no dependen del gesto)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    alcanceCorrutina.launch {
                        val destino = (estadoPaginador.currentPage - 1)
                            .coerceAtLeast(0)
                        estadoPaginador.animateScrollToPage(destino)
                    }
                },
                enabled = estadoPaginador.currentPage > 0,
                modifier = Modifier.semantics {
                    contentDescription = "Ir al artículo anterior"
                }
            ) {
                Text("◀ Anterior")
            }

            Button(
                onClick = {
                    alcanceCorrutina.launch {
                        val destino = (estadoPaginador.currentPage + 1)
                            .coerceAtMost(listaArticulos.size - 1)
                        estadoPaginador.animateScrollToPage(destino)
                    }
                },
                enabled = estadoPaginador.currentPage < listaArticulos.size - 1,
                modifier = Modifier.semantics {
                    contentDescription = "Ir al artículo siguiente"
                }
            ) {
                Text("Siguiente ▶")
            }
        }
    }
}