package com.diego.conoceeldestino.dto

data class HorarioResponseDTO(
    val id: Int? = null,
    val inviernoFechaInit: String? = null,
    val inviernoFechaEnd: String? = null,
    val inviernoHoraInit: String? = null,
    val inviernoHoraEnd: String? = null,
    val veranoFechaInit: String? = null,
    val veranoFechaEnd: String? = null,
    val veranoHoraInit: String? = null,
    val veranoHoraEnd: String? = null
)
