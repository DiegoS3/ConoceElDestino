package com.diego.conoceeldestino.service

import com.diego.conoceeldestino.dto.ProductDto
import com.diego.conoceeldestino.entity.Product
import java.util.*

interface ProductService {

    fun findAllProduct(): MutableIterable<Product>
    fun updateProduct(product: Product): Product?
    fun createProduct(product: Product): Product?
    fun findByName(name: String): Optional<Product>
    fun findByCategory(name: String): List<ProductDto>
    fun deleteProduct(name: String): Boolean

}