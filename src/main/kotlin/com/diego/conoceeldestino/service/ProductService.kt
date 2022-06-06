package com.diego.conoceeldestino.service

import com.diego.conoceeldestino.dto.ProductDto
import com.diego.conoceeldestino.dto.ProductRequestDTO
import com.diego.conoceeldestino.entity.Product
import java.util.*

interface ProductService {

    fun findAllProduct(): List<ProductDto>
    fun updateProduct(product: ProductRequestDTO): Product?
    fun createProduct(product: ProductRequestDTO): Product?
    fun findByName(name: String): Optional<ProductDto>
    fun findByCategory(name: String): List<ProductDto>
    fun deleteProduct(name: String): Boolean

}