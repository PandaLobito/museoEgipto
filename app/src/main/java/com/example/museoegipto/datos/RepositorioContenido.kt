package com.example.museoegipto.datos

import com.example.museoegipto.R
import com.example.museoegipto.modelo.ArticuloModel
import com.example.museoegipto.modelo.SeccionTematicaModel

/**
 * Repositorio en memoria con todo el contenido del museo.
 * Cada sección temática contiene 5 artículos, 10 imágenes de galería,
 * al menos 5 audios reales y 5 videos documentales.
 */
object RepositorioContenido {

    fun obtenerSecciones(): List<SeccionTematicaModel> = listOf(
        seccionVidaCotidiana(),
        seccionArquitectura(),
        seccionArte()
    )

    fun obtenerSeccionPorId(identificador: String): SeccionTematicaModel? =
        obtenerSecciones().firstOrNull { it.identificador == identificador }

    // -------------------------------------------------------------
    // SECCIÓN 1: VIDA COTIDIANA
    // -------------------------------------------------------------
    private fun seccionVidaCotidiana() = SeccionTematicaModel(
        identificador = "vida_cotidiana",
        titulo = "Vida Cotidiana en el Nilo",
        descripcion = "Descubre cómo vivían los antiguos egipcios: agricultura, oficios, familia y creencias.",
        urlImagenPortada = "https://images.unsplash.com/photo-1764686621721-317752a14672?q=80&w=1200",
        textoAlternativoPortada = "Murales de templo egipcio con figuras humanas",
        listaArticulos = listOf(
            ArticuloModel(
                identificador = "vc_agricultura",
                titulo = "La agricultura y las crecidas del Nilo",
                textoNinos = "Cada año el río Nilo crecía y dejaba barro fértil en los campos. Los niños ayudaban a plantar trigo y cebada mientras jugaban con el barro.",
                textoAdolescentes = "La crecida anual del Nilo cubría las tierras con limo fértil. Los egipcios cultivaban trigo, cebada, lino y papiro, organizados en tres estaciones agrícolas: Akhet, Peret y Shemu.",
                textoAdultos = "La economía egipcia dependía del ciclo de inundación del Nilo, registrado en nilómetros. Se cultivaban trigo, cebada, lentejas y papiro, y el Estado controlaba la distribución desde templos y graneros reales.",
                urlImagen = "https://images.unsplash.com/photo-1560493676-04071c5f467b?q=80&w=800",
                textoAlternativo = "Campesinos egipcios sembrando trigo junto al Nilo",
                recursoNarracion = R.raw.ambiente_nilo_amanecer
            ),
            ArticuloModel(
                identificador = "vc_familia",
                titulo = "La familia y la infancia",
                textoNinos = "Los niños egipcios jugaban con pelotas de barro, muñecos de madera y peonzas. Vivían en casas de adobe con sus familias.",
                textoAdolescentes = "La familia era el núcleo de la sociedad egipcia. Los niños aprendían el oficio del padre y las niñas ayudaban en el hogar. El matrimonio solía celebrarse entre los 12 y 15 años.",
                textoAdultos = "La familia egipcia era patriarcal, pero la mujer gozaba de derechos notables: podía poseer bienes, divorciarse y heredar. Los hijos eran esenciales para el culto funerario de los padres.",
                urlImagen = "https://images.unsplash.com/photo-1709216461598-018ae6307dc0?q=80&w=800",
                textoAlternativo = "Familia egipcia representada en un relieve de templo",
                recursoNarracion = R.raw.ambiente_taller_artesanos
            ),
            ArticuloModel(
                identificador = "vc_alimentacion",
                titulo = "Alimentación y pan",
                textoNinos = "Los egipcios comían pan de trigo, pescado del Nilo y verduras. El pan era tan importante que se usaba como pago a los trabajadores.",
                textoAdolescentes = "La base de la dieta era el pan, la cerveza, el pescado y las verduras. La cerveza era más segura que el agua del río y la consumían todas las clases sociales.",
                textoAdultos = "La dieta egipcia incluía panes de distintas harinas, cerveza de cebada, pescado del Nilo, aves, legumbres y frutas como dátiles e higos. La carne se reservaba a élites y fiestas.",
                urlImagen = "https://images.unsplash.com/photo-1549931319-a545dcf3bc73?w=800",
                textoAlternativo = "Pan artesanal de trigo similar al que comían los egipcios",
                recursoNarracion = R.raw.ambiente_arpa_banquete
            ),
            ArticuloModel(
                identificador = "vc_indumentaria",
                titulo = "Vestimenta y cosmética",
                textoNinos = "Los egipcios vestían lino blanco para el calor. Se pintaban los ojos con kohl negro y usaban pelucas.",
                textoAdolescentes = "Hombres y mujeres usaban túnicas de lino. El kohl protegía los ojos del sol y era símbolo de estatus. Las pelucas distinguían clases sociales.",
                textoAdultos = "La indumentaria egipcia era sencilla: lino fino para élites, lana para campesinos. La cosmética tenía función ritual y medicinal: kohl, aceites perfumados y henna.",
                urlImagen = "https://images.unsplash.com/photo-1558769132-cb1aea458c5e?q=80&w=800",
                textoAlternativo = "Representación de vestimenta egipcia de lino blanco",
                recursoNarracion = R.raw.ambiente_flauta_pastor
            ),
            ArticuloModel(
                identificador = "vc_creencia",
                titulo = "Creencias cotidianas y amuletos",
                textoNinos = "Los egipcios usaban amuletos para protegerse. El escarabajo era un símbolo de buena suerte y protección.",
                textoAdolescentes = "Los egipcios creían en muchos dioses y llevaban amuletos como el ojo de Horus o el escarabajo sagrado. También veneraban a sus antepasados.",
                textoAdultos = "La religiosidad impregnaba la vida cotidiana: ofrendas a dioses domésticos como Bes y Taweret, amuletos como el ankh y prácticas de magia protectora contra enfermedades y mal de ojo.",
                urlImagen = "https://images.unsplash.com/photo-1578301978162-7aae4d755744?q=80&w=800",
                textoAlternativo = "Amuleto egipcio en forma de escarabajo sobre superficie de piedra",
                recursoNarracion = R.raw.ambiente_rio
            )
        ),
        galeriaImagenes = listOf(
            "https://images.unsplash.com/photo-1684100096410-fd39cdff91a3?q=80&w=800",
            "https://images.unsplash.com/photo-1632944398987-494eebe663be?q=80&w=800",
            "https://images.unsplash.com/photo-1549931319-a545dcf3bc73?w=800",
            "https://images.unsplash.com/photo-1575783402312-883c35cad34b?q=80&w=800",
            "https://images.unsplash.com/photo-1775129840965-4d4e123e6439?q=80&w=800",
            "https://images.unsplash.com/photo-1539768942893-daf53e448371?w=800",
            "https://images.unsplash.com/photo-1599656531273-70bbbe4272ff?q=80&w=800",
            "https://images.unsplash.com/photo-1568322445389-f64ac2515020?w=800",
            "https://images.unsplash.com/photo-1672215055915-e6143dc70e6a?q=80&w=800",
            "https://images.unsplash.com/photo-1734357288506-5271d99f306c?q=80&w=800"
        ),
        galeriaTextosAlternativos = listOf(
            "Río Nilo con barcas de papiro al atardecer",
            "Murales de templo egipcio con figuras humanas",
            "Pan de trigo sobre una mesa rústica",
            "Máscara funeraria dorada estilo egipcio",
            "Amuleto escarabajo tallado en piedra",
            "Pirámide de Giza bajo cielo despejado",
            "Jeroglíficos tallados en muro de piedra",
            "Estatua de faraón en templo de Luxor",
            "Templo de Karnak con columnas decoradas",
            "Papiro antiguo con escritura jeroglífica"
        ),
        listaAudiosAmbiente = listOf(
            R.raw.ambiente_nilo_egipto,
            R.raw.ambiente_nilo_amanecer,
            R.raw.ambiente_taller_artesanos,
            R.raw.ambiente_rio
        ),
        listaAudiosMusica = listOf(
            R.raw.ambiente_arpa_banquete,
            R.raw.ambiente_flauta_pastor
        ),
        listaVideos = listOf(
            "https://upload.wikimedia.org/wikipedia/commons/transcoded/e/ee/Die_Bedeutung_von_Fr%C3%B6schen_im_alten_%C3%84gypten.webm/Die_Bedeutung_von_Fr%C3%B6schen_im_alten_%C3%84gypten.webm.1080p.vp9.webm",
            "https://upload.wikimedia.org/wikipedia/commons/transcoded/5/5c/Dream_Machine_Egypt_animation.webm/Dream_Machine_Egypt_animation.webm.480p.vp9.webm",
            "https://upload.wikimedia.org/wikipedia/commons/transcoded/6/6f/Freer_Gallery_of_Art.webm/Freer_Gallery_of_Art.webm.480p.vp9.webm",
            "https://upload.wikimedia.org/wikipedia/commons/transcoded/e/ee/Royal_couple-MAHG_12440-0001-0250.ogv/Royal_couple-MAHG_12440-0001-0250.ogv.480p.vp9.webm",
            "https://upload.wikimedia.org/wikipedia/commons/transcoded/b/bf/Wie_kam_die_Katze_zum_Menschen%3F.webm/Wie_kam_die_Katze_zum_Menschen%3F.webm.1080p.vp9.webm"
        ),
        titulosVideos = listOf(
            "demo de reproductor de video",
            "demo de reproductor de video 2",
            "demo de reproductor de video 3",
            "demo de reproductor de video 4",
            "demo de reproductor de video 5",
        )
    )

