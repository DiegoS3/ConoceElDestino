package com.diego.conoceeldestino.service.impl

import com.diego.conoceeldestino.dto.ProductDto
import com.diego.conoceeldestino.entity.Product
import com.diego.conoceeldestino.error.ConoceElDestinoException
import com.diego.conoceeldestino.repository.ProductRepository
import com.diego.conoceeldestino.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductServiceImpl : ProductService {

    @Autowired
    private lateinit var productRepository: ProductRepository

    override fun findAllProduct(): MutableIterable<Product> {
        try {
            val productList = productRepository.findAll()
            productList.map {
                it.duration = it.duration?.div(60)
            }
            return productList
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

    override fun updateProduct(product: Product): Product? {
        try {
            return productRepository.findByName(product.name!!)
                .map {
                    product.category = it.category
                    return@map productRepository.save(product)
                }
                .orElseGet {
                    return@orElseGet productRepository.save(product)
                }
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

    override fun createProduct(product: Product): Product? {
        try {
            return productRepository.findByName(product.name!!).orElse(productRepository.save(product))
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

    override fun findByName(name: String): Optional<Product> {
        try {
            return productRepository.findByName(name)
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

    override fun findByCategory(name: String): List<ProductDto> {
        return try {
            productRepository.findByCategory(name).map { products ->
                val list = products.map {
                    ProductDto(
                        it.id,
                        it.name,
                        it.shortDescription,
                        it.longDescription,
                        it.included,
                        it.notIncluded,
                        it.price,
                        it.duration,
                        it.departure,
                        it.arrival,
                        it.distance,
                        it.place
                    )
                }
                return@map list
            }.orElseGet {
                throw ConoceElDestinoException()
            }
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

    override fun deleteProduct(name: String): Boolean {
        try {
            return findByName(name)
                .map {
                    productRepository.delete(it)
                    return@map true
                }.orElseGet {
                    return@orElseGet false
                }
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }
}