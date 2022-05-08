package com.diego.conoceeldestino.dto

import java.io.Serializable
import java.math.BigDecimal

data class ProductDto(
    val id: Int? = null,
    val name: String? = null,
    val shortDescription: String? = null,
    val longDescription: String? = null,
    val included: String? = null,
    val notIncluded: String? = null,
    val price: BigDecimal? = null,
    val duration: Double? = null,
    val departure: String? = null,
    val arrival: String? = null,
    val distance: Int? = null,
    val place: String? = null
) : Serializable
