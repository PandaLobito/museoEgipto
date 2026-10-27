package com.example.museoegipto.componentes

import android.net.Uri
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

/**
 * Reproductor de video basado en ExoPlayer
 * Se recrea automáticamente cuando cambia la URL para evitar
 * que el reproductor quede apuntando al video anterior
 * Se libera automáticamente al salir de la composición
 */
@Composable
fun ReproductorVideoComponent(urlVideo: String) {
    val contextoActual = LocalContext.current

    // Al cambiar la URL, remember se vuelve a ejecutar
    // y se crea un ExoPlayer nuevo con el nuevo MediaItem
    val reproductor = remember(urlVideo) {
        ExoPlayer.Builder(contextoActual).build().apply {
            setMediaItem(MediaItem.fromUri(Uri.parse(urlVideo)))
            prepare()
            playWhenReady = false
        }
    }

    // Liberamos el reproductor cuando cambia la URL o al salir de la composición
    // La clave "reproductor" garantiza que se libere el anterior al recrearse.
    DisposableEffect(reproductor) {
        onDispose { reproductor.release() }
    }

    AndroidView(
        factory = { contexto ->
            PlayerView(contexto).apply {
                player = reproductor
                useController = true
            }
        },
        update = { vistaJugador ->
            // Nos aseguramos de que la vista apunte siempre al reproductor actual
            vistaJugador.player = reproductor
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
    )
}