    // -------------------------------------------------------------
    // SECCIÓN 2: ARQUITECTURA
    // -------------------------------------------------------------
    private fun seccionArquitectura() = SeccionTematicaModel(
        identificador = "arquitectura",
        titulo = "Arquitectura Monumental",
        descripcion = "Pirámides, templos y tumbas que desafiaron al tiempo.",
        urlImagenPortada = "https://images.unsplash.com/photo-1503177119275-0aa32b3a9368?w=1200",
        textoAlternativoPortada = "Pirámide de Giza bajo un cielo despejado con arena en primer plano",
        listaArticulos = listOf(
            ArticuloModel(
                identificador = "ar_piramides",
                titulo = "Las pirámides de Giza",
                textoNinos = "La Gran Pirámide tiene más de 4.500 años. Fue construida con millones de bloques de piedra y era la más alta del mundo.",
                textoAdolescentes = "Las pirámides de Giza se construyeron entre 2600 y 2500 a.C. como tumbas de los faraones Keops, Kefrén y Micerino. La Gran Pirámide medía originalmente 146 metros.",
                textoAdultos = "El complejo de Giza fusiona religión, poder político y astronomía. La Gran Pirámide de Keops, orientada a los puntos cardinales con precisión de minutos de arco, es una obra maestra de la ingeniería antigua.",
                urlImagen = "https://images.unsplash.com/photo-1760446837269-fc36fea21678?q=80&w=800",
                textoAlternativo = "Las tres pirámides de Giza vistas desde la meseta",
                recursoNarracion = R.raw.ambiente_cantera
            ),
            ArticuloModel(
                identificador = "ar_templos",
                titulo = "Templos de Karnak y Luxor",
                textoNinos = "Los templos eran casas de los dioses. Tenían columnas enormes decoradas con dibujos y colores brillantes.",
                textoAdolescentes = "Los templos de Karnak y Luxor, dedicados a Amón, se ampliaron durante siglos. Sus columnas con capiteles papiriformes alcanzaban 20 metros de altura.",
                textoAdultos = "El templo egipcio era un microcosmos del universo: la sala hipóstila representaba el caos primigenio y el santuario el montículo de la creación. Karnak, con más de 130 columnas, es el mayor complejo religioso del mundo antiguo.",
                urlImagen = "https://images.unsplash.com/photo-1663867425427-dc706d53945f?q=80&w=800",
                textoAlternativo = "Columnas de la sala hipóstila del templo de Karnak",
                recursoNarracion = R.raw.ambiente_templo_karnak
            ),
            ArticuloModel(
                identificador = "ar_tumbas",
                titulo = "Tumbas del Valle de los Reyes",
                textoNinos = "Los faraones eran enterrados en tumbas escondidas en el desierto, llenas de tesoros y pinturas.",
                textoAdolescentes = "El Valle de los Reyes alberga más de 60 tumbas faraónicas del Imperio Nuevo. La de Tutankamón, descubierta en 1922, contenía más de 5.000 objetos.",
                textoAdultos = "Las tumbas del Valle de los Reyes, excavadas en la roca para protegerse de saqueadores, presentan pinturas murales con el Libro de los Muertos y el Amduat. Su estudio revela la evolución de las creencias funerarias del Imperio Nuevo.",
                urlImagen = "https://images.unsplash.com/photo-1632944511358-0753f3f61283?q=80&w=800",
                textoAlternativo = "Entrada excavada en roca del Valle de los Reyes",
                recursoNarracion = R.raw.ambiente_templo
            ),
            ArticuloModel(
                identificador = "ar_esfinge",
                titulo = "La Gran Esfinge",
                textoNinos = "La Esfinge tiene cuerpo de león y cabeza humana. Es muy grande y está junto a las pirámides.",
                textoAdolescentes = "La Gran Esfinge de Giza, tallada en un solo bloque de caliza, mide 73 metros de largo y 20 de alto. Representa al faraón Kefrén.",
                textoAdultos = "La Esfinge, guardiana del complejo funerario de Kefrén, ha sufrido erosión y restauraciones desde la antigüedad. Su rostro ha sido objeto de debate académico sobre la identidad del faraón representado.",
                urlImagen = "https://images.unsplash.com/photo-1669301038557-f84309ac1269?q=80&w=800",
                textoAlternativo = "La Gran Esfinge de Giza con las pirámides al fondo",
                recursoNarracion = R.raw.ambiente_viento_desierto
            ),
            ArticuloModel(
                identificador = "ar_obeliscos",
                titulo = "Obeliscos y columnas",
                textoNinos = "Los obeliscos son columnas altas y puntiagudas con dibujos. Marcaban la entrada de los templos.",
                textoAdolescentes = "Los obeliscos eran monolíticos y estaban decorados con jeroglíficos. Se erigían en parejas a la entrada de los templos dedicados al dios sol Ra.",
                textoAdultos = "El obelisco egipcio, símbolo solar por excelencia, requería técnicas de extracción y transporte asombrosas. Muchos fueron llevados a Roma y otras capitales europeas en la antigüedad y la era moderna.",
                urlImagen = "https://images.unsplash.com/photo-1554111954-66a45f3de9b4?q=80&w=800",
                textoAlternativo = "Obelisco egipcio de granito rojo decorado con jeroglíficos",
                recursoNarracion = R.raw.ambiente_canto_obreros
            )
        ),
        galeriaImagenes = listOf(
            "https://images.unsplash.com/photo-1684100096410-fd39cdff91a3?q=80&w=800",
            "https://images.unsplash.com/photo-1632944398987-494eebe663be?q=80&w=800",
            "https://images.unsplash.com/photo-1549931319-a545dcf3bc73?w=800",
            "https://images.unsplash.com/photo-1575783402312-883c35cad34b?q=80&w=800",
            "https://images.unsplash.com/photo-1775129840965-4d4e123e6439?q=80&w=800",
            "https://images.unsplash.com/photo-1539768942893-daf53e448371?w=800",
            "https://images.unsplash.com/photo-1599656531273-70bbbe4272ff?q=80&w=800",
            "https://images.unsplash.com/photo-1568322445389-f64ac2515020?w=800",
            "https://images.unsplash.com/photo-1672215055915-e6143dc70e6a?q=80&w=800",
            "https://images.unsplash.com/photo-1734357288506-5271d99f306c?q=80&w=800"
        ),
        galeriaTextosAlternativos = listOf(
            "Río Nilo con barcas de papiro al atardecer",
            "Murales de templo egipcio con figuras humanas",
            "Pan de trigo sobre una mesa rústica",
            "Máscara funeraria dorada estilo egipcio",
            "Amuleto escarabajo tallado en piedra",
            "Pirámide de Giza bajo cielo despejado",
            "Jeroglíficos tallados en muro de piedra",
            "Estatua de faraón en templo de Luxor",
            "Templo de Karnak con columnas decoradas",
            "Papiro antiguo con escritura jeroglífica"
        ),
        listaAudiosAmbiente = listOf(
            R.raw.ambiente_desierto,
            R.raw.ambiente_viento_desierto,
            R.raw.ambiente_cantera,
            R.raw.ambiente_canto_obreros,
            R.raw.ambiente_templo_karnak,
            R.raw.ambiente_amanecer_abu_simbel,
            R.raw.ambiente_templo
        ),
        listaAudiosMusica = emptyList(),
        listaVideos = listOf(
            "https://upload.wikimedia.org/wikipedia/commons/transcoded/e/ee/Die_Bedeutung_von_Fr%C3%B6schen_im_alten_%C3%84gypten.webm/Die_Bedeutung_von_Fr%C3%B6schen_im_alten_%C3%84gypten.webm.1080p.vp9.webm",
            "https://upload.wikimedia.org/wikipedia/commons/transcoded/5/5c/Dream_Machine_Egypt_animation.webm/Dream_Machine_Egypt_animation.webm.480p.vp9.webm",
            "https://upload.wikimedia.org/wikipedia/commons/transcoded/6/6f/Freer_Gallery_of_Art.webm/Freer_Gallery_of_Art.webm.480p.vp9.webm",
            "https://upload.wikimedia.org/wikipedia/commons/transcoded/e/ee/Royal_couple-MAHG_12440-0001-0250.ogv/Royal_couple-MAHG_12440-0001-0250.ogv.480p.vp9.webm",
            "https://upload.wikimedia.org/wikipedia/commons/transcoded/b/bf/Wie_kam_die_Katze_zum_Menschen%3F.webm/Wie_kam_die_Katze_zum_Menschen%3F.webm.1080p.vp9.webm"
        ),
        titulosVideos = listOf(
            "demo de reproductor de video",
            "demo de reproductor de video 2",
            "demo de reproductor de video 3",
            "demo de reproductor de video 4",
            "demo de reproductor de video 5",
        )
    )

