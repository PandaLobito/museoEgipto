package com.example.museoegipto.modelo

/**
 * Modelo que representa una sección temática del museo.
 * Contiene listas de artículos, imágenes, audios y videos para
 * ofrecer una experiencia multimedia completa.
 */
data class SeccionTematicaModel(
    val identificador: String,
    val titulo: String,
    val descripcion: String,
    val urlImagenPortada: String,
    val textoAlternativoPortada: String,
    val listaArticulos: List<ArticuloModel>,
    val galeriaImagenes: List<String>,
    val galeriaTextosAlternativos: List<String>,
    val listaAudiosAmbiente: List<Int>,
    val listaAudiosMusica: List<Int>,
    val listaVideos: List<String>,
    val titulosVideos: List<String>
)

/**
 * Niveles de audiencia para adaptar el contenido educativo.
 */
enum class NivelAudienciaModel(val etiqueta: String) {
    NINOS("Niños"),
    ADOLESCENTES("Adolescentes"),
    ADULTOS("Adultos")
}

/**
 * Extensión que devuelve el texto del artículo según el nivel de audiencia.
 */
fun ArticuloModel.obtenerTextoPorNivel(nivel: NivelAudienciaModel): String = when (nivel) {
    NivelAudienciaModel.NINOS -> textoNinos
    NivelAudienciaModel.ADOLESCENTES -> textoAdolescentes
    NivelAudienciaModel.ADULTOS -> textoAdultos
}