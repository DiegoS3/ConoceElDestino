package com.diego.conoceeldestino.service.impl

import com.diego.conoceeldestino.entity.Category
import com.diego.conoceeldestino.entity.Product
import com.diego.conoceeldestino.error.ConoceElDestinoException
import com.diego.conoceeldestino.repository.ProductRepository
import com.diego.conoceeldestino.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductServiceImpl: ProductService {

    @Autowired
    private lateinit var productRepository: ProductRepository

    override fun findAllServices(): MutableIterable<Product> {
        try {
            val serviceList = productRepository.findAll()
            serviceList.map {
                it.duration = it.duration?.div(60)
            }
            return serviceList
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

    override fun updateService(product: Product): Product? {
        try {
            return productRepository.findByName(product.name!!)
                .map {
                    it.name = category.name
                    it.image = category.image
                    it.longDescription = category.longDescription
                    it.shortDescription = category.shortDescription
                    return@map categoryRepository.save(category)
                }
                .orElseGet {
                    return@orElseGet categoryRepository.save(category)
                }
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

    override fun createService(product: Product): Product? {
        TODO("Not yet implemented")
    }

    override fun findByName(name: String): Optional<Product> {
        TODO("Not yet implemented")
    }

    override fun findByCategory(category: Category): MutableIterable<Product> {
        TODO("Not yet implemented")
    }

    override fun deleteService(name: String): Boolean {
        TODO("Not yet implemented")
    }
}