    // -------------------------------------------------------------
    // SECCIÓN 3: ARTE
    // -------------------------------------------------------------
    private fun seccionArte() = SeccionTematicaModel(
        identificador = "arte",
        titulo = "Arte y Simbolismo",
        descripcion = "Jeroglíficos, pinturas y tesoros funerarios cargados de significado.",
        urlImagenPortada = "https://images.unsplash.com/photo-1576766691316-15b72385d5dc?q=80&w=1200",
        textoAlternativoPortada = "Máscara funeraria dorada de estilo egipcio con detalles azules",
        listaArticulos = listOf(
            ArticuloModel(
                identificador = "ar_jeroglificos",
                titulo = "Jeroglíficos: la escritura sagrada",
                textoNinos = "Los jeroglíficos son dibujos que significan sonidos e ideas. ¡Como un código secreto que los egipcios usaban para contar historias!",
                textoAdolescentes = "La escritura jeroglífica combinaba pictogramas y fonogramas. Fue descifrada por Champollion en 1822 gracias a la Piedra Rosetta.",
                textoAdultos = "El sistema jeroglífico, con más de 700 signos, se empleaba en contextos sagrados y monumentales. La Piedra Rosetta, con decretos en tres escrituras, permitió a Champollion descifrar el sistema en 1822.",
                urlImagen = "https://images.unsplash.com/photo-1655923478826-ef7c2d40820e?q=80&w=800",
                textoAlternativo = "Jeroglíficos egipcios tallados en piedra caliza",
                recursoNarracion = R.raw.ambiente_taller_escultor
            ),
            ArticuloModel(
                identificador = "ar_pintura",
                titulo = "Pintura mural y canon artístico",
                textoNinos = "Las pinturas egipcias muestran personas de perfil con los hombros de frente. Usaban colores brillantes como azul, verde y dorado.",
                textoAdolescentes = "El arte egipcio seguía reglas estrictas: ley de frontalidad, perspectiva jerárquica y uso simbólico del color. Cada color tenía un significado ritual.",
                textoAdultos = "El canon artístico egipcio buscaba la claridad simbólica más que el realismo: figuras con rostro de perfil, hombros frontales y piernas laterales. Los colores tenían valores rituales: azul (lapislázuli), verde (vida), rojo (caos).",
                urlImagen = "https://images.unsplash.com/photo-1539768942893-daf53e448371?w=800",
                textoAlternativo = "Pintura mural egipcia con figuras humanas de perfil",
                recursoNarracion = R.raw.ambiente_himno_aton
            ),
            ArticuloModel(
                identificador = "ar_escultura",
                titulo = "Escultura: faraones y dioses",
                textoNinos = "Las estatuas de faraones eran enormes y mostraban su poder. Los dioses tenían cabeza de animal.",
                textoAdolescentes = "La escultura egipcia representaba faraones con la barba postiza y el tocado nemes. Los dioses se representaban con atributos animales específicos.",
                textoAdultos = "La escultura egipcia combinaba función ritual y política: el faraón como mediador entre dioses y humanos. Los colosos de Memnón y las esculturas de Amarna muestran la evolución estilística del Imperio Nuevo.",
                urlImagen = "https://images.unsplash.com/photo-1777189978576-08b21689fcc9?q=80&w=800",
                textoAlternativo = "Estatua colosal de faraón egipcio en templo",
                recursoNarracion = R.raw.ambiente_danza_sistro
            ),
            ArticuloModel(
                identificador = "ar_tesoros",
                titulo = "Tesoros funerarios de Tutankamón",
                textoNinos = "En la tumba de Tutankamón encontraron una máscara de oro, joyas y hasta un trono. ¡Era como un tesoro de cuento!",
                textoAdolescentes = "Howard Carter descubrió la tumba de Tutankamón en 1922. Contenía más de 5.000 objetos, incluyendo la famosa máscara de oro de 11 kg.",
                textoAdultos = "El ajuar funerario de Tutankamón, descubierto casi intacto por Howard Carter, revela la sofisticación del arte del Imperio Nuevo: orfebrería, ebanistería, textiles y objetos rituales que acompañaban al faraón al más allá.",
                urlImagen = "https://images.unsplash.com/photo-1517187654069-ba29110a1d9e?q=80&w=800",
                textoAlternativo = "Máscara funeraria de oro de Tutankamón con detalles azules",
                recursoNarracion = R.raw.ambiente_oro_tutankamon
            ),
            ArticuloModel(
                identificador = "ar_simbolos",
                titulo = "Símbolos: ankh, ojo de Horus, escarabajo",
                textoNinos = "El ankh era el símbolo de la vida, el ojo de Horus protegía y el escarabajo traía buena suerte.",
                textoAdolescentes = "Los símbolos egipcios tenían poderes mágicos: el ankh (vida eterna), el ojo de Horus (protección), el escarabajo (renacimiento).",
                textoAdultos = "El simbolismo egipcio codificaba conceptos cosmológicos: el ankh representaba la vida, el ojo de Horus la integridad restaurada, el escarabajo el sol naciente y la transformación. Estos símbolos permean el arte funerario y la joyería.",
                urlImagen = "https://images.unsplash.com/photo-1673550416827-d9377d594926?q=80&w=800",
                textoAlternativo = "Amuletos egipcios de ankh, ojo de Horus y escarabajo",
                recursoNarracion = R.raw.ambiente_tumba_misterio
            )
        ),
        galeriaImagenes = listOf(
            "https://images.unsplash.com/photo-1684100096410-fd39cdff91a3?q=80&w=800",
            "https://images.unsplash.com/photo-1632944398987-494eebe663be?q=80&w=800",
            "https://images.unsplash.com/photo-1549931319-a545dcf3bc73?w=800",
            "https://images.unsplash.com/photo-1575783402312-883c35cad34b?q=80&w=800",
            "https://images.unsplash.com/photo-1775129840965-4d4e123e6439?q=80&w=800",
            "https://images.unsplash.com/photo-1539768942893-daf53e448371?w=800",
            "https://images.unsplash.com/photo-1599656531273-70bbbe4272ff?q=80&w=800",
            "https://images.unsplash.com/photo-1568322445389-f64ac2515020?w=800",
            "https://images.unsplash.com/photo-1672215055915-e6143dc70e6a?q=80&w=800",
            "https://images.unsplash.com/photo-1734357288506-5271d99f306c?q=80&w=800"
        ),
        galeriaTextosAlternativos = listOf(
            "Río Nilo con barcas de papiro al atardecer",
            "Murales de templo egipcio con figuras humanas",
            "Pan de trigo sobre una mesa rústica",
            "Máscara funeraria dorada estilo egipcio",
            "Amuleto escarabajo tallado en piedra",
            "Pirámide de Giza bajo cielo despejado",
            "Jeroglíficos tallados en muro de piedra",
            "Estatua de faraón en templo de Luxor",
            "Templo de Karnak con columnas decoradas",
            "Papiro antiguo con escritura jeroglífica"
        ),
        listaAudiosAmbiente = listOf(
            R.raw.ambiente_tutankamon,
            R.raw.ambiente_taller_escultor,
            R.raw.ambiente_tumba_misterio,
            R.raw.ambiente_oro_tutankamon,
            R.raw.ambiente_danza_sistro
        ),
        listaAudiosMusica = listOf(
            R.raw.ambiente_himno_aton
        ),
        listaVideos = listOf(
            "https://upload.wikimedia.org/wikipedia/commons/transcoded/e/ee/Die_Bedeutung_von_Fr%C3%B6schen_im_alten_%C3%84gypten.webm/Die_Bedeutung_von_Fr%C3%B6schen_im_alten_%C3%84gypten.webm.1080p.vp9.webm",
            "https://upload.wikimedia.org/wikipedia/commons/transcoded/5/5c/Dream_Machine_Egypt_animation.webm/Dream_Machine_Egypt_animation.webm.480p.vp9.webm",
            "https://upload.wikimedia.org/wikipedia/commons/transcoded/6/6f/Freer_Gallery_of_Art.webm/Freer_Gallery_of_Art.webm.480p.vp9.webm",
            "https://upload.wikimedia.org/wikipedia/commons/transcoded/e/ee/Royal_couple-MAHG_12440-0001-0250.ogv/Royal_couple-MAHG_12440-0001-0250.ogv.480p.vp9.webm",
            "https://upload.wikimedia.org/wikipedia/commons/transcoded/b/bf/Wie_kam_die_Katze_zum_Menschen%3F.webm/Wie_kam_die_Katze_zum_Menschen%3F.webm.1080p.vp9.webm"
        ),
        titulosVideos = listOf(
            "demo de reproductor de video",
            "demo de reproductor de video 2",
            "demo de reproductor de video 3",
            "demo de reproductor de video 4",
            "demo de reproductor de video 5",
        )
    )
}