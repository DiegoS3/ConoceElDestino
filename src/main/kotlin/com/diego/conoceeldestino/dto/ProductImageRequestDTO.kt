package com.diego.conoceeldestino.dto

import java.io.Serializable

data class ProductImageRequestDTO(
    val image: ByteArray? = null,
    val service_id: Int? = null,
): Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProductImageRequestDTO

        if (image != null) {
            if (other.image == null) return false
            if (!image.contentEquals(other.image)) return false
        } else if (other.image != null) return false
        if (service_id != other.service_id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = image?.contentHashCode() ?: 0
        result = 31 * result + (service_id ?: 0)
        return result
    }


}
