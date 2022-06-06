package com.diego.conoceeldestino.dto

import com.diego.conoceeldestino.entity.Category
import com.diego.conoceeldestino.entity.Horario
import java.io.Serializable
import java.math.BigDecimal

data class ProductDto(
    val id: Int? = null,
    val name: String? = null,
    val shortDescription: String? = null,
    val longDescription: String? = null,
    val included: Array<String>? = null,
    val notIncluded: Array<String>? = null,
    val priceIndi: BigDecimal? = null,
    val priceGroup: BigDecimal? = null,
    val duration: Double? = null,
    val departure: String? = null,
    val arrival: String? = null,
    val distance: Int? = null,
    val place: String? = null,
    val category: String? = null,
    val horario: HorarioResponseDTO? = null,
    val images: MutableList<ProductImageDTO>? = null
) : Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProductDto

        if (id != other.id) return false
        if (name != other.name) return false
        if (shortDescription != other.shortDescription) return false
        if (longDescription != other.longDescription) return false
        if (!included.contentEquals(other.included)) return false
        if (!notIncluded.contentEquals(other.notIncluded)) return false
        if (priceIndi != other.priceIndi) return false
        if (priceGroup != other.priceGroup) return false
        if (duration != other.duration) return false
        if (departure != other.departure) return false
        if (arrival != other.arrival) return false
        if (distance != other.distance) return false
        if (place != other.place) return false
        if (images != other.images) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (shortDescription?.hashCode() ?: 0)
        result = 31 * result + (longDescription?.hashCode() ?: 0)
        result = 31 * result + included.contentHashCode()
        result = 31 * result + (notIncluded?.hashCode() ?: 0)
        result = 31 * result + (priceIndi?.hashCode() ?: 0)
        result = 31 * result + (priceGroup?.hashCode() ?: 0)
        result = 31 * result + (duration?.hashCode() ?: 0)
        result = 31 * result + (departure?.hashCode() ?: 0)
        result = 31 * result + (arrival?.hashCode() ?: 0)
        result = 31 * result + (distance ?: 0)
        result = 31 * result + (place?.hashCode() ?: 0)
        result = 31 * result + (images?.hashCode() ?: 0)
        return result
    }
}
