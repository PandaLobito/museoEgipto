package com.example.museoegipto.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.museoegipto.componentes.BotonNarracionComponent
import com.example.museoegipto.componentes.CarruselArticulosComponent
import com.example.museoegipto.componentes.GaleriaImagenesComponent
import com.example.museoegipto.componentes.ListaVideosComponent
import com.example.museoegipto.componentes.NarradorTextoComponent
import com.example.museoegipto.componentes.ReproductorAudioComponent
import com.example.museoegipto.componentes.SelectorAudienciaComponent
import com.example.museoegipto.componentes.VisorImagenConZoomComponent
import com.example.museoegipto.datos.RepositorioContenido
import com.example.museoegipto.estado.EstadoAccesibilidad
import com.example.museoegipto.modelo.NivelAudienciaModel
import com.example.museoegipto.modelo.obtenerTextoPorNivel
import com.example.museoegipto.ui.componentes.FondoPapiroComponent
import com.example.museoegipto.ui.theme.PaletaEgipcia


/**
 * Pantalla de detalle de una sección temática con gestos ampliados,
 * alternativas accesibles y audio descriptivo por imagen.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaDetalleSeccion(
    identificadorSeccion: String,
    estadoAccesibilidad: EstadoAccesibilidad,
    alRegresar: () -> Unit
) {
    val seccion = RepositorioContenido.obtenerSeccionPorId(identificadorSeccion)

    if (seccion == null) {
        Text(text = "Sección no encontrada")
        return
    }

    // --------------------------- Estados ---------------------------------------------------
    var nivelSeleccionado by remember { mutableStateOf(NivelAudienciaModel.ADULTOS) }
    var narracionActiva by remember { mutableStateOf(false) }
    var textoNarracion by remember { mutableStateOf("") }

    // Índice de la imagen que se muestra en el visor con zoom (-1 = ninguna)
    var indiceImagenVisor by remember { mutableIntStateOf(-1) }
    var descripcionParaLeer by remember { mutableStateOf("") }

    // Audio ambiental en loop; se pausa mientras hay narración activa
    ReproductorAudioComponent(
        recursoAudio = seccion.listaAudiosAmbiente.first(),
        enBucle = true,
        reproducir = !narracionActiva && descripcionParaLeer.isEmpty()
    )

    // Narración del artículo o de la sección completa
    if (narracionActiva && textoNarracion.isNotBlank()) {
        NarradorTextoComponent(textoALeer = textoNarracion)
    }

    // Narración de la descripción de una imagen
    if (descripcionParaLeer.isNotBlank()) {
        NarradorTextoComponent(textoALeer = descripcionParaLeer)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(seccion.titulo) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PaletaEgipcia.LapislazuliOscuro,
                    titleContentColor = PaletaEgipcia.DoradoClaro,
                    navigationIconContentColor = PaletaEgipcia.DoradoClaro
                ),
                navigationIcon = {
                    IconButton(
                        onClick = alRegresar,
                        modifier = Modifier.semantics {
                            contentDescription = "Regresar a la pantalla anterior"
                        }
                    ) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { rellenoInterno ->
        FondoPapiroComponent(modifier = Modifier.padding(rellenoInterno)) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(rellenoInterno)
                    .background(
                        Brush.verticalGradient(
                            listOf(Color(0xFFFFF8E1), Color(0xFFD7B377))
                        )
                    )
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // -------------------------- Portada con visor de zoom -------------------------------------
                Text(
                    text = "Portada de la sección",
                    style = MaterialTheme.typography.titleSmall
                )
                VisorImagenConZoomComponent(
                    urlImagen = seccion.urlImagenPortada,
                    textoAlternativo = seccion.textoAlternativoPortada,
                    alSolicitarNarracion = { descripcionParaLeer = seccion.textoAlternativoPortada }
                )

                Text(
                    text = seccion.descripcion,
                    style = MaterialTheme.typography.bodyLarge
                )

                // ------- Selector de audiencia ----------------------
                Text(
                    text = "Adapta el contenido:",
                    style = MaterialTheme.typography.titleSmall
                )
                SelectorAudienciaComponent(
                    nivelSeleccionado = nivelSeleccionado,
                    alSeleccionarNivel = { nivelSeleccionado = it }
                )

                // ---------------- Narración global de la sección ---------------------------
                BotonNarracionComponent(
                    reproduciendo = narracionActiva,
                    alAlternar = {
                        if (!narracionActiva) {
                            textoNarracion = buildString {
                                append(seccion.titulo).append(". ")
                                append(seccion.descripcion).append(" ")
                                seccion.listaArticulos.forEach { articulo ->
                                    append(articulo.titulo).append(". ")
                                    append(articulo.obtenerTextoPorNivel(nivelSeleccionado)).append(
                                        " "
                                    )
                                }
                            }
                        }
                        narracionActiva = !narracionActiva
                    }
                )

                // -------------- Carrusel de artículos con swipe --------------------------
                CarruselArticulosComponent(
                    listaArticulos = seccion.listaArticulos,
                    nivelAudiencia = nivelSeleccionado,
                    alReproducirNarracion = { articulo ->
                        textoNarracion = articulo.obtenerTextoPorNivel(nivelSeleccionado)
                        narracionActiva = true
                    }
                )

                // ----------------------- Visor de imagen seleccionada de la galería ---------------
                if (indiceImagenVisor in seccion.galeriaImagenes.indices) {
                    val indice = indiceImagenVisor
                    val textoAlt = seccion.galeriaTextosAlternativos.getOrNull(indice)
                        ?: "Imagen ${indice + 1}"

                    Column {
                        Text(
                            text = "Imagen ampliada (${indice + 1}/${seccion.galeriaImagenes.size})",
                            style = MaterialTheme.typography.titleSmall
                        )
                        VisorImagenConZoomComponent(
                            urlImagen = seccion.galeriaImagenes[indice],
                            textoAlternativo = textoAlt,
                            alSolicitarNarracion = { descripcionParaLeer = textoAlt }
                        )
                        IconButton(
                            onClick = { indiceImagenVisor = -1 },
                            modifier = Modifier.semantics {
                                contentDescription = "Cerrar visor de imagen"
                            }
                        ) {
                            Text("Cerrar visor", style = MaterialTheme.typography.bodySmall)
                            Icon(Icons.Filled.VolumeUp, contentDescription = null)
                        }
                    }
                }

                // --------------------------- Galería de imágenes -----------------------------------
                GaleriaImagenesComponent(
                    imagenes = seccion.galeriaImagenes,
                    textosAlternativos = seccion.galeriaTextosAlternativos,
                    alSeleccionarImagen = { indice, _ -> indiceImagenVisor = indice },
                    alSolicitarNarracion = { texto -> descripcionParaLeer = texto }
                )

                // ------------------ Videos documentales ---------------------------
                ListaVideosComponent(
                    urlsVideos = seccion.listaVideos,
                    titulosVideos = seccion.titulosVideos
                )

                // ----------------------- Indicador de accesibilidad ---------------------------------------
                if (estadoAccesibilidad.audioDescriptivoActivo) {
                    Text(
                        text = "🔊 Audio descriptivo activo. Toca el botón de bocina en cualquier imagen para escuchar su descripción.",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}