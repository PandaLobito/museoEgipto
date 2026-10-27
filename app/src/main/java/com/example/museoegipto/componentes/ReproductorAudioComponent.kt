package com.example.museoegipto.componentes

import android.media.MediaPlayer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

/**
 * Composable que reproduce un recurso de audio de res/raw.
 * Se libera automáticamente al salir de la composición.
 *
 * @param recursoAudio identificador R.raw del archivo
 * @param enBucle si debe repetirse indefinidamente (ambiente)
 * @param reproducir si debe estar activo en este momento
 */
@Composable
fun ReproductorAudioComponent(
    recursoAudio: Int,
    enBucle: Boolean = false,
    reproducir: Boolean = true
) {
    val contextoActual = LocalContext.current

    val reproductor = remember(recursoAudio) {
        MediaPlayer.create(contextoActual, recursoAudio).apply {
            isLooping = enBucle
        }
    }

    LaunchedEffect(reproducir) {
        if (reproducir) {
            if (!reproductor.isPlaying) reproductor.start()
        } else {
            if (reproductor.isPlaying) reproductor.pause()
        }
    }

    DisposableEffect(reproductor) {
        onDispose {
            if (reproductor.isPlaying) reproductor.stop()
            reproductor.release()
        }
    }
}