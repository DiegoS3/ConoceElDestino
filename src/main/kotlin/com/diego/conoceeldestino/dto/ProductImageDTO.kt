package com.diego.conoceeldestino.dto

import java.io.Serializable

data class ProductImageDTO(
    var id: Int? = null,
    var image: ByteArray? = null
): Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProductImageDTO

        if (id != other.id) return false
        if (image != null) {
            if (other.image == null) return false
            if (!image.contentEquals(other.image)) return false
        } else if (other.image != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (image?.contentHashCode() ?: 0)
        return result
    }
}
