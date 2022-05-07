package com.diego.conoceeldestino.service

import com.diego.conoceeldestino.entity.Category
import com.diego.conoceeldestino.entity.Product
import java.util.*

interface ProductService {

    fun findAllServices(): MutableIterable<Product>
    fun updateService(product: Product): Product?
    fun createService(product: Product): Product?
    fun findServiceByName(name: String): Optional<Product>
    fun findServiceByCategory(category: Category): MutableIterable<Product>
    fun deleteService(name: String): Boolean

}