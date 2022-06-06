package com.diego.conoceeldestino.service

import com.diego.conoceeldestino.dto.ProductImageDTO
import com.diego.conoceeldestino.dto.ProductImageRequestDTO
import com.diego.conoceeldestino.entity.ProductImage

interface ProductImageService {
    fun findByProduct(id: Int): List<ProductImageDTO>
    fun createImage(productImageRequestDTO: ProductImageRequestDTO): ProductImage
    fun updateImage(productImageRequestDTO: ProductImageRequestDTO): ProductImage
    fun deleteImage(id: Int): Boolean
}