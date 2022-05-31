package com.diego.conoceeldestino.dto

import com.fasterxml.jackson.annotation.JsonFormat

data class HorarioRequestDTO(
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val inviernoFechaInit: String? = null,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val inviernoFechaEnd: String? = null,
    val inviernoHoraInit: String? = null,
    val inviernoHoraEnd: String? = null,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val veranoFechaInit: String? = null,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val veranoFechaEnd: String? = null,
    val veranoHoraInit: String? = null,
    val veranoHoraEnd: String? = null
)
