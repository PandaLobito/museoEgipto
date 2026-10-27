package com.example.museoegipto.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.museoegipto.componentes.PanelAccesibilidadComponent
import com.example.museoegipto.componentes.TarjetaSeccionComponent
import com.example.museoegipto.datos.RepositorioContenido
import com.example.museoegipto.estado.EstadoAccesibilidad
import com.example.museoegipto.ui.componentes.EncabezadoEgiptoComponent
import com.example.museoegipto.ui.componentes.FondoPapiroComponent
import com.example.museoegipto.ui.theme.PaletaEgipcia

/**
 * Pantalla principal del museo, rediseñada con atmósfera egipcia:
 * fondo papiro, encabezado dorado y tarjetas con marco decorativo.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaInicio(
    estadoAccesibilidad: EstadoAccesibilidad,
    alCambiarAccesibilidad: (EstadoAccesibilidad) -> Unit,
    alSeleccionarSeccion: (String) -> Unit
) {
    var mostrarPanelAccesibilidad by remember { mutableStateOf(false) }
    val estadoHoja = rememberModalBottomSheetState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Museo del Antiguo Egipto",
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PaletaEgipcia.LapislazuliOscuro,
                    titleContentColor = PaletaEgipcia.DoradoClaro
                ),
                actions = {
                    IconButton(
                        onClick = { mostrarPanelAccesibilidad = true },
                        modifier = Modifier.semantics {
                            contentDescription = "Abrir opciones de accesibilidad"
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = null,
                            tint = PaletaEgipcia.DoradoClaro
                        )
                    }
                }
            )
        }
    ) { rellenoInterno ->
        FondoPapiroComponent(modifier = Modifier.padding(rellenoInterno)) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    EncabezadoEgiptoComponent(
                        titulo = "Explora el Nilo",
                        subtitulo = "Un viaje interactivo por el Antiguo Egipto"
                    )
                }

                item {
                    Text(
                        text = "Secciones temáticas",
                        style = MaterialTheme.typography.titleLarge,
                        color = PaletaEgipcia.LapislazuliOscuro,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    )
                }

                items(RepositorioContenido.obtenerSecciones()) { seccion ->
                    TarjetaSeccionComponent(
                        seccion = seccion,
                        alAbrirSeccion = { alSeleccionarSeccion(seccion.identificador) },
                        alPulsacionLarga = { /* Reservado */ }
                    )
                }
            }
        }
    }

    if (mostrarPanelAccesibilidad) {
        ModalBottomSheet(
            onDismissRequest = { mostrarPanelAccesibilidad = false },
            sheetState = estadoHoja
        ) {
            PanelAccesibilidadComponent(
                estadoAccesibilidad = estadoAccesibilidad,
                alCambiarAccesibilidad = alCambiarAccesibilidad,
                alReproducirNarracion = { }
            )
        }
    }
}