package com.example.museoegipto.componentes

import android.speech.tts.TextToSpeech
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import java.util.Locale

/**
 * Composable que utiliza el motor TextToSpeech de Android para leer un texto
 * en voz alta. Sirve como audio descriptivo accesible sin archivos pregrabados.
 * Detiene y libera el motor al salir de la composición.
 */
@Composable
fun NarradorTextoComponent(
    textoALeer: String,
    idioma: Locale = Locale("es", "ES")
) {
    val contextoActual = LocalContext.current

    val motorTextoVoz = remember {
        var motor: TextToSpeech? = null
        motor = TextToSpeech(contextoActual) { estado ->
            if (estado == TextToSpeech.SUCCESS) {
                motor?.language = idioma
            }
        }
        motor
    }

    LaunchedEffect(textoALeer) {
        if (textoALeer.isNotBlank()) {
            motorTextoVoz?.speak(textoALeer, TextToSpeech.QUEUE_FLUSH, null, "narracion_museo")
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            motorTextoVoz?.stop()
            motorTextoVoz?.shutdown()
        }
    }
}