package com.example.museoegipto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.museoegipto.estado.EstadoAccesibilidad
import com.example.museoegipto.pantallas.PantallaDetalleSeccion
import com.example.museoegipto.pantallas.PantallaInicio
import com.example.museoegipto.ui.theme.MuseoEgiptoTheme

/**
 * Actividad principal que aloja toda la aplicación del museo.
 * Configura la navegación entre la pantalla de inicio y el detalle de cada sección temática.
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Estado global de accesibilidad compartido por todas las pantallas
            var estadoAccesibilidad by remember { mutableStateOf(EstadoAccesibilidad()) }

            MuseoEgiptoTheme(
                escalaTexto = estadoAccesibilidad.escalaTexto,
                altoContraste = estadoAccesibilidad.altoContraste
            ) {
                Surface(
                    modifier = Modifier,
                    color = MaterialTheme.colorScheme.background
                ) {
                    AplicacionMuseo(
                        estadoAccesibilidad = estadoAccesibilidad,
                        alCambiarAccesibilidad = { estadoAccesibilidad = it }
                    )
                }
            }
        }
    }
}

/**
 * Composable raíz que define el grafo de navegación de la aplicación.
 */
@Composable
fun AplicacionMuseo(
    estadoAccesibilidad: EstadoAccesibilidad,
    alCambiarAccesibilidad: (EstadoAccesibilidad) -> Unit
) {
    val controladorNavegacion = rememberNavController()

    NavHost(
        navController = controladorNavegacion,
        startDestination = "inicio"
    ) {
        // Pantalla principal con las secciones temáticas del museo
        composable("inicio") {
            PantallaInicio(
                estadoAccesibilidad = estadoAccesibilidad,
                alCambiarAccesibilidad = alCambiarAccesibilidad,
                alSeleccionarSeccion = { identificadorSeccion ->
                    controladorNavegacion.navigate("detalle/$identificadorSeccion")
                }
            )
        }

        // Pantalla de detalle que muestra el contenido multimedia de la sección elegida
        composable("detalle/{idSeccion}") { entradaNavegacion ->
            val idSeccion = entradaNavegacion.arguments?.getString("idSeccion") ?: ""
            PantallaDetalleSeccion(
                identificadorSeccion = idSeccion,
                estadoAccesibilidad = estadoAccesibilidad,
                alRegresar = { controladorNavegacion.popBackStack() }
            )
        }
    }
}