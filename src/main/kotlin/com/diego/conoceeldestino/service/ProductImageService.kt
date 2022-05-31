package com.diego.conoceeldestino.service

import com.diego.conoceeldestino.dto.ProductImageDTO

interface ProductImageService {
    fun findByProduct(id: Int): List<ProductImageDTO>
}