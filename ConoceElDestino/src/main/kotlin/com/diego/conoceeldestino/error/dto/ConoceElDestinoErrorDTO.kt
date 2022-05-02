package com.diego.conoceeldestino.error.dto

import com.diego.conoceeldestino.error.ConoceElDestinoException
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*


@JsonIgnoreProperties(ignoreUnknown = true)
data class ConoceElDestinoErrorDTO(
    /** The timestamp.  */
    var timestamp: Date? = null,

    /** The message.  */
    var message: String? = null,

    /** The type.  */
    var type: String? = null,

    /** The wrong code.  */
    var wrongCode: String? = null
) {
    constructor() : this(
        timestamp = Date(),
        type = "CONOCE_EL_DESTINO",
        message = "UNKNOWN",
        wrongCode = null
    )

    /**
     * Instantiates a new people plus error DTO.
     *
     * @param ppe the ppe
     */
    constructor(cede: ConoceElDestinoException) : this (Date(), cede.message, "CONOCE_EL_DESTINO", cede.getErrorCode())

}