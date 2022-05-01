package com.diego.conoceeldestino.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class ApiError (
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    val timestamp: LocalDateTime? = null,
    val status: Int? = null,
    var error: String? = null